package algorithm.baekjoon.dynamic;

/*
 * 동적 계획법
 * 거스름돈 문제
 * C[j]를 j월을 거슬러 줄 때 필요한 최소 동전 개수라고 하자.
 * 동전이 100원, 400원, 500원 짜리가 있다고 할 때, (d1 = 500, d2 = 400, d3 = 100)
 * 500원짜리가 거스름돈에 포함된다면, C[j] = C[j-500] + 1 이고,
 * 400원짜리가 거스름돈에 포함된다면, C[j] = C[j-400] + 1 이고,
 * 100원짜리가 거스름돈에 포함된다면, C[j] = C[j-100] + 1 이다.
 * 
 * 최소 값이기 때문에 위의 예에선 위 3가지 경우 중 작은 값이 C[j]가 될 것이다.
 */
public class DynamicCoin {
	private int coins[] = {100,400,500};//동전 종류
	private int count[];				//최소개수
	
	public static void main(String[] args) {
		DynamicCoin dc = new DynamicCoin();
		System.out.println(dc.Dp(1200));
	}
	
	public int Dp(int value) {
		count = new int[value+1];
		count[0] = 0;
		for(int i = 1;i <= value;i++) {
			count[i] = 10000;			// 초기값 큰값으로 설정
		}
		for(int i = 1;i <= value;i++) {
			for(int j = 0;j < coins.length;j++) {	//거스름돈 개수만큼 반복
				if(i - coins[j] >= 0 && count[i] > count[i-coins[j]]+1) {//작은 값일 경우, 체인지
					count[i] = count[i-coins[j]]+1;	
					//System.out.println("잔돈 : "+i+", count["+i+"] = count["+i+"-"+coins[j]+"]+1 = "+count[i]);
				}
			}
		}
		return count[value];
	}
}
