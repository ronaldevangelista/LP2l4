//Ronald Pereira Evangelista
package Pessoa;
import java.awt.*;
import java.awt.event.*;

public class FormPessoa extends Frame implements ActionListener{
    //COMPONENTS
    //Labels
    private Label numeroLabel = new Label("Numero:");
    private Label nomeLabel = new Label("Nome:");
    private Label sexoLabel = new Label("Sexo:");
    private Label idadeLabel = new Label("Idade:");
    //Textfields
    private TextField numeroTextField = new TextField();
    private TextField nomeTextField = new TextField();
    private TextField sexoTextField = new TextField();
    private TextField idadeTextField = new TextField();
    //Buttons
    private Button buttonOk = new Button("Ok");
    private Button buttonClean = new Button("Limpar");
    private Button buttonShow = new Button("Mostrar");
    private Button buttonExit = new Button("Sair");
    
    //CONTAINERS
    private Container supContainer = new Container();
    private Container bottomContainer = new Container();

    //ATRIBUTTES
    Pessoa umaPessoa = new Pessoa();

    public FormPessoa(String Title, int width, int height, int colinic, int lilinic){
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
        supContainer.add(sexoTextField);
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
        sexoTextField.setText("");
        idadeTextField.setText("0");
    }
    
    private void camposPreenchidos(){

        if (nomeTextField.getText().equals("")){
            throw new RuntimeException("Todos os campos são obrigatórios");
        } else if (!sexoTextField.getText().equals("M") && !sexoTextField.getText().equals("F")){
            throw new RuntimeException("Só é permitido M ou F");
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
                umaPessoa.setSexo(sexoTextField.getText().charAt(0));
                Pessoa.setKp(Pessoa.getKp() + 1);
                limparCampos();
            } catch (RuntimeException a) {
                if (a.getMessage() == "Todos os campos são obrigatórios"){
                    nomeTextField.setText(a.getMessage());
                } else if (a.getMessage() == "Só é permitido M ou F"){
                    sexoTextField.setText(a.getMessage());
                } else if (a.getMessage() == "O valor da idade tem que ser igual ou superior a 0"){
                    idadeTextField.setText(a.getMessage());
                }
            }
        } else if (e.getSource() == buttonShow){
            limparCampos();
            idadeTextField.setText(String.valueOf(umaPessoa.getIdade()));
            nomeTextField.setText(umaPessoa.getNome());
            sexoTextField.setText(String.valueOf(umaPessoa.getSexo()));
            numeroTextField.setText(String.valueOf(Pessoa.getKp()));
        }
    }

    public static void main(String[] args) {
        FormPessoa formPessoa = new FormPessoa("Semana 06 - Exercicio 01", 480, 240, 150, 150);
    }
}
