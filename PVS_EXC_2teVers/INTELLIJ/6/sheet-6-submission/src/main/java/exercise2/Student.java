package exercise2;

public class Student {
    private final String id;
    private final String name;

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
