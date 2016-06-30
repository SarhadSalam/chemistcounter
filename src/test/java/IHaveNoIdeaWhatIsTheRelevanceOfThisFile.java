import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by sarhaD on 29-Jun-16.
 */
public class IHaveNoIdeaWhatIsTheRelevanceOfThisFile
{
	public static void main(String[] args) throws IOException
	{
		Files.walk(Paths.get("C:\\Users\\sarha\\Music")).forEach(filePath -> {
			if( Files.isRegularFile(filePath) )
			{
				String path = String.valueOf(filePath);
				path = path.substring(21);
				if( path.endsWith(".mp3") )
				{
					path = path.replaceAll("\\.mp3", "");
					System.out.println(path);
				}
			}
		});
	}
}
