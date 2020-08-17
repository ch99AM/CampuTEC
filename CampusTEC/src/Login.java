import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

import java.awt.SystemColor;

import Estudiante. *;
import Administrador. *;
import Profesor. *;

public class Login extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("CampusTEC");
		setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextField inputUsuario = new JTextField();
		inputUsuario.setBounds(270, 125, 186, 32);
		contentPane.add(inputUsuario);
		inputUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(172, 128, 77, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CampusTEC");
		lblNewLabel_1.setBounds(243, 21, 123, 26);
		contentPane.add(lblNewLabel_1);
		
		JPasswordField passwordUsuario = new JPasswordField();
		passwordUsuario.setBounds(270, 187, 186, 32);
		contentPane.add(passwordUsuario);
		
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_2.setBounds(137, 190, 112, 26);
		contentPane.add(lblNewLabel_2);
		
		Choice choice = new Choice();
		choice.setBounds(270, 241, 186, 32);
		choice.add("Administrador");
		choice.add("Profesor");
		choice.add("Estudiante");
		contentPane.add(choice);
		
		JButton buttonLogin = new JButton("Login");
		buttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String usuario = "";
				String contrasena = "";
				String perfil = "";
				usuario = inputUsuario.getText();
				contrasena = passwordUsuario.getText();
				perfil = choice.getSelectedItem().toString();
				
				Object obj = null;
				boolean checker = false;
				try {
					obj = new JSONParser().parse(new FileReader("C:\\Users\\Edgar\\Documents\\Year_2020\\Espe\\ProyectoJava\\CampusTEC\\src\\usuario.json"));
					checker = checkUsuario(obj);
				} catch (IOException | ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println(checker);
				if (checker) {
					System.out.println(usuario);
					System.out.println(contrasena);
					System.out.println(perfil);
					
					if( perfil.equals("Administrador")) {
						vistaAdministrador admin = new vistaAdministrador();
						admin.setVisible(true);
					}else if (perfil.equals("Estudiante")) {
						vistaEstudiante estudiante = new vistaEstudiante();
						estudiante.SetCaracteristicas(obj);
						estudiante.setVisible(true);
					}else if (perfil.equals("Profesor")) {
						vistaProfesor profesor = new vistaProfesor();
						profesor.setVisible(true);
					}
				}else {
					;
				}
				
				
			}
		});
		buttonLogin.setBounds(270, 293, 123, 32);
		contentPane.add(buttonLogin);
		
		JLabel lblNewLabel_3 = new JLabel("Perfil:");
		lblNewLabel_3.setBounds(194, 247, 55, 26);
		contentPane.add(lblNewLabel_3);
		
	}
	
	public boolean checkUsuario(Object obj) {
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		usuario jsonUsuario = gson.fromJson(json, usuario.class);
		if (jsonUsuario.getNombre().equals("") &&
			jsonUsuario.getUsuario().equals("")) {
			return false;
		}else {
			return true;
		}
		
	}

}
