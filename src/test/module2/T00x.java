package test.module2;

import java.io.IOException;
import java.net.MalformedURLException;

import home.*;

public class T00x {
	
	public static void main(String args[])
	{
		
		try {
			System.out.println(
					Main.compareWebImageToLocalFile(
							"C:\\Users\\marqu\\workspace\\POCSeleniumFramework\\library\\files\\logo-startrek_674x148.png", 
							"http://www.startrek.com/images/logo-startrek_674x148.png")
					);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
