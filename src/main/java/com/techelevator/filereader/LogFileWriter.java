package com.techelevator.filereader;
import com.techelevator.items.CandyStoreItem;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    This class should contain any and all details of access to the log file
 */
public class LogFileWriter {
    private String fileName = "Log.txt";


    public void writeLogCandySelection(CandyStoreItem candy, double newBalance) {
        try (FileWriter fileWriter = new FileWriter(fileName, true); PrintWriter printWriter = new PrintWriter(fileWriter)) {
            //did we have to make an entire new FileWriter (as well as print writer) ? Steve did in roster example, but that was for buffered writer.
            //this ~appears~ to circumvent the need for a File Object.
            //would it have just been better to pass in a file object?

            //date information
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
            String timestamp = dateFormat.format(new Date());

            //log & format items selected
            printWriter.printf("%s %s %s %s $%.2f $%.2f %n" , timestamp, candy.getQuantity(), candy.getName(), candy.getID(), candy.getQuantity() * candy.getPrice(), newBalance );

        } catch (Exception e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }

    public void writeLogMoneyAdded(double oldBalance, double newBalance){
        try (FileWriter fileWriter = new FileWriter(fileName, true); PrintWriter printWriter = new PrintWriter(fileWriter)) {

            //date information
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
            String timestamp = dateFormat.format(new Date());


            //Log the old and new balances
            printWriter.printf("%s %s $%.2f $%.2f %n", timestamp, "MONEY RECEIVED:" , oldBalance, newBalance);
        }
        catch (Exception e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }

    public void writeLogChangeGiven(double oldBalance) {
        try (FileWriter fileWriter = new FileWriter(fileName, true); PrintWriter printWriter = new PrintWriter(fileWriter)) {

            //date information
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
            String timestamp = dateFormat.format(new Date());

            // Log the change given
            printWriter.printf("%s %s $%.2f %s %n", timestamp, "CHANGE GIVEN:", oldBalance, "$0.00");

        } catch (Exception e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }
}



