package algorithm.Kakao;

import java.util.*;

/**
 * Created by jslee on 2018-09-15.
 */
public class Kakao_2018Q5 {
    public static void main(String[] args){
        int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};

        int[][] answer = solution(nodeinfo);
        for(int i = 0;i < answer.length;i++){
            for(int j = 0;j < answer[i].length;j++){
                System.out.print(answer[i][j]+ " ");
            }
            System.out.println();
        }
    }
    public static int[][] solution(int[][] nodeinfo) {
        int size = nodeinfo.length;
        int[][] answer = new int[2][size];
        Node node[] = new Node[size];
        //2차원 배열가지고 x좌표, y좌표, 노드번호를 가지는 노드생성
        for(int i = 0;i < size;i++){
            int x = nodeinfo[i][0];
            int y = nodeinfo[i][1];

            node[i] = new Node(x, y, i+1);
        }

        List<Node> list = new ArrayList<Node>();
        for(Node n : node){
            list.add(n);
        }
        //y축을 기준으로 내림차순 정렬, y축이 같을 경우, x축 기준으로 내림차순 정렬
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.y > o2.y){
                    return -1;
                }else if(o1.y < o2.y){
                    return 1;
                }else{
                    if(o1.x > o2.x){
                        return -1;
                    }else if(o1.x < o2.x){
                       return 1;
                    }
                }
                return 0;
            }
        });
        //정렬 후, 트리 만듬
        Tree tree = new Tree();
        for(Node a : list){
            tree.insert(a);
        }
        tree.preOrder(list.get(0));     //전위순회 실행
        tree.postOrder(list.get(0));    //후위순회 실행
        List<Integer> pre = tree.pre;   //결과값
        List<Integer> post = tree.post; //결과값

        //해당 결과값 배열에 저장
        for(int i = 0;i < size;i++){
            answer[0][i] = pre.get(i);
            answer[1][i] = post.get(i);
        }
        return answer;
    }
}
class Node{
    int x;
    int y;
    int number;

    Node left;
    Node right;

    Node(int x, int y, int number){
        this.x = x;
        this.y = y;
        this.number = number;
    }
}

class Tree{
    Node root;
    List<Integer> pre = new ArrayList<Integer>();
    List<Integer> post = new ArrayList<Integer>();
    Tree(){
        root = null;
    }

    public void insert(Node insert){
        if(root == null){
            root = insert;
        }else{
            Node current = root;
            Node parent;

            while(true){
                parent = current;   //부모노드설정
                if(insert.x < current.x){
                    current = current.left;
                    if (current == null)        // 현재 위치에 삽입 가능
                    {
                        parent.left = insert;
                        return;
                    }
                }else
                {
                    current = current.right;
                    if (current == null)        // 현재 위치에 삽입 가능
                    {
                        parent.right = insert;
                        return;
                    }
                }
            }
        }
    }
    public void preOrder(Node root){
        if(root != null){
            pre.add(root.number);
            //System.out.print(root.number+ " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public void postOrder(Node root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            post.add(root.number);
            //System.out.print(root.number+ " ");
        }
    }
}