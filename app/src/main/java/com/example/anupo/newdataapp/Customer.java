package com.example.anupo.newdataapp;

public class Customer {
    int sno;
    String sname, cname;

    public Customer() {
    }

    public Customer(int sno, String sname, String cname)
    {
        this.sno = sno;
        this.sname = sname;
        this.cname = cname;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
