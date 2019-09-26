public class GenericStack<E> {
    private E [] elements;
    private int index = 0;
    private int capacity;

    GenericStack(int capacity) {
        this.capacity = capacity;
        elements = (E[]) new Object[capacity];
    }

    int size() {
        int count = 0;
        for (E element : elements) {
            if (element != null)
                count++;
            else
                break;
        }
        return count;
    }

    E peek() {
        if (size() != 0)
            return elements[index - 1];
        else
            return null;
    }

    void push(E o) {
        // if array is empty    -> push 'o'
        // if array is full     -> double size of array and then push 'o'
        if (index < capacity) {
            // push 'o'
            elements[index] = o;
            index++;
        } else {
            // Double capacity and push 'o'
            E [] cache = (E[]) new Object[elements.length * 2];
            System.arraycopy(elements, 0, cache, 0, elements.length);
            elements = cache;
            capacity = elements.length;
            push(o);
        }
    }

    void pop() {
        // if array == empty    -> do nothing
        // if array != empty    -> pop at index
        if (index != 0) {
            elements[index] = null;
            index--;
        }
    }

    boolean isEmpty() {
        return elements[0] == null;
    }

    int getTotalLengthOfElements() {
        return elements.length;
    }

    @Override
    public String toString() {
        // TODO: MUST PRINT STRINGS UP TO FIRST NULL, NOT ENTIRE ARRAY!!!
        StringBuilder stringToReturn = new StringBuilder();
        if (elements[0] != null) {
            for (int i = 0; i < elements.length; i++) {
                if (i == 0)
                    stringToReturn.append(String.format("[%s", elements[i]));
                if (elements[i] != null && i != 0)
                    stringToReturn.append(String.format(", %s", elements[i]));
                if (i == elements.length - 1)
                    stringToReturn.append("]");
             }
        } else
            stringToReturn.append("array was empty!");
        return stringToReturn.toString();
    }
}
