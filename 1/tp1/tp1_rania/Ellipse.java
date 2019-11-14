package tp1;

import java.util.Set;

public class Ellipse extends tp1.BaseShape {
    // TODO creer une ellipse avec une largeur et une longueur.
    public Ellipse(Double widthRadius, Double heightRadius) {
        widthRadius=0;
        heightRadius=0;

        // ...
    }

    private Ellipse(Set<Point2d> coords) {
        super(coords);
    }

    // TODO appliquer la translation sur la forme.
    @Override
    public Ellipse translate(Point2d point) {
        this.translate(point);
        return this;
        //return new Ellipse(translateAll(point));
    }

    // TODO appliquer la rotation sur la forme.
    @Override
    public Ellipse rotate(Double angle) {
        this.rotate(angle);
        //return new Ellipse(rotateAll(angle));
    }

    // TODO retourner une nouvelle forme.
    @Override
    public Ellipse clone() {
        this.clone()
    return this;
    //return new Ellipse(getCoords()); }
}
