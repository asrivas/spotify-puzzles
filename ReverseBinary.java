import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//https://www.spotify.com/us/jobs/tech/reversed-binary/
public class ReverseBinary {

	public static void main (String [] args){
		//referenced: http://www.abbeyworkshop.com/howto/java/readLine/
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(input);
		try {
			int num = Integer.parseInt(in.readLine());
			System.out.println(reverseBinary(num));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int reverseBinary(int num){
		int result =  0;		
		while(num > 0){
			result <<= 1;
			result += (num & 1);
			num >>= 1; 
		}
		return result;
	}
	
}
