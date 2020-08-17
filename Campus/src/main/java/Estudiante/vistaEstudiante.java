package Estudiante;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

public class vistaEstudiante extends JFrame {
	private static String Nombre;
	private String Usuario;
	private String Sede;
	private String Telefono;
	private String Correo;
	private String Foto;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vistaEstudiante frame = new vistaEstudiante();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public vistaEstudiante() throws FileNotFoundException, IOException, ParseException {
		this.Nombre = Nombre;
		/*this.Usuario = jsonUsuario.getUsuario();
		this.Sede = jsonUsuario.getSede();
		this.Telefono = jsonUsuario.getTelefono();
		this.Correo = jsonUsuario.getTelefono();
		this.Foto = jsonUsuario.getFoto();*/
		setTitle("Estudiante");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 604, 359);
		contentPane.add(tabbedPane);
		
		Perfil perfil = new Perfil();
		OrganizacionSemanal orgSemanal = new OrganizacionSemanal();
		tabbedPane.add("Perfil",perfil);
		tabbedPane.add("Organizaci�n Semanal",orgSemanal);
		
	}
	
	public void SetCaracteristicas(Object objetoUsuario) {
		Gson gson = new Gson();
		String json = gson.toJson(objetoUsuario);
		usuario jsonUsuario = gson.fromJson(json, usuario.class);
		Nombre = jsonUsuario.getNombre();
		this.Usuario = jsonUsuario.getUsuario();
		this.Sede = jsonUsuario.getSede();
		this.Telefono = jsonUsuario.getTelefono();
		this.Correo = jsonUsuario.getTelefono();
		this.Foto = jsonUsuario.getFoto();
		
		
	}

}
