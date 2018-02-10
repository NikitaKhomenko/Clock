package clockMachine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;


public class Clock extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer timer;
	int degree = 0;
	final static int x = 80;
	final static int y = 50;
	
	public void MovingTime() {
		timer = new Timer();
		TimerTask timeSeconds = new MyTimerTask();
		timer.schedule(timeSeconds, 1000, 999999999);
		
	}

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		String time = getTime();
		int hours = Integer.parseInt(time.substring(0, 2));
		if(hours > 12)
			hours = hours - 12;
		int minutes = Integer.parseInt(time.substring(3, 5));
		int seconds = Integer.parseInt(time.substring(6, 8));

        setLayout(new BorderLayout());
		g.setColor(Color.BLACK);
		g.drawOval(x, y, 340, 340);
		g.setColor(Color.WHITE);
		g.fillOval(x, y, 340, 340);
		
		g.setColor(Color.BLUE);
		g.fillArc(x, y, 340, 340, -hours*30+90, 1);
		g.setColor(Color.GREEN);
		g.fillArc(x, y, 340, 340, -minutes*6+90, 1);
		g.setColor(Color.RED);
		g.fillArc(x, y, 340, 340, -seconds*6+90, 1);
		
		g.setColor(Color.BLACK);
		Font FontNumbers = new Font("TimesRoman", Font.BOLD, 27);
		g.setFont(FontNumbers);
		g.drawString("12", 235, 76);
		g.drawString("3", 400, 225);
		g.drawString("6", 243, 382);
		g.drawString("9", 92, 228);
		g.drawString(time, 200, 440);

		
		MovingTime();
		
//		System.out.println(hours + " " + minutes + " " + seconds);
	}
	
	class MyTimerTask extends TimerTask{
		@Override
		public void run() {
			if (true)
				degree = degree + 6;
			repaint();
		}
	}
	
	public void stop() {
		timer.cancel();
	}
	
	public String getTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
	
	public void summer() {
	}
	
	public void winter() {
	}


	
}
