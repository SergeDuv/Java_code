import java.util.*;
/**
 * Write a description of CountTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CountTester {
    public void testCounts(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        HashMap<String,Integer> counts = la.countVisitPerIP(); 
        System.out.println (counts);
    }
    
    public void testmostNumberVisitsByIP() {
       LogAnalyzer le = new LogAnalyzer();
        le.readFile("weblog2_log");
        HashMap<String,Integer> counts = le.countVisitPerIP();
        int max_value = le.mostNumberVisitsByIP(counts); 
        System.out.println ("Max value in the HashMap is " + max_value); 
    }
    
    public void testiPsMostVisits() {
       LogAnalyzer le = new LogAnalyzer();
        le.readFile("weblog2_log");
        HashMap<String,Integer> counts = le.countVisitPerIP();
        ArrayList<String> list = le.iPsMostVisits(counts); 
        System.out.println ("List of IPs with max visits is " + list); 
    }
    
    public void testiPsForDays() {
       LogAnalyzer le = new LogAnalyzer();
        le.readFile("weblog3-short_log");
        HashMap<String,ArrayList<String>> counts = le.iPsForDays();
        //ArrayList<String> list = le.iPsMostVisits(counts); 
        System.out.println ("The HashMap is here "  + counts); 
    }
    
    public void testdayWithMostIPVisits() {
       LogAnalyzer le = new LogAnalyzer();
        le.readFile("weblog2_log");
        HashMap<String,ArrayList<String>> counts = le.iPsForDays();
        String date = le.dayWithMostIPVisits(counts);
        //ArrayList<String> list = le.iPsMostVisits(counts); 
        System.out.println ("The day with most IP visits is "  + date); 
    
           }
           
    public void testiPsWithMostVisitsOnDay(){
        LogAnalyzer le = new LogAnalyzer();
        le.readFile("weblog2_log");
        HashMap<String,ArrayList<String>> counts = le.iPsForDays();
        ArrayList<String> IPs = le.iPsWithMostVisitsOnDay(counts, "Sep 29");
        System.out.println ("The IPs with most visits are "  + IPs);
    }
  }
