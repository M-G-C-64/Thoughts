package Encopack;

// https://textuploader.com/tdu5h/raw
import Revealpack.Reveal;
import Selectfilepackage.SelectFile;
import Textfieldpackage.TextField;
import newPasspack.newPass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;


public class Enco{
    public static void out(Object tt){ 
        
        // print function

        System.out.println(tt);
    }
    
    public static void show(Path datapath){

        // shows the list of thoughts

        out("here is your list of thoughts, make sure your'e private");
        
        try
        {
            FileReader fread = new FileReader(datapath.toString());
            BufferedReader bread = new BufferedReader(fread);

            String buff;
            out("");
            while ((buff = bread.readLine()) != null){
                out(decod(buff));
                out("");
            }
            bread.close();
            fread.close();

        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public static void showgui(Path datapath){
                // shows the list of thoughts

                out("here is your list of thoughts, make sure your'e private");
        
                try
                {
                    FileReader fread = new FileReader(datapath.toString());
                    BufferedReader bread = new BufferedReader(fread);
        
                    new Reveal(bread, datapath);

                    bread.close();
                    fread.close();
        
                }catch(IOException e){
                    e.printStackTrace();
                }
    }

    public static void writebro(Path datapath, String ss){

        // writes the given string into the file

        try{
            FileWriter fwrite = new FileWriter(datapath.toString(), true);
            fwrite.write(encod(ss)+"\n");
            fwrite.close();

        }catch(IOException e){
            e.printStackTrace();
        }

    }

    static String encod (String ss){
        ss = ss+"\n-------------------------------------------------\n";
        ArrayList<String> enclst = new ArrayList<String>();

        for (char c: ss.toCharArray()){
            int temp =  c;
            enclst.add(0, Integer.toOctalString(temp*temp)+" ");
        }
        return String.join(" ", enclst);
    }

    public static String encodpass (String ss){
        ArrayList<String> enclst = new ArrayList<String>();

        for (char c: ss.toCharArray()){
            int temp =  c;
            enclst.add(0, Integer.toOctalString(temp*temp)+" ");
        }
        return String.join(" ", enclst);
    }

    public static String decod (String ss){
        StringBuilder dec = new StringBuilder();
        String[] splited = ss.split("\\s+");
        for (int i = splited.length - 1; i >= 0; i--){
            int tmp = Integer.parseInt(splited[i], 8);
            double tt = Math.sqrt(tmp);
            tmp = (int) tt;
            dec.append((char) tmp);
        }
        return dec.toString();
    }

    public static Boolean PassCheck (String ss){
        //String corrPass = "5220  5544  10000  22604  21501  22301  21501";
        String fullpath = System.getProperty("user.dir") + "/" + "scrtgc.txt";
        Path datapath = Path.of(fullpath);
        try
        {
            FileReader fread = new FileReader(datapath.toString());
            BufferedReader bread = new BufferedReader(fread);

            String buff;
            buff = bread.readLine();

            bread.close();
            fread.close();
            out(decod(buff));
            if (ss.equals(decod(buff))){
                return true;
            }
            

        }catch(IOException e){
            e.printStackTrace();
        }
        return false;

    }

    public static Boolean Selcfile(String flnm, Boolean bl){
        out("Select your file here");
        
        //String flnm = sc.nextLine();

        //Enco.java
        //String fullpath = "C:/Users/ganes/Thoughts/" + flnm;

        String fullpath = System.getProperty("user.dir") + "/" + flnm;
        //System.out.println(System.getProperty("user.dir"));

        try{
            File f = new File(fullpath);
            if (f.createNewFile()){
                if (!bl){
                f.delete();}
                return false;
            }else{
                return true;
            }
            

        } catch (IOException e){
            
            out("an error occured");
            e.printStackTrace();
            return false;
        }

        //Path datapath = Path.of(fullpath);

    }
    
    public static void pass(){
        String fullpath = System.getProperty("user.dir") + "/" + "scrtgc.txt";
        Selcfile("scrtgc.txt", true);
        //String fullpath = "C:/Users/ganes/Thoughts/scrtgc.txt";
        Path datapath = Path.of(fullpath);
        
        try
        {
            FileReader fread = new FileReader(datapath.toString());
            BufferedReader bread = new BufferedReader(fread);

            if (bread.readLine() == null){
                new newPass();
            }else{
                new TextField();
            }
            bread.close();
            fread.close();

        }catch(IOException e){
            e.printStackTrace();
        }


    }
    
    public static void passSet(String ss){
        String fullpath = System.getProperty("user.dir") + "/" + "scrtgc.txt";
        Path datapath = Path.of(fullpath);
        try{
            FileWriter fwrite = new FileWriter(datapath.toString(), true);
            out(ss);
            fwrite.write(encodpass(ss));
            fwrite.close();
            new TextField();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    // --------------------------------------------------------

    public static void main(String[] args){

        pass();
        /*
        Scanner sc = new Scanner(System.in);
        out("Select your file here");
        String flnm = sc.nextLine();

        //Enco.java
        String fullpath = "C:/Users/ganes/Thoughts/" + flnm;
        
        try{
            File f = new File(fullpath);
            if (f.createNewFile()){
                out("\nThis file doesn't exist, do you want to create a new file?");
                String opinion = sc.nextLine();
                if (opinion.equals("no") || opinion.equals("No") || opinion.equals("NO")){
                    f.delete();
                    out("No file is created");
                }
                if (opinion.equals("yes")){
                out("file successfully created! "+ f.getName());}
            }
            

        } catch (IOException e){
            out("an error occured");
            e.printStackTrace();
        }

        Path datapath = Path.of(fullpath);


        System.out.println("Hello, Master!\nAuthorisation Required");
        System.out.println("Enter the Passcode here : ");

        //temporary password must change later
        String corrPass = "5220  5544  10000  22604  21501  22301  21501";
        String passcode = sc.nextLine();

        // passcheck

        if (!passcode.equals(decod(corrPass))){
            sc.close();
            return;}

        out("Authorisation Successful!\n");



        //Path datapath = Path.of("C:/Users/ganes/G/JavaFold/secre/myThoughts.txt");

        while (true){
            out("\n>>>>");
            String inp = sc.nextLine();

            if (inp.equals("thank you")){
                out("DON'T FORGET TO ADD, COMMIT AND PUSH THE FILES");
                break;
            }

            if (inp.equals("new thought")){
                out("hmmm... whats that? ;)");
                //thoughts.add(sc.nextLine());
                String k = sc.nextLine();
                writebro(datapath, k + "\n");
            }

            else if (inp.equals("what are my thoughts")){
                show(datapath);
            }

            else if (inp.equals("change passcode")){
                out("yeah sure");
                out("enter new pass");
                    corrPass = encod(sc.nextLine());
                    out("Successfully changed the corrPass");
                    out(corrPass);
            }

            else{out("Really? How high are you?");}
        }
        sc.close();
        */
    }
}

