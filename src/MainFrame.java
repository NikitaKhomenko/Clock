
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clockMachine.Clock;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btStop, btStart;
	private JComboBox<String> cbOrigin;
	private Clock clock = new Clock();
	
	public MainFrame() {
		setFrameConfigurations();
		
		setButtonsPrefrences();
		
		arrangeComponents();

		setButtonsActionListeners();
	}
	


	private void setFrameConfigurations() {
		setTitle("Clock");
		setSize(new Dimension(510, 550));
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setAlwaysOnTop(true);
	}


	private void setButtonsActionListeners() {
		btStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent stop) {
				clock.stop();	
			}
		});
		
		btStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent start) {
				clock.MovingTime();
			}
		});
		
		cbOrigin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent changeColor) {
				int selected = cbOrigin.getSelectedIndex();
				Clock.setHourTimeZone(selected);
			}
		});

	}


	private void setButtonsPrefrences() {
		btStop = new JButton("Stop");
		btStop.setPreferredSize(new Dimension(90, 30));
		btStart = new JButton("Start");
		btStart.setPreferredSize(new Dimension(90, 30));
		cbOrigin = new JComboBox<String>(new String[] {"Jerusalem", "New York", "London", "Tokyo", "Canberra"});
	}
	
	private void arrangeComponents() {
		JPanel ButtonPnl = new JPanel();

        setLayout(new BorderLayout(10, 10));
        this.add(clock, BorderLayout.CENTER);
	    this.add(ButtonPnl, BorderLayout.SOUTH);

	    ButtonPnl.add(btStop);
	    ButtonPnl.add(btStart);
	    ButtonPnl.add(cbOrigin);
	}

}


