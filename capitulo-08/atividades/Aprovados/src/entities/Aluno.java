package entities;

public class Aluno {

    private String name;
    private double N1;
    private double N2;

    public Aluno(String name, double n1, double n2) {
        this.name = name;
        N1 = n1;
        N2 = n2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getN1() {
        return N1;
    }

    public void setN1(double n1) {
        N1 = n1;
    }

    public double getN2() {
        return N2;
    }

    public void setN2(double n2) {
        N2 = n2;
    }

    public double mediaAluno(){
        return (N1 + N2) / 2.0;
    }


}
