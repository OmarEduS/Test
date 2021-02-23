public class Instruction {
    //Variables
    String name;
    String hex;

    public Instruction(String name, String hex) {
        this.name = name;
        this.hex = hex;
    }

    public void putName(String name) {
        this.name = name;
    }

    public void putHex(String hex) {
        this.hex = hex;
    }

    public String getName(){
        return name;
    }

    public String getHex(){
        return hex;
    }

    public void printInst() {
        System.out.println(name + " " + hex);
    }
    //Branch Comment
}
