import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BannedWordsReader extends Reader {
	HashSet<String> ban;
	FileReader input;

	public BannedWordsReader(FileReader file,HashSet<String> banned){
		ban = banned;
		input = file;
	} 
	public BannedWordsReader(FileReader file){
		input = file;
	} 
	
	public static void main(String[] args) throws Exception{
		FileReader fr = new FileReader(args[0]);
		BannedWordsReader bwr;
		if(args.length == 2){
			HashSet<String> hs = new HashSet<String>();
			BufferedReader in
				= new BufferedReader(new FileReader(args[1]));
			String r;
			while((r = in.readLine()) != null){
				hs.add(r);
			}
			in.close();
			bwr = new BannedWordsReader(fr,hs);
		} else {
			bwr = new BannedWordsReader(fr);
		}
		System.out.println(bwr.readline());
		
        bwr.close();
	}
	private String readline() throws Exception{
		BufferedReader in = new BufferedReader(input);
		Iterator itr = ban.iterator();
		String banrx = "/";
	    while(itr.hasNext()){
	      banrx = banrx +itr.next()+"|";
	  	}
	    banrx = banrx.substring(0, banrx.length()-1) + "/gi";
		String r;
		String out = "";
		Pattern p = Pattern.compile("/\\W+/");
		while((r = in.readLine()) != null){
			if(ban != null){
				String[] words = r.split("/\\W+/");
				for (int i=0;i<words.length;i++){
					
				}
				
				Matcher m = p.matcher(r); // get a matcher object
				StringBuffer sb = new StringBuffer();
				while (m.find()) {
					m.appendReplacement(sb, "*");
				}
				m.appendTail(sb);
		    	out += sb.toString();
			} else {
				out += r;
			}
		}
		in.close();
		return out;
	}
	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		//Really not sure about this method
		return 0;
	}
	@Override
	public void close() throws IOException {
		input.close();
	}

}