using System;
using System.Data;
using System.Linq;
using System.Net;
using System.Web.Http;
using System.Web.Http.Description;
using CampusTECAPI1.DBConnection;


namespace CampusTECAPI1.Controllers
{
    public class LoginController : ApiController
    {
        // GET: api/Login
        public string GetPerfils()
        {
            return "Hola mundo";
        }

        // GET: api/Login/5
        [ResponseType(typeof(DataTable))]
        public IHttpActionResult GetLogin(String usuario, String pin)
        {
            DataTable datatable = DBQuerys.LoginCredentials(usuario, pin);
            return Ok(datatable);
        }
    }
}