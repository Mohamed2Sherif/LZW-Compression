import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Compressor {
    public static List<Integer> compress (String input){
        Map<String,Integer> dictionary = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int dictindex=128;
        String current = "";

        for(int i =0; i <128; i++){
            dictionary.put(""+(char) i,i);
        }

        for (char c : input.toCharArray()){
            String combined = current+c;
            if (dictionary.containsKey(combined)){
                current = combined;
            }
            else {
                result.add(dictionary.get(current));
                dictionary.put(combined,dictindex++);
                current = ""+c;
            }
        }

        if (!current.equals("")){
            result.add(dictionary.get(current));
        }

    return result;
    }

    public static String decompress(List<Integer> compressedinput){
        Map<Integer,String> dictionary = new HashMap<>();
        int dictindex = 128;
        String previous = "" + (char)(int) compressedinput.remove(0);
        StringBuilder result = new StringBuilder(previous);

        for(int i =0;i<128;i++){
            dictionary.put(i,""+(char) i);
        }

        for (int tag : compressedinput){
            String current;
            if(dictionary.containsKey(tag)){
                current = dictionary.get(tag);
            }
            else if (tag == dictindex){current = previous+previous.charAt(0);}
            else {
                current="";
            }
            result.append(current);
            dictionary.put(dictindex++, previous + current.charAt(0));
            previous = current;
        }
        return result.toString();
    }
}
