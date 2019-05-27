package com.beans;

import com.connection.ConnectionBD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class Facture {
    String type;
    int numero;
    int nbunite;
    String Date;
    String ExpirationDate;

    public Facture(String type, int numero, int nbunite) {
        System.out.println("entre constructeur");
        this.numero = numero;
        this.type = type;
        this.nbunite = nbunite;
        ZoneId z = ZoneId.of("Europe/Paris");
        this.Date = LocalDate.now(z).toString();
        this.ExpirationDate = LocalDate.now(z).plusMonths(3).toString();


    }

    public void addfacture() throws SQLException {
        ConnectionBD c = new ConnectionBD();
        c.driver();
        c.OpenConnexion();
        if (type.equals("Mobile")) {
            String sql = "select Num_service_int,Num_service_voc from Mobile where Numero=" + numero + ";";
            ResultSet rst = c.selectExec(sql);
            rst.next();


            sql = "select  Cout_unitaire from Service_Int where Num_service='" + rst.getInt(1) + "';";
            ResultSet rst1 = c.selectExec(sql);
            rst1.next();
            int i = rst1.getInt(1);
            sql = "select  Cout_unitaire from Service_Voc where Num_service='" + rst.getInt(2) + "';";
            rst1 = c.selectExec(sql);

            rst1.next();
            int j = rst1.getInt(1);
            int k = nbunite * i + nbunite * j;
            sql = "insert into facture (numero,Date_ajout,nb_unite_conso,total,delais) values('" + numero + "','" + Date + "','" + nbunite + "','" + k + "','" + ExpirationDate + "');";
            c.updateExec(sql);
        } else

        {

            String sql = "insert into facture(numero,Date_ajout,nb_unite_conso,total,delais) values('" + numero + "','" + Date + "','" + nbunite + "','" + nbunite * 120 + "','" + ExpirationDate + "');";

            c.updateExec(sql);
        }
        c.closeConnection();

    }

    public static ArrayList<Integer> afficherfacture() throws SQLException {
        ZoneId z = ZoneId.of("Europe/Paris");
        String sql = "select Numero ,Max(id) from facture where Delais>='" + LocalDate.now(z).toString() + "' GROUP BY Numero;";
        ConnectionBD c = new ConnectionBD();
        c.driver();
        c.OpenConnexion();
        ResultSet rst = c.selectExec(sql);
        System.out.println("heloooooooooo");
        ArrayList<Integer> A = new ArrayList<Integer>();
        while (rst.next()) {
            A.add(rst.getInt("Numero"));
        }
        System.out.println(String.valueOf(A.size()));
        return (A);


    }
    public static void  payer(int numero)
    {
        ConnectionBD c=new ConnectionBD();
        c.driver();
        c.OpenConnexion();
        String sql="delete from facture where numero='"+numero+"';";
        c.updateExec(sql);

    }
    public static Vector getfacture() throws SQLException {
        String sql="select id ,numero,Date_ajout,nb_unite_conso,total,delais from facture;";
        ConnectionBD c=new ConnectionBD();
        c.driver();
        c.OpenConnexion();
        ResultSet rst=c.selectExec(sql);
        Vector v=new Vector();
        while(rst.next())
        {

            Integer i=rst.getInt("id");
            Integer numero=rst.getInt("numero");
            String d=rst.getString("Date_ajout");
            Integer n=rst.getInt("nb_unite_conso");
            Float f=rst.getFloat("total");
            String dl=rst.getString("delais");
            v.add(i);
            v.add(numero);
            v.add(d);
            v.add(n);
            v.add(f);
            v.add(dl);
        }
        return v;

    }
}