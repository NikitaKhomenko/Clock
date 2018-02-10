
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import clockMachine.Clock;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btStop, btGeorgian, btSummer, btWinter;
	private Clock clock = new Clock();

	public MainFrame() {
		setTitle("Clock");
		setSize(new Dimension(510, 550));
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setAlwaysOnTop(true);
		
		btStop = new JButton("Stop");
		btStop.setPreferredSize(new Dimension(90, 30));
		btGeorgian = new JButton("Georgian");
		btGeorgian.setPreferredSize(new Dimension(90, 30));
		btSummer = new JButton("Summer");
		btSummer.setPreferredSize(new Dimension(90, 30));
		btWinter = new JButton("Winter");
		btWinter.setPreferredSize(new Dimension(90, 30));
		
		arrangeComponents();

		
		btStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent stop) {
				clock.stop();	
			}
		});
		
		btGeorgian.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent start) {
				clock.MovingTime();
			}
		});
		
		


	}
	
	
	private void arrangeComponents() {
		JPanel ButtonPnl = new JPanel();

        setLayout(new BorderLayout(10, 10));
        this.add(clock, BorderLayout.CENTER);
	    this.add(ButtonPnl, BorderLayout.SOUTH);

	    ButtonPnl.add(btStop);
	    ButtonPnl.add(btGeorgian);
	    ButtonPnl.add(btSummer);
	    ButtonPnl.add(btWinter);

        
	}
}


