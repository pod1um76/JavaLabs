import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class htmlWork {
     public static void main(String[] args) throws Exception
    {
        try {
            ArrayList<String> addresses = new ArrayList<String>();
            Document doc = Jsoup.connect("https://www.mirea.ru/").userAgent("Chrome/4.0.249.0 Safari/532.5").referrer("http://www.google.com").get();
            Elements img = doc.select("img");
            for (Element el : img) {
                addresses.add(el.absUrl("src"));
                String src = el.attr("abs:src");
                if (src.equals(""))
                    src = el.attr("abs:data-src");
                downloadImg(src);
            }

            for(int i = 0; i < addresses.size(); i++)
                downloadImg(addresses.get(i));

            System.out.println(img);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
    public static void downloadImg(String src) throws Exception
    {
        String strImageName = "";
        for (int i = src.length()-1; i>=0;i--)
            if (src.charAt(i)=='/')
            {
                for (int j = i+1; j<src.length();j++)
                {
                    if (src.charAt(j) == '?')
                        break;
                    strImageName += src.charAt(j);
                }
                break;
            }
        URL urlImage = new URL(src);
        InputStream in = urlImage.openStream();
        byte[] buffer = new byte[4096];
        int n = -1;
        File file = new File("images");
        if (!file.exists()) {
            file.mkdirs();
        }
        OutputStream os = new FileOutputStream( "images/" + strImageName );
        while ( (n = in.read(buffer)) != -1 ){
            os.write(buffer, 0, n);
        }
        os.close();
        System.out.println(strImageName + ";");
    }

}
