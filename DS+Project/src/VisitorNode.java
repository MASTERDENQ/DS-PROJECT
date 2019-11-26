/**
 * Written By :
 * Tyrone Wallace - 1706903
 * Dimitri Russell - 1801488
 * Reinaldo Peno - 1803640
 */

//class: O(1)
public class VisitorNode {
	private Visitor data;
	private VisitorNode next;
	
	//function: O(1)
	public VisitorNode() {
		this(new Visitor(""), null);
	}

	//function: O(1)
	public VisitorNode(Visitor data, VisitorNode next) {
		super();
		this.data = data;
		this.next = next;
	}

	//function: O(1)
	public Visitor getData() {
		return data;
	}

	//function: O(1)
	public void setData(Visitor data) {
		this.data = data;
	}

	//function: O(1)
	public VisitorNode getNext() {
		return next;
	}

	//function: O(1)
	public void setNext(VisitorNode next) {
		this.next = next;
	}
}
