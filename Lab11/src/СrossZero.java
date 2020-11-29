import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class СrossZero extends JFrame{
    JFrame jfm = new JFrame();
    JButton jb0 = new JButton(" ");
    JButton jb1 = new JButton(" ");
    JButton jb2 = new JButton(" ");
    JButton jb3 = new JButton(" ");
    JButton jb4 = new JButton(" ");
    JButton jb5 = new JButton(" ");
    JButton jb6 = new JButton(" ");
    JButton jb7 = new JButton(" ");
    JButton jb8 = new JButton(" ");

    JButton[][] jb = {
            {jb0, jb1, jb2},
            {jb3, jb4, jb5},
            {jb6, jb7, jb8}
    };

    JButton game1 = new JButton("P2P");
    JButton game2 = new JButton("P2C");
    Random random = new Random();
    public int x = 0;
    public int n = 0;
    boolean out = false;

    public void GameP2P(){
        game1.setVisible(false);
        game2.setVisible(false);

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                jb[i][j].setVisible(true);
            }
        }
        Step();

    }

    public void CheckX(){ //проверка, есть ли три х в ряд

        //проверка горизонталей
        for(int i=0; i<3; i++){
            if(jb[i][0].getText().equals(jb[i][1].getText()) && jb[i][1].getText().equals(jb[i][2].getText()) && "X".equals(jb[i][0].getText())){
                JOptionPane.showMessageDialog(null, "Игрок 1 выиграл.");
                System.exit(0);
            }
        }

        for(int i=0; i<3; i++){
            if(jb[0][i].getText().equals(jb[1][i].getText()) && jb[1][i].getText().equals(jb[2][i].getText()) && "X".equals(jb[0][i].getText())){
                JOptionPane.showMessageDialog(null, "Игрок 1 выиграл.");
                System.exit(0);
            }
        }
        //проверка диагоналей
        if(jb[0][0].getText().equals(jb[1][1].getText()) && jb[1][1].getText().equals(jb[2][2].getText()) && "X".equals(jb[0][0].getText())){
            JOptionPane.showMessageDialog(null, "Игрок 1 выиграл.");
            System.exit(0);
        }
        if(jb[0][2].getText().equals(jb[1][1].getText()) && jb[1][1].getText().equals(jb[2][0].getText()) && "X".equals(jb[1][1].getText())){
            JOptionPane.showMessageDialog(null, "Игрок 1 выиграл.");
            System.exit(0);
        }
//
        if(x == 8){
            JOptionPane.showMessageDialog(null, "Ничья.");
            System.exit(0);
        }
    }

    public void CheckY(){ //проверка, есть ли три o в ряд

        //проверка горизонталей
        for(int i=0; i<3; i++){
            if(jb[i][0].getText().equals(jb[i][1].getText()) && jb[i][1].getText().equals(jb[i][2].getText()) && "O".equals(jb[i][0].getText())){
                JOptionPane.showMessageDialog(null, "Игрок 2 выиграл.");
                System.exit(0);
            }
        }

        for(int i=0; i<3; i++){
            if(jb[0][i].getText().equals(jb[1][i].getText()) && jb[1][i].getText().equals(jb[2][i].getText()) && "O".equals(jb[0][i].getText())){
                JOptionPane.showMessageDialog(null, "Игрок 2 выиграл.");
                System.exit(0);
            }
        }
        //проверка диагоналей
        if(jb[0][0].getText().equals(jb[1][1].getText()) && jb[1][1].getText().equals(jb[2][2].getText()) && "O".equals(jb[0][0].getText())){
            JOptionPane.showMessageDialog(null, "Игрок 2 выиграл.");
            System.exit(0);
        }
        if(jb[0][2].getText().equals(jb[1][1].getText()) && jb[1][1].getText().equals(jb[2][0].getText()) && "O".equals(jb[1][1].getText())){
            JOptionPane.showMessageDialog(null, "Игрок 2 выиграл.");
            System.exit(0);
        }
//
        if(x == 8){
            JOptionPane.showMessageDialog(null, "Ничья.");
            System.exit(0);
        }
    }

    public void Step(){

        ///////////////////////////////////////////////////////////////
        jb0.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                if(x % 2 == 0){
                    jb0.setText("X");
                    CheckX();
                }
                else{
                    jb0.setText("O");
                    CheckY();
                }
                x++;
            }
        });
        jb1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                if(x % 2 == 0){
                    jb1.setText("X");
                    CheckX();
                }
                else{
                    jb1.setText("O");
                    CheckY();
                }
                x++;
            }
        });
        jb2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                if(x % 2 == 0){
                    jb2.setText("X");
                    CheckX();
                }
                else{
                    jb2.setText("O");
                    CheckY();
                }
                x++;
            }
        });

        ///////////////////////////////////////////////////////////////
        jb3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                if(x % 2 == 0){
                    jb3.setText("X");
                    CheckX();
                }
                else{
                    jb3.setText("O");
                    CheckY();
                }
                x++;
            }
        });
        jb4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                if(x % 2 == 0){
                    jb4.setText("X");
                    CheckX();
                }
                else{
                    jb4.setText("O");
                    CheckY();
                }
                x++;
            }
        });
        jb5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                if(x % 2 == 0){
                    jb5.setText("X");
                    CheckX();
                }
                else{
                    jb5.setText("O");
                    CheckY();
                }
                x++;
            }
        });

        ///////////////////////////////////////////////////////////////
        jb6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                if(x % 2 == 0){
                    jb6.setText("X");
                    CheckX();
                }
                else{
                    jb6.setText("O");
                    CheckY();
                }
                x++;
            }
        });
        jb7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                if(x % 2 == 0){
                    jb7.setText("X");
                    CheckX();
                }
                else{
                    jb7.setText("O");
                    CheckY();
                }
                x++;
            }
        });
        jb8.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                if(x % 2 == 0){
                    jb8.setText("X");
                    CheckX();
                }
                else{
                    jb8.setText("O");
                    CheckY();
                }
                x++;
            }
        });
    }



    public void GameP2C(){
        game1.setVisible(false);
        game2.setVisible(false);

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                jb[i][j].setVisible(true);
            }
        }

        Step1();
    }

    public void Step1(){
        ///////////////////////////////////////////////////////////////
        System.out.println("n = " + n);
        if(n % 2 == 0){
            jb0.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent event){
                    jb0.setText("X");
                    CheckX();
                    n++;
                    Cross();
                }
            });
            jb1.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent event){
                    jb1.setText("X");
                    CheckX();
                    n++;
                    Cross();
                }
            });
            jb2.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent event){
                    jb2.setText("X");
                    CheckX();
                    n++;
                    Cross();
                }
            });

            ///////////////////////////////////////////////////////////////
            jb3.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent event){
                    jb3.setText("X");
                    CheckX();
                    n++;
                    Cross();
                }
            });
            jb4.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent event){
                    jb4.setText("X");
                    CheckX();
                    n++;
                    Cross();
                }
            });
            jb5.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent event){
                    jb5.setText("X");
                    CheckX();
                    n++;
                    Cross();
                }
            });

            ///////////////////////////////////////////////////////////////
            jb6.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent event){
                    jb6.setText("X");
                    CheckX();
                    n++;
                    Cross();
                }
            });
            jb7.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent event){
                    jb7.setText("X");
                    CheckX();
                    n++;
                    Cross();
                }
            });
            jb8.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent event){
                    jb8.setText("X");
                    CheckX();
                    n++;
                    Cross();
                }
            });

        }

    }

    public boolean Step1C(){
        boolean check = false;

        for(int i=0; i<3; i++){
            if((jb[i][0].getText() == "O") && (jb[i][1].getText() == "O") ||
                    (jb[i][0].getText() == "O") && (jb[i][2].getText() == "O") ||
                    (jb[i][1].getText() == "O") && (jb[i][2].getText() == "O")){

                if(jb[i][0].getText() == " "){
                    jb[i][0].setText("O");
                    check = true;
                    System.out.println("check 1 =" + check);
                    return check;
                }
                if(jb[i][1].getText() == " "){
                    jb[i][1].setText("O");
                    check = true;
                    System.out.println("check 1 =" + check);
                    return check;
                }
                if(jb[i][2].getText() == " "){
                    jb[i][2].setText("O");
                    check = true;
                    System.out.println("check 1 =" + check);
                    return check;
                }
            }
        }

        for(int i=0; i<3; i++){
            if(((jb[0][i].getText() == "O") && (jb[1][i].getText() == "O")) ||
                    ((jb[0][i].getText() == "O") && (jb[2][i].getText() == "O")) ||
                    ((jb[1][i].getText() == "O") && (jb[2][i].getText() == "O"))){

                if(jb[0][i].getText() == " "){
                    jb[0][i].setText("O");
                    check = true;
                    System.out.println("check 1 =" + check);
                    return check;
                }
                if(jb[1][i].getText() == " "){
                    jb[1][i].setText("O");
                    check = true;
                    System.out.println("check 1 =" + check);
                    return check;
                }
                if(jb[2][i].getText() == " "){
                    jb[2][i].setText("O");
                    check = true;
                    System.out.println("check 1 =" + check);
                    return check;
                }
            }
        }

        if(((jb[0][0].getText() == "O") && (jb[1][1].getText() == "O")) ||
                ((jb[0][0].getText() == "O") && (jb[2][2].getText() == "O")) ||
                ((jb[1][1].getText() == "O") && (jb[2][2].getText() == "O"))){

            if(jb[0][0].getText() == " "){
                jb[0][0].setText("O");
                check = true;
                System.out.println("check 1 =" + check);
                return check;
            }
            if(jb[1][1].getText() == " "){
                jb[1][1].setText("O");
                check = true;
                System.out.println("check 1 =" + check);
                return check;
            }
            if(jb[2][2].getText() == " "){
                jb[2][2].setText("O");
                check = true;
                System.out.println("check 1 =" + check);
                return check;
            }
        }

        if(((jb[2][0].getText() == "O") && (jb[1][1].getText() == "O")) ||
                ((jb[2][0].getText() == "O") && (jb[0][2].getText() == "O")) ||
                ((jb[1][1].getText() == "O") && (jb[0][2].getText() == "O"))){

            if(jb[2][0].getText() == " "){
                jb[2][0].setText("O");
                check = true;
                System.out.println("check 1 =" + check);
                return check;
            }
            if(jb[1][1].getText() == " "){
                jb[1][1].setText("O");
                check = true;
                System.out.println("check 1 =" + check);
                return check;
            }
            if(jb[0][2].getText() == " "){
                jb[0][2].setText("O");
                check = true;
                System.out.println("check 1 =" + check);
                return check;
            }
        }
        System.out.println("check 1 =" + check);
        return check;
    }

    public boolean Step2C(){
        boolean check = false;

        for(int i=0; i<3; i++){
            if((jb[i][0].getText() == "X") && (jb[i][1].getText() == "X") ||
                    (jb[i][0].getText() == "X") && (jb[i][2].getText() == "X") ||
                    (jb[i][1].getText() == "X") && (jb[i][2].getText() == "X")){
                if(jb[i][0].getText() == " "){
                    jb[i][0].setText("O");
                    check = true;
                    System.out.println("check 2 =" + check);
                    return check;
                }
                if(jb[i][1].getText() == " "){
                    jb[i][1].setText("O");
                    check = true;
                    System.out.println("check 2 =" + check);
                    return check;
                }
                if(jb[i][2].getText() == " "){
                    jb[i][2].setText("O");
                    check = true;
                    System.out.println("check 2 =" + check);
                    return check;
                }

            }
        }

        for(int i=0; i<3; i++){
            if(((jb[0][i].getText() == "X") && (jb[1][i].getText() == "X")) ||
                    ((jb[0][i].getText() == "X") && (jb[2][i].getText() == "X")) ||
                    ((jb[1][i].getText() == "X") && (jb[2][i].getText() == "X"))){

                if(jb[0][i].getText() == " "){
                    jb[0][i].setText("O");
                    check = true;
                    System.out.println("check 2 =" + check);
                    return check;
                }
                if(jb[1][i].getText() == " "){
                    jb[1][i].setText("O");
                    check = true;
                    System.out.println("check 2 =" + check);
                    return check;
                }
                if(jb[2][i].getText() == " "){
                    jb[2][i].setText("O");
                    check = true;
                    System.out.println("check 2 =" + check);
                    return check;
                }
            }
        }

        if(((jb[0][0].getText() == "X") && (jb[1][1].getText() == "X")) ||
                ((jb[0][0].getText() == "X") && (jb[2][2].getText() == "X")) ||
                ((jb[1][1].getText() == "X") && (jb[2][2].getText() == "X"))){

            if(jb[0][0].getText() == " "){
                jb[0][0].setText("O");
                check = true;
                System.out.println("check 2 =" + check);
                return check;
            }
            if(jb[1][1].getText() == " "){
                jb[1][1].setText("O");
                check = true;
                System.out.println("check 2 =" + check);
                return check;
            }
            if(jb[2][2].getText() == " "){
                jb[2][2].setText("O");
                check = true;
                System.out.println("check 2 =" + check);
                return check;
            }
        }

        if(((jb[2][0].getText() == "X") && (jb[1][1].getText() == "X")) ||
                ((jb[2][0].getText() == "X") && (jb[0][2].getText() == "X")) ||
                ((jb[1][1].getText() == "X") && (jb[0][2].getText() == "X"))){

            if(jb[2][0].getText() == " "){
                jb[2][0].setText("O");
                check = true;
                System.out.println("check 2 =" + check);
                return check;
            }
            if(jb[1][1].getText() == " "){
                jb[1][1].setText("O");
                check = true;
                System.out.println("check 2 =" + check);
                return check;
            }
            if(jb[0][2].getText() == " "){
                jb[0][2].setText("O");
                check = true;
                System.out.println("check 2 =" + check);
                return check;
            }
        }
        System.out.println("check 2 =" + check);
        return check;
    }

    public boolean Step3C(){
        boolean check = false;

        if(jb[0][0].getText() == "X" && jb[0][2].getText() == "X"){
            if(jb[1][1].getText() == " "){
                jb[1][1].setText("O");
                check = true;
                System.out.println("check 3 =" + check);
                return check;
            }
        }
        if(jb[0][0].getText() == "X" && jb[2][0].getText() == "X"){
            if(jb[1][1].getText() == " "){
                jb[1][1].setText("O");
                check = true;
                System.out.println("check 3 =" + check);
                return check;
            }
        }
        if(jb[2][2].getText() == "X" && jb[0][2].getText() == "X"){
            if(jb[1][1].getText() == " "){
                jb[1][1].setText("O");
                check = true;
                System.out.println("check 3 =" + check);
                return check;
            }
        }
        if(jb[2][2].getText() == "X" && jb[2][0].getText() == "X"){
            if(jb[1][1].getText() == " "){
                jb[1][1].setText("O");
                check = true;
                System.out.println("check 3 =" + check);
                return check;
            }
        }
        if(jb[2][2].getText() == "X" && jb[1][1].getText() == "X"){ //сделать проверку на все углы
            if(jb[0][2].getText() == " "){
                jb[0][2].setText("O");
                check = true;
                System.out.println("check 3 =" + check);
                return check;
            }
        }
        System.out.println("check 3 =" + check);
        return check;
    }

    public boolean Step4C(){
        boolean check = false;

        if(jb[1][1].getText() == " "){
            jb[1][1].setText("O");
            check = true;
            System.out.println("check 4 =" + check);
            return check;
        }
        System.out.println("check 4 =" + check);
        return check;
    }

    public boolean Step5C(){
        boolean check = false;

        for(int i=0; i<3; i++){
            if(jb[i][0].getText() == " "){
                jb[i][0].setText("O");
                check = true;
                System.out.println("check 5 =" + check);
                return check;
            }
            if(jb[i][1].getText() == " "){
                jb[i][1].setText("O");
                check = true;
                System.out.println("check 5 =" + check);
                return check;
            }
            if(jb[i][2].getText() == " "){
                jb[i][2].setText("O");
                check = true;
                System.out.println("check 5 =" + check);
                return check;
            }
        }
        System.out.println("check 5 =" + check);
        return check;
    }

    public void Cross(){
        CheckC();
        if(Step1C()){
            CheckY();
        }
        else{
            if(Step2C()){
                CheckY();
            }
            else{
                if(Step3C()){
                    CheckY();
                }
                else{
                    if(Step4C()){
                        CheckY();
                    }
                    else{
                        if(Step5C()){
                            CheckY();
                        }
                    }
                }
            }
        }



    }

    public void CheckC(){
        int m = 0;
        for(int i=0; i<3 ; i++){
            for(int j=0; j<3; j++){
                if(jb[i][j].getText() != " "){
                    m++;
                    //System.out.println("m = " + m);
                }
            }
        }
        if(m == 9){
            JOptionPane.showMessageDialog(null, "Ничья.");
            System.exit(0);
        }
    }

    public СrossZero(){
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        game1.setBounds(500, 300, 200, 100);
        add(game1);
        game2.setBounds(750, 300, 200, 100);
        add(game2);

        jb0.setBounds(400, 150, 200, 150);
        add(jb0).setVisible(false);
        jb1.setBounds(600, 150, 200, 150);
        add(jb1).setVisible(false);
        jb2.setBounds(800, 150, 200, 150);
        add(jb2).setVisible(false);

        jb3.setBounds(400, 300, 200, 150);
        add(jb3).setVisible(false);
        jb4.setBounds(600, 300, 200, 150);
        add(jb4).setVisible(false);
        jb5.setBounds(800, 300, 200, 150);
        add(jb5).setVisible(false);

        jb6.setBounds(400, 450, 200, 150);
        add(jb6).setVisible(false);
        jb7.setBounds(600, 450, 200, 150);
        add(jb7).setVisible(false);
        jb8.setBounds(800, 450, 200, 150);
        add(jb8).setVisible(false);


        game1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                GameP2P();
            }
        });

        game2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                GameP2C();
            }
        });
    }
    public static void main(String[] args) {
        new СrossZero().setVisible(true);
    }

}