#Java-adamant

A library enhancing the JRE with the core functionality it should have had for a long time. 

The core ideas are: 

* Collections are value objects and therefore immutable (read-only; changes create new collections, the originating one kept unchanged)
* `null` is avoided as far as possible - it is not considered as a valid value (e.g. in collections)
* Interfaces should be narrow/minimal (1 method for most of em) - a rich set of utile functions comes from combining and composing minimal interfaces
* Reflection is pain - it is replaced with concepts to avoid them wherever one is found 
* There is no natural order - order depends on the point of view
* `Iterator` / `Iterable` is a badly designed and needs a replacement - The are supported as 'legacy' anyway.

### About
'jadamant' is a made-up word conbined out of 'Java' and 'Adamant'. Inspired by the Master of Orion II Adamantium plating Adamant should symbolise the immutable and solid character and the hole philosophy of this project.

### Working with Lists
``` java
// list construction
List.with.noElements(); // a empty list
List.with.element(1); // a list with a single element - the integer 1
List.with.elements(1,2,3,4); // a list holding the numbers 1 to 4
```

to be continued...