package edu.citadel.cprl.ast;


import edu.citadel.compiler.InternalAssertion;
import edu.citadel.cprl.ScopeLevel;
import edu.citadel.cprl.Token;
import edu.citadel.cprl.Type;


/**
 * The abstract syntax tree node for a parameter declaration.
 */
public class ParameterDecl extends Declaration implements NamedDecl
  {
    private ScopeLevel scopeLevel;
    private int relAddr;      // relative address for this declaration

    private boolean isVarParam;   // true if this is a variable parameter


    /**
     * Construct a parameter declaration with its identifier, type,
     * scope level, and a boolean value that indicates if it is a
     * variable parameter declaration.
     */
    public ParameterDecl(Token paramId, Type type, ScopeLevel scopeLevel, boolean isVarParam)
      {
        super(paramId, type);
        this.scopeLevel = scopeLevel;
        this.isVarParam = isVarParam;
      }


    /**
     * Returns the size (number of bytes) associated with this parameter
     * declaration.  The size of a parameter declaration is the number of
     * bytes associated with its type, except for variable parameters,
     * whose size is the number of bytes of a memory address.  
     */
    public int getSize()
      {
        return isVarParam ? Type.Address.getSize() : getType().getSize();
      }


    @Override
    public ScopeLevel getScopeLevel()
      {
        return scopeLevel;
      }


    /**
     * Sets the relative address for this declaration. <br>
     * Note:  This method should be called before calling method getRelAddr().
     */
    public void setRelAddr(int relAddr)
      {
        this.relAddr = relAddr;
      }


    /**
     * Returns the relative address (offset) associated with this parameter
     * declaration. 
     */
    public int getRelAddr()
      {
        return relAddr;
      }


    /**
     * Returns true if this parameter is a variable parameter.
     */
    public boolean isVarParam()
      {
        return isVarParam;
      }


    @Override
    public void checkConstraints()
      {
        InternalAssertion.check(getType() == Type.Boolean
                             || getType() == Type.Integer
                             || getType() == Type.Char,
                             "Invalid CPRL type in parameter declaration.");
      }
  }