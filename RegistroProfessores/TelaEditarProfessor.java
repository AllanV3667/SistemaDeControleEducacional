import javax.swing.*;
import java.io.*;

public class TelaEditarProfessor extends JFrame {
    public TelaEditarProfessor() {
        setTitle("Editar Professor");
        setSize(350, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblId = new JLabel("ID do Professor:");
        lblId.setBounds(30, 30, 120, 25);
        add(lblId);

        JTextField txtId = new JTextField();
        txtId.setBounds(150, 30, 150, 25);
        add(txtId);

        JLabel lblNome = new JLabel("Novo Nome:");
        lblNome.setBounds(30, 70, 100, 25);
        add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(150, 70, 150, 25);
        add(txtNome);

        JLabel lblMateria = new JLabel("Nova Matéria:");
        lblMateria.setBounds(30, 110, 100, 25);
        add(lblMateria);

        JTextField txtMateria = new JTextField();
        txtMateria.setBounds(150, 110, 150, 25);
        add(txtMateria);

        JButton btnSalvar = new JButton("Salvar Alterações");
        btnSalvar.setBounds(90, 160, 160, 25);
        add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            String id = txtId.getText();
            String nome = txtNome.getText();
            String materia = txtMateria.getText();

            if (id.isEmpty() || nome.isEmpty() || materia.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
                return;
            }

            File inputFile = new File("professores.txt");
            File tempFile = new File("professores_temp.txt");

            boolean atualizado = false;

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

                String linha;
                while ((linha = reader.readLine()) != null) {
                    String[] partes = linha.split(";");
                    if (partes.length == 3 && partes[0].equals(id)) {
                        writer.write(id + ";" + nome + ";" + materia);
                        atualizado = true;
                    } else {
                        writer.write(linha);
                    }
                    writer.newLine();
                }

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao editar o professor.");
                return;
            }

            if (inputFile.delete()) {
                tempFile.renameTo(inputFile);
            }

            if (atualizado) {
                JOptionPane.showMessageDialog(null, "Professor atualizado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "ID não encontrado.");
            }

            dispose();
            new TelaMenuPrincipal();
        });

        setVisible(true);
    }
}
