package contabilidade;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    public static void main(String[] args) {
        float numSomar;
        float numTotal=0;
        
        //Janela denominada 'somador'
        JFrame somador = new JFrame();
         //Botão que soma os números
        JButton botaoSomar = new JButton("Somar"); 
        //Caixa de texto que o usuário não pode digitar, indicando aonde o usuário deve digitar 
        JLabel indicaUsario =new JLabel("Valor");
        //Caixa de texto que o usuário vai digitar os números
        JTextField digitarValores = new JTextField();

        //Definindo o tramanho, largura e coordenadas do botão
        botaoSomar.setBounds(650, 40, 100, 30);
        //função para quando o botão for clicado
        botaoSomar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {


                //Aqui o botão pega o valor digitado pelo usuário
                numSomar = Float.parseFloat(digitarValores.getText());
                //Aqui o botão faz a soma 
                numTotal += numSomar;
                

                //Aqui ele mostra o resultado
                System.out.println(numTotal);
            }
            

        });

        ////Definindo o tamanho, largura e coordenas da caixa de texto que vai inidicar aonde o usuário vai digitar
        indicaUsario.setBounds(440, 10, 100, 30);

        //Definindo o tamanho, largura e coordenas da caixa de texto aonde o usuário vai digitar os valores
        digitarValores.setBounds(440, 40 , 200, 30);

        //Adição do botão na janela
        somador.add(botaoSomar);

        //Adição do indicador na janela
        somador.add(indicaUsario);

        //Adição da caixa de texto editavel pelo usuário
        somador.add(digitarValores);

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