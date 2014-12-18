
import java.awt.*;
import java.io.BufferedReader;



public class CalculateStringWidth extends Frame{

	int x =0 ;
	String str = "";
	 
	public CalculateStringWidth (String sample){
		setBackground(Color.pink);
		setTitle("Metadata of Monospaced Font");
		setSize(500, 500);
		setVisible(true);
		str = sample;
	}
	
	public int get(){
		
		return x;
	}

	 public void paint(Graphics g)   
	   {
	      //  Font f1 = new Font("Monospaced", Font.BOLD, 16);
		 Font f1 = new Font("Tahoma", Font.BOLD, 10);
  //     String str = "\u30C9\u30AD\u30E5\u30E1\u30F3\u30C8\u3092\u958B\u304F";      
	     char bigx = 'X';
	     char smallx = 'x';
	 
		g.setFont(f1);
		java.awt.FontMetrics fm = getFontMetrics(f1);   
		x = fm.stringWidth(str);
	//	System.out.println(str);
		System.out.println("string width in pixels: " + fm.stringWidth(str));
		setVisible(false);
		
	   }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String sm = args[0];
	 //   sm = StringEscapeUtils.unescapeJava(sm);
		CalculateStringWidth m = new CalculateStringWidth (sm);
		
		try {
		    Thread.sleep(100);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}			
		System.out.println("Given String:"+ sm);
		System.exit(m.get());
	}

}
