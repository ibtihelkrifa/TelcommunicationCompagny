package com.beans;
import com.connection.ConnectionBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public  class Abonne extends Personne {

    public Abonne(String nom , String prenom, String adresse,String mail)
    {
        super(nom , prenom, adresse, mail);

    }




    public int addabonne()
    {
        ConnectionBD c = new ConnectionBD();
        c.driver();
        c.OpenConnexion();
        c.updateExec("insert into Abonne (Nom,Prenom,Adresse,Mail) values ('"+ this.getNom()+"','"+this.getprenom()+"','"+this.getadresse()+"','"+this.getMail()+"');");
        ResultSet rs = c.selectExec("select Matricule from Abonne where Mail ='"+ this.getMail()+"' and Nom='"+ this.getNom()+"';");
        try {
            rs.next();
            return(Integer.parseInt(rs.getString(1)));
            }
        catch (Exception e)
        {
            System.out.println("Beeeeeeeeeeeeeeeeeeet" +e.getMessage());
        }
        return 0;
    }
    public static String getmail(int numero) throws SQLException {
        System.out.println("heloo methode get mail");
        ConnectionBD c = new ConnectionBD();
        c.driver();
        c.OpenConnexion();
        String sql = "select Matricule from Fixe where Numero='" + numero + "';";
        ResultSet rst = c.selectExec(sql);
        if (rst.next()) {
            System.out.println("boucle 1");
            sql = "select Mail from Abonne where Matricule='" + rst.getInt("matricule") + "';";
            rst = c.selectExec(sql);
        } else {
            System.out.println("boucle 2");
            sql = "select Matricule from Mobile where Numero='" + numero + "';";
            rst = c.selectExec(sql);
            rst.next();
            int mat = rst.getInt("matricule");
            System.out.println(String.valueOf(mat)+"this is the mat");
            sql = "select Mail from Abonne where Matricule='" + rst.getInt("matricule") + "';";
            rst = c.selectExec(sql);
        }


        rst.next();
        return (rst.getString("Mail"));
    }


public static Vector getabonne() throws SQLException {
    String sql="select Nom,Prenom,adresse,Mail from Abonne;";
    ConnectionBD c=new ConnectionBD();
    c.driver();
    c.OpenConnexion();
    ResultSet rst=c.selectExec(sql);
    Vector v=new Vector();
    while(rst.next())
    {
        Abonne a=new Abonne(rst.getString("Nom"),rst.getString("Prenom"),rst.getString("Adresse"),rst.getString("Mail"));
        v.add(a);
    }
   return v;

}

}
