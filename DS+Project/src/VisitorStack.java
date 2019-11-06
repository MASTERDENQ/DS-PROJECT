import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class VisitorStack {
	VisitorNode head;

	VisitorStack() {
		head = null;
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
