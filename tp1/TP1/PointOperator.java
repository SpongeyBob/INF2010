package tp1;

import java.util.*;

public final class PointOperator {
    //  appliquer la translation sur le vecteur d'entree.
    public static Double[] translate(Double[] vector, Double[] translateVector) {
        if (vector.length != translateVector.length) {
            System.out.printf("incompatible size vector");
            return null;
        }
        Double[] retval = new Double[vector.length];
        for (int i =0; i<vector.length; i++){
            retval[i] = vector[i] + translateVector[i];
        }
        return retval;
    }

    //  appliquer la rotation sur le vecteur d'entree.
    public static Double[] rotate(Double[] vector, Double[][] rotationMatrix) {
       if(vector.length != rotationMatrix[0].length) {
            System.out.printf("incompatible dimensions");
            return null;
        }
       Double[] retval = new Double[vector.length]; //redundant within code not within scope
       for(int i =0; i<vector.length; i++){ //row
           retval[i]=0D;
           for (int j = 0; j<vector.length;j++){ //column
               retval[i] += vector[j] * rotationMatrix[i][j];
           }
       }
       return retval;
    }

    //  appliquer le facteur de division sur le vecteur d'entree.
    public static Double[] divide(Double[] vector, Double divider) {
        Double[] retval = new Double[vector.length];
        for (int i =0 ; i<vector.length; i ++){
            retval[i] = vector[i] / divider;

        }
        return retval;
    }

    //  appliquer le facteur de multiplication sur le vecteur d'entree.
    public static Double[] multiply(Double[] vector, Double multiplier) {
        Double[] retval = new Double[vector.length];
        for (int i =0 ; i<vector.length; i ++){
            retval[i] = vector[i] * multiplier;
        }
        return retval;
    }

    //  appliquer le facteur d'addition sur le vecteur d'entree.
    public static Double[] add(Double[] vector, Double adder) {
        Double[] retval = new Double[vector.length];
        for (int i =0 ; i<vector.length; i ++){
            retval[i] = vector[i]+ adder;
        }
        return retval;
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
