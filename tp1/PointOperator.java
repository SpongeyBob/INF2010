package tp1;

import java.util.*;

public final class PointOperator {
    // TODO appliquer la translation sur le vecteur d'entree.
    public static Double[] translate(Double[] vector, Double[] translateVector) {
        if (translateVector.length != vector.length) {
            throw new Exception("incompatible vectors \n");
        }
        for (int i =0; i < vector.length ; i++){
            vector[i] += translateVector[j];
        }
        return null;
    }   

    // TODO appliquer la rotation sur le vecteur d'entree.
    public static Double[] rotate(Double[] vector, Double[][] rotationMatrix) {
        if(vector.length != rotationMatrix[0].length) {
            throw Exception("incompatible dimensions");
        }
        for(int i =0 ; i<vector.length; i ++){
            //save data to be reused (og stand for original)
            double og = vector[i];
            //initial vector to affect directly the answer on it
            vector[i] = 0;
            for (int j =0; j<rotationMatrix[i].length; j++){
                vector[i] += og * rotationMatrix[i][j];
            } 

        }
        return null;
    }

    // TODO appliquer le facteur de division sur le vecteur d'entree.
    public static Double[] divide(Double[] vector, Double divider) {
        for(Double x : vector){
            x= x/divider;
        }
        return null;
    }

    // TODO appliquer le facteur de multiplication sur le vecteur d'entree.
    public static Double[] multiply(Double[] vector, Double multiplier) {
        for(double x : vector){
            x = x*multiplier;
        }
        return null;
    }

    // TODO appliquer le facteur d'addition sur le vecteur d'entree.
    public static Double[] add(Double[] vector, Double adder) {
        for (double x : vector){
            x += adder;
        }
        return null;
    }

    // TODO retourne la coordonnee avec les plus grandes valeurs en X et en Y.
    public static Point2d getMaxCoord(Collection<Point2d> coords) {
        double[] retval = {-0xffff,-0xffff};
        for(Point2d point : coords){
            double 
                X = point.X(),
                y= point.Y();

            if(X>retval[0]) 
                retval[0] = X;
            if (Y>retval[1])
                retval[1]=Y;
        }
        return Point2d(retval);
    }

    // TODO retourne la coordonnee avec les plus petites valeurs en X et en Y.
    public static Point2d getMinCoord(Collection<Point2d> coords) {
        double[] retval = {0xffff,0xffff};
        for(Point2d point : coords){
            double 
                X = point.X(), 
                Y = point.Y();
            if( X<retval[0]) 
                retval[0] = X;
            if( Y<retval[1])
                retval[1]=Y;
        }
        return Point2d(retval);
    }
}
