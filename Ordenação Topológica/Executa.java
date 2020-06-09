import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Executa extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public Executa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Color bege = new Color(255, 255, 204);
		Color azulClaro = new Color(135, 206, 250);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(bege);

		JLabel lblEscolhaSeuArquivo_1 = new JLabel("Clique no botão abaixo para realizar a leitura do arquivo");
		lblEscolhaSeuArquivo_1.setBounds(80, 130, 400, 14);
		contentPane.add(lblEscolhaSeuArquivo_1);

		JLabel lblParaGerarUma = new JLabel("e verificar se e um conjunto parcialmente ordenado.");
		lblParaGerarUma.setBounds(90, 150, 400, 14);
		contentPane.add(lblParaGerarUma);

		JButton btnExecuta = new JButton("Executa");
		btnExecuta.setBounds(180, 200, 100, 23);
		btnExecuta.setBackground(azulClaro);

		btnExecuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrdenacaoTopologica ord = new OrdenacaoTopologica();
				String nomeEntrada = "entrada.txt";
				Console console = new Console();
				console.init();
				dispose();

				try {
					ord.realizaLeitura(nomeEntrada);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				if (!ord.executa()) {
					System.out.println("O conjunto nao e parcialmente ordenado.");
				}

				else {
					System.out.println("O conjunto e parcialmente ordenado.");
				}
			}
		});

		contentPane.add(btnExecuta);
	}
}

class Console {
	final JFrame frame = new JFrame();

	public Console() {

		Color bege = new Color(255, 255, 204);
		Color azulClaro = new Color(135, 206, 250);

		JTextArea textArea = new JTextArea(24, 80);
		textArea.setBounds(100, 100, 500, 400);
		textArea.setBackground(bege);
		textArea.setForeground(Color.BLACK);
		textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		System.setOut(new PrintStream(new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				textArea.append(String.valueOf((char) b));
			}
		}));
		frame.add(textArea);
	}

	public void init() {
		frame.pack();
		frame.setVisible(true);
	}

	public JFrame getFrame() {
		return frame;
	}
}