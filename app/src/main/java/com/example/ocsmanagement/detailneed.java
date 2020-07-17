package com.example.ocsmanagement;

public class detailneed {
    String organisationID, studentID, teacherID, managementID, appSettingID;
    public detailneed(String organisationID, String studentID, String teacherID, String managementID, String appSettingID) {
        OrganisationID = organisationID;
        StudentID = studentID;
        TeacherID = teacherID;
        ManagementID = managementID;
        AppSettingID = appSettingID;
    }

    public detailneed(String organisationName, String organisationID, String studentID, String teacherID, String managementID, String appSettingID) {

    }

    public String getOrganisationID() {
        return OrganisationID;
    }

    public void setOrganisationID(String organisationID) {
        OrganisationID = organisationID;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(String teacherID) {
        TeacherID = teacherID;
    }

    public String getManagementID() {
        return ManagementID;
    }

    public void setManagementID(String managementID) {
        ManagementID = managementID;
    }

    public String getAppSettingID() {
        return AppSettingID;
    }

    public void setAppSettingID(String appSettingID) {
        AppSettingID = appSettingID;
    }

    private String OrganisationID,StudentID,TeacherID,ManagementID,AppSettingID;
}
