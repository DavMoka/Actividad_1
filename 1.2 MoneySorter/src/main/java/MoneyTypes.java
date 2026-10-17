
import java.util.ArrayList;

public class MoneyTypes {

    public static class MoneyType {
        public String type;
        public int value;
        public int amount;

        public MoneyType(String t, int v) {
            this.type = t;
            this.value = v;
            this.amount = 0;
        }
        public MoneyType(String t, int v, int a) {
            this.type = t;
            this.value = v;
            this.amount = a;
        }

        public String getName() { return this.type + "s de $" + this.value; }
    }
    
    public static ArrayList<MoneyType> moneyTypes = new ArrayList<>();

    private static void addType(String t, int v) { moneyTypes.add(new MoneyType(t, v)); }

    public static void load() {
        addType("Billete", 500);
        addType("Billete", 200);
        addType("Billete", 100);
        addType("Billete", 50);
        addType("Billete", 20);
        addType("Moneda", 10);
        addType("Moneda", 5);
        addType("Moneda", 2);
        addType("Moneda", 1);
    }

    public static ArrayList<MoneyType> sortAmount(int totalAmount) {
        ArrayList<MoneyType> results = new ArrayList<>();

        for(MoneyType mt : moneyTypes) {
            int typeAmount = totalAmount / mt.value;

            totalAmount -= typeAmount * mt.value;
            results.add(new MoneyType(mt.type, mt.value, typeAmount));
        }

        return results;
    }
}
