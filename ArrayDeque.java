public class ArrayDeque<T> {
    T[] list;
    int size;
    public ArrayDeque(){
        list = (T[]) new Object[8];
        size = 0;
    }
    public ArrayDeque(T values){
        list=(T[]) new Object[8];
        list[0]=values;
        size=1;
    }
    public void addFirst(T item){
        if (size==list.length){
            resize(size*2);
        }
        T[] newlist=(T[]) new Object[list.length];
        newlist[0]=item;
        System.arraycopy(list,0,newlist,1,size);
        list=newlist;
        size+=1;
    }
    public void addLast(T item){
        if (size==list.length){
            resize(size*2);
        }
        list[size]=item;
        size+=1;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        for (int i=0;i<size;i++){
            System.out.print(list[i]+" ");
        }
        System.out.println();
    }
    public T removeFirst(){
        if (size==0){
            return null;
        }
        T[] newlist=(T[]) new Object[list.length];
        System.arraycopy(list,1,newlist,0,size-1);
        T first=list[0];
        list=newlist;
        size-=1;
        if (size<list.length/4){
            resize(list.length/2);
        }
        return first;
    }
    public T removeLast(){
        if (size==0){
            return null;
        }
        T last=list[size-1];
        list[size-1]=null;
        size-=1;
        if (size<list.length/4){
            resize(list.length/2);
        }
        return last;
    }
    public T get(int index){
        if (index>=size){
            return null;
        }
        return list[index];
    }
    private void resize(int capacity){
        T[] newlist=(T[]) new Object[capacity];
        System.arraycopy(list,0,newlist,0,size);
        list=newlist;
    }

}