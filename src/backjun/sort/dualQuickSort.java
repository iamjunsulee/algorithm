package backjun.sort;

/**
 * Created by jslee on 2018-03-17.
 */
public class dualQuickSort {
    public static void main(String[] args){
        int[] data = {3, 5, 1, 8, 4, 7, 2, 9, 6};
        dualPivotQuickSort(data, 0, data.length - 1);
        for(int i=0;i<data.length;i++){
            System.out.print(data[i]+" ");
        }
    }
    public static void dualPivotQuickSort(int[] data,int start,int end){
        if(start < end){
            if(data[start] > data[end]){
                swap(data,start,end);
            }
            int pivot1 = data[start];
            int pivot2 = data[end];
            int l = start + 1;
            int k = start + 1;
            int g = end - 1;

            while(k <= g){
                if(data[k] < pivot1){
                    swap(data,k,l);
                    l++;
                }else if(data[k] >= pivot2) {
                    while (data[g] > pivot2 && k < g) {
                        g--;
                    }
                    swap(data,k,g);
                    g--;
                    if(data[k] < pivot1){
                        swap(data,k,l);
                        l++;
                    }
                }
                k++;
            }
            l--;
            g++;

            swap(data,start,l);
            swap(data,end,g);
            //partitioning done
        }
    }
    public static void swap(int[] data, int idx1, int idx2){
        int temp = data[idx1];
        data[idx1] = data[idx2];
        data[idx2] = temp;
    }
}
