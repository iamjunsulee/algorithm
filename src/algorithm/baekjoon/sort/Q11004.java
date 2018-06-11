package algorithm.baekjoon.sort;

import java.io.*;
import java.util.StringTokenizer;

public class Q11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int idx = Integer.parseInt(st.nextToken());
        int data[] = new int[size];

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<size;i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        dualPivotQuickSort(data, 0, size - 1);
        bw.write(data[idx-1]+"\n");
        bw.close();
        br.close();
    }
    public static void dualPivotQuickSort(int[] data,int start,int end){
        if(start < end){
        	//첫번째 index 값을 pivot1, 마지막 index 값을 pivot2로 설정
            if(data[start] > data[end]){//만약 pivot2가 더 작으면 교환
                swap(data,start,end);
            }
            int pivot1 = data[start];
            int pivot2 = data[end];
            int low = start + 1;    //pivot1 다음 index부터 시작
            int k = start + 1;      //움직이는 index
            int great = end - 1;    //pivot2 전 index부터 시작

            while(k <= great){
                if(data[k] < pivot1){   //small 값인 경우
                    swap(data,k,low);  //low index 값과 교환
                    low++;               //low 이동
                }else if(data[k] >= pivot2) {   //large 값인 경우
                	//large 값인 경우, swap할 값을 찾는다
                	//pivot2보다 작은 값이 나올때까지 이동
                    while (data[great] > pivot2) {
                        great--;
                    }
                    if(k > great){  //k, great가 교차되는 경우, pivot1,2 위치 조정
                        break;
                    }
                    swap(data,k,great);
                    //swap한 후, pivot1보다 작으면 low 값과 교환
                    if(data[k] < pivot1){
                        swap(data,k,low);
                        low++;
                    }
                }
                k++;    //medium 값인 경우 (pivot1 < data[k] < pivot2)
            }
            low--;     	 //swap 하기위한 index 이동
            great++;     //swap 하기위한 index 이동

            swap(data,start,low);       //pivot1과 교환
            swap(data,end,great);       //pivot2와 교환
            //partitioning done
            dualPivotQuickSort(data,start,low-1);
            dualPivotQuickSort(data,low+1,great-1);
            dualPivotQuickSort(data,great+1,end);
        }
    }
    //swap 함수
    public static void swap(int[] data, int idx1, int idx2){
        int temp = data[idx1];
        data[idx1] = data[idx2];
        data[idx2] = temp;
    }
}
