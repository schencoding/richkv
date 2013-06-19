
set host=127.0.0.1
set port=9160
set script=C:/development/workspace-3.5.1jee/cassandra/script/initscript
#C:/development/workspace-3.5.1jee/cassandra/bin/cassandra

C:/development/workspace-3.5.1jee/cassandra/bin/cassandra-cli -h %host% -p %port% -f %script%
