using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

using System.Data.SqlClient;
using System.Data;
using System.Text;

namespace CampusTECAPI1.DBConnection
{
    public class DBQuerys
    {
        public static DataTable exeQuery(String inUser, String password)
        {
            //Pido conexion
            SqlConnection connection = singletonConnection.getConnection();

            //Variable que guarda la tabla resultante del sp
            DataTable datatable = new DataTable();
            using (connection)
            {

                StringBuilder sb = new StringBuilder("SELECT Nombre, Apellido, Usuario FROM Perfil p WHERE " +
                    "Usuario = 2017146794 AND Pin = 1234;");

                String sqlQuery = sb.ToString();

                SqlDataAdapter adapter = new SqlDataAdapter(sqlQuery, connection);
                adapter.SelectCommand.CommandType = CommandType.Text;

                connection.Open();
                adapter.Fill(datatable);
                connection.Close();
            }
            return datatable;
        }

    }
}