package tp1;

import java.util.*;

public final class PointOperator {
    //  appliquer la translation sur le vecteur d'entree.
    public static Double[] translate(Double[] vector, Double[] translateVector) {
        if (translateVector.length != vector.length) {
            System.out.printf("incompatible vectors \n");
        }
        for (int i =0; i < vector.length ; i++){
            vector[i] += translateVector[i];
        }
        return vector;
    }   

    //  appliquer la rotation sur le vecteur d'entree.
    public static Double[] rotate(Double[] vector, Double[][] rotationMatrix) {
        if(vector.length != rotationMatrix[0].length) {
            System.out.printf("incompatible dimensions");
            return null;
        }
        Double[] retval = vector;
        for (int row =0 ; row< rotationMatrix[0].length; row ++ ){
            double sum = 0.0;
            for (int column = 0 ; column< vector.length; column ++){
                sum += vector[column]*rotationMatrix[row][column] ;
            }
            retval[row] = sum;
        }
        return retval;
    }

    //  appliquer le facteur de division sur le vecteur d'entree.
    public static Double[] divide(Double[] vector, Double divider) {
        for (int i =0 ; i<vector.length; i ++){
            vector[i] = vector[i] / divider;
        }
        return vector;
    }

    //  appliquer le facteur de multiplication sur le vecteur d'entree.
    public static Double[] multiply(Double[] vector, Double multiplier) {
        for (int i =0 ; i<vector.length; i ++){
            vector[i] = vector[i] * multiplier;
        }
        return vector;
    }

    //  appliquer le facteur d'addition sur le vecteur d'entree.
    public static Double[] add(Double[] vector, Double adder) {
        for (int i =0 ; i<vector.length; i ++){
            vector[i] += adder;
        }
        return vector;
    }

    //  retourne la coordonnee avec les plus grandes valeurs en X et en Y.
    public static Point2d getMaxCoord(Collection<Point2d> coords) {
        Double[] retval = {-9999.99,-9999.99};
        for(Point2d point : coords){
            Double
                X = point.X(),
                y= point.Y();

            if(X>retval[0]) 
                retval[0] = X;
            if (y>retval[1])
                retval[1]=y;
        }
        return new Point2d(retval);
    }

    //  retourne la coordonnee avec les plus petites valeurs en X et en Y.
    public static Point2d getMinCoord(Collection<Point2d> coords) {
        Double[] retval = {9999.99,9999.99};
        for(Point2d point : coords){
            Double
                X = point.X(), 
                Y = point.Y();
            if( X<retval[0]) 
                retval[0] = X;
            if( Y<retval[1])
                retval[1]=Y;
        }
        return new Point2d(retval);
    }
}
