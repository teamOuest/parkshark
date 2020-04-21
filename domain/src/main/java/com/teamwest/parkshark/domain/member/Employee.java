package com.teamwest.parkshark.domain.member;

import javax.persistence.*;
import javax.validation.constraints.Email;
import static javax.persistence.GenerationType.SEQUENCE;


@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "EMPLOYEE_SEQ")
    @SequenceGenerator(sequenceName = "employee_id_seq", allocationSize = 1, name = "EMPLOYEE_SEQ")
    private int id;

    @Column(name = "name")
    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "countryCode", column = @Column(name = "countrycodemobile")),
            @AttributeOverride(name = "localNumber", column = @Column(name = "localnumbermobile"))
    })
    private PhoneNumber mobilePhoneNumber;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "countryCode", column = @Column(name = "countrycodelandline")),
            @AttributeOverride(name = "localNumber", column = @Column(name = "localnumberlandline"))
    })
    private PhoneNumber landlinePhoneNumber;

    @Column(name = "email")
    @Email
    private String email;

    @Embedded
    private Address address;

    public Employee() {

    }

    public Employee(String name, PhoneNumber mobilePhoneNumber, PhoneNumber landlinePhoneNumber, String email, Address adress) {
        this.name = name;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.landlinePhoneNumber = landlinePhoneNumber;
        this.email = email;
        this.address = adress;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PhoneNumber getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public PhoneNumber getLandlinePhoneNumber() {
        return landlinePhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

}
