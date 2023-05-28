package metroparisien;

class StationDistance implements Comparable<StationDistance> {
    Station station;
    int distance;

    public StationDistance(Station station, int distance) {
        this.station = station;
        this.distance = distance;
    }

    @Override
    public int compareTo(StationDistance other) {
        return Integer.compare(this.distance, other.distance);
    }
    
    
    
}