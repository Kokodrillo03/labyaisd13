
public class Point implements Comparable<Point>{
	public long x;
	public long y;
	//TODO ?

	public Point(long x, long y){
		this.x = x;
		this.y = y;
	}

	public long getX() {
		return x;
	}

	public void setX(long x) {
		this.x = x;
	}

	public long getY() {
		return y;
	}

	public void setY(long y) {
		this.y = y;
	}

	@Override
	public String toString() {
		String ret = "(";
		ret += x;
		ret += ", ";
		ret += y;
		ret += ")";
		return ret;
	}

	@Override
	public int compareTo(Point that) {
		if (this.y < that.y)
			return -1;
		if (this.y > that.y)
			return +1;
		if (this.x < that.x)
			return -1;
		if (this.x > that.x)
			return +1;
		return 0;
	}

	public long distsq(Point p){
		return(this.x-p.x)^2+(this.y-p.y)^2;
	}



}
