class Centroid {
    private final double nitricOxide;
    private final double sulphurDioxide;
    private final double ozone;

    public Centroid(double nitricOxide, double sulphurDioxide, double ozone) {
        this.nitricOxide = nitricOxide;
        this.sulphurDioxide = sulphurDioxide;
        this.ozone = ozone;
    }

    public double getNitricOxide() {
        return nitricOxide;
    }

    public double getSulphurDioxide() {
        return sulphurDioxide;
    }

    public double getOzone() {
        return ozone;
    }
}
