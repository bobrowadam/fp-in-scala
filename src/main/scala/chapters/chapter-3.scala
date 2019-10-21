package fp.chapters.three
import java.awt.print.Book

trait Monoid[A] {
  def op(a1: A, a2: A): A
  def zero: A
}

object monoids {
  val intAddition: Monoid[Int] =
    new Monoid[Int] {
      def op(a1: Int, a2: Int): Int = a1 + a2
      val zero = 0
    }

  val intMultiplication: Monoid[Int] =
    new Monoid[Int] {
      def op(a1: Int, a2: Int): Int = a1 * a2
      val zero = 1
    }

  val booleanOr: Monoid[Boolean] =
    new Monoid[Boolean] {
      def op(a1: Boolean, a2: Boolean) = a1 || a2
      val zero = false
    }

  val booleanAnd: Monoid[Boolean] =
    new Monoid[Boolean] {
      def op(a1: Boolean, a2: Boolean) = a1 && a2
      val zero = true
    }

  def optionMonoid[A]: Monoid[Option[A]] =
    new Monoid[Option[A]] {
      def op(a1: Option[A], a2: Option[A]) = a1 orElse a2
      val zero = None
    }

  def endoMonoid[A]: Monoid[A => A] = {
    new Monoid[A => A] {
      def op(f1: A => A, f2: A => A) = f1 compose f2
      // def op(f1: A => A, f2: A => A) = (a: A) => f1(f2(a))
      val zero: A => A = (z: A) => z
    }
  }
}
