package algorithm.Samsung;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 톱니바퀴 문제
 * linkedlist 성질을 사용해서 방향에 따라 앞, 뒤로 원소를 뺏다 넣었다한다.
 *
 * 1. 서로 맞물리는 톱니바퀴는 2번 6번
 * 2. 입력받은 톱니바퀴는 반드시 회전한다.
 * 3. 극이 다르면 회전시키고 아니면 그대로
 * 4. 인접한 톱니바퀴는 반대로 회전하게된다.
 */
public class Gear {
    static LinkedList<Integer>[] gear = (LinkedList<Integer>[])new LinkedList[5];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //입력
        for(int i = 1;i <= 4;i++){
            gear[i] = new LinkedList<Integer>();
            String input = sc.next();
            for(String str : input.split("")){
                gear[i].add(Integer.parseInt(str));
            }
        }

        int size = sc.nextInt();

        for(int i = 0;i < size;i++){
            int num = sc.nextInt();
            int dir = sc.nextInt();

            left(num - 1, -dir);
            right(num + 1,-dir);
            rotate(num, dir);
        }
        int result = 0;
        for(int i = 0;i < 4;i++){
            //s극일때, 점수 1, 2, 4, 8
            if(gear[i+1].get(0) == 1){
                result += (int)Math.pow(2,i);
            }
        }
        System.out.println(result);
    }
    //인접한 왼쪽 확인 및 회전
    public static void left(int num, int dir){
        if(num >= 1 && num <= 4){
            if(isRotate(num, num + 1)){
                left(num-1, -dir);
                rotate(num, dir);
            }
        }
    }
    //인접한 오른쪽 확인 및 회전
    public static void right(int num, int dir){
        if(num >= 1 && num <= 4){
            if(isRotate(num, num - 1)){
                right(num + 1, -dir);
                rotate(num, dir);
            }
        }
    }
    //회전시키는 함수
    public static void rotate(int num, int dir){
        if(dir == 1){//시계방향회전 => 제일 뒤의 원소를 제일 앞으로
            gear[num].addFirst(gear[num].pollLast());
        }else{//반시계방향회전 => 제일 앞 원소를 제일 뒤로
            gear[num].addLast(gear[num].pollFirst());
        }
    }
    //맞물린 부분 극 체크
    public static boolean isRotate(int a, int b){
        if(a > b){
            //큰쪽의 left와 작은쪽의 right
            if(gear[a].get(6) == gear[b].get(2)){
                return false;
            }else{
                return true;
            }
        }else{
            if(gear[a].get(2) == gear[b].get(6)){
                return false;
            }else{
                return true;
            }
        }
    }
}
