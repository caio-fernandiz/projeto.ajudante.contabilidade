package contabilidade;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.awt.event.KeyListener;


public class Main {

    private static float numSomar;
    private static float numTotal = 0;

    public static void main(String[] args) {

        //adição do metodo Decfimal format
        DecimalFormat df= new DecimalFormat("R$ #,##0.00");

        //Janela denominada 'somador'
        JFrame somador = new JFrame();
       
        //Botão que soma os números
        JButton botaoAdicionar = new JButton("Adicionar");
        //Definindo o tramanho, largura e coordenadas do botão
        botaoAdicionar.setBounds(650, 40, 100, 30);
        //Adição do botão na janela
        somador.add(botaoAdicionar);

        //Caixa de texto que indica aonde o usuário deve digitar os valores
        JLabel indicaValores = new JLabel("Valores");
        //Definindo o tamanho, largura e coordenas da caixa de texto que vai inidicar aonde o usuário vai digitar os valores
        indicaValores.setBounds(440, 10, 100, 30);
        //Adição do indicador de valores na janela
        somador.add(indicaValores);

        //Caixa de texto que indica aondeo o usuário deve digitar cada item da lista
        JLabel indicaItens = new JLabel("Itens");
        //Definindo o tamanho, largura e coordenas da caixa de texto que vai inidicar aonde o usuário vai digitar os itens
        indicaItens.setBounds(30, 10, 100,30);
        //Adição do indicador de itens na janela
        somador.add(indicaItens);

        //Caixa de texto que indica aonde irá o resultado total da soma de valores
        JLabel indicaResultadoValores = new JLabel("Resultado");
        //Definindo o tamanho, largura e coordenas da caixa de texto que indica aonde irá o resultado da soma de valores
        indicaResultadoValores.setBounds(440, 300, 100, 30);
        //Adição do indicador do resultado da soma de valores
        somador.add(indicaResultadoValores);

        //Caixa de texto que o usuário vai digitar os números
        JTextField digitarValores = new JTextField();
        //Definindo o tamanho, largura e coordenas da caixa de texto aonde o usuário vai digitar os valores
        digitarValores.setBounds(440, 40 , 200, 30);
        //Adição da caixa de texto que o usuário adiciona os valores 
        somador.add(digitarValores);

        //Caixa de texto que o usuárioo vai digitar os itens da lista 
        JTextField digitarItens = new JTextField();
        //Definindo o tamanho, largura e coordenas da caixa de texto aonde o usuário vai digitar os itens
        digitarItens.setBounds(30, 40, 200, 30);
        //Adição da caixa de texto que o usuário adiciona os itens
        somador.add(digitarItens);

        //Caixa de texto que o usuário vai ver os resultado total da soma de valores
        JTextField mostraResultados = new JTextField();
        //Definindo o tamanho, largura e coordenas da caixa de texto aonde o usuário vai ver os resultados
        mostraResultados.setBounds(440, 330, 200, 30);
        //Adilção da caixa de texto que irá mostrar os resultado da soma dos valores
        somador.add(mostraResultados);

        //Caixa que mostra a lista de valores inseridos
        JTextArea listaValores = new JTextArea("Valores\n");
        //Definindo o tamanho, largura e coordenas da caixa que vai mostrar os valores inseridos pelo usuário na lista
        listaValores.setBounds(440, 80, 311, 200);
        //Adição da caixa de texto que mostra a lista de valores inseridos pelo usuário
        somador.add(listaValores);

        //Caixa que mostra a list de itens inseridos
        JTextArea listaItens = new JTextArea("Itens\n");
        //Definindo o tamanho, largura e coordenas da caixa que vai mostrar os itens inseridos pelo usuário na lista
        listaItens.setBounds(30, 80, 311, 200 );
        //Adição da caixa que mostra a lista de itens inseridos pelo usuário
        somador.add(listaItens);

        //função para quando o botão for clicado
        botaoAdicionar.addActionListener(new ActionListener(){


            @Override
            public void actionPerformed(ActionEvent arg0) {

                //Essa string serve para pegar o item informado, assim o botão envia para a lista 
                String itens = digitarItens.getText();

                //aqui é aonde o botão envia o item informado para a lista
                listaItens.append(itens + "\n");

                if(itens.equals("")){
                    JOptionPane.showMessageDialog(null, "Você precisa informar o item", "AVISO", JOptionPane.WARNING_MESSAGE);

                }

                else{
                //Aqui o botão pega o valor digitado pelo usuário e converte todos os pontos para virgula
                numSomar = Float.parseFloat(digitarValores.getText().replaceAll(",", "."));

                //Aqui o botão faz a soma
                numTotal += numSomar;
               
                //Envia os valores digitados para a lista usando o metodo df
                listaValores.append(df.format(numSomar) + "\n");

                //Envia o resultado da soma usando o metodo df
                mostraResultados.setText(df.format(numTotal));
                }
            }
        });


        //metodo que faz a caixa de texto dos valores aceitar somente números e virgula
        digitarValores.addKeyListener(new KeyAdapter(){

            @Override
            public void keyTyped(KeyEvent e){
                //essa Strgin serve para determinar quais caracteres vão ser aceitos 
                String somenteEsses = "0123456789,";

                //essa função é para impedir os caracteres não aceitos de aparecerem se o usuário digitar eles
                if (!somenteEsses.contains(e.getKeyChar()+ "")){
                    e.consume();

                }
            }
        });

        //Essa linha faz com que a janela fique nula, me obrigadno a definir o tamanho e coordenas dos componentes dentro dela.
        somador.setLayout(null);
        //Responsavel pelo tamanho e localização de inicio da janela
        somador.setBounds(600, 200, 800, 600);
        //Responsavel pela encerração do programa ao fechar a janela
        somador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Responsável pela visibildade da janela
        somador.setVisible(true);
               
    }
}