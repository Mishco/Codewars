package kata.kyu5;

public class Greed {
    private Greed() {
    }

    public static int greedy(int[] dice) {
        int[] diceCount = new int[7];
        int totalScore = 0;

        for (int die : dice) {
            diceCount[die]++;
        }

        for (int i = 0; i < 7; i++) {
            if (diceCount[i] >= 3) {
                switch (i) {
                    case 1:
                        totalScore += 1000;
                        break;
                    case 2:
                        totalScore += 200;
                        break;
                    case 3:
                        totalScore += 300;
                        break;
                    case 4:
                        totalScore += 400;
                        break;
                    case 5:
                        totalScore += 500;
                        break;
                    case 6:
                        totalScore += 600;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + i);
                }
                diceCount[i] -= 3;
            }
        }

        totalScore += diceCount[1] * 100;
        totalScore += diceCount[5] * 50;


        return totalScore;
    }
}
