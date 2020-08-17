package Profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Perfil extends JPanel {
	public static String numero, correo;
	/**
	 * Create the panel.
	 */
	public Perfil() {
setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre Completo:");
		lblNewLabel_1.setBounds(62, 21, 187, 26);
		add(lblNewLabel_1);
		
		JLabel nombreCompleto = new JLabel("------");
		nombreCompleto.setBounds(253, 21, 92, 26);
		add(nombreCompleto);
		
		JLabel lblNewLabel_3 = new JLabel("N\u00FAmero de Carn\u00E9:");
		lblNewLabel_3.setBounds(62, 68, 173, 26);
		add(lblNewLabel_3);
		
		JLabel numeroCarne = new JLabel("--------");
		numeroCarne.setBounds(253, 68, 92, 26);
		add(numeroCarne);
		
		JLabel lblNewLabel_2 = new JLabel("Sede:");
		lblNewLabel_2.setBounds(62, 115, 92, 26);
		add(lblNewLabel_2);
		
		JLabel sede = new JLabel("------");
		sede.setBounds(253, 115, 92, 26);
		add(sede);
		
		JLabel lblNewLabel_4 = new JLabel("Tel\u00E9fono:");
		lblNewLabel_4.setBounds(62, 152, 92, 26);
		add(lblNewLabel_4);
		
		JTextField textFieldTelefono = new JTextField();
		String numero = "2222-2222";
		textFieldTelefono.setText(numero);
		textFieldTelefono.setBounds(253, 149, 186, 32);
		add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Correo electr\u00F3nico:");
		lblNewLabel_5.setBounds(58, 199, 177, 26);
		add(lblNewLabel_5);
		
		JTextField textFieldCorreo = new JTextField();
		String correo = "estudiante@estudiante.cr";
		textFieldCorreo.setText("profesor@profesor.cr");
		textFieldCorreo.setBounds(253, 196, 238, 29);
		add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		JButton btnNewButton = new JButton("Guardar Cambios");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String numero = textFieldTelefono.getText();
				String correo = textFieldCorreo.getText();
				setConfiguraciones (numero, correo);
			}
		});
		btnNewButton.setBounds(199, 246, 195, 35);
		add(btnNewButton);
		
		
	}
	public void setConfiguraciones (String numero1, String correo1 ) {
		this.numero = numero1;
		this.correo = correo1;
		
		System.out.println(this.numero);
		System.out.println(this.correo);
		
	}

	

}
