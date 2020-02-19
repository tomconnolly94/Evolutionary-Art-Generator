# Evolutionary-Art-Generator

A Java project built to create pieces of digital art and blend them whilst exposing them to external features to simulate the evolutionary process in the creation of the next generation of art. 

## Implementation

* The program largely revolves around a low level object called a "Biomorph". A set are created at program initialisation and displayed to the user in the GUI. The user can choose different methods of evolution (using Gene "Perfect Values" or an average of the parents gene values) by which to breed the Biomorphs together and create a set of unique new gene values for the child Biomorph to Assume.

### Evolution by average

* This simple evolution algorithm simply averages the values for each gene provided by the mother and father Biomorphs, and assigns these new values to the child Biomorph.
* This lacks a certain realism as genes in reality are more binary, as in one gene value will be inherited from either the mother or the father, not a blend of the values of both. Also averaging the values tends to produce boring looking art as extreme gene values are discouraged.

### Evolution by "Perfect Values"

* Mitigation for the problems sene in the *Evolution by average* approach was achieved by providing a second method of evolution based on a set of "Perfect values" that are provided by the user.
* This is an attempt to emulate the effects that the outside world may have on gene selection. The gene value given to the child Biomorph is the value closest to the quivalent perfect value out of the values provided by the mother and the father Biomorph. 
* In this way, the selected value will mutate naturally but the environment (the *Perfect Values*) will slowly influence which gene values are selected.


Usage

* The Project follows an eclipse project setup.
* Simply import the project into your eclipse IDE and build + run. The GUI will appear and manipulation can begin.
