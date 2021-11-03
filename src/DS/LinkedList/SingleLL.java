package DS.LinkedList;

class ListNode {
	int val;
	ListNode next;

	public ListNode(int val, ListNode node) {
		this.val = val;
		this.next = node;
	}

}

public class SingleLL {

	private static ListNode head = null;
	private static ListNode lastNode = null;

	public static void add(int val) {
		ListNode newNode = new ListNode(val, null);
		if (head == null) {
			head = newNode;
			lastNode = head;
		} else {
			lastNode.next = newNode;
			lastNode = lastNode.next;
		}
	}

	public static void display() {
		ListNode curr = head;
		while (curr != null) {
			System.out.print(curr.val);
			if (curr.next != null)
				System.out.print("->");
			curr = curr.next;
		}
	}

	public static void remove(int val) {
		ListNode curr = head;
		if (curr.val == val) {
			head = head.next;
		} else {
			while(curr.next!=null) {
				if(curr.next.val == val) {
					
				}
			}
		}
	}

	public static void main(String[] args) {
		add(1);
		add(2);
		add(3);
		add(4);
		display();
	}

}
