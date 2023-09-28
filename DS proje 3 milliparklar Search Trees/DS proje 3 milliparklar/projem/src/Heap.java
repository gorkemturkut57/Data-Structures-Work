public class Heap {
    private MilliParklar[] heapArray;
    private int maxSize; // size of array
    private int currentSize; // number of nodes in array
    public Heap(int mx) // constructor
    {
        maxSize = mx;
        currentSize = 0;
        heapArray = new MilliParklar[maxSize]; // create array
    }
    public boolean isEmpty()
    { return currentSize==0; }
    public boolean insert(MilliParklar key)
    {
        if(currentSize==maxSize)
            return false;
        heapArray[currentSize] = key;
        trickleUp(currentSize++);
        return true;
    } // end insert()
    public void trickleUp(int index)
    {
        int parent = (index-1) / 2;
        MilliParklar bottom = heapArray[index];
        while( index > 0 &&
                heapArray[parent].getYuzOlcumu() < bottom.getYuzOlcumu() )
        {
            heapArray[index] = heapArray[parent]; // move it down
            index = parent;
            parent = (parent-1) / 2;
        } // end while
        heapArray[index] = bottom;
    } // end trickleUp()
    public MilliParklar remove() // delete item with max key
    { // (assumes non-empty list)
        MilliParklar root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    } // end remove()
    public void trickleDown(int index) {
        int largerChild;
        MilliParklar top = heapArray[index]; // save root
        while (index < currentSize / 2) // while node has at
        { // least one child,
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;
            // find larger child
            if (rightChild < currentSize && // (rightChild exists?)
                    heapArray[leftChild].getYuzOlcumu() <
                            heapArray[rightChild].getYuzOlcumu())
                largerChild = rightChild;
            else
                largerChild = leftChild;
            // top >= largerChild?
            if (top.getYuzOlcumu() >= heapArray[largerChild].getYuzOlcumu())
                break;
            // shift child up
            heapArray[index] = heapArray[largerChild];
            index = largerChild; // go down
        } // end while
        heapArray[index] = top; // root to index
    }
    public boolean change(int index, MilliParklar newValue)
    {
        if(index<0 || index>=currentSize)
            return false;
        MilliParklar oldValue = heapArray[index]; // remember old
        heapArray[index] = newValue; // change to new
        if(oldValue.getYuzOlcumu() < newValue.getYuzOlcumu()) // if raised,
            trickleUp(index); // trickle it up
        else // if lowered,
            trickleDown(index); // trickle it down
        return true;
    } // end change()
    public void displayHeap()
    {
        System.out.print("heapArray:"); // array format
        for(int m=0; m<currentSize; m++)
            if(heapArray[m] != null)
                System.out.print( heapArray[m] + "  ");
            else
                System.out.print( "-- ");
        System.out.println();
        // heap format
        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0; // current item
        String dots = "...............................";
        System.out.println(dots+dots); // dotted top line
        while(currentSize > 0) // for each heap item
        {
            if(column == 0) // first item in row?
                for(int k=0; k<nBlanks; k++) // preceding blanks
                    System.out.print(' ');
        // display item
            System.out.print(heapArray[j]);
            if(++j == currentSize) // done?
                break;
            if(++column==itemsPerRow) // end of row?
            {
                nBlanks /= 2; // half the blanks
                itemsPerRow *= 2; // twice the items
                column = 0; // start over on
                System.out.println(); // new row
            }
            else // next item on row
                for(int k=0; k<nBlanks*2-2; k++)
                    System.out.print(' '); // interim blanks
        } // end for
        System.out.println("\n"+dots+dots); // dotted bottom line
    } // end displayHeap()
    }
