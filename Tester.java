import edu.duke.*;
import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer LogAnalyzer = new LogAnalyzer();
        LogAnalyzer.readFile("short-test_log");
        LogAnalyzer.printAll();
        // complete method
    }
    
    public void testUniqueIP(){
        LogAnalyzer LogAnalyzer = new LogAnalyzer();
        LogAnalyzer.readFile("weblog2_log");
        System.out.println("Number of unique IPs " + LogAnalyzer.countUniqueIPs());
        
    }
    
    public void testprintAllHigherThanNum(){
       LogAnalyzer LogAnalyzer = new LogAnalyzer();
        LogAnalyzer.readFile("weblog1_log");
        LogAnalyzer.printAllHigherThanNum(400); 
    }
    
    public void testuniqueIPVisitsOnDay() {
        LogAnalyzer LogAnalyzer = new LogAnalyzer();
        LogAnalyzer.readFile("weblog2_log");
        LogAnalyzer.uniqueIPVisitsOnDay("Sep 24");
    }
    public void countUniqueIPsInRange() {
        LogAnalyzer LogAnalyzer = new LogAnalyzer();
        LogAnalyzer.readFile("weblog2_log");
        LogAnalyzer.countUniqueIPsInRange(400, 499);
    }
    
}
