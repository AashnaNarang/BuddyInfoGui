import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

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
	
	@Test
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
	
	@Test
	public void testSize() {
		a.addBuddy(b);
		a.addBuddy(c);
		assertEquals(2, a.size());
	}
	
	@Test 
	public void testSave() {
		a.addBuddy(b);
		a.save("buddies.txt");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("buddies.txt")));
			assertTrue(b.toString().equals(reader.readLine()));
			reader.close();	
		} catch (IOException e) {
			System.out.println("cannot test because cannot retrieve file");
		}
		
	}
	
	@Test
	public void testLoadAddressBook() { 
		a.addBuddy(b);
		a.save("buddies.txt");
		try {
			AddressBook fromFile = AddressBook.importBuddiesFromFile("buddies.txt");
			assertTrue(b.equals((BuddyInfo)fromFile.get(0)));
		} catch (IOException e) {
			System.out.println("Cannot retrieve file");
		}
	}
	
	@Test
	public void testLoadWithReadObject() {
		try {
			a.addBuddy(b);
			a.writeObject("buddies.txt");
			AddressBook addy = a.readObject("buddies.txt");
			assertTrue(a.equals(addy));
		} catch (IOException e) {
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLoadWithXML() {
		a.addBuddy(b);
		a.exportToXMLFile("buddies.txt");
		AddressBook addy;
		try {
			addy = a.importFromXMLFile("buddies.txt");
			assertTrue(a.equals(addy));
		} catch (SAXException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
