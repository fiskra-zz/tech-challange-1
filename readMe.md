# Techical Interview

Three questions are asked to me by a java framework company. Level of questions are really eliminative, from easy to tough. Unfortunately, I 
don't have relevant java8 experience so I failed. I really enjoyed during the interview it was like chit-chatting with my colleague for me.


### Question1

Bubble sort is a simple sorting algorithm that works by repeatedly stepping through the list to be sorted, comparing each pair of adjacent items and swapping them if they are in the wrong order. Implement the algorithm.

After implementation they asked me how would I improve my solution? The answer should be without considering other sorting algorithms like quick sort and merge sort. 

This is also can be a question like swapping numbers without temp variable. You can find detailed description in the link below: 
[swap numbers without temp](http://www.geeksforgeeks.org/swap-two-numbers-without-using-temporary-variable/)

Basically:

* x = x + y; *
* y = x - y; *
* x = x - y; *

 

### Question2

In the Fibonacci sequence of numbers, each number is the sum of the previous two numbers, starting with 1 and 1. This sequence begins:
	1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
Your task is to create a method fibonacciAverage(int COUNT) that returns the average of COUNT first Fibonacci numbers. Let's do this in the Java 8 way, and create an IntStream that emits Fibonacci numbers. Then we can solve the problem simply by calling IntStream.average()

### Question3

Last question is about implementing reading file operation via java8 and doing some search operation. 
First task is to read contents of a file with CSV values (one entry per line) in FileBasedProvider.read()
Once the contents of the file are read, proceed to FileBasedProvider.findAll() and return all the data found in the file as a collection.
After that, look at FileBasedProvider.search(...) and implement it according to the documentation.
