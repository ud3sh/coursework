package fpinscala.datastructures

sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]


object Tree {
  
  //3.25
  def size[A](t: Tree[A]):Int = {
    t match {
      case Leaf(_) => 1
      case Branch(left, right) => 1 + size(left) + size(right)
    }
  }
  
  
  //3.26
  def maximum(t: Tree[Int]): Int = {
    t match {
      case Leaf(value) => value
      case Branch(left, right) => maximum(left).max(maximum(right))
    }    
  }
  
  //3.27
  def depth[A](t: Tree[A]):Int = {
    t match {
      case Leaf(value) => 1
      case Branch(left, right) => 1 + depth(left).max(depth(right))
    }     
  }
  
  //3.28
  def map[A](t: Tree[A], f:Tree[A]=>Tree[A]):Tree[A] = {
    t match {
      case Leaf(value) => f(Leaf(value))
      case Branch(left, right) => Branch(map(left,f), map(right,f))
    }   
  }
  
  //3.29
  def fold[A,B](t: Tree[A], initial:B)(f:(A,B)=>B):B = {
    t match {
      case Leaf(value) => f(value, initial)
      case Branch(left, right) => fold(right, fold(left, initial)(f))(f)
    }     
  }
  
  def sizeViaFold[A](t: Tree[A]):Int = {
    fold(t, 0)((a,b)=>b+1)
  }


}