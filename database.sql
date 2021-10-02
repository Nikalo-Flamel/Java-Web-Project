create table RegisteredUser (
	RegisteredUserId int NOT NULL AUTO_INCREMENT,
    User_name varchar(30),
    Name varchar(40),
    Password varchar(30),
    Email varchar (40),
    Mobile varchar(12),
    
    CONSTRAINT PK_RegisteredUser PRIMARY KEY(RegisteredUserId)
);

insert into RegisteredUser value (0, 'kamal', 'kamal', 'kamal123', 'kamal@gmail.com', '0771234567');
insert into RegisteredUser value (0, 'nimal', 'Nimal', 'nimal123', 'nimal@gmail.com', '0771234567');