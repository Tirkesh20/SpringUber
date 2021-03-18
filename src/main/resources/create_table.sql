create table account(
                        id bigserial not null PRIMARY KEY ,
                        first_name varchar(50) not null,
                        last_name varchar(50) not null,
                        username varchar (50) not null,
                        email varchar (20) not null ,
                        password varchar (50) not null,
                        user_type varchar (50) not null,
                        PRIMARY KEY (id)
);
create table location(
                         id bigserial not null PRIMARY KEY ,
                         lat decimal not null ,
                         lng decimal not null,
                         req_status varchar (50)not null,
                         place varchar(50) not null ,
                         account_id bigint,
                         PRIMARY KEY (id),
                         FOREIGN KEY (account_id) REFERENCES account(id)
);




create table "order" (
                         id bigserial not null primary key ,
                         client_id bigint not null,
                         taxi_id bigint,
                         from_id bigint not null,
                         to_id bigint not null,
                         status varchar(50),
                         order_date timestamp without time zone,
                         PRIMARY KEY (id),
                         FOREIGN KEY (client_id) REFERENCES account(id) ON UPDATE CASCADE,
                         FOREIGN KEY (taxi_id) REFERENCES account(id) ON UPDATE CASCADE,
                         FOREIGN KEY (from_id) REFERENCES location(id) ON UPDATE CASCADE,
                         FOREIGN KEY (to_id) REFERENCES location(id) ON UPDATE CASCADE
);


create table transaction(
                            id bigserial not null primary key ,
                            order_id bigint not null,
                            status varchar(20),
                            pay_date timestamp without time zone,
                            PRIMARY KEY(id),
                            FOREIGN KEY (order_id) REFERENCES "order"(id) ON UPDATE CASCADE
);