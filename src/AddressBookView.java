import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.*;

public class AddressBookView extends JFrame implements ActionListener, Serializable  {
	private JMenuBar menuBar; 
	private JMenu menuAddress, menuBuddy;
	private JMenuItem createAddress, createBuddy, removeBuddy, saveAddy, addressBookFromFile;
	private JList<BuddyInfo> buddies;
	private AddressBook addy;
	
	public AddressBookView() {
		this.menuBar = new JMenuBar();
		this.menuAddress = new JMenu("Address Book");
		this.menuBuddy = new JMenu("Buddy Info");
		this.createAddress = new JMenuItem("Create new Address Book");
		this.createBuddy = new JMenuItem("Add a  Buddy");
		this.removeBuddy = new JMenuItem("Remove a buddy :(");
		this.saveAddy = new JMenuItem("Save");
		
		
		this.createAddress.addActionListener(this);
		this.createBuddy.addActionListener(this);
		this.removeBuddy.addActionListener(this);
		this.saveAddy.addActionListener(this);
		
		this.menuAddress.add(createAddress);
		this.menuBuddy.add(createBuddy);
		this.menuBuddy.add(removeBuddy);
		this.menuAddress.add(saveAddy);
		
		this.menuBar.add(menuAddress);
		this.menuBar.add(menuBuddy);
		
		this.buddies = new JList<BuddyInfo>();
		add(new JScrollPane(buddies));
		
		add(buddies, BorderLayout.CENTER);
		add(menuBar, BorderLayout.NORTH);

		this.setJMenuBar(menuBar);
		this.setSize(500,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.createAddress) {
			if(this.addy == null) {
				this.addy = new AddressBook();
				buddies.setModel(addy);
				buddies.setVisible(true);
				this.setTitle("Address Book 1");
			} else {
				JOptionPane.showMessageDialog(this, "Address Book already created");
			}

		} else if (e.getSource() == this.createBuddy){
			if(this.addy == null) {
				JOptionPane.showMessageDialog(this, "Please create an Address Book first");
			} else {
				String name = JOptionPane.showInputDialog("Please enter the buddy's name");
				String address = JOptionPane.showInputDialog("Please enter " + name + "'s address");
				String phone = JOptionPane.showInputDialog("Please enter " + name + "'s phone number");
				int age = Integer.parseInt(JOptionPane.showInputDialog("Please enter " + name + "'s age"));
				BuddyInfo b = new BuddyInfo(name, address, phone, age);
				this.addy.addBuddy(b);
			}
		} else if (e.getSource() == this.removeBuddy){
			if(this.addy == null) {
				JOptionPane.showMessageDialog(this, "Please create an Address Book first");
			} else {
				this.addy.remove(buddies.getSelectedIndex());
			}
		} else {
			this.addy.save("buddies.txt");
		}
	}
	
	
}
