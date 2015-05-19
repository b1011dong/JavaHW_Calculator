package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.beans.Expression;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import model.ExpressionData;
import control.CalculateControler;

public class MainFrame extends JFrame implements ActionListener, KeyListener, MouseListener, MouseWheelListener, MouseMotionListener{

	private static final long serialVersionUID = -4640227615212468133L;
	
	protected int x;
	protected int y;
	protected int _x;
	protected int _y;
	
	private static final int SEVEN = 0;
	private static final int EIGHT = 1;
	private static final int NINE = 2;
	private static final int DIVIDE = 3;
	private static final int FOUR = 4;
	private static final int FIVE = 5;
	private static final int SIX = 6;
	private static final int TIMES = 7;
	private static final int ONE = 8;
	private static final int TWO = 9;
	private static final int THREE = 10;
	private static final int MINUS = 11;
	private static final int ZERO = 12;
	private static final int DOT = 13;
	private static final int EQUALS = 14;
	private static final int PLUS = 15;
	private static final int C = 16;
	private static final int B = 17;
	
	private JPanel mainPanel;
	private JPanel textPanel;
	private JPanel buttonPanel;
	
	private JLabel resultLabel;
	private JLabel operandLabel;
	private JLabel historyLabel;
	private JLabel mainLogoLabel;
	private JLabel calculatorLabel;
	
	private JTextField resultTextField;
	private JTextField operandTextField;
	private JTextField historyTextField;
	
	private JButton[] keyButton;
	private JButton exitButton;
	private JButton minimizeButton;
	
	private ExpressionData exp;
	private CalculateControler con;
	
	public MainFrame()
	{
		makeItSimple();
		
		mainPanelSetup();
		textPanelSetup();
		buttonPanelSetup();
		
		resultLabelSetup();
		operandLabelSetup();
		historyLabelSetup();
		mainLogoLabelSetup();
		calculatorLabelSetup();
		
		resultTextFieldSetup();
		operandTextFieldSetup();
		historyTextFieldSetup();
		
		keyButtonSetup();
		exitButtonSetup();
		minimizeButtonSetup();
		
		this.validate();
	}
	
	
	/* ========== Event Listeners ========== */
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == exitButton)
		{
			System.out.println("Exit Button Clicked");
			this.dispose();
		}
		else if(e.getSource() == minimizeButton)
		{
			System.out.println(" Button Clicked");
			this.setState(Frame.ICONIFIED);
		}
		else
		{
			if(e.getSource() == keyButton[PLUS])
			{
				System.out.println("+ Button Clicked");
			}
			else if(e.getSource() == keyButton[MINUS])
			{
				System.out.println("- Button Clicked");
			}
			else if(e.getSource() == keyButton[TIMES])
			{
				System.out.println("* Button Clicked");
			}
			else if(e.getSource() == keyButton[DIVIDE])
			{
				System.out.println("/ Button Clicked");
			}
			else if(e.getSource() == keyButton[DOT])
			{
				System.out.println(". Button Clicked");
			}
			else if(e.getSource() == keyButton[EQUALS])
			{
				System.out.println("= Button Clicked");
			}
			else if(e.getSource() == keyButton[C])
			{
				System.out.println("C Button Clicked");
			}
			else if(e.getSource() == keyButton[B])
			{
				System.out.println("B Button Clicked");
			}
			else
			{
				System.out.println("number button clicked : " + e.getActionCommand());
			}
			
			performCommand(e.getActionCommand());
		}
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		System.out.println("Key Pressed");
		
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
		{
			this.dispose();
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e)
	{
		
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		for(int i = 0; i < 18; i++)
		{
			if(e.getSource() == keyButton[i])
			{
				keyButton[i].setBackground(new Color(255, 252, 128));
				break;
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		for(int i = 0; i < 18; i++)
		{
			if(e.getSource() == keyButton[i])
			{
				keyButton[i].setBackground(new Color(244, 249, 251));
				break;
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		_x = e.getX();
		_y = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) 
	{
		x = e.getXOnScreen() - _x;
		y = e.getYOnScreen() - _y;
		
		this.setBounds(x, y, getWidth(), getHeight());
	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
		
	}
	
	
	/* ========== View methods ========== */
	
	public void performCommand(String command)
	{
		con.compute(command);
	}
	
	public void repaintTextField()
	{
		resultTextField.setText(getExp().getResult());
		operandTextField.setText(getExp().getOperand());
		historyTextField.setText(getExp().getHistory());
		
		this.textPanel.validate();
	}
	
	
	/* ========== Setups ========== */
	
	private void makeItSimple()
	{
		setLayout(null);
		setUndecorated(true);
		addMouseListener(this);
		addMouseMotionListener(this);
		setTitle("°è»ê±â");
		setSize(275, 335);
		getRootPane().setBorder(new LineBorder(Color.GRAY, 2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		addKeyListener(this);
		
		exp = new ExpressionData("0123456789", "0123456789", "0123456789+-*/.", null);
		con = new CalculateControler(exp);
	}
	
	private void mainPanelSetup()
	{
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setSize(275, 335);
		mainPanel.setBackground(new Color(218, 233, 239));
		this.add(mainPanel);
	}
	
	private void textPanelSetup()
	{
		textPanel = new JPanel();
		textPanel.setLayout(null);
		textPanel.setBackground(Color.WHITE);
		textPanel.setBackground(new Color(218, 233, 239));
		mainPanel.add(textPanel).setBounds(5, 35, 260, 90);
	}
	
	private void buttonPanelSetup()
	{
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5, 4, 2, 2));
		buttonPanel.setBackground(new Color(217, 233, 238));
		buttonPanel.setBorder(new LineBorder(new Color(218, 233, 239), 2));
		mainPanel.add(buttonPanel).setBounds(5, 125, 260, 200);
	}
	
	private void resultLabelSetup()
	{
		resultLabel = new JLabel("  Result");
		resultLabel.setFont(new Font("Buxton Sketch", Font.PLAIN, 18));
		resultLabel.setBackground(Color.WHITE);
		resultLabel.setBorder(BorderFactory.createEtchedBorder());
		textPanel.add(resultLabel).setBounds(3, 0, 75, 29);
	}
	
	private void operandLabelSetup()
	{
		operandLabel = new JLabel("  Operand");
		operandLabel.setFont(new Font("Buxton Sketch", Font.PLAIN, 18));
		operandLabel.setBackground(Color.WHITE);
		operandLabel.setBorder(BorderFactory.createEtchedBorder());
		textPanel.add(operandLabel).setBounds(3, 30, 75, 29);
	}
	
	private void historyLabelSetup()
	{
		historyLabel = new JLabel("  History");
		historyLabel.setFont(new Font("Buxton Sketch", Font.PLAIN, 18));
		historyLabel.setBackground(Color.WHITE);
		historyLabel.setBorder(BorderFactory.createEtchedBorder());
		textPanel.add(historyLabel).setBounds(3, 60, 75, 29);
	}
	
	private void mainLogoLabelSetup()
	{
		mainLogoLabel = new JLabel(new ImageIcon("img/main_logo.png"));
		mainPanel.add(mainLogoLabel).setBounds(10, 5, 18, 25);
	}
	
	public void calculatorLabelSetup()
	{
		calculatorLabel = new JLabel("ParkDongWon Calculator");
		calculatorLabel.setFont(new Font("Buxton Sketch", Font.PLAIN, 14));
		calculatorLabel.setBackground(Color.WHITE);
		mainPanel.add(calculatorLabel).setBounds(35, 10, 200, 25);
	}
	
	private void resultTextFieldSetup()
	{
		resultTextField = new JTextField(getExp().getResult());
		resultTextField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		resultTextField.setEditable(false);
		resultTextField.setFont(new Font("SketchFlow Print", Font.PLAIN, 16));
		resultTextField.setBackground(Color.WHITE);
		resultTextField.setBorder(BorderFactory.createEtchedBorder());
		textPanel.add(resultTextField).setBounds(80, 0, 178, 29);
	}
	
	private void operandTextFieldSetup()
	{
		operandTextField = new JTextField(getExp().getOperand());
		operandTextField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		operandTextField.setEditable(false);
		operandTextField.setFont(new Font("SketchFlow Print", Font.PLAIN, 16));
		operandTextField.setBackground(Color.WHITE);
		operandTextField.setBorder(BorderFactory.createEtchedBorder());
		textPanel.add(operandTextField).setBounds(80, 30, 178, 29);
	}
	
	private void historyTextFieldSetup()
	{
		historyTextField = new JTextField(getExp().getHistory());
		historyTextField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		historyTextField.setEditable(false);
		historyTextField.setFont(new Font("SketchFlow Print", Font.PLAIN, 16));
		historyTextField.setBackground(Color.WHITE);
		historyTextField.setBorder(BorderFactory.createEtchedBorder());
		textPanel.add(historyTextField).setBounds(80, 60, 178, 29);
	}
	
	private void exitButtonSetup()
	{
		exitButton = new JButton(new ImageIcon("img/exit_logo.png"));
		exitButton.setRolloverIcon(new ImageIcon("img/exit_logo_s.png"));
		exitButton.addActionListener(this);
		exitButton.addKeyListener(this);
		exitButton.setBorderPainted(false);
		exitButton.setFocusPainted(false);
		exitButton.setContentAreaFilled(false);
		mainPanel.add(exitButton).setBounds(235, 5, 26, 25);
	}
	private void minimizeButtonSetup()
	{
		minimizeButton = new JButton(new ImageIcon("img/minimize_logo.png"));
		minimizeButton.setRolloverIcon(new ImageIcon("img/minimize_logo_s.png"));
		minimizeButton.addActionListener(this);
		minimizeButton.addKeyListener(this);
		minimizeButton.setBorderPainted(false);
		minimizeButton.setFocusPainted(false);
		minimizeButton.setContentAreaFilled(false);
		mainPanel.add(minimizeButton).setBounds(200, 5, 26, 25);
	}
	
	private void keyButtonSetup()
	{
		keyButton = new JButton[18];
		
		String[] keyNames = {
				"7", "8", "9", "/",
				"4", "5", "6", "*",
				"1", "2", "3", "-",
				"0", ".", "=", "+",
				"C", "B"};
		
		for(int i = 0; i < 18; i++)
		{
			keyButton[i] = new JButton(keyNames[i]);
			keyButton[i].setBackground(Color.WHITE);
			keyButton[i].setFont(new Font("SketchFlow Print", Font.BOLD, 18));
			keyButton[i].setBorder(new LineBorder(Color.GRAY, 1));
			keyButton[i].setFocusPainted(false);
			keyButton[i].setBackground(new Color(244, 249, 251));
			keyButton[i].addActionListener(this);
			keyButton[i].addKeyListener(this);
			keyButton[i].addMouseListener(this);
			buttonPanel.add(keyButton[i]);
		}
	}
	
	
	/* ========== Getters and Setters ========== */

	public ExpressionData getExp() {
		return exp;
	}

	public void setExp(ExpressionData exp) {
		this.exp = exp;
	}

	public CalculateControler getCon() {
		return con;
	}

	public void setCon(CalculateControler con) {
		this.con = con;
	}
	
}
