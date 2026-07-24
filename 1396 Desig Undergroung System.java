class UndergroundSystem {
    class CheckIn{
        String station;
        int time;

        CheckIn(String station, int time){
            this.station = station;
            this.time = time;
        }
    }
    Map<Integer,CheckIn> checkInMap;
    Map<String,int[]> travelMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        travelMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
        
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckIn info = checkInMap.get(id);

        String key = info.station + "-" + stationName;

        int[] value = travelMap.getOrDefault(key, new int[2]);

        value[0] += (t - info.time);
        value[1]++;

        travelMap.put(key , value);

        checkInMap.remove(id);
        
    }
    
    public double getAverageTime(String startStation, String endStation) {
        int[] value = travelMap.get(startStation + "-" + endStation);
        return (double) value[0] / value [1];
        
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
