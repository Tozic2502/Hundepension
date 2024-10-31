package org.example;

public class Veterinarian
{
    //Instance variables
    private int fldVetTelephoneNumber;
    private String fldVetName;
    private String fldVetAdres;

    //Constructors
    public Veterinarian (int fldVetTelephoneNumber, String fldVetName, String fldVetAdress)
    {
        this.fldVetTelephoneNumber = fldVetTelephoneNumber;
        this.fldVetName = fldVetName;
        this.fldVetAdres = fldVetAdress;
    }

    public Veterinarian()
    {

    }



    //Getter + setter for phone no.
    public int getFldVetTelephoneNumber()
    {
        return fldVetTelephoneNumber;
    }

    public void setFldVetTelephoneNumber(int fldVetTelephoneNumber)
    {
        this.fldVetTelephoneNumber = fldVetTelephoneNumber;
    }

    //Getter + setter for Vet name
    public String getFldVetName()
    {
        return fldVetName;
    }

    public void setFldVetName(String fldVetName)
    {
        this.fldVetName = fldVetName;
    }

    //Getter + setter for Vet address
    public String getFldVetAdres()
    {
        return fldVetAdres;
    }

    public void setFldVetAdres(String fldVetAdres)
    {
        this.fldVetAdres = fldVetAdres;
    }

}
