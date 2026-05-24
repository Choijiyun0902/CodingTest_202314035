import java.util.*;

class Main_202314035_7 {
    // 인접 리스트에 저장할 노드 정보 클래스
    static class Node implements Comparable<Node> {
        int index; // 마을 번호
        int distance; // 소요 시간

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }
    }

    public int solution(int N, int[][] road, int K) {
        // 1. 그래프 초기화
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 2. 도로 정보 입력받기 (양방향 도로)
        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int c = r[2];
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        // 3. 최단 거리를 저장할 배열 초기화 (무한대로 설정)
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // 시작점(1번 마을) 설정
        distance[1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        // 4. 다익스트라 알고리즘 수행
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int dist = current.distance;
            int now = current.index;

            // 이미 처리된 적이 있는 더 짧은 경로라면 패스
            if (distance[now] < dist) {
                continue;
            }

            // 현재 마을과 연결된 다른 인접 마을들을 확인
            for (Node next : graph.get(now)) {
                int cost = dist + next.distance;
                // 현재 마을을 거쳐서 가는 것이 더 빠른 경우 업데이트
                if (cost < distance[next.index]) {
                    distance[next.index] = cost;
                    pq.offer(new Node(next.index, cost));
                }
            }
        }

        // 5. 최단 거리가 K 이하인 마을의 개수 세기
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (distance[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}
