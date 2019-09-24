package tp1;

import java.util.Set;

public class Rectangle extends BaseShape {
    // TODO creer un rectangle avec une largeur et une longueur.

        public Rectangle(double width, double height) {
            for (double i = -width / 2; i <= width / 2; i++) {
                for (double j = -height / 2; j <= height / 2; j++) {
                    add(new Point(i, j));
                }

            }
        }

    // TODO creer un rectangle avec un point contenant la largeur et longueur.
    public Rectangle(Point2d dimensions) { //AREVOIR
        Rectangle(dimension.X(),dimensions.Y());

        // ...
    }

    private Rectangle(Set<Point2d> coords) {
        super(coords);
    }

    // TODO appliquer la translation sur la forme.
    @Override
    public Rectangle translate(Point2d point) {

        this.translate(point);
        return this;
    }

    // TODO appliquer la rotation sur la forme.
    @Override
    public Rectangle rotate(Double angle) {
        this.rotate(angle);
        return this;
    }

    // TODO retourner une nouvelle forme.
    @Override
    public Rectangle clone() {
        this.clone();
        return this;
    }
}
