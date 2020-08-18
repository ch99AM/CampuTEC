package Testing;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import GUI.Login;
import id.Campus.Connection;

public class UserValidationTest {
	
	
	@Test
	public void testValidation() throws FileNotFoundException, IOException, ParseException, URISyntaxException{
		
		Login log = new Login();
		Connection c = new Connection();
		Object obj = new JSONParser().parse(new FileReader("../LoginCredentials.json"));
		
		c.LoginCredentials("/Login", "usuario={2017146794}&pin={1234}");
		
		assertEquals(true, log.checkUsuario(obj));
		
	}
	
	   public static void main(String[] args) {
		      Result result = JUnitCore.runClasses(UserValidationTest.class);
				
		      for (Failure failure : result.getFailures()) {
		         System.out.println(failure.toString());
		      }
				
		      System.out.println(result.wasSuccessful());
		   }
}
