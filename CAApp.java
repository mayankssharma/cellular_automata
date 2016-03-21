package mypackage;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class CAApp extends Applet implements ActionListener {

	String comboselected;
	Button start;
	Button stop;
	Button submit;
	Button abort;
	Timer t;
	TextField txt;
	Label lb;
	Choice combo;

	int b = 0;
	int d = 0;
	int l = 1;
	int p = 2;
	int col = 1;

	public void init() {

		setSize(900, 700);

		start = new Button("START PAINTING");
		stop = new Button("PAUSE PAINTING");
		abort = new Button("ABORT RULE AND GO WITH NEW ONE");
		submit = new Button("SUBMIT FOR GENERATION OF LOGIC");
		txt = new TextField("1000");
		lb = new Label("Select the number of Iterations and Rule and then click on SUBMIT");

		combo = new Choice();
		combo.add("ruleset90");
		combo.add("ruleset165");
		combo.add("ruleset130");

		start.addActionListener(this);
		stop.addActionListener(this);
		submit.addActionListener(this);
		abort.addActionListener(this);

		this.add(lb);
		this.add(txt);
		this.add(combo);
		this.add(submit);
		this.add(abort);
		this.add(start);
		this.add(stop);

		t = new Timer(350, this);

	}

	public void paint(Graphics g) {

		try {

			setBackground(Color.CYAN);
			this.start.setLocation(200, 80);
			this.stop.setLocation(600, 80);
			this.abort.setLocation(340, 50);
			int count = 110; // variable "count" is set 110 so that the
								// painting starts from y axis - 110 and further
								// goes down by 5
			l++; // variable "l" is used to keep a track of how much time
					// the timer has run . so the number of rows painted should
					// be equal to that only.
			if (d != 0) // variable "d" is used to check whether its
						// first time its painting or not.
			{

				for (int j = 0, c = 0; c < l - 1; j++, c++) {

					CACell cag = (CAGeneration.ar).get(j);

					count = count + 10;
					for (int i = 0; i < 64; i++) {
						if (col % 2 == 0) // variable "col" is to use
											// different colors.
						{
							if (cag.c[i] == 0) // if 0 the paint red
							{

								g.setColor(Color.RED);

								g.fillRect(10 * i, count, 10, 10);

							} else // if 1 the paint green
							{

								g.setColor(Color.GREEN);
								g.fillRect(10 * i, count, 10, 10);

							}
						} else {
							if (cag.c[i] == 0) // if 0 the paint blue
							{

								g.setColor(Color.BLUE);

								g.fillRect(10 * i, count, 10, 10);

							} else // if 1 the paint magenta
							{

								g.setColor(Color.MAGENTA);
								g.fillRect(10 * i, count, 10, 10);

							}
						}
					} // for each row

					col++;

				} // for all rows

			}
			d++;

		} catch (Exception e) {

		}

	}

	public void actionPerformed(ActionEvent a) {
		if (a.getSource() == start) // when START PAINTING button is pressed
		{
			if (b == 0) // if its the first time( variable "b" here checks that)
						// , then the timer will start or else it will restart
			{
				t.start();
				b++;

			} else
				t.restart();

		} else if (a.getSource() == stop) // when PAUSE PAINTING button is
											// pressed
		{
			t.stop();
		}

		else if (a.getSource() == t) // when timer is in action
		{
			int r = Integer.parseInt(txt.getText());

			if (r == p) // if number of iteration entered by user equals the
						// number of times the timer had run , then timer stops
						// else it keeps on repainting
			{
				t.stop();
			} else {
				p++;
				repaint();
			}
		}

		else if (a.getSource() == submit) // when SUBMIT FOR GENERATION OF LOGIC
											// button is pressed
		{

			int r = Integer.parseInt(txt.getText()); // variable "r" stands for
														// the number of
														// iterations selected
														// by user
			comboselected = combo.getSelectedItem().toString(); // variable
																// "comboselected"
																// stands for
																// the ruleset
																// selected by
																// the user

			CAGenerationSet cagen = new CAGenerationSet();
			// below is the logic to pass "r" and "comboselected" to the
			// CAGenerationSet for creation of ruleset
			switch (comboselected) {
			case "ruleset90":
				cagen.callCAGeneration90(r);
				break;
			case "ruleset130":
				cagen.callCAGeneration130(r);
				break;
			case "ruleset165":
				cagen.callCAGeneration165(r);
				break;
			}

		}

		else if (a.getSource() == abort) // when ABORT RULE AND GO WITH NEW ONE
											// button is pressed
		{

			t.stop(); // timer is stopped
			b = 0;
			p = 2;
			d = 0;
			l = 1;
			col = 1;
			CAGeneration.ar.clear(); // current values in the arraylist are
										// cleared so that it can now be filled
										// with new values for other rule set
		}

	}

}
