package clockMachine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
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

    public static Map<Integer, Integer> timeZoneHours = new HashMap<Integer, Integer>();
	
    public Clock() {
	    timeZoneHours.put(1, -7);
	    timeZoneHours.put(0, 0);
	    timeZoneHours.put(2, -2);
	    timeZoneHours.put(3, 7);
	    timeZoneHours.put(4, 9);
	}
	
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
		drawClockNumbers(g);
		
		drawDigitalClock(g, hoursDigital, minutes, seconds);


		MovingTime();
	}

	private void drawDigitalClock(Graphics g, int hoursDigital, int minutes, int seconds) {
		String digitalClock = concatDigitalClockString(hoursDigital, minutes, seconds);
		g.drawString(digitalClock, 200, 440);
	}

	public String concatDigitalClockString(int hoursDigital, int minutes, int seconds) {
		String hoursDisplay = hoursDigital + "";
		String minutesDisplay = minutes + "";
		String secondsDisplay = seconds + ""; 
		
		if (hoursDigital < 10)
			hoursDisplay = "0" + hoursDigital;
		if (minutes < 10)
			minutesDisplay = "0" + minutes;
		if (seconds < 10)
			secondsDisplay = "0" + seconds;
		String digitalClock = hoursDisplay + ":" + minutesDisplay + ":" + secondsDisplay;
		
		return digitalClock;
	}

	private void drawClockNumbers(Graphics g) {
		g.drawString("12", 235, 76);
		g.drawString("3", 400, 225);
		g.drawString("6", 243, 382);
		g.drawString("9", 92, 228);
	}
	
	class MyTimerTask extends TimerTask{
		@Override
		public void run() {
			repaint();     //calling graphics g to repaint clock.
		}
	}
	
	public void stop() {
		timer.cancel();
	}
	
	public static void setHourTimeZone(int selectedHour) {
       hour = timeZoneHours.get(selectedHour);				
	}
	
	public static int getHour() {
		return hour;
	}

}
