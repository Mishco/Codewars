package kata.kyu6;

import java.util.ArrayList;
import java.util.List;

public class SqInRect {

    private SqInRect() {}

    public static List<Integer> sqInRect(int lng, int wdth) {
        if (lng == wdth) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        while (lng > 0 && wdth > 0) {
            int squareArea = Math.min(lng, wdth);
            list.add(squareArea);

            if (lng < wdth) {
                wdth -= squareArea;
            } else {
                lng -= squareArea;
            }
        }


        return list;
    }
}
