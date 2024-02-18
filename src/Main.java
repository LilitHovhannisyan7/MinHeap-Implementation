import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MinHeap
{
    List<Integer> list;
    int size;
    public MinHeap()
    {
        this.list = new ArrayList<Integer>();
    }
    public int left(int i)
    {
        return this.list.get(2 * i + 1);
    }
    public int right(int i)
    {
        return this.list.get(2 * i + 2);
    }
    public int parent(int i)
    {
        return this.list.get((i - 1)/ 2);
    }

    public void minHeapify(int i)
    {
        int l = this.left(i);
        int r = this.right(i);
        int min = i;
        if(l < this.size && (this.list.get(min) > this.list.get(l)))
        {
            min = l;
        }
        if(r < this.size && (this.list.get(min) > this.list.get(r)))
        {
            min = r;
        }
        if(min != i)
        {
            Collections.swap(list, min, i);
            minHeapify(min);
        }
    }


    public void buildMinHeap()
    {
        int i = (this.size / 2) - 1;
        for(; i >= 0; --i)
        {
            this.minHeapify(i);
        }
    }

    public void insert(int element)
    {
        this.list.add(element);
        ++this.size;
        int index = this.size - 1;
        int p = this.parent(index);
        while(index > 0 && this.list.get(p) > this.list.get(index))
        {
            Collections.swap(this.list, p, index);
            index = this.parent(index);
            p = this.parent(index);
        }
    }

    public int getMin()
    {
        return this.list.get(0);
    }

    public void extractMin()
    {
        Collections.swap(this.list, 0, this.size - 1);
        --this.size;
        minHeapify(0);
    }

    public void decreaseKey(int index, int newValue)
    {
        if(newValue >= this.list.get(index))
        {
            throw new RuntimeException("Invalid");
        }
        this.list.set(index, newValue);
        int tempIndex = index;
        int p = this.parent(index);
        while(tempIndex > 0 && this.list.get(tempIndex) < this.list.get(p))
        {
            Collections.swap(this.list, tempIndex, p);
            tempIndex = this.parent(tempIndex);
            p = this.parent(tempIndex);
        }
    }

}






public class Main
{
    public static void main(String[] args)
    {

    }
}