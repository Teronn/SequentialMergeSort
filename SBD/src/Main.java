import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {
	

    public static void main(String[] args) {
        SortFunctions func = new SortFunctions();
        int count = 1;
        int phases = 1;
        Interface ui = new Interface();
        ui.startOfInterface();
        //coll.doNothing();
       // func.createBasicFiles();
        //func.generateRandomFile("randomfile.txt",525000,count);
        //func.createSeries("randomfile.txt",count);
        //func.naturalMerging("tape3.txt",count,10);
        //func.createSeries("kek.txt",count);
        //System.out.println(func.pczserie);
        //func.naturalMerging("tape3.txt",count,5);
       /* if (func.sortCheck("tape3.txt", count, 5)==true)
        	System.out.println("dobrze");
        try {
			copy("tape3.txt","somefile.txt");
		} catch (IOException e) {
			 //TODO Auto-generated catch block
			e.printStackTrace();
		} 
      
        
        while (func.sortCheck("tape3.txt", count, 5)==false) {
        func.clearCollections();
        func.cleanFile("tape1.txt");
        func.cleanFile("tape2.txt");
        func.cleanFile("tape3.txt");
        phases++;
        func.createSeries("somefile.txt",count);
        
        func.naturalMerging("tape3.txt",count,5);

        try {
			copy("tape3.txt","somefile.txt");
		} catch (IOException e) {
			 //TODO Auto-generated catch block
			e.printStackTrace();
		} 
        	
        }
        
*/
System.out.println(phases);
        
    }

}