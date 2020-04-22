create sequence parkshark.parkinglot_seq start with 1 increment by 1;
create sequence parkshark.employee_id_seq start with 1 increment by 1;
create sequence parkshark.member_seq start with 1 increment by 1;

CREATE TABLE parkshark.employee
(
    id integer NOT NULL DEFAULT nextval('parkshark.employee_id_seq'::regclass),
    name character varying(25) COLLATE pg_catalog."default",
    countrycodemobile integer,
    localnumbermobile integer,
    countrycodelandline integer,
    localnumberlandline integer,
    email character varying(25) COLLATE pg_catalog."default",
    streetname character varying(25) COLLATE pg_catalog."default",
    housenumber character varying(25) COLLATE pg_catalog."default",
    postcode integer,
    city character varying(25) COLLATE pg_catalog."default"
);

CREATE TABLE parkshark.member
(
    id integer NOT NULL DEFAULT nextval('parkshark.member_seq'::regclass),
    name character varying(25) COLLATE pg_catalog."default",
    countrycodemobile integer,
    localnumbermobile integer,
    countrycodelandline integer,
    localnumberlandline integer,
    email character varying(25) COLLATE pg_catalog."default",
    streetname character varying(25) COLLATE pg_catalog."default",
    housenumber integer,
    licenseplate character varying(25) COLLATE pg_catalog."default",
    registrationdate date,
    postcode integer,
    city character varying COLLATE pg_catalog."default",
    CONSTRAINT member_pkey PRIMARY KEY (id)
);

CREATE TABLE parkshark.parkinglot
(
    id bigint NOT NULL DEFAULT nextval('parkshark.parkinglot_seq'::regclass),
    name text COLLATE pg_catalog."default" NOT NULL,
    capacity bigint,
    fk_person_id bigint,
    streetname text COLLATE pg_catalog."default",
    housenumber integer,
    postcode integer,
    city text COLLATE pg_catalog."default",
    unit text COLLATE pg_catalog."default",
    amount double precision,
    category text COLLATE pg_catalog."default",
    CONSTRAINT pk_parkinglot PRIMARY KEY (id)
);



CREATE TABLE parkshark.postcode
(
    postcodevalue integer NOT NULL,
    city character varying COLLATE pg_catalog."default",
    CONSTRAINT postcode_pk PRIMARY KEY (postcodevalue)
);
