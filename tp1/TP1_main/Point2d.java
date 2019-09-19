package tp1;

public class Point2d extends AbstractPoint {
    private final Integer X = 0;
    private final Integer Y = 1;

    //  creer un point en 2d avec 2 donnees

    public Point2d(Double x, Double y) {
        super(new Double[]{x, y});
    }

    //  creer un point a partir d'un vecteur de donnees

    public Point2d(Double[] vector) {
        super(new Double[]{vector[0],vector[1]});
    }

    public Double X() { return vector[X];}
    public Double Y() { return vector[Y];}

    //  prendre un vecteur de donnees et appliquer la translation.
    @Override
    public Point2d translate(Double[] translateVector) {
        Point2d retval = new Point2d(PointOperator.translate(vector, translateVector));
        return retval;
    }

    //  prendre un point et appliquer la translation.
    public Point2d translate(Point2d translateVector) {
         Point2d retval = new Point2d(PointOperator.translate(this.vector, translateVector.vector));
        return retval;
    }

    //https://academo.org/demos/rotation-about-point/
    //  prendre un vecteur de donnees et appliquer la translation.
    @Override
    public Point2d rotate(Double[][] rotationMatrix) {
        Point2d retval = new Point2d(PointOperator.rotate(vector, rotationMatrix));
        return retval;
    }

    //  prendre un angle de rotation, creer une matrice et appliquer la rotation.
    public Point2d rotate(Double angle) {
        /*
        [cos θ   -sin θ] 
        [sin θ    cos θ]
        */
        Double[][] rotationMatrix = new Double[2][2];
        rotationMatrix[0][0] = Math.cos(angle);
        rotationMatrix[0][1] = Math.sin(angle) * (-1);

        rotationMatrix[1][0] = Math.sin(angle);
        rotationMatrix[1][1] = Math.cos(angle);
        return this.rotate(rotationMatrix);
    }

    //  prendre un facteur de division et l'appliquer.
    @Override
    public Point2d divide(Double divider) {
        PointOperator.divide(vector, divider);
        return this;
    }

    //  prendre un facteur de multiplication et l'appliquer.
    @Override
    public Point2d multiply(Double multiplier) {
        PointOperator.multiply(vector, multiplier);
        return this;
    }

    //  prendre un facteur d'addition et l'appliquer.
    @Override
    public Point2d add(Double adder) {
        PointOperator.add(vector, adder);
        return this;
    }

    //  creer un nouveau point.
    @Override
    public Point2d clone() {
        Point2d clone = new Point2d(this.X(), this.Y());
        return clone;
    }
}
