package components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import frame.FramePanel;

public class ChildPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int xPanelSize;
	private int yPanelSize;
	public int getxPanelSize() {
		return xPanelSize;
	}
	public int getyPanelSize() {
		return yPanelSize;
	}
	public void setxPanelSize(int xPanelSize) {
		this.xPanelSize = xPanelSize;
	}
	public void setyPanelSize(int yPanelSize) {
		this.yPanelSize = yPanelSize;
	}
	
	public ChildPanel(int x, int y) {
		setxPanelSize(x);
		setyPanelSize(y);
		components();
	}
	
	private void components() {
		this.setBackground(Color.white);
	}
	
	public void setCenterPosition(int x, int y, int adjPx) {

		/*
		 * the size of the child panel should be
		 * adjacent with the parent size regardless of
		 * the adjusted pixels and ( -100px left / top )
		 * left over area inside the parent
		 */
		
		// finding the mid point of a rectangle with its defined pixel
		int centerX = ((x + adjPx) - x);
		int centerY = ((y + adjPx) - y);
		
		// sets the panel to center
		this.setBounds(new Rectangle(centerX, centerY, xPanelSize, yPanelSize));
		
	}
	
}
