package com.beans;
import com.connection.ConnectionBD;

public class Service_Voc extends Service
{
    public Service_Voc(String description, float cout)
    {
        super(description,cout);
    }
    public void addservicevoc()
    {
        ConnectionBD c = new ConnectionBD();
        c.driver();
        c.OpenConnexion();
        c.updateExec("insert into Service_Voc (Description,Cout_unitaire) values ('"+this.getDescription()+"','"+this.getCout()+"');");
    }

}
