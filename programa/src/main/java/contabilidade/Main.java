package contabilidade;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        String [] escolhas =  new String[] {"Sair", "Somador"};
        String [] fecharOuNão = new String[] {"Sim", "Não"};

        int  escolher  = JOptionPane.showOptionDialog(null, "O que você deseja?", "Ajudante", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, escolhas, escolhas[0]);
        int encerramentoOuNão, somaNumero, guardaNumero=0;


        while (escolher != 0) {
            
            somaNumero = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o número", "Ajudante Somador", JOptionPane.WARNING_MESSAGE));
            guardaNumero += somaNumero;
            JOptionPane.showMessageDialog(null,"Aqui está o resultado: " +guardaNumero, "Ajudante Somador",  JOptionPane.WARNING_MESSAGE );
            escolher = JOptionPane.showOptionDialog(null, "O que você deseja?", "Ajudante", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, escolhas, escolhas[0]);

            if(escolher == 0){
                encerramentoOuNão = JOptionPane.showOptionDialog(null, "Você tem certeza que deseja sair?", "Ajudante", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, 
                null, fecharOuNão, fecharOuNão[0]);

                if(encerramentoOuNão == 1){
                    escolher = JOptionPane.showOptionDialog(null, "O que você deseja?", "Ajudante", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, 
                    null, escolhas, escolhas[0]);

                }

            }
            
        }
    }
}