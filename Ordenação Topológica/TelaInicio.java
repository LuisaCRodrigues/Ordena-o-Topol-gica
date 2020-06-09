import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class TelaInicio extends JFrame {

	private JPanel contentPane;
	private JTextField txtOrdenaoTopolgica;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicio frame = new TelaInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static FileReader reader = null;

	/**
	 * Create the frame.
	 */
	public TelaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Color bege = new Color(255, 255, 204);
		Color azulClaro = new Color(135, 206, 250);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(bege);

		JLabel titulo = new JLabel("Ordenacao Topologica");
		titulo.setBounds(110, 60, 300, 30);
		contentPane.add(titulo);
		titulo.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));

		JLabel lblEscolhaSeuArquivo_1 = new JLabel("Escolha seu arquivo com ordenacao parcial de um conjunto");
		lblEscolhaSeuArquivo_1.setBounds(70, 130, 400, 14);
		contentPane.add(lblEscolhaSeuArquivo_1);

		JLabel lblParaGerarUma = new JLabel("para gerar uma ordenacao topologica, se possivel");
		lblParaGerarUma.setBounds(90, 150, 400, 14);
		contentPane.add(lblParaGerarUma);

		JButton btnLerArquivo = new JButton("Ler Arquivo");
		btnLerArquivo.setBounds(180, 200, 100, 23);
		btnLerArquivo.setBackground(azulClaro);
		Main main = new Main();
		JFileChooser fileChooser = new JFileChooser();

		btnLerArquivo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int retorno = fileChooser.showOpenDialog(null);

				try {

					if (retorno == JFileChooser.APPROVE_OPTION) {
						reader = new FileReader(fileChooser.getSelectedFile());

						Executa executa = new Executa();
						executa.setVisible(true);
						dispose();
					}

				} catch (FileNotFoundException e1) {

					e1.printStackTrace();
				}

			};

		});
		contentPane.add(btnLerArquivo);

	}
}
