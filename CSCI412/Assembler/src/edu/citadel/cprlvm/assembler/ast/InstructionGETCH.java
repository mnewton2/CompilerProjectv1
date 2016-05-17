package edu.citadel.cprlvm.assembler.ast;


import edu.citadel.cprlvm.OpCode;
import edu.citadel.cprlvm.assembler.Symbol;
import edu.citadel.cprlvm.assembler.Token;

import java.util.List;
import java.io.IOException;


/**
 * This class implements the abstract syntax tree for
 * the assembly language instruction GETCH.
 */
public class InstructionGETCH extends InstructionNoArgs
  {
    public InstructionGETCH(List<Token> labels, Token opCode)
      {
        super(labels, opCode);
      }


    public void assertOpCode()
      {
        assertOpCode(Symbol.GETCH);
      }


    @Override
    public void emit() throws IOException
      {
        emit(OpCode.GETCH);
      }
  }