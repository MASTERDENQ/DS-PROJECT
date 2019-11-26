/**
 * Written By :
 * Tyrone Wallace - 1706903
 * Dimitri Russell - 1801488
 * Reinaldo Peno - 1803640
 */

public class VisitorNode {
	private Visitor data;
	private VisitorNode next;
	
	public VisitorNode() {
		this(new Visitor(""), null);
	}

	public VisitorNode(Visitor data, VisitorNode next) {
		super();
		this.data = data;
		this.next = next;
	}

	public Visitor getData() {
		return data;
	}

	public void setData(Visitor data) {
		this.data = data;
	}

	public VisitorNode getNext() {
		return next;
	}

	public void setNext(VisitorNode next) {
		this.next = next;
	}
}
