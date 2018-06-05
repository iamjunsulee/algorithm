package algorithm.baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jslee on 2018-06-06.
 * 11650문제와 유사
 * x좌표 대신에 y좌표부터 먼저 정렬
 */
public class Q11651 {
    static class Point implements Comparable<Point>{
        int x, y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Point p){
            if(this.y < p.y){
                return -1;
            }else if(this.y == p.y){    //y좌표가 같으면 x좌표 비교
                if(this.x < p.x){
                    return -1;
                }else if(this.x == p.x){
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
