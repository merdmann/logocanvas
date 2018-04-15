// 
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
import javax.swing.JFrame;
import java.util.*;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;

public class Program
{
    public static void main(String[] args)
    {
        JFrame frmMain = new JFrame();
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMain.setSize(600, 600);

        Canvas cnvs = new Canvas();
        cnvs.setSize(400, 400);

        frmMain.add(cnvs);
        frmMain.setVisible(true);

        Graphics g = cnvs.getGraphics();
        g.setColor(new Color(255, 0, 0));
        //g.drawString("Hello",0, 590);
        // g.drawOval(300, 300, 1, 1);
        
        create_seed(g, (double)0.5);
    }
    
    public static Figure create_seed(Graphics g, double variance) {
    	Random rnd = new Random(4711);
    	Figure fig = new Figure( null );
    	
    	for (double x=0; x < 10.0; ++x) {
    		for(double y=0; y < 10.0; ++y ) {

    			double dx =	rnd.nextDouble()*variance;
    			double dy = rnd.nextDouble()*variance;
    			int xx = (int) (x * 50.0);
    			int yy = (int) (y * 50.0);
    			Point p = new Point(xx+dx, yy+dy);
    			System.out.println("p" + p);
    			fig.put(p);
    			p.mark(g);
    		}
    	}
    	return fig;
    }
}
