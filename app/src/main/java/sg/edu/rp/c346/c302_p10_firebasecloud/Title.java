package sg.edu.rp.c346.c302_p10_firebasecloud;

import java.io.Serializable;

/**
 * Created by 14049561 on 25/7/2017.
 */

public class Title implements Serializable{

    private String title;
    private String date;
    private int noOfDays;
    private boolean completed;

    public Title(){

    }

    public Title(String title, String date, int noOfDays, boolean completed) {
        this.title = title;
        this.date = date;
        this.noOfDays = noOfDays;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


}
