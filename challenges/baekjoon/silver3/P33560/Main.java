package challenges.baekjoon.silver3.P33560;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int getReward(int score){
        if(score>250) return 4;
        else if(score>=95) return 3;
        else if(score>=65) return 2;
        else if(score>=35) return 1;
        else return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dice = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        int reward1 = 0, reward2 = 0, reward3 = 0, reward4 = 0;

        // 게임 상태 초기화
        int score = 0;
        int totalTime = 0;
        int scorePerTurn = 1;
        int timePerTurn = 4;

        for (int i = 0; i < N; i++) {
            int currentDice = dice[i];

            // 게임 시작 전에 시간 초과 확인
            if (totalTime + timePerTurn > 240) {
                int reward = getReward(score);
                if (reward == 1) reward1++;
                else if (reward == 2) reward2++;
                else if (reward == 3) reward3++;
                else if (reward == 4) reward4++;

                // 게임 상태 초기화
                score = 0;
                totalTime = 0;
                scorePerTurn = 1;
                timePerTurn = 4;
            }

            // 여전히 플레이 가능하면 턴 실행
            if (totalTime + timePerTurn <= 240) {
                totalTime += timePerTurn;
                score += scorePerTurn;

                switch (currentDice) {
                    case 1:
                        // 게임 종료
                        int reward = getReward(score);
                        if (reward == 1) reward1++;
                        else if (reward == 2) reward2++;
                        else if (reward == 3) reward3++;
                        else if (reward == 4) reward4++;

                        // 상태 초기화
                        score = 0;
                        totalTime = 0;
                        scorePerTurn = 1;
                        timePerTurn = 4;
                        break;

                    case 2:
                        if (scorePerTurn > 1) {
                            scorePerTurn /= 2;
                        } else {
                            timePerTurn += 2;
                        }
                        break;

                    case 3:
                        // 아무 일 없음
                        break;

                    case 4:
                        totalTime += 56;
                        break;

                    case 5:
                        if (timePerTurn > 1) {
                            timePerTurn--;
                        }
                        break;

                    case 6:
                        if (scorePerTurn < 32) {
                            scorePerTurn *= 2;
                        }
                        break;
                }
            }
        }

        System.out.println(reward1);
        System.out.println(reward2);
        System.out.println(reward3);
        System.out.println(reward4);


    }

}
