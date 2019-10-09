package tp1;

import java.util.HashSet;
import java.util.Set;

public class Ellipse extends BaseShape {
    int HALF_POINT_COUNT = 100;
    // TODO creer une ellipse avec une largeur et une longueur.
    public Ellipse(Double widthRadius, Double heightRadius) {
        Set<Point2d> coordone = new HashSet<>();
        Double[] pointCoord = new Double[2];
        for(double i = 0; i < 2*Math.PI; i+= Math.PI/HALF_POINT_COUNT){
            pointCoord[0] = widthRadius * Math.cos(i);
            pointCoord[1] = widthRadius * Math.sin(i);
            coordone.add(new Point2d(pointCoord));
        }
    }

    private Ellipse(Set<Point2d> coords) {
        super(coords);
    }

    // TODO appliquer la translation sur la forme.
    @Override
    public Ellipse translate(Point2d point) {

        return new Ellipse(translateAll(point));
    }

    // TODO appliquer la rotation sur la forme.
    @Override
    public Ellipse rotate(Double angle) {
        return new Ellipse(rotateAll(angle));
    }

    // TODO retourner une nouvelle forme.
    @Override
    public Ellipse clone() { return new Ellipse(getCoords()); }
}
