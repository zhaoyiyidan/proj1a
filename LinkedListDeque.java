
public class LinkedListDeque<typename> {
    int size;
    list sentinel;
    class list{
        list front;
        typename items;
        list back;
        public list(){
            front=null;
            back=null;
        }
        public typename get(int index){
            if (index==0)
            return items;
            return back.get(index-1);
        }
    }
    public LinkedListDeque(){
        size=0;
        sentinel=new list();
    }
    public LinkedListDeque(typename values){
        size=1;
        sentinel=new list();
        sentinel.back=new list();
        sentinel.back.items=values;
        sentinel.back.front=sentinel;
        sentinel.back.back=sentinel;
        sentinel.front=sentinel.back;
    }
    public void addFirst(typename item){
        size+=1;
        list middle=new list();
        middle.items=item;
        middle.front=sentinel;
        middle.back=sentinel.back;
        sentinel.back=middle;
    }
    public void addLast(typename item){
        size+=1;
        list middle =new list();
        middle.items=item;
        if (sentinel.back==null){
            sentinel.back=middle;
            sentinel.front=middle;
        }
        else{
            sentinel.front.back=middle;
            sentinel.front=middle;
        }
        // another way to do this
        /**if (sentinel.front!=null){
        sentinel.front.back=new list();
        sentinel.front.back.items=item;
        sentinel.front.back.front=sentinel.front;
        sentinel.front=sentinel.front.back;}
        else{
            list middle=new list();
            middle.items=item;
            sentinel.front=middle;
            sentinel.back=middle;
            middle.front=sentinel;}*/
        
    }
    public typename get(int index){
        list gets=sentinel.back;
        while (index!=0) {
            gets=gets.back;
            index--;
        }
        return gets.items;
    }
    public boolean isEmpty(){
        if (sentinel.back==null)
        return true;
        return false;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        list a=sentinel;
        while(a.back!=null){
            System.out.print(a.back.items+" ");
            a.back=a.back.back;
        }
    }
    public typename removeFirst(){
        if (isEmpty())
        return null;
        sentinel.back=sentinel.back.back;
        sentinel.back.back.front=sentinel;
        size-=1;
        return sentinel.back.items;
    }
    public typename removeLast(){
        if (isEmpty())
        return null;
        sentinel.front=sentinel.front.front;
        typename result=sentinel.front.back.items;
        sentinel.front.back=null;
        size-=1;
        return result;
        
    }
    public typename getRecursive(int index){
        return sentinel.back.get(index);
    }

}
