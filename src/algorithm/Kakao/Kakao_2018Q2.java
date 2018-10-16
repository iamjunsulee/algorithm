package algorithm.Kakao;

import java.util.*;

/**
 * Created by jslee on 2018-09-15.
 */
public class Kakao_2018Q2 {
    public static void main(String[] args) {
        int[] stages = {2,1,2,6,2,4,3,3};
        int N = 5;
        int answer[] = solution(N, stages);
        for(int i : answer){
            System.out.print(i);
        }
    }
    public static int[] solution(int N, int[] stages){
        int[] answer = new int[N];

        double[] fail = new double[N];

        for(int i = 0;i < N;i++){
            int in = 0;
            int notClear = 0;
            answer[i] = i+1;
            for(int j = 0;j < stages.length;j++){
                boolean isIn = false;
                if((i+1) <= stages[j]){
                    in++;
                    //System.out.println("i+1 : "+(i+1)+",stage : "+stages[j]+", in :"+in);
                    isIn = true;
                }
                if((i+1) >= stages[j] && isIn){
                    notClear++;
                    //System.out.println("i+1 : "+(i+1)+",stage : "+stages[j]+", notClear :"+notClear);
                }
            }
            fail[i] = (double)notClear / (double)in;
        }

        List<Stage> list = new ArrayList<Stage>();
        int idx = 1;
        for(double rate : fail){
            list.add(new Stage(idx++, rate));
        }
        Collections.sort(list, new Comparator<Stage>() {
            @Override
            public int compare(Stage o1, Stage o2) {
                if(o1.getRate() > o2.getRate()){
                    return -1;
                }else if(o1.getRate() < o2.getRate()){
                    return 1;
                }else{
                    if(o1.getStage() < o2.getStage()){
                        return 0;
                    }
                }
                return 0;
            }
        });

        for(int i=0;i < N;i++){
            answer[i] = list.get(i).getStage();
        }
        return answer;
    }
}
class Stage{
    int stage;
    double rate;

    Stage(int stage, double rate){
        this.stage = stage;
        this.rate = rate;
    }
    public int getStage(){
        return this.stage;
    }
    public double getRate(){
        return this.rate;
    }
}
