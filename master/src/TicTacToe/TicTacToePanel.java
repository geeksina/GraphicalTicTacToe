package TicTacToe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TicTacToePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Button[][] buttons;
	Label[] labels=new Label[2];
	JTextField firstTextField=new JTextField();
	radiobutton[] radiobuttons=new radiobutton[2];
	DoozAction action=new DoozAction();
	String MainShape;
	TicTacToePlayer player1=new TicTacToePlayer();
	TicTacToePlayer player2=new TicTacToePlayer();
	public TicTacToePanel(int NumberofButtons,String shape1,String shape2) {
		// TODO Auto-generated constructor stub
		this.setLayout(null);
		player1.shape=shape1;
		player2.shape=shape2;
		buttons=new Button[NumberofButtons/3][NumberofButtons/3];
		this.CreatButtonTable(NumberofButtons);
		this.CreatPlayersLabels();
		this.CreatPlayersRadioButton();
		MainShape=player1.shape;
		
		
	}
	public int IsWin() {
		
		for (int i = 0;i<3;i++) {
		if (buttons[0][i].getText()==player1.shape)
		{
			return 1;
		}
	}
		if (buttons[1][0].getText()==player1.shape && buttons[1][2].getText()==player1.shape && buttons[1][1].getText()==player1.shape) {
			return 1;
		}
		if (buttons[2][0].getText()==player1.shape && buttons[2][2].getText()==player1.shape && buttons[2][1].getText()==player1.shape) {
			return 1;
		}
		
		if (buttons[0][0].getText()==player1.shape && buttons[0][2].getText()==player1.shape && buttons[0][1].getText()==player1.shape) {
			return 1;
		}
		if (buttons[0][1].getText()==player1.shape && buttons[2][1].getText()==player1.shape && buttons[1][1].getText()==player1.shape) {
			return 1;
		}
		if (buttons[0][2].getText()==player1.shape && buttons[2][2].getText()==player1.shape && buttons[2][1].getText()==player1.shape) {
			return 1;
		}
		
		if (buttons[0][0].getText()==player1.shape && buttons[1][1].getText()==player1.shape && buttons[2][2].getText()==player1.shape) {
			return 1;
		}
		if (buttons[2][0].getText()==player1.shape && buttons[0][2].getText()==player1.shape && buttons[1][1].getText()==player1.shape) {
			return 1;
		}
		
		if (buttons[0][0].getText()==player2.shape && buttons[0][2].getText()==player2.shape && buttons[0][1].getText()==player2.shape) {
			return 2;
		}
		if (buttons[1][0].getText()==player2.shape && buttons[1][2].getText()==player2.shape && buttons[1][1].getText()==player2.shape) {
			return 2;
		}
		if (buttons[2][0].getText()==player2.shape && buttons[2][2].getText()==player2.shape && buttons[2][1].getText()==player2.shape) {
			return 2;
		}
		
		if (buttons[0][0].getText()==player2.shape && buttons[0][2].getText()==player2.shape && buttons[0][1].getText()==player2.shape) {
			return 2;
		}
		if (buttons[0][1].getText()==player2.shape && buttons[2][1].getText()==player2.shape && buttons[1][1].getText()==player2.shape) {
			return 2;
		}
		if (buttons[0][2].getText()==player2.shape && buttons[2][2].getText()==player2.shape && buttons[2][1].getText()==player2.shape) {
			return 2;
		}
		
		if (buttons[0][0].getText()==player2.shape && buttons[1][1].getText()==player2.shape && buttons[2][2].getText()==player2.shape) {
			return 2;
		}
		if (buttons[2][0].getText()==player2.shape && buttons[0][2].getText()==player2.shape && buttons[1][1].getText()==player2.shape) {
			return 2;
		}
		
		return 0;
		
		
	}
	
	public void CreatPlayersRadioButton() {
		radiobuttons[0]=new radiobutton();
		radiobuttons[0].setLocation(160, 0);
		this.add(radiobuttons[0]);
		radiobuttons[1]=new radiobutton();
		radiobuttons[1].setLocation(160, 20);
		this.add(radiobuttons[1]);
		
		
	}
	public void CreatPlayersLabels() {
		labels[0]=new Label();
		labels[0].setText("pl1");
		labels[0].setLocation(130,0);
		this.add(labels[0]);
		labels[1]=new Label();
		labels[1].setText("pl2");
		labels[1].setLocation(130,20);
		this.add(labels[1]);
		
	}
	public  void CreatButtonTable(int NumberOfButtons) {
		if (NumberOfButtons>=9 && NumberOfButtons%9==0) {
			
				for (int i = 0; i < buttons.length; i++) {
				for (int j = 0; j < buttons.length; j++) {
					buttons[i][j]=new Button();
					buttons[i][j].setLocation(i*40,j*40);
					buttons[i][j].addActionListener(action);
					
					buttons[i][j].setVisible(true);
				
					this.add(buttons[i][j]);
				}
			}
		}
	}
	public class Button extends JButton
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Button() {
			// TODO Auto-generated constructor stub
			this.setSize(40,40);
		}
	}
	public class Label extends JLabel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Label() {
			// TODO Auto-generated constructor stub
			this.setSize(20, 20);
		}
	}

	public class radiobutton extends JRadioButton  {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public radiobutton() {
			// TODO Auto-generated constructor stub
			this.setSize(20, 20);
		}
	}
	public void help() {
		if (TicTacToePlayer.PlayerShift==0) {
			MainShape=player1.shape;
			radiobuttons[1].setSelected(false);
			radiobuttons[0].doClick();
			TicTacToePlayer.PlayerName="pl1";
			
			TicTacToePlayer.PlayerShift=1;
		}else if (TicTacToePlayer.PlayerShift==1) {
			MainShape=player2.shape;
			radiobuttons[0].setSelected(false);
			radiobuttons[1].doClick();
			TicTacToePlayer.PlayerName="pl2";
			TicTacToePlayer.PlayerShift=0;
		}
	}
	public class  DoozAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			//buttons[0][0].setText(MainShape);
			
			Button tmp;
			for( int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++){
					tmp = buttons[i][j];
				if(event.getSource()==tmp){
					buttons[i][j].setText(MainShape);
					//buttons[i][j].setVisible(false);
					help();
					if (IsWin()==1 || IsWin()==2) {
						JOptionPane.showMessageDialog(null, TicTacToePlayer.PlayerName+"is winner");
					}
				}
				}
			}
			
			if (event.getSource()==buttons[0][0]) {
				buttons[0][0].setText(MainShape);
				help();
				if (IsWin()==1 || IsWin()==2) {
					JOptionPane.showMessageDialog(null, TicTacToePlayer.PlayerName+"is winner");
				}
			}
				if (event.getSource()==buttons[0][1]) {
					buttons[0][1].setText(MainShape);
					help();
					if (IsWin()==1 || IsWin()==2) {
						JOptionPane.showMessageDialog(null, TicTacToePlayer.PlayerName+"is winner");
					}
				}
				if (event.getSource()==buttons[0][2]) {
						buttons[0][2].setText(MainShape);
						help();
						if (IsWin()==1 || IsWin()==2) {
							JOptionPane.showMessageDialog(null, TicTacToePlayer.PlayerName+"is winner");
						}
				}
				if (event.getSource()==buttons[1][0]) {
						buttons[1][0].setText(MainShape);
						help();
						if (IsWin()==1 || IsWin()==2) {
								JOptionPane.showMessageDialog(null, TicTacToePlayer.PlayerName+"is winner");
						}
				}
				if (event.getSource()==buttons[1][1]) {
						buttons[1][1].setText(MainShape);
						help();
						if (IsWin()==1 || IsWin()==2) {
								JOptionPane.showMessageDialog(null, TicTacToePlayer.PlayerName+"is winner");
						}
				}
				if (event.getSource()==buttons[1][2]) {
						buttons[1][2].setText(MainShape);
						help();
						if (IsWin()==1 || IsWin()==2) {
								JOptionPane.showMessageDialog(null, TicTacToePlayer.PlayerName+"is winner");
						}	
				}
				if (event.getSource()==buttons[2][0]) {
						buttons[2][0].setText(MainShape);
						help();
						if (IsWin()==1 || IsWin()==2) {
								JOptionPane.showMessageDialog(null, TicTacToePlayer.PlayerName+"is winner");
						}
				}
				if (event.getSource()==buttons[2][1]) {
						buttons[2][1].setText(MainShape);
						help();
						if (IsWin()==1 || IsWin()==2) {
								JOptionPane.showMessageDialog(null, TicTacToePlayer.PlayerName+"is winner");
						}
				}
				if (event.getSource()==buttons[2][2]) {
						buttons[2][2].setText(MainShape);
						help();
						if (IsWin()==1 || IsWin()==2) {
								JOptionPane.showMessageDialog(null, TicTacToePlayer.PlayerName+"is winner");
				}	
			}
		}	
	}
}

