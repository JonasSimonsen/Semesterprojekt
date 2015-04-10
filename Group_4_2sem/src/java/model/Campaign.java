/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Sander
 */
public class Campaign {
    
    int planNumber;
    int partnerNumber;
    String country;
    String description;
    String audience;
    String currency;
    double cost;
    int mdfBudget;
    String status;
    String quarter;
    String startDate;
    String endDate;
    String objective;
    String poeRequirement;
    


    public Campaign(int planNumber, int partnerNumber, String country, String description, String audience, String currency, double cost, int mdfBudget, String status, String quarter, String startDate, String endDate, String objective, String poeRequirement) {

        this.planNumber = planNumber;
        this.partnerNumber = partnerNumber;
        this.country = country;
        this.description = description;
        this.audience = audience;
        this.currency = currency;
        this.cost = cost;
        this.mdfBudget = mdfBudget;
        this.status = status;
        this.quarter = quarter;
        this.startDate = startDate;
        this.endDate = endDate;
        this.objective = objective;
        this.poeRequirement = poeRequirement;
    }

    public int getPlanNumber() {
        return planNumber;
    }

    public void setPlanNumber(int planNumber) {
        this.planNumber = planNumber;
    }

    public int getPartnerNumber() {
        return partnerNumber;
    }

    public void setPartnerNumber(int partnerNumber) {
        this.partnerNumber = partnerNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getMdfBudget() {
        return mdfBudget;
    }

    public void setMdfBudget(int mdfBudget) {
        this.mdfBudget = mdfBudget;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
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

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getPoeRequirement() {
        return poeRequirement;
    }

    public void setPoeRequirement(String poeRequirement) {
        this.poeRequirement = poeRequirement;
    }
    
    
}
