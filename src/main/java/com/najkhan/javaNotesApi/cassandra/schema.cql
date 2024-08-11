CREATE KEYSPACE IF NOT EXISTS notesapi WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };
use notesapi;
CREATE table IF NOT EXISTS HealthCheck(id Text, status Text,primary key (id));
insert into HealthCheck(id,status) values('Healthy','Healthy');

CREATE table IF NOT EXISTS Users(id int, fullName Text, password Text, email Text, primary key(email));
CREATE table IF NOT EXISTS Notes(email Text, title Text, note Text, primary key(email,title));