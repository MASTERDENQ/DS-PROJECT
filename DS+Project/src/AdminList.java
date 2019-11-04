
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AdminList {
	private AdminNode head, tail;

	public AdminList() {
		this(null, null);
	}

	public AdminList(AdminNode head, AdminNode tail) {
		super();
		this.head = head;
		this.tail = tail;
	}

	public boolean isEmpty() {
		if (head == null) {
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings("unused")
	public boolean isFull() {
		AdminNode temp = new AdminNode();

		if (temp == null) {
			return true;
		} else {
			temp = null;
			return false;
		}
	}

	public void addToBack(Administrator data) {
		if (isFull()) {
			System.out.println("List is Full, unable to add item");
		} else {
			AdminNode nextItem = new AdminNode();
			nextItem.setData(data);

			if (isEmpty()) {
				head = nextItem;
				tail = nextItem;
			} else {
				tail.setNext(nextItem);
				tail = tail.getNext();
			}
		}
	}

	public void loadFiles() {
		if(isEmpty()) {
			try {
				File file = new File("placeList.txt");
				Scanner fileReader;
				fileReader = new Scanner(file);
				Administrator adminData = new Administrator();
				while(fileReader.hasNextLine()) {
					adminData.setPlaceID(fileReader.next());
					adminData.setPlaceName(fileReader.next());
					adminData.setPlaceDescription(fileReader.next());
					adminData.setPlaceAddress(fileReader.next());
					adminData.setPlaceParishCode(fileReader.next());
					adminData.setPlaceCost(fileReader.next());
					adminData.setPlaceOpeningHours(fileReader.next());
					adminData.setPlaceContact(fileReader.next());
					adminData.setPlacePhotoLink(fileReader.next());
					adminData.setPlaceMain(fileReader.next());
					
					addToBack(adminData);
				}
				fileReader.close();
				
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null,"Failed to read from file");
			}
		}
		else {
			//need to implement for when 
		}
	}
	
	public JTable display() {
		if (isEmpty()) {
			JOptionPane.showMessageDialog(null, "No places have been added to the system");
			return null;
		} else {
			Object[] columnNames = { "ID #", "Name", "Description", "Address", "Parish Code", "Cost", "Opening Hours",
					"Contact #", "Photo Link", "Main Attraction" };
			Object[][] rowData = {};
			DefaultTableModel tableModel = new DefaultTableModel(rowData, columnNames);

			AdminNode current = head;
			while (current != null) {
				Administrator data = current.getData();
				tableModel.addRow(new Object[] { data.getPlaceID(), data.getPlaceName(), data.getPlaceDescription(),
						data.getPlaceAddress(), data.getPlaceParishCode(), data.getPlaceCost(),
						data.getPlaceOpeningHours(), data.getPlaceContact(), data.getPlacePhotoLink(),
						data.getPlaceMain() });
				current = current.getNext();
			}

			JTable table = new JTable(tableModel);
			for(int i=0; i<10; i++) {
				table.getColumnModel().getColumn(i).setMinWidth(300);
			}
			table.setRowHeight(25);
			//scrollPane wont work without this
		    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			
			return table;
		}
	}

	public AdminNode getHead() {
		return head;
	}

	public void setHead(AdminNode head) {
		this.head = head;
	}

	public AdminNode getTail() {
		return tail;
	}

	public void setTail(AdminNode tail) {
		this.tail = tail;
	}

}
