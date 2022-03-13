create table users (
	id int auto_increment,
	username varchar(255) not null,
	vacancy_id int not null,
	primary key(id),
	unique(username)
);

create table vacancies (
	id int auto_increment,
	name varchar(255) not null,
	primary key(id)
);

create table files (
	id int auto_increment,
	path varchar(255) not null,
	user_id int not null,
	primary key(id),
	foreign key(user_id) references users(id)
);

create table questions (
	id int auto_increment,
	vacancy_id int not null,
	data varchar(1023) not null,
	primary key(id),
	foreign key(vacancy_id) references vacancies(id)
);