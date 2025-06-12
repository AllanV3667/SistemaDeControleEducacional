import javax.swing.*;
import java.io.*;

public class TelaExcluirProfessor extends JFrame {
    public TelaExcluirProfessor() {
        setTitle("Excluir Professor");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblId = new JLabel("ID do Professor:");
        lblId.setBounds(30, 30, 120, 25);
        add(lblId);

        JTextField txtId = new JTextField();
        txtId.setBounds(150, 30, 100, 25);
        add(txtId);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(90, 80, 100, 25);
        add(btnExcluir);

        btnExcluir.addActionListener(e -> {
            String id = txtId.getText();
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe o ID.");
                return;
            }

            File inputFile = new File("professores.txt");
            File tempFile = new File("professores_temp.txt");

            boolean excluido = false;

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

                String linha;
                while ((linha = reader.readLine()) != null) {
                    String[] partes = linha.split(";");
                    if (partes.length == 3 && partes[0].equals(id)) {
                        excluido = true;
                        continue;
                    }
                    writer.write(linha);
                    writer.newLine();
                }

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir o professor.");
                return;
            }

            if (inputFile.delete()) {
                tempFile.renameTo(inputFile);
            }

            if (excluido) {
                JOptionPane.showMessageDialog(null, "Professor excluído com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "ID não encontrado.");
            }

            dispose();
            new TelaMenuPrincipal();
        });

        setVisible(true);
    }
}
