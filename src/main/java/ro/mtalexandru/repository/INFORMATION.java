package ro.mtalexandru.repository;

/**
 * Created by malexandru on 8/22/2016.
 */
public class INFORMATION {

    /**
     * As it turned out Hibernate doesn't convert dates to GMT automatically, it just cuts off time if you use query.setDate(),
     * so if you pass "2009-01-16 12:13:14" it becomes "2009-01-16 00:00:00".

     To take time into consideration you need to use query.setTimestamp("date", dateObj) instead.
     *
     *
     *
     * ------------------------------------------------------------------------------------------------------------
         Additionally, for those blessed with MySQL >= 5.1.12:

     Execute SET GLOBAL log_output = 'TABLE';
     Execute SET GLOBAL general_log = 'ON';
     Take a look at the table mysql.general_log

     select * from mysql.general_log
     where user_host like '%curuser%' and argument like '%SELECT%'
     order by event_time desc ;


     If you prefer to output to a file:

     SET GLOBAL log_output = "FILE"; which is set by default.
     SET GLOBAL general_log_file = "/path/to/your/logfile.log";
     SET GLOBAL general_log = 'ON';
     I prefer this method because:

     you're not editing the my.cnf file and potentially permanently turning on logging
     you're not fishing around the filesystem looking for the query log - or even worse, distracted by the need for the perfect destination.  /var/log /var/data/log /opt /home/mysql_savior/var
     restarting the server leaves you where you started (log is off)


     ------------------------------------------------------------------------
     VM Option for tomcat: -XX:MaxPermSize=2128M

     Monitoring Hibernate Queries with P6Spy:
     http://jasalguero.com/ledld/development/monitoring-hibernate-queries/

     ------------------------------------------------------------------------
     Java, getting Date without time

     //method 1
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
     Date dateWithoutTime = sdf.parse(sdf.format(new Date()));

     //method 2
     Calendar cal = Calendar.getInstance();
     cal.set(Calendar.HOUR_OF_DAY, 0);
     cal.set(Calendar.MINUTE, 0);
     cal.set(Calendar.SECOND, 0);
     cal.set(Calendar.MILLISECOND, 0);
     dateWithoutTime = cal.getTime();
     * */
}
