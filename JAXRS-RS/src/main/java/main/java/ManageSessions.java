package main.java;

import java.util.Enumeration;
import java.util.Hashtable;

public class ManageSessions {

	   private static ManageSessions singletonObject = new ManageSessions();

	   private ManageSessions(){}

	   public static ManageSessions getInstance(){
	      return singletonObject;
	   }

	    Hashtable<String, String> roomSessionDB = new Hashtable<String, String>();
	    Enumeration<String> roomsAndSessions;
	    String roomSessionData;
	    
	    public String getSessionData(String roomDetails)
	    {
	    	return roomSessionDB.get(roomDetails);
	    }
	    
	    public void updateSessionData(String roomDetails, String SESSION_ID){
	    	roomSessionDB.put(roomDetails, SESSION_ID);
	    }
	    
	    public void showAllSessionData(){
	    	
	    	roomsAndSessions = roomSessionDB.keys();
	    	
		    while(roomsAndSessions.hasMoreElements()) {
			    roomSessionData = (String) roomsAndSessions.nextElement();
			    System.out.println(roomSessionData + ": " +
			    roomSessionDB.get(roomSessionData));
		    }
	    }
		    
	    public String returnAllRoomData(){
	    	
	    	roomsAndSessions = roomSessionDB.keys();
	    	
	    	roomSessionData = "";
	    	
		    while(roomsAndSessions.hasMoreElements()) {
		    	String in = (String) roomsAndSessions.nextElement();
		    	roomSessionData = roomSessionData.concat(in).concat("  ");
		    	roomSessionData = roomSessionData.concat(roomSessionDB.get(in)).concat("\n\n");
		    }
		    
		    System.out.println("All room data :"+roomSessionData);
	    	return roomSessionData;
	    }
	    
	    public void clearRooms(){
	    	roomSessionDB.clear();
	    }
	}
