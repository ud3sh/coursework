package fpinscala.datastructures

import scala.annotation.tailrec

sealed trait List[+A] // `List` data type, parameterized on a type, `A`
case object Nil extends List[Nothing] // A `List` data constructor representing the empty list
case class Cons[+A](head: A, tail: List[A]) extends List[A] // Another data constructor, representing nonempty lists. Note that `tail` is another `List[A]`, which may be `Nil` or another `Cons`.

object List { // `List` companion object. Contains functions for creating and working with lists.
  def sum(ints: List[Int]): Int = ints match { // A function that uses pattern matching to add up a list of integers
    case Nil => 0 // The sum of the empty list is 0.
    case Cons(x,xs) => x + sum(xs) // The sum of a list starting with `x` is `x` plus the sum of the rest of the list.
  } 
  
  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x,xs) => x * product(xs)
  }
  
  def apply[A](as: A*): List[A] = // Variadic function syntax
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  val x = List(1,2,3,4,5) match {
    case Cons(x, Cons(2, Cons(4, _))) => x
    case Nil => 42 
    case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
    case Cons(h, t) => h + sum(t)
    case _ => 101 
  }

  def append[A](a1: List[A], a2: List[A]): List[A] =
    a1 match {
      case Nil => a2
      case Cons(h,t) => Cons(h, append(t, a2))
    }

  def foldRight[A,B](as: List[A], z: B)(f: (A, B) => B): B = // Utility functions
    as match {
      case Nil => z
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }
  
  def sum2(ns: List[Int]) = 
    foldRight(ns, 0)((x,y) => x + y)
  
  def product2(ns: List[Double]) = 
    foldRight(ns, 1.0)(_ * _) // `_ * _` is more concise notation for `(x,y) => x * y`; see sidebar


  //exercise 3.2
  def tail[A](l: List[A]): List[A] = {
    l match {
      case Nil => throw new RuntimeException("Attempted to obtain tail of empty list")
      case Cons(_, tail) => tail
    }
  }
<<<<<<< HEAD

  //exercise 3.3
  def setHead[A](l: List[A], h: A): List[A] = {
    l match {
      case Nil => List(h) //the answer throws an exception. How would you express an empty list, and set head ? s
      case Cons(oldHead, tail) => Cons(h, tail)
    }
  }

  //exercise 3.4 (the answer in this case doesn't throw exception when l.size<n)
  def drop[A](l: List[A], n: Int): List[A] = {
    if (n == 0){
      l
    } else {
	    l match {
	      case Nil => throw new RuntimeException("Cannot drop " + n + " elements in a smaller list")
	      case Cons(_, tail) => drop(tail, n-1)
	    }      
    }
  }

  //exercise 3.5 
  /*answer section solution seems weird
   consider: dropWhile(List(3, 4, 4, 5, 6, 1, 7), (n:Int)=>{ n % 2 == 1}) 
   project answers
   scala> dropWhile(List(3, 4, 4, 5, 6, 1, 7), (n:Int)=>{ n % 2 == 1})
res0: fpinscala.datastructures.List[Int] = Cons(4,Cons(4,Cons(5,Cons(6,Cons(1,Cons(7,Nil))))))
   project exercises
   scala> dropWhile(List(3, 4, 4, 5, 6, 1, 7), (n:Int)=>{ n % 2 == 1})
res2: fpinscala.datastructures.List[Int] = Cons(4,Cons(4,Cons(6,Nil)))
   i.e my answer is (4, 4, 6) which is correct, given answer is (4, 4, 5, 6, 1, 7)  
   
   ^^ the answer is correct, misunderstood dropwhile
   */
  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = {
    l match {
      case Cons(head, tail) => if (f(head)) dropWhile(tail, f) else Cons(head,dropWhile(tail, f))
      case Nil => l
    }
  }
  
  //exercise 3.6
  def init[A](l: List[A]): List[A] = {
    l match {
      case Nil => throw new RuntimeException("Attempted to get initial elements of a null list")
      case Cons(_, Nil) => l
      case Cons(head, tail) => Cons(head, init(tail))
    }
  }

  //exercise 3.9
  def length[A](l: List[A]): Int = {
    foldRight(l, 0)((h,tailAcc) => 1 + tailAcc)
  }

  //exercise 3.10
  @tailrec
  def foldLeft[A,B](l: List[A], z: B)(f: (B, A) => B): B = {
    l match {
      case Nil=> z
      case Cons(h, tail) => foldLeft(tail,f(z, h))(f)
    } 
  }
  
  //exercise 3.11a
  def sumFL(xs: List[Int]): Int = {
    foldLeft(xs, 0)(_+_)
  }
  
  //exercise 3.11b
  def productFL(xs: List[Int]): Int = {
    foldLeft(xs, 1)(_*_)
  }  
  
  //exercise 3.11c
  def lengthFL[A](xs: List[A]): Int = {
    foldLeft(xs, 1)((acc,_)=>(acc+1))
  }
  
  def reverse[A](xs: List[A]): List[A] = {
    foldLeft(xs, List[A]())((tail,h)=>Cons(h, tail))
  }

  def map[A,B](l: List[A])(f: A => B): List[B] = sys.error("todo")
}


//Exercise 3.1
//1 + 2 = 3

//Exercise 3.7
//Unless foldright is modified, there is no way to short circut * 0

=======

  //exercise 3.3
  def setHead[A](l: List[A], h: A): List[A] = {
    l match {
      case Nil => List(h) //the answer throws an exception. How would you express an empty list, and set head ? s
      case Cons(oldHead, tail) => Cons(h, tail)
    }
  }

  //exercise 3.4 (the answer in this case doesn't throw exception when l.size<n)
  def drop[A](l: List[A], n: Int): List[A] = {
    if (n == 0){
      l
    } else {
	    l match {
	      case Nil => throw new RuntimeException("Cannot drop " + n + " elements in a smaller list")
	      case Cons(_, tail) => drop(tail, n-1)
	    }      
    }
  }

  //exercise 3.5 
  /*answer section solution seems weird
   consider: dropWhile(List(3, 4, 4, 5, 6, 1, 7), (n:Int)=>{ n % 2 == 1}) 
   project answers
   scala> dropWhile(List(3, 4, 4, 5, 6, 1, 7), (n:Int)=>{ n % 2 == 1})
res0: fpinscala.datastructures.List[Int] = Cons(4,Cons(4,Cons(5,Cons(6,Cons(1,Cons(7,Nil))))))
   project exercises
   scala> dropWhile(List(3, 4, 4, 5, 6, 1, 7), (n:Int)=>{ n % 2 == 1})
res2: fpinscala.datastructures.List[Int] = Cons(4,Cons(4,Cons(6,Nil)))
   i.e my answer is (4, 4, 6) which is correct, given answer is (4, 4, 5, 6, 1, 7)  
   
   ^^ the answer is correct, misunderstood dropwhile
   */
  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = {
    l match {
      case Cons(head, tail) => if (f(head)) dropWhile(tail, f) else Cons(head,dropWhile(tail, f))
      case Nil => l
    }
  }
  
  //exercise 3.6
  def init[A](l: List[A]): List[A] = {
    l match {
      case Nil => throw new RuntimeException("Attempted to get initial elements of a null list")
      case Cons(_, Nil) => l
      case Cons(head, tail) => Cons(head, init(tail))
    }
  }
  
  //exercise 3.7
  /* no because fold right must traverse the entire list before evaluating anything. The second argument of the passed in function requires foldRight to be evaluated
     recall:
     def foldRight[A,B](as: List[A], z: B)(f: (A, B) => B): B =
		as match {
		case Nil => z
		case Cons(x, xs) => f(x, foldRight(xs, z)(f))
	}
	No matter how f is defined foldRight will always need to be evaluated
  */
  //exercise 3.8
  //you get back the original list

  //exercise 3.9
  def length[A](l: List[A]): Int = {
    foldRight(l, 0)((h,tailAcc) => 1 + tailAcc)
  }

  //exercise 3.10
  @tailrec
  def foldLeft[A,B](l: List[A], z: B)(f: (B, A) => B): B = {
    l match {
      case Nil=> z
      case Cons(h, tail) => foldLeft(tail,f(z, h))(f)
    } 
  }
  
  //exercise 3.11a
  def sumFL(xs: List[Int]): Int = {
    foldLeft(xs, 0)(_+_)
  }
  
  //exercise 3.11b
  def productFL(xs: List[Int]): Int = {
    foldLeft(xs, 1)(_*_)
  }  
  
  //exercise 3.11c
  def lengthFL[A](xs: List[A]): Int = {
    foldLeft(xs, 1)((acc,_)=>(acc+1))
  }
  
  //exercise 3.12
  def reverse[A](xs: List[A]): List[A] = {
    foldLeft(xs, List[A]())((tail,h)=>Cons(h, tail))
  }
  
  //excercise 3.13a (try again)
  def foldLeftViaFoldRight[A,B](xs: List[A], z: B)(f: (B, A) => B): B = {
    foldRight(reverse(xs), z)((b,a)=>f(a,b))
  }
  
//  def foldRightViaFoldLeft[A,B](xs: List[A], z: B)(f: (A, B) => B): B = {
//  }
  
  //excercise 3.14

  def appendViaFoldRight[A](xs1: List[A], xs2:List[A]): List[A] = {
    foldRight(xs1, xs2)((i, acc)=> Cons(i, acc))
  } 
  
  def appendViaFoldLeft[A](xs1: List[A], xs2:List[A]): List[A] = {
    foldLeft(reverse(xs1), xs2)((acc, i)=> Cons(i, acc))
  } 
  
  //excercise 3.15
  def concat[A](l: List[List[A]]): List[A] = {
    foldLeft(l, List[A]())((acc, nextList)=>append(acc, nextList))
  }
  
  //excercise 3.15-alternative
  def concatViaFoldRight[A](l: List[List[A]]): List[A] = {
    foldRight(l, List[A]())(append)
  }
  
  
  //excercise 3.16
  def addOne(xs:List[Int]):List[Int] = {
    foldRight(xs, List():List[Int])((i, tail)=> Cons(i+1, tail))
  }
  
  //excercise 3.17
  def doubleToString(xs:List[Double]):List[String] = {
    foldRight(xs, List():List[String])((i, tail) => Cons(i.toString, tail))
  }

  //excercise 3.18
  def map[A,B](xs: List[A])(f: A => B): List[B] = {
    foldRight(xs, List():List[B])((i, tail) => Cons(f(i), tail))
  }
  
  //excercise 3.19
  def filter[A](xs: List[A])(f: A => Boolean): List[A] = {
     foldRight(xs, List():List[A])( (i, tail) => if (f(i)) Cons(i, tail) else tail)
  }
  
  //excercise 3.20
  def flatMap[A,B](xs: List[A])(f: A => List[B]): List[B] = {
    foldRight(xs, List():List[B])((i, tail) => append(f(i), tail))  
  }
  
  //excercise 3.21
  def filterUsingFlatMap[A](xs: List[A])(f: A => Boolean): List[A] = {
    flatMap(xs)( (a)=> if(f(a)) List(a) else List())
  }
  
  //excercise 3.22
  def addIntLists(xs:List[Int], ys:List[Int]):List[Int] = {
     (xs, ys) match {
       case (Cons(a, xs1), Cons(b, ys1)) => Cons(a+b, addIntLists(xs1, ys1))
       case (Nil, Cons(b, ys1)) => Cons(b, ys1)
       case (Cons(a, xs1), Nil) => Cons(a, xs1)
       case (Nil, Nil) => Nil
     }
  }
  
  //excercise 3.23
  def zipWith[T](xs:List[T], ys:List[T])(f: (T,T) => T):List[T] = {
     (xs, ys) match {
       case (Nil, _) => Nil
       case (_, Nil) => Nil
       case (Cons(a, xs1), Cons(b, ys1)) => Cons(f(a,b), zipWith(xs1, ys1)(f))
     }
  }

}


//Exercise 3.1
//1 + 2 = 3

//Exercise 3.7
//Unless foldright is modified, there is no way to short circut * 0

//Exercise 3.8
//what happens when you pass Nil and Cons themselves to foldRight?
//You'll essentially get a copy.  Fold right and data constructors of List walk the tree the same way
