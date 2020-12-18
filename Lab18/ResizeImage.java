import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ResizeImage {
    public static void main(String[] args) {
        String srcFolder = "images";
        String dstFolder = "dst";

        File srcDir = new File(srcFolder);

        File[] files = srcDir.listFiles();

        int availableProcessors = files.length / Runtime.getRuntime().availableProcessors();

        File[] partOfFiles = new File[availableProcessors];

        long start;
        // FirstRealisation
        try {
            System.out.println("First Realisation");

            long testStart = System.currentTimeMillis();

            if (!Files.exists(Paths.get(dstFolder))) {
                Files.createDirectories(Paths.get(dstFolder));
            }

            for (int i = 0; i < files.length; i++) {
                start = System.currentTimeMillis();
                Runnable resize = new AsyncImageResizeFisrt(files[i], dstFolder, start);
                resize.run();
            }

            System.out.println("\n" + "Full working time: " + (System.currentTimeMillis() - testStart));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // SecondRealisation

        try {
            System.out.println("\n" + "Second Realisation");

            long testStart = System.currentTimeMillis();

            if (!Files.exists(Paths.get(dstFolder))) {
                Files.createDirectories(Paths.get(dstFolder));
            }

            if (files.length > Runtime.getRuntime().availableProcessors())
                for (int i = 0; i < files.length; i += availableProcessors) {
                    start = System.currentTimeMillis();
                    System.arraycopy(files, i, partOfFiles, 0, availableProcessors);
                    Runnable resize = new AsyncImageResizeSecond(partOfFiles, dstFolder, start);
                    resize.run();
                }
            else {
                start = System.currentTimeMillis();
                partOfFiles = new File[files.length];
                System.arraycopy(files, 0, partOfFiles, 0, files.length);
                Runnable resize = new AsyncImageResizeSecond(partOfFiles, dstFolder, start);
                resize.run();
            }

            System.out.println("\n" + "Full working time: " + (System.currentTimeMillis() - testStart));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
