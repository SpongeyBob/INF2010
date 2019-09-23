package tp1;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class BaseShape {
    // Vous aller apprendre plus en details le fonctionnement d'un Set lors
    // du cours sur les fonctions de hashage, vous pouvez considerez ceci comme une liste normale.
    private Set<Point2d> coords;

    // DONE Initialiser les points.
    public BaseShape() {
        coords =  new HashSet<>();
    }

    // DONE -  prendre une liste de points et creer une nouvelle forme.
    public BaseShape(@NotNull Collection<Point2d> coords) {
        this.coords=new HashSet<>();
        Iterator<Point2d> myIterator = coords.iterator();
        while(myIterator.hasNext()){
            this.coords.add(myIterator.next());
        }
    }

    // DONE ajouter ou retirer des coordonnees a la liste de points.
    public void add(Point2d coord) {
        coords.add(coord);
    }

    public void add(BaseShape shape) {
        Iterator<Point2d> shapeIterator = shape.coords.iterator();
        while(shapeIterator.hasNext()){
            this.add(shapeIterator.next());
        }
        //for (Point2d newPoint : shape.getCoords()) this.add(newPoint);
    }
    public void addAll(Collection<Point2d> coords) {
        for(Point2d newPoint : coords) this.add(newPoint);
    }
    public void remove(Point2d coord) {
        coords.remove(coord);
    }
    public void remove(BaseShape shape) {
        for(Point2d oldPoint : shape.getCoords()) coords.remove(oldPoint);
    }
    public void removeAll(Collection<Point2d> coords) {
        for (Point2d oldPoint : coords) this.coords.remove(oldPoint);
    }

    // retourne les coordonnees de la liste.
    public Set<Point2d> getCoords() {
        Set<Point2d> retCoord = new HashSet<>();
        Iterator<Point2d> iterator = coords.iterator();
        while(iterator.hasNext()){
            retCoord.add(iterator.next());
        }
        return retCoord;
    }

    // Done appliquer la translation sur la forme.
    public BaseShape translate(Point2d point) {
        Set<Point2d> retval = new HashSet<>();
        for(Point2d shapePoint : coords ) retval.add(shapePoint.translate(point));
        return new BaseShape(retval);
    }

    // TODO appliquer la translation sur la liste.
    public Set<Point2d> translateAll(Point2d point) {
        Set<Point2d> retval =  new HashSet<>();
        for(Point2d oldPoint: coords){
            retval.add(oldPoint.translate(point));
        }
        return retval;
    }

    // TODO appliquer la rotation sur la forme.
    public BaseShape rotate(Double angle) {
        BaseShape retval = new BaseShape();
        for (Point2d point: coords){
            retval.add(point.rotate(angle));
        }
        return retval;
    }

    // TODO appliquer la rotation sur la liste.
    public Set<Point2d> rotateAll(Double angle) {
        Set<Point2d> retval = new HashSet<>();
        for(Point2d point: coords){
            retval.add(point);
        }
        return retval;
    }

    // TODO retourner une nouvelle forme.
    public BaseShape clone() {
        BaseShape clone = new BaseShape(coords);
        return clone;
    }
}
