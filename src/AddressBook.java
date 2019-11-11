import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultListModel; 
public class AddressBook extends DefaultListModel { 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7458536798499564904L;
		
	public void addBuddy(BuddyInfo bud) {
		if (bud != null) {
			super.addElement(bud);
		}
	}
		
	public void removeBuddy(int index) {
		if (index >= 0 && index < super.getSize()) {
			super.remove(index);
		}
	}
	
	public int size() {
		return this.getSize();
	}
	
	public void clear() {
		super.clear();
	}
	
	public static AddressBook importBuddiesFromFile(String filename) throws IOException {
		String curr = "";
		AddressBook book = new AddressBook();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filename));
			while ((curr = reader.readLine()) != null) {
				book.addBuddy(BuddyInfo.importBuddy(curr));
			}
			reader.close();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return book;
	}
	
	public boolean save(String filename) {
		try {
			FileWriter writer = new FileWriter(new File(filename), false);
			for(int i = 0; i < this.getSize(); i++) {
				writer.write(this.getElementAt(i).toString() + "\n");
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}	
		return true;
	}
		
	public static void main(String args[]) {
		AddressBookView view = new AddressBookView();
		BuddyInfo b = new BuddyInfo("a", "aa", "2312", 3);
		try {
			AddressBook addy = AddressBook.importBuddiesFromFile("buddies.txt");
			System.out.println(addy.getElementAt(0));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

