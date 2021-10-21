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
import javax.swing.JTextField;

import br.senai.sp.jandira.conta.Multiplicar;

public class Frame {

	public void criarTela() {

		JFrame frame = new JFrame();
		frame.setSize(500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tabuada");
		frame.setLayout(null);

		JLabel lblTitulo = new JLabel();
		lblTitulo.setText("Tabuada");
		lblTitulo.setBounds(25, 20, 200, 35);
		lblTitulo.setFont(new Font("Serif", Font.BOLD, 25));
		lblTitulo.setForeground(Color.blue);

		JLabel lblMultiplicando = new JLabel();
		lblMultiplicando.setText("Multiplicando:");
		lblMultiplicando.setBounds(75, 65, 80, 20);

		JLabel lblMultiplicador = new JLabel();
		lblMultiplicador.setText("Multiplicador máximo:");
		lblMultiplicador.setBounds(25, 95, 130, 20);

		JLabel lblResultado = new JLabel();
		lblResultado.setText("RESULTADO:");
		lblResultado.setBounds(250, 65, 200, 20);

		JTextField txtMultiplicando = new JTextField();
		txtMultiplicando.setBounds(160, 65, 50, 20);

		JTextField txtMultiplicador = new JTextField();
		txtMultiplicador.setBounds(160, 95, 50, 20);

		JButton btnCalcular = new JButton();
		btnCalcular.setBounds(25, 140, 210, 50);
		btnCalcular.setText("Calcular");
		btnCalcular.setBackground(Color.green);

		JButton btnApagar = new JButton();
		btnApagar.setBounds(25, 200, 210, 50);
		btnApagar.setText("Limpar");
		btnApagar.setBackground(Color.red);

		DefaultListModel<String> modelListContas = new DefaultListModel<>();
		JList<String> listContas = new JList<>(modelListContas);
		listContas.setBounds(250, 90, 200, 250);

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

		frame.getContentPane().add(listContas);
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
