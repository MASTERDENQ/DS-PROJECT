/**
 * Written By :
 * Tyrone Wallace - 1706903
 * Dimitri Russell - 1801488
 * Reinaldo Peno - 1803640
 */

//class: O(1)
public class LeafNode {
	
	private int key, fileLine, height;
	private LeafNode left, right;

	//function: O(1)
	public LeafNode(int k) {
		key = k;
		fileLine = k - 99;
		height = 1;
	}
	
	//function: O(1)
	public int getKey() {
		return key;
	}

	//function: O(1)
	public void setKey(int key) {
		this.key = key;
	}

	//function: O(1)
	public int getFileLine() {
		return fileLine;
	}

	//function: O(1)
	public void setFileLine(int fileLine) {
		this.fileLine = fileLine;
	}

	//function: O(1)
	public int getHeight() {
		return height;
	}

	//function: O(1)
	public void setHeight(int height) {
		this.height = height;
	}

	//function: O(1)
	public LeafNode getLeft() {
		return left;
	}

	//function: O(1)
	public void setLeft(LeafNode left) {
		this.left = left;
	}

	//function: O(1)
	public LeafNode getRight() {
		return right;
	}

	//function: O(1)
	public void setRight(LeafNode right) {
		this.right = right;
	}
}
