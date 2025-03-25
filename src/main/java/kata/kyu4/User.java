package kata.kyu4;

public class User {
    public int rank;
    public int progress;

    public User() {
        this.rank = -8;
        this.progress = 0;
    }

    public int getRank() {
        return rank;
    }

    public int getProgress() {
        return progress;
    }

    public void incProgress(int activityRank) {
        if (activityRank < -8 || activityRank > 8 || activityRank == 0) {
            throw new IllegalArgumentException();
        }

        int diff = this.calculate_rank_diff(activityRank);

        if (diff <= -2) {
            this.progress += 0;  // No progress for activities two or more ranks below
        } else if (diff == -1) {
            this.progress += 1;  // Fixed 1 point for one rank below
        } else if (diff == 0 ) {
            this.progress += 3;  // Fixed 3 points for same rank
        } else {
            this.progress += 10 * diff * diff;  // Points formula for higher rank activities
        }

        this.update_rank();
    }

    private int calculate_rank_diff(int activity_rank) {
        if (this.rank < 0 && activity_rank > 0) {
            return activity_rank - this.rank - 1;
        } else if (this.rank > 0 && activity_rank < 0) {
            return activity_rank - this.rank + 1;
        } else {
            return activity_rank - this.rank;
        }
    }

    private void update_rank(){
        while (this.progress >= 100 && this.rank < 8) {
            this.progress -= 100;
            this.rank = next_rank(rank);
        }
        // If we reach max rank of 8, reset the extra progress
        if (rank == 8) {
            progress = 0;
        }
    }

    private int next_rank(int current_rank) {
        if (current_rank == -1) {
            return 1;
        } else {
            return current_rank;
        }
    }

}
