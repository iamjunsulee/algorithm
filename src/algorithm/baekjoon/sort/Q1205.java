package algorithm.baekjoon.sort;

/*
 * 유진이가 즐겨하는 디제이맥스 게임은 각각의 노래마다 랭킹 리스트가 있다. 이것은 매번 게임할 때 마다 얻는 점수가 비오름차순으로 저장되 있는 것이다.
 * 이 랭킹 리스트의 등수는 보통 위에서부터 몇 번째 있는 점수인지로 결정한다. 하지만, 같은 점수가 있을 때는 그러한 점수의 등수 중에 가장 작은 등수가 된다.
 * 예를 들어 랭킹 리스트가 100, 90, 90, 80일 때 각각의 등수는 1, 2, 2, 4등이 된다
 * 랭킹 리스트에 올라 갈 수 있는 점수의 개수 P가 주어진다. 그리고 리스트에 있는 점수 N개가 비오름차순으로 주어지고, 송유진의 새로운 점수가 주어진다.
 * 이 때, 송유진의 새로운 점수가 랭킹 리스트에서 몇 등 하는지 구하는 프로그램을 작성하시오. 만약 점수가 랭킹 리스트에 올라갈 수 없을 정도로 낮다면 -1을 출력한다.
 * 만약, 랭킹 리스트가 꽉 차있을 때, 새 점수가 이전 점수보다 더 좋을 때만 점수가 바뀐다. (예제 2)
 *
 * 첫째 줄에 N, 송유진의 새로운 점수, 그리고 P가 주어진다. P는 10보다 크거나 같고, 50보다 작거나 같고 N은 0보다 크거나 같고, P보다 작거나 같다.
 * 그리고 모든 점수는 2000000000보다 작거나 같은 정수이다. 둘째 줄에는 현재 랭킹 리스트에 있는 점수가 비오름차순으로 주어진다.
 *
 * 첫째 줄에 문제의 정답을 출력한다.
 *
 * <문제 해결과정>
 * 1. 내림차순으로 입력을 받는다 했으므로 따로 sorting은 필요없는 것 같다.
 * 2. 점수의 갯수와 랭킹리스트 갯수가 동일하다면 유진의 점수가 입력받은 젤 마지막 점수와 같거나 작을경우는 랭킹에 들수없기때문에 -1 출력한다.
 * 3. 그 경우가 아니라면 랭킹리스트 점수와 비교해가며 작을경우 순위를 계속 증가시켜준다.
 *
 * 결과 : 런타임 에러 => 배열의 공간문제는 아닌 거 같고, 시간이 오래 걸려서 발생하는 거 같기도 한데, 원인을 잘모르겠다.
 */
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1205 {
	public static void main(String[] args) throws IOException {
		//Scanner sc = new Scanner(System.in);
		//int n = sc.nextInt();
		//int score = sc.nextInt();
		//int p = sc.nextInt();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		long score = Long.parseLong(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		if(n < 0) {return;}
		st = new StringTokenizer(br.readLine());
		long[] scoreList = new long[n];
		
		for(int i=0;i<n;i++) {
			scoreList[i] = Long.parseLong(st.nextToken());
		}
		sort_descending(scoreList,n);
		int rank = 1; 
		if(n > 0) { 
			if(scoreList[n-1] >= score && n == p){
				rank = -1;
			}else{
				for(int j=0;j<n;j++){
					if(scoreList[j] > score){
						rank++;
					}else{
						break;
					}
				}
			}
		}
		bw.write(rank+"\n");
		bw.close();
		br.close(); 
	}
	
	public static void sort_descending(long[] num, int size){
		int max;
		long temp;
		for(int i=0;i<size-1;i++){
			max = i;
			for(int j=i;j<size;j++){
				if(num[j] > num[max]){
					max = j;
				}
			}
			temp = num[max];
			num[max] = num[i];
			num[i] = temp;
		}
	}
}

