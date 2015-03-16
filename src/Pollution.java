class Pollution {
    private final Double nitricOxide;
    private final Double sulphurDioxide;
    private final Double ozone;

    public Pollution(String nitricOxide, String sulphurDioxide, String ozone) {
        this.nitricOxide = Double.parseDouble(nitricOxide);
        this.sulphurDioxide = Double.parseDouble(sulphurDioxide);
        this.ozone = Double.parseDouble(ozone);
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