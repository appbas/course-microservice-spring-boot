insert into user_details (id, birth_date, name) values (10001, current_date(), 'Bruno');
insert into user_details (id, birth_date, name) values (10002, current_date(), 'Augusto');
insert into user_details (id, birth_date, name) values (10003, current_date(), 'Silva');

insert into post (id, description, user_id) values (10001, 'I want to learn AWS', 10001); 
insert into post (id, description, user_id) values (20001, 'I want to learn DevOps', 10002); 
insert into post (id, description, user_id) values (30001, 'I want to learn GCP', 10003); 