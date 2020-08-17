package id.Campus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

public class Connection{
	
	private static FileWriter file1;
	
	public void toJSON() {
		
	}
	
	// Método encargado de realizar los get al API
	public void LoginCredentials(String r, String p) throws URISyntaxException {
		  try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			
			// Archivo JSON
			String ruta = "../LoginCredentials.json";
			File file = new File(ruta);
			
            if (!file.exists()) {
                file.createNewFile();
            }
			
			// Formato para el URL
			String formatedURL = new URI("http", "localhost:8080", "/api" + r, p, "").toURL().toString();
			HttpGet getRequest = new HttpGet(formatedURL);
			getRequest.addHeader("accept", "application/json");

			HttpResponse response = httpClient.execute(getRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "+ response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
    	    
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				output = output.replace("[", "").replace("]", "");
	            bw.write(output);
			}
			
			bw.close();
			httpClient.getConnectionManager().shutdown();
		}catch (ClientProtocolException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Método encargado de realizar los post al API
	public void post(String path, String in) {
		  try {

				DefaultHttpClient httpClient = new DefaultHttpClient();
				HttpPost postRequest = new HttpPost("https://prueba.free.beeceptor.com" + path);

				StringEntity input = new StringEntity(in);
				input.setContentType("application/json");
				postRequest.setEntity(input);

				HttpResponse response = httpClient.execute(postRequest);

				if (response.getStatusLine().getStatusCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

				String output;
				System.out.println("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output);
				}

				httpClient.getConnectionManager().shutdown();

			  } catch (MalformedURLException e) {

				e.printStackTrace();

			  } catch (IOException e) {

				e.printStackTrace();

			  }

			
	}
}


