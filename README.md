# self-correlation-software
Repository containing my personal side project consisting of a self-correlation software used to analyze periodical behavior in data

The program performs a self-correlation analysis to find periodic behavior in data given. It has been used so far to study periodicity in variable stars.
The program now has a GUI that allows to take in a .csv file or a .dat file with two columns of data (date, magnitude), prompts the user for the lower and upper bounds of the periods you want to scan and the number of bins. And displays a graph of the resulting self-correlation analysis.
The number of bins represents the precision depending on the number of data points you have. If you use a number of bins too great compared to the number of data points you have, the bins might have too few data points in them and the result will be meaningless.
The csv file just has to be defined as a normal .csv file. If the file is in .dat format, the two columns must be seperated by a single tabulation. 
If you are not sure whether your data file is in a correct format, put your data in two columns in Excel and save it as a .csv file and it will work.
The program works perfectly if the input for the lower and upper bound of the period scanned are positive and if the number of bins is a natural number (!=0). However, it is not yet completely error proof if the input are not in the correct format, it will be fixed in later updates.
Upcoming changes: better error handling in case of incorrect/invalid input given, it is a work in progress.
This program is best used as a complementary to a Fourier analysis software.
