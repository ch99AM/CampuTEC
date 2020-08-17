package Estudiante;

import javax.swing.JPanel;
import javax.swing.JTextField;

import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;

import GUI.usuario;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import org.json.simple.parser.ParseException;
import com.google.gson.Gson;

public class Perfil extends JPanel {
	private JTextField textFieldTelefono;
	private JTextField textFieldCorreo;
	public static String numero, correo;

	public Perfil() throws FileNotFoundException, IOException, ParseException {
		
		Object obj = new JSONParser().parse(new FileReader("../LoginCredentials.json"));
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		usuario jsonUsuario = gson.fromJson(json, usuario.class);
		
		setLayout(null);
		JLabel lblNewLabel_1 = new JLabel("Nombre Completo:");
		lblNewLabel_1.setBounds(149, 61, 187, 26);
		add(lblNewLabel_1);
		
		JLabel nombreCompleto = new JLabel(jsonUsuario.getNombre());
		nombreCompleto.setBounds(340, 61, 92, 26);
		add(nombreCompleto);
		
		JLabel lblNewLabel_3 = new JLabel("N\u00FAmero de Carn\u00E9:");
		lblNewLabel_3.setBounds(149, 108, 173, 26);
		add(lblNewLabel_3);
		
		JLabel numeroCarne = new JLabel(jsonUsuario.getUsuario());
		numeroCarne.setBounds(340, 108, 92, 26);
		add(numeroCarne);
		
		JLabel lblNewLabel_2 = new JLabel("Sede:");
		lblNewLabel_2.setBounds(149, 155, 92, 26);
		add(lblNewLabel_2);
		
		JLabel sede = new JLabel(jsonUsuario.getSede());
		sede.setBounds(340, 155, 92, 26);
		add(sede);
		
		JLabel lblNewLabel_4 = new JLabel("Tel\u00E9fono:");
		lblNewLabel_4.setBounds(149, 192, 92, 26);
		add(lblNewLabel_4);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setText(jsonUsuario.getTelefono());
		textFieldTelefono.setBounds(340, 189, 186, 32);
		add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Correo electr\u00F3nico:");
		lblNewLabel_5.setBounds(145, 239, 177, 26);
		add(lblNewLabel_5);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setText(jsonUsuario.getCorreo());
		textFieldCorreo.setBounds(340, 236, 238, 29);
		add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		JButton btnNewButton = new JButton("Guardar Cambios");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String numero = textFieldTelefono.getText();
				String correo = textFieldCorreo.getText();
				//setConfiguraciones (numero, correo);
			}
		});
		btnNewButton.setBounds(286, 286, 195, 35);
		add(btnNewButton);
		
	}
}
