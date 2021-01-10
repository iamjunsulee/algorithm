package algorithm.hackerrank.search;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Search {
    public static void main(String[] args) {
        List<Integer> p = new ArrayList<>();
        p.add(100);
        p.add(200);
        p.add(100);
        p.add(500);
        p.add(100);
        p.add(600);

//        System.out.println(balancedSums(p));
//        System.out.println(hackerlandRadioTransmitters(new int[]{7,2,4,6,5,9,12,11}, 2));
//        System.out.println(pairs(2, new int[]{1,5,3,4,2}));
        System.out.println(minimumLoss(new long[]{20, 7, 8, 2, 5}));
    }

    private static String balancedSums(List<Integer> arr){
        //리스트가 주어질 때, 양 옆의 원소의 합이 같게 만드는 원소가 있는지 찾는 문제
        int sum = 0;
        int subSum = 0;

        for(int a : arr){
            sum += a;
        }

        for (Integer integer : arr) {
            if (sum - subSum - integer == subSum) return "YES";
            subSum += integer;
        }
        return "NO";
    }

    private static int hackerlandRadioTransmitters(int[] x, int k) {
        TreeSet<Integer> treeSet = new TreeSet<>(); //이진검색트리로 저장하는 자료구조
        for(int val : x){
            treeSet.add(val);
        }
        int count = 0;
        Integer num = treeSet.ceiling(0);   //0이 없으면 0보다 큰 값 중 가장 가까운 값, 없으면 null
        System.out.println("num : " + num);
        while(num != null){
            num = treeSet.floor(num + k);   //num+k가 없으면 num+k보다 작은 값 중 가장 가까운 값, 없으면 null
            count++;
            num = treeSet.ceiling(num + k + 1);
        }
        return count;
    }

    private static int pairs(int k, int[] arr){
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for(int i : arr){
            set.add(i);
        }
        for(int i : set){
            if(set.contains(i+k)){
                count++;
            }
        }
        return count;
    }

    private static int[] maxSubarray(int[] arr) {
        int maxSubArr = arr[0], maxSubSeq = arr[0], max = arr[0];
        int n = arr.length;
        for(int i = 1;i < n;i++){
            max = Math.max(max + arr[i], arr[i]);
            maxSubArr = Math.max(maxSubArr, max);
            maxSubSeq = Math.max(Math.max(maxSubSeq, arr[i]), maxSubSeq + arr[i]);
        }
        return new int[]{maxSubArr, maxSubSeq};
    }

    private static int minimumLoss(long[] price){
        //treeset 에서 higher() 메소드는 입력값보다 큰 값 중 최소값을 가지고 온다.
        long diff = price[0];   //20, 7, 8, 2, 5
        TreeSet<Long> treeSet = new TreeSet<>();
        treeSet.add(price[0]);
        for(int i = 1;i < price.length;i++){
            long value = price[i];                  //7, 8, 2, 5
            Long higher = treeSet.higher(value);    //20, 20, 7, 7
            if(higher != null){
                diff = Math.min(higher - value, diff);
            }
            treeSet.add(value);
        }
        return (int)diff;
    }
}
