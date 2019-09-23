package tp1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Rectangle extends BaseShape {
    // TODO creer un rectangle avec une largeur et une longueur.
    public Rectangle(Double width, Double height) {

        for(int i =0; i<width; i++){
            for (int j = 0; j<height; j++){
                Point2d newPoint = new Point2d(height,width);
                this.add(newPoint);
            }
        }
    }

    // TODO creer un rectangle avec un point contenant la largeur et longueur.
    public Rectangle(Point2d dimensions) {
        this(dimensions.X(),dimensions.Y());
    }

    private Rectangle(Set<Point2d> coords) {
        super(coords);
    }

    // TODO appliquer la translation sur la forme.
    @Override
    public Rectangle translate(Point2d point) {
        Set<Point2d> translatedCoords = new HashSet<>();
        Iterator<Point2d> myIterator = this.getCoords().iterator();
        while(myIterator.hasNext()){
            translatedCoords.add(myIterator.next().translate(point));
        }
        return new Rectangle(translatedCoords);
    }

    // TODO appliquer la rotation sur la forme.
    @Override
    public Rectangle rotate(Double angle) {
        Set<Point2d> rotatedCoords = new HashSet<>();
        Iterator<Point2d> myIterator = this.getCoords().iterator();
        while(myIterator.hasNext()){
            rotatedCoords.add(myIterator.next().rotate(angle));
        }
        return new Rectangle(rotatedCoords);
    }

    // TODO retourner une nouvelle forme.
    @Override
    public Rectangle clone() {

        Set<Point2d> myCoords = new HashSet<>();
        Iterator<Point2d> myIterator = this.getCoords().iterator();
        while(myIterator.hasNext()){
            myCoords.add(myIterator.next());
        }
        return new Rectangle(myCoords);
    }
}
