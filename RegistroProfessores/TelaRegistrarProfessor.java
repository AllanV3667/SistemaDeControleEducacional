import javax.swing.*;
import java.io.*;
import java.util.*;

public class TelaRegistrarProfessor extends JFrame {
    public TelaRegistrarProfessor() {
        setTitle("Registrar Professor");
        setSize(300, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(30, 30, 80, 25);
        add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(100, 30, 150, 25);
        add(txtNome);

        JLabel lblMateria = new JLabel("Matéria:");
        lblMateria.setBounds(30, 70, 80, 25);
        add(lblMateria);

        JTextField txtMateria = new JTextField();
        txtMateria.setBounds(100, 70, 150, 25);
        add(txtMateria);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(80, 120, 120, 25);
        add(btnRegistrar);

        btnRegistrar.addActionListener(e -> {
            String nome = txtNome.getText();
            String materia = txtMateria.getText();

            if (nome.isEmpty() || materia.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
                return;
            }

            int novoId = gerarProximoId();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("professores.txt", true))) {
                writer.write(novoId + ";" + nome + ";" + materia);
                writer.newLine();
                dispose();
                new TelaMenuPrincipal();

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar o professor.");
            }
        });

        setVisible(true);
    }

    private int gerarProximoId() {
        int maiorId = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("professores.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length >= 1) {
                    try {
                        int id = Integer.parseInt(partes[0]);
                        if (id > maiorId) {
                            maiorId = id;
                        }
                    } catch (NumberFormatException ignored) {}
                }
            }
        } catch (IOException e) {
            
        }

        return maiorId + 1;
    }
}
