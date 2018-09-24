	
	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.Reader;
	import java.io.Writer;
	import java.util.Arrays;
	import java.util.logging.Level;
	import java.util.logging.Logger;

	import org.apache.commons.csv.CSVFormat;
	import org.apache.commons.csv.CSVPrinter;
	import org.apache.commons.csv.CSVRecord;

	public class Assignment1 {
		static int i = 0;
		static int x = 0;
		private static Writer out;
		private static CSVPrinter csvPrinter;

		public void walk(String path) {

			File root = new File(path);
			File[] list = root.listFiles();
			if (list == null)
				return;
			for (File f : list) {
				if (f.isDirectory()) {
					walk(f.getAbsolutePath());
					// System.out.println("Dir:" + f.getAbsoluteFile());
				} else {
					
					if (f.getAbsolutePath().endsWith(".csv")) 
					
					{
						Reader in;
						try {
						in = new FileReader(f.getAbsoluteFile());
						Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
						
						String[] datePath = f.getPath().toString().split(File.separator+File.separator);
						String date = (datePath[datePath.length - 4]) + "/" + (datePath[datePath.length - 3].length() > 1 ? datePath[datePath.length - 3] : "0" + datePath[datePath.length - 3])
								+ "/" + (datePath[datePath.length - 2].length() > 1 ? datePath[datePath.length - 2] : "0" + datePath[datePath.length - 2]);
								
						
						
						for (CSVRecord record : records) {
							if(record.getRecordNumber() == 1) continue;
							try {
								String First_Name = record.get(0);
								String Last_Name = record.get(1);
								String Street_Number = record.get(2);
								String Street = record.get(3);
								String City = record.get(4);
								String Province = record.get(5);
								String Postal_Code = record.get(6);
								String Country = record.get(7);
								String Phone_Number = record.get(8);
								String email_Address = record.get(9);
							
								if (First_Name == null || First_Name.equals("") || Postal_Code == null
										|| Postal_Code.equals("") || email_Address == null || email_Address.equals("")) {
									Logger.getAnonymousLogger().log(Level.INFO,
											"This record is incomplete, so it is skipped.");
									i++;
								
									
								} else {
									csvPrinter.printRecord(Arrays.asList(new String[]{First_Name, Last_Name,Street_Number,Street,City,Province,Postal_Code,Country,Phone_Number ,email_Address, date}));

									csvPrinter.flush();

								}
							} catch (IOException e) {
								e.printStackTrace();
								Logger.getAnonymousLogger().log(Level.INFO,
										"The invalid count is:" + ++x);
								/*System.out.println("The invalid count is:" + ++x);*/
									
							}  catch (ArrayIndexOutOfBoundsException e) {
								e.printStackTrace();
								Logger.getAnonymousLogger().log(Level.INFO,
										"The invalid count is:" + ++x);
								/*System.out.println("The invalid count is:" + ++x);*/
									
							}
						}
						}catch(Exception e) {
							e.printStackTrace();
							Logger.getAnonymousLogger().log(Level.INFO,
									"The invalid count is:" + ++x);
							/*System.out.println("The invalid count is:" + ++x);*/
						}
					}
				}
			}
		}

		public static void main(String[] args) {
			System.setProperty("java.util.logging.config.file", "./logging.properties");
			try {
				out = new BufferedWriter(new FileWriter(".\\Output\\Jasleen.csv"));
				csvPrinter = new CSVPrinter(out, CSVFormat.EXCEL.withHeader("First_Name", "Last_Name","Street_Number","Street","City","Province","Postal_Code","Country","Phone_Number" ,"email_Address", "date"));
			} catch (Exception e) {

			}
			final long startTime = System.currentTimeMillis();
			Assignment1 fw = new Assignment1();
			fw.walk("C:\\Users\\jasle\\Documents\\GitHub\\MCDA5510_Assignments\\Sample Data\\Sample Data");
			final long endTime = System.currentTimeMillis();

			Logger.getAnonymousLogger().log(Level.INFO,"Total execution time: " + (endTime - startTime) +" ms");
			Logger.getAnonymousLogger().log(Level.INFO,"The number of invalid count :" + ++x);
			Logger.getAnonymousLogger().log(Level.INFO,
					"Number of records skipped:" + ++i);
		}
	}


