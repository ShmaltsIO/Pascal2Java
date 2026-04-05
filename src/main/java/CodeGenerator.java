import enums.OpCode;

import java.util.LinkedList;
import java.io.*;

public class CodeGenerator {

    LinkedList <Instruction> instructions = new LinkedList <>();

    int label=0;

    public void emit(OpCode opCode) {
        instructions.add(new Instruction(opCode));
    }

    public void emit(OpCode opCode, int operandIndex, int operand) {
        instructions.add(new Instruction(opCode, operandIndex, operand));
    }

    public void emitLabel(int operand, int operandIndex) {
        emit(OpCode.label, operandIndex, operand);
    }

    public int newLabel() {
        return label++;
    }

    public void toJasmin() throws IOException{
        PrintWriter out = new PrintWriter(new FileWriter("Output.j"));
        StringBuilder temp = new StringBuilder();
        temp.append(header);
        while(!instructions.isEmpty()){
            Instruction tmp = instructions.remove();
            temp.append(tmp.toJasmin());
        }
        temp.append(footer);
        out.println(temp);
        out.flush();
        out.close();
    }

    private static final String header = """
            .class public Output\s
            .super java/lang/Object

            .method public <init>()V
             aload_0
             invokenonvirtual java/lang/Object/<init>()V
             return
            .end method

            .method public static run()V
             .limit stack 1024
             .limit locals 256
            """;

    private static final String footer = """
             return
            .end method

            .method public static main([Ljava/lang/String;)V
             invokestatic Output/run()V
             return
            .end method
            """;
}
