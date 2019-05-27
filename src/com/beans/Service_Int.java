package com.beans;
import com.connection.ConnectionBD;

public class Service_Int extends Service
{
    private String isp;

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    public Service_Int(String description, float cout, String isp)
    {
        super(description,cout);
        this.setIsp(isp);
    }
    public void addserviceint()
    {
        ConnectionBD c = new ConnectionBD();
        c.driver();
        c.OpenConnexion();
        c.updateExec("insert into Service_Int (ISP,Description,Cout_unitaire) values ('"+ this.getIsp()+"','"+this.getDescription()+"','"+this.getCout()+"');");
    }

}
