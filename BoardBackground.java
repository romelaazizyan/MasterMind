package masterMindGame;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class BoardBackground extends JPanel{
	public BoardBackground() {
	}

	@Override
	protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g;
	g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	int w = getWidth();
	int h = getHeight();
	//Color color1 = Color.BLUE;	
	//Color color2 = Color.CYAN;
	Color color1 = new Color(89, 51, 29);
	Color color2 = new Color(178,109,68);

	GradientPaint gp = new GradientPaint(0, 0, color2, 0, h, color1);
	g2d.setPaint(gp);
	g2d.fillRect(0, 0, w, h);
	}

}
