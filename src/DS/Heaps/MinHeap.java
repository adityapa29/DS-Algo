package DS.Heaps;

import java.util.Arrays;

public class MinHeap {
	
	int capacity = 10;
	int size = 0;
	int[] items = new int[capacity];
	
	private int getParentIndex(int childIndex) { return (childIndex-1)/2; }
	private int getLeftChildIndex(int parentIndex) { return (2*parentIndex)+1; } 
	private int getRightChildIndex(int parentIndex) { return (2*parentIndex)+2; }
	
	private boolean hasParent(int childIndex) {return getParentIndex(childIndex) >=0; }
	private boolean hasLeftChild(int parentIndex) { return getLeftChildIndex(parentIndex) < size; }
	private boolean hasRightChild(int parentIndex) { return getRightChildIndex(parentIndex) < size; }
	
	private void swap(int index1, int index2) {
		int temp = items[index1];
		items[index1] = items[index2];
		items[index2] = temp;
	}
	
	private void ensureCapacity() {
		if(size == capacity) {
		items = Arrays.copyOf(items, capacity*2);
		capacity *= 2;
		}
	}
	
	public int peek() {
		if(size==0) {
			System.out.println("Heap is empty..");
			return -1;
		}
		
		return items[0];
	}
	
	public void offer(int item) {
		ensureCapacity();
		items[size] = item;
		size++;
		heapifyUp();
	}
	
	public int poll() {
		if(size==0) {
			System.out.println("Heap is empty..");
			return -1;
		}
		
		int item = items[0];
		items[0] = items[size-1]; 
		size--;
		heapifyDown();
		return item;
	}
	
	private void heapifyUp() {
		int index = size-1;
		while(hasParent(index) && items[getParentIndex(index)] > items[index]) {
			swap(index,getParentIndex(index));
			index = getParentIndex(index);
		}
	}
	
	private void heapifyDown() {
		int index = 0;
		
		while(hasLeftChild(index)) {
			int smallerChild = getLeftChildIndex(index);
			if(hasRightChild(index) && items[getRightChildIndex(index)] < items[smallerChild]) {
				smallerChild = getRightChildIndex(index);
			}
	        if(items[smallerChild] < items[index]) {
	        	swap(smallerChild,index);
	        } else break;
	        
	        index = smallerChild;
		}
	}
	
	public static void main(String[] args) {
		
		MinHeap mh = new MinHeap();
		mh.offer(40);
		mh.offer(50);
		mh.offer(30);
		System.out.println(Arrays.toString(mh.items));
		System.out.println("Peak : "+mh.peek());
		System.out.println("Poll : "+mh.poll());
		System.out.println(Arrays.toString(mh.items));
		mh.offer(25);
		mh.offer(37);
		mh.offer(35);
		mh.offer(12);
		System.out.println(Arrays.toString(mh.items));
		System.out.println("Peak : "+mh.peek());
		System.out.println("Poll : "+mh.poll());
		System.out.println("Peak : "+mh.peek());
		System.out.println("Poll : "+mh.poll());
		System.out.println("Peak : "+mh.peek());
		System.out.println("Poll : "+mh.poll());
		System.out.println("Peak : "+mh.peek());
		System.out.println("Poll : "+mh.poll());
		System.out.println("Peak : "+mh.peek());
		System.out.println("Poll : "+mh.poll());
		System.out.println(Arrays.toString(mh.items));
		System.out.println("Peak : "+mh.peek());
		System.out.println("Poll : "+mh.poll());
		System.out.println("Peak : "+mh.peek());
		System.out.println("Poll : "+mh.poll());
		System.out.println("Peak : "+mh.peek());
		System.out.println("Poll : "+mh.poll());
		mh.offer(50);
		mh.offer(40);
		mh.offer(30);
		mh.offer(20);
		mh.offer(10);
		System.out.println(Arrays.toString(mh.items));
		System.out.println("Peak : "+mh.peek());
		System.out.println("Poll : "+mh.poll());
		System.out.println("Peak : "+mh.peek());
		System.out.println("Poll : "+mh.poll());
		System.out.println("Peak : "+mh.peek());
		System.out.println("Poll : "+mh.poll());
		System.out.println("Peak : "+mh.peek());
		System.out.println("Poll : "+mh.poll());
		System.out.println("Peak : "+mh.peek());
		System.out.println("Poll : "+mh.poll());
		System.out.println(Arrays.toString(mh.items));

	}

}
