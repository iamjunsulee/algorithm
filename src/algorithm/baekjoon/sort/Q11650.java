package algorithm.baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jslee on 2018-06-05.
 * 좌표 정렬하기
 * 나만의 정렬기법을 사용하려면 compareTo를 override해서 사용해야함.
 */
public class Q11650 {
    static class Point implements Comparable<Point>{
        int x, y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Point p){
            if(this.x < p.x){
                return -1;
            }else if(this.x == p.x){    //x좌표가 같으면 y좌표 비교
                if(this.y < p.y){
                    return -1;
                }else if(this.y == p.y){
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
        int n = sc.nextInt();   //점의 개수
        Point[] point = new Point[n];

        for(int i = 0;i < n;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            point[i] = new Point(x, y);
        }
        Arrays.sort(point);

        for(int i = 0;i < n;i++){
            System.out.print(point[i].x +" "+point[i].y);
            System.out.println();
        }
    }
}
