/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import model.exceptions.DomainException;

/**
 *
 * @author filip
 */
public class Reservation {
    
    private int roomNumber;
    private Date checkIn;
    private Date checkOut;
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

    public Reservation(int roomNumber, Date checkIn, Date checkOut) {
        if (!checkOut.after(checkIn)){
               throw new DomainException("Error in reservation: Check Out date must be after Check In date ");
            } 
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public long duraction(){
    
        //diferença das datas em milisegundos
        long diff = checkOut.getTime() - checkIn.getTime();
        //converter milisegundos em dias
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    
    public void updateDates(Date checkIn, Date checkOut) {
        Date now = new Date();
            if(checkIn.before(now) || checkOut.before(now)){
                throw new DomainException("Error in reservation: Reservation dates for update must be future dates");
            }
            if (!checkOut.after(checkIn)){
               throw new DomainException("Error in reservation: Check Out date must be after Check In date ");
            } 
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        
    }

    @Override
    public String toString() {
        return "Room " 
                + roomNumber 
                + " , check-In: " 
                + sdf.format(checkIn) 
                +" , check-Out " 
                + sdf.format(checkOut) 
                + " , "
                + duraction()
                + " nigths";
    }
    
    
    
}
