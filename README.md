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
that are opened and closed properly. Eg.: "{[()]}" and "((()))" are valid sequences, instead "}()" and "{)}" are not.

In [ParenthesesExercise.java](exercise/src/main/java/com/buenbit/exercise/ParenthesesExercise.java) you'll find a
template of the method that you should implement. Once you're done, make sure that the unit tests in
[ParenthesesExerciseTest.java](exercise/test/java/com/buenbit/exercise/ParenthesesExerciseTest.java) pass successfully.

## Is inside figure
For this challenge, given a binary matrix (Full of 1s and 0s) that represent a canvas, it is requested to write down a
method named *isInside* that receives two integer values, representing the row and the column of the matrix
respectively, and returns a boolean value, indicating if the point given by such coordinates is inside a figure made by
an outline of 1s or not.

Given the following matrix, and being X the point represented by coordinates (3, 10):
```
"00000000000000000000"
"01111111111111111110"
"01000000000000000010"
"0100000000X000000010"
"01000000000000000010"
"01111111111111111110"
"00000000000000000000"
```
The X is inside of square figure determined by 1s. In the following example: 
```
"00000000000000000000"
"01111111111111111110"
"01000000000000000010"
"01000000000000000010"
"01000000000000000010"
"01111111111111111110"
"0000000000X000000000"
```
The X is outside of the square figure determined by 1s (Coordinate (6, 10)).

In [IsInsideFigureExercise.java](exercise/src/main/java/com/buenbit/exercise/IsInsideFigure.java) you'll find a
template of the method that you should implement. Once you're done, make sure that the unit tests in
[IsInsideFigureExerciseTest.java](exercise/test/java/com/buenbit/exercise/IsInsideFigureTest.java) pass successfully.

## Some useful links
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.3/maven-plugin/reference/html/#build-image)

