package tp1;

public final class LetterFactory {
    final static Double maxHeight = 200.0;
    final static Double maxWidth = maxHeight / 2;
    final static Double halfMaxHeight = maxHeight / 2;
    final static Double halfMaxWidth = maxWidth / 2;
    final static Double stripeThickness = maxHeight / 10;

    // TODO
    public static BaseShape create_H() {
        BaseShape leftStripe = new Rectangle(stripeThickness,maxHeight);
        BaseShape centerDash = new Rectangle(maxWidth,stripeThickness);
        Double[] centerPoint ={0D, halfMaxHeight};
        centerDash= centerDash.translate(new Point2d(centerPoint)) ;
        Double[] rightPoint ={maxWidth,0D};
        BaseShape rightStripe = leftStripe.translate(new Point2d(rightPoint));
        leftStripe.add(centerDash);
        leftStripe.add(rightStripe);
        return leftStripe;
    }

    // TODO
    public static BaseShape create_e() {
        BaseShape circle = new Circle(50D);
        return circle;
    }

    // TODO
    public static BaseShape create_l() {
        return new Rectangle(stripeThickness,maxHeight);
    }

    // TODO
    public static BaseShape create_o() {
        return new Circle(halfMaxWidth);
    }

    // On vous donne la lettre W comme exemple.
    public static BaseShape create_W() {
        Double degrees15 = Math.toRadians(8);
        Double spacing = stripeThickness * 2;
        BaseShape mainStripe = new Rectangle(stripeThickness, maxHeight);
        BaseShape leftStripe = mainStripe.rotate(-degrees15).translate(new Point2d(-spacing, 0.0));
        BaseShape middleLeftStripe = mainStripe.rotate(degrees15).translate(new Point2d(-spacing / 3, 0.0));
        BaseShape middleRightStripe = mainStripe.rotate(-degrees15).translate(new Point2d(spacing / 3, 0.0));
        BaseShape rightStripe = mainStripe.rotate(degrees15).translate(new Point2d(spacing, 0.0));
        leftStripe.add(middleLeftStripe);
        leftStripe.add(middleRightStripe);
        leftStripe.add(rightStripe);
        return leftStripe;
    }

    // TODO
    public static BaseShape create_r() {
        return new Rectangle(1D,1D);
    }

    // TODO
    public static BaseShape create_d() {
        return new Rectangle(1D,1D);
    }
}
