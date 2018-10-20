package algorithm.Samsung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 감시 문제
 */
public class Watch {
    static int N, M;
    static ArrayList<Map> cctv = new ArrayList<Map>();
    static int[][] a = new int[8][8];
    static int result = 1000000;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   //가로
        M = sc.nextInt();   //세로
        //입력
        for(int i = 0;i < N;i++){
            for(int j = 0;j < M;j++){
                a[i][j] = sc.nextInt();
                if(a[i][j] > 0 && a[i][j] < 6){
                    cctv.add(new Map(i,j,a[i][j]));
                }
            }
        }
        solution(0, a);
        System.out.println(result);
    }

    public static void solution(int idx, int[][] prev) {
        int[][] checked = new int[8][8];

        if(idx == cctv.size()){
            //사각지대 카운트
            int count = 0;
            for(int i = 0;i < N;i++){
                for(int j = 0;j < M;j++){
                    if(prev[i][j] == 0){
                        count++;
                    }
                }
            }
            result = Math.min(result, count);
        }else{
            Map map = cctv.get(idx);
            int type = map.type;
            int x = map.x;
            int y = map.y;

            switch(type){
                case 1:
                    //1번 카메라는 4번 회전
                    for(int i = 0;i < 4;i++){
                        for(int j = 0;j < N;j++){
                            checked[j] = Arrays.copyOf(prev[j], M);    //현재 상태 복사
                        }
                        watch(x, y, i, checked);      //감시
                        solution(idx + 1, checked);  //다음 cctv
                    }
                    break;
                case 2:
                    //2번 카메라는 2번 회전
                    for(int i = 0;i < 2;i++){
                        for(int j = 0;j < N;j++){
                            checked[j] = Arrays.copyOf(prev[j], M);
                        }
                        watch(x, y, i, checked);
                        watch(x, y, i+2, checked);
                        solution(idx + 1, checked);
                    }
                    break;
                case 3:
                    //3번 카메라는 4번 회전
                    for(int i = 0; i < 4;i++){
                        for(int j = 0;j < N;j++){
                            checked[j] = Arrays.copyOf(prev[j], M);
                        }
                        watch(x, y, i, checked);
                        watch(x, y, (i+1)%4, checked);
                        solution(idx + 1, checked);
                    }
                    break;
                case 4:
                    //4번 카메라는 4번 회전
                    for(int i = 0; i < 4;i++){
                        for(int j = 0;j < N;j++){
                            checked[j] = Arrays.copyOf(prev[j], M);
                        }
                        watch(x, y, i, checked);
                        watch(x, y, (i+1)%4, checked);
                        watch(x, y, (i+2)%4, checked);
                        solution(idx + 1, checked);
                    }
                    break;
                case 5:
                    for(int i = 0;i < N;i++){
                        checked[i] = Arrays.copyOf(prev[i], M);
                    }
                    for(int i = 0; i < 4;i++){
                        watch(x, y, i, checked);
                    }
                    solution(idx + 1, checked);
                    break;
            }
        }
    }
    //카메라 방향대로 감시 체크
    public static void watch(int x, int y, int dir, int[][] map){
        switch (dir){
            //right
            case 0:
                for(int i = y + 1;i < M;i++){
                    if(a[x][i] == 6) {
                        break;
                    }
                    map[x][i] = 7;
                }
                break;
            //top
            case 1:
                for(int i = x - 1;i >= 0;i--){
                    if(a[i][y] == 6){
                        break;
                    }
                    map[i][y] = 7;
                }
                break;
            //left
            case 2:
                for(int i = y - 1;i >= 0;i--){
                    if(a[x][i] == 6){
                        break;
                    }
                    map[x][i] = 7;
                }
                break;
            //bottom
            case 3:
                for(int i = x + 1;i < N;i++){
                    if(a[i][y] == 6){
                        break;
                    }
                    map[i][y] = 7;
                }
                break;
        }
    }
}
class Map{
    int x, y, type;

    Map(int x, int y, int type){
        this.x = x;
        this.y = y;
        this.type = type;
    }
}
