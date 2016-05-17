package edu.citadel.cprl.ast;


import edu.citadel.compiler.CodeGenException;
import edu.citadel.compiler.ConstraintException;
import edu.citadel.compiler.ErrorHandler;
import edu.citadel.compiler.InternalAssertion;
import edu.citadel.compiler.Position;
import edu.citadel.cprl.Symbol;
import edu.citadel.cprl.Token;
import edu.citadel.cprl.Type;

import java.io.IOException;


/**
 * The abstract syntax tree node for a negation expression.  A negation
 * expression is a unary expression where the operator is either "-" or "+".
 * A simple example would be "-x".
 */
public class NegationExpr extends UnaryExpr
  {
    /**
     * Construct a negation expression with the specified operator ("-") and operand.
     */
    public NegationExpr(Token operator, Expression operand)
      {
// ...
      }


    @Override
    public void checkConstraints()
      {
// ...
      }


    @Override
    public void emit() throws CodeGenException, IOException
      {
// ...
      }
  }
