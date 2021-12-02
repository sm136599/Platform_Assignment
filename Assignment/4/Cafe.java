import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class Cafe {
    private String name;
    private HashMap<String, Beverage> menus = new HashMap<>();

    public Cafe(String name) {
        this.name = name;
    }

    public String toString() {
    
        String msg = " Cafe Name: " + name + " Beverage Count: " + menus.size() + "\n";
        Iterator<Beverage> values = menus.values().iterator();
        while(values.hasNext()) {
            msg += "\t" + values.next() + "\n";
        }
        return msg;
    }

    public void addBeverage(Beverage newBeverage) {
        menus.put(newBeverage.getBeverageName(), newBeverage);
        
    }

    public void removeAllBeverage() {
        menus.clear();
        
    }

    public Beverage findBeverage(String name, String type) {
        
        Iterator<Beverage> values = menus.values().iterator();
        Beverage beverage = new Beverage(name, type);
        while (values.hasNext()) {
            if (values.next().equals(beverage)) return beverage;
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cafe cafe = (Cafe) o;
        return Objects.equals(name, cafe.name) && Objects.equals(menus, cafe.menus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, menus);
    }
}
