package slidingBlockPuzzle;

import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class ExitController {
	
	MainWindow view;
	public void exit() {
		int c = JOptionPane.showConfirmDialog(view, "do you wish to quit?");
		if (c == JOptionPane.OK_OPTION) {
			view.setVisible(false);
			view.dispose();
		}
	}
	public ExitController(MainWindow app) {
		view = app;
	}

}