package magician;

public final class GreatMagician {
    private String notice;
    private static GreatMagician instance = null;

    public static GreatMagician getInstance() {
        if (instance == null) {
            instance = new GreatMagician();
        }
        return instance;
    }

    private GreatMagician() {
        this.notice = null;
    }

    private GreatMagician(final String notice) {
        this.notice = notice;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(final String notice) {
        this.notice = notice;
    }
}
