import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
    private int index;
    private int startTime;
    private int endTime;

    public Node(int index, int startTime, int endTime) {
        this.index = index;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    @Override
    public int compareTo(Node o) {
        if (this.startTime < o.startTime) {
            return -1;
        } else if (this.startTime == o.startTime) {
            return Integer.compare(this.endTime, o.endTime);
        } else return 1;
    }
}

public class Main {
    private static PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(Node::getEndTime));
    private static Node[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        temp = new Node[n];
        //강의 번호, 강의 시작 시간, 강의 종료
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            temp[i] = new Node(index, startTime, endTime);
        }
        Arrays.sort(temp);
        pq.add(temp[0]);
        int cnt = 1;

        if (temp.length == 1) {
            System.out.println(cnt);
            return;
        }
        for (int i = 1; i < temp.length; i++) {
            if (!pq.isEmpty()) {
                Node current = pq.peek();

                if (current.getEndTime() <= temp[i].getStartTime()) {
                    pq.remove();
                    pq.add(temp[i]);
                } else {
                    pq.add(temp[i]);
                    cnt++;
                }
            } else
                pq.add(temp[i]);
        }

        System.out.println(cnt);
    }
}