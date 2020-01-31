package greedy_algoritm;

import java.util.List;

public class MyPriorityQueue {
    public final List<Integer> data;

    MyPriorityQueue(List<Integer> other) {
        data = other;
    }

    private void siftDown(int index) {
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;
        int maxChild;
        if (leftChild > data.size() - 1) {
            return;
        }
        if (rightChild > data.size() - 1) {
            maxChild = leftChild;
        } else {
            maxChild = data.get(leftChild) > data.get(rightChild) ? leftChild : rightChild;
        }
        int temp = data.get(index);
        if (temp < data.get(maxChild)) {
            data.set(index, data.get(maxChild));
            data.set(maxChild, temp);
            siftDown(maxChild);
        }
    }

    private void siftUp(int index) {
        if (index == 0) {
            return;
        }

        int nodeIndex = index;
        int parentIndex = nodeIndex % 2 == 0 ? nodeIndex / 2 - 1 : nodeIndex / 2;
        while (data.get(nodeIndex) > data.get(parentIndex)) {
            int temp = data.get(nodeIndex);
            data.set(nodeIndex, data.get(parentIndex));
            data.set(parentIndex, temp);
            nodeIndex = parentIndex;
            if (nodeIndex == 0) {
                return;
            }
            parentIndex = nodeIndex % 2 == 0 ? nodeIndex / 2 - 1 : nodeIndex / 2;
        }
    }

    public void Insert(int value) {
        data.add(value);
        siftUp(data.size() - 1);
    }

    public int ExtractMax() {
        int result = data.get(0);
        data.set(0, data.get(data.size() - 1));
        data.remove(data.size() - 1);
        siftDown(0);
        return result;
    }
}
