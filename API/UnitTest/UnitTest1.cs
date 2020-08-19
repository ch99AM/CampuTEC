using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MySql.Data.MySqlClient;

using CampusTECAPI1.DBConnection;
using System.Data;

namespace UnitTest
{
    [TestClass]
    public class TestDBConection
    {
        [TestMethod]
        public void testDBCon()
        {
            MySqlConnection connection = singletonConnection.getConnection();

            connection.Open();
            Assert.AreEqual(connection.State, ConnectionState.Open);
            connection.Close();
        }
    }

    [TestClass]
    public class TestDBQueryLogin
    {
        [TestMethod]
        public void testDB()
        {
            DataTable result = DBQuerys.LoginCredentials("2017146794", "1234");
           
            DataTable tableTest = new DataTable("MyTable");
            DataColumn NColumn = new DataColumn("Nombre", typeof(String));
            DataColumn AColumn = new DataColumn("Apellido", typeof(String));
            DataColumn UColumn = new DataColumn("Usuario", typeof(String));
            DataColumn SColumn = new DataColumn("Sede", typeof(String));
            DataColumn CColumn = new DataColumn("Celular", typeof(String));
            DataColumn EColumn = new DataColumn("Email1", typeof(String));
            DataColumn FColumn = new DataColumn("Foto", typeof(String));

            tableTest.Columns.Add(NColumn);
            tableTest.Columns.Add(AColumn);
            tableTest.Columns.Add(UColumn);
            tableTest.Columns.Add(SColumn);
            tableTest.Columns.Add(CColumn);
            tableTest.Columns.Add(EColumn);
            tableTest.Columns.Add(FColumn);

            DataRow newRow = tableTest.NewRow();
            newRow["Nombre"] = "Christian";
            newRow["Apellido"] = "Alpizar";
            newRow["Usuario"] = "2017146794";
            newRow["Sede"] = "Central";
            newRow["Celular"] = "Null";
            newRow["Email1"] = "Null";
            newRow["Foto"] = "Null";

            tableTest.Rows.Add(newRow);

            Console.WriteLine(tableTest.Rows.Count);
            foreach (DataRow dataRow in tableTest.Rows)
            {
                foreach (var item in dataRow.ItemArray)
                {
                    Console.WriteLine(item);
                }
            }

            Console.WriteLine(result.Rows.Count);
            foreach (DataRow dataRow in result.Rows)
            {
                foreach (var item in dataRow.ItemArray)
                {
                    Console.WriteLine(item);
                }
            }

            Assert.AreEqual(tableTest, result);

        }
    }
}
