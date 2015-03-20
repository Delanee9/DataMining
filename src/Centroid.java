class Centroid {
    private double nitricOxide;
    private double sulphurDioxide;
    private double ozone;
    private boolean isFinished = false;

    public Centroid(double nitricOxide, double sulphurDioxide, double ozone) {
        this.nitricOxide = nitricOxide; //X Coord
        this.sulphurDioxide = sulphurDioxide;   //Y Coord
        this.ozone = ozone; //Z Coord
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

    public boolean isFinished() {
        return true;
    }
}