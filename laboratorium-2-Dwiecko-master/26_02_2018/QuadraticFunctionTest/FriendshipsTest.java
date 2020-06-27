import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class FriendshipsTest {
	private Friendships friendships; 

	@Before
	public void setUp() throws Exception {
		friendships = new Friendships();
	}
	
	@Test
	public void bothPeopleShouldNotBeFriendsDueToNullValue()
	{
		assertFalse(friendships.areFriends("Janusz", "Andrzej"));
	}

	@Test
	public void addingOnePerson()
	{
		assertEquals(null,friendships.getFriendsList("Beata"));
	}

	@Test
	public void peopleConnectedWithEachotherAreFriends()
	{
		friendships.makeFriends("Andrzej", "Barbara");
		assertTrue(friendships.areFriends("Andrzej", "Barbara"));
	}
	
	@Test
	public void addingMultiplePeopleWillIncrementList()
	{
		friendships.makeFriends("Andrzej", "Beata");
		friendships.makeFriends("Andrzej", "Barbara");
		assertEquals(2,friendships.getFriendsList("Andrzej").size());
	}
	
	@Test
	public void peopleNotConnectedWithEachotherShouldBeAlone()
	{
		friendships.friendships.put("Bartek", Arrays.asList("Andrzej"));
		friendships.friendships.put("Andrzej", Arrays.asList("Ryszard"));
		assertFalse(friendships.areFriends("Bartek", "Andrzej"));
	}
	
	@Test
	public void namesShouldntDuplicateTest()
	{
		friendships.makeFriends("Andrzej", "Bartek");
		assertEquals(1,friendships.getFriendsList("Andrzej").size());

	}

	@Test
	public void shouldntBeFriendsBothWaysTest()
	{
		friendships.friendships.put("Janusz", Arrays.asList("Ryszard"));
		friendships.friendships.put("Andrzej", Arrays.asList("Ryszard"));
		assertFalse(friendships.areFriends("Janusz", "Andrzej"));
	}
}