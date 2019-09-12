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
        if (translateVector.length != vector.length) {
            throw new Exception("incompatible vectors \n");
        }
        vector[X] += translateVector[X];
        vector[Y] += translateVector[Y];
        return this;
    }

    // TODO prendre un point et appliquer la translation.
    public Point2d translate(Point2d translateVector) {
        if (translateVector.vector.length != this.vector.length) {
            throw new Exception("incompatible vectors \n");
        }
        this.vector[X] += translateVector.vector[X];
        this.vector[Y] += translateVector.vector[Y];
        return this;
    }

    //https://academo.org/demos/rotation-about-point/
    // TODO prendre un vecteur de donnees et appliquer la translation.
    @Override
    public Point2d rotate(Double[][] rotationMatrix) {
        if(rotationMatrix.length !=2 || rotationMatrix[0].length != 2){
            throw new Exception("Wrong dimension for rotation Matrix");
        }
        //n'est pas primordial mais facilite la lecture.
        double x =this.vector[X],
               y= this.vector[Y];
        this.vector[X]= x * rotationMatrix[X][0] + x * rotationMatrix[X][1];
        this.vector[Y]= y * rotationMatrix[Y][0] + y * rotationMatrix[Y][1];
        return this;
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
        return this.rotate(rotationMatrix);
    }

    // TODO prendre un facteur de division et l'appliquer.
    @Override
    public Point2d divide(Double divider) {
        vector[X] = vector[X] / divider;
        vector[Y] = vector[Y] / divider;
        return this;
    }

    // TODO prendre un facteur de multiplication et l'appliquer.
    @Override
    public Point2d multiply(Double multiplier) {
        vector[X] = vector[X] * multiplier;
        vector[Y] = vector[Y] * multiplier;
        return this;
    }

    // TODO prendre un facteur d'addition et l'appliquer.
    @Override
    public Point2d add(Double adder) {
        vector[X] += adder;
        vector[Y] += adder;
        return this;
    }

    // TODO creer un nouveau point.
    @Override
    public Point2d clone() {
        Point2d clone = new Point2d(this.X(), this.Y());
        return clone;
    }
}
