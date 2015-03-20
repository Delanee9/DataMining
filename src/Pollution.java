/**
 * Class to hold the information relating to pollution levels
 */
class Pollution {
    private final double nitricOxide;
    private final double sulphurDioxide;
    private final double ozone;

    public Pollution(String nitricOxide, String sulphurDioxide, String ozone) {
        this.nitricOxide = Double.parseDouble(nitricOxide);
        this.sulphurDioxide = Double.parseDouble(sulphurDioxide);
        this.ozone = Double.parseDouble(ozone);
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