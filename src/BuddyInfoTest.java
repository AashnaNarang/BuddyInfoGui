import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BuddyInfoTest {
	private BuddyInfo b;
	private BuddyInfo c;
	
	@Before
	public void setUp() throws Exception {
		b = new BuddyInfo("b", "313", "6132725555", 30);
		c = new BuddyInfo(b);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBuddyInfo() {
		assertNotNull(b);
	}
	
	@Test
	public void testGetName() {
		assertEquals("b", b.getName());
	}
	
	@Test
	public void testGetAddress() {
		assertEquals("313", b.getAddress());
	}
	
	@Test
	public void testGetPhonee() {
		assertEquals("6132725555", b.getPhone());
	}
	
	@Test
	public void testGetAge() {
		assertEquals(30, b.getAge());
	}
	
	@Test
	public void testSetName() {
		b.setName("aa");
		assertEquals("aa", b.getName());
	}
	
	@Test
	public void testSetAddress() {
		b.setAddress("213");
		assertEquals("213", b.getAddress());
	}
	
	@Test
	public void testSetPhone() {
		b.setPhone("6133456789");
		assertEquals("6133456789", b.getPhone());
	}
	
	@Test
	public void testSetAge() {
		b.setAge(25);
		assertEquals(25, b.getAge());
	}
	
	@Test 
	public void testCopyConstructor() {
		assertTrue(c.equals(b));
	}
	
	@Test
	public void testEquals() {
		assertTrue(b.equals(b));
	}
	
	@Test
	public void testGreeting() {
		assertEquals("Hi b", b.greeting());
	}
	
	@Test
	public void testToString() {
		String s = "Name: " + b.getName() + "    Address: " + b.getAddress() + "    Phone: " + b.getPhone();
		assertEquals(s, b.toString());
	}
	
	@Test 
	public void testIsOlder18() {
		assertTrue(c.isOver18());
	}
	
	@Test
	public void testIsYounger18() {
		BuddyInfo d = new BuddyInfo("d", "232", "7132812723", 12);
		assertFalse(d.isOver18());
	}
	

}
