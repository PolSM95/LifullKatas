import java.util.ArrayList;

public class StackKata {

        private int length = 0;
        private ArrayList<String> stackArray = new ArrayList<String>();

        public String pop() {
            length = stackArray.size();
            if (length == 0){
                throw new RuntimeException ("Stack is empty");
            }
          String element =  stackArray.get(length-1);
            stackArray.remove(length-1);
            return element;
        }

        public void push(String element) {
            stackArray.add(element);
            length = stackArray.size();
        }

         public int getLength() {
             return length;
         }


    }
