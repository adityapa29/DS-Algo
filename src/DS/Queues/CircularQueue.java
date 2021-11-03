package DS.Queues;

public class CircularQueue {
	
	int front=-1, rear=-1;
	int[] cq;
	
	public CircularQueue(int size) {
		cq = new int[size];
	}
	
	private boolean isEmpty() {
		if(front == -1 && rear == -1) return true;
		else return false;
	}
	
	public void offer(int item) {
		int size = cq.length;
		
		if((rear+1) % size == front) {
			System.out.println("Queue is full...");
			return;
		}
		if(isEmpty()) {
			front=0; rear=0;
		} else {
			rear = (rear+1) % size;
		}
		cq[rear] = item;
		System.out.println("Inserted "+item+" into the queue...");
	}
	
	public void poll() {
		int size = cq.length;
		
		if(isEmpty()) {
			System.out.println("Queue is empty...");
			return;
		}
		if(front == rear) {
			System.out.println("Popped out: "+cq[front]);
			front=-1; rear=-1;
		} else {
			System.out.println("Popped out: "+cq[front]);
			front = (front+1) % size;
		}
	}

	public static void main(String[] args) {
		CircularQueue circularQueue = new CircularQueue(5);
		circularQueue.offer(10);
		circularQueue.offer(20);
		circularQueue.offer(30);
		circularQueue.offer(40);
		circularQueue.offer(50);
		circularQueue.offer(60);
		circularQueue.poll();
		circularQueue.offer(60);
	}

}
