import enums.OpCode;

public class Instruction {
    OpCode opCode;
    int operandIndex;
    int operand;

    public Instruction(OpCode opCode) {
        this.opCode = opCode;
    }

    public Instruction(OpCode opCode, int operandIndex, int operand) {
        this.opCode = opCode;
        this.operand = operand;
        this.operandIndex = operandIndex;
    }

    public String toJasmin () {
        String temp="";
        switch (opCode) {
            case ldc : temp = " ldc " + operand + "\n"; break;
            case invokestatic :
               if( operand == 1)
                  temp = " invokestatic " + "Output/print(I)V" + "\n";
               else
                  temp = " invokestatic " + "Output/read()I" + "\n"; break;
            case iadd : temp = " iadd " + "\n"; break;
            case imul : temp = " imul " + "\n"; break;
            case idiv : temp = " idiv " + "\n"; break;
            case isub : temp = " isub " + "\n"; break;
            case ineg : temp = " ineg " + "\n"; break;
            case iconst: temp = " iconst_" + operandIndex + "\n"; break;
            case istore : temp = " istore_" + operandIndex + "\n"; break;
            case iload : temp = " iload_" + operandIndex + "\n"; break;
            case bipush: temp = " bipush " + operand + "\n"; break;
            case astore: temp = " astore_" + operandIndex + "\n"; break;
            case aload: temp = " aload_" + operandIndex + "\n"; break;
            case label : temp = "L" + operand + ":\n"; break;
        }
    return temp;
    }
}
