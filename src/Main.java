import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final String INPUT_PATH = "D:\\repo\\stack\\src\\file_input.txt";
    private static final String OUTPUT_PATH = "D:\\repo\\stack\\src\\file_output.txt";
    private static final String PUSH = "PU";
    private static final String TOP = "TO";
    private static final String POP = "PO";
    private static final String OB1 = "OB1";
    private static final String OB2 = "OB2";
    private static final String OB3 = "OB3";
    private static Stack arrayStack;
    private static Stack arrayListStack1;
    private static Stack arrayListStack2;
    private static FileWriter writer;

    public static void main(String[] args) throws IOException {
        File inputFile = new File(INPUT_PATH);
        createStacks();
        writer = new FileWriter(OUTPUT_PATH);
        Scanner sc = new Scanner(inputFile);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            doOperation(line);
        }
        writer.write("Elements in arrayStack: " + arrayStack.getActualNumberOfElements() + "\n");
        writer.write("Elements in arrayStack: " + arrayListStack1.getActualNumberOfElements() + "\n");
        writer.write("Elements in arrayStack: " + arrayListStack2.getActualNumberOfElements() + "\n");
        writer.close();
    }

    private static void createStacks() {
        arrayStack = new ArrayStackImpl();
        arrayListStack1 = new ArrayListStackImpl();
        arrayListStack2 = new ArrayListStackImpl();
    }

    private static void doOperation(String line) throws IOException {
        Integer element = -1;
        String command = line.split(" ")[0];
        String stackNumber = line.split(" ")[1];
        if(command.equals(PUSH)){
            element = Integer.parseInt(line.split(" ")[2]);
        }
        try {
            if (stackNumber.equals(OB1)) {
                if (command.equals(PUSH)) {
                    arrayStack.push(element);
                } else if (command.equals(POP)) {
                    arrayStack.pop();
                } else if (command.equals(TOP)) {
                    int topElement = arrayStack.top();
                    writer.write("top element: " + topElement + "\n");
                }
            } else if (stackNumber.equals(OB2)) {
                if (command.equals(PUSH)) {
                    arrayListStack1.push(element);
                } else if (command.equals(POP)) {
                    arrayListStack1.pop();
                } else if (command.equals(TOP)) {
                    int topElement = arrayListStack1.top();
                    writer.write("top element: " + topElement + "\n");
                }
            } else if (stackNumber.equals(OB3)) {
                if (command.equals(PUSH)) {
                    arrayListStack2.push(element);
                } else if (command.equals(POP)) {
                    arrayListStack2.pop();
                } else if (command.equals(TOP)) {
                    int topElement = arrayListStack2.top();
                    writer.write("top element: " + topElement + "\n");
                }
            }
        } catch (FullStackException | EmptyStackException e) {
            writer.write(e.getMessage());
        }

    }
}