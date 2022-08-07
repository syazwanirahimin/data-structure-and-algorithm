import java.lang.reflect.Type;

public class Pet {

    private final String name;
    private final int age;
    private final Type type;

    public Pet(String name, int age, Type type) {
        super();
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Pet [name=" + name + ", age=" + age + "]";
    }
}