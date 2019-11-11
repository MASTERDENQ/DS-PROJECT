
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
			JOptionPane.showMessageDialog(null, "List is Full, unable to add item");
		} else {
			AdminNode nextItem = new AdminNode();
			nextItem.setData(data);

			if (isEmpty()) {
				head = nextItem;
				tail = nextItem;
			} else {
				tail.setNext(nextItem);
				tail = nextItem;
			}
		}
	}

	public void saveToSubFile(String parishCode, Administrator adminData) {
		try {
			File file = new File(parishCode + ".txt");
			
			FileWriter fileWriter = new FileWriter(file, true);

			fileWriter.write(adminData.getPlaceID() + " " + adminData.getPlaceName() + " "
					+ adminData.getPlaceDescription() + " " + adminData.getPlaceAddress() + " "
					+ adminData.getPlaceParishCode() + " " + adminData.getPlaceCost() + " "
					+ adminData.getPlaceOpeningHours() + " " + adminData.getPlaceContact() + " "
					+ adminData.getPlacePhotoLink() + " " + adminData.getPlaceMain()+"\n");

			fileWriter.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error saving to sub-file");
		}
	}

	public void saveFiles(AdminNode pastTail) {
		try {
			File file = new File("placeList.txt");
			
			FileWriter fileWriter = new FileWriter(file, true);

			AdminNode current = pastTail.getNext();
			while (current != null) {
				Administrator adminData = current.getData();

				fileWriter.write(adminData.getPlaceID() + " " + adminData.getPlaceName() + " "
						+ adminData.getPlaceDescription() + " " + adminData.getPlaceAddress() + " "
						+ adminData.getPlaceParishCode() + " " + adminData.getPlaceCost() + " "
						+ adminData.getPlaceOpeningHours() + " " + adminData.getPlaceContact() + " "
						+ adminData.getPlacePhotoLink() + " " + adminData.getPlaceMain()+"\n");

				saveToSubFile(adminData.getPlaceParishCode(), adminData);

				current = current.getNext();
			}

			fileWriter.close();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error saving to file");
		}
	}

	public void loadFiles() {
		try {
			File file = new File("placeList.txt");
			if (file.exists()) {
				Scanner fileReader;
				fileReader = new Scanner(file);
				Administrator adminData = new Administrator();
				while (fileReader.hasNext()) {
					String placeID = fileReader.next();
					String placeName = fileReader.next();
					String placeDescription = fileReader.next();
					String placeAddress = fileReader.next();
					String placeParishCode = fileReader.next();
					String placeCost = fileReader.next();
					String placeOpeningHours = fileReader.next();
					String placeContact = fileReader.next();
					String placePhotoLink = fileReader.next();
					String placeMain = fileReader.next();

					adminData = new Administrator(placeID, placeName, placeDescription, placeAddress, placeParishCode,
							placeCost, placeOpeningHours, placeContact, placePhotoLink, placeMain);

					addToBack(adminData);
				}
				fileReader.close();
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Failed to read from file");
		}
	}

	public String getParishName(String parishCode) {
		int choice = Integer.parseInt(parishCode);
		String parish = "";

		switch (choice) {
		case 1:
			parish = "Kingston & St. Andrew";
			break;

		case 2:
			parish = "St. Thomas";
			break;
		case 3:
			parish = "Portland";
			break;
		case 4:
			parish = "St. Mary";
			break;
		case 5:
			parish = "St. Catherine";
			break;
		case 6:
			parish = "Clarendon";
			break;
		case 7:
			parish = "Manchester";
			break;
		case 8:
			parish = "St. Ann";
			break;
		case 9:
			parish = "St. Elizabeth";
			break;
		case 10:
			parish = "St. James";
			break;
		case 11:
			parish = "Hanover";
			break;
		case 12:
			parish = "Westmoreland";
			break;
		case 13:
			parish = "Trelawny";
			break;
		}

		return parish;
	}

	public JTable display() {
		if (!isEmpty()) {
			Object[] columnNames = { "ID #", "Name", "Description", "Address", "Parish Code", "Cost", "Opening Hours",
					"Contact #", "Photo Link", "Main Attraction" };
			Object[][] rowData = {};
			DefaultTableModel tableModel = new DefaultTableModel(rowData, columnNames);

			AdminNode current = head;
			while (current != null) {
				Administrator data = current.getData();
				tableModel.addRow(new Object[] { data.getPlaceID(), data.getPlaceName(), data.getPlaceDescription(),
						data.getPlaceAddress(), getParishName(data.getPlaceParishCode()), data.getPlaceCost(),
						data.getPlaceOpeningHours(), data.getPlaceContact(), data.getPlacePhotoLink(),
						data.getPlaceMain() });

				current = current.getNext();
			}

			JTable table = new JTable(tableModel);
			for (int i = 0; i < 10; i++) {
				table.getColumnModel().getColumn(i).setMinWidth(200);
			}
			table.setRowHeight(25);
			// scrollPane wont work without this
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

			return table;
		}

		return null;
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
