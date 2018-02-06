/*
 * Programmed by Shephalika Shekhar
 */
package implementation;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

//This class implements the Classification Algorithm
public class Classifier extends ReadDataset {
	public static double accuracy; // global variable to get the accuracy
	
	//Method that takes input training dataset filename, test dataset filename, input value of K and distance measure 
	//such as Euclidean or Manhattan and then based on these classification algorithm works.
	public void input(String train, String test, String inputK, String distance)
			throws NumberFormatException, IOException {
		ReadDataset r1 = new ReadDataset();
		ReadDataset r2 = new ReadDataset();
		r1.features.clear();
		r1.label.clear();
		r2.features.clear();
		r2.label.clear();
		r1.read(train);
		r2.read(test);
		//iterate over test features and test set labels
		Iterator<double[]> test_itr = r2.features.iterator();
		Iterator<String> test_sitr = r2.label.iterator();
		String label = "";
		int k = Integer.parseInt(inputK);
		FileWriter fileWriter = new FileWriter("Results.csv");
		int count = 0;
		while (test_itr.hasNext()) {
			double db[] = test_itr.next();
			label = classify(r1.features, r1.label, db, k, distance);
			String s = test_sitr.next();
			// write in CSV file - test set features, actual label column and predicted label column
			for (int i = 0; i < db.length; i++) {

				fileWriter.append(db[i] + ",");
			}

			fileWriter.append(s + "," + label + "\n");

		}
		System.out.println("Contents exported to File!!!");

		BufferedReader br2 = null;
		fileWriter.flush();
		fileWriter.close();
		int i = 0;
		String st2;
		File file2 = new File("Results.csv");
		br2 = new BufferedReader(new FileReader(file2));
		while ((st2 = br2.readLine()) != null) {
			String[] s = st2.split(",");
			if (s[s.length - 1].equals(s[s.length - 2])) {

			} else
				count++;
		}
		br2.close();
		//find the accuracy of the classifier
		accuracy = ((double) 100 - (((double) count / r2.label.size()) * 100));
		System.out.println("Accuracy is: " + ((double) 100 - (((double) count / r2.label.size()) * 100)) + "%");

	}
	
	//Method for classification algorithm
	@SuppressWarnings("unchecked")
	public static String classify(List<double[]> trainfeatures, List<String> trainlabel, double test[], int k,
			String distancemeasure) {
		//Iterate over train features and labels
		Iterator<double[]> train_itr = trainfeatures.iterator();
		Iterator<String> train_sitr = trainlabel.iterator();
		int size = trainfeatures.size() * test.length;
		ArrayList<CompareDistances> diff = new ArrayList<>();//Array list to store distances
		Map<String, Integer> map = new HashMap<>(); // store the unique labels
		String classlabel = "";
		int i = 0;

		while (train_itr.hasNext()) {
			double d = 0;
			double db[] = train_itr.next();
			String s = train_sitr.next();
			if (distancemeasure.equals("Euclidean")) {
				d = Distance.eucledianDistance(db, test);
			}
			if (distancemeasure.equals("Manhattan")) {
				d = Distance.manhattanDistance(db, test);
			}
			map.put(trainlabel.get(i), i);
			// System.out.println(trainlabel.get(i));
			diff.add(new CompareDistances(d, trainlabel.get(i)));
			i++;

		}
		Collections.sort(diff);
		//sort and get the top distances with lowest values
		Object[] a = map.keySet().toArray();
		Map<String, Integer> freq = new HashMap<>(); //to store frequencies of each label
		int count = 0;
		for (Object n : a) {
			// System.out.println(n);
			for (int p = 0; p < k; p++) {
				if ((diff.get(p).str).equals(n.toString())) {
					count++;
				}
				freq.put(n.toString(), count); //find the count of each labels

			}

		}
		// System.out.println(freq.keySet());
		// System.out.println(freq.values());
		int maxValueInMap = (Collections.max(freq.values())); // This will
																// return max
																// value in the
																// Hashmap
		for (Entry<String, Integer> entry : freq.entrySet()) { // Iterate
																// through
																// Hashmap
			if (entry.getValue() == maxValueInMap) {
				return entry.getKey(); // Print the key/label with max value
			}
		}
		return classlabel;
	}

	/* For console program
	 * public static void main(String args[]) throws IOException {
	 * 
	 * ReadDataset r1 = new ReadDataset(); ReadDataset r2 = new ReadDataset();
	 * r1.features.clear(); r1.label.clear(); r2.features.clear();
	 * r2.label.clear(); Scanner sc=new Scanner(System.in);
	 * System.out.println("Enter the Training dataset filename with path");
	 * String train = sc.next(); r1.read(train); //r1.display();
	 * System.out.println("Enter the Testing dataset filename with path");
	 * String test = sc.next(); r2.read(test);
	 * System.out.println("Enter the value of k"); int k = sc.nextInt();
	 * //r2.display(); Iterator<double[]> test_itr = r2.features.iterator();
	 * Iterator<String> test_sitr = r2.label.iterator(); String label="";
	 * FileWriter fileWriter = new FileWriter("Results.csv"); int count=1; while
	 * (test_itr.hasNext()) { double db[] = test_itr.next(); label =
	 * classify(r1.features, r1.label, db, k); String s = test_sitr.next(); //
	 * write in csv in test set as column predicted label for(int i=0; i<4;i++)
	 * {
	 * 
	 * fileWriter.append(db[i]+","); }
	 * 
	 * fileWriter.append(s+","+label+"\n"); if(s.equals(label)) count++;
	 * 
	 * } System.out.println("Contents exported to File!!!"); int accuracy =
	 * (count/r2.features.size())*100;
	 * System.out.println("Accuracy is: "+((float)count/r2.label.size())*100+"%"
	 * ); fileWriter.flush(); fileWriter.close(); }
	 */

}
