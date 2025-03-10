package kata.kyu4;

public class TimeFormatter {

    private TimeFormatter() {
    }

    public static String formatDuration(int seconds) {
        if (seconds <= 0) {
            return "now";
        }

        StringBuilder result = new StringBuilder();
        int[] units = new int[]{31536000, 86400, 3600, 60, 1};
        String[] words = new String[]{"year", "day", "hour", "minute", "second"};

        for (int i = 0; i < 5; i++) {
            if (seconds >= units[i]) {
                int remainder = seconds / units[i];
                seconds = seconds % units[i];

                if (result.isEmpty())
                    result.append(remainder).append(" ").append(words[i]).append(remainder > 1 ? "s" : "");
                else
                    result.append((seconds == 0) ? " and " : ", ").append(remainder).append(" ").append(words[i]).append(remainder > 1 ? "s" : "");
            }
        }
        return result.toString();
    }


}
