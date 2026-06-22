class JetPlane extends Aircraft {
    public JetPlane() {}

    public JetPlane(String name, int longitude, int latitude, int height) {
        super(name, longitude, latitude, height);
    }

    @Override public void getInfo() {
        System.out.println("[JetPlane] " + this.name + " at (" + this.longitude + ", " + this.latitude + ", " + this.height + ")");
    }

    public void fly() {
        this.latitude += 10;
    }
}