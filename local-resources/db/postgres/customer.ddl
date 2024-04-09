CREATE SCHEMA customer;

create table customer.contact_info (
    opt_in_ind boolean default false,
    create_ts timestamp(6),
    phone_number varchar(255),
    primary key (phone_number)
);
