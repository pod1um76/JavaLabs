import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class TreeCopyFileVisitor extends SimpleFileVisitor<Path> {

    private Path source;
    private final Path target;

    public TreeCopyFileVisitor(String source, String target) {
        this.source = Paths.get(source);
        this.target = Paths.get(target);
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

        Path resolve = target.resolve(source.relativize(dir));
        if (Files.notExists(resolve)) {
            Files.createDirectories(resolve);
            System.out.println("Create directories : " + resolve);
        }
        return FileVisitResult.CONTINUE;

    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        Path resolve = target.resolve(source.relativize(file));
        Files.copy(file, resolve, StandardCopyOption.REPLACE_EXISTING);
        System.out.println(String.format("Copy File from \t'%s' to \t'%s'", file, resolve));

        return FileVisitResult.CONTINUE;

    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        System.err.format("Unable to copy: %s: %s%n", file, exc);
        return FileVisitResult.CONTINUE;
    }

}

public class CopyFolder {

    static void createFileAndFolder() throws IOException {
        try {
            // C:\\Users\\Антон\\Documents\\GitHub\\JavaLabsNew\\Lab15\\forTextFile
            File folder = new File("C:\\Users\\Антон\\Documents\\GitHub\\JavaLabsNew\\Lab15\\forTextFile");
            boolean bool = folder.mkdir();
            FileWriter textFile = new FileWriter("C:\\Users\\Антон\\Documents\\GitHub\\JavaLabsNew\\Lab15\\forTextFile\\log.txt");

            if (bool) {
                System.out.println("Successfully create!");
            } else
                System.out.print("");

            textFile.write("Successfully copy!");
            textFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void copyFolder(String addressOne, String addressTwo ) throws IOException {
        TreeCopyFileVisitor fileVisitor = new TreeCopyFileVisitor(addressOne, addressTwo);
        Files.walkFileTree(Paths.get(addressOne), fileVisitor);
        createFileAndFolder();
    }

    void copy(Path source, Path dest) {
        try {
            Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}

class MainTest {
    public static void main(String[] args) throws IOException {
        CopyFolder object = new CopyFolder();
        Scanner in = new Scanner(System.in);
        
        String addressFolderOne = in.next();
        String addressFolderTwo = in.next();
        
        try {
            object.copyFolder(addressFolderOne, addressFolderTwo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        in.close();
    }
}
