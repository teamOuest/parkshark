create sequence parkshark.parkingspot_allocation_seq start with 1 increment by 1;


CREATE TABLE parkshark.parkingspot_allocation
(
    id integer NOT NULL DEFAULT nextval('parkshark.parkingspot_allocation_seq'::regclass),
    licenseplate text NOT NULL,
    parkinglot_id integer,
    starttime timestamp,
    endtimme timestamp,
    status boolean,
    member_id integer,
    PRIMARY KEY (id),
    FOREIGN KEY(member_id) references parkshark.member (id)

);