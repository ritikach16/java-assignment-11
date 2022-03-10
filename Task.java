import java.io.*;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) throws FileNotFoundException {
        Map<Character, Integer> map = new HashMap<>();
        String root = System.getProperty("user.home");
        File f1 = new File(root+ "/" + args[0]);
        FileReader file = new FileReader(f1);
       fileData(file, map);
    }

    public static void fileData(FileReader file, Map<Character, Integer> map) throws FileNotFoundException{
        try{
            int r = 0;
            while((r = file.read())!=0){
                char ch = (char)r;
                    map.put(ch, map.getOrDefault(ch, 0)+1);

            }

            FileWriter outFile = new FileWriter ("output.txt");
            for(Map.Entry m : map.entrySet()){
                outFile.write(m.getKey()+" = "+m.getValue() + "\n");
            }
            file.close();
            outFile.close();
        }
        catch(InputMismatchException ex){
            System.out.println("type mismatch!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}