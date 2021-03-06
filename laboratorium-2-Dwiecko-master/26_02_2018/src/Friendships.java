import java.util.*;

public class Friendships {
    Map<String, List<String>> friendships = new HashMap<>();

    //Dodanie przyjaciół - wykorzystuje funkcje addFriend!	
    public void makeFriends(String person1, String person2) {
       addFriend(person1, person2);
	   addFriend(person2, person1);
    }
    
    //Pobranie listy przyjaciol
    public List<String> getFriendsList(String person) {
        return friendships.get(person);
    }
    
    //Sprawdzenie czy przyjaciele
    public boolean areFriends(String person1, String person2) {
    	if(!friendships.containsKey(person1) || (!friendships.containsKey(person2))) return false;
        if(getFriendsList(person1).contains(person2) &&
      	   getFriendsList(person2).contains(person1))
      	  return true;
        
    return false;  
    }
    
    //Dodanie do listy przyjaciol do danej osoby
    private void addFriend(String person, String friend) {
    	List<String> friendsList = friendships.get(person);

	    if(friendsList == null) {
	         friendsList = new ArrayList<String>();
	         friendsList.add(friend);
	         friendships.put(person, friendsList);
	    } else {
	        if(!friendsList.contains(friend)) friendsList.add(friend);
	    }	    

    }
}
