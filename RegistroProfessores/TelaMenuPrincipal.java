import javax.swing.*;

public class TelaMenuPrincipal extends JFrame {
    public TelaMenuPrincipal() {
        setTitle("Menu Principal");
        setSize(300, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JButton btnRegistrar = new JButton("Registrar Professor");
        btnRegistrar.setBounds(50, 30, 200, 30);
        add(btnRegistrar);

        JButton btnEditar = new JButton("Editar Professor");
        btnEditar.setBounds(50, 80, 200, 30);
        add(btnEditar);

        JButton btnExcluir = new JButton("Excluir Professor");
        btnExcluir.setBounds(50, 130, 200, 30);
        add(btnExcluir);

        JButton btnListar = new JButton("Listar Professores");
        btnListar.setBounds(50, 180, 200, 30);
        add(btnListar);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(50, 230, 200, 30);
        add(btnSair);

        btnRegistrar.addActionListener(e -> {
            dispose();
            new TelaRegistrarProfessor();
        });

        btnEditar.addActionListener(e -> {
            dispose();
            new TelaEditarProfessor();
        });

        btnExcluir.addActionListener(e -> {
            dispose();
            new TelaExcluirProfessor();
        });

        btnListar.addActionListener(e -> {
            dispose();
            new TelaListarProfessores();
        });

        btnSair.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaMenuPrincipal();
    }
}