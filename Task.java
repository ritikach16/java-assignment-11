import java.io.*;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) throws FileNotFoundException {
        Map<Character, Integer> map = new HashMap<>();
        Scanner file = new Scanner(new File("input.txt"));
       fileData(file, map);
    }

    public static void fileData(Scanner file, Map<Character, Integer> map) throws FileNotFoundException{
        try{
            while(file.hasNext()){
                String str = file.nextLine();
                for(int i = 0; i<str.length(); i++){
                    map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
                }
            }

            int count = 0;
            for(Character ch : map.keySet()){
                count++;
            }
            System.out.println(count);
            FileWriter outFile = new FileWriter ("output.txt");
            outFile.write(count+"");
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