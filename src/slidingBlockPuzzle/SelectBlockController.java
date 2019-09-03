package slidingBlockPuzzle;

import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

public class SelectBlockController {
	
	Puzzle puzzle;
	MainWindow view;
	public void select(MouseEvent e) {
		puzzle.select(e.getX(), e.getY());
		SwingUtilities.updateComponentTreeUI(view);
		//System.out.println("hello");
	}
	public SelectBlockController(Puzzle puzzlein, MainWindow app) {
		puzzle = puzzlein;
		view = app;
	}

}
