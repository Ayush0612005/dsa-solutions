/*
LeetCode 622 - Design Circular Queue

Difficulty: Medium

Approach:
- Implement a circular queue using an array.
- Maintain:
  - head: index of the front element.
  - tail: index of the rear element.
  - size: current number of elements.
  - capacity: maximum queue size.
- Use modulo (%) arithmetic to wrap around the array.
- Operations:
  - enQueue: Insert at the rear if the queue is not full.
  - deQueue: Remove the front element if the queue is not empty.
  - Front: Return the front element.
  - Rear: Return the rear element.
  - isEmpty: Check if the queue has no elements.
  - isFull: Check if the queue has reached its capacity.

Time Complexity:
- enQueue()  : O(1)
- deQueue()  : O(1)
- Front()    : O(1)
- Rear()     : O(1)
- isEmpty()  : O(1)
- isFull()   : O(1)

Space Complexity: O(k)
where k is the queue capacity.
*/

class MyCircularQueue {

    private int[] queue;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    public MyCircularQueue(int k) {

        capacity = k;
        queue = new int[k];

        head = 0;
        tail = -1;
        size = 0;
    }

    public boolean enQueue(int value) {

        if (isFull()) {
            return false;
        }

        tail = (tail + 1) % capacity;
        queue[tail] = value;
        size++;

        return true;
    }

    public boolean deQueue() {

        if (isEmpty()) {
            return false;
        }

        head = (head + 1) % capacity;
        size--;

        return true;
    }

    public int Front() {

        if (isEmpty()) {
            return -1;
        }

        return queue[head];
    }

    public int Rear() {

        if (isEmpty()) {
            return -1;
        }

        return queue[tail];
    }

    public boolean isEmpty() {

        return size == 0;
    }

    public boolean isFull() {

        return size == capacity;
    }
}

/*
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
