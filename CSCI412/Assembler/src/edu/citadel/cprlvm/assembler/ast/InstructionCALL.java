package edu.citadel.cprlvm.assembler.ast;


import edu.citadel.compiler.ConstraintException;
import edu.citadel.cprlvm.Constants;
import edu.citadel.cprlvm.OpCode;
import edu.citadel.cprlvm.assembler.Symbol;
import edu.citadel.cprlvm.assembler.Token;

import java.util.List;
import java.io.IOException;


/**
 * This class implements the abstract syntax tree for
 * the assembly language instruction CALL.
 */
public class InstructionCALL extends InstructionOneArg
  {
    public InstructionCALL(List<Token> labels, Token opCode, Token arg)
      {
        super(labels, opCode, arg);
      }


    public void assertOpCode()
      {
        assertOpCode(Symbol.CALL);
      }


    public void checkArgType() throws ConstraintException
      {
        checkArgType(Symbol.identifier);
        checkLabelArgDefined();
      }


    public int getArgSize()
      {
        return Constants.BYTES_PER_INTEGER;
      }


    public int getArg2Size()
      {
        return Constants.BYTES_PER_INTEGER;
      }


    @Override
    public void emit() throws IOException
      {
        emit(OpCode.CALL);
        emit(getDisplacement(getArg()));
      }
  }
