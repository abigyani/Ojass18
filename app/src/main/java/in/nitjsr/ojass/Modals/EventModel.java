package in.nitjsr.ojass.Modals;

import java.util.ArrayList;

/**
 * Created by Aditya on 02-02-2017.
 */

public class EventModel {

    String about;
    String branch;
    String details;
    String name;



    Long prize1;
    Long prize2;
    Long prize3;
    Long prizeT;
    ArrayList<CoordinatorsModel> coordinatorsModelArrayList=new ArrayList<>();
    ArrayList<RulesModel> rulesModels=new ArrayList<>();

    public EventModel(String about, String branch, String details, String name, Long prize1, Long prize2, Long prize3, Long prizeT, ArrayList<CoordinatorsModel> coordinatorsModelArrayList, ArrayList<RulesModel> rulesModels) {
        this.about=about;
        this.name = name;
        this.details=details;
        this.branch=branch;
        this.prize1=prize1;
        this.prize2=prize2;
        this.prize3=prize3;
        this.prizeT=prizeT;
        this.coordinatorsModelArrayList=coordinatorsModelArrayList;
        this.rulesModels=rulesModels;
    }
    public EventModel()
    {

    }

    public Long getPrize2() {
        return prize2;
    }

    public String getAbout() {
        return about;
    }

    public String getBranch() {
        return branch;
    }

    public String getDetails() {
        return details;
    }

    public String getName() {
        return name;
    }

    public Long getPrize1() {
        return prize1;
    }

    public Long getPrize3() {
        return prize3;
    }

    public Long getPrizeT() {
        return prizeT;
    }

    public ArrayList<CoordinatorsModel> getCoordinatorsModelArrayList() {
        return coordinatorsModelArrayList;
    }

    public ArrayList<RulesModel> getRulesModels() {
        return rulesModels;
    }

}
