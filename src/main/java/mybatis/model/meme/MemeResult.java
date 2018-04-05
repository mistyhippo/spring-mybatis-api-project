package mybatis.model.meme;

public class MemeResult {

    String displayName;
    int totalVotesScore;
    String text0;
    String text1;
    MemeSum entityVotesSummary;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getTotalVotesScore() {
        return totalVotesScore;
    }

    public void setTotalVotesScore(int totalVotesScore) {
        this.totalVotesScore = totalVotesScore;
    }

    public String getText0() {
        return text0;
    }

    public void setText0(String text0) {
        this.text0 = text0;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public MemeSum getEntityVotesSummary() {
        return entityVotesSummary;
    }

    public void setEntityVotesSummary(MemeSum entityVotesSummary) {
        this.entityVotesSummary = entityVotesSummary;
    }

}
