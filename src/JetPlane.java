class JetPlane extends Aircraft {
    public JetPlane() {}

    public JetPlane(String name, int longitude, int latitude, int height) {
        super(name, longitude, latitude, height);
    }

    @Override public void getInfo() {
        System.out.println("[JetPlane] " + this.name + " at (" + this.longitude + ", " + this.latitude + ", " + this.height + ")");
    }

    @Override public void fly() {
        this.latitude += 10;
    }

    @Override public void updateConditions(String weather) {
        if ("SUN".equals(weather)) {
            System.out.println("JetPlane#B1: Let's enjoy the good weather!");
        } else if ("RAIN".equals(weather)) {
            System.out.println("JetPlane#B1: Damn you rain!");
        }
    }
}