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
            //ù��° index ���� pivot1, ������ index ���� pivot2�� ����
            if(data[start] > data[end]){//���� pivot2�� �� ������ ��ȯ
                swap(data,start,end);
            }
            int pivot1 = data[start];
            int pivot2 = data[end];
            int low = start + 1;    //pivot1 ���� index���� ����
            int k = start + 1;      //�����̴� index
            int great = end - 1;    //pivot2 �� index���� ����

            while(k <= great){
                if(data[k] < pivot1){   //small ���� ���
                    swap(data,k,low);   //low index ���� ��ȯ
                    low++;              //low �̵�
                }else if(data[k] >= pivot2) {   //large ���� ���
                    //large ���� ���, swap�� ���� ã�´�
                    //pivot2���� ���� ���� ���ö����� �̵�
                    while (data[great] > pivot2) {
                        great--;
                    }
                    if(k > great){  //k, great�� �����Ǵ� ���, pivot1,2 ��ġ ����
                        break;
                    }
                    swap(data,k,great);
                    //swap�� ��, pivot1���� ������ low ���� ��ȯ
                    if(data[k] < pivot1){
                        swap(data,k,low);
                        low++;
                    }
                }
                k++;    //medium ���� ��� (pivot1 < data[k] < pivot2)
            }
            low--;      //swap �ϱ����� index �̵�
            great++;    //swap �ϱ����� index �̵�

            swap(data,start,low);       //pivot1�� ��ȯ
            swap(data,end,great);       //pivot2�� ��ȯ
            //partitioning done
            dualPivotQuickSort(data,start,low-1);
            dualPivotQuickSort(data,low+1,great-1);
            dualPivotQuickSort(data,great+1,end);
        }
    }
    //swap �Լ�
    public static void swap(int[] data, int idx1, int idx2){
        int temp = data[idx1];
        data[idx1] = data[idx2];
        data[idx2] = temp;
    }
}
