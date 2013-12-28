import java.net.*;
import java.io.*;
import java.util.*;
class  rss
{
	public static void main(String[] args)throws IOException 
	{
		ArrayList<String> nf=new ArrayList<String>();
	//	nf.add(readrss("http://rss.cnn.com/rss/edition.rss"));
        nf.add(readrss("http://feeds.nbcnews.com/feeds/topstories"));
		//nf.add(readrss("https://www.facebook.com/"));
	//	nf.add(readrss("http://feeds.abcnews.com/abcnews/topstories"));
		System.out.println(nf);
	}

	public static String readrss(String urladdress)throws IOException
	{
		URL rssurl=new URL(urladdress);
		BufferedReader in=new BufferedReader(new InputStreamReader(rssurl.openStream()));
		String sourcecode="";
		String line;
		int n=0;
		while(((line=in.readLine())!=null )&& (n!=3))
		{
			if(line.contains("<description>"))
			{
				int firstpos=line.indexOf("<description>");
				int lastpos=line.indexOf("</description>");
				String temp=line.substring(firstpos,lastpos);
				temp=temp.replace("<description>","");
				sourcecode += temp+"\n";
			n++;
			}
		}
		in.close();
		return sourcecode;
	}

}
