package org.example.impl;

import org.example.exceptions.InvalidIndexException;
import org.example.exceptions.NullItemException;
import org.example.exceptions.NullObjectException;
import org.example.interfaces.SimpleArrayList;

import java.util.Arrays;


public class SimpleArrayListImpl implements SimpleArrayList {

    private int size = 0;
    private static final Integer DEFAULT_CAPACITY = 10;
    private Integer[] elements;

    public SimpleArrayListImpl() {
        this.elements = new Integer[DEFAULT_CAPACITY];
    }

    public SimpleArrayListImpl(Integer[] elements) {
        this.elements = Arrays.copyOf(elements, elements.length);
        this.size = elements.length;
    }

    public SimpleArrayListImpl(int initialCapacity) {
        elements = new Integer[initialCapacity];
    }

    @Override
    public Integer add(Integer item) {
        validateItem(item);
        if (size == elements.length) {
            grow();
        }
        elements[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        if (size == elements.length) {
            grow();
        }
        if (index == size) {
            elements[size++] = item;
            return item;
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
        size ++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateItem(item);
        validateIndex(index);
        elements[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        validateIndex(index);
        if (index != size) {
            System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        }
        size --;
        return item;
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer item = get(index);
        if (index != size) {
            System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        }
        size --;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        validateItem(item);
        Integer[] elementsCopy = toArray();
        sort(elementsCopy);
        return binarySearch(elementsCopy, item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        validateItem(item);
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return elements[index];
    }

    @Override
    public boolean equals(SimpleArrayList otherList) {
        if (Arrays.equals(this.toArray(), otherList.toArray())) {
            return true;
        }
        if (otherList == null) {
            throw new NullObjectException();
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidIndexException();
        }
    }

    private void grow() {
        elements = Arrays.copyOf(elements, size + size / 2);

    }

    private void sort(Integer[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                swapElements(arr, i, j);
            }
        }
        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private void swapElements(Integer[] arr, int indexA, int indexB) {
        Integer tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    private boolean binarySearch(Integer[] arr, Integer element) {
        int min = 0;
        int max = arr.length - 1;
        while (min <= max) {
            Integer mid = (max + min) / 2;
            if (element == arr[mid]) {
                return true;
            }
            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}
