/**
 * Class that holds data relating to bike hire information.
 */
class BikeData {
    private final int hireTime;
    private final int bikeHires;

    public BikeData(String hireTime, String bikeHires) {
        this.hireTime = Integer.parseInt(hireTime);
        this.bikeHires = Integer.parseInt(bikeHires);
    }

    public int getHireTime() {
        return hireTime;
    }

    public int getBikeHires() {
        return bikeHires;
    }
}