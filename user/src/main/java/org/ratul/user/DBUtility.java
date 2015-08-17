package org.ratul.user;

import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBUtility {
    public static void main(String[] args)
    {
        try {
            addNewMovie();
        } catch (Exception ex) {
            Logger.getLogger(DBUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void addNewMovie()throws Exception
    {
        String name,type,date;int ratings,id;
        Statement st = DAOLayer.getConnection().createStatement();
        System.out.print("Enter new movie name : ");
        name=new Scanner(System.in).nextLine();
        System.out.printf("\n%s","Enter movie id : ");
        id = new Scanner(System.in).nextInt();
        name=name.replace("'","\\'");
        System.out.printf("\n%s","Enter type : ");
        type=new Scanner(System.in).nextLine();
        System.out.printf("\n%s","Enter movie ratings(out of five) : ");
        ratings = new Scanner(System.in).nextInt();
        System.out.printf("\n%s","Enter movie release date(yyyy-mm-dd) : ");
        date = new Scanner(System.in).nextLine();
        DAOLayer.updateData("insert into movie values("+id+",'"+name+"','"+type+"',"+ratings+",'"+date+"');");


    }
}
