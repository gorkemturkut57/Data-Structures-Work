public class stack {
    int kapasite;
    int index; //Ekleme yapmak için kullanılan index.
    MilliPark[] stack;

    stack(int kapasite){
        this.kapasite=kapasite;
        this.stack= new MilliPark[kapasite];
        index=-1;
    }

    public boolean isEmpty(){
        return index < 0;
    }


    public void push(MilliPark data){ //ekleme
        if (index==kapasite-1){
            System.out.println("Yığıt dolu!");
        }
        else{
            index++;
            stack[index]=data;
        }
    }

    public MilliPark pop(){ //silme
        if (isEmpty()){
            System.out.println("Stack boş");
            return null;
        }
        else {
            MilliPark data=stack[index];
            index--;
            return data;
        }
    }
}
