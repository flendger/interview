select ms.id,
       ms.title,
       ms.minutes,
       ms.start_time,
       ms.end_time,
       ms.price,
       ms_break.id,
       m_break.title,
       d_break.minutes,
       ms_break.start_time,
       addtime(ms_break.start_time, SEC_TO_TIME(d_break.minutes * 60)) as break_end_time
from (select ms1.*,
             MIN(ms2.start_time)                   as next_start,
             (time_to_sec(MIN(ms2.start_time))
                 - time_to_sec(ms1.end_time)) / 60 as break
      from (select ms1.*,
                   m1.title,
                   d1.minutes,
                   addtime(ms1.start_time, SEC_TO_TIME(d1.minutes * 60)) as end_time
            from movie_sessions ms1,
                 movies m1,
                 durations d1
            where ms1.movie_id = m1.id
              and m1.duration_id = d1.id) ms1
               left join movie_sessions ms2
                         on ms2.start_time > ms1.start_time
      where ms2.start_time is not null
      group by ms1.id) ms,
     movie_sessions ms_break,
     movies m_break,
     durations d_break
where ms.next_start = ms_break.start_time
  and m_break.id = ms_break.movie_id
  and d_break.id = m_break.id
and ms.break >= 30;
