/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author G5 5590
 */
public class TblCapstones {
    private String capid;
    private String capname;
    private String capdescription;
    private TblUsers capuserid;

    public TblCapstones() {
    }

    public TblCapstones(String capid, String capname, String capdescription, TblUsers capuserid) {
        this.capid = capid;
        this.capname = capname;
        this.capdescription = capdescription;
        this.capuserid = capuserid;
    }

    public String getCapid() {
        return capid;
    }

    public void setCapid(String capid) {
        this.capid = capid;
    }

    public String getCapname() {
        return capname;
    }

    public void setCapname(String capname) {
        this.capname = capname;
    }

    public String getCapdescription() {
        return capdescription;
    }

    public void setCapdescription(String capdescription) {
        this.capdescription = capdescription;
    }

    public TblUsers getCapuserid() {
        return capuserid;
    }

    public void setCapuserid(TblUsers capuserid) {
        this.capuserid = capuserid;
    }

    @Override
    public String toString() {
        return "TblCapstones{" + "capid=" + capid + ", capname=" + capname + ", capdescription=" + capdescription + ", capuserid=" + capuserid + '}';
    }

   
    
}
