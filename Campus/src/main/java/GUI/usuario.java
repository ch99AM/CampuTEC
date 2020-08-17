package GUI;

public class usuario {
	public String Nombre,Usuario,Sede,Telefono,Correo,Foto;
	
	public usuario(String Nombre, String Usuario, String Sede, String Telefono, String Correo,String Foto) {
		this.Nombre = Nombre;
		this.Usuario = Usuario;
		this.Sede = Sede;
		this.Telefono = Telefono;
		this.Correo = Correo;
		this.Foto = Foto;
		// TODO Auto-generated constructor stub
	}
	public String getNombre() {
		return this.Nombre;
	}
	public String getUsuario() {
		return this.Usuario;
	}
	public String getSede() {
		return this.Sede;
	}
	public String getTelefono() {
		return this.Telefono;
	}
	public String getCorreo() {
		return this.Correo;
	}
	public String getFoto() {
		return this.Foto;
	}

}
