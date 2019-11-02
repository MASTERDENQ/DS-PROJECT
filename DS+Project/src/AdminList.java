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
		if(head == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@SuppressWarnings("unused")
	public boolean isFull() {
		AdminNode temp = new AdminNode();
		
		if(temp == null) {
			return true;
		}
		else {
			temp = null;
			return false;
		}
	}
	
	public void insert(Administrator data) {
		if(isFull()) {
			System.out.println("List is Full, unable to add item");
		}
		else {
			AdminNode nextItem = new AdminNode();
			nextItem.setData(data);
			
			if(isEmpty()) {
				head = nextItem;
				tail = nextItem;
			}
			else {
				tail.setNext(nextItem);
				tail = tail.getNext();
			}
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
