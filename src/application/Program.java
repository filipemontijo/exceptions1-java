/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;
import model.exceptions.DomainException;

/**
 *
 * @author filip
 */
public class Program {
    
    public static void main(String[] args) {
        
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyy");

    try {
        System.out.print("Room Number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date (dd/mm/yyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-Out date (dd/mm/yyy): ");
        Date checkOut = sdf.parse(sc.next());

        Reservation reservation = new Reservation(number, checkIn, checkOut);
        System.out.println("Reservation: " +reservation);

        System.out.println("");
        System.out.println("Enter data to update the reservation: ");
        System.out.print("Check-in date (dd/mm/yyy): ");
        checkIn = sdf.parse(sc.next());
        System.out.print("Check-Out date (dd/mm/yyy): ");
        checkOut = sdf.parse(sc.next());

        reservation.updateDates(checkIn, checkOut);
        System.out.println("Reservation: " +reservation);
    
    }
    catch(ParseException error){
        
        System.out.println("Invalid date format");
    }

    catch(DomainException error){
        System.out.println("Error in reservation: " + error.getMessage());
        
    }
    
     catch(RuntimeException error){
        System.out.println("Unexpected Error ");
      sc.close();

    }
    }    
}       



