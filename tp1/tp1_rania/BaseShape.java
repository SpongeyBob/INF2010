package tp1;

import java.util.*;
import java.util.stream.Collectors;

public class BaseShape {
    // Vous aller apprendre plus en details le fonctionnement d'un Set lors
    // du cours sur les fonctions de hashage, vous pouvez considerez ceci comme une liste normale.
    private Set<Point2d> coords;

    // TODO Initialiser les points.
    public BaseShape() {
        coords= new HashSet<Point2d>();
        // ...
    }

    // TODO prendre une liste de points et creer une nouvelle forme.
    public BaseShape(Collection<Point2d> coords) {
        this.coords= new HashSet<Point2d>(coords); //AREVOIR//
        
        // ...
    }

    // TODO ajouter ou retirer des coordonnees a la liste de points.
    public void add(Point2d coord) {
        coords.add(coord);
        // ...
    }
    public void add(BaseShape shape) {
        this.coords.addAll(shape.coords);
        // ...
    }
    public void addAll(Collection<Point2d> coords) {
        this.coords.addAll(coords); //existe la fonction addall pr set
        // ...
    }
    public void remove(Point2d coord) {
        for (int i=0; i<this.coords.size(); i++)
        {
            if(this.coords[i]==coord)
                this.coords[i].remove();
        }
        // ...
    }
    public void remove(BaseShape shape) {
        if(this.coords.containsAll(shape.coords))
            removeAll(this.coords);
        // ...
    }
    public void removeAll(Collection<Point2d> coords) {
        if (this.coords.containsAll(coords))
            removeAll(this.coords);

        
        // ...
    }

    // TODO retourne les coordonnees de la liste.
    public Set<Point2d> getCoords() {
        return this.coords;
        //return null;
    }

    // TODO appliquer la translation sur la forme.
    public BaseShape translate(Point2d point) {
      
        translateAll(point); //quel est la difference avec translatteal
        return this; // retourne le baseshape et non la liste
    }

    // TODO appliquer la translation sur la liste.
    public Set<Point2d> translateAll(Point2d point) {
        for(int i=0;i<this.coords.size(); i++)
        {
            this.coords[i].translate(point);
        }
        return this.coords;
    }

    // TODO appliquer la rotation sur la forme.
    public BaseShape rotate(Double angle) {
        rotateAll(angle);
        return this;
    }

    // TODO appliquer la rotation sur la liste.
    public Set<Point2d> rotateAll(Double angle) {
        for(int i=0;i<this.coords.size(); i++)
        {
            this.coords[i].rotate(angle);
        }
        return this.coords;
    }

    // TODO retourner une nouvelle forme.
    public BaseShape clone() {
        for(int i=0;i<this.coords.size(); i++)
        {
            this.coords[i].clone();
            
        }
        return this;
    }
}
