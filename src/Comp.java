import java.util.Comparator;

public class Comp implements Comparator<Point> {

    Point p0;

    public Comp(Point p0){
        this.p0 = p0;
    }

    @Override
    public int compare(Point p1, Point p2) {
        int o = orientation(p1, p2);
        if (o==0){
            if(p0.distsq(p2) >= p0.distsq(p1))return -1;
            return 1;
        }
        if(o==2)return -1;
        return 1;
    }

    public int orientation( Point p1, Point p2){
        long val = ((p1.y-p0.y) * (p2.y-p1.y) - (p1.x-p0.x) * (p2.x-p1.x));
        if(val==0)return 0;
        if(val > 0)return 1;
        return 2;
    }

}
