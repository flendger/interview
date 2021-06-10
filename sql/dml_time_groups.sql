select case
           when ms.start_time between '09:00' and '15:00'
               then '09 - 15'
           when ms.start_time between '15:00' and '18:00'
               then '15 - 18'
           when ms.start_time between '18:00' and '21:00'
               then '18 - 21'
           when ms.start_time between '21:00' and '00:00'
               then '21 - 00'
           end       as time_group,
       count(t.id)   as visitors,
       sum(ms.price) as sum
from tickets t,
     movie_sessions ms
where t.session_id = ms.id
group by time_group
