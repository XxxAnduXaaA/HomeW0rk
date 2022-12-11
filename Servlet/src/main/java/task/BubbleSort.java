package task;
public class BubbleSort implements Sorter
{
    @Override
    public int[] sort(int[] numbers)
    {
        if (numbers == null)
        {
            throw new NullPointerException("Array is null");
        }
        int[] copy = copyArrays(numbers);
        while (!isSorted(copy)){
            sorting(copy);
        }
        return copy;
    }
    int[] copyArrays (int[] numbers)
    {
        int l = numbers.length;
        int[] copy = new int[l];
        for (int i = 0; i < l; i++)
            copy[i] = numbers[i];
        return copy;
    }

    boolean isSorted (int[] numbers)
    {
        int l = numbers.length;
        for (int i = 1; i < l; i++){
            if (numbers[i] < numbers[i - 1])
            {
                return false;
            }
        }
        return true;
    }

    void sorting (int[] numbers)
    {
        int l = numbers.length;
        for (int i = 1; i < l; i++)
        {
            if (numbers[i] < numbers[i - 1])
            {
                int temp = numbers[i];
                numbers[i] = numbers[i-1];
                numbers[i-1] = temp;
            }
        }
    }

}
