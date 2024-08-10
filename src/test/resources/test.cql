CREATE KEYSPACE notesapi WITH replication={'class' : 'SimpleStrategy', 'replication_factor':1};
use notesapi;
create table HealthCheck(id Text, status Text,primary key (id));
insert into HealthCheck(id,status) values('Healthy','true');