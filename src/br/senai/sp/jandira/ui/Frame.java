package br.senai.sp.jandira.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import br.senai.sp.jandira.conta.Multiplicar;

public class Frame {

	public void criarTela() {
		
		Color dourado = new Color(218, 165, 32);
		Color cinzaEscuro = new Color(10,10,10);
		Color cinzaMenosEscuro = new Color(30,30,30);

		JFrame frame = new JFrame();
		frame.setSize(500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tabuada");
		frame.setLayout(null);

		JLabel lblTitulo = new JLabel();
		lblTitulo.setText("Tabuada");
		lblTitulo.setBounds(25, 20, 200, 35);
		lblTitulo.setFont(new Font("Serif", 3, 25));
		lblTitulo.setForeground(dourado);

		JLabel lblMultiplicando = new JLabel();
		lblMultiplicando.setText("Multiplicando:");
		lblMultiplicando.setFont(new Font("Serif", Font.ITALIC, 13));
		lblMultiplicando.setForeground(dourado);
		lblMultiplicando.setBounds(70, 65, 90, 20);

		JLabel lblMultiplicador = new JLabel();
		lblMultiplicador.setText("Multiplicador máximo:");
		lblMultiplicador.setFont(new Font("Serif", Font.ITALIC, 13));
		lblMultiplicador.setForeground(dourado);
		lblMultiplicador.setBounds(25, 95, 130, 20);

		JLabel lblResultado = new JLabel();
		lblResultado.setText("RESULTADO:");
		lblResultado.setFont(new Font("Serif", 3, 20));
		lblResultado.setForeground(dourado);
		lblResultado.setBounds(250, 65, 200, 20);

		JTextField txtMultiplicando = new JTextField();
		txtMultiplicando.setFont(new Font("Serif", Font.PLAIN, 14));
		txtMultiplicando.setForeground(dourado);
		txtMultiplicando.setCaretColor(Color.white);
		txtMultiplicando.setBackground(cinzaMenosEscuro);
		txtMultiplicando.setBounds(160, 65, 50, 20);

		JTextField txtMultiplicador = new JTextField();
		txtMultiplicador.setFont(new Font("Serif", Font.PLAIN, 14));
		txtMultiplicador.setForeground(dourado);
		txtMultiplicador.setCaretColor(Color.white);
		txtMultiplicador.setBackground(cinzaMenosEscuro);
		txtMultiplicador.setBounds(160, 95, 50, 20);

		JButton btnCalcular = new JButton();
		btnCalcular.setBounds(25, 140, 210, 50);
		btnCalcular.setText("Calcular");
		btnCalcular.setBorderPainted(false);
		btnCalcular.setFocusPainted(false);
		btnCalcular.setForeground(cinzaEscuro);
		btnCalcular.setFont(new Font("Serif", 3, 35));
		btnCalcular.setBackground(Color.green);

		JButton btnApagar = new JButton();
		btnApagar.setBounds(25, 200, 210, 50);
		btnApagar.setText("Apagar");
		btnApagar.setBorderPainted(false);
		btnApagar.setFocusPainted(false);
		btnApagar.setForeground(cinzaEscuro);
		btnApagar.setFont(new Font("Serif", 3, 35));
		btnApagar.setBackground(Color.red);

		DefaultListModel<String> modelListContas = new DefaultListModel<>();
		JList<String> listContas = new JList<>(modelListContas);
		JScrollPane scrollPane = new JScrollPane(listContas);
		listContas.setBackground(cinzaMenosEscuro);
		listContas.setForeground(dourado);
		listContas.setBounds(250, 90, 200, 250);
		scrollPane.setBounds(250, 90, 200, 250);
		scrollPane.setForeground(cinzaMenosEscuro);
		

		btnCalcular.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				double multiplicando = Double.valueOf(txtMultiplicando.getText());
				double multiplicador = Double.valueOf(txtMultiplicador.getText());
				Multiplicar resultado = new Multiplicar();

				for (int contador = 1; contador <= multiplicador; contador++) {

					resultado.tabuada(multiplicando, contador);
					String conta = String.valueOf(resultado.getResultado());
					modelListContas.addElement(multiplicando + " x " + contador + " = " + conta);

				}

			}
		});
		
		btnApagar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				modelListContas.clear();
				listContas.setModel(modelListContas);
				txtMultiplicando.requestFocus();
				
			}
		});

		frame.getContentPane().setBackground(cinzaEscuro);
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(btnApagar);
		frame.getContentPane().add(btnCalcular);
		frame.getContentPane().add(txtMultiplicador);
		frame.getContentPane().add(txtMultiplicando);
		frame.getContentPane().add(lblResultado);
		frame.getContentPane().add(lblMultiplicador);
		frame.getContentPane().add(lblMultiplicando);
		frame.getContentPane().add(lblTitulo);
		frame.setVisible(true);

	}

}
