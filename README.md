# Buenbit technical challenge
Welcome to Buenbit technical challenge! In here you'll find all the necessary info to successfully complete the
technical challenges pointed out by your interviewers. Good luck!

### Table of contents
* [About](#about)
* [Well-formed expression](#well-formed-expression)
* [Is inside figure](#is-inside-figure)
* [Some useful links](#some-useful-links)

## About
This document contains the indications to be followed by the candidate to be able to successfully complete the technical
challenges pointed out by Buenbit interviewers.
Next, you'll be able to have a detailed description on each one of the exercises. Please refer to the one indicated by
Buenbit via email.

## Well-formed expression
For this challenge, it is requested to write down a method named *isValid* that receives a *String* parameter, and
returns a boolean value, indicating if the string content is well-formed or not. What does it mean to be well-formed in
this case? For the string to be valid or well-formed, it should contain a sequence of braces, brakets and or parentheses
that are opened and closed properly. Eg.: `"{[()]}"` and `"((()))"` are valid sequences, instead `"}()"` and `"{)}"` are
not.

In [ParenthesesExercise.java](https://github.com/buenbit/exercise/blob/master/src/main/java/com/buenbit/exercise/ParenthesesExercise.java)
you'll find a  template of the method that you should implement. Once you're done, make sure that the unit tests in
[ParenthesesExerciseTest.java](https://github.com/buenbit/exercise/blob/master/src/test/java/com/buenbit/exercise/ParenthesesExerciseTest.java) pass successfully.

## Is inside figure
For this challenge, given a binary matrix (Full of 1s and 0s) that represent a canvas, it is requested to write down a
method named *isInside* that receives two integer values, representing the row and the column of the matrix
respectively, and returns a boolean value, indicating if the point given by such coordinates is inside a figure made by
an outline of 1s or not.

Given the following matrix, and being X the point represented by coordinates (2, 5):
```
"0 0 0 0 0 0 0 0 0 0 0"
"0 1 1 1 1 1 1 1 1 0 0"
"0 1 0 0 0 X 0 0 1 0 0"
"0 1 0 1 1 1 1 0 1 0 0"
"0 1 0 1 0 0 1 1 1 0 0"
"0 1 0 1 0 0 0 0 0 0 0"
"0 1 0 1 0 0 1 1 1 0 0"
"0 1 0 1 1 1 1 0 1 0 0"
"0 1 0 0 0 0 0 0 1 0 0"
"0 1 1 1 1 1 1 1 1 0 0"
"0 0 0 0 0 0 0 0 0 0 0"
```
The X is inside of square figure determined by 1s. In the following example: 
```
"0 0 0 0 0 0 0 0 0 0 0"
"0 1 1 1 1 1 1 1 1 0 0"
"0 1 0 0 0 0 0 0 1 0 0"
"0 1 0 1 1 1 1 0 1 0 0"
"0 1 0 1 0 0 1 1 1 0 0"
"0 1 0 1 0 X 0 0 0 0 0"
"0 1 0 1 0 0 1 1 1 0 0"
"0 1 0 1 1 1 1 0 1 0 0"
"0 1 0 0 0 0 0 0 1 0 0"
"0 1 1 1 1 1 1 1 1 0 0"
"0 0 0 0 0 0 0 0 0 0 0"
```
The X is outside of the square figure determined by 1s (Coordinate (5, 5)).

IMPORTANT: The figure only contains orthogonal lines, meaning that the lines made by the 1s will form only angles of 90??
between them, and that there will not be any diagonal lines in the figure. Also, have into account that, if there is a
figure in the matrix, then the figure is closed, meaning that if you follow the trail of 1s in the figure, there will
not be any 0s between two consecutive 1s in the outline of the figure. Last, but not least, there can be at most 1
figure inside the matrix.

In [IsInsideFigureExercise.java](https://github.com/buenbit/exercise/blob/master/src/main/java/com/buenbit/exercise/IsInsideFigureExercise.java) you'll find a
template of the method that you should implement. Take into account that IsInsideFigureExercise has a constructor that
receives a `short[][]` matrix that should be used in `isInside()` method. Once you're done, make sure that the unit
tests in [IsInsideFigureExerciseTest.java](https://github.com/buenbit/exercise/blob/master/src/main/java/com/buenbit/exercise/IsInsideFigureExerciseTest.java)
pass successfully.

## Some useful links
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.3/maven-plugin/reference/html/#build-image)

