package fp

import fp.chapters.three.{ monoids }

object Hello extends App {
  import monoids.intAddition.op
  println(op(op(1,2), 3) == op(1,op(2, 3)) )
}
