package kata.kyu4;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class User {

    private static final int POINTS_PER_RANK = 100;
    public int rank = Rank.KYU_LEVEL_8.getRank();
    public int progress;

    public void incProgress(final int rank) {
        Rank currentRank = Rank.fromRank(this.rank);
        if (currentRank == Rank.DAN_LEVEL_8) {
            return;
        }
        int points = currentRank.calculatePoints(Rank.fromRank(rank));
        progress += points;

        int ranksUp = progress / POINTS_PER_RANK;
        for (int i = 0; i < ranksUp; i++) {
            currentRank = currentRank.next();
            this.rank = currentRank.getRank();
        }

        progress = currentRank == Rank.DAN_LEVEL_8 ? 0 : progress % POINTS_PER_RANK;
    }

    private enum Rank {
        KYU_LEVEL_8(-8, 0),
        KYU_LEVEL_7(-7, 1),
        KYU_LEVEL_6(-6, 2),
        KYU_LEVEL_5(-5, 3),
        KYU_LEVEL_4(-4, 4),
        KYU_LEVEL_3(-3, 5),
        KYU_LEVEL_2(-2, 6),
        KYU_LEVEL_1(-1, 7),
        DAN_LEVEL_1(1, 8),
        DAN_LEVEL_2(2, 9),
        DAN_LEVEL_3(3, 10),
        DAN_LEVEL_4(4, 11),
        DAN_LEVEL_5(5, 12),
        DAN_LEVEL_6(6, 13),
        DAN_LEVEL_7(7, 14),
        DAN_LEVEL_8(8, 15);

        private static final Map<Integer, Rank> RANKS_BY_VALUE = Stream.of(values())
                .collect(Collectors.toMap(Rank::getRank, rank -> rank));

        private static final Map<Integer, Rank> RANKS_BY_ORDER = Stream.of(values())
                .collect(Collectors.toMap(Rank::getOrder, rank -> rank));

        private final int rank;
        private final int order;

        Rank(int rank, int order) {
            this.rank = rank;
            this.order = order;
        }

        public int getRank() {
            return rank;
        }

        public int getOrder() {
            return order;
        }

        public static Rank fromRank(final int rank) {
            return RANKS_BY_VALUE.getOrDefault(rank, null);
        }

        public Rank next() {
            return RANKS_BY_ORDER.getOrDefault(order + 1, this);
        }

        public int calculatePoints(final Rank activityRank) {
            int difference = activityRank.order - this.order;
            return switch (difference) {
                case 0 -> 3;
                case -1 -> 1;
                case -2, -3, -4 -> 0;
                default -> 10 * difference * difference;
            };
        }
    }
}