/*
 * Programmed by Shephalika Shekhar
 */
package implementation;

public class Distance {

	public Distance() {
		// TODO Auto-generated constructor stub
	}

	// method to find euclidean distance between two points
	public static double eucledianDistance(double[] point1, double[] point2) {
		double sum = 0;
		for (int i = 0; i < point1.length; i++) {
			// System.out.println(point1[i]+" "+point2[i]);
			sum += (point1[i] - point2[i]) * (point1[i] - point2[i]);
		}
		return Math.sqrt(sum);
	}

	// method to find Manhattan distance between two points
	public static double manhattanDistance(double point1[], double point2[]) {
		double sum = 0;
		for (int i = 0; i < point1.length; i++) {
			sum += Math.abs(point1[i] - point2[i]);
		}
		return sum;
	}

}
