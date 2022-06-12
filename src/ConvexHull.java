

import java.util.LinkedList;
import java.util.Stack;

public class ConvexHull {
	static Point p0;

	public static LinkedList<Point> solve(LinkedList<Point> points) {
		p0  = new Point(Long.MAX_VALUE,Long.MAX_VALUE);

		if(points.size()<3)return new LinkedList<>();
		Stack<Point> s = new Stack<>();

		for(Point p : points){
			if(p.compareTo(p0) < 0)p0 = p;
		}

		points.remove(p0);
		points.sort(new Comp(p0));
		points.addFirst(p0);

		s.push(points.get(0));
		s.push(points.get(1));
		s.push(points.get(2));

		for(int i = 3; i < points.size(); i++){
			while(orientation(nextToTop(s),s.peek(), points.get(i))==1){
				s.pop();
			}
			s.push(points.get(i));
		}

		LinkedList<Point> ret = new LinkedList<>();
		while(!s.isEmpty()){
			ret.addFirst(s.pop());
		}

		return ret;
	}

	public static Point nextToTop(Stack<Point> s){
		Point temp = s.pop();
		if(s.isEmpty()) {
			s.push(temp);
			return temp;
		}
			Point ret = s.peek();
		s.push(temp);
		return ret;
	}

	public static int orientation(Point p0, Point p1, Point p2){
		long val = ((p1.y-p0.y) * (p2.y-p1.y) - (p1.x-p0.x) * (p2.x-p1.x));
		if(val==0)return 0;
		if(val > 0)return 1;
		return 2;
	}



}
