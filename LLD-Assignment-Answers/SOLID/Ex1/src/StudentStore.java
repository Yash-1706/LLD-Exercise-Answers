import java.util.List;

// Storage abstraction so the implementation (e.g., FakeDb) can be swapped without changing callers.
public interface StudentStore {
    void save(StudentRecord r);
    int count();
    List<StudentRecord> all();
}
