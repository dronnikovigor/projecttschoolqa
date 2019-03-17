package common;

public class Env {
    public static final String HOST = PropertyLoader.loadProperty("host");
    public static final String OS = PropertyLoader.loadProperty("os");
}
