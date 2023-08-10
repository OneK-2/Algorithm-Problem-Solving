package Test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		Queue<Integer> onBridge = new LinkedList<Integer>();

		int sum = 0;
		int time = 0;
		for (int i : truck_weights) {
			while (true) {
				if (onBridge.isEmpty()) {
					onBridge.add(i);
					sum += i;
					time++;
					break;
				} else if (onBridge.size() == bridge_length) {
					sum -= onBridge.poll();
				} else {
					if (sum + i > weight) {
						onBridge.add(0);
						time++;
					} else {
						onBridge.add(i);
						sum += i;
						time++;
						break;
					}
				}

			}

		}
		time += bridge_length;

		return answer = time;
	}

}