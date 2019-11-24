/**
 * Written By :
 * Tyrone Wallace - 1706903
 * Dimitri Russell - 1801488
 * Reinaldo Peno - 1803640
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VisitorStack {
	private VisitorNode head;

	VisitorStack() {
		head = null;
	}

	public void saveFiles() {
		if(!isEmpty()) {
			FileWriter rMade;
			try {
				File file = new File("processRequests.txt");
				rMade = new FileWriter(file, false);

				VisitorNode current = head;

				while (current != null) {
					Visitor data = current.getData();

					rMade.write(data.getReqID() + " " + data.getfName() + " " + data.getlName() + " "
							+ data.getEmail() + " " + data.getAttractionID() + " " + data.getAttractionName() + " "
							+ data.getMessage() + " " + data.getDateAndTime()+"\n");

					current = current.getNext();
				}
				rMade.close();
			} catch (IOException e) {
				JOptionPane.showConfirmDialog(null,
						"UNABLE TO STORE INFORMATION. " + "PLEASE CONTACT SYSTEM ADMINISTRATOR THANK YOU");
				e.printStackTrace();
			} // end of try and catch exception handling
		}
	}
	
	public void loadFiles(){
		try {
			File file = new File("processRequests.txt");
			if (file.exists()) {
				Scanner fileReader;
				fileReader = new Scanner(file);

				String reqID, fName, lName, email, attractionID, attractionName, message, dateAndTime;
				while (fileReader.hasNext()) {
					reqID = fileReader.next();
					fName = fileReader.next();
					lName = fileReader.next();
					email = fileReader.next();
					attractionID = fileReader.next();
					attractionName = fileReader.next();
					message = fileReader.next();
					dateAndTime = fileReader.next();

					Visitor visitorData = new Visitor(reqID, fName, lName, email, attractionID, attractionName, message,
							dateAndTime);

					push(visitorData);
				}
				fileReader.close();
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Failed to read from file");
		}
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
		VisitorNode temp = new VisitorNode();

		if (temp == null) {
			return true;
		} else {
			temp = null;
			return false;
		}
	}

	public void push(Visitor data) {
		if (isFull()) {
			JOptionPane.showMessageDialog(null, "Unable to add data to stack");
		} else {
			VisitorNode nextItem = new VisitorNode();
			nextItem.setData(data);

			if (isEmpty()) {
				head = nextItem;
			} else {
				nextItem.setNext(head);
				head = nextItem;
			}
		}
	}

	public JTable display() {
		if (!isEmpty()) {
			Object[] columnNames = { "Request ID", "First Name", "Last Name", "Email", "Attraction ID",
					"Attraction Name", "Message", "Date and Time" };
			Object[][] rowData = {};
			DefaultTableModel tableModel = new DefaultTableModel(rowData, columnNames);

			VisitorNode current = head;
			while (current != null) {
				Visitor data = current.getData();

				tableModel.addRow(new Object[] { data.getReqID(), data.getfName(), data.getlName(), data.getEmail(),
						data.getAttractionID(), data.getAttractionName(), data.getMessage(), data.getDateAndTime() });

				current = current.getNext();
			}
			

			JTable table = new JTable(tableModel);
			for (int i = 0; i < 8; i++) {
				table.getColumnModel().getColumn(i).setMinWidth(200);
			}
			table.setRowHeight(25);
			// scrollPane wont work without this
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

			return table;
		}
		
		return null;
	}
}
