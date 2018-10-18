package algorithm.Samsung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 치킨배달 문제
 * 탐색, 백트레킹
 */
public class ChickenDelivery {
    static ArrayList<Point> chicken = new ArrayList<Point>();
    static ArrayList<Point> house = new ArrayList<Point>();
    static int N, M, result = 1000000;
    static boolean[] visited = new boolean[14];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   //입력 row 수
        M = sc.nextInt();   //선택하는 최대 치킨집 개수

        //입력
        for(int i = 1;i <= N;i++){
            for(int j = 1;j <= N;j++){
                int num = sc.nextInt();

                if(num == 1){
                    house.add(new Point(i, j));
                }else if(num == 2){
                    chicken.add(new Point(i, j));
                }
            }
        }
        Arrays.fill(visited, false);

        for(int i = 0;i < chicken.size();i++){
            solution(i, 1);
        }
        System.out.println(result);
    }

    /**
     * 문제해결함수
     * @param start 시작점
     * @param count 치킨집 수
     */
    public static void solution(int start, int count){
        visited[start] = true;  //치킨집 방문
        //System.out.println(start + " 방문");
        if(count < M){  //M개의 치킨집을 방문하지 않았을 경우
            for(int i = start;i < chicken.size();i++){
                solution(i + 1, count + 1); //다음 치킨집 방문
            }
        }else{
            int total = 0;
            //최대 M개 치킨집 방문한 경우, 거리 계산
            for(int i = 0;i < house.size();i++){
                int min = 10000000;
                for(int j = 0;j < chicken.size();j++){
                    if(visited[j]){
                        //System.out.println("집 좌표 :"+house.get(i).x+", "+house.get(i).y+", 치킨집 좌표 :"+chicken.get(j).x+", "+chicken.get(j).y);
                        min = Math.min(min, calc(house.get(i), chicken.get(j)));
                    }
                }
                total += min;
            }
            result = Math.min(result, total);
        }
        visited[start] = false;     //backtracking
    }
    //거리계산
    public static int calc(Point p1, Point p2){
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
}
class Point{
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}