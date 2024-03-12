import java.util.ArrayList;
import java.util.List;

public class PowerOfTwoMaxHeap<T extends Comparable<T>> {
    private List<T> heap;
    private int childDegree;

    public PowerOfTwoMaxHeap(int childDegree) {
        this.heap = new ArrayList<>();
        this.childDegree = childDegree;
    }

    public void insert(T element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }

    public T popMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty.");
        }

        T maxElement = heap.get(0);
        T lastElement = heap.remove(heap.size() - 1);

        if (!isEmpty()) {
            heap.set(0, lastElement);
            heapifyDown(0);
        }

        return maxElement;
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / childDegree;

        while (index > 0 && heap.get(index).compareTo(heap.get(parentIndex)) > 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / childDegree;
        }
    }

    private void heapifyDown(int index) {
        int maxChildIndex = findMaxChildIndex(index);

        while (maxChildIndex != -1 && heap.get(index).compareTo(heap.get(maxChildIndex)) < 0) {
            swap(index, maxChildIndex);
            index = maxChildIndex;
            maxChildIndex = findMaxChildIndex(index);
        }
    }

    private int findMaxChildIndex(int index) {
        int startChildIndex = index * childDegree + 1;
        int endChildIndex = Math.min(startChildIndex + childDegree, heap.size());

        if (startChildIndex >= heap.size()) {
            return -1;
        }

        int maxChildIndex = startChildIndex;
        for (int i = startChildIndex + 1; i < endChildIndex; i++) {
            if (heap.get(i).compareTo(heap.get(maxChildIndex)) > 0) {
                maxChildIndex = i;
            }
        }

        return maxChildIndex;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public static void main(String[] args) {
        PowerOfTwoMaxHeap<Integer> heap = new PowerOfTwoMaxHeap<>(2);

        heap.insert(10);
        heap.insert(25);
        heap.insert(15);
        heap.insert(20);

        while (!heap.isEmpty()) {
            System.out.println(heap.popMax());
        }
    }
}
