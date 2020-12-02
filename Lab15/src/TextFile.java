import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class TextFile {
    static void createFile(String information) throws IOException{
        try {
            File floder = new File("C:\\Users\\Антон\\Documents\\GitHub\\JavaLabsNew\\Lab15\\forTextFile");
            boolean bool = floder.mkdir();
            FileWriter textFile = new FileWriter("C:\\Users\\Антон\\Documents\\GitHub\\JavaLabsNew\\Lab15\\forTextFile\\log.txt");

            if (bool) {
                System.out.println("Successfully create!");
            }
            else
                System.out.print("");
            
            textFile.write(information);
            textFile.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    long getFolderSize(File folder) throws IOException{
        long length = 0;
        File[] files = folder.listFiles();

        int count = files.length;

        for (int i = 0; i < count; i++) {
            if (files[i].isFile())
                length += files[i].length();
            else
                length += getFolderSize(files[i]);
        }

        return length;
    }

    String whenGetReadableSize__thenCorrect(String address) throws IOException {
        File folder = new File(address);
        long size = getFolderSize(folder);

        String []units = new String[] { "B", "KB", "MB", "GB", "TB" };
        int unitIndex = (int) (Math.log10(size)/3);
        double unitValue = 1 << (unitIndex *  10);

        String readableSize = new DecimalFormat("#,##0.#").format(size/unitValue) + " " + units[unitIndex];
        createFile(readableSize);

        return readableSize;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        TextFile textFile = new TextFile();
        
        Scanner in = new Scanner(System.in);
        String address = in.next();
        
        System.out.println("Floder size " + address +" compose " + textFile.whenGetReadableSize__thenCorrect(address));
        in.close();   
    }
}
