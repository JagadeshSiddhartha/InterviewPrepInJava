package AdvancedDS;

import java.util.Arrays;

public class MinHeapImpl {
    int SIZE = 0;
    int CAPACITY = 2;
    int heap[] = new int[CAPACITY];

    int getLeftChildIndex(int index) {return 2 * index + 1;}
    int getRightChildIndex(int index) {return 2 * index + 2;}
    int getParentIndex(int index) { return (index - 1) / 2;}

    boolean hasLeftChild(int index) { return (getLeftChildIndex(index) < SIZE);}
    boolean hasRightChild(int index) { return (getRightChildIndex(index) < SIZE);}
    boolean hasParent(int index) { return (getParentIndex(index) > 0);}

    int leftChild(int index) { return heap[getLeftChildIndex(index)];}
    int rightChild(int index) { return heap[getRightChildIndex(index)];}
    int parent(int index) { return heap[getParentIndex(index)];}

    void swap (int first, int second) {
        int temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }

    void ensureCapacity() {
        if(SIZE == CAPACITY) {
            heap = Arrays.copyOf(heap, SIZE*2);
            CAPACITY *= 2;
        }
    }

    int peek() {
        if(SIZE == 0) {
            throw new IllegalStateException();
        }
        return heap[0];
    }

    int poll() {
        if(SIZE == 0) {
            throw new IllegalStateException();
        }
        int item = heap[0];
        heap[0] = heap[SIZE - 1];
        SIZE --;
        heapifyDown();
        return item;
    }

    void add(int item) {
        ensureCapacity();
        heap[SIZE] = item;
        SIZE ++;
        heapifyUp();
    }

    void heapifyDown() {
        int index = 0;
        while(hasLeftChild(index)) {
            int smallerIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerIndex = getRightChildIndex(index);
            }
            if(heap[index] < heap[smallerIndex]) {
                break;
            } else {
                swap(index, smallerIndex);
            }
            index = smallerIndex;
        }
    }

    void heapifyUp(){
        int index = SIZE - 1;
        while(hasParent(index) && parent(index) > heap[index]) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    public static void main(String[] args) {
        MinHeapImpl minHeap = new MinHeapImpl();
        minHeap.add(5);
        minHeap.add(2);
        minHeap.add(7);
        minHeap.add(9);
        minHeap.add(125);
        minHeap.add(124);
        minHeap.add(1);
        //for(int i:minHeap.heap) {System.out.print(i + " ");}
        System.out.println(minHeap.poll());
        //for(int i:minHeap.heap) {System.out.print(i + " ");}
        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());
    }
}
