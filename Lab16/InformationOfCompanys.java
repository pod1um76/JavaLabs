public class InformationOfCompanys {
    String company;
    double cost;

    public InformationOfCompanys(String company, double cost) {
        this.company = company;
        this.cost = cost;
    }

    public void WriteInfo() {
        System.out.println(this.company + ", " + this.cost);
    }
}
