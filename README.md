# KNN-Implementation-with-Java
KNN Classifier implementation using Java and visualization using JavaFX 

# Demo

![Want to stand out of crowd](https://github.com/shephalika21/KNN-Implementation-with-Java/blob/master/Images/Capture1.PNG)

![Want to stand out of crowd](https://github.com/shephalika21/KNN-Implementation-with-Java/blob/master/Images/Capture2.PNG)

The application created is generic for any dataset. 
Any dataset can be given as input to the algorithm after doing data preprocessing. This application should work in both Java7 and Java8. 
The application takes below inputs:
1.	Training file: Please give the correct path with file name (example: E:\\IM1_Training.txt)
2.	Testing file: Please give the correct path with file name (example: E:\\IM2_Testing.txt)
3.	Input value of K – this should be odd number and less than the no. of observations in test set
4.	Distance measure – this can be selected from dropdown(Euclidean/Manhattan)
For getting the graphs, please enter the filenames of training and testing set and then click on Graphs button, you will get the bar chart of accuracy of the KNN algorithm for each odd value of K from 1 to 19.
For getting output for a K value, enter all the input fields and then click on submit. This will give the accuracy for that value of K and Results.csv output file with features of test set, actual labels and predicted values will be exported through application and saved to your local computer.


# How KNN works:
KNN is a supervised learning algorithm and can be used for both classification and regression. If a test data is placed in a space with only training data points, the algorithm calculates distances from that test data point to each training data points and then top K neighbors to the test data point is picked up by the algorithm whose distances are lowest as compared to others. Among those top K neighbors, test data point is assigned to the class which has highest frequency in the top K selected data points from training set. 
The KNN Classification algorithm works as below:
1.	Training and test dataset, K value, distance measure has been taken as input parameters.
2.	Features has been extracted to list of arrays and labels have extracted to array list of String for both training and test dataset.
3.	Different method for Euclidean and Manhattan distance is written and is chosen based on user input.
4.	For each test set data point, distance from all training set points is calculated and stored in Array list of objects.
5.	Frequency is calculated for each label.
6.	Label with maximum frequency is assigned to the test data point.
7.	Repeat steps from 3 to 6 for each data point in test set.
8.	Accuracy is calculated based on how many predicted labels match the actual labels in test set.
