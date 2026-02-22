import java.util.List;

// Abstraction for invoice persistence; decouples storage from business logic.
public interface InvoiceStore {
    void save(String invoiceId, String content);
    int countLines(String invoiceId);
}

