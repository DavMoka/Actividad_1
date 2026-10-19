import java.util.ArrayList;

public class Spendings {

    public static class Spending {
        public String name;
        public int cost;

        public Spending(String name) {
            this.name = name;
            this.cost = 0;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }
    }

    public static ArrayList<Spending> spendings = new ArrayList<>();
    private static void add(String n) { spendings.add(new Spending(n)); }

    public static void load() {
        add("Alimentación");
        add("Refrigerios");
        add("Transporte");
        add("Telefonía");
        add("Otros");
    }

    public static int getTotal() {
        int total = 0;
        for(Spending spend : spendings) total += spend.cost;
        return total;
    }
    public static Spending getHighest() {
        Spending highest = spendings.get(0);
        for(Spending spend : spendings) if(spend.cost > highest.cost) highest = spend;
        return highest;
    }

}
