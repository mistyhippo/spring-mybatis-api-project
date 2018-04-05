package mybatis.model.meme;

public class MemeRoot {

    boolean success;
    int elapsedMS;
    String warning;
    MemeResult[] result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getElapsedMS() {
        return elapsedMS;
    }

    public void setElapsedMS(int elapsedMS) {
        this.elapsedMS = elapsedMS;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public MemeResult[] getResult() {
        return result;
    }

    public void setResult(MemeResult[] result) {
        this.result = result;
    }
}
