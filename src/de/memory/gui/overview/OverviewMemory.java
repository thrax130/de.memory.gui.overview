package de.memory.gui.overview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.memory.api.IPlayer;
import de.memory.gui.MemoryGUI;
import de.memory.gui.OvalView;

public class OverviewMemory extends MemoryGUI {

	private OvalView player1Oval = new OvalView(Color.GREEN);
	private JLabel player1Pairs = new JLabel("0");
	private OvalView player2Oval = new OvalView(Color.RED);
	private JLabel player2Pairs = new JLabel("0");
	
	private JButton startNewGameButton = new JButton("Start new game");
	public OverviewMemory() {
		super("Overview Memory");
	}
	@Override
	protected JComponent northView() {
		return this.getHeaderView();//header;
	}

	@Override
	protected JComponent southView() {
		//button functionality
		startNewGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetVisibilityMemoryFieldElements();
				getModel().startNewGame();
			}
		});
		JPanel footer = new JPanel();
		footer.setLayout(new BorderLayout());
		footer.add(this.startNewGameButton, BorderLayout.CENTER);
		return footer;
	}

	@Override
	protected JComponent eastView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected JComponent westView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void updateView() {
		super.updateView();
		this.player1Pairs.setText(""+getModel().getPlayer(1).getAmountCardPairs());
		this.player1Pairs.repaint();
		this.player1Oval.setColor( getModel().getPlayer(1).isActive() ? Color.GREEN : Color.RED);
		this.player1Oval.repaint();
		
		this.player2Pairs.setText(""+getModel().getPlayer(2).getAmountCardPairs());
		this.player2Pairs.repaint();
		this.player2Oval.setColor( getModel().getPlayer(2).isActive() ? Color.GREEN : Color.RED);
		this.player2Oval.repaint();
		
		//display winner
		IPlayer winner = getModel().getWinner();
		if(winner != null) {
			showMessageDialog("Player "+winner.getPlayerNumber()+" has won!");
		}
	}
	
	private JComponent getHeaderView() {
		JPanel header = new JPanel();
		header.setLayout(new GridLayout(2,4));
		header.add(new JLabel("Player 1"));
		header.add(this.player1Oval);
		header.add(new JLabel("Player 2"));
		header.add(this.player2Oval);
		header.add(new JLabel("Pairs:"));
		//TODO pair counter player 1
		header.add(this.player1Pairs);
		
		header.add(new JLabel("Pairs:"));
		//TODO pair counter player 2
		header.add(this.player2Pairs);
		return header;
	}
	@Override
	public void startNewGame() {
		//reset visibility of all memory field elements
		resetVisibilityMemoryFieldElements();
	}

}
