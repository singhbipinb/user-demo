package com.bipin.physicswallahdemo.Models;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class UserModel {


    @SerializedName("id")
    int ID;

    @SerializedName("name")
    String Name;

    @SerializedName("subjects")
    String Subjects[];

    @SerializedName("qualification")
    String Qualification[];

    @SerializedName("profileImage")
    String profileImage;


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String[] getSubjects() {
        return Subjects;
    }

    public void setSubjects(String[] subjects) {
        Subjects = subjects;
    }

    public String[] getQualification() {
        return Qualification;
    }

    public void setQualification(String[] qualification) {
        Qualification = qualification;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

//    public String subjectToString(){
//        return
//    }

    @Override
    public String toString() {
        return "UserModel{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Subjects=" + Arrays.toString(Subjects) +
                ", Qualification=" + Arrays.toString(Qualification) +
                ", profileImage='" + profileImage + '\'' +
                '}';
    }
}
