package Estudiante;

import java.util.List;

public class ListaSemanas {
	public List<semana> semanas;
	
	public List<semana> getSemana(){
		return this.semanas;
	}
	
	public class semana{
		public int Semana;
		public List<retos> Retos;
		public semana(int laSemana, List<retos> losRetos) {
			this.Semana = laSemana;
			this.Retos = losRetos;
			// TODO Auto-generated constructor stub
		}
		
		public int getSemana() {
			return this.Semana;
		}
		public void setSemana(int semana) {
			this.Semana = semana;
		}
		public List<retos> getRetos(){
			return this.Retos;
		}
		public class retos{
			public int idR; /**/
			public String nombre;
			public String fecha_vencimiento;
			public List<Objetivos> objetivos;
			public int tec_colones;
			public List<Actividades> actividades;
			
			public String getNombreReto () {
				return this.nombre;
			}
			public void setNombreReto(String nombre) {
				this.nombre = nombre;
			}
			public String getFechaVencimiento() {
				return this.fecha_vencimiento;
			}
			public void setFechaVencimiento(String fecha) {
				this.fecha_vencimiento = fecha;
			}
			public List<Objetivos> getObjetivos(){
				return this.objetivos;
			}
			public int getTecColones() {
				return this.tec_colones;
			}
			public List<Actividades> getActividades(){
				return this.actividades;
			}
			public int getIDReto() {
				return this.idR;
			}
			public class Objetivos {
				public int idO;
				public String descripcion;
				public int getIDObjetivo() {
					return this.idO;
				}
				public String getDescripcionObjetivo() {
					return this.descripcion;
				}
			}
			public class Actividades{
				public String descripcionA;
				public List<tareas> Tareas;
				
				public String getDescripcionActividades() {
					return this.descripcionA;
				}
				public List<tareas> getTareasPorActividad(){
					return this.Tareas;
				}
				public class tareas{
					public String descripcionT;
					public String hora;
					public String dia;
					public String getDescripcionT() {
						return this.descripcionT;
					}
					public String getHora() {
						return this.hora;
					}
					public String getDia() {
						return this.dia;
					}
				}
				
				
			}
		}
		
	}

}
