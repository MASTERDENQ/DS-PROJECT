import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VisitorList {
	private VisitorNode head, tail;

	public VisitorList() {
		this(null, null);
	}

	public VisitorList(VisitorNode head, VisitorNode tail) {
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
		VisitorNode temp = new VisitorNode();

		if (temp == null) {
			return true;
		} else {
			temp = null;
			return false;
		}
	}

	public void enqueue(Visitor data) {
		if (isFull()) {
			JOptionPane.showMessageDialog(null, "List is Full, unable to add item");
		} else {
			VisitorNode nextItem = new VisitorNode();
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
		if (isEmpty()) {
			try {
				File file = new File("requestMade.txt");
				Scanner fileReader;
				fileReader = new Scanner(file);
				Visitor visitorData = new Visitor();
				while (fileReader.hasNextLine()) {
					String reqID = fileReader.next();
					String fName = fileReader.next();
					String lName = fileReader.next();
					String email = fileReader.next();
					String attractionID = fileReader.next();
					String attractionName = fileReader.next();
					String message = fileReader.next();
					String dateAndTime = fileReader.next();

					visitorData = new Visitor(reqID, fName, lName, email, attractionID, attractionName, message,
							dateAndTime);

					enqueue(visitorData);
				}
				fileReader.close();

			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Failed to read from file");
			}
		} else {

		}
	}

	public JTable display() {
		if (isEmpty()) {
			JOptionPane.showMessageDialog(null, "No places have been added to the system");
			return null;
		} else {
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
				table.getColumnModel().getColumn(i).setMinWidth(300);
			}
			table.setRowHeight(25);
			// scrollPane wont work without this
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

			return table;
		}
	}

	public VisitorNode getHead() {
		return head;
	}

	public void setHead(VisitorNode head) {
		this.head = head;
	}

	public VisitorNode getTail() {
		return tail;
	}

	public void setTail(VisitorNode tail) {
		this.tail = tail;
	}

}
