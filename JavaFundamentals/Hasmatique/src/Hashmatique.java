
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Hashmatique {
    public static void main (String[] args){
        HashMap<String, String> trackList=new HashMap<>();

        trackList.put("Sound of Music", "The hills are alive with the sound of music with songs they have sung");
        trackList.put("Bad Romance", "Ra ra ra uh uh, Ra ma ra ma ma, Gaga Ooh la la, want your bad romance");
        trackList.put("PokerFace", "Po po po poker face po poker face");
        trackList.put("Jet Lag", "What time is it where you are, I miss you more than anything");

        String jetLagLyrics = trackList.get("Jet Lag");
        System.out.println(jetLagLyrics);

        for(String song : trackList.keySet()) {
            System.out.println(song + " : " + trackList.get(song));
        }
    }
}
