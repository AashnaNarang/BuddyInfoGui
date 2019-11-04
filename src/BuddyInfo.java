public class BuddyInfo {

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
		return "Name: " + this.name + "    Address: " + this.address + "    Phone: " + phone;
	}
	
	public String greeting() {
		return "Hi " + this.name;
	}
	
	public boolean isOver18() {
		return this.age > 18;
	}
	
}