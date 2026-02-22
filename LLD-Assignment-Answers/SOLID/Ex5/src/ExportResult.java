// Represents exporter outcome: success or failure (used instead of throwing exceptions).
public class ExportResult {
    public final String contentType;
    public final byte[] bytes;
    public final boolean success;
    public final String errorMessage;

    public ExportResult(String contentType, byte[] bytes) {
        this.contentType = contentType;
        this.bytes = bytes;
        this.success = true;
        this.errorMessage = null;
    }

    private ExportResult(String errorMessage) {
        this.contentType = null;
        this.bytes = new byte[0];
        this.success = false;
        this.errorMessage = errorMessage;
    }

    // Helper to create a failed ExportResult with an error message.
    public static ExportResult error(String message) {
        return new ExportResult(message);
    }
}
