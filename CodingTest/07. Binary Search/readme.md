# 이진 탐색
- 정렬되어 있는 리스트에서 탐색 범위를 절반씩 좁혀가며 데이터를 탐색하는 방법
  - 이진 탐색은 시작점, 끝점, 중간점을 이용하여 탐색 범위를 설정
  - 찾으려는 데이터와 중간점 위치에 있는 데이터를 반복적으로 비교
- 단계마다 탐색 범위를 2로 나누는 것과 동일하므로 연산 횟수는 log<sub>2</sub>N에 비례
- 이진 탐색은 탐색 범위를 절반씩 줄이며, 시간복잡도는 O(logN)을 보장
