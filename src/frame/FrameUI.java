package frame;

import javax.swing.JFrame;
import frame.FramePanel;

public class FrameUI extends JFrame{
	
	/**
	 * @Roland
	 */
	private static final long serialVersionUID = 4550885008574146232L;
	
	FramePanel panel;
	
	public FrameUI() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("JavaMorse");

		panel = new FramePanel();
		
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
	}


}
