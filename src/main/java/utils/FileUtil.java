package utils;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public List readArray(String fileName){

        try (FileReader reader = new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\" + fileName + ".txt")){

            StringBuilder arrayStr = new StringBuilder();
            ArrayList array = new ArrayList<>();

            int c;
            while((c=reader.read())!=-1){
                arrayStr.append((char)c);
            }

            for (String str : arrayStr.toString().split(" ")) {
                try {
                    array.add(Integer.valueOf(str));
                }catch (NumberFormatException e){
                    System.out.println("Incorrect string format: " + str);
                }
            }
            return array;
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public void writeArray(String arrayStr, String fileName){
        try (FileWriter writer = new FileWriter(System.getProperty("user.dir") + "\\src\\main\\resources\\" + fileName + ".txt", false)){
            writer.write(arrayStr);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
