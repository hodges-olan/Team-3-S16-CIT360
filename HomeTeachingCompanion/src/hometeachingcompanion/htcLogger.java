/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hometeachingcompanion;

import java.io.PrintWriter;
import java.util.Date;

/**
 *
 * @author co075oh
 */
public class htcLogger {

    // Get PrintWriter for logging
    private static final PrintWriter LOG_FILE = HomeTeachingCompanionSrvr.getLogFile();
    
    public static void log(String action, String log, String type) {
        Date date = new Date();
        String logEntry = date + " - " + type + " - " + action + " - " + log;
        LOG_FILE.println(logEntry);
        System.out.println(logEntry);
        LOG_FILE.flush();
    }
    
}
