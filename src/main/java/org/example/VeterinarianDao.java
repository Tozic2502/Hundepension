package org.example;

public interface VeterinarianDao
{
    void readVeterinarian(int fldVetTelephoneNumber) throws Exception;
    void readAllVeterinarians() throws Exception;
    void createVeterinarian(Veterinarian veterinarian) throws Exception;
}
