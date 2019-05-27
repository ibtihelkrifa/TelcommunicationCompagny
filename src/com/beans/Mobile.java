package com.beans;
import com.connection.ConnectionBD ;

public class Mobile {
    private int num=98000000;
    private String type;
    private String reseau;
    private String payement;
    private int serviceint;
    private int servicevoc;
    private int mat;
    private static int i=0;

    public Mobile(String type ,String reseau,String payement,int serviceint,int servicevoc,int mat)
    {   i=i+1;
        this.type=type;
        this.reseau=reseau;
        this.payement=payement;
        this.servicevoc=servicevoc;
        this.serviceint=serviceint;
        this.mat=mat;
        this.num=this.num +i;
        System.out.println("ibibib");
    }
    public String getreseau()
    {
        return reseau;
    }
    public void setreseau(String reseau)
    {
        this.reseau=reseau;
    }
    public String gettype()
    {
        return type;
    }
    public void type(String type)
    {
        this.type=type;
    }

    public void setmat(int mat)
    {
        this.mat=mat;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


    public String getPayement() {
        return payement;
    }

    public void setPayement(String payement) {
        this.payement = payement;
    }

    public int getServiceint() {
        return serviceint;
    }

    public void setServiceint(int serviceint) {
        this.serviceint = serviceint;
    }

    public int getServicevoc() {
        return servicevoc;
    }

    public void setServicevoc(int servicevoc) {
        this.servicevoc = servicevoc;
    }

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }
    public void addmobile()
    {
        ConnectionBD c = new ConnectionBD();
        c.driver();
        c.OpenConnexion();
        System.out.println("ccccccc");
        c.updateExec("insert into Mobile (Numero,Type,Reseau,Payement,Num_service_int,Num_service_voc,Matricule) values ('"+ this.getNum()+"','"+this.gettype()+"','"+ this.getreseau()+"','"+this.getPayement()+"','"+this.getServiceint()+"','"+this.getServicevoc()+"','"+ this.getMat()+"');");
    }

}
