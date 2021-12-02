import java.util.Objects;

public class Beverage {
    private String type;
    private String name;

    public Beverage(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getBeverageName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beverage beverage = (Beverage) o;
        return Objects.equals(type, beverage.type) && Objects.equals(name, beverage.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name);
    }

    public String toString() {
        return String.format("[%s, %s]", this.name, this.type);
    }
}
