// **********************************************
// Program1: C Parser
// Course: CS451
// Student Name: Andrew Pyscher
// Instructor: Dr. Cho
// Date of submission: 4/11/23
// Program Description: Scala functions
// Complete functions that were given to use using Scala
// **********************************************


import scala.annotation.tailrec

@main def m() =
    // #1
    val l4 = List(1, 2, 3, 4)
    println("#1")
    println(member(2, l4))
    println(member(5, l4))

    // #2
    val l1 = List('A', 'B', 'C', 'D')
    val l2 = List('A', 'C', 'D')
    val l3 = List('A', 'C', 'D')
    println("#2")
    println(equalsimp(l1, l2))
    println(equalsimp(l3, l2))
    println(equalsimp(l3, List('D', 'A', 'C')))
    println(equalsimp(l1, List('D', 'A', 'C', 'B')))
    // #3
    println("#3")
    println(append(l1, l2))
    println(append(l3, l1))
    val l8 = List(1, 2, 3, 4)
    val l5 = List(10, 11)
    println(append(l8, l5))
    // #4
    println("#4")
    println(quadratic_roots(1, -2, -3))
    // #5
    println("#5")
    println(factorial(10))
    //println(factorial(10000)) // Stack Overflow
    // #6
    println("#6")
    println(tailFactorial(10000)) // much faster and no stack overflow
    // #7
    val add2 = (x: Int) => x + 2
    val times3 = (x: Int) => x * 3
    println("#7")
    println(h(add2, times3)(4))
    // #8
    val l6 = List(1, 2, 3, 4)
    println("#8")
    println(third_list(l6))
    println(third_list(List(1,2,(3,4,5), 6, 7)))
    // #9
    println("#9")
    println(nth_list(2, l1))
    println(nth_list(2, List(1,2,(3,4,5), 6, 7)))
  // checking for member
  // [[HW1: (10 pts) complete the member function
def member(a: Int, b: List[Int]): Boolean = {
    // iterate through each element in the list and see if a matches any of them
    for(i<-b){
    if(i==a)
    return true
    }
    return false
}
    // HW1]]

    // [[HW2: (10 pts) complete the list equality function
    // Assume that list of chars are passed as parameters
def equalsimp(a: List[Char], b: List[Char]): Boolean = {
    // check if the sizes are the same
    if(a.size != b.size)
        return false
// iterate through both lists, and see if the elements match
    for(i<-a; i<-b){
        if(a != b)
            return false
    }
    return true
}
    // HW2]]

    // [[HW3: (10 pts) Complete the append function
def append[A](l1: List[A], l2: List[A]): List[A] = {
    // add the elements in l2 to l1
    var newList = l1
    for(i<-l2){
        newList =  i :: newList 
    }
    newList
    }
    // HW3]]

    // [[HW4: (10 pts) Complete the quadratic_roots function
    // hint: for square root, you can call math.sqrt() function
    def quadratic_roots(a: Int, b: Int, c: Int) = {
    // quadratic formula (b^2 -4ac)/2a
    val root_part = (Math.sqrt(b*b - (4*a*c))) / (2*a)
    // -b/2a 
    val minus_b = (-1*b) / (2*a)
    List(minus_b + root_part, minus_b - root_part)
}
    // HW4]]

    // [[HW5: (10 pts) Complete the factorial functin using recursion
    
def factorial(n: Int): BigInt = {
    // basic factorial using recursion
    if(n == 0)
        1
    else
        n * factorial(n-1)

}
    // HW5]]

    // [[HW6: (10 pts) Complete the factorial function with tail recursion
def factHelper(n: Int, factPartial: BigInt): BigInt = {
    // factorial function that uses helper, was in the slides
    if(n<=1)
        factPartial
    else
        factHelper(n-1, n * factPartial)
    } // helper function
    def tailFactorial(n: Int): BigInt = {
        factHelper(n, 1)
}
    // HW6]]


    // Function composition
    // this was already done
def h[A, B, C](f: B => C, g: A => B): A => C ={
    x => f(g(x))
    }

    // [[HW8: (10 pts) Complete the third_list function
def third_list[A](ls: List[A]): A = {
    // get the third element in the list
    ls.tail.tail.head
}
    // HW8]]

    // [[HW9: (20 pts) Complete the nth_list function
    // this function returns the nth element in the list
def nth_list[A](n: Int, ls: List[A]): A = {
    // simliar to factorial, use recursion to find the nth element
    if(n == 1)
        ls.head
    else
        nth_list(n-1, ls.tail)
}
  // HW9]]
