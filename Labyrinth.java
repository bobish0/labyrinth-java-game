
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;  // import
import java.io.File;
import java.io.IOException; // import
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;   // import
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent; // didnt tell me about this either, for making mouse things work.
import java.applet.AudioClip;


public class Labyrinth extends JComponent implements MouseMotionListener {




	// images and audio-files outside of the main method

	BufferedImage introduktion;
	BufferedImage niva1;
	BufferedImage niva2;
	BufferedImage niva3;
	BufferedImage slut;
	BufferedImage nuvarandeniva;

	AudioClip Hero = JApplet.newAudioClip(getClass().getResource("Hero.wav"));  // Gets audiofile, java only supports .wav 



//gets the images through objects in the constructor.
	public Labyrinth()throws IOException {
	introduktion = ImageIO.read(getClass().getResource("IntroScreen.png"));   // has memory reserved for it .
	niva1 = ImageIO.read(getClass().getResource("Level1.png"));
	niva2 = ImageIO.read(getClass().getResource("Level2.png"));
	niva3 = ImageIO.read(getClass().getResource("Level3.png"));
	slut = ImageIO.read(getClass().getResource("GameOver.png"));

	nuvarandeniva = introduktion;  // starting image.
	}


public static void main (String[] args)throws IOException{ // also needed in the main method.

JFrame fonster = new JFrame ("Ryan Gosling maze by Kristian");

	Labyrinth spel = new Labyrinth();
	fonster.add(spel);
	fonster.pack();
	fonster.setLocationRelativeTo(null);   // new
	fonster.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	fonster.setVisible(true);

	spel.addMouseMotionListener(spel);  // 'So the game knows when the mouse is moving'
	}

	//Override.
	public Dimension getPreferredSize() {  // it has to be Dimension.
		return new Dimension(2000,1000);
}


	protected void paintComponent(Graphics h) {  // method needs to be be public if existing in another class,and called upon.


	h.setColor(Color.BLUE);
	h.fillRect(0, 0, 2000, 1000);

		h.drawImage(nuvarandeniva,0,0,null);
	}

	//mandatory
	public void mouseDragged(MouseEvent h) {
	// does nothing
	}

	//mandatory
	public void mouseMoved(MouseEvent h) {
	// check color of the pixel that the mouse is over.

	int x = h.getX();  // get mouse x position
	int y = h.getY();	// get mouse y position
	int farg = nuvarandeniva.getRGB(x, y);

	System.out.println(farg);


  // Level 1
if (farg == -16735512){

	nuvarandeniva = niva1;
		}


if (farg == -6694422){
	nuvarandeniva = slut;
	Hero.play();

}




// Level 2
if (farg == -9399618) {
	nuvarandeniva = niva2;

	}

	if (farg == -12629812){
	nuvarandeniva = slut;
		Hero.play();
	}




	repaint();	  // so it redraws the screen



	}

}
