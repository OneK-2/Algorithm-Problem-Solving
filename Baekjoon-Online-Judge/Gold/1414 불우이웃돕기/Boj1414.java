import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//최소 스패닝 트리
//a부터 z는 1부터 26을 나타내고, A부터 Z는 27부터 52
//N은 50보다 작거나 같은 자연수
public class Main {
    static int[] parent;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    // n개의 방에 한개의 컴퓨터
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); //컴퓨터 개수
        int totalLen = 0; // 총 랜선 길이 변수
        int sum = 0; // 정점을 연결하는데 사용된 랜선 길이의 합

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                int num = (int) str.charAt(j);
                if (num >= 'a' && n <= 'z') {// a부터 z는 1부터 26
                    num -= 'a' - 1;
                } else if (num >= 'A' && num <= 'Z') { // A부터 Z는 27부터 52
                    num -= 38;
                } else if (num == '0') // 0일때
                    num = 0;

                if (num != 0) { //랜선이 존재하는 경우 우선순위 큐에 추가
                    pq.add(new Edge(i, j, num));
                }
                totalLen += num; // 랜선의 총 길이 누적
            }
        }

        // parent 초기화
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        int cnt = 0; // 이미 연결된 간선의 개수
        while (!pq.isEmpty()) {
            if (cnt == n - 1) break; // cnt가 n-1이 되면 모든 정점을 연결한것으로 판단

            Edge now = pq.poll(); // 가장 가중치가 작은 간선을 꺼낸다.
            if (find(now.c1) != find(now.c2)) { // 두 정점이 같은 그룹에 속해있지 않다면
                sum += now.cost; //랜선 길이를 더하고
                union(now.c1, now.c2); // 두 정점을 하나의 그룹으로 합친다.`
                cnt++; // 정점이 연결되었므로 cnt증가
            }
        }

        if (cnt < n - 1) { // 모든 정점이 연결되지 않았다면 -1 반환
            System.out.println(-1);
        } else { // 연결되었으면 총 랜선 길이에서 사용된 랜선 길이를 뺸 값을 출력
            System.out.println(totalLen - sum);
        }
    }

    private static int find(int a) {
        if (a == parent[a]) { //부모가 자기 자신이라면 해당 정점이 그룹의 루트
            return a;
        }
        return parent[a] = find(parent[a]); // 부모를 따라가면서 루트를 찾는다
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        // a 와 b의 루트를 찾아서 그룹화
        if (a != b) {
            parent[b] = a;
        }
    }
}

class Edge implements Comparable<Edge> { // 두 정점과 가중치를 위한 클래스
    int c1;
    int c2;
    int cost; //랜선 길이

    public Edge(int c1, int c2, int cost) {
        super();
        this.c1 = c1;
        this.c2 = c2;
        this.cost = cost; //랜선 길이
    }

    @Override
    public int compareTo(Edge o) { // 길이가 짧은 순서로 정렬
        return this.cost - o.cost;
    }
}