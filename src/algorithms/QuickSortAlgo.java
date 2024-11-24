package algorithms;

import java.util.*;

public class QuickSortAlgo implements SortStrategy{
    @Override
    public static <T extends Comparable<T>> void sort(List<T> list){
        quickSort(list,0,list.size()-1);
    }

    private static <T extends Comparable<T>> void quickSort(List<T> list, int low, int high) {
            int left = low;
            int right = high;
            int pivot = list.get(left);
            
            while (left <= right)
            {
                while (list.get(left).compateTo(pivot)<0)
                    left++;
                while (list.get(right).compareTo(pivot)>0)
                    right--;
                if (left <= right){
                    //swap
                    T temp = list.get(left);
                    list.set( left, list.get(right));
                    list.set( right, list.get(temp));
                    
                    left++;
                    right--;
                }
            }
            if (right > low) quickSort(list, low, right);
            if (left < high) quickSort(list, left, high);

    }
}
