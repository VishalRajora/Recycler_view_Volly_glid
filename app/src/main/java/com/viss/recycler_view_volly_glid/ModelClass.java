package com.viss.recycler_view_volly_glid;

public class ModelClass
{
   private String name , realname , team , moviepublisher ,  createdby,image;
    private  int launchDate;

    public ModelClass(String name , String realname , String team , String moviepublisher , String createdby , String image , int launchDate) {
        this.name = name;
        this.realname = realname;
        this.team = team;
        this.moviepublisher = moviepublisher;
        this.createdby = createdby;
        this.image = image;
        this.launchDate = launchDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getMoviepublisher() {
        return moviepublisher;
    }

    public void setMoviepublisher(String moviepublisher) {
        this.moviepublisher = moviepublisher;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(int launchDate) {
        this.launchDate = launchDate;
    }
}
