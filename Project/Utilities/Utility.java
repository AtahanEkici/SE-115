package Utilities;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Atahan Ekici
 */
public class Utility 
{
    public static ArrayList<Double> readInfo()       
    {
        ArrayList<Double> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        try 
        {
            URL url = new URL("https://kur.doviz.com/serbest-piyasa");
            URLConnection con = url.openConnection();
            InputStream is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;String read = null;String dolar;String euro;String gold;boolean Needed;double dollar,yuro,altın;

while ((line = br.readLine()) != null) 
{
    if(line.contains("class=\"value\">")){
        Needed = true;
    }
    else
    {
        Needed = false;
    }
    if(Needed == true) 
    {
        read += line + "\n";
    }       
} 
read = read.replaceAll("null","");
read = read.replaceAll(" ","");
read = read.replaceAll("<spanclass=\"value\">", "");
read = read.replaceAll("</span>", "");
String lines[] = read.split("\\r?\\n");
Collections.addAll(list2, lines);

gold = list2.get(0);
gold = gold.replaceAll(",",".");
altın = Double.parseDouble(gold);

dolar = list2.get(1);
dolar = dolar.replaceAll(",",".");
dollar = Double.parseDouble(dolar);

euro = list2.get(2);
euro = euro.replaceAll(",",".");
yuro = Double.parseDouble(euro);

list.add(yuro);
list.add(dollar);
list.add(altın);

        } catch (Exception e) 
        {
            System.out.println(e);
        } 
        System.gc();
        return list;
    } 
}