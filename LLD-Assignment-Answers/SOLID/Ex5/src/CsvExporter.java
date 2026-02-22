import java.nio.charset.StandardCharsets;

// Escapes newlines and commas to keep CSV structure intact.
public class CsvExporter extends Exporter {
    @Override
    protected ExportResult doExport(ExportRequest req) {
        String body = req.body == null ? "" : sanitizeForCsv(req.body);
        String csv = "title,body\n" + req.title + "," + body + "\n";
        return new ExportResult("text/csv", csv.getBytes(StandardCharsets.UTF_8));
    }

    private String sanitizeForCsv(String value) {
        return value.replace("\n", " ").replace(",", " ");
    }
}
