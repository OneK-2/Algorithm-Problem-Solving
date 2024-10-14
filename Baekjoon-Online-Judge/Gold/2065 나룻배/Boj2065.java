import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 나룻배 최대 인원
        int t = Integer.parseInt(st.nextToken()); // 이동시간
        int N = Integer.parseInt(st.nextToken()); //
        int[] result = new int[N];
        PriorityQueue<Node> leftPq = new PriorityQueue<>();
        PriorityQueue<Node> rightPq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int arriveTime = Integer.parseInt(st.nextToken()); //도착시간
            String arrivePlace = st.nextToken(); // 도착 정박장
            if (arrivePlace.equals("left")) {
                leftPq.offer(new Node(i, arriveTime, arrivePlace));
            } else if (arrivePlace.equals("right")) {
                rightPq.offer(new Node(i, arriveTime, arrivePlace));
            }
        }

        int curTime = 0;
        int people = M;
        boolean flag = false; //false를 left로 생각
        while (!leftPq.isEmpty() || !rightPq.isEmpty()) {
            while (!flag) {
                //왼쪽에 정박한 상태로 M만큼 사람 태운다.
                //현재 시간보다 작은 경우에만.
                boolean fuck = false;
                while (people-- > 0) {
                    if (leftPq.isEmpty()) {
                        break;
                    }
                    if (leftPq.peek().arriveTime <= curTime) {
                        result[leftPq.peek().idx] = curTime + t;
                        leftPq.poll();
                        fuck = true;
                        if (leftPq.isEmpty()) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                // 사람이 탔어.
                if (fuck) {
                    flag = true;
                    curTime += t;
                } else {
                    //사람 못탐
                    int left = 0;
                    int right = 0;
                    if (rightPq.isEmpty()) {
                        right = 100000000;
                    } else {
                        right = rightPq.peek().arriveTime;
                    }
                    if (leftPq.isEmpty()) {
                        left = 100000000;
                    } else {
                        left = leftPq.peek().arriveTime;
                    }

                    if (left > right) {
                        int tmp = Math.max(curTime, right);
                        curTime = tmp + t;
                        flag = true;
                    } else {
                        if (left == 100000000 && right == 100000000) { // 둘다 비었을 때
                            break;
                        }
                        curTime = left;
                    }
                }
                people = M;

            }

            while (flag) {
                boolean fuck = false;
                while (people-- > 0) {
                    if (rightPq.isEmpty()) {
                        break;
                    }
                    if (rightPq.peek().arriveTime <= curTime) {
                        result[rightPq.peek().idx] = curTime + t;
                        rightPq.poll();
                        fuck = true;
                        if (rightPq.isEmpty()) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                //사람 탔음
                if (fuck) {
                    flag = false;
                    curTime += t;
                } else { // 못탔음
                    int left = 0;
                    int right = 0;
                    if (rightPq.isEmpty()) {
                        right = 100000000;
                    } else {
                        right = rightPq.peek().arriveTime;
                    }
                    if (leftPq.isEmpty()) {
                        left = 100000000;
                    } else {
                        left = leftPq.peek().arriveTime;
                    }

                    if (left < right) {
                        int tmp = Math.max(curTime, left);
                        curTime = tmp + t;
                        flag = false;
                    } else {
                        if (left == 100000000 && right == 100000000) { // 둘다 비었을 때
                            break;
                        }
                        curTime = right;
                    }
                }
                people = M;
            }


        }
        for (int i = 0; i < N; i++) {
            System.out.println(result[i]);
        }
    }
}

class Node implements Comparable<Node> {
    int idx = 0;
    int arriveTime = 0;
    String arrivePlace;

    public Node(int idx, int arriveTime, String arrivePlace) {
        this.idx = idx;
        this.arriveTime = arriveTime;
        this.arrivePlace = arrivePlace;
    }

    @Override
    public int compareTo(Node o) {
        return this.arriveTime - o.arriveTime;
    }
}


/**
 * 1. 정박장 도착하면 해당 정박장 가는 손님 다내리기
 * 2. 기다리던 손님 최대치로 탑승. 가장 오래 기다린 순서
 * 3. 다 태우고 반대편으로 이동하기
 * 4. 기다리는 손님이 없으면 다음 손님을 기다린다.
 * 5. 기다리는 중 반대편에 손님 생기면 해당 정박장으로 이동.
 */