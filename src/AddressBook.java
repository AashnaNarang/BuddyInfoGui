import javax.swing.DefaultListModel; 
public class AddressBook extends DefaultListModel { 	
	public AddressBook() {
		super();
	}
		
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
		
}

