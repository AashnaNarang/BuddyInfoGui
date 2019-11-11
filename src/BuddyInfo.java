import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class BuddyInfo implements Serializable {

	private String name, address, phone;
	private int age;

	/* Constructor
	*/


	public BuddyInfo(String name, String address, String phone, int age) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.age = age;
	}
	
	public BuddyInfo(BuddyInfo b) {
		this(b.getName(), b.getAddress(), b.getPhone(), b.getAge());
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public boolean equals(BuddyInfo buddy) {
		if(buddy == null) return false; 
		if(buddy == this) return true;
		if(buddy.getClass() != this.getClass()) return false;
		BuddyInfo bud = (BuddyInfo)buddy;
		if(bud.getAddress() == this.address & bud.getName() == this.name & bud.getPhone() == this.phone) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return this.name + "#" + this.address + "#" + this.phone + "#" + this.age;
	}
	
	public String greeting() {
		return "Hi " + this.name;
	}
	
	public boolean isOver18() {
		return this.age > 18;
	}
	
	
	public static BuddyInfo importBuddy(String info) {
		String[] s = info.split("#");
		for(String st : s) {
			System.out.println(st);
		}
		BuddyInfo b = new BuddyInfo(s[0], s[1], s[2], Integer.parseInt(s[3]));
		return b;		
	}
	
//	public static void removeFromFile(String buddyInfo, String filename) {
//		String curr = "";
//		AddressBook book = new AddressBook();
//		BufferedReader reader;
//		try {
//			reader = new BufferedReader(new FileReader(filename));
//			while ((curr = reader.readLine()) != null) {
//				if(curr.equals(buddyInfo)) {
//					try {
//						FileWriter writer = new FileWriter(new File(filename), true);
//					    writer.write(this.toString() + "\n");
//						writer.close();
//					} catch (FileNotFoundException e) {
//						e.printStackTrace();
//						return false;
//					} catch (IOException e) {
//						e.printStackTrace();
//						return false;
//					}	
//				}
//			}
//			reader.close();	
//		}
//	}
	
	
}