import java.util.ArrayList;
import java.util.List;

public class ArrayListStackImpl implements Stack {
    private static int actualNumOfElements = 0;
    private List<Integer> stack = new ArrayList<>();

    @Override
    public int top() throws EmptyStackException {
        if(actualNumOfElements > 0) {
            return stack.get(actualNumOfElements-1);
        } else {
            throw new EmptyStackException("Empty stack\n");
        }
    }

    @Override
    public int pop() throws EmptyStackException {
        if (actualNumOfElements > 0) {
            int element = stack.get(actualNumOfElements-1);
            stack.remove(actualNumOfElements-1);
            actualNumOfElements--;
            return element;
        } else {
            throw new EmptyStackException("Empty stack\n");
        }
    }

    @Override
    public void push(int element) throws FullStackException {
        if(actualNumOfElements >= maxElementsOnStack){
            throw new FullStackException("Stack if full\n");
        }
        else {
            stack.add(actualNumOfElements++, element);
        }
    }

    @Override
    public int getActualNumberOfElements() {
        return actualNumOfElements;
    }
}