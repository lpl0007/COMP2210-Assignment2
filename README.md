# COMP2210-Assignment2

### This assignment focuses on implementing the methods of a class much like java.util.Collections. The Selector.java file defines a class with static methods that implement polymorphic algorithms that operate on and/or return objects that implement the Collection interface. Each method of Selector is clearly specified, is independent of the other methods in the class, and is designed to provide relatively simple functionality. So, this is a great context in which to practice systematic, disciplined development and test-based verification.

- The Selector.java source code file is provided in the startercode folder in Vocareum. You can download Selector.java from Vocareum and work on your local machine.

- The comments provided in Selector.java describe the required behavior of each method.

- The constructor of the Selector class has been written for you and it must not be changed in any way.

- You may add any number of private methods that you like, but you may not add any public method or constructor, nor may you change the signature of any public method or constructor.

- You must not add any fields, either public or private, to the Selector class.

- You must not add, remove, or change in any way the import statements that are already provided. You may not use fully-qualified names to circumvent this restriction, except in the instance noted below.

- You may not use any of the toArrray() methods in the Collection interface and then solve the problem in terms of arrays. More generally, you may not convert the Collection parameter to any other type (with the exception necessary for sorting in kmin and kmax mentioned below). The penalty for violating this constraint will be a deduction of up to 50% of the total points available on the assignment.

- You may not use sorting in any method, except for kmin and kmax. The penalty for violating this constraint will be a deduction of points up to 50% of the total points available on the assignment.

- You do not have to use sorting in kmin and kmax, but doing so makes the solution more straightforward. If you choose to use sorting in these two methods, you must do so by calling the java.util.Collections.sort(List, Comparator) method. You must use the fully-qualified name (no importing Collections) and you are allowed at most two calls to this method - at most one in kmin and at most one in kmax. You are also allowed to use a call to java.util.Collections.reverse(List) in kmax.
