import java.io.*;
public class TestArea
{
    public static void main (String [] args)
    {
        String[][] ArrayA = new String[5][10];
        System.out.println(ArrayA[0].length);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void a () throws IOException
    {
        FileReader fr = new FileReader ("Contacts.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        int numOflines =0;
        
        do
        {
            numOflines++;
            System.out.println(line);
        } while ((line = br.readLine()) != null);
        
        System.out.println("number Of lines: " + numOflines);
        br.close();
        
        
        
        
        fr = new FileReader ("Contacts.txt");
        br = new BufferedReader(fr);
        line = br.readLine();
        
        String[][] Contacts = new String[3][numOflines];
        int j=0;
        do
        {
            String[] Components = line.split(", ");
            System.out.println("Component:  " + Components[0] + " " + Components[1] + " " + Components[2]);
            System.out.println("Components.length: " + Components.length);
            for (int i = 0; i<Components.length; i++)
            {
                Contacts[i][j] = Components[i];
            }
            j++;
        } while ((line = br.readLine()) != null);
        System.out.println("''''''");
        System.out.println(Contacts[0][0] + " " + Contacts[1][0] + " " + Contacts[2][0]);
        System.out.println(Contacts[1][0] + " " + Contacts[1][1] + " " + Contacts[2][1]);
        
        //System.out.println("number Of lines: " + numOflines);
        br.close();
    }
}
