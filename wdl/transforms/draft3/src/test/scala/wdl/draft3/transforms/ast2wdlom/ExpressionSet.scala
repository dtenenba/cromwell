package wdl.draft3.transforms.ast2wdlom

import wdl.model.draft3.elements.ExpressionElement._
import wom.values._

object ExpressionSet {
  val stringLiteral = PrimitiveLiteralExpressionElement(WomString("hello"))
  val intLiteral = PrimitiveLiteralExpressionElement(WomInteger(5))
  val floatLiteral = PrimitiveLiteralExpressionElement(WomFloat(5.5))
  val booleanLiteral = PrimitiveLiteralExpressionElement(WomBoolean(true))

  val addExpression = Add(intLiteral, intLiteral)
  val subtractExpression = Subtract(intLiteral, intLiteral)
  val multiplyExpression = Multiply(intLiteral, intLiteral)
  val divideExpression = Divide(intLiteral, intLiteral)
  val remainderExpression = Remainder(intLiteral, intLiteral)

  val pairExpression = PairLiteral(intLiteral, stringLiteral)

  val tenVariableLookup = IdentifierLookup("ten")
  val pairExpressionMemberAccess = ExpressionMemberAccess(pairExpression, Vector("left"))

  val unaryExpressions = LogicalNot(LessThan(UnaryPlus(intLiteral), UnaryNegation(intLiteral)))

  val comparisonExpression =
    LogicalOr(
      LogicalOr(
        Equals(
          IdentifierLookup("a"),
          IdentifierLookup("b")
        ),
        LogicalAnd(
          LogicalAnd(
            NotEquals(
              IdentifierLookup("c"),
              IdentifierLookup("d")
            ),
            LessThan(
              IdentifierLookup("e"),
              IdentifierLookup("f")
            )
          ),
          LessThanOrEquals(
            IdentifierLookup("e"),
            IdentifierLookup("f")
          )
        )
      ),
      LogicalAnd(
        GreaterThan(
          IdentifierLookup("g"),
          IdentifierLookup("h")
        ),
        GreaterThanOrEquals(
          IdentifierLookup("g"),
          IdentifierLookup("h")
        )
      )
    )

  val chainIdentifierAccess = IdentifierMemberAccess("a", "b", Vector("c", "d", "e", "f", "g"))
  val chainPairAccess = ExpressionMemberAccess(pairExpression, Vector("a", "b", "c", "d", "e", "f", "g"))

  val arrayOfIs = ArrayLiteral(Vector(intLiteral, Multiply(intLiteral, intLiteral), UnaryNegation(intLiteral)))
  val objectLiteralExpression = ObjectLiteral(Map(
    "a" -> intLiteral,
    "b" -> stringLiteral,
    "c" -> pairExpression
  ))
  val mapLiteralExpression = MapLiteral(Map(
    "a" -> intLiteral,
    "b" -> addExpression,
    "c" -> subtractExpression
  ))

  val ternaryIfExpression = TernaryIf(booleanLiteral, intLiteral, intLiteral)
  val zippedExpression = Zip(IdentifierLookup("is"), IdentifierLookup("is"))
  val subbedExpression = Sub(stringLiteral, stringLiteral, stringLiteral)
}
