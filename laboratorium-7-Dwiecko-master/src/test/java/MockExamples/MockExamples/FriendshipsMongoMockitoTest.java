package MockExamples.MockExamples;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// Ta linia jest wymagana
@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class FriendshipsMongoMockitoTest {
	
	//Co zastepujemy
	@Mock
	FriendsCollection friends;
	
	//Nasza atrapa
	@InjectMocks
	FriendshipsMongo friendships;
	
	@Test
	public void mockingWorksAsExpected(){
		Person joe = new Person("Joe");
		doReturn(joe).when(friends).findByName("Joe");
		assertThat(friends.findByName("Joe")).isEqualTo(joe);
	}


	
	@Test
	public void alexDoesNotHaveFriends(){
		assertThat(friendships.getFriendsList("Alex")).isEmpty();
	}
	
	@Test
	public void joeHas5Friends(){
		List<String> expected = Arrays.asList(new String[]{"Karol","Dawid","Maciej","Tomek","Adam"});
		//Spy przechwytuje wywołania z przekazywanymi pośrednio danymi w celu
		// późniejszego zbadania tych danych w teście - tutaj w przykładzie lista przyjaciół Joe
		Person joe = spy(new Person("Joe"));
		doReturn(joe).when(friends).findByName("Joe");
		doReturn(expected).when(joe).getFriends();
		assertThat(friendships.getFriendsList("Joe")).hasSize(5).containsOnly("Karol","Dawid","Maciej","Tomek","Adam");		
	}
	
	@Test
	public void returnsEmptyListAfterPassingNullValue(){
		List<String> people = friendships.getFriendsList(null);
		
		assertThat(people.isEmpty());
	}
	
	@Test
	public void returnsFalseAfterTryingToMakeFriendsBetweenTwoPeopleWhenOneDoesNotExist(){
		Person joe = spy(new Person("Joe"));
		doReturn(joe).when(friends).findByName("Joe");
		
		
		boolean test = friendships.areFriends("Joe", "Nick");
		
		assertFalse(test);
	}
	
	@Test
	public void returnsTrueAfterMakingFriends(){
		Person joe = spy(new Person("Joe"));
		doReturn(joe).when(friends).findByName("Joe");
		
//		Person nick = spy(new Person("Nick"));
		//doReturn(nick).when(friends).findByName("Nick");
		
		friendships.addFriend("Joe", "Nick");
		boolean areFriends = friendships.areFriends("Joe", "Nick");
		
		assertTrue(areFriends);
	}
	
	
	@Test
	public void areNotFriendsWorksAsExpected(){
		List<String> people = Arrays.asList(new String[]{"Karol", "Nick"});
		Person nick = spy(new Person("Nick"));
		
		doReturn(nick).when(friends).findByName("Nick");
		doReturn(people).when(nick).getFriends();
		
		friendships.addFriend("Nick", "Karol");
		
		assertFalse(friendships.areFriends("Nick", "Joe"));
	}
}