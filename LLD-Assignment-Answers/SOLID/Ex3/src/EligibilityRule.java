// Common interface implemented by all eligibility rules.
public interface EligibilityRule {
    // Returns null when the rule passes, or a failure reason string when it fails.
    String check(StudentProfile student);
}

