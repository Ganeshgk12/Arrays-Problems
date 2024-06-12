package Programs.striverz.Arrays;

public class TrafficCodeNinja {
    public static void main(String[] args) {
        int [] vehicle = {1,0,0,1,0,1,0,1,1,1,0,0};
        int m = 5;
        System.out.println(tarffic(vehicle,m));
    }
    public static int tarffic(int [] vehicle, int m){

        int count = 0;
        int continution = 0;

        int j = 0;

        for (int i = 0; i < vehicle.length; i++) {
            if (vehicle[i] == 0){
                count++;
            }
            if (count > m){
                if (vehicle[j] == 0){
                    count--;
                }
                j++;
            }
            continution = Math.max(continution,i - j + 1);
        }
        return continution;
    }
}
