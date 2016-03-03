package javasst

/**
  * Enumeration of possible types.
  *
  * @author Julian Schlichtholz
  * @version 1.0.0
  */
object JavaSstType extends Enumeration {
  type JavaSstType = Value

  val CLASS, CURLY_BRACE_OPEN, CURLY_BRACE_CLOSE, FIELD, FINAL, EQUALS, SEMICOLON, PUBLIC, PARENTHESIS_OPEN,
  PARENTHESIS_CLOSE, COMMA, IF, INTEGER, ELSE, WHILE, RETURN, EQUALS_EQUALS, LESS_THAN, LESS_THAN_EQUALS, GREATER_THAN,
  GREATER_THAN_EQUALS, PLUS, MINUS, TIMES, SLASH, COMMENT_START, COMMENT_STOP, IDENT, NUMBER, EOF, ASSIGNMENT, CALL,
  CONSTANT, FUNCTION, IF_ELSE, PARAMETER, VARIABLE, VOID = Value
}