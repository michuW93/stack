public class ArrayStackImpl implements Stack {
    private static int actualNumOfElements = 0;
    private int[] stack = new int[maxElementsOnStack];

    @Override
    public int top() throws EmptyStackException {
        if(actualNumOfElements > 0){
            return stack[actualNumOfElements];
        } else {
            throw new EmptyStackException("Empty stack\n");
        }
    }

    @Override
    public int pop() throws EmptyStackException {
        if (actualNumOfElements > 0) {
            return stack[actualNumOfElements--];
        } else {
            throw new EmptyStackException("Empty stack\n");
        }
    }

    @Override
    public void push(int element) throws FullStackException {
        if(actualNumOfElements >= maxElementsOnStack){
            throw new FullStackException("Stack if full \n");
        }
        else {
            stack[actualNumOfElements++] = element;
        }
    }

    @Override
    public int getActualNumberOfElements() {
        return actualNumOfElements;
    }
}