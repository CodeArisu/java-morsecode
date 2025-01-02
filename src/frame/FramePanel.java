package frame;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import components.ChildPanel;

public class FramePanel extends JPanel{

	
	/**
	 * @Roland
	 */
	private static final long serialVersionUID = 1L;
	
	private final int frameWidth = 600;
	private final int frameHeight = 800;
	private final int borderWidth = 100;

	private ChildPanel panel;

	public FramePanel() {
		components();
	}
	
	private boolean isMaxSize(int maxInput) {
		
		if(maxInput > frameWidth) return true;
		
		if(maxInput > frameHeight) return true;

		return false;
		
	}
	
	private int frametoConvertedPx(int maxSize) {
		
		if(isMaxSize(maxSize)) {
			return -1;
		}
		
		return 0;
	}
	
	private void components() {
		
		this.setPreferredSize(new Dimension(frameWidth, frameHeight));
		this.setLayout(null);
		this.setBackground(Color.gray);
		this.setDoubleBuffered(true);
		 
		// child panels
		
		panel = new ChildPanel(frameWidth - borderWidth, frameHeight - borderWidth);
		this.add(panel);
		panel.setCenterPosition(frameWidth, frameHeight, 50);
		
	}
	
}
