select sales.title,
       sales.visitors,
       sales.sesions as av_visitors,
       sales.sum
from (select m.title,
             count(t.id)   as visitors,
             count(t.id)/count(distinct t.session_id) as sesions,
             sum(ms.price) as sum
      from tickets t,
           movie_sessions ms,
           movies m
      where t.session_id = ms.id
        and ms.movie_id = m.id
      group by m.title
      order by sum desc) sales
union
select 'ИТОГО',
       count(t.id)   as visitors,
       count(t.id)/count(distinct t.session_id),
       sum(ms.price) as sum
from tickets t,
     movie_sessions ms,
     movies m
where t.session_id = ms.id
  and ms.movie_id = m.id
group by 'ИТОГО'