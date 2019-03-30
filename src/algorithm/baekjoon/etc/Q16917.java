package algorithm.baekjoon.etc;

import java.util.Scanner;

/**
 * Created by jslee on 2019-03-30.
 * 양념반 후라이드반
 */
public class Q16917 {
    public static void main(String[] args){
        int sp = 0, fp =0, hp = 0, x = 0, y = 0;
        int price1 = 0, price2 = 0, price3 = 0, result = 0;
        Scanner sc = new Scanner(System.in);
        sp = sc.nextInt();  //seasoning chicken price
        fp = sc.nextInt();  //fried chicken price
        hp = sc.nextInt();  //half chicken price
        x = sc.nextInt();
        y = sc.nextInt();

        //반반치킨을 두마리사면 양념 1, 후라이드 1가 된다.
        //반반 두마리가 양념 1, 후라이드 1 각각 산 가격보다 싼 경우
        if(sp + fp > hp * 2){
            //양념치킨 수가 더 큰 경우
            if(x > y){
                price1 = (hp * 2 * y) + (x-y) * sp;
                price2 = hp * 2 * x;
                price3 = Math.min(price1, price2);
            }else{
                price1 = (hp * 2 * x) + (y-x) * fp;
                price2 = hp * 2 * y;
                price3 = Math.min(price1, price2);
            }
            result = Math.min(sp * x + fp * y, price3);
        }else{
            result = sp * x + fp * y;
        }
        System.out.println(result);
    }
}
