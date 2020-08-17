using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

using System.Data.SqlClient;
using System.Text;

namespace CampusTECAPI1.DBConnection
{
    public class singletonConnection
    {
        public static string CONNECTIONSTRING = @"Data Source=CHRISTIAN\SQLEXPRESS;Initial Catalog=DBCampusTEC;Integrated Security=True";
        
        private static SqlConnection conn = null;

        public static SqlConnection getConnection()
        {
            if(true)
            {
                conn  = new SqlConnection(CONNECTIONSTRING);
            }
            return conn;
        }
    }
}