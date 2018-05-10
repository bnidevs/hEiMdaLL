# hEiMdaLL
<body background="https://vignette.wikia.nocookie.net/marvelcinematicuniverse/images/f/f7/Heimdall_Armor_DW.jpg/revision/latest?cb=20131229082119">
</body>
### Frank Chen, Tania Cao, Bill Ni

## Background

An exploration of priority queues in Java and their runtimes.

## Description

PriorityQueue - An encapsulation of ArrayList that orders itself based on priority (compareTo values)
<br> <br>
\_storage - The ArrayList container in an instance of PriorityQueue
<br> <br>
add() - Places the parameterized element in its proper place in \_storage
<br> <br>
isEmpty() - Returns true if the instance of PriorityQueue is empty, false otherwise
<br> <br>
peekMin() - Returns the highest priority item in the PriorityQueue
<br> <br>
remove() - Removes and returns the highest priority item in the PriorityQueue

## Reasoning

The API states that __add()__ is an *O(1)* runtime method, and __peekMin()__ and __remove()__ are *O(n)* runtime methods.
<br> <br>
However, we decided on making __add()__ *O(n)* and __peekMin()__ and __remove()__ *O(1)*. This is because the use of a queue often necessitates removing all the elements that the user(s) has added. So if we switch __add()__ and __remove()__ in terms of runtimes, it would make no difference. But __peekMin()__ has to be used at least once in an instance of a PriorityQueue, otherwise there would be no point in writing the method.
<br> <br>
This is where writing __peekMin()__ as *O(1)* makes a difference. It would optimize peeking during the instance of a PriorityQueue.