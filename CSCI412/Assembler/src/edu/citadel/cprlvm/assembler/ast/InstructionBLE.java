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
 * the assembly language instruction BLE.
 */
public class InstructionBLE extends InstructionOneArg
  {
    public InstructionBLE(List<Token> labels, Token opCode, Token arg)
      {
        super(labels, opCode, arg);
      }


    public void assertOpCode()
      {
        assertOpCode(Symbol.BLE);
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


    @Override
    public void emit() throws IOException
      {
        emit(OpCode.BLE);
        emit(getDisplacement(getArg()));
      }
  }
