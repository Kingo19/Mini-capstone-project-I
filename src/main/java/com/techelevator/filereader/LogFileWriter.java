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

            //date information
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
            String timestamp = dateFormat.format(new Date());

            // Log the items bought
            String logMessage = timestamp + " " + candy.getQuantity() + " " + candy.getName() + " " + candy.getID() + " $" + candy.getQuantity() * candy.getPrice() + " $" + newBalance;
            printWriter.println(logMessage);

        } catch (IOException e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }

    public void writeLogMoneyAdded(double oldBalance, double newBalance){
        try (FileWriter fileWriter = new FileWriter(fileName, true); PrintWriter printWriter = new PrintWriter(fileWriter)) {
            //date information
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
            String timestamp = dateFormat.format(new Date());

            // Log the old and new balances
            String balanceLogMessage = timestamp + " MONEY RECEIVED: " + "$" + oldBalance + " $" + newBalance;
            printWriter.println(balanceLogMessage);
        }
        catch (IOException e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }

    public void writeLogChangeGiven(double oldBalance) {
        try (FileWriter fileWriter = new FileWriter(fileName, true); PrintWriter printWriter = new PrintWriter(fileWriter)) {

            //date information
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
            String timestamp = dateFormat.format(new Date());

            // Log the items bought
            String logMessage = timestamp + " CHANGE GIVEN: $" + oldBalance + " $0.00";
            printWriter.println(logMessage);

        } catch (IOException e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }
}



