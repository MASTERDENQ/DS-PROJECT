/**
 * Written By :
 * Tyrone Wallace - 1706903
 * Dimitri Russell - 1801488
 * Reinaldo Peno - 1803640
 */

public class LeafNode {
	private int key, fileLine, height;
	private LeafNode left, right;

	public LeafNode(int k) {
		key = k;
		fileLine = k - 99;
		height = 1;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getFileLine() {
		return fileLine;
	}

	public void setFileLine(int fileLine) {
		this.fileLine = fileLine;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public LeafNode getLeft() {
		return left;
	}

	public void setLeft(LeafNode left) {
		this.left = left;
	}

	public LeafNode getRight() {
		return right;
	}

	public void setRight(LeafNode right) {
		this.right = right;
	}
}
