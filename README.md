# self-correlation-software
Repository containing my personal side project consisting of a self-correlation software used to analyze periodical behavior in data

This code doesn't have a GUI yet but it is a work in progress. The data file provided is data from a variable star with as first column time and second column light magnitude. 
The program still uses terminal command promps. To use it for actual data analysis, one just needs to replace the data in the csv file by what one wants to analyse. The program works best if it analyses the change of a variable over time. The first column has to be time (in days or whatever unit one wants to use) and the second column has to be the variable analyzed.
When starting the program, the user will be prompted the bounds of the period analysis, lower then upper bound. Then the user will be prompted the number of bins wanted, aka the precision. However I recommand to try not to have beens smaller than at least 5 units of time otherwise the analysis kind of loses meaning as there might not be enough data in each bin.
Then the program outputs the bin's lower bound, upper bound, mean variable variation and the number of elements in the bin for each bin. 
The bin with the smallest mean variable variation represents the time interval in which the main period of the data is present if there is a periodical behavior in the data. 

This program is best used as a complementary to a Fourier analysis software.
