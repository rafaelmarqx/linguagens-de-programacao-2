package br.newtonpaiva;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JOptionPane;


public class Interface_Grafica_Projeto_Lotofacil extends JFrame {

    Random random = new Random();

    private JPanel painel = new JPanel();
    private JButton jButtonAposta1 = new JButton("Apostar de 0 a 100");
    private JButton jButtonAposta2 = new JButton("Apostar de A a Z");
    private JButton jButtonAposta3 = new JButton("Apostar par ou ímpar");
    private JLabel jLabelMensagem = new JLabel("Exemplo de Simples Janela");

    public Interface_Grafica_Projeto_Lotofacil() {
        this.setTitle("Lotofácil - Interface Gráfica");
        this.setSize(400, 200);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        painel.setBackground(new Color(255, 255, 255));
        painel.add(jButtonAposta1);
        painel.add(jButtonAposta2);
        painel.add(jButtonAposta3);
        this.getContentPane().add(painel);
        this.setLocationRelativeTo(null); // Centralizar janela
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true); // Exibir janela

        jButtonAposta1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String numeroinput = JOptionPane.showInputDialog(null, "Digite um número de 0 a 100:");
                int numero = Integer.parseInt(numeroinput);
                int numerorandom = random.nextInt(101);

                if (numero >= 0 && numero <= 100) {

                    if (numerorandom == numero) {
                        JOptionPane.showMessageDialog(null, "Você venceu!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Infelizmente não foi desta vez. Que pena! O número sorteado foi: " + numerorandom);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,"Número fora do intervalo válido, tente novamente.");
                }
            }
        });

        jButtonAposta2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String letraInput = JOptionPane.showInputDialog("Insira uma letra entre A e Z:");
                letraInput = letraInput.toUpperCase();
                char letra = letraInput.charAt(0);
                char letraPremiada = 'R';

                if (Character.isLetter(letra)) {
                    if (letra == letraPremiada) {
                        JOptionPane.showMessageDialog(null, String.format("'%c'. Boa!! Você Venceu.", letra));
                    } else {
                        JOptionPane.showMessageDialog(null, String.format("'%c'. Boa! ... Mas infelizmente não foi desta vez. Que pena! A letra sorteada foi: %c", letra, letraPremiada));
                    }
                } else {
                    JOptionPane.showMessageDialog(null,"Inserção fora do intervalo válido, tente novamente.");
                }
            }
        });

        jButtonAposta3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int numpi = Integer.parseInt(
                        JOptionPane.showInputDialog("Digite um número par ou ímpar:"));
                if (numpi % 2 == 0) {
                    JOptionPane.showMessageDialog(null,"Você venceu!");
                } else {
                    JOptionPane.showMessageDialog(null,"Que pena! O número digitado foi um número ímpar e a premiação foi para números pares, tente novamente.");
                }
            }
        });
    }

    public static void main(String[] args) {
        new Interface_Grafica_Projeto_Lotofacil();
    }
}