package slidingBlockPuzzle;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

class Tests {

	@Test
	void moveTest1() {
		Puzzle puzzle = new Puzzle();
		puzzle.select(150, 250);
		assertEquals(puzzle.selectedBlock.x, 1);
		assertEquals(puzzle.selectedBlock.y, 2);
		puzzle.move(Puzzle.direction.RIGHT);
		assertEquals(puzzle.selectedBlock.x, 2);
		assertEquals(puzzle.selectedBlock.y, 2);
		puzzle.move(Puzzle.direction.UP);
		assertEquals(puzzle.selectedBlock.x, 2);
		assertEquals(puzzle.selectedBlock.y, 2);

		
	}
	
	@Test
	void moveTest2(){
		Puzzle puzzle = new Puzzle();
		puzzle.select(350, 350);
		assertEquals(puzzle.selectedBlock.x, 3);
		assertEquals(puzzle.selectedBlock.y, 3);
		puzzle.move(Puzzle.direction.LEFT);
		assertEquals(puzzle.selectedBlock.x, 2);
		assertEquals(puzzle.selectedBlock.y, 3);
		puzzle.move(Puzzle.direction.UP);
		assertEquals(puzzle.selectedBlock.x, 2);
		assertEquals(puzzle.selectedBlock.y, 2);
		puzzle.move(Puzzle.direction.DOWN);
		assertEquals(puzzle.selectedBlock.x, 2);
		assertEquals(puzzle.selectedBlock.y, 3);
	}
	
	@Test
	void resetTest() {
		MainWindow win = new MainWindow();
		win.setVisible(true);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Puzzle puzzle = new Puzzle();
		puzzle.select(150, 250);
		assertEquals(puzzle.selectedBlock.x, 1);
		assertEquals(puzzle.selectedBlock.y, 2);
		puzzle.move(Puzzle.direction.RIGHT);
		assertEquals(puzzle.selectedBlock.x, 2);
		assertEquals(puzzle.selectedBlock.y, 2);
		new ResetButtonController(puzzle, win).Reset();
		assertEquals(puzzle, new Puzzle());
		
	}
	
	@Test
	void falseEquals() {
		Puzzle puzzle = new Puzzle();
		puzzle.select(150, 250);
		assertEquals(puzzle.selectedBlock.x, 1);
		assertEquals(puzzle.selectedBlock.y, 2);
		puzzle.move(Puzzle.direction.RIGHT);
		assertEquals(puzzle.selectedBlock.x, 2);
		assertEquals(puzzle.selectedBlock.y, 2);
		assertNotEquals(puzzle, new Puzzle());
	}
	
	@Test
	void moveControllerTest() {
		MainWindow win = new MainWindow();
		win.setVisible(true);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Puzzle puzzle = new Puzzle();
		puzzle.select(150, 250);
		assertEquals(puzzle.selectedBlock.x, 1);
		assertEquals(puzzle.selectedBlock.y, 2);
		new MoveBlockController(puzzle, win).move(Puzzle.direction.RIGHT);
		assertEquals(puzzle.selectedBlock.x, 2);
		assertEquals(puzzle.selectedBlock.y, 2);
		new ResetButtonController(puzzle, win).Reset();
		assertEquals(puzzle, new Puzzle());
		
	}
	
	@Test
	void winTest() {
		Puzzle puzzle = new Puzzle();
		puzzle.playerBlock.y = 3;
		puzzle.selectedBlock = puzzle.playerBlock;
		assertEquals(puzzle.hasWon, false);
		puzzle.move(Puzzle.direction.DOWN);
		assertEquals(puzzle.hasWon, true);
		
	}

}
