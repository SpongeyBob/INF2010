package tp1;

public class Point2d extends AbstractPoint {
    private final Integer X = 0;
    private final Integer Y = 1;

    // TODO creer un point en 2d avec 2 donnees

    public Point2d(Double x, Double y) {
        super(x,y);
    }

    // TODO creer un point a partir d'un vecteur de donnees

    public Point2d(Double[] vector) {
        super(vector[0], vector[1]);
    }

    public Double X() { return vector[X];}
    public Double Y() { return vector[Y];}

    // TODO prendre un vecteur de donnees et appliquer la translation.
    @Override
    public Point2d translate(Double[] translateVector) {
        PointOperator.translate(vector, translateVector);
        return null;
    }

    // TODO prendre un point et appliquer la translation.
    public Point2d translate(Point2d translateVector) {
        PointOperator.translate(this.vector, translateVector.vector);
        return null;
    }

    //https://academo.org/demos/rotation-about-point/
    // TODO prendre un vecteur de donnees et appliquer la translation.
    @Override
    public Point2d rotate(Double[][] rotationMatrix) {
        PointOperator.rotate(vector, rotationMatrix);
        return null;
    }

    // TODO prendre un angle de rotation, creer une matrice et appliquer la rotation.
    public Point2d rotate(Double angle) {
        /*
        [cos θ   -sin θ] 
        [sin θ    cos θ]
        */
        Double[][] rotationMatrix = new double[2][2];
        rotationMatrix[0][0] = java.lang.Math.cos(angle);
        rotationMatrix[0][1] = -java.lang.Math.sin(angle);

        rotationMatrix[1][0] = java.lang.Math.sin(angle);
        rotationMatrix[1][1] = java.lang.Math.cos(angle);
        this.rotate(rotationMatrix);
        return null;
    }

    // TODO prendre un facteur de division et l'appliquer.
    @Override
    public Point2d divide(Double divider) {
        PointOperator.divide(vector, divider);
        return null;
    }

    // TODO prendre un facteur de multiplication et l'appliquer.
    @Override
    public Point2d multiply(Double multiplier) {
        PointOperator.multiply(vector, multiplier);
        return null;
    }

    // TODO prendre un facteur d'addition et l'appliquer.
    @Override
    public Point2d add(Double adder) {
        PointOperator.add(vector, adder);
        return this;
    }

    // TODO creer un nouveau point.
    @Override
    public Point2d clone() {
        Point2d clone = new Point2d(this.X(), this.Y());
        return clone;
    }
}
