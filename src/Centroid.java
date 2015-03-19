class Centroid {
    private double nitricOxide;
    private double sulphurDioxide;
    private double ozone;

    public Centroid(double nitricOxide, double sulphurDioxide, double ozone) {
        this.nitricOxide = nitricOxide; //X Coord
        this.sulphurDioxide = sulphurDioxide;   //Y Coord
        this.ozone = ozone; //Z Coord
    }

    public double getNitricOxide() {
        return nitricOxide;
    }

    public void setNitricOxide(double nitricOxide) {
        this.nitricOxide = nitricOxide;
    }

    public double getSulphurDioxide() {
        return sulphurDioxide;
    }

    public void setSulphurDioxide(double sulphurDioxide) {
        this.sulphurDioxide = sulphurDioxide;
    }

    public double getOzone() {
        return ozone;
    }

    public void setOzone(double ozone) {
        this.ozone = ozone;
    }
}
