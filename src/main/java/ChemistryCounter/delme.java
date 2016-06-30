package ChemistryCounter;/*
 * Copyright (c) 2016. Chemists Counter belongs to Sarhad Maisoon Salam. Any copyright infringement will be legally pursued..
 */

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by sarhaD on 29-Jun-16.
 */
public class delme
{
	public static void main(String[] args) throws Exception
	{
		PrintWriter out = new PrintWriter("W:\\Chemists Counter\\MusicName.txt");
		Files.walk(Paths.get("C:\\Users\\sarha\\Music")).forEach(filePath -> {
			if( Files.isRegularFile(filePath) )
			{
				String path = String.valueOf(filePath);
				path = path.substring(21);
				if( path.endsWith(".mp3") )
				{
					path = path.replaceAll("\\.mp3", "");
					out.println(path);
					System.out.println(path);
				}
			}
		});
	}
}
