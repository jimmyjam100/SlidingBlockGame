package slidingBlockPuzzle;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Label;

public class Counter extends JPanel {
	Puzzle puzzle;

	/**
	 * Create the panel.
	 */
	public Counter(Puzzle puzzle) {
		this.puzzle = puzzle;

	}
	 @Override
	 public void paint(Graphics g) 
	 {
	    super.paint(g);
	    g.drawString("Moves: " + String.valueOf(puzzle.moveCounter), 10, 10);
	 }

}
