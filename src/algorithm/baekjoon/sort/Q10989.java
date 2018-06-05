package algorithm.baekjoon.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*
- * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
- *
- * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.
- * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
- *
- * <문제해결과정> 시간제한 : 5초, 메모리제한 : 8MB
- * 1. sorting algorithm 중에 제일 빠른 퀵 정렬을 사용해보았지만, 시간초과.
- * 2. pivot 위치에 따른 시간 초과인가해서 pivot 위치를 바꿔가며 해봤지만 여전히 시간초과 혹은 결과값이 제대로 나오지 않았다.
- * 3. sorting algorithm으로 접근하는 문제가 아닌거같다는 결론을 내렸다.
- * 4. 10
-	   5
-	   2
-	   3
-	   1
-	   4
-	   2
-	   3
-	   5
-	   1
-	   7
- * 왜 입력받는 형식이 한줄로 입력을 받는지 의문이 생겼고, scanner의 경우 입출력이 느리다는 사실과 BufferedReader는 줄단위로 입력을 받는다는 것이 생각났다.
- * 그래서 입출력 방식부터 변경
- * 5. 여기서 문제를 다시 보자. 데이터의 사이즈 수는 1 ~ 10,000,000 인데반해 숫자의 크기는 10,000을 벗어나지 않는다고 한다. 이 말은 10,000보다 작거나 같은 수가 반복된다는 뜻.
- * 6. 배열은 0부터 인덱스가 시작되므로 전체 사이즈를 10,001로 정하고, 입력받는 숫자의 갯수를 배열에 저장한다.
- * 7. 갯수가 0이 아니라면 그 갯수만큼 숫자를 출력해주면 된다.
- */
public class Q10989 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//Scanner sc = new Scanner(System.in);
		//int size = sc.nextInt();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = Integer.parseInt(br.readLine());
		int[] count = new int[10001];

		for(int i=0;i<size;i++) {
			count[Integer.parseInt(br.readLine())]++;
		}

		for(int i=1;i<=10000;i++) {
			if(count[i]>0) {
				for(int j=0;j<count[i];j++) {
					bw.write(i+"\n");
				}
			}
		}
		br.close();
		bw.close();
	}
}
