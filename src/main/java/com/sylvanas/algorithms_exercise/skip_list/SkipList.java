package com.sylvanas.algorithms_exercise.skip_list;

import java.util.NoSuchElementException;
import java.util.Random;

/**
 * A skip list is a data structure that allows fast search within
 * an ordered sequence of elements. Fast search is made possible
 * by maintaining a linked hierarchy of subsequences, with each
 * successive subsequence skipping over fewer elements than the
 * previous one. Searching starts in the sparsest subsequence until
 * two consecutive elements have been found, one smaller and one larger
 * than or equal to the element searched for.
 * <p>
 * cite: <a href="https://en.wikipedia.org/wiki/Skip_list">Skip List - Wikipedia</a>
 * <br>
 *
 * @author SylvanasSun <sylvanas.sun@gmail.com>
 */
public class SkipList<K extends Comparable<K>, V> {

    protected static final Random randomGenerator = new Random();

    protected static final double DEFAULT_PROBABILITY = 0.5;

    private Node<K, V> head;

    private double probability;

    private int size;

    public SkipList() {
        this(DEFAULT_PROBABILITY);
    }

    public SkipList(double probability) {
        this.head = new Node<K, V>(null, null, 0);
        this.probability = probability;
        this.size = 0;
    }

    public V get(K key) {
        checkKeyValidity(key);
        Node<K, V> node = findNode(key);
        if (node.getKey().compareTo(key) == 0)
            return node.getValue();
        else
            return null;
    }

    public void add(K key, V value) {
        checkKeyValidity(key);
        Node<K, V> node = findNode(key);
        if (node.getKey() != null && node.getKey().compareTo(key) == 0) {
            node.setValue(value);
            return;
        }

        Node<K, V> newNode = new Node<K, V>(key, value, node.getLevel());
        horizontalInsert(node, newNode);
        // Decide level according to the probability function
        int temporaryLevel = 0;
        int headLevel = head.getLevel();
        while (isBuildLevel()) {
            // buiding a new level
            if (temporaryLevel >= headLevel) {
                Node<K, V> newHead = new Node<K, V>(null, null, headLevel + 1);
                verticalLink(newHead, head);
                head = newHead;
                headLevel = head.getLevel();
            }
            // copy node and newNode to the upper level
            while (node.getUp() == null) {
                node = node.getPrevious();
            }
            node = node.getUp();

            Node<K, V> tmp = new Node<K, V>(key, value, node.getLevel());
            horizontalInsert(node, tmp);
            verticalLink(tmp, newNode);
            newNode = tmp;
            temporaryLevel++;
        }
        size++;
    }

    public void remove(K key) {
        checkKeyValidity(key);
        Node<K, V> node = findNode(key);
        if (node == null || node.getKey().compareTo(key) != 0)
            throw new NoSuchElementException("The key is not exist!");

        // Because node is on the lowest level so we need remove by down-top
        Node<K, V> prev = null;
        Node<K, V> next = null;
        for (; node != null; node = node.getUp()) {
            prev = node.getPrevious();
            next = node.getNext();
            if (prev != null)
                prev.setNext(next);
            if (next != null)
                next.setPrevious(prev);
        }

        // Adjust head
        while (head.getNext() == null && head.getDown() != null) {
            head = head.getDown();
            head.setUp(null);
        }
        size--;
    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    protected Node<K, V> findNode(K key) {
        Node<K, V> node = head;
        Node<K, V> next = null;
        Node<K, V> down = null;

        while (true) {
            // Searching nearest (less than or equal) node with special key
            next = node.getNext();
            while (next != null && lessThanOrEqual(next.getKey(), key)) {
                node = next;
                next = node.getNext();
            }
            // Descend to the bottom for continue search
            down = node.getDown();
            if (down != null) {
                node = down;
            } else {
                break;
            }
        }

        return node;
    }

    protected void checkKeyValidity(K key) {
        if (key == null)
            throw new IllegalArgumentException("Key must be not null!");
    }

    protected boolean lessThanOrEqual(K a, K b) {
        return a.compareTo(b) <= 0;
    }

    protected boolean isBuildLevel() {
        return randomGenerator.nextDouble() < probability;
    }

    protected void horizontalInsert(Node<K, V> x, Node<K, V> y) {
        y.setPrevious(x);
        y.setNext(x.getNext());
        if (x.getNext() != null)
            x.getNext().setPrevious(y);
        x.setNext(y);
    }

    protected void verticalLink(Node<K, V> x, Node<K, V> y) {
        x.setDown(y);
        y.setUp(x);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<K, V> node = head;

        // Move into the lower left bottom
        while (node.getDown() != null)
            node = node.getDown();

        while (node.getPrevious() != null)
            node = node.getPrevious();

        // Head node with each level the key is null
        // so need to move into the next node
        if (node.getNext() != null)
            node = node.getNext();

        while (node != null) {
            sb.append(node.toString()).append("\n");
            node = node.getNext();
        }

        return sb.toString();
    }

    protected static class Node<K extends Comparable<K>, V> {

        private K key;

        private V value;

        private int level;

        private Node<K, V> up, down, next, previous;

        public Node(K key, V value, int level) {
            this.key = key;
            this.value = value;
            this.level = level;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Node[")
                    .append("key:");
            if (this.key == null)
                sb.append("None");
            else
                sb.append(this.key.toString());

            sb.append(" value:");
            if (this.value == null)
                sb.append("None");
            else
                sb.append(this.value.toString());
            sb.append("]");
            return sb.toString();
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public Node<K, V> getUp() {
            return up;
        }

        public void setUp(Node<K, V> up) {
            this.up = up;
        }

        public Node<K, V> getDown() {
            return down;
        }

        public void setDown(Node<K, V> down) {
            this.down = down;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }

        public Node<K, V> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<K, V> previous) {
            this.previous = previous;
        }
    }

    public static void main(String[] args) {
        SkipList<Integer, String> skipList = new SkipList<>();
        for (int i = 0; i < 10; i++) {
            skipList.add(i, String.valueOf(i));
        }
        assert skipList.size() == 10;
        assert !skipList.empty();
        assert !skipList.contains(11);
        assert skipList.get(5).equals("5");
        skipList.remove(9);
        assert skipList.size() == 9;
        assert skipList.get(9) == null;
        skipList.remove(8);
        skipList.remove(7);
        skipList.remove(6);
        skipList.remove(5);
        skipList.remove(4);
        skipList.remove(3);
        skipList.remove(2);
        skipList.remove(1);
        skipList.remove(0);
        assert skipList.size() == 0;
        assert skipList.empty();
    }

}
