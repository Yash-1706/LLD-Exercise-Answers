import java.nio.charset.StandardCharsets;

// Base class handles null requests; this subclass focuses on converting content to JSON.
public class JsonExporter extends Exporter {
    @Override
    protected ExportResult doExport(ExportRequest req) {
        String json = "{\"title\":\"" + escape(req.title) + "\",\"body\":\"" + escape(req.body) + "\"}";
        return new ExportResult("application/json", json.getBytes(StandardCharsets.UTF_8));
    }

    private String escape(String s) {
        if (s == null) return "";
        return s.replace("\"", "\\\"");
    }
}
