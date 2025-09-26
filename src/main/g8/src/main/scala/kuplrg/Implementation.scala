package kuplrg

object Implementation extends Template {

  /** This is the playground for you to run your implementation. Do whatever you
    * want here and run `sbt run` to see the result.
    */
  @main def playground: Unit = {
    println("------------------- PLAYGROUND -------------------")

    // You can check your implementation here.
    val accept = tm_an_bn_cn.accept
    println(s"tm_an_bn_cn.accept(\"abc\")    = ${accept("abc")}")
    println(s"tm_an_bn_cn.accept(\"aabbcc\") = ${accept("aabbcc")}")
    println(s"tm_an_bn_cn.accept(\"abcabc\") = ${accept("abcabc")}")

    println("--------------------------------------------------")
  }

  import HeadMove.*

  // TM accpeting L = { a^n b^n c^n | n ≥ 0 }
  val tm_an_bn_cn: TM = TM(
    states = Set(0, 1, 2, 3, 4, 5),
    symbols = Set('a', 'b', 'c'),
    tapeSymbols = Set('a', 'b', 'c', 'X', 'Y', 'Z', 'B'),
    trans = Map(
      (0, 'a') -> (1, 'X', R),
      (0, 'Y') -> (4, 'Y', R),
      (0, 'B') -> (5, 'B', L),
      (1, 'a') -> (1, 'a', R),
      (1, 'Y') -> (1, 'Y', R),
      (1, 'b') -> (2, 'Y', R),
      (2, 'b') -> (2, 'b', R),
      (2, 'Z') -> (2, 'Z', R),
      (2, 'c') -> (3, 'Z', L),
      (3, 'a') -> (3, 'a', L),
      (3, 'b') -> (3, 'b', L),
      (3, 'Y') -> (3, 'Y', L),
      (3, 'Z') -> (3, 'Z', L),
      (3, 'X') -> (0, 'X', R),
      (4, 'Y') -> (4, 'Y', R),
      (4, 'Z') -> (4, 'Z', R),
      (4, 'B') -> (5, 'B', L),
    ),
    initState = 0,
    blank = 'B',
    finalStates = Set(5),
  )

  // TM accepting L = { a^{n^2} | n ≥ 0 }
  def tm_square: TM = ???

  // TM accepting L = { a^n | n is a fibonacci number }
  def tm_fib: TM = ???

  // TM accepting L = { w \in {a, b, c}* | N_a(w) = N_b(w) = N_c(w) }
  def tm_eq_abc: TM = ???

  // TM for a function f(w ∈ {0, 1}*) = w' where w' = w - 1 if w starts with 1,
  // otherwise f(w) is not defined
  def tm_dec: TM = ???

  // TM for a function f(x+y) = z where x,y ∈ {0, 1}* start with 1 and z = x + y
  def tm_add: TM = ???

}
