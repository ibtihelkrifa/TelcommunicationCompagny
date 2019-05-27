package com.beans;
import com.connection.ConnectionBD;
public class Fixe {
    private int loc;
    private int mat;
    private  int num=70000000;
    private static int i=0;
    public Fixe(int loc ,int mat)
    {   i=i+1;
        this.loc=loc;
        this.mat=mat;
        this.num=this.num +i;
    }
    public int getloc()
    {
        return(loc);
    }
    public int getmat()
    {
        return(mat);
    }
    public void setloc(int loc)
    {
        this.loc=loc;
    }
    public void setmat(int mat)
    {
        this.mat=mat;
    }
    public int getnum()
    {
        return(num);
    }
    public void addfixe()
    {
        ConnectionBD c = new ConnectionBD();
        c.driver();
        c.OpenConnexion();
        c.updateExec("insert into Fixe (Numero,Localisation,Matricule) values ('"+ this.getnum()+"','"+this.getloc()+"','"+this.getmat()+"');");
        c.updateExec("update Localistation set NB_crees=Nb_crees+1 where id= "+this.getloc()+";");
    }

}
