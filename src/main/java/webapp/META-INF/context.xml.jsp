<Context>

    <Resource name="jdbc/DatabaseVeloce" auth="Container" type="javax.sql.DataSource"
              maxTotal="100" maxIdle="30" maxWaitMillis="10000"
              username="root" password="" driverClassName="com.mysql.cj.jdbc.Driver"
              url="jdbc:mysql://localhost:8080/velocerentals"></Resource>

</Context>