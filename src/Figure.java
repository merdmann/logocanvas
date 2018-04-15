// Copyright (c) 2018 Michael Erdmann
//
// Permission is hereby granted, to any person obtaining a copy of this software and associated 
// documentation files (the "Software"), to deal in the Software without restriction, including 
// without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
// copies of the Software, and to permit persons to whom the Software is furnished to do so, 
// subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in all copies or 
// substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT 
// NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
// NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, 
// DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, 
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
//
import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Figure {
	int x0, y0;
	ArrayList<Point> points = new ArrayList<Point>();
	
	public Figure( Point[] pts ) {
		if( pts == null ) {
			points = new ArrayList<Point>(0);
		} else { 
			int size = pts.length;
			ArrayList<Point> list = new ArrayList<Point>(size);

			for(int i=0; i < size; ++i)  {
				list.add(pts[i]);
			}
		points = list;
		}
	}	
	
	public void put(Point p) {
		points.add(p); 
	}
	
    public Point nearest( Point p0 ) {
		Point p = null;
		
		TreeMap<Float,Point> dist= new TreeMap<Float,Point>();
		
		for(int i=0; i< points.size(); ++i) {
			p = points.get(i);
			dist.put( (float)distance( p0, p ), p );
		}
		
		Map.Entry<Float, Point> result = dist.firstEntry();
		return result.getValue();
	}
	
	public float distance(Point p1 , Point p2) {
		return (float) Math.sqrt( Math.pow(p1.x-p2.y,2) + Math.pow(p1.y-p2.y, 2.0) );
	}
}
	
	


