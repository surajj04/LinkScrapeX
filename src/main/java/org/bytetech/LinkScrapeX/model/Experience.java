package org.bytetech.LinkScrapeX.model;

import java.util.Objects;

public class Experience {

    private String jobTitle;
    private String companyName;
    private String employmentDuration;
    private String totalDuration;
    private String companyUrl;

    // Getters and setters


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

    public String getEmploymentDuration() {
        return employmentDuration;
    }

    public void setEmploymentDuration(String employmentDuration) {
        this.employmentDuration = employmentDuration;
    }

    public String getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(String totalDuration) {
        this.totalDuration = totalDuration;
    }

    public String getCompanyUrl() {
        return companyUrl;
    }

    public void setCompanyUrl(String companyUrl) {
        this.companyUrl = companyUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Experience that = (Experience) o;
        return Objects.equals(jobTitle, that.jobTitle) &&
                Objects.equals(companyName, that.companyName) &&
                Objects.equals(employmentDuration, that.employmentDuration) &&
                Objects.equals(totalDuration, that.totalDuration) &&
                Objects.equals(companyUrl, that.companyUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobTitle, companyName, employmentDuration, totalDuration, companyUrl);
    }

    @Override
    public String toString() {
        return "Experience{" +
                "jobTitle='" + jobTitle + '\'' +
                ", companyName='" + companyName + '\'' +
                ", employmentDuration='" + employmentDuration + '\'' +
                ", totalDuration='" + totalDuration + '\'' +
                ", companyUrl='" + companyUrl + '\'' +
                '}';
    }
}
