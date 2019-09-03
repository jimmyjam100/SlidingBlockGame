package slidingBlockPuzzle;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class MainWindow extends JFrame{
	
	Puzzle puzzle = new Puzzle();

	private JPanel contentPane;
	JButton resetButton;
	JButton leftButton;
	JButton rightButton;
	JButton upButton;
	JButton downButton;
	private JLabel lblExit;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		MainWindow view = this;
		
		view.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		
		
		PuzzleSpace panel = new PuzzleSpace(puzzle);
		Counter counter = new Counter(puzzle);
		
		panel.addMouseListener(new MouseListener() {
			@Override
		    public void mouseClicked(MouseEvent event) {
				new SelectBlockController(puzzle, view).select(event);
		    }

		    @Override
		    public void mouseEntered(MouseEvent arg0) {}

		    @Override
		    public void mouseExited(MouseEvent arg0) {}

		    @Override
		    public void mousePressed(MouseEvent arg0) {}

		    @Override
		    public void mouseReleased(MouseEvent arg0) {}
		});
		
		
		
		resetButton = new JButton("Reset Puzzle");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ResetButtonController(puzzle, view).Reset();
			}
		});
		leftButton = new JButton("<");
		leftButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MoveBlockController(puzzle, view).move(Puzzle.direction.LEFT);
			}
		});
		
		upButton = new JButton("^");
		upButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MoveBlockController(puzzle, view).move(Puzzle.direction.UP);
			}
		});
		
		downButton = new JButton("v");
		downButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MoveBlockController(puzzle, view).move(Puzzle.direction.DOWN);
			}
		});
		
		rightButton = new JButton(">");
		rightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MoveBlockController(puzzle, view).move(Puzzle.direction.RIGHT);
			}
		});
		
		view.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				new ExitController(view).exit();
			}
		});
		
		lblExit = new JLabel("EXIT");
		lblExit.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(76)
										.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(118, Short.MAX_VALUE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(leftButton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
										.addGap(29)
										.addComponent(rightButton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
										.addGap(66)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(125)
									.addComponent(counter, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
									.addGap(171)))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(upButton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
								.addGap(133)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(downButton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(133))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(185)
					.addComponent(lblExit, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(541, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(30)
							.addComponent(counter, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(50)
							.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addGap(89)
							.addComponent(upButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(leftButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
								.addComponent(rightButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(downButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblExit, GroupLayout.PREFERRED_SIZE, 18, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
