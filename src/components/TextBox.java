package components;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextField;

public class TextBox extends JTextField{
	
	private int xRect;
	private int yRect;
	private int textFontSize;
	
	public int getTextFontSize() {
		return textFontSize;
	}

	public void setTextFontSize(int textFont) {
		this.textFontSize = textFont;
	}

	public int getxRect() {
		return xRect;
	}

	public int getyRect() {
		return yRect;
	}

	public void setxRect(int xRect) {
		this.xRect = xRect;
	}

	public void setyRect(int yRect) {
		this.yRect = yRect;
	}
	
	public TextBox(int x, int y) {

		setxRect(x);
		setyRect(y);
		
		setTextFontSize(getyRect() / 2);
		// sets the font size relative to height of the text box
		
		textBoxComponent();
	}
	
	private void textBoxComponent() {
		this.setBounds(0, 0, getxRect(), getyRect());
		this.setFont(new Font("Consolas", Font.PLAIN, getTextFontSize()));
	}
	
}
