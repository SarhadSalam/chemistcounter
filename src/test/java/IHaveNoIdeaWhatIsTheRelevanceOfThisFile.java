import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Time;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by sarhaD on 29-Jun-16.
 */
public class IHaveNoIdeaWhatIsTheRelevanceOfThisFile
{
	public static void main(String[] args) throws IOException
	{
//		Files.walk(Paths.get("C:\\Users\\sarha\\Music")).forEach(filePath -> {
//			if( Files.isRegularFile(filePath) )
//			{
//				String path = String.valueOf(filePath);
//				path = path.substring(21);
//				if( path.endsWith(".mp3") )
//				{
//					path = path.replaceAll("\\.mp3", "");
//					System.out.println(path);
//				}
//			}
//		});
		Timer t = new Timer();
		TimerTask ts = new TimerTask()
		{
			@Override
			public void run()
			{
				methoder();
			}
		};
		ts.scheduledExecutionTime();
	}

	public static void methoder()
	{
		Scanner sc = new Scanner(System.in);
		String s = "Skip to News Feed\n"+
				"Facebook\n"+
				"\n"+
				"\n"+
				"Search Facebook\n"+
				"Sarhad\n"+
				"Home\n"+
				"Friend Requests\n"+
				"Messages\n"+
				"Notifications\n"+
				"Account Settings\n"+
				"\n"+
				"Sarhad Salam\n"+
				"Edit Profile\n"+
				"FAVORITES\n"+
				"News Feed\n"+
				"Messages\n"+
				"Events\n"+
				"Photos\n"+
				"20+\n"+
				"Mother of Banter\n"+
				"1\n"+
				"Saved\n"+
				"Sale Groups\n"+
				"PAGES\n"+
				"\n"+
				"Am I Famous Now?\n"+
				"20+\n"+
				"Pages Feed\n"+
				"4\n"+
				"Like Pages\n"+
				"Create Ad\n"+
				"Create Page\n"+
				"APPS\n"+
				"Live Video\n"+
				"12\n"+
				"Games\n"+
				"On This Day\n"+
				"Suggest Edits\n"+
				"1\n"+
				"Pokes\n"+
				"4\n"+
				"Games Feed\n"+
				"FRIENDS\n"+
				"1\n"+
				"Close Friends\n"+
				"Family\n"+
				"Abha Area\n"+
				"New York, New York Area\n"+
				"Miami, Florida Area\n"+
				"GROUPS\n"+
				"20+\n"+
				"Neymar Tips 'VIP'\n"+
				"20+\n"+
				"Go Join Bill Why Already\n"+
				"Discover Groups\n"+
				"Create Group\n"+
				"INTERESTS\n"+
				"Pages and Public Figures\n"+
				"DEVELOPER\n"+
				"Manage Apps\n"+
				"Insights\n"+
				"EVENTS\n"+
				"Create Event\n"+
				"YOUR PAGES\n"+
				"\n"+
				"Mother of Banter1 Comment\n"+
				"This Week\n"+
				"414\n"+
				"Post Reach\n"+
				"366\n"+
				"People Engaged\n"+
				"Recent Posts\n"+
				"\n"+
				"Happy Eid Mubarak everyone!\n"+
				"Boost Post\n"+
				"\n"+
				"Mother of Banter added a new photo.\n"+
				"See More\n"+
				"birthday\n"+
				"Kamrun Nahar Putul and 1 other\n"+
				"\n"+
				"\n"+
				"\n"+
				"\n"+
				"\n"+
				"TRENDING\n"+
				"\n"+
				"\n"+
				"Empire State Building: Video Reportedly Shows Lightning Striking Building During Thunderstorm in New York City\n"+
				"\n"+
				"\n"+
				"Hells Angels: Motorcycle Club's 'Canada Run' Meeting Ends, Police Say\n"+
				"\n"+
				"\n"+
				"Democratic National Committee: Group Apologizes to Bernie Sanders and His Supporters After Leaked Emails\n"+
				"See More\n"+
				"English (US) · Français (Canada) · Español · Português (Brasil) · Deutsch\n"+
				"Privacy · Terms · Advertising · Ad Choices · Cookies · \n"+
				"More\n"+
				"Facebook © 2016\n"+
				" \n"+
				"Photo/VideoChoose FilesPhoto AlbumChoose a file to uploadChoose Files\n"+
				"\n"+
				"\n"+
				"What's on your mind?\n"+
				"Friends\n"+
				"Post\n"+
				"News Feed\n"+
				"\n"+
				"Claire Persky\n"+
				"17 mins · \n"+
				"I just got hit on by a married polish man\n"+
				"Like\n"+
				"Like\n"+
				"Love\n"+
				"Haha\n"+
				"Wow\n"+
				"Sad\n"+
				"Angry\n"+
				"CommentShare\n"+
				"1414\n"+
				"Comments\n"+
				"4 of 12\n"+
				"View previous comments\n"+
				"Giovanni Giorgio\n"+
				"Giovanni Giorgio\n"+
				"Like · Reply · 8 mins\n"+
				"Myles Grant\n"+
				"Myles Grant Bruh\n"+
				"Like · Reply · 1 · 7 mins\n"+
				"Skyler Podhurst\n"+
				"Skyler Podhurst lmao dont messs with those guys\n"+
				"Like · Reply · 3 mins\n"+
				"Claire Persky\n"+
				"Claire Persky Lol why\n"+
				"Like · Reply · 2 mins\n"+
				"\n"+
				"Skyler Podhurst replied · 3 Replies · Just now\n"+
				"Sarhad Salam\n"+
				"\n"+
				"Write a comment...\n"+
				"\n"+
				"Choose File\n"+
				"\n"+
				"Sarah Silverman\n"+
				"6 mins · \n"+
				"\u202A#\u200Ebadass\u202C Elizabeth Warren\n"+
				"Sarah Silverman's photo.\n"+
				"\n"+
				"749 Comments215 Shares\n"+
				"6.3K6.3K\n"+
				"Top Comments\n"+
				"Like\n"+
				"Like\n"+
				"Love\n"+
				"Haha\n"+
				"Wow\n"+
				"Sad\n"+
				"Angry\n"+
				"CommentShare\n"+
				"Comments\n"+
				"Sarhad Salam\n"+
				"\n"+
				"Write a comment...\n"+
				"\n"+
				"Tracey Nolan\n"+
				"Tracey Nolan Two smart, BRAVE, truth-telling women. Thank you Sarah!\n"+
				"Like · Reply · 177 · 5 mins\n"+
				"12 Replies · Just now\n"+
				"Sid Billiams\n"+
				"Sid Billiams Yeah, Sarah, but unless your statement about Bernie was a joke, you sold out for this criminal whore we call HRC. Not happy with you right now.\n"+
				"Like · Reply · 205 · 4 mins\n"+
				"25 Replies · Just now\n"+
				"2 of 749\n"+
				"View more comments\n"+
				"\n"+
				"The Daily Beast\n"+
				"6 mins · \n"+
				"Sarah Silverman, comedian and self-proclaimed Bernie Sanders supporter, brought down the house at tonight's Democratic National Convention, when she called on Bernie supporters to support Hillary Clinton: http://thebea.st/2a7hKZB\n"+
				"The Daily Beast's photo.\n"+
				"\n"+
				"50 Comments162 Shares\n"+
				"798798\n"+
				"Like\n"+
				"Like\n"+
				"Love\n"+
				"Haha\n"+
				"Wow\n"+
				"Sad\n"+
				"Angry\n"+
				"CommentShare\n"+
				"\n"+
				"Lil Jon\n"+
				"2 hrs · \n"+
				"WOW\n"+
				"\n"+
				"Mom Pulls Up To The Drive-Thru Window. Her Face Grows Pale When She Sees HIM...\n"+
				"The determination and hard work of people can be truly inspiring, especially…\n"+
				"SHAREABLY.NET|BY PATRICIA LYNN\n"+
				"\n"+
				"3 Comments14 Shares\n"+
				"169169\n"+
				"Like\n"+
				"Like\n"+
				"Love\n"+
				"Haha\n"+
				"Wow\n"+
				"Sad\n"+
				"Angry\n"+
				"CommentShare\n"+
				"\n"+
				"Zooey Deschanel shared a link.\n"+
				"20 hrs · \n"+
				"\n"+
				"Why you needed to pay attention to what Jon Snow was wearing in the last episode of \"Game of Thrones\"\n"+
				"The biggest sartorial chatter thus far regarding post-stabbing Jon Snow has been the introduction of his man bun. And yes, it's a really good, really cute,\n"+
				"HELLOGIGGLES.COM\n"+
				"\n"+
				"43 Comments31 Shares\n"+
				"697697\n"+
				"Like\n"+
				"Like\n"+
				"Love\n"+
				"Haha\n"+
				"Wow\n"+
				"Sad\n"+
				"Angry\n"+
				"CommentShare\n"+
				"\n"+
				"Tag someone who added a new photo.\n"+
				"10 hrs · \n"+
				"Tag someone who's photo.\n"+
				"\n"+
				"5.4K Comments176 Shares\n"+
				"1.1K1.1K\n"+
				"Like\n"+
				"Like\n"+
				"Love\n"+
				"Haha\n"+
				"Wow\n"+
				"Sad\n"+
				"Angry\n"+
				"CommentShare\n"+
				"\n"+
				"Entertainment Weekly\n"+
				"11 hrs · \n"+
				"Conan wears Game of Thrones' Melisandre impressively well in this hilarious spoof. \uD83D\uDE02\n"+
				"\n"+
				"'Game of Thrones': Conan O'Brien spoofs Melisandre scene\n"+
				"Conan O’Brien revealed quite the secret on the final Comic-Con edition of his show Sunday night: He wears a ruby choker like Melisandre.\n"+
				"EW.COM\n"+
				"\n"+
				"27 Comments102 Shares\n"+
				"1.2K1.2K\n"+
				"Like\n"+
				"Like\n"+
				"Love\n"+
				"Haha\n"+
				"Wow\n"+
				"Sad\n"+
				"Angry\n"+
				"CommentShare\n"+
				"\n"+
				"UberFacts\n"+
				"4 hrs · \n"+
				"Ha! Horizontal refreshments...\n"+
				"UberFacts's photo.\n"+
				"\n"+
				"436 Comments3.2K Shares\n"+
				"13K13K\n"+
				"Like\n"+
				"Like\n"+
				"Love\n"+
				"Haha\n"+
				"Wow\n"+
				"Sad\n"+
				"Angry\n"+
				"CommentShare\n"+
				"\n"+
				"The Walking Dead\n"+
				"8 hrs · \n"+
				"The \u202A#\u200ETWD\u202C cast stopped by the TVLine studio during \u202A#\u200ESDCC\u202C. Watch the video to learn more about the Season 7 Premiere.\n"+
				"\n"+
				"The Walking Dead Team Talks Season 7 Premiere: 'It's Very, Very Gruesome'\n"+
				"Season 7 of The Walking Dead will have its lighter moments, promises showrunner Scott Gimple, but the resolution of the “Who did Negan kill?” cliffhanger won’t be…\n"+
				"TVLINE.COM|BY MICHAEL SLEZAK\n"+
				"\n"+
				"1.1K Comments2.9K Shares\n"+
				"37K37K\n"+
				"Like\n"+
				"Like\n"+
				"Love\n"+
				"Haha\n"+
				"Wow\n"+
				"Sad\n"+
				"Angry\n"+
				"CommentShare\n"+
				"\n"+
				"Snoop Dogg\n"+
				"4 hrs · \n"+
				"\uD83C\uDF4B\uD83D\uDC31\uD83D\uDE02\n"+
				"Snoop Dogg's photo.\n"+
				"\n"+
				"5.9K Comments11K Shares\n"+
				"50K50K\n"+
				"Like\n"+
				"Like\n"+
				"Love\n"+
				"Haha\n"+
				"Wow\n"+
				"Sad\n"+
				"Angry\n"+
				"CommentShare\n"+
				"More Stories\n"+
				"\n"+
				"Chat\n"+
				"\n"+
				"3h\n"+
				"Ehab Najeeb\n"+
				"\n"+
				"Ryan Yan\n"+
				"\n"+
				"7h\n"+
				"Adeeb Najeeb\n"+
				"\n"+
				"Jon Çejku\n"+
				"\n"+
				"Evan Sarginson\n"+
				"MORE FRIENDS (12)\n"+
				"\n"+
				"Abdul Hamid\n"+
				"\n"+
				"Claire Persky\n"+
				"\n"+
				"Hamoudi Ali\n"+
				"\n"+
				"Hank Shackleton\n"+
				"\n"+
				"Jesse Darby-Tillis II\n"+
				"\n"+
				"Raihan Uddin\n"+
				"\n"+
				"Rachael Fayard\n"+
				"\n"+
				"Kimberly Fagan\n"+
				"\n"+
				"Joseph Bailey\n"+
				"\n"+
				"Jenna Funderburk\n"+
				"\n"+
				"Kacie Spencer\n"+
				"\n"+
				"Shabree Lovewell\n"+
				"\n"+
				"Search\n";
		int time;
		for(int i = 0; i < s.length(); i++)
		{
			System.out.println(s.charAt(i));
		}
	}

}
