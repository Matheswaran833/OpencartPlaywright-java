package utilities;

public class VideoTraceManager {
    private static ThreadLocal<String> videoPath = new ThreadLocal<>();
    private static ThreadLocal<String> tracePath = new ThreadLocal<>();

    public static void setVideoPath(String path) {
        videoPath.set(path);
    }

    public static String getVideoPath() {
        return videoPath.get();
    }

    public static void removeVideoPath() {
        videoPath.remove();
    }

    public static void setTracePath(String path) {
        tracePath.set(path);
    }

    public static String getTracePath() {
        return tracePath.get();
    }

    public static void removeTracePath() {
        tracePath.remove();
    }

    public static void clear() {
        videoPath.remove();
        tracePath.remove();
    }
}
