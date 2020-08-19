using MySql.Data.MySqlClient;

namespace CampusTECAPI1.DBConnection
{
    public class singletonConnection
    {
        public static string CONNECTIONSTRING = "server = localhost; database=DBCampusTEC; Uid=root; pwd=12345678";

       

        private static MySqlConnection conn = null;

        public static MySqlConnection getConnection()
        {
            if(true)
            {
                conn = new MySqlConnection(CONNECTIONSTRING);
                
            }
            return conn;
        }
    }
} 