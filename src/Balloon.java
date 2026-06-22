class Balloon extends Aircraft {
    private String name;
    private int longitude;
    private int latitude;
    private int height;

    public Balloon() {}

    public Balloon(String name, int longitude, int latitude, int height) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    @Override public void getInfo() {
        System.out.println("[Balloon] " + this.name + " at (" + this.longitude + ", " + this.latitude + ", " + this.height + ")");
    }

    public void fly() {
        if (this.height + 4 >= 100) {
            this. height = 100;
        } else {
            this.height += 4;
        }
    }
}