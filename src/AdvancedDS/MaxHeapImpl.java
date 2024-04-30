package AdvancedDS;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaxHeapImpl {
    private int CAPACITY = 10;
    private int SIZE = 0;
    private int heap[] = new int[CAPACITY];

    private int getLeftChildIndex(int index) {return 2 * index + 1;}
    private int getRightChildIndex(int index) {return 2 * index + 2;}
    private int getParentIndex(int index) {return (index - 1) / 2;}

    private boolean hasLeftChild(int index) { return 2 * index + 1 < SIZE;}
    private boolean hasRightChild(int index) { return 2 * index + 2 < SIZE;}
    private boolean hasParent(int index) { return (index - 1)/2 < SIZE;}

    private int getLeftChild(int index) {return heap[getLeftChildIndex(index)];}
    private int getRightChild(int index) { return heap[getRightChildIndex(index)];}
    private int getParent(int index) { return heap[getParentIndex(index)];}

    private void swap(int first, int second) {
        int temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }


    private void ensureCapaity() {
        if(SIZE == CAPACITY) {
            heap = Arrays.copyOf(heap, SIZE *2);
            CAPACITY *= 2;
        }
    }

    void add(int item) {
        ensureCapaity();
        heap[SIZE] = item;
        SIZE++;
        heapifyUp();
    }

    int peek() {
        if(SIZE == 0) throw new IllegalStateException();
        return heap[SIZE];
    }

    int poll() {
        if(SIZE == 0) throw new IllegalStateException();
        int item = heap[0];
        heap[0] = heap[SIZE - 1];
        SIZE--;
        heapifyDown();
        return item;
    }

    void heapifyUp() {
        int index = SIZE - 1;
        while(hasParent(index) && getParent(getParentIndex(index)) < heap[index]) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    void heapifyDown() {
        int index = 0;
        while(hasLeftChild(index)) {
            int biggerIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && getRightChild(getRightChildIndex(index)) > heap[biggerIndex]) {
                biggerIndex = getRightChildIndex(index);
            }
            if(heap[index] < heap[biggerIndex]) {
                swap(index, biggerIndex);
            } else {
                break;
            }
            index = biggerIndex;
        }
    }

    public static void main(String[] args) {
        MaxHeapImpl maxHeap = new MaxHeapImpl();
        maxHeap.add(2);
        maxHeap.add(3);
        maxHeap.add(8);
        maxHeap.add(12);
        maxHeap.add(9);
        maxHeap.add(11);

        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());

    }
}
