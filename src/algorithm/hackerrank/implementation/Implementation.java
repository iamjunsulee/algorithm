package algorithm.hackerrank.implementation;

import java.util.*;
import java.util.stream.Collectors;

public class Implementation {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(1);
        a.add(3);
        a.add(2);

//        System.out.println(migratoryBirds(a));
//        System.out.println(birthday(a,3,2));
//        System.out.println(taumBday(27984, 1402, 619246, 615589, 247954));
    }

    private static int migratoryBirds(List<Integer> arr) {
        //stream으로 값으로 grouping 해서 각 개수를 collect함
        //value로 비교해서 max값 추출
        Map<Integer, Long> collect = arr.stream().collect(Collectors.groupingBy(a -> a, Collectors.counting()));
        return Collections.max(collect.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private static int birthday(List<Integer> s, int d, int m) {
        //주어진 m으로 묶었을 때, 각 원소의 합이 d가 나오는 경우의 수 출력하기
        int[] sum = new int[s.size()+1];    //인덱스 숫자만큼 원소의 합을 저장할 배열
        int count = 0;
        for(int i = 0;i < s.size();i++){
            int idx = i + 1;
            sum[idx] = sum[i] + s.get(i);
            //인덱스까지 전체 원소의 합에서 m개의 원소빼고 나머지 합을 뺀게 d와 같으면 된다.
            if(idx >= m && (sum[idx] - sum[idx-m] == d)){
                count++;
            }
        }
        return count;
    }

    private static long taumBday(long b, long w, long bc, long wc, long z) {
        return b * Math.min(bc, wc+z) + w * Math.min(wc, bc+z);
    }
}

