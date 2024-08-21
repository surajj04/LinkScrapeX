package org.bytetech.LinkScrapeX.scraping;

import java.util.Arrays;

public class KeyWords {
    private String[] jobTitleKeywords = {
            "Developer", "Engineer", "Manager", "Consultant", "Analyst", "Director", "Specialist",
            "Coordinator", "Administrator", "Technician", "Executive", "Officer", "Lead",
            "Architect", "Designer", "Supervisor", "Trainer", "Instructor", "Strategist",
            "Advisor", "Scientist", "Planner", "Advisor", "Assistant", "Associate",
            "Controller", "Consultant", "Coordinator", "Creator", "Developer", "Engineer",
            "Lead", "Manager", "Mentor", "Officer", "Partner", "Planner", "Practitioner",
            "Producer", "Project", "Representative", "Scientist", "Specialist", "Supervisor",
            "Technician", "Trainer", "Strategist", "VP", "Engineer","Developer",
            "Head", "Chief", "President", "Founder", "Owner", "Partner", "Principal",
            "Researcher", "Programmer", "Strategist", "Consultant", "Product Manager",
            "Business Analyst", "Marketing Manager", "Sales Manager", "Customer Success Manager",
            "Operations Manager", "Product Owner", "UI/UX Designer", "Data Scientist",
            "Data Analyst", "Quality Assurance", "Product Specialist", "Content Creator",
            "Growth Hacker", "Social Media Manager", "Digital Marketer", "Content Strategist",
            "E-commerce Manager", "Finance Manager", "HR Manager", "Recruiter", "Training Manager",
            "Compliance Officer", "Legal Advisor", "IT Manager", "Cybersecurity Analyst",
            "Software Engineer", "Systems Analyst", "Cloud Engineer", "Network Engineer",
            "Business Development Manager", "Account Manager", "Project Coordinator",
            "Technical Lead", "Operations Director", "Program Manager"
    };

    public String[] getJobTitleKeywords() {
        return jobTitleKeywords;
    }

    public boolean isJobTitleKeyword(String keyword) {
        return Arrays.asList(jobTitleKeywords).contains(keyword);
    }

    @Override
    public String toString() {
        return "KeyWords{" +
                "jobTitleKeywords=" + Arrays.toString(jobTitleKeywords) +
                '}';
    }
}
