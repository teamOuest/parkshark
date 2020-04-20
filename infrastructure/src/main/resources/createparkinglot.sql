set schema 'parkshark';

create table parkinglot (
	id bigint not null,
	name text not null,
	category text,
	capacity bigint,
	fk_person_id bigint,
	streetname text,
	housenumber int,
	postcode int,
	city text,
	amount money,
	unit text,
	constraint pk_parkinglot primary key(id)
);
create sequence parkinglot_seq start with 1 increment by 1;