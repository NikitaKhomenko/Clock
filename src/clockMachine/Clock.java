package clockMachine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;


public class Clock extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer timer;
	private static int hour = 0;
	final static int x = 80;
	final static int y = 50;
	
	public void MovingTime() {
		timer = new Timer();
		TimerTask timeSeconds = new MyTimerTask();
		timer.schedule(timeSeconds, 1000, 99999999);
		
	}

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// get time
		LocalDateTime time = LocalDateTime.now();
		int hours = time.getHour() + Clock.hour;
		
		int hoursDigital = hours;
		if(hoursDigital > 23)
			hoursDigital =- 24;
		if(hoursDigital < 0)
			hoursDigital =+ 24;
		
		if(hours > 11)
			hours = hours - 12;
		else if(hours < 0)
			hours = hours + 12;
		
		int minutes = time.getMinute();
		int seconds = time.getSecond();

		// clock component
		g.setColor(Color.WHITE);
		g.fillOval(x, y, 340, 340);
        g.setColor(Color.BLACK);
		g.drawOval(x, y, 340, 340);
		
		// Clock dial component
		g.setColor(Color.BLUE);
		g.fillArc(x+60, y+60, 220, 220, -hours*30+90, 3);
		g.setColor(Color.GREEN);
		g.fillArc(x+20, y+20, 300, 300, -minutes*6+90, 2);
		g.setColor(Color.RED);
		g.fillArc(x, y, 340, 340, -seconds*6+90, 1);
		
		// numbers component
		g.setColor(Color.BLACK);
		Font FontNumbers = new Font("TimesRoman", Font.BOLD, 27);
		g.setFont(FontNumbers);
		g.drawString("12", 235, 76);
		g.drawString("3", 400, 225);
		g.drawString("6", 243, 382);
		g.drawString("9", 92, 228);
		
		if (hoursDigital < 10)
			g.drawString("0" + hoursDigital + ":" + minutes + ":" + seconds, 200, 440);
		else
			g.drawString(hoursDigital + ":" + minutes + ":" + seconds, 200, 440);


		MovingTime();
	}
	
	class MyTimerTask extends TimerTask{
		@Override
		public void run() {
			repaint();
		}
	}
	
	public void stop() {
		timer.cancel();
	}
	
	public static void setOrigin(int selected) {
		if (selected == 0)
			hour = 0;
		if (selected == 1)
			hour = -7;
		if (selected == 2)
			hour = -2;
		if (selected == 3)
			hour = 7;
		if (selected == 4)
			hour = 9;				
	}

}
