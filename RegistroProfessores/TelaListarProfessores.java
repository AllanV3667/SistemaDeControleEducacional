import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.*;

public class TelaListarProfessores extends JFrame {
    public TelaListarProfessores() {
        setTitle("Professores Registrados");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        String[] colunas = {"ID", "Nome", "Matéria"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabela);
        add(scrollPane);

        try (BufferedReader br = new BufferedReader(new FileReader("professores.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 3) {
                    model.addRow(new Object[]{dados[0], dados[1], dados[2]});
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler professores.txt");
        }

        JButton btnVoltar = new JButton("Voltar ao Menu");
        btnVoltar.addActionListener(e -> {
            dispose();
            new TelaMenuPrincipal();
        });
        add(btnVoltar);

        setVisible(true);
    }
}