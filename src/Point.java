import java.awt.Color;
import java.awt.Graphics;

public class Point {
	double x;
	double y;

	public Point(double  xx, double yy) {
		x = xx;
		y = yy;
	}
	
	public void mark(Graphics g) {	
		g.setColor( Color.RED);
		
		System.out.println( this );
		
		g.drawOval( (int)Math.round(x), (int)Math.round(y), 10, 10 );
	}
	
	public String toString() {
		int xx = (int)Math.round(x);
		int yy = (int)Math.round(y);
		
		return "[" + xx + " " + yy + "]";
	}
}
