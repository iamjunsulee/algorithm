package algorithm.baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jslee on 2018-06-06.
 * 나이순 정렬
 */
public class Q10814 {
    static class Member implements Comparable<Member>{
        int age, order;
        String name;

        Member(int age, int order, String name){
            this.age = age;
            this.order = order;
            this.name = name;
        }
        @Override
        public int compareTo(Member m){
            if(this.age < m.age){
                return -1;
            }else if(this.age == m.age){    //나이가 같으면 가입순서 비교
                if(this.order < m.order){
                    return -1;
                }else if(this.order == m.order){
                    return 0;
                }else{
                    return 1;
                }
            }else{
                return 1;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //회원 수
        Member[] member = new Member[n];

        for(int i = 0;i < n;i++){
            int age = sc.nextInt();
            String name = sc.next();

            member[i] = new Member(age, i, name);
        }
        Arrays.sort(member);

        for(int i = 0;i < n;i++){
            System.out.print(member[i].age +" "+member[i].name);
            System.out.println();
        }
    }
}
