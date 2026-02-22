// Base class for exporters.
// Contract: accept a non-null request and return an ExportResult (do not throw exceptions).
public abstract class Exporter {

    // Performs a null-check here so subclasses can assume the request is non-null.
    public ExportResult export(ExportRequest req) {
        if (req == null) {
            return ExportResult.error("request is null");
        }
        return doExport(req);
    }

    // Subclasses implement format-specific exporting logic here.
    protected abstract ExportResult doExport(ExportRequest req);
}
