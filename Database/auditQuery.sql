select * from mysql.general_log
where user_host like '%curuser%'
order by event_time desc ;