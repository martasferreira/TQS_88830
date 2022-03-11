import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TqsStack <T>{

    private ArrayList<T> stack;
    private int limitSize;

    public TqsStack(){
        this.stack = new ArrayList<>();
        this.limitSize = -1;
    }

    public TqsStack(int i){
        this.stack = new ArrayList<>();
        if(i < 0){
            throw new IllegalStateException("ERROR! The stack maximum size must be > 0!");
        }
        this.limitSize = i;

    }

    public void push(T elem){
        if(limitSize>0){
            if (limitSize > this.stack.size()){
                this.stack.add(elem);
            }
            else{
                throw new IllegalStateException("ERROR! The stack is full");
            }
        }
        else{
            this.stack.add(elem);
        }


    }

    public T pop(){
        if(this.stack.size() == 0) {
            throw new NoSuchElementException();
        }
        return stack.remove(this.stack.size() - 1);
    }

    public T peek(){
        if(this.stack.size() == 0) {
            throw new NoSuchElementException();
        }
        return stack.get(this.stack.size() - 1);
    }

    public int size(){
        return this.stack.size();
    }

    public boolean isEmpty(){
        return this.stack.isEmpty();
    }





}
