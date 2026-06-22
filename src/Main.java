public class Main {
    public static void main(String[] args) {
        Aircraft balloon = new Balloon("balloon", 100, 200, 90);
        Aircraft jetPlane = new JetPlane("jet", 400, 500, 600);

        Aircraft[] array = {balloon, jetPlane};

        for (Aircraft aircraft : array) {
            aircraft.getInfo();
        }

        ((Balloon)balloon).fly();
        ((JetPlane)jetPlane).fly();
        ((Balloon)balloon).fly();
        ((JetPlane)jetPlane).fly();
        ((Balloon)balloon).fly();
        ((JetPlane)jetPlane).fly();

        for (Aircraft aircraft : array) {
            aircraft.getInfo();
        }
    }
}