class Solution {

    int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};

    public int shortestPathBinaryMatrix(int[][] grid) {

        Node node = new Node(0, 0, 2);
        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(node);

        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        } else if (n <= 2) {
            return n;
        }
        while (!queue.isEmpty()) {
            Node cur = queue.removeFirst();
            int x = cur.x;
            int y = cur.y;
            int step = cur.step;
            for (int i = 0; i < 8; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (0 <= newX && newX < n && 0 <= newY && newY < n && grid[newX][newY] == 0) {
                    //找到终点
                    if (newX == n - 1 && newY == n - 1) {
                        return step;
                    }
                    queue.addLast(new Node(newX, newY, step + 1));
                    grid[newX][newY] = 1; //标记已遍历过，避免重复
                }
            }
        }
        return -1;
    }

    static class Node {
        int x;
        int y;
        int step;

        public Node(int start, int end, int step) {
            this.x = start;
            this.y = end;
            this.step = step;
        }
    }

}
