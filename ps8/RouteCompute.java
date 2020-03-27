package ps8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RouteCompute {

    public static void main(String[] args) {
        ArrayList<WayPoint> wayPoints = new ArrayList<>();

        Scanner scanner = null;
        try{
            scanner = new Scanner(new FileInputStream(args[0]));
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        while (scanner.hasNextLine()){
            if(scanner.hasNext()){
                WayPoint wayPoint = new WayPoint();
                wayPoint.setTimestamp(scanner.nextInt());
                wayPoint.setX(scanner.nextDouble());
                wayPoint.setY(scanner.nextDouble());
                wayPoints.add(wayPoint);
            } else {
                break;
            }
        }

//        for(int i = 0; i < wayPoints.size(); i++){
//            System.out.println(wayPoints.get(i));
//        }

        double totalDistance = 0.0;
        int totalTime;
        double mph;
        for(int i = 0; i < wayPoints.size()-1; i++) {
            totalDistance += WayPoint.Distance(wayPoints.get(i), wayPoints.get(i + 1));
            if(wayPoints.get(i).getTimestamp() >= wayPoints.get(i+1).getTimestamp()){
                throw new IllegalStateException("Illegal Time Elapsed");
            }
        }
        totalTime = wayPoints.get(wayPoints.size()-1).getTimestamp() - wayPoints.get(0).getTimestamp();
        mph = totalDistance / (totalTime / 3600.0);
        System.out.printf("Total Distance(mile): %.3f, Average speed(mph): %.3f", totalDistance, mph);
    }
}
