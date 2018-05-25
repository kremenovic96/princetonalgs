package coolinear;

import java.util.Arrays;

public class BruteCollinearPoints {

    private LineSegment[] segmets;
    private int numOfLineSegments;
    Point[] pointsCopy;
    public BruteCollinearPoints(Point[] points){
        pointsCopy = points.clone();
        Arrays.sort(pointsCopy);
        for(int i = 0; i < pointsCopy.length; i++){
            for(int j = 0; j < pointsCopy.length-1; j++){
                for(int k = 0; k<pointsCopy.length-2; k++){
                    for(int l = 0; l< pointsCopy.length-3; l++){
                        Point a = pointsCopy[i];
                        Point b = pointsCopy[j];
                        Point c = pointsCopy[k];
                        Point d = pointsCopy[l];
                        if (a.slopeTo(b) == a.slopeTo(c) && a.slopeTo(b) == a.slopeTo(d)){
                            LineSegment line = new LineSegment(a, d);
                            segmets[numOfLineSegments ++] = line;
                        }
                    }
                }
            }
        }
    }

    public int numberOfSegments(){
        return numOfLineSegments;
    }

    public LineSegment[] segments(){
        return segmets;
    }

}
