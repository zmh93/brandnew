package test.observer;

public enum TheState {
    GORGEOUS(1),BEAUTIFUL(2),UGLY(3), PLAIN(4),;
    int val;

    TheState(int val) {
        this.val = val;
    }
}
