class Balloon extends Aircraft {
    public Balloon() {}

    public Balloon(String name, int longitude, int latitude, int height) {
        super(name, longitude, latitude, height);
    }

    @Override public void getInfo() {
        System.out.println("[Balloon] " + this.name + " at (" + this.longitude + ", " + this.latitude + ", " + this.height + ")");
    }

    @Override public void fly() {
        if (this.height + 4 >= 100) {
            this. height = 100;
        } else {
            this.height += 4;
        }
    }

    @Override public void updateConditions(String weather) {
        if ("SUN".equals(weather)) {
            System.out.println("Balloon#" + this.name + ": Let's enjoy the good weather!");
        } else if ("RAIN".equals(weather)) {
            System.out.println("Balloon#" + this.name + ": Damn you rain!");
        }
    }
}