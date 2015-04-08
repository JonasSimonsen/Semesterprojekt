

package control;

import entity.Campaign;
import interfaces.interface_campaign;


public class control_campaign implements interface_campaign{

    @Override
    public void submitCampaign(int planNumber, int partnerNumber, String country, String description, String audience, String currency, int cost, int mdfBudget, String status, String quarter, String startDate, String endDate, String objective, String poeRequirement) {
        Campaign camp = new Campaign(planNumber, partnerNumber, country, description, audience, currency, cost, mdfBudget, status, quarter, startDate, endDate, objective, poeRequirement);
    }

}
