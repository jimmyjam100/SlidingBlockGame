package slidingBlockPuzzle;

import javax.swing.SwingUtilities;

public class ResetButtonController {
	Puzzle puzzle;
	MainWindow view;
	public void Reset() {
		puzzle.moveCounter = 0;
		puzzle.hasWon = false;
		puzzle.selectedBlock = null;
		for (Block block : puzzle.blocks) {
			block.x = block.startX;
			block.y = block.startY;
		}
		SwingUtilities.updateComponentTreeUI(view);
	}
	public ResetButtonController(Puzzle puzzlein, MainWindow app) {
		puzzle = puzzlein;
		view = app;
	}
}
