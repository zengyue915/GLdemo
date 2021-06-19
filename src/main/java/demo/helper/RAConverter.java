package demo.helper;

public class RAConverter {
    public static Double RAto180(Double ra360){
        double result = ra360>180? (360-ra360)*-1:ra360;
        return result;
    }

    public static Double RAto180(String ra360_string){
        Double ra360 = Double.valueOf(ra360_string);
        return RAto180(ra360);
    }

}
