package slidingBlockPuzzle;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PuzzleSpace extends JPanel {
	Puzzle puzzle;
	/**
	 * Create the panel.
	 */
	public PuzzleSpace(Puzzle puzzle) {
		this.puzzle = puzzle;
		setSize(400, 500);
        setVisible(true);
		setBackground(Color.gray);

	}
	
    @Override
    public void paint(Graphics g) 
    {
    	super.paint(g);
    	if(!puzzle.hasWon) {
    		for (Block block : puzzle.blocks) {
    			if(block == puzzle.playerBlock && block == puzzle.selectedBlock) {
    				g.setColor(new Color(255, 153, 153));
    			}
    			else if(block == puzzle.playerBlock) {
    				g.setColor(Color.RED);
    			}
    			else if(block == puzzle.selectedBlock) {
    				g.setColor(new Color(204, 229, 207));
    			}
    			else {
        			g.setColor(new Color(70, 110, 40));	
    			}
    			g.fillRect(block.x*100 + 2, block.y*100 + 2, block.w*100 - 4, block.h*100 - 4);
    			g.setColor(Color.BLACK);
    			g.drawRect(block.x*100 + 2, block.y*100 + 2, block.w*100 - 4, block.h*100 - 4);
    		}
    	}
    	else {
    	    g.drawString("YOU WIN!!!!!", 170, 200);
    	}
    }


}
