public class Main {
    public static void main(String[] args) {
        Instruction inst= new Instruction("halt","");

        HashFunction<String,String>  hashtable = new HashFunction();
        hashtable.put("halt","00");
        hashtable.put("pop","01");
        hashtable.put("dup","02");
        hashtable.put("exit","03");
        hashtable.put("ret","04");
        hashtable.put("not","0C");
        hashtable.put("and","0D");
        hashtable.put("or","0E");
        hashtable.put("xor","0F");
        hashtable.put("neg","10");
        hashtable.put("inc","11");
        hashtable.put("dec","12");
        hashtable.put("add","13");
        hashtable.put("sub","14");
        hashtable.put("mul","15");
        hashtable.put("div","16");
        hashtable.put("rem","17");
        hashtable.put("shl","18");
        hashtable.put("shr","19");
        hashtable.put("teq","1A");
        hashtable.put("tne","1B");
        hashtable.put("tlt","1C");
        hashtable.put("tgt","1D");
        hashtable.put("tle","1E");
        hashtable.put("tge","1F");

        inst.putHex(hashtable.get(inst.getName()));
        inst.printInst();

    }
}