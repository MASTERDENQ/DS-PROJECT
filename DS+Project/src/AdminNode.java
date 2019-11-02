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

	@Override
	public String toString() {
		return "AdminNode [data=" + data + ", next=" + next + "]";
	}
	
	public void display() {
		System.out.println(toString());
	}
}
