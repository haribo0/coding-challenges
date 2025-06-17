package challenges.baekjoon.silver2.p2477;

import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int dir, len;
        public Edge(int dir, int len) {
            this.dir = dir;
            this.len = len;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int K = Integer.parseInt(br.readLine());
        Edge[] edges = new Edge[6];
        
        int maxWidth = 0, maxHeight = 0;
        int maxWidthIdx = -1, maxHeightIdx = -1;

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(dir, len);

            if (dir == 1 || dir == 2) {
                if (len > maxWidth) {
                    maxWidth = len;
                    maxWidthIdx = i;
                }
            } else {
                if (len > maxHeight) {
                    maxHeight = len;
                    maxHeightIdx = i;
                }
            }
        }

        int smallWidth = Math.abs(edges[(maxHeightIdx + 3) % 6].len);
        int smallHeight = Math.abs(edges[(maxWidthIdx + 3) % 6].len);

        int area = (maxWidth * maxHeight) - (smallWidth * smallHeight);

        System.out.println(area * K);
    }
}
