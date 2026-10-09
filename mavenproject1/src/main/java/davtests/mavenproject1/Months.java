package davtests.mavenproject1;



public class Months {
    public static class Month {
        private String name;
        private int value;
        private int days;

        public Month(int value, String name, int days) {
            this.value = value;
            this.name = name;
            this.days = days;
        }

        public String getName() { return this.name; }
        public int getValue() { return this.value; }
        public int getDays() { return this.days; }
    }

    public static Month[] Months = {
        new Month( 1, "Enero", 31),
        new Month( 2, "Febrero", 29),
        new Month( 3, "Marzo", 31),
        new Month( 4, "Abril", 30),
        new Month( 5, "Mayo", 31),
        new Month( 6, "Junio", 30),
        new Month( 7, "Julio", 31),
        new Month( 8, "Agosto", 31),
        new Month( 9, "Septiembre", 30),
        new Month(10, "Octubre", 31),
        new Month(11, "Noviembre", 30),
        new Month(12, "Diciembre", 31)
    };

    public static Month getMonth(String name) {
        for(Month m : Months) if(m.getName().equals(name)) return m;
        return new Month(0, "", 0);
    }
}
