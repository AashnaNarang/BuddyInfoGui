import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddressBookTest {
	private AddressBook a;
	private BuddyInfo b;
	private BuddyInfo c;
	
	@Before
	public void setUp() throws Exception {
		a = new AddressBook();
		b = new BuddyInfo("Bud", "333 add", "6132923030", 12);
		c = new BuddyInfo("a", "232", "6132884653", 30);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddressBook() {
		assertTrue(a.isEmpty());
	}

	@Test
	public void testAddBuddy() {
		a.addBuddy(b);
		assertEquals(1, a.getSize());
		assertSame(b, a.get(0));
	}

	@Test
	public void testRemoveBuddy() {
		a.addBuddy(b);
		a.removeBuddy(0);
		assertEquals(0, a.getSize());
	}
	
	public void testTwoBuddies() {
		a.addBuddy(b);
		a.addBuddy(c);
		assertEquals(2, a.getSize());
		assertSame(c, a.get(1));
	}
	
	@Test
	public void testClear() {
		a.addBuddy(b);
		a.clear();
		assertTrue(a.isEmpty());
	}
	
	public void testSize() {
		a.addBuddy(b);
		a.addBuddy(c);
		assertEquals(2, a.size());
	}

}
