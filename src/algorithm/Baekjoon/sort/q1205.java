package algorithm.Baekjoon.sort;

/*
 * �����̰� ����ϴ� �����̸ƽ� ������ ������ �뷡���� ��ŷ ����Ʈ�� �ִ�. �̰��� �Ź� ������ �� ���� ��� ������ ������������� ����� �ִ� ���̴�.
 * �� ��ŷ ����Ʈ�� ����� ���� ���������� �� ��° �ִ� ���������� �����Ѵ�. ������, ���� ������ ���� ���� �׷��� ������ ��� �߿� ���� ���� ����� �ȴ�.
 * ���� ��� ��ŷ ����Ʈ�� 100, 90, 90, 80�� �� ������ ����� 1, 2, 2, 4���� �ȴ�
 * ��ŷ ����Ʈ�� �ö� �� �� �ִ� ������ ���� P�� �־�����. �׸��� ����Ʈ�� �ִ� ���� N���� ������������� �־�����, �������� ���ο� ������ �־�����. 
 * �� ��, �������� ���ο� ������ ��ŷ ����Ʈ���� �� �� �ϴ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. ���� ������ ��ŷ ����Ʈ�� �ö� �� ���� ������ ���ٸ� -1�� ����Ѵ�.
 * ����, ��ŷ ����Ʈ�� �� ������ ��, �� ������ ���� �������� �� ���� ���� ������ �ٲ��. (���� 2)
 * 
 * ù° �ٿ� N, �������� ���ο� ����, �׸��� P�� �־�����. P�� 10���� ũ�ų� ����, 50���� �۰ų� ���� N�� 0���� ũ�ų� ����, P���� �۰ų� ����. 
 * �׸��� ��� ������ 2000000000���� �۰ų� ���� �����̴�. ��° �ٿ��� ���� ��ŷ ����Ʈ�� �ִ� ������ ������������� �־�����.
 * 
 * ù° �ٿ� ������ ������ ����Ѵ�.
 * 
 * <���� �ذ����>
 * 1. ������������ �Է��� �޴´� �����Ƿ� ���� sorting�� �ʿ���� �� ����.
 * 2. ������ ������ ��ŷ����Ʈ ������ �����ϴٸ� ������ ������ �Է¹��� �� ������ ������ ���ų� �������� ��ŷ�� ������⶧���� -1 ����Ѵ�.
 * 3. �� ��찡 �ƴ϶�� ��ŷ����Ʈ ������ ���ذ��� ������� ������ ��� ���������ش�.
 * 
 * ��� : ��Ÿ�� ���� => �迭�� ���������� �ƴ� �� ����, �ð��� ���� �ɷ��� �߻��ϴ� �� ���⵵ �ѵ�, ������ �߸𸣰ڴ�.  
 */
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class q1205 {
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

