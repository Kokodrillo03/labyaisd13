
import java.util.LinkedList;
import java.util.Scanner;

public class PointsReader {
	static LinkedList<Point> load(Scanner scan,int nrOfPoints){
		LinkedList<Point> ret = new LinkedList<>();

		for(int i = 0; i < nrOfPoints; i ++){
			String line = scan.nextLine();
			String[] cords = line.split(" ");
			long x = Long.parseLong(cords[0]);
			long y = Long.parseLong(cords[1]);
			ret.add(new Point(x,y));
		}

		return ret;
	}
}
