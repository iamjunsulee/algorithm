package algorithm.hackerrank.greedy;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Greedy {
    public static void main(String[] args) {
//        System.out.println(getMinimumCost(3,
//                new int[]{4504,1520,5857,4094,4157,3902,822,6643,2422,7288,8245,9948,2822,1784,7802,3142,9739,5629,5413,7232}));
//        System.out.println(maxMin(5,
//                new int[]{4504,1520,5857,4094,4157,3902,822,6643,2422,7288,8245,9948,2822,1784,7802,3142,9739,5629,5413,7232}));
//        jimOrders(new int[][]{{8,1},{4,2},{5,6},{3,1},{4,3}});
    }

    private static int getMinimumCost(int k, int[] c){
        //두번째 사는 꽃부터 가중치가 적용됨, k만큼 더하고나면 가중치 +1 이 된다.
        //sort 시키는 것 중요
        int minCost = 0;
        int previous = 0;
        int temp = 0;
        Arrays.sort(c);
        if(k >= c.length){
            for(int num : c){
                minCost += num;
            }
        }else{
            for(int i = c.length-1;i >= 0;i--){
                if(temp == k) {
                    previous++;
                    temp = 0;   //k개 이후로 초기화 시켜줘야 다시 k만큼 사면 이전에 산 횟수를 증가시킴
                }
                temp++;
                minCost += (previous + 1) * c[i];
            }
        }
        return minCost;
    }

    private static int maxMin(int k, int[] arr) {
        Arrays.sort(arr);
        int min = arr[k-1] - arr[0];
        for(int i = 0;i < arr.length-k+1;i++){
            if(arr[i+k-1] - arr[i] < min){
                min = arr[i+k-1] - arr[i];
            }
        }
        return min;
    }

    private static int[] jimOrders(int[][] orders) {
        //2차원 배열이 주어지는 데, 각 원소를 더해서 1차원 배열로 만든 후, 각 키값을 부여
        //value로 오름차순 정렬해서 key값을 출력
        int[] result = new int[orders.length];
        AtomicInteger b = new AtomicInteger(1);
        Map<Integer, Integer> collect = Arrays.stream(orders)
                .map(a -> a[0] + a[1])
                .collect(Collectors.toMap(i -> b.getAndIncrement(), a -> a));
        List<Map.Entry<Integer, Integer>> entries = new LinkedList<>(collect.entrySet());
        entries.sort(Comparator.comparing(Map.Entry::getValue));

        for(int i = 0;i < entries.size();i++){
            result[i] = entries.get(i).getKey();
        }
        return result;
    }

    private static String twoArrays(int k, int[] A, int[] B) {
        //Collections sort를 사용하려면 wrapper 를 사용해야 함
        //stream 에서 boxed는 primitive type을 wrapper type으로 변환해준다.
        Integer[] arr1 = Arrays.stream(A).boxed().sorted().toArray(Integer[]::new);
        Integer[] arr2 = Arrays.stream(B).boxed().sorted(Collections.reverseOrder()).toArray(Integer[]::new);

        for(int i = 0;i < arr1.length;i++){
            if(arr1[i] + arr2[i] < k) return "NO";
        }
        return "YES";
    }
}
