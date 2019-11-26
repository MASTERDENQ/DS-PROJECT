/**
 * Written By :
 * Tyrone Wallace - 1706903
 * Dimitri Russell - 1801488
 * Reinaldo Peno - 1803640
 */

public class AdminNode {
	private Administrator data;
	private AdminNode next;
	
	public AdminNode() {
		this(new Administrator(""), null);
	}
	
	public AdminNode(Administrator data, AdminNode next) {
		super();
		this.data = data;
		this.next = next;
	}

	public Administrator getData() {
		return data;
	}

	public void setData(Administrator data) {
		this.data = data;
	}

	public AdminNode getNext() {
		return next;
	}

	public void setNext(AdminNode next) {
		this.next = next;
	}
}
