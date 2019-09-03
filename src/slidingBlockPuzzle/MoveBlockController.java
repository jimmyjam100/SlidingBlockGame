package slidingBlockPuzzle;

import javax.swing.SwingUtilities;

public class MoveBlockController {
	
	Puzzle puzzle;
	MainWindow view;
	
	public MoveBlockController(Puzzle puzzlein, MainWindow app) {
		puzzle = puzzlein;
		view = app;
	}

	void move(Puzzle.direction direct) {
		puzzle.move(direct);
		SwingUtilities.updateComponentTreeUI(view);
	}
}
