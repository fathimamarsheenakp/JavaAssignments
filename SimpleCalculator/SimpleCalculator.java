package SimpleCalculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Font;
import java.text.DecimalFormat;

public class SimpleCalculator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleCalculator frame = new SimpleCalculator();
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
	public SimpleCalculator() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\fathi\\Downloads\\simple-calculator.png"));
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 317, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Number 1");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(36, 48, 68, 19);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(119, 29, 141, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Number 2");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(36, 108, 68, 13);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(119, 96, 141, 39);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Result");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setToolTipText("");
		lblNewLabel_2.setBounds(36, 166, 59, 13);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(119, 155, 141, 39);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("SUB");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				performOperation('-');
			}
		});
		btnNewButton_1.setBounds(167, 242, 93, 39);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("MUL");
		btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performOperation('*');
            }
        });
		btnNewButton_2.setBounds(51, 312, 93, 39);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("ADD");
		btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performOperation('+');
            }
        });
//		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setBounds(51, 242, 93, 39);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("DIV");
		btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performOperation('/');
            }
        });
		btnNewButton_4.setBounds(167, 312, 93, 39);
		contentPane.add(btnNewButton_4);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, lblNewLabel, textField, lblNewLabel_1, textField_1, lblNewLabel_2, textField_2, btnNewButton_1, btnNewButton_2, btnNewButton_3, btnNewButton_4}));
	}
	
	private void performOperation(char operator) {
	    try {
	        double num1 = Double.parseDouble(textField.getText());
	        double num2 = Double.parseDouble(textField_1.getText());
	        double res;
	        String result = "";
	        DecimalFormat df = new DecimalFormat("#.#####");

	        switch (operator) {
	            case '+':
	                res = num1 + num2;
	                result = "Add = " + df.format(res);
	                break;
	            case '-':
	                res = num1 - num2;
	                result = "Sub = " + df.format(res);
	                break;
	            case '*':
	                res = num1 * num2;
	                result = "Product = " + df.format(res);
	                break;
	            case '/':
	                if (num2 != 0) {
	                    res = num1 / num2;
	                    result = "Quotient = " + df.format(res);
	                } else {
	                    textField_2.setText("Error: Div by 0");
	                    return;
	                }
	                break;
	            default:
	                break;
	        }
	        textField_2.setText(result); // Set the formatted result
	    } catch (NumberFormatException e) {
	        textField_2.setText("Invalid Input");
	    }
	}
}
