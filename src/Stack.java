public interface Stack {
    int top() throws EmptyStackException;
    int pop() throws EmptyStackException;
    void push(int element) throws FullStackException;
    int maxElementsOnStack = 5;
    int getActualNumberOfElements();
}
