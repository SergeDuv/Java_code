import edu.duke.*;
import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Write a description of LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LogAnalyzer {
    private ArrayList<LogEntry> records;
    WebLogParser WebLogParser = new WebLogParser(); 
    
    public LogAnalyzer() {
      records = new ArrayList<LogEntry>();  
    }
    
    public void readFile (String filename) {
        FileResource f = new FileResource();
        for (String line : f.lines()) {
            WebLogParser.parseEntry(line);
            records.add(WebLogParser.parseEntry(line));
        }
    }
    public void printAll() {
     for (LogEntry le : records) {
         System.out.println(le);
        }
    }
    
    public int countUniqueIPs(){
     ArrayList<String> uniqueIps = new ArrayList<String>();
     for (LogEntry le : records) {
         String ipAddr = le.getIpAddress();
         if (!uniqueIps.contains(ipAddr)) {
             uniqueIps.add(ipAddr);
            }
        }
        return uniqueIps.size();
    }
    
    public void printAllHigherThanNum(int num){
        for (LogEntry le : records) {
         int Code = le.getStatusCode();
         if (Code > num) {
             System.out.println (Code);
            }
        }
        
    }
    
    public ArrayList<String> uniqueIPVisitsOnDay(String someday){
        ArrayList<String> myIPs = new ArrayList<String>();
        ArrayList<Integer>myFreqs = new ArrayList<Integer>();
        for (LogEntry le : records) {
            Date d = le.getAccessTime();
            String ipAddr = le.getIpAddress();
            String str = d.toString();
            int index = myIPs.indexOf(ipAddr);
            if (str.contains(someday) && (!myIPs.contains(ipAddr))) {
             myIPs.add(ipAddr); 
             myFreqs.add(1);
            }
    }
    for (int k =0; k<myIPs.size(); k++) {
        System.out.println(myIPs.get(k)+"\t"); 
    }
    System.out.println("Array size: "+myIPs.size());
    return myIPs;
    }
    
    public int countUniqueIPsInRange(int low, int high) {
        ArrayList<Integer>myFreqs = new ArrayList<Integer>();
        ArrayList<String> myIPs = new ArrayList<String>();
        for (LogEntry le : records) {
         String ipAddr = le.getIpAddress();
         int Code = le.getStatusCode();
         if (Code <= high && Code >= low ) {
             if (!myIPs.contains(ipAddr)) {
             myIPs.add(ipAddr);
             myFreqs.add(1);
            }
        }
        }
        for (int k =0; k<myIPs.size(); k++) {
        System.out.println(myIPs.get(k)+"\t");
        }
        System.out.println("Array size: "+ myFreqs.size());
        return myIPs.size();
        
        } 
        
        public HashMap <String,Integer> countVisitPerIP() {
            HashMap<String, Integer> counts = new HashMap<String, Integer>();
            for (LogEntry le : records) {
            String ip = le.getIpAddress(); 
            if  (!counts.containsKey(ip)) {
                counts.put(ip,1);
                }
            else {
             counts.put(ip, counts.get(ip)+1);   
            }
            }
            return counts;
        }
        
        public int countUniqueIPsMap(){
          HashMap<String, Integer> counts =  countVisitPerIP();
          return counts.size();
        }
        
        public int mostNumberVisitsByIP (HashMap<String,Integer> myCounts){
            int max = 0;
            for (String s : myCounts.keySet()){
                int currentNum = myCounts.get(s);
                if (currentNum > max) {
                 max = currentNum;   
                }
            }
            return max;
        }
        
        public ArrayList<String> iPsMostVisits (HashMap<String,Integer> myCounts){
               ArrayList<String> myIPs = new ArrayList<String>();
               /*int maxVisits = 0;
               for (String ip: myCounts.keySet()) {
                  int currentNum = myCounts.get(ip);
                     if(currentNum >= maxVisits) {
                         maxVisits = currentNum;
                         */
                        int max = 0;
                        max = mostNumberVisitsByIP(myCounts);
                        for (String s : myCounts.keySet()) {
                            if (myCounts.get(s) == max){
                                myIPs.add(s);
                        }
                    }
            return myIPs;
        }
        
        public HashMap<String, ArrayList<String>> iPsForDays(){
            HashMap<String,ArrayList<String>> dayIpThatDay = new HashMap<String,ArrayList<String>>();
            ArrayList<String> myIPs = new ArrayList<String>();
            String myString = null;
            for (LogEntry le : records) {
             Date d = le.getAccessTime();
             String ipAddr = le.getIpAddress();
             myString = d.toString();
             myIPs = uniqueIPVisitsOnDay(myString);
             dayIpThatDay.put(myString, myIPs);
            }
            return dayIpThatDay;
        }
      
         
        public String dayWithMostIPVisits (HashMap<String, ArrayList<String>> dayIPs) {
             String dateMostVisited = "";  
             int mostIPsOnDay = 0;
             for (String s : dayIPs.keySet()) {
               if (dayIPs.get(s).size() >= mostIPsOnDay) {
                   mostIPsOnDay = dayIPs.get(s).size();
                   dateMostVisited = s;
                   }
                 }
             return dateMostVisited;    
        }
        
        public ArrayList<String> iPsWithMostVisitsOnDay (HashMap<String, ArrayList<String>> map, String day) {
            
            ArrayList<String> mostIPs = new ArrayList<String>();
            mostIPs = uniqueIPVisitsOnDay(day);
            HashMap<String,Integer> counts = new HashMap<String,Integer>();      
        
            for (int k=0;k<mostIPs.size();k++) {
             String s = mostIPs.get(k) ; 
                 if (!counts.containsKey(s)) {
                 counts.put(s,1);
             }
             else {
                 int freq = counts.get(s);
                 counts.put(s,freq+1);
             }
       }
           return iPsMostVisits(counts);
    }
        }
