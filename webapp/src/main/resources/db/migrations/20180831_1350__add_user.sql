create table uzer  (
  id bigserial primary key,
  user_name varchar(80) not null unique,
  password varchar(100) not null,
  role varchar(100) not null
);

insert into uzer (user_name, password, role) VALUES ('fu','fu', 'ADMIN');
