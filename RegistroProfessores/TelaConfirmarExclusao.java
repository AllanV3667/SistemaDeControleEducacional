import javax.swing.*;

public class TelaConfirmarExclusao extends JFrame {
    public TelaConfirmarExclusao() {
        setTitle("Confirmar Exclusão");
        setSize(350, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblConfirmar = new JLabel("Deseja realmente excluir o professor?");
        lblConfirmar.setBounds(40, 20, 280, 25);
        add(lblConfirmar);

        JButton btnSim = new JButton("Sim");
        btnSim.setBounds(60, 60, 80, 25);
        add(btnSim);

        JButton btnNao = new JButton("Não");
        btnNao.setBounds(180, 60, 80, 25);
        add(btnNao);

        btnSim.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Professor excluído.");
            dispose();
            new TelaMenuPrincipal();
        });

        btnNao.addActionListener(e -> {
            dispose();
            new TelaMenuPrincipal();
        });

        setVisible(true);
    }
}