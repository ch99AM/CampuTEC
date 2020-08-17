package GUI;
import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.google.gson.Gson;
import java.awt.SystemColor;
import Estudiante. *;
import Administrador. *;
import Profesor. *;
import id.Campus.Connection;

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
		
		final JTextField inputUsuario = new JTextField();
		inputUsuario.setBounds(270, 125, 186, 32);
		contentPane.add(inputUsuario);
		inputUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(172, 128, 77, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CampusTEC");
		lblNewLabel_1.setBounds(243, 21, 123, 26);
		contentPane.add(lblNewLabel_1);
		
		final JPasswordField passwordUsuario = new JPasswordField();
		passwordUsuario.setBounds(270, 187, 186, 32);
		contentPane.add(passwordUsuario);
		
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_2.setBounds(137, 190, 112, 26);
		contentPane.add(lblNewLabel_2);
		
		final Choice choice = new Choice();
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
					
					checkCredentialsStudent(usuario, contrasena);
					obj = new JSONParser().parse(new FileReader("../LoginCredentials.json"));
					
					checker = checkUsuario(obj);
				} catch (IOException | ParseException | URISyntaxException e) {
					e.printStackTrace();
				}
				
				System.out.println(checker);
				if (checker) {
					if( perfil.equals("Administrador")) {
						vistaAdministrador admin = new vistaAdministrador();
						admin.setVisible(true);
					}else if (perfil.equals("Estudiante")) {
						vistaEstudiante estudiante;
						try {
							estudiante = new vistaEstudiante();
							estudiante.SetCaracteristicas(obj);
							estudiante.setVisible(true);
						} catch (IOException | ParseException e) {
							e.printStackTrace();
						}
						
					}else if (perfil.equals("Profesor")) {
						vistaProfesor profesor;
						try {
							profesor = new vistaProfesor();
							profesor.setVisible(true);
						} catch (IOException | ParseException e) {
							e.printStackTrace();
						}
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
		if (json.equals("[]")) {
			return false;
		}else {
			return true;
		}
		
	}
	
	public void checkCredentialsStudent(String usuario, String pin) throws URISyntaxException {
		Connection c = new Connection();
		c.LoginCredentials("/Login", "usuario={" + usuario +"}&pin={" + pin + "}");
	}
	

}
