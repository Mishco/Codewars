package kata.kyu6;

public class BouncingBall {

    private BouncingBall() {
    }

    public static int bouncingBall(double h, double bounce, double window) {
        if ((h <= 0) || (window >= h) || (bounce <= 0) || (bounce >= 1))
            return -1;

        int count = 0;
        double currentHeight = h;

        while (currentHeight > window) {
            count++;

            currentHeight *= bounce;

            if (currentHeight > window) {
                count++;
            }
        }
        return count;
    }
}
