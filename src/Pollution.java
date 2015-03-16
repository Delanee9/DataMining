class Pollution {
    private final Double nitricOxide;
    private final Double sulphurDioxide;
    private final Double ozone;

    public Pollution(Double nitricOxide, Double sulphurDioxide, Double ozone) {
        this.nitricOxide = nitricOxide;
        this.sulphurDioxide = sulphurDioxide;
        this.ozone = ozone;
    }

    public Double getNitricOxide() {
        return nitricOxide;
    }

    public Double getSulphurDioxide() {
        return sulphurDioxide;
    }

    public Double getOzone() {
        return ozone;
    }
}