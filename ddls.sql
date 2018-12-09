
CREATE TABLE role(role_id int UNIQUE , role_name varchar(20) NOT NULL UNIQUE, PRIMARY KEY(role_id , role_name) );

insert into role values (1, 'Donator')

insert into role values (2, 'Doctor')

insert into role values (3, 'Operator Transfuzii')

insert into role values (4, 'Administrator')



----postgres/admin
-- psql -U postgres blood (database)
--postgres/public IJ


CREATE TABLE users (user_id serial PRIMARY KEY , Name varchar(30) , email varchar(30) , location varchar(30) , Age INT NOT NULL , Weight_In_Kg INT NOT NULL, Pulse INT ,
Tension INT , Diseases INT , Gender varchar(10), Under_Treatment INT);

insert into users values('Mocanuu Madalin', 'mocanumadalin188@yahoo.com', 'Bucuresti' , 22, 55, 80, 100, 0, 'Male', 0, 4 , 'Administrator')

----

CREATE TABLE role_mapping (user_id INT references users(user_id)   , role_id INT references role(role_id))


insert into role_mapping values (1, 4)

select a.role_name from role a inner join role_mapping b on a.role_id = b.role_id inner join users c on c.user_id = b.user_id


----

CREATE TABLE donations_history (donation_id serial UNIQUE, user_id int references users(user_id), donation_date date, donation_result varchar(20) , 
comments varchar(20) , beneficiary varchar(20), PRIMARY KEY(donation_id, user_id) )


----

 
CREATE TABLE donation_requests (request_id serial UNIQUE, RH varchar(10), 
blood_type varchar(10), reason_to_request varchar(20), location varchar(20), hospital varchar(30), PRIMARY KEY(request_id))




