package com.cyo.ex2_2;

/**
 * Created by USER on 2015/3/21.
 */
public class team {
    private int team_pic, team_num;
    private String team_name;

    public team() {

    }

    public team(int team_pic, int team_num, String team_name) {
        this.team_pic = team_pic;
        this.team_num = team_num;
        this.team_name = team_name;


    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public int getTeam_num() {
        return team_num;
    }

    public void setTeam_num(int team_num) {
        this.team_num = team_num;
    }

    public int getTeam_pic() {
        return team_pic;
    }

    public void setTeam_pic(int team_pic) {
        this.team_pic = team_pic;
    }


}
