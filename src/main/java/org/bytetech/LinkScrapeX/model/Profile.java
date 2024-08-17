package org.bytetech.LinkScrapeX.model;


import java.util.List;

public class Profile {
    private int id;
    private String name; //
    private String contactInfo;  //
    private String email;  //
    private String headline;
    private String about;
    private String website;
    private String profileLink;

    //    Current Position:
    private String jobTitle;
    private String companyName;
    private String location;
    private String startDate;
    private String endDate;
    private String responsibilities;

    //    Experience
    private String previousPositions;
    private String previousJobTitle;
    private String previousCompanyNames;
    private String previousLocations;
    private String startAndEndDates;
    private String previousResponsibilities;

    //    Education
    private String degrees;
    private String institutions;
    private String datesAttended;
    private String coursework;

    //    Skills
    private List<String> skills;

    //    Certifications
    private List<String> certifications;
    private List<String> awards;

    //    Projects
    private String projectName;
    private String ProjectDescription;
    private String technologiesUsed;
    private String Date;


    public Profile() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileLink() {
        return profileLink;
    }

    public void setProfileLink(String profileLink) {
        this.profileLink = profileLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public String getPreviousPositions() {
        return previousPositions;
    }

    public void setPreviousPositions(String previousPositions) {
        this.previousPositions = previousPositions;
    }

    public String getPreviousJobTitle() {
        return previousJobTitle;
    }

    public void setPreviousJobTitle(String previousJobTitle) {
        this.previousJobTitle = previousJobTitle;
    }

    public String getPreviousCompanyNames() {
        return previousCompanyNames;
    }

    public void setPreviousCompanyNames(String previousCompanyNames) {
        this.previousCompanyNames = previousCompanyNames;
    }

    public String getPreviousLocations() {
        return previousLocations;
    }

    public void setPreviousLocations(String previousLocations) {
        this.previousLocations = previousLocations;
    }

    public String getStartAndEndDates() {
        return startAndEndDates;
    }

    public void setStartAndEndDates(String startAndEndDates) {
        this.startAndEndDates = startAndEndDates;
    }

    public String getPreviousResponsibilities() {
        return previousResponsibilities;
    }

    public void setPreviousResponsibilities(String previousResponsibilities) {
        this.previousResponsibilities = previousResponsibilities;
    }

    public String getDegrees() {
        return degrees;
    }

    public void setDegrees(String degrees) {
        this.degrees = degrees;
    }

    public String getInstitutions() {
        return institutions;
    }

    public void setInstitutions(String institutions) {
        this.institutions = institutions;
    }

    public String getDatesAttended() {
        return datesAttended;
    }

    public void setDatesAttended(String datesAttended) {
        this.datesAttended = datesAttended;
    }

    public String getCoursework() {
        return coursework;
    }

    public void setCoursework(String coursework) {
        this.coursework = coursework;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<String> certifications) {
        this.certifications = certifications;
    }

    public List<String> getAwards() {
        return awards;
    }

    public void setAwards(List<String> awards) {
        this.awards = awards;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return ProjectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        ProjectDescription = projectDescription;
    }

    public String getTechnologiesUsed() {
        return technologiesUsed;
    }

    public void setTechnologiesUsed(String technologiesUsed) {
        this.technologiesUsed = technologiesUsed;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }


    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", email='" + email + '\'' +
                ", headline='" + headline + '\'' +
                ", about='" + about + '\'' +
                ", website='" + website + '\'' +
                ", profileLink='" + profileLink + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", companyName='" + companyName + '\'' +
                ", location='" + location + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", responsibilities='" + responsibilities + '\'' +
                ", previousPositions='" + previousPositions + '\'' +
                ", previousJobTitle='" + previousJobTitle + '\'' +
                ", previousCompanyNames='" + previousCompanyNames + '\'' +
                ", previousLocations='" + previousLocations + '\'' +
                ", startAndEndDates='" + startAndEndDates + '\'' +
                ", previousResponsibilities='" + previousResponsibilities + '\'' +
                ", degrees='" + degrees + '\'' +
                ", institutions='" + institutions + '\'' +
                ", datesAttended='" + datesAttended + '\'' +
                ", coursework='" + coursework + '\'' +
                ", skills=" + skills +
                ", certifications=" + certifications +
                ", awards=" + awards +
                ", projectName='" + projectName + '\'' +
                ", ProjectDescription='" + ProjectDescription + '\'' +
                ", technologiesUsed='" + technologiesUsed + '\'' +
                ", Date='" + Date + '\'' +
                '}';
    }
}
