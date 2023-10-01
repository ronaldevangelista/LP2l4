//Ronald Pereira Evangelista
import java.awt.*;
import java.awt.event.*;

public class FormCalculadora extends Frame implements ActionListener{
    //COMPONENTS
    private TextField screen = new TextField("0");
    private Button n1 = new Button("1");
    private Button n2 = new Button("2");
    private Button n3 = new Button("3");
    private Button n4 = new Button("4");
    private Button n5 = new Button("5");
    private Button n6 = new Button("6");
    private Button n7 = new Button("7");
    private Button n8 = new Button("8");
    private Button n9 = new Button("9");
    private Button n0 = new Button("0");
    private Button simbolDivide = new Button("/");
    private Button simbolmultiplication = new Button("*");
    private Button simbolLess = new Button("-");
    private Button simbolPlus = new Button("+");
    private Button simbolEqual = new Button("=");
    private Button simbolDot = new Button(".");
    private Button simbolClean = new Button("C");
    
    //CONTAINERS - C1 = BODY - C2 = SCREEN 
    private Container c1 = new Container();
    private Container c2 = new Container();

    //ATRIBUTTES
    private boolean val2 = false;
    private char opt = ' ';
    private String screenNow = "";
    private String number01 = "";
    private String number02 = "";
    private double value1 = 0;
    private double value2 = 0;

    //UPDATE THE SCREEN
    //MUST BE USED ALWAYS AFTER A BUTTON GET PRESSED
    private void refreshScreen(){
        screenNow = number01 + " " + opt + " " + number02;
        screen.setText(screenNow);
    }

    //MATH CALCS
    private double multiplication(double v1, double v2){
        return v1 * v2;
    }

    private double sum(double v1, double v2){
        return v1 + v2;
    }
    
    private double minus(double v1, double v2){
        return v1 - v2;
    }

    //If the divisor is 0, it must return a error.
    private double divide(double v1, double v2){

        if(v2 == 0){
            throw new RuntimeException("Não se pode dividir por zero");
        }
        
        return v1 / v2;
    }

    public FormCalculadora(String nome, int altura, int largura, int colinic, int lilinic){
        //FRAME
        super(nome);
        setSize(largura, altura);
        setLocation(colinic, lilinic);
        setVisible(true);
        setLayout(new BorderLayout(2, 2));
        setResizable(false);

        //CONTAINER BODY
        add(c1, BorderLayout.CENTER);
        c1.setLayout(new GridLayout(5, 4, 1, 1));
        c1.add(n7);
        c1.add(n8);
        c1.add(n9);
        c1.add(simbolDivide);
        c1.add(n4);
        c1.add(n5);
        c1.add(n6);
        c1.add(simbolmultiplication);
        c1.add(n1);
        c1.add(n2);
        c1.add(n3);
        c1.add(simbolLess);
        c1.add(n0);
        c1.add(simbolDot);
        c1.add(simbolEqual);
        c1.add(simbolPlus);
        c1.add(simbolClean);

        //SUPERIOR CONTAINER (SCREEN OF THE CALC)
        add(c2, BorderLayout.NORTH);
        c2.setLayout(new BorderLayout());
        c2.add(screen, BorderLayout.CENTER);
        screen.setEditable(false);

        //CREATE ACTION LISTENERS
        n7.addActionListener(this);
        n8.addActionListener(this);
        n9.addActionListener(this);
        simbolDivide.addActionListener(this);
        n4.addActionListener(this);
        n5.addActionListener(this);
        n6.addActionListener(this);
        simbolmultiplication.addActionListener(this);
        n1.addActionListener(this);
        n2.addActionListener(this);
        n3.addActionListener(this);
        simbolLess.addActionListener(this);
        n0.addActionListener(this);
        simbolDot.addActionListener(this);
        simbolEqual.addActionListener(this);
        simbolPlus.addActionListener(this);
        simbolClean.addActionListener(this);

        //CLOSE WINDOW
        addWindowListener(new FechaJanela());
    }

    public void actionPerformed(ActionEvent e){
        if (number01.contains("Não se pode dividir por zero")){
            number01 = "";
        }
        if (e.getSource() == n0) {
            if (val2) {
                number02 += "0";
            } else {
                number01 += "0";
            }            
        } else if (e.getSource() == n1){
            if (val2) {
                number02 += "1";
            } else {
                number01 += "1";
            }
        } else if (e.getSource() == n2){
            if (val2) {
                number02 += "2";
            } else {
                number01 += "2";
            }
        } else if (e.getSource() == n3){
            if (val2) {
                number02 += "3";
            } else {
                number01 += "3";
            }
        } else if (e.getSource() == n4){
            if (val2) {
                number02 += "4";
            } else {
                number01 += "4";
            }
        } else if (e.getSource() == n5){
            if (val2) {
                number02 += "5";
            } else {
                number01 += "5";
            }
        } else if (e.getSource() == n6){
            if (val2) {
                number02 += "6";
            } else {
                number01 += "6";
            }
        } else if (e.getSource() == n7){
            if (val2) {
                number02 += "7";
            } else {
                number01 += "7";
            }
        } else if (e.getSource() == n8){
            if (val2) {
                number02 += "8";
            } else {
                number01 += "8";
            }
        } else if (e.getSource() == n9){
            if (val2) {
                number02 += "9";
            } else {
                number01 += "9";
            }
        } else if (e.getSource() == simbolDot){
            if (val2) {
                number02 += ".";
            } else {
                number01 += ".";
            }
        } else if (e.getSource() == simbolDivide){
            val2 = true;
            opt = '/';
        } else if (e.getSource() == simbolLess){
            val2 = true;
            opt = '-';
        } else if (e.getSource() == simbolmultiplication){
            val2 = true;
            opt = '*';
        } else if (e.getSource() == simbolPlus){
            val2 = true;
            opt = '+';
        } else if (e.getSource() == simbolEqual){
            value1 = Double.parseDouble(number01);
            value2 = Double.parseDouble(number02);
            if (opt == '*') {
                value1 = multiplication(value1, value2);
                number01 = Double.toString(value1);
                number02 = "";
                opt = ' ';
            } else if (opt == '/'){
                try {
                    value1 = divide(value1, value2);
                    number01 = Double.toString(value1);
                    number02 = "";
                    opt = ' ';
                } catch (RuntimeException a) {
                    value1 = 0;
                    number01 = a.getMessage();
                    number02 = "";
                    opt = ' ';
                    val2 = false;
                }
            } else if (opt == '-'){
                value1 = minus(value1, value2);
                number01 = Double.toString(value1);
                number02 = "";
                opt = ' ';
            } else if (opt == '+'){
                value1 = sum(value1, value2);
                number01 = Double.toString(value1);
                number02 = "";
                opt = ' ';
            }
            value2 = 0;

        } else if (e.getSource() == simbolClean){
                number01 = "";
                number02 = "";
                opt = ' ';
                value1 = 0;
                value2 = 0;
                val2 = false;
        }
        refreshScreen();
    }

    public static void main(String[] args) {
        FormCalculadora calc1 = new FormCalculadora("Calculadora Java", 220, 180, 360, 360);
    }
}
