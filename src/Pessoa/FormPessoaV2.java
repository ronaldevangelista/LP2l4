//Ronald Pereira Evangelista
//Esqueci de fazer as outras, versões. Aceite se sentir dó pobre vascaíno.
package Pessoa;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JComboBox;

public class FormPessoaV2 extends Frame implements ActionListener{
    //COMPONENTS
    //Labels
    private Label numeroLabel = new Label("Numero:");
    private Label nomeLabel = new Label("Nome:");
    private Label sexoLabel = new Label("Sexo:");
    private Label idadeLabel = new Label("Idade:");
    //Textfields and JComboBox
    private TextField numeroTextField = new TextField();
    private TextField nomeTextField = new TextField();
    private String[] optionArrayButtons = {"","Masculino", "Feminino"};
    private JComboBox sexoComboBox = new JComboBox<>(optionArrayButtons);
    private TextField idadeTextField = new TextField();
    //Buttons
    private Button buttonOk = new Button("Ok");
    private Button buttonClean = new Button("Limpar");
    private Button buttonShow = new Button("Mostrar");
    private Button buttonExit = new Button("Sair");
    //CONTAINERS and arrays
    private Container supContainer = new Container();
    private Container bottomContainer = new Container();
    //ATRIBUTTES
    Pessoa umaPessoa = new Pessoa();

    public FormPessoaV2(String Title, int width, int height, int colinic, int lilinic){
        //FRAME
        super(Title);
        setSize(width, height);
        setLocation(colinic, lilinic);
        setVisible(true);
        setLayout(new BorderLayout(0, 10));

        //ADD THE CONTAINERS
        add(supContainer, BorderLayout.CENTER);
        add(bottomContainer, BorderLayout.SOUTH);

        //SETTING THE SUPERIOR CONTAINER
        supContainer.setLayout(new GridLayout(4, 2, 5, 10));
        supContainer.add(numeroLabel);
        supContainer.add(numeroTextField);
        numeroTextField.setEditable(false);
        supContainer.add(nomeLabel);
        supContainer.add(nomeTextField);
        supContainer.add(sexoLabel);
        supContainer.add(sexoComboBox);
        supContainer.add(idadeLabel);
        supContainer.add(idadeTextField);

        //SETTING THE BOTTOM CONTAINER
        bottomContainer.setLayout(new GridLayout(1, 4, 2, 0));
        bottomContainer.add(buttonOk);
        bottomContainer.add(buttonClean);
        bottomContainer.add(buttonShow);
        bottomContainer.add(buttonExit);

        //SETTING THE ACTION LISTENERS
        buttonOk.addActionListener(this);
        buttonClean.addActionListener(this);
        buttonShow.addActionListener(this);
        buttonExit.addActionListener(this);

        addWindowListener(new FechaJanela());
        limparCampos(); 
    }

    public void limparCampos(){
        numeroTextField.setText(String.valueOf(Pessoa.getKp()));
        nomeTextField.setText("");
        //sexoTextField.setText("");
        idadeTextField.setText("0");
    }
    
    private void camposPreenchidos(){

        if (nomeTextField.getText().equals("")){
            throw new RuntimeException("Todos os campos são obrigatórios");
        } else if (sexoComboBox.getSelectedIndex() == 0){
            throw new RuntimeException("Sexo tem que ser selecionado");
        } else if (Integer.parseInt(idadeTextField.getText()) <= 0){
            throw new RuntimeException("O valor da idade tem que ser igual ou superior a 0");
        }
    }

    public void actionPerformed (ActionEvent e){
        if (e.getSource() == buttonExit){
            System.exit(0);
        } else if (e.getSource() == buttonClean){
            limparCampos();
        } else if (e.getSource() == buttonOk){
            try {
                camposPreenchidos();
                umaPessoa.setIdade(Integer.parseInt(idadeTextField.getText()));
                umaPessoa.setNome(nomeTextField.getText());
                umaPessoa.setSexo(sexoComboBox.getSelectedItem().toString().charAt(0));
                Pessoa.setKp(Pessoa.getKp() + 1);
                limparCampos();
            } catch (RuntimeException a) {
                if (a.getMessage() == "Todos os campos são obrigatórios"){
                    nomeTextField.setText(a.getMessage());
                } else if (a.getMessage() == "Sexo tem que ser selecionado"){
                    nomeTextField.setText(a.getMessage());
                } else if (a.getMessage() == "O valor da idade tem que ser igual ou superior a 0"){
                    idadeTextField.setText(a.getMessage());
                }
            }
        } else if (e.getSource() == buttonShow){
            limparCampos();
            idadeTextField.setText(String.valueOf(umaPessoa.getIdade()));
            nomeTextField.setText(umaPessoa.getNome());
            if (umaPessoa.getSexo() == 'M') {
                sexoComboBox.setSelectedIndex(1);
            } else {sexoComboBox.setSelectedIndex(2);}
            numeroTextField.setText(String.valueOf(Pessoa.getKp()));
        }
    }

    public static void main(String[] args) {
        FormPessoaV2 formPessoa = new FormPessoaV2("Semana 06 - Exercicio 01", 480, 240, 150, 150);
    }
}
