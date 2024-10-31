package org.example;


public interface HundDao {
    void readHund(int id) throws Exception;
    void readAllHund() throws Exception;
    void createHund(Hund hund) throws Exception;
}
