package algorithm.baekjoon.graph;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 반복수열
 * 정의된 수열을 만들어가는 중에 반복되지 않는 수의 개수를 출력하는 문제
 * 그래프적으로 생각해보면, 한번만 방문하는 정점의 개수를 출력하는 것이다.
 */
public class Q2331 {
	static int[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();	//1<= A <= 9999
		int P = sc.nextInt();	//1<= P <= 5

		visited = new int[236197];	//최대 범위
		Arrays.fill(visited, 0);
		
		dfs(A, P);
		//System.out.println(next(A,P));
		int count = 0;
		for(int a : visited) {
			if(a == 1){//한번만 방문한 경우의 수를 센다.
				count++;
			}
		}
		System.out.println(count);
	}
	public static void dfs(int n, int p) {
	    visited[n]++;	//정점 방문
	    int next = next(n, p);
	    //System.out.println(next+" "+visited[n]+" ");
	    if(visited[next] <= 1) {
	    	dfs(next, p);
	    }
	}
	//다음 숫자 계산
	public static int next(int n, int p) {
		int result = 0;
		while(n > 0) {
			result += Math.pow(n%10, p);	//1의 자리부터 계산
			n /= 10;	//10을 나눔으로서 자리 수 교환
		}
		return result;
	}
}
