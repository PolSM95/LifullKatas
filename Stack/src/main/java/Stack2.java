import java.util.ArrayList;

public class Stack2 {

    public int length = 0;
    private ArrayList<String> arraystack = new ArrayList<>();

    public String pop() {

        if(arraystack.isEmpty()){
            throw new RuntimeException("Stack is empty.");
        }
        length--;
        return arraystack.get(length);


    }

    public void push(String element) {

        arraystack.add(element);

        length = arraystack.size();
    }
}
