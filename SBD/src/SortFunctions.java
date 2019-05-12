import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.NoSuchElementException;
import java.util.Scanner;



public class SortFunctions {
	private int 	collectionsFirst = 0;
	private int 	collectionsSecond = 0;
	public int		pczserie = 1;
	public void 	incrementCollectionFirst() {
		collectionsFirst++;
	}
	public int		operations = 0;
	public int  	getCollectionFirst() {
		return collectionsFirst;
	}
	public int  	getCollectionSecond() {
		return collectionsSecond;
	}
	public void 	incrementCollectionSecond() {
		collectionsSecond++;
	}
	public void 	clearCollections() {
		collectionsFirst = 0;
		collectionsSecond = 0;
	}
	public void 	generateRandomFile(String entryFileName, int recordNumber, int countOfNumbers) {
		int random = (int )(Math.random() * countOfNumbers + 1);
		int randomNumber;
		int forInt = countOfNumbers;
		int records = recordNumber;
		Writer writer = null;
		
		try {
			
			writer = new BufferedWriter(new OutputStreamWriter(
				  new FileOutputStream(entryFileName),"utf-8"));
			for (;records>0;records--) {
				for(;forInt>countOfNumbers-random;forInt--)
				{
					randomNumber = (int )(Math.random() * 1000 + 1);
					writer.write(String.valueOf(randomNumber)+" ");
   			 		writer.flush(); 
				
				}
				for(;forInt>0;forInt--)
				{
					writer.write(String.valueOf(0)+" ");
   			 		writer.flush(); 
				}
				random = (int )(Math.random() * countOfNumbers + 1);
				forInt=countOfNumbers;
				writer.write(0x0A);
				writer.flush(); 
			}
			
		} catch (IOException ex) {
			System.out.println("Exception");
		} finally {
			try {writer.close();} catch (Exception ex) {}
		}
		
		
	};
	public int  	maxOfCollection(int[] collection, int countOfNumbers) {
		int max = collection[0];
		for (int i = 1; i<countOfNumbers;i++)
		{
			if(collection[i]>max) 
			max = collection[i];
		}
		return max;
	}
	public void 	cleanFile(String fileName) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(fileName);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		writer.close();
		};
	public void 	createBasicFiles() {
		Writer writer = null;

		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream("tape1.txt"), "utf-8"));
		} catch (IOException ex) {
		    // Report
		} finally {
		   try {writer.close();} catch (Exception ex) {/*ignore*/}
		}
		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream("inRandom.txt"), "utf-8"));
		} catch (IOException ex) {
		    // Report
		} finally {
		   try {writer.close();} catch (Exception ex) {/*ignore*/}
		}
		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream("inKeyboard.txt"), "utf-8"));
		} catch (IOException ex) {
		    // Report
		} finally {
		   try {writer.close();} catch (Exception ex) {/*ignore*/}
		}
		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream("inManual.txt"), "utf-8"));
		} catch (IOException ex) {
		    // Report
		} finally {
		   try {writer.close();} catch (Exception ex) {/*ignore*/}
		}
		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream("tape2.txt"), "utf-8"));
		} catch (IOException ex) {
		    // Report
		} finally {
		   try {writer.close();} catch (Exception ex) {/*ignore*/}
		}
		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream("tape3.txt"), "utf-8"));
		} catch (IOException ex) {
		    // Report
		} finally {
		   try {writer.close();} catch (Exception ex) {/*ignore*/}
		}
		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream("keyboard.txt"), "utf-8"));
		} catch (IOException ex) {
		    // Report
		} finally {
		   try {writer.close();} catch (Exception ex) {/*ignore*/}
		}
		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream("manual.txt"), "utf-8"));
		} catch (IOException ex) {
		    // Report
		} finally {
		   try {writer.close();} catch (Exception ex) {/*ignore*/}
		}
	};
	public void 	createSeries(String entryFile, int countOfNumbers) {
		Scanner inFile = null;
		Writer outFileFirst = null;
		Writer outFileSecond = null;
		FileInputStream inputStream = null;
		try {
			 outFileFirst = new BufferedWriter(new FileWriter("tape1.txt", true));
			 outFileSecond = new BufferedWriter(new FileWriter("tape2.txt", true));
			 inputStream = new FileInputStream(entryFile);
	         inFile = new Scanner(inputStream,"UTF-8");
	        
	         int first = -1;
	         int second = -2;
	         int general = 0;
	         int flagTape = 1;
	         int[] generalss = new int[countOfNumbers];
	         
	         for(int i=0;i<countOfNumbers;i++) {
	        	 general = inFile.nextInt();
	        	 generalss[i]=general;	         
	         }
	         inFile.nextLine();
	        
	         while (inFile.hasNextInt()) {
	        	 if(flagTape == 1) {
	        		 if(maxOfCollection(generalss,countOfNumbers) >= first)
	        		 {
	        			 for(int i=0;i<countOfNumbers;i++) {
	        				 outFileFirst.write(String.format("%08d", generalss[i])+" ");	        			
	        	         }
	        			 operations++;
	        			 outFileFirst.flush();
	        			 incrementCollectionFirst();
	        			 first = maxOfCollection(generalss,countOfNumbers);
	        			 
	        		 }
	        		 else {	
	        			 for(int i=0;i<countOfNumbers;i++) {
	        				 outFileSecond.write(String.format("%08d", generalss[i])+" ");
	        	         }
	        			 operations++;
	        			 outFileSecond.flush();
	        			 incrementCollectionSecond();
	        			 second = maxOfCollection(generalss,countOfNumbers);
	        			 pczserie++;
	        			 flagTape++;
	        		 }
	        	 
	        	 } else {
	        		 if (maxOfCollection(generalss,countOfNumbers) >= second)
	        		 {
	        			 for(int i=0;i<countOfNumbers;i++) {
	        				 outFileSecond.write(String.format("%08d", generalss[i])+" ");
	        	         }
	        			 operations++;
        				 incrementCollectionSecond();
	        			 outFileSecond.flush(); 
	        			 second = maxOfCollection(generalss,countOfNumbers);
	        		 }
	        		 else {
	        			 for(int i=0;i<countOfNumbers;i++) {
	        				 outFileFirst.write(String.format("%08d", generalss[i])+" ");
	        	         }
	        			 operations++;
        				 incrementCollectionFirst();
	        			 outFileFirst.flush();
	        			 first = maxOfCollection(generalss,countOfNumbers);
	        			 pczserie++;
	        			 flagTape--;
	        		 }
	        		 
	        	 }
	        	 for(int i=0;i<countOfNumbers;i++) {
		        	 general = inFile.nextInt();
		        	 generalss[i]=general;	         
		         }
		         inFile.nextLine();
		         
	         }
        	 if(flagTape == 1) {
        		 if(maxOfCollection(generalss,countOfNumbers) >= first)
        		 {
        			 for(int i=0;i<countOfNumbers;i++) {
        				 outFileFirst.write(String.format("%08d", generalss[i])+" ");
        	         }
        			 operations++;
    				 incrementCollectionFirst();
        			 outFileFirst.flush();
        			 first = maxOfCollection(generalss,countOfNumbers);
        			 
        		 }
        		 else {
        			 for(int i=0;i<countOfNumbers;i++) {
        				 outFileSecond.write(String.format("%08d", generalss[i])+" ");
        	         }
        			 operations++;
    				 incrementCollectionSecond();
        			 outFileSecond.flush();
        			 second = maxOfCollection(generalss,countOfNumbers);
        			 pczserie++;
        			 flagTape++;
        		 }
        	 
        	 } else {
        		 if (maxOfCollection(generalss,countOfNumbers) >= second)
        		 {
        			 for(int i=0;i<countOfNumbers;i++) {
        				 outFileSecond.write(String.format("%08d", generalss[i])+" ");
        	         }
        			 operations++;
        			 outFileSecond.flush(); 
    				 incrementCollectionSecond();
        			 second = maxOfCollection(generalss,countOfNumbers);
        		 }
        		 else {
        			 for(int i=0;i<countOfNumbers;i++) {
        				 outFileFirst.write(String.format("%08d", generalss[i])+" ");
        	         }
        			 operations++;
       				 incrementCollectionFirst();
        			 outFileFirst.flush();
        			 first = maxOfCollection(generalss,countOfNumbers);
        			 pczserie++;
        			 flagTape--;
        		 }
        		 
        	 }
	         
	        
	      } catch (FileNotFoundException fileNotFoundException) {
	         System.err.println("Error opening file.");
	         fileNotFoundException.printStackTrace();
	      } catch (NoSuchElementException noSuchElementException) {
	         System.err.println("Error in file record structure");
	         noSuchElementException.printStackTrace();
	      } catch (IllegalStateException illegalStateException) {
	         System.err.println("Error reading from file.");
	         illegalStateException.printStackTrace();
	      } catch (IOException ioe2) {
	    	  
	  	  }
	       finally {
	    	   if (inFile != null) 
	            inFile.close();
	         if (outFileFirst != null) 
	        	 try { outFileFirst.close(); } 
	         catch (IOException ignore) {}
	         if (outFileSecond != null) 
	        	 try { outFileSecond.close(); } 
	         catch (IOException ignore) {}
	      }
		
	};
	public void 	naturalMerging(String entryFile, int countOfNumbers, int chunkSize) {		
		
		Writer thirdTape = null;
		BufferedInputStream inFirst = null;
		BufferedInputStream inSecond = null;
		try {
			 inFirst = new BufferedInputStream(new FileInputStream("tape1.txt"));
			 inSecond = new BufferedInputStream(new FileInputStream("tape2.txt"));
			 thirdTape = new BufferedWriter(new FileWriter(entryFile, true));
			 byte[] bbufFirst = new byte[chunkSize*countOfNumbers*9];
			 byte[] bbufSecond = new byte[chunkSize*countOfNumbers*9];
			 int[] generalsFirst = new int[countOfNumbers];
			 int[] generalsSecond = new int[countOfNumbers];
			 int bbufPosFirst = 0;
			 int bbufPosSecond = 0;
			 int firstFlag = 0;
			 int secondFlag = 0;
			 int firstHelp = 0;
			 int secondHelp = 0;
			 int maxOfFirst = 0;
			 int maxOfSecond = 0;
			 int operFirstCount = 0;
			 int operSecondCount = 0;
			 inFirst.read(bbufFirst);
			 inSecond.read(bbufSecond);
			 for (int i=0;i<countOfNumbers;i++)
			 {
				 generalsFirst[i]=0;
				 for(int j=0;j<8;j++) {
					 generalsFirst[i]+=((bbufFirst[(7-j+(i*9))+bbufPosFirst*36]-48)*Math.pow(10,j));
				 }
				 
			 }
			 operFirstCount++;
			 maxOfFirst = maxOfCollection(generalsFirst,countOfNumbers);
			 for (int i=0;i<countOfNumbers;i++)
			 {
				 generalsSecond[i]=0;
				 for(int j=0;j<8;j++) {
					 generalsSecond[i]+=((bbufSecond[7-j+(i*9)+bbufPosSecond*36]-48)*Math.pow(10,j));
				 }				
			 }
			 operSecondCount++;
			 maxOfSecond = maxOfCollection(generalsSecond,countOfNumbers);
			 
			 while (firstFlag == 0 && secondFlag == 0) {
				 if (maxOfFirst<=maxOfSecond) {
					 for (int k = 0; k < countOfNumbers;k++)
						 thirdTape.write(String.valueOf(generalsFirst[k])+" ");
     				 thirdTape.write(0x0A);
					 thirdTape.flush(); 
					 operations++;
					 firstHelp = maxOfFirst;
					 if (bbufPosFirst==(chunkSize-1)) {
						 bbufPosFirst = -1;
						 inFirst.read(bbufFirst);
						 if (operFirstCount!=getCollectionFirst())
						 {
							 bbufPosFirst = 0;
							 for (int i=0;i<countOfNumbers;i++)
							 {
								 generalsFirst[i]=0;
								 for(int j=0;j<8;j++) {
									 generalsFirst[i]+=((bbufFirst[(7-j+(i*9))+bbufPosFirst*(countOfNumbers*9)]-48)*Math.pow(10,j));
								 }
								 
							 }
							 operFirstCount++;
							 maxOfFirst = maxOfCollection(generalsFirst,countOfNumbers);		
							 if (firstHelp > maxOfFirst)
								 firstFlag = 1;
						 } else 
							 firstFlag = 2;
						 
					 } else {
					 if (operFirstCount!=getCollectionFirst())
					 	{
						 bbufPosFirst++;
						 for (int i=0;i<countOfNumbers;i++)
						 {
							 generalsFirst[i]=0;
							 for(int j=0;j<8;j++) {
								 generalsFirst[i]+=((bbufFirst[(7-j+(i*9))+bbufPosFirst*(countOfNumbers*9)]-48)*Math.pow(10,j));
							 }
							 
						 }
						 operFirstCount++;
						 maxOfFirst = maxOfCollection(generalsFirst,countOfNumbers);	
						 if (firstHelp > maxOfFirst)
							 firstFlag = 1;
						 
					 	} else 
							 firstFlag = 2;						 						 
					 }
					 
				 } else 
				 {
					 for (int k = 0; k < countOfNumbers;k++)
						 thirdTape.write(String.valueOf(generalsSecond[k])+" ");
     				 thirdTape.write(0x0A);
					 thirdTape.flush(); 
					 operations++;
					 secondHelp = maxOfSecond;
					 if (bbufPosSecond==(chunkSize-1)) {
						 bbufPosSecond = -1;
						 inSecond.read(bbufSecond);
						 if (operSecondCount!=getCollectionSecond())
						 {
							 bbufPosSecond = 0;
							 for (int i=0;i<countOfNumbers;i++)
							 {
								 generalsSecond[i]=0;
								 for(int j=0;j<8;j++) {
									 generalsSecond[i]+=((bbufSecond[(7-j+(i*9))+bbufPosSecond*(countOfNumbers*9)]-48)*Math.pow(10,j));
								 }				
							 }
							 operSecondCount++;
							 maxOfSecond = maxOfCollection(generalsSecond,countOfNumbers);		
							 if (secondHelp > maxOfSecond)
								 secondFlag = 1;
						 } else 
							 secondFlag = 2;
						 
					 } else {
					 if (operSecondCount!=getCollectionSecond())
					 	{
						 bbufPosSecond++;
						 for (int i=0;i<countOfNumbers;i++)
						 {
							 generalsSecond[i]=0;
							 for(int j=0;j<8;j++) {
								 generalsSecond[i]+=((bbufSecond[(7-j+(i*9))+bbufPosSecond*(countOfNumbers*9)]-48)*Math.pow(10,j));
							 }				
						 }
						 operSecondCount++;
						 maxOfSecond = maxOfCollection(generalsSecond,countOfNumbers);	
						 if (secondHelp > maxOfSecond)
							 secondFlag = 1;
						 
					 	} else 
					 		secondFlag = 2;						 						 
					 }
					 
				 }
			 

			 if (firstFlag == 1) {
				 while (secondFlag == 0)
				 {
					 for (int k = 0; k < countOfNumbers;k++)
						 thirdTape.write(String.valueOf(generalsSecond[k])+" ");
     				 thirdTape.write(0x0A);
					 thirdTape.flush(); 
					 operations++;
					 if (bbufPosSecond==(chunkSize-1)) {
						 bbufPosSecond = -1;
						 inSecond.read(bbufSecond);
						 if (operSecondCount==getCollectionSecond())
							 {
							 	secondFlag = 2;
							 	break;
							 }
						 secondHelp = maxOfSecond;
						 bbufPosSecond = 0;
						 for (int i=0;i<countOfNumbers;i++)
						 {
							 generalsSecond[i]=0;
							 for(int j=0;j<8;j++) {
								 generalsSecond[i]+=((bbufSecond[(7-j+(i*9))+bbufPosSecond*(countOfNumbers*9)]-48)*Math.pow(10,j));
							 }				
						 }
						 operSecondCount++;
						 maxOfSecond = maxOfCollection(generalsSecond,countOfNumbers);
						 if (secondHelp > maxOfSecond)
							 secondFlag = 1;
						 
					   }  else 
					   {

							 if (operSecondCount==getCollectionSecond())
								 {
								 	secondFlag = 2;
								 	break;
								 }
							 secondHelp = maxOfSecond;
							 bbufPosSecond++;
							 for (int i=0;i<countOfNumbers;i++)
							 {
								 generalsSecond[i]=0;
								 for(int j=0;j<8;j++) {
									 generalsSecond[i]+=((bbufSecond[(7-j+(i*9))+bbufPosSecond*(countOfNumbers*9)]-48)*Math.pow(10,j));
								 }				
							 }
							 operSecondCount++;
							 maxOfSecond = maxOfCollection(generalsSecond,countOfNumbers);
							 if (secondHelp > maxOfSecond)
								 secondFlag = 1;
					   }
					 
				 }
			 }
			 if (secondFlag == 1) {
				 while (firstFlag ==0)
				 {
					 for (int k = 0; k < countOfNumbers;k++)
						 thirdTape.write(String.valueOf(generalsFirst[k])+" ");
     				 thirdTape.write(0x0A);
					 thirdTape.flush(); 
					 operations++;
					 if (bbufPosFirst==(chunkSize-1)) {
						 bbufPosFirst = -1;
						 inFirst.read(bbufFirst);
						 if (operFirstCount==getCollectionFirst())
							 {
							 	firstFlag = 2;
							 	break;
							 }
						 firstHelp = maxOfFirst;
						 bbufPosFirst = 0;
						 for (int i=0;i<countOfNumbers;i++)
						 {
							 generalsFirst[i]=0;
							 for(int j=0;j<8;j++) {
								 generalsFirst[i]+=((bbufFirst[(7-j+(i*9))+bbufPosFirst*(countOfNumbers*9)]-48)*Math.pow(10,j));
							 }
							 
						 }
						 operFirstCount++;
						 maxOfFirst = maxOfCollection(generalsFirst,countOfNumbers);
						 if (firstHelp > maxOfFirst)
							 firstFlag = 1;
						 
					   } else {
							 if (operFirstCount==getCollectionFirst())
								 {
								 	firstFlag = 2;
								 	break;
								 }
							 firstHelp = maxOfFirst;
							 bbufPosFirst++;
							 for (int i=0;i<countOfNumbers;i++)
							 {
								 generalsFirst[i]=0;
								 for(int j=0;j<8;j++) {
									 generalsFirst[i]+=((bbufFirst[(7-j+(i*9))+bbufPosFirst*(countOfNumbers*9)]-48)*Math.pow(10,j));
								 }				
							 }
							 operFirstCount++;
							 maxOfFirst = maxOfCollection(generalsFirst,countOfNumbers);
							 if (firstHelp > maxOfFirst)
								 firstFlag = 1;
							 
					   }
					 
				 }
			 }
			 
			 
			 if (firstFlag == 2)
			 {
				
				 do {
					 for (int k = 0; k < countOfNumbers;k++)
						 thirdTape.write(String.valueOf(generalsSecond[k])+" ");
     				 thirdTape.write(0x0A);
					 thirdTape.flush();
					 secondHelp = maxOfSecond;
					 operations++;
					 if (bbufPosSecond==(chunkSize-1)) {
						 bbufPosSecond = -1;
						 inSecond.read(bbufSecond);
						 if (operSecondCount==getCollectionSecond())
							 	break;							 
						 secondHelp = maxOfSecond;
						 bbufPosSecond = 0;
						 for (int i=0;i<countOfNumbers;i++)
						 {
							 generalsSecond[i]=0;
							 for(int j=0;j<8;j++) {
								 generalsSecond[i]+=((bbufSecond[(7-j+(i*9))+bbufPosSecond*(countOfNumbers*9)]-48)*Math.pow(10,j));
							 }				
						 }
						 operSecondCount++;
						 maxOfSecond = maxOfCollection(generalsSecond,countOfNumbers);
						 
					   }  else 
					   {

							 if (operSecondCount==getCollectionSecond())
								 	break;
							 secondHelp = maxOfSecond;
							 bbufPosSecond++;
							 for (int i=0;i<countOfNumbers;i++)
							 {
								 generalsSecond[i]=0;
								 for(int j=0;j<8;j++) {
									 generalsSecond[i]+=((bbufSecond[(7-j+(i*9))+bbufPosSecond*(countOfNumbers*9)]-48)*Math.pow(10,j));
								 }				
							 }
							 operSecondCount++;
							 maxOfSecond = maxOfCollection(generalsSecond,countOfNumbers);
					   }
					 
				 } while (true);
			 }
			 
			 if (secondFlag == 2)
			 {
				 do {
					 for (int k = 0; k < countOfNumbers;k++)
						 thirdTape.write(String.valueOf(generalsFirst[k])+" ");
     				 thirdTape.write(0x0A);
					 thirdTape.flush(); 
					 operations++;
					 firstHelp = maxOfFirst;
					 if (bbufPosFirst==(chunkSize-1)) {
						 bbufPosFirst = -1;
						 inFirst.read(bbufFirst);
						 if (operFirstCount==getCollectionFirst())
							 	break;							 
						 firstHelp = maxOfFirst;
						 bbufPosFirst = 0;
						 for (int i=0;i<countOfNumbers;i++)
						 {
							 generalsFirst[i]=0;
							 for(int j=0;j<8;j++) {
								 generalsFirst[i]+=((bbufFirst[(7-j+(i*9))+bbufPosFirst*(countOfNumbers*9)]-48)*Math.pow(10,j));
							 }				
						 }
						 operFirstCount++;
						 maxOfFirst = maxOfCollection(generalsFirst,countOfNumbers);
						 
					   } else {
							 if (operFirstCount==getCollectionFirst())
								 	break;
							 firstHelp = maxOfFirst;
							 bbufPosFirst++;
							 for (int i=0;i<countOfNumbers;i++)
							 {
								 generalsFirst[i]=0;
								 for(int j=0;j<8;j++) {
									 generalsFirst[i]+=((bbufFirst[(7-j+(i*9))+bbufPosFirst*(countOfNumbers*9)]-48)*Math.pow(10,j));
								 }				
							 }
							 operFirstCount++;
							 maxOfFirst = maxOfCollection(generalsFirst,countOfNumbers);
							 
					   }
					 
					 
				 } while (true);
			 }
			 	if(firstFlag==1&&secondFlag==1)
			 		{
			 		firstFlag--;
			 		secondFlag--;
			 		}

			 	
			 }
       	 
	      } catch (FileNotFoundException fileNotFoundException) {
	         System.err.println("Error opening file.");
	         fileNotFoundException.printStackTrace();
	      } catch (NoSuchElementException noSuchElementException) {
	         System.err.println("Error in file record structure");
	         noSuchElementException.printStackTrace();
	      } catch (IllegalStateException illegalStateException) {
	         System.err.println("Error reading from file.");
	         illegalStateException.printStackTrace();
	      } catch (IOException ioe2) {
	  	    
	  	  }
	       finally {
	         if (inFirst != null)
				try {
					inFirst.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         if (inSecond != null)
				try {
					inSecond.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         if (thirdTape != null) try { thirdTape.close(); } catch (IOException ignore) {}
	      }
		
	};
	public boolean 	sortCheck(String entryFile, int countOfNumbers, int chunkSize) {

		int previousValue = 0;
		int[] collection = new int[countOfNumbers];
		Scanner file = null;
		FileInputStream inputStreamData = null;
        
		try {
			int general = 0;
			 inputStreamData = new FileInputStream(entryFile);
	         file = new Scanner(inputStreamData,"UTF-8");
	         
	         while(file.hasNextInt()) {
	        	 for(int i=0;i<countOfNumbers;i++) {
	        		 general = file.nextInt();
	        		 collection[i]=general;	         
	        	 }
	        	 file.nextLine();
	        	 if(maxOfCollection(collection,countOfNumbers)<previousValue)
	        		 return false;
	        	 previousValue = maxOfCollection(collection,countOfNumbers) ;
	        	 
	         }
	        
			
      } catch (FileNotFoundException fileNotFoundException) {
         System.err.println("Error opening file.");
         fileNotFoundException.printStackTrace();
      } catch (NoSuchElementException noSuchElementException) {
         System.err.println("Error in file record structure");
         noSuchElementException.printStackTrace();
      } catch (IllegalStateException illegalStateException) {
         System.err.println("Error reading from file.");
         illegalStateException.printStackTrace();
      } catch (IOException ioe2) {
    	  
  	  }
       finally {
    	   if (file != null) 
            file.close();
      }
		
		
		
		return true;
	}
	
	
	
}
