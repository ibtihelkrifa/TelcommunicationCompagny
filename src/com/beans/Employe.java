package com.beans;
import com.connection.ConnectionBD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Employe extends Personne
{
    private String password;
    private int nums;

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String pass)
    {
        this.password = pass;
    }
    public int getNums()
    {
        return this.nums;
    }
    public void setNums(int nums)
    {
        this.nums = nums;
    }

    public Employe(String nom , String prenom, String adresse,String mail, String pass, int nums)
    {
        super(nom , prenom, adresse, mail);
        this.setNums(nums);
        this.setPassword(pass);
    }
    public void addEmploye()
    {
        ConnectionBD c = new ConnectionBD();
        c.driver();
        c.OpenConnexion();
        c.updateExec("insert into Employe (Nom,Prenom,Adresse,Mail,Password,NumeroService) values ('"+ this.getNom()+"','"+this.getprenom()+"','"+this.getadresse()+"','"+this.getMail()+"','"+this.getPassword()+"','"+this.getNums()+"');");
    }
    public static Vector getemploye() throws SQLException {
        String sql="select * from Employe";
        ConnectionBD c=new ConnectionBD();
        c.driver();
        c.OpenConnexion();
        Vector v=new Vector();
        ResultSet rst=c.selectExec(sql);
        while(rst.next())
        {
            Employe a=new Employe(rst.getString("Nom"),rst.getString("Prenom"),rst.getString("Adresse"),rst.getString("Mail"),rst.getString("Password"),Integer.parseInt(rst.getString("NumeroService")));
            v.add(a);
        }
    }
}
