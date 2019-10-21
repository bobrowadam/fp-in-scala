package fp

import org.scalatest._
import fp.chapters.three.{monoids}

class chapter3specs extends FlatSpec with Matchers {

  "intAddition" should "hold the Monoid traits" in {
    import monoids.intAddition.{op, zero}
    validateMonoid(op, zero)(1, 2, 3)
  }

  "intMultiplication" should "hold the Monoid traits" in {
    import monoids.intMultiplication.{op, zero}
    validateMonoid(op, zero)(1, 2, 3)
  }

  "booleanOr" should "hold the Monoid traits" in {
    import monoids.booleanOr.{op, zero}
    validateMonoid(op, zero)(true, false, true)
  }

  "booleanAndr" should "hold the Monoid traits" in {
    import monoids.booleanAnd.{op, zero}
    validateMonoid(op, zero)(true, false, true)
  }
  "optionMonoid" should "hold the Monoid traits" in {
    import monoids.optionMonoid
    validateMonoid(optionMonoid[Int].op, optionMonoid[Int].zero)(
      None,
      Some(1),
      Some(2)
    )
  }

  "endoMonoid" should "hold the Monoid traits" in {
    import monoids.endoMonoid
    endoMonoid[Int].op((a: Int) => a + a, (b: Int) => b * b)(2) should equal(8)
    endoMonoid[Int].op(endoMonoid[Int].zero, (a: Int) => a * a)(3) should equal (9)
    endoMonoid[Int].op((a: Int) => a * a, endoMonoid[Int].zero)(3) should equal (9)
  }

  def validateMonoid[T](op: (T, T) => T, zero: T)(x: T, y: T, z: T) = {
    op(op(x, y), z) should equal(op(x, op(y, z)));
    op(zero, z) should equal(z);
    op(z, zero) should equal(z);
  }
}
