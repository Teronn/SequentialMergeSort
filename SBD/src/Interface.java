import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Interface {
	
	public static void copy(String sourcePath, String destinationPath) throws IOException {
	    Files.copy(Paths.get(sourcePath), new FileOutputStream(destinationPath));
	}

	private int 	autoSortFlag = 0;
	private int		phases = 0;
	private	int		chunkSize = 10;
	private int		numbersAmount = 15;
	private int		collectionAmount = 10;
	private int		minToGenerate = 1;
	private int		maxToGenerate = 100;
	
	public	int		flagX = 0;
	
	
	public 	int 	getSortFlag() {
		return autoSortFlag;
	}
	public 	int 	getPhases() {
		return phases;
	}
	public 	int 	getChunkSize() {
		return chunkSize;
	}
	public 	int 	getNumbersAmount() {
		return numbersAmount;
	}
	public 	int 	getCollectionAmount() {
		return collectionAmount;
	}
	public 	int 	getMin() {
		return minToGenerate;
	}
	public 	int 	getMax() {
		return maxToGenerate;
	}
	
	public String fileName = "manual.txt";
	
	
	public	void	setSortFlag() {
		if(autoSortFlag == 0)
			autoSortFlag++;
		else autoSortFlag--;
	}
	public	void	setChunkSize(int value) {
		chunkSize = value;
		
	}
	public	void	setPhases(int value) {
		phases = value;
		
	}
	public	void	setNumbersAmount(int value) {
		numbersAmount = value;
	}
	public	void	setCollectionAmount(int value) {
		collectionAmount = value;
	}
	public	void	setMin(int value) {
		minToGenerate = value;
	}
	public	void	setMax(int value) {
		maxToGenerate = value;
	}
	

	public	void	startOfInterface() {		
		Scanner keyboard = new Scanner(System.in);
		String myint;
		int number;
		Writer outFile = null;
		SortFunctions func = new SortFunctions();
		func.createBasicFiles();
		
		while (true)
		{	
			System.out.println("Q - exit / A - zmiana trybu sortowania / O - opcje generowania");
			System.out.println("G - generowanie losowego pliku wejœciowego / H - generowanie pliku z klawiatury ");
			System.out.println("S - sortowanie pliku losowego / D - sortowanie pliku z klawiatury");
			System.out.println("F - sortowanie pliku manualnego (wymaga ustawien wlasciwych)");
			System.out.println("Wpisz znak");
			myint = keyboard.nextLine();
			if (myint.equals("q"))
				break;
			if (myint.equals("a"))
			{
				setSortFlag();
				if(getSortFlag()==1)
					System.out.println("Sortowanie po jednej fazie");
				else
					System.out.println("Sortowanie do koñca");
			}
			if (myint.equals("o"))
			{
				System.out.println("Obecne ustawienia:");
				System.out.println(" 1-Iloœæ liczb w zbiorze:"+String.valueOf(getNumbersAmount()));
				System.out.println(" 2-Iloœæ rekordów:"+String.valueOf(getCollectionAmount()));
				System.out.println(" 3-Iloœæ rekordów w chunku:"+String.valueOf(getChunkSize()));
				System.out.println(" 4-Minimalna liczba w zbiorze (do generowania):"+String.valueOf(getMin()));
				System.out.println(" 5-Maksymalna liczba w zbiorze (do generowania):"+String.valueOf(getMax()));
				System.out.println(" 6-Plik manualny:"+fileName);
				while (true)
				{
					System.out.println(" Wpisz liczbe - edycja / o - aktualne ustawienia / q - powrót");
					myint = keyboard.nextLine();
					if (myint.equals("q"))
						break;
					if (myint.equals("o"))
					{
						System.out.println("Obecne ustawienia:");
						System.out.println(" 1-Iloœæ liczb w zbiorze:"+String.valueOf(getNumbersAmount()));
						System.out.println(" 2-Iloœæ rekordów:"+String.valueOf(getCollectionAmount()));
						System.out.println(" 3-Iloœæ rekordów w chunku:"+String.valueOf(getChunkSize()));
						System.out.println(" 4-Minimalna liczba w zbiorze (do generowania):"+String.valueOf(getMin()));
						System.out.println(" 5-Maksymalna liczba w zbiorze (do generowania):"+String.valueOf(getMax()));
						System.out.println(" 6-Plik manualny:"+fileName);
					}					
					if (myint.equals("1"))
					{
						System.out.println("Wpisz liczbe - iloœæ liczb w zbiorze ");
						if (keyboard.hasNextInt())
						{
							number = keyboard.nextInt();
						if(number>0)
							setNumbersAmount(number);
						else System.out.println("Niew³aœciwa liczba");
						}
						else System.out.println("Niew³aœciwy znak");
					}
					if (myint.equals("2"))
					{
						System.out.println("Wpisz liczbe - iloœæ rekordow ");
						if (keyboard.hasNextInt())
						{
						number = keyboard.nextInt();
						if(number>0)
							setCollectionAmount(number);
						else System.out.println("Niew³aœciwa liczba");
						}
						else System.out.println("Niew³aœciwy znak");
					}
					if (myint.equals("3"))
					{
						System.out.println("Wpisz liczbe - iloœæ rekordów w chunku ");
						if (keyboard.hasNextInt())
						{
						number = keyboard.nextInt();
						if(number>0)
							setNumbersAmount(number);
						else System.out.println("Niew³aœciwa liczba");
						}
						else System.out.println("Niew³aœciwy znak");
					}
					if (myint.equals("4"))
					{
						System.out.println("Wpisz liczbe - minimalna liczba losowana w zbiorze ");
						if (keyboard.hasNextInt())
						{
						number = keyboard.nextInt();
						if(number>=0&&number<=getMax()&&number<1000000)
							setNumbersAmount(number);
						else System.out.println("Niew³aœciwa liczba");
						}
						else System.out.println("Niew³aœciwy znak");
					}
					if (myint.equals("5"))
					{
						System.out.println("Wpisz liczbe - maksymalna liczba losowana w zbiorze ");
						if (keyboard.hasNextInt())
						{
						number = keyboard.nextInt();
						if(number>=0&&number>=getMax()&&number<1000000)
							setNumbersAmount(number);
						else System.out.println("Niew³aœciwa liczba");
						}
						else System.out.println("Niew³aœciwy znak");
					}
					if (myint.equals("6"))
					{
						System.out.println("Wpisz nazwe pliku manualnego ");
						myint = keyboard.nextLine();
						fileName = myint;
						
					}
				};
				
				
				
			}
			if (myint.equals("g"))
			{
				setPhases(0);
				func.generateRandomFile("randomfile.txt", getCollectionAmount(),getNumbersAmount() );
				System.out.println("Plik wygenerowany pod nazwa randomfile.txt");
			}
			if (myint.equals("h"))
			{
				setPhases(0);
				func.cleanFile("keyboard.txt");
				try {
					outFile = new BufferedWriter(new FileWriter("keyboard.txt", true));
					for (int i=0;i<getCollectionAmount();i++) {
						for(int j=0;j<getNumbersAmount();j++) {
							if (keyboard.hasNextInt())
							{
							number = keyboard.nextInt();
							if(number>=0) {
								outFile.write(number+" ");
								outFile.flush();
							}
							else { System.out.println("Niew³aœciwa liczba. Wpisuje 0");
							outFile.write("0"+" ");
							outFile.flush();
							
							}
							}
							else { 
								System.out.println("Niew³aœciwy znak. Wpisuje 0");
								outFile.write("0"+" ");
								outFile.flush();
							}			
						
						}
						System.out.println("Wpisujesz do kolejnego rekordu");
						outFile.write(0x0A);
						outFile.flush();
					}
					System.out.println("Zakonczone wpisywanie pliku");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			       finally {
			         if (outFile != null) 
			        	 try { outFile.close(); } 
			         catch (IOException ignore) {}

			      }
			}
			if (myint.equals("f"))
			{
				
				if(flagX==0) {
					setPhases(1);
			        func.clearCollections();
			        func.cleanFile("tape1.txt");
			        func.cleanFile("tape2.txt");
			        func.cleanFile("tape3.txt");
					func.cleanFile("inManual.txt");
					func.operations = 0;
			        try {
						copy(fileName,"inManual.txt");
					} catch (IOException e) {
						 //TODO Auto-generated catch block
						e.printStackTrace();
					} 
			        flagX=1;
				}
				
				if(func.sortCheck("inManual.txt", getNumbersAmount(), getChunkSize())==true)
				{
					System.out.println("Plik jest posortowany");
					flagX=0;
				}

				if(getSortFlag()==1&&func.sortCheck("inManual.txt", getNumbersAmount(), getChunkSize())==false)
				{
					
					func.createSeries("inManual.txt",getNumbersAmount() );
					func.naturalMerging("tape3.txt",getNumbersAmount() ,getChunkSize());
			        try {
						copy("tape3.txt","inManual.txt");
					} catch (IOException e) {
						 //TODO Auto-generated catch block
						e.printStackTrace();
					}
			        System.out.println("Przejsc:"+String.valueOf(getPhases()));
			        System.out.println("Zapisow by³o:" + String.valueOf(func.operations));
			        func.clearCollections();
			        func.cleanFile("tape1.txt");
			        func.cleanFile("tape2.txt");
			        func.cleanFile("tape3.txt");
			        setPhases(getPhases()+1);
				} else
				{
					func.operations = 0;
					setPhases(0);
			        func.clearCollections();
			        func.cleanFile("tape1.txt");
			        func.cleanFile("tape2.txt");
			        func.cleanFile("tape3.txt");
					func.cleanFile("inManual.txt");
					
			        try {
						copy(fileName,"inManual.txt");
					} catch (IOException e) {
						 //TODO Auto-generated catch block
						e.printStackTrace();
					} 
			        if (func.sortCheck("inManual.txt", getNumbersAmount(), getChunkSize())==false) {
						func.createSeries("inManual.txt",getNumbersAmount() );
						func.naturalMerging("tape3.txt",getNumbersAmount() ,getChunkSize());
						setPhases(getPhases()+1);
						func.cleanFile("inManual.txt");
				        try {
							copy("tape3.txt","inManual.txt");
						} catch (IOException e) {
							 //TODO Auto-generated catch block
							e.printStackTrace();
						} 
			        }
					while(func.sortCheck("tape3.txt", getNumbersAmount(), getChunkSize())==false) {
				        func.clearCollections();
				        func.cleanFile("tape1.txt");
				        func.cleanFile("tape2.txt");
				        func.cleanFile("tape3.txt");
				        func.createSeries("inManual.txt",getNumbersAmount());
				        
				        func.naturalMerging("tape3.txt",getNumbersAmount(),getChunkSize());
				        
				        func.cleanFile("inManual.txt");
				        try {
							copy("tape3.txt","inManual.txt");
						} catch (IOException e) {
							 //TODO Auto-generated catch block
							e.printStackTrace();
						} 
				        setPhases(getPhases()+1);
				        					}
					
					System.out.println("Plik posortowany znajduje sie w pliku inManual.txt");
					System.out.println("Faz by³o:" + String.valueOf(getPhases()));
					System.out.println("Zapisow by³o:" + String.valueOf(func.operations));
					
			}
	
				}
			if (myint.equals("d"))
			{
				
				if(flagX==0) {
					func.operations=0;
					setPhases(1);
			        func.clearCollections();
			        func.cleanFile("tape1.txt");
			        func.cleanFile("tape2.txt");
			        func.cleanFile("tape3.txt");
					func.cleanFile("inKeyboard.txt");
					
			        try {
						copy("keyboard.txt","inKeyboard.txt");
					} catch (IOException e) {
						 //TODO Auto-generated catch block
						e.printStackTrace();
					} 
			        flagX=1;
				}
				
				if(func.sortCheck("inKeyboard.txt", getNumbersAmount(), getChunkSize())==true)
				{
					System.out.println("Plik jest posortowany");
					flagX=0;
				}

				if(getSortFlag()==1&&func.sortCheck("inKeyboard.txt", getNumbersAmount(), getChunkSize())==false)
				{
					
					func.createSeries("inKeyboard.txt",getNumbersAmount() );
					func.naturalMerging("tape3.txt",getNumbersAmount() ,getChunkSize());
			        try {
						copy("tape3.txt","inKeyboard.txt");
					} catch (IOException e) {
						 //TODO Auto-generated catch block
						e.printStackTrace();
					}
			        System.out.println("Przejsc:"+String.valueOf(getPhases()));
			        System.out.println("Zapisow by³o:" + String.valueOf(func.operations));
			        func.clearCollections();
			        func.cleanFile("tape1.txt");
			        func.cleanFile("tape2.txt");
			        func.cleanFile("tape3.txt");
			        setPhases(getPhases()+1);
				} else
				{
					func.operations=0;
					setPhases(0);
			        func.clearCollections();
			        func.cleanFile("tape1.txt");
			        func.cleanFile("tape2.txt");
			        func.cleanFile("tape3.txt");
					func.cleanFile("inKeyboard.txt");
					
			        try {
						copy("keyboard.txt","inKeyboard.txt");
					} catch (IOException e) {
						 //TODO Auto-generated catch block
						e.printStackTrace();
					} 
			        if (func.sortCheck("inKeyboard.txt", getNumbersAmount(), getChunkSize())==false) {
						func.createSeries("inKeyboard.txt",getNumbersAmount() );
						func.naturalMerging("tape3.txt",getNumbersAmount() ,getChunkSize());
						setPhases(getPhases()+1);
						func.cleanFile("inKeyboard.txt");
				        try {
							copy("tape3.txt","inKeyboard.txt");
						} catch (IOException e) {
							 //TODO Auto-generated catch block
							e.printStackTrace();
						} 
			        }
					while(func.sortCheck("tape3.txt", getNumbersAmount(), getChunkSize())==false) {
				        func.clearCollections();
				        func.cleanFile("tape1.txt");
				        func.cleanFile("tape2.txt");
				        func.cleanFile("tape3.txt");
				        func.createSeries("inKeyboard.txt",getNumbersAmount());
				        
				        func.naturalMerging("tape3.txt",getNumbersAmount(),getChunkSize());
				        
				        func.cleanFile("inKeyboard.txt");
				        try {
							copy("tape3.txt","inKeyboard.txt");
						} catch (IOException e) {
							 //TODO Auto-generated catch block
							e.printStackTrace();
						} 
				        setPhases(getPhases()+1);
				        					}
					
					System.out.println("Plik posortowany znajduje sie w pliku inKeyboard.txt");
					System.out.println("Faz by³o:" + String.valueOf(getPhases()));
					System.out.println("Zapisow by³o:" + String.valueOf(func.operations));
					
			}
	
				}
			if (myint.equals("s"))
			{
				
				if(flagX==0) {
					func.operations=0;
					setPhases(1);
			        func.clearCollections();
			        func.cleanFile("tape1.txt");
			        func.cleanFile("tape2.txt");
			        func.cleanFile("tape3.txt");
					func.cleanFile("inRandom.txt");
					
			        try {
						copy("randomfile.txt","inRandom.txt");
					} catch (IOException e) {
						 //TODO Auto-generated catch block
						e.printStackTrace();
					} 
			        flagX=1;
				}
				
				if(func.sortCheck("inRandom.txt", getNumbersAmount(), getChunkSize())==true)
				{
					System.out.println("Plik jest posortowany");
					flagX=0;
				}

				if(getSortFlag()==1&&func.sortCheck("inRandom.txt", getNumbersAmount(), getChunkSize())==false)
				{
			        func.clearCollections();
			        func.cleanFile("tape1.txt");
			        func.cleanFile("tape2.txt");
			        func.cleanFile("tape3.txt");
					func.createSeries("inRandom.txt",getNumbersAmount() );
					func.naturalMerging("tape3.txt",getNumbersAmount() ,getChunkSize());
			        try {
						copy("tape3.txt","inRandom.txt");
					} catch (IOException e) {
						 //TODO Auto-generated catch block
						e.printStackTrace();
					}
			        System.out.println("Przejsc:"+String.valueOf(getPhases()));
			        System.out.println("Zapisow by³o:" + String.valueOf(func.operations));

			        setPhases(getPhases()+1);
				} else
				{
					func.operations=0;
					setPhases(0);
			        func.clearCollections();
			        func.cleanFile("tape1.txt");
			        func.cleanFile("tape2.txt");
			        func.cleanFile("tape3.txt");
					func.cleanFile("inRandom.txt");
					
			        try {
						copy("randomfile.txt","inRandom.txt");
					} catch (IOException e) {
						 //TODO Auto-generated catch block
						e.printStackTrace();
					} 
			        if (func.sortCheck("inRandom.txt", getNumbersAmount(), getChunkSize())==false) {
						func.createSeries("inRandom.txt",getNumbersAmount() );
						func.naturalMerging("tape3.txt",getNumbersAmount() ,getChunkSize());
						setPhases(getPhases()+1);
						func.cleanFile("inRandom.txt");
				        try {
							copy("tape3.txt","inRandom.txt");
						} catch (IOException e) {
							 //TODO Auto-generated catch block
							e.printStackTrace();
						} 
			        }
					while(func.sortCheck("tape3.txt", getNumbersAmount(), getChunkSize())==false) {
				        func.clearCollections();
				        func.cleanFile("tape1.txt");
				        func.cleanFile("tape2.txt");
				        func.cleanFile("tape3.txt");
				        func.createSeries("inRandom.txt",getNumbersAmount());
				        
				        func.naturalMerging("tape3.txt",getNumbersAmount(),getChunkSize());
				        
				        func.cleanFile("inRandom.txt");
				        try {
							copy("tape3.txt","inRandom.txt");
						} catch (IOException e) {
							 //TODO Auto-generated catch block
							e.printStackTrace();
						} 
				        setPhases(getPhases()+1);
				        					}
					
					System.out.println("Plik posortowany znajduje sie w pliku inRandom.txt");
					System.out.println("Faz by³o:" + String.valueOf(getPhases()));
					System.out.println("Zapisow by³o:" + String.valueOf(func.operations));
					
			}
	
				}
			
			
			
		};

	}
	
	
}
