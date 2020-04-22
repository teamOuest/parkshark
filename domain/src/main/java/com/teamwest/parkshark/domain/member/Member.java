package com.teamwest.parkshark.domain.member;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="member")
public class Member{

    @Id
    @Column(name="id")
    @SequenceGenerator(allocationSize = 1, name = "MEMBER_SEQ", sequenceName="member_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ")
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

    @Column(name="licenseplate")
    private String licensePlate;
    @Column(name="registrationdate")
    private LocalDate registrationDate;

    @Enumerated(EnumType.STRING)
    @Column(name="membershiplevel")
    private MembershipLevel membershipLevel;

    public Member(){}

    public Member(String name, PhoneNumber mobilePhoneNumber, PhoneNumber landlinePhoneNumber, String email, Address address, String licensePlate, LocalDate registrationDate, MembershipLevel membershipLevel) {
        this.id = id;
        this.name = name;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.landlinePhoneNumber = landlinePhoneNumber;
        this.email = email;
        this.address = address;
        this.licensePlate = licensePlate;
        this.registrationDate = registrationDate;
        this.membershipLevel = membershipLevel;
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

    public String getLicensePlate() {
        return licensePlate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public MembershipLevel getMembershipLevel() {
        return membershipLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(name, member.name) &&
                Objects.equals(mobilePhoneNumber, member.mobilePhoneNumber) &&
                Objects.equals(landlinePhoneNumber, member.landlinePhoneNumber) &&
                Objects.equals(email, member.email) &&
                Objects.equals(address, member.address) &&
                Objects.equals(licensePlate, member.licensePlate) &&
                Objects.equals(registrationDate, member.registrationDate) &&
                Objects.equals(membershipLevel, member.membershipLevel);

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mobilePhoneNumber, landlinePhoneNumber, email, address, licensePlate, registrationDate, membershipLevel);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobilePhoneNumber=" + mobilePhoneNumber +
                ", landlinePhoneNumber=" + landlinePhoneNumber +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", licensePlate='" + licensePlate + '\'' +
                ", registrationDate=" + registrationDate +
                ", membershipLevel=" + membershipLevel +
                '}';
    }
}
