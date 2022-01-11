package DataStructure;
/*
Heap is represented as an array.
Arr[(i-1)/2] Returns the parent node.
Arr[(2*i)+1] Returns the left child node.
Arr[(2*i)+2] Returns the right child node.
 */
public class Heap {
    private int[] arr;
    private int size, maxSize; // we need size to keep track of current heap size. and max to initialize array.

    public void maxHeap(int maxsize){
        this.maxSize = maxsize;
        this.size = 0;
        arr = new int[this.maxSize];
    }

    public void minHeap(int maxsize){
        maxHeap(maxsize);
    }

    private int parent(int index){ return (index - 1) / 2;}
    private int leftChild(int index){ return (2*index) + 1;}
    private int rightChild(int index){return (2*index) + 2;}

    private boolean isLeafNode(int index){ return index > size / 2 && index <= size;}

    private void swap(int from, int to){
        int tmp = arr[from];
        arr[from] = arr[to];
        arr[to] = tmp;
    }

    private void maxHeapify(int index){
        if(isLeafNode(index)) return;

        if(arr[index] < arr[leftChild(index)]
        || arr[index] < arr[rightChild(index)]){
            if(arr[leftChild(index)] > arr[rightChild(index)]){
                swap(index, leftChild(index));
                maxHeapify(leftChild(index));
            }else{
                swap(index, rightChild(index));
                maxHeapify(rightChild(index));
            }

        }
    }

    private void minHeapify(int index){
        if(isLeafNode(index)) return;

        if(arr[index] > arr[leftChild(index)]
                || arr[index] > arr[rightChild(index)]){
            if(arr[leftChild(index)] < arr[rightChild(index)]){
                swap(index, leftChild(index));
                minHeapify(leftChild(index));
            }else{
                swap(index, rightChild(index));
                minHeapify(rightChild(index));
            }
        }
    }

    public void insertMax(int element){
        int current = size;
        arr[size++] = element;
        while(arr[current] > arr[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void insertMin(int element){
        int current = size;
        arr[size++] = element;
        while(arr[current] < arr[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int top(){
        return arr[0];
    }

}
