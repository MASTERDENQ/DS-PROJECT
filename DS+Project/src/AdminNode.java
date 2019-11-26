/**
 * Written By :
 * Tyrone Wallace - 1706903
 * Dimitri Russell - 1801488
 * Reinaldo Peno - 1803640
 */

//class: O(1)
public class AdminNode {
	private Administrator data;
	private AdminNode next;
	
	//function: O(1)
	public AdminNode() {
		this(new Administrator(""), null);
	}
	
	//function: O(1)
	public AdminNode(Administrator data, AdminNode next) {
		super();
		this.data = data;
		this.next = next;
	}

	//function: O(1)
	public Administrator getData() {
		return data;
	}

	//function: O(1)
	public void setData(Administrator data) {
		this.data = data;
	}

	//function: O(1)
	public AdminNode getNext() {
		return next;
	}

	//function: O(1)
	public void setNext(AdminNode next) {
		this.next = next;
	}
}
