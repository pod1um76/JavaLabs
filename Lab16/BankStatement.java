import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BankStatement {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        int it = 2;
        String line = " ";
        double revenue = 0;
        double cost = 0;
        boolean flag = false;

        try {
            ArrayList<Statement> statementList = new ArrayList<Statement>();
            ArrayList<InformationOfCompanys> informationOfCompanys = new ArrayList<InformationOfCompanys>();
            File file = new File("Data\\movementList.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            line = bufferedReader.readLine();
            while (it < 121) {
                line = bufferedReader.readLine();
                statementList.add(new Statement(line));

                revenue += statementList.get(it - 2).revenue;
                cost += statementList.get(it - 2).cost;

                it++;
            }

            informationOfCompanys.add(
                    new InformationOfCompanys(statementList.get(0).descriptionOperations, statementList.get(0).cost));

            for (int i = 0; i < statementList.size(); i++) {
                for (int k = 0; k < informationOfCompanys.size(); k++) {
                    if (statementList.get(i).descriptionOperations.equals(informationOfCompanys.get(k).company)) {
                        informationOfCompanys.get(k).cost += statementList.get(i).cost;
                        flag = true;
                        break;
                    }
                }
                if (flag == false && statementList.get(i).cost != 0) {
                    informationOfCompanys.add(new InformationOfCompanys(statementList.get(i).descriptionOperations,
                            statementList.get(i).cost));
                }
                flag = false;
            }

            System.out.println("Прибыль: " + revenue);
            System.out.println("Убыль: " + cost);

            for (int i = 0; i < informationOfCompanys.size(); i++) {
                informationOfCompanys.get(i).WriteInfo();
            }
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println(it);
        }
    }
}
