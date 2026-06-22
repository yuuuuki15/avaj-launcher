public class Helicopter extends Aircraft {
    Helicopter(String name, int longitude, int latitude, int height) {
        super(name, longitude, latitude, height);
    }

    @Override public void getInfo() {
        System.out.println("[Helicopter] " + this.name + " at (" + this.longitude + ", " + this.latitude + ", " + this.height + ")");
    }

    @Override public void fly() {
        this.longitude += 10;
        this.height += 2;
    }

    @Override public void updateConditions(String weather) {
        if ("SUN".equals(weather)) {
            System.out.println("Helicopter#" + this.name + ": Let's enjoy the good weather!");
        } else if ("RAIN".equals(weather)) {
            System.out.println("Helicopter#" + this.name + ": Damn you rain!");
        }
    }
}
