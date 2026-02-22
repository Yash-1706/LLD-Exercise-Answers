// Generic numeric utility methods used across rules and checks.
public class Numbers {
    public static double clamp(double x, double a, double b) {
        return Math.max(a, Math.min(b, x));
    }
}
