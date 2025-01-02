package app;
import frame.FrameUI;

public class Main {
	
	FrameUI ui;
	
	public void run() {
		
		try 
		{	
			 ui = new FrameUI();
			 ui.setVisible(true);
			 System.out.print("Running...");
		} 
		catch (Exception e) 
		{
		  System.out.println(e);
		}
		
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}

}
