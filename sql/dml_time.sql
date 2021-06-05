select ms.id,
       m.title,
       d.minutes,
       ms.start_time,
       addtime(ms.start_time, SEC_TO_TIME(d.minutes * 60)) as end_time,
       ms.next_start,
       ms.price,
       ms_problem.id,
       m2.title,
       d2.minutes,
       ms_problem.start_time
from (select ms1.id,
             ms1.movie_id,
             ms1.start_time,
             ms1.price,
             min(ms2.start_time) as next_start
      from movie_sessions ms1
               left join movie_sessions ms2
                         on ms1.id <> ms2.id
                             and ms1.start_time <= ms2.start_time
      where ms2.id is not null
      group by ms1.id) ms,
     movies m,
     durations d,
     movie_sessions ms_problem,
     movies m2,
     durations d2
where m.id = ms.movie_id
  and m.duration_id = d.id
  and ms.next_start = ms_problem.start_time
  and ms_problem.movie_id = m2.id
  and m2.duration_id = d2.id
  and addtime(ms.start_time, SEC_TO_TIME(d.minutes * 60)) > ms.next_start;