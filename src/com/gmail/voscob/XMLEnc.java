package com.gmail.voscob;

import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;


public class XMLEnc
{
	public XMLEnc(List<Site> listSites, String fileName)
	{
		XMLEncoder e = null;
		try
		{
			e = new XMLEncoder(
				        new FileOutputStream("d:\\" + fileName + ".xml"));
		}
		catch (FileNotFoundException e2)
		{
			e2.printStackTrace();
		}
			e.writeObject(listSites);
			e.close();
	}
}
