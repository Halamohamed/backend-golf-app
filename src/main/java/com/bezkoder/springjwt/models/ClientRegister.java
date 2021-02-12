package com.bezkoder.springjwt.models;

import org.hibernate.type.BlobType;
import org.springframework.http.MediaType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Blob;

@Entity
//@Table(name = "clientregister")
public class ClientRegister {

    @Id
    private String id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String golfId;

    private String image;

    private String phone;
    @NotBlank
    private String memberType;

    private String handicap;

    private String competitionHandicap;

    public ClientRegister(String id,String firstName,String lastName, String golfId,  String memberType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.golfId = golfId;
        this.memberType = memberType;

    }

    public ClientRegister() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGolfId() {
        return golfId;
    }

    public void setGolfId(String golfId) {
        this.golfId = golfId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getHandicap() {
        return handicap;
    }

    public void setHandicap(String handicap) {
        this.handicap = handicap;
    }

    public String getCompetitionHandicap() {
        return competitionHandicap;
    }

    public void setCompetitionHandicap(String competitionHandicap) {
        this.competitionHandicap = competitionHandicap;
    }
}
