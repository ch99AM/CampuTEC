using System;
using MySql.Data.MySqlClient;
using System.Data;
using System.Text;
using System.Web.Mvc;

namespace CampusTECAPI1.DBConnection
{
    [ValidateInput(false)]
    public class DBQuerys
    {
        public static DataTable LoginCredentials(String inUser, String password)
        {
            //Pido conexion
            MySqlConnection connection = singletonConnection.getConnection();

            //Variable que guarda la tabla resultante del sp
            DataTable datatable = new DataTable { TableName = "MyTableName" };
            using (connection)
            {
                StringBuilder sb = new StringBuilder("SELECT P.Nombre, P.Apellido, P.Usuario, E.Sede, E.Celular, E.Email1, E.Foto " +
                    "FROM Perfil P " +
                    "INNER JOIN Estudiante E ON E.IdPerfil = P.IdPerfil " +
                    "WHERE P.Usuario = \"" +
                    inUser.Substring(1, inUser.Length-2) + "\" " +
                    "AND Pin = \"" + password.Substring(1, password.Length - 2) + "\";");

                String sqlQuery = sb.ToString();

                MySqlDataAdapter adapter = new MySqlDataAdapter(sqlQuery, connection);
                adapter.SelectCommand.CommandType = CommandType.Text;

                connection.Open();
                adapter.Fill(datatable);
                connection.Close();
            }

            return datatable;
        }

    }
}