package com.beans;

public abstract class Personne
{
    private String nom;
    private String prenom;
    private String adresse ;
    private String mail;

    public String getMail()
    {
        return mail;
    }

    public void setMail(String mail)
    {
        this.mail = mail;
    }

    public String getNom()
    {

        return nom;

    }

    public void setNom(String nom)
    {

        this.nom = nom;

    }

    public String getprenom()
    {

        return nom;

    }

    public void setprenom(String prenom)
    {

        this.prenom = prenom;

    }

    public String getadresse()
    {

        return adresse;

    }

    public void setadresse(String adresse)
    {

        this.adresse = adresse;

    }

    public Personne(String nom , String prenom, String adresse,String mail)
    {
         this.setNom(nom);
         this.setprenom(prenom);
         this.setadresse(adresse);
         this.setMail(mail);
    }
}
