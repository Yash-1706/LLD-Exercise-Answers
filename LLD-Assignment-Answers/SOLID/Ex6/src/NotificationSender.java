// Abstract base class for senders; `send()` returns a SendResult rather than throwing exceptions.
public abstract class NotificationSender {
    protected final AuditLog audit;
    protected NotificationSender(AuditLog audit) { this.audit = audit; }
    public abstract SendResult send(Notification n);
}
