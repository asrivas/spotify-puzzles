
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/*This solution makes too many data structures, should implement a max heap*/


public class ZipfSong {
	
	static int numSongs;
	static int numResults;
	
	public static void main(String [] args) throws IOException{
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(input);
		String [] split_args = in.readLine().split(" ");
		numSongs = Integer.parseInt(split_args[0]);
		numResults = Integer.parseInt(split_args[1]);
		String [] songList = new String [numSongs];
		
		HashMap<String, Integer> songPlaysMap = new HashMap<String, Integer>();
		for(int i = 0; i < numSongs; i++){
			split_args = in.readLine().split(" ");
			songList[i] = split_args[1];
			songPlaysMap.put(split_args[1], Integer.parseInt(split_args[0]));
		}
		zipfCalculation(songList, songPlaysMap);
	}
	
	public static void zipfCalculation(String [] songList, HashMap<String, Integer> songPlaysMap){
		HashMap<String, Integer> qualityMap = new HashMap<String, Integer>();
		HashMap<Integer, String> qualityToSongMap = new HashMap<Integer, String>();
		int [] qualityList = new int[numSongs];
		
		int q;
		String title;
		for(int i = 0; i < numSongs; i++){
			title = songList[i];
			q = songPlaysMap.get(title)*(i+1);
			qualityMap.put(title, q);
			qualityToSongMap.put(q, title);
			qualityList[i] = q;
		}	
		Arrays.sort(qualityList);
		for(int i = 0; i < numResults; i++){
			System.out.println(qualityToSongMap.get(qualityList[numSongs - i - 1]));
		}		
		
	}

}
