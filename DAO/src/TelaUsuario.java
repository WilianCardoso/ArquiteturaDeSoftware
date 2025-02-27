

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.UserDaoImpl;
import model.User;

public class TelaUsuario extends JFrame {

    private JTextField txtId;
    private JTextField txtName;
    private JButton btnBuscar;
    private JButton btnSalvar;
    private JButton btnExcluir;
    private JButton btnUpdate;
    private UserDaoImpl userDao;

    public TelaUsuario() {
        userDao = new UserDaoImpl();

        setTitle("Gerenciamento de Usuários");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Criando os componentes
        JLabel lblId = new JLabel("ID:");
        txtId = new JTextField();
        JLabel lblNome = new JLabel("Nome:");
        txtName = new JTextField();

        btnBuscar = new JButton("Buscar");
        btnSalvar = new JButton("Salvar");
        btnExcluir = new JButton("Excluir");
        btnUpdate = new JButton("Atualizar");

        // Adicionando os componentes ao JFrame
        add(lblId);
        add(txtId);
        add(lblNome);
        add(txtName);

        add(btnBuscar);
        add(btnSalvar);
        add(btnExcluir);
        add(btnUpdate);

        // Ações dos botões
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarUsuario();
            }
        });

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarUsuario();
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirUsuario();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateUser();
            }
        });

        setLocationRelativeTo(null); // Centraliza a janela
    }

    // Método para buscar usuário pelo ID
    private void buscarUsuario() {
        int id = Integer.parseInt(txtId.getText());
        User user = userDao.findUserByUserId(id);

        if (user != null) {
            txtName.setText(user.getName());
        } else {
            JOptionPane.showMessageDialog(this, "Usuário não encontrado!");
        }
    }

    // Método para salvar um novo usuário
    private void salvarUsuario() {
        String nome = txtName.getText();

        User user = new User();
        user.setName(nome);

        userDao.saveUser(user);
        JOptionPane.showMessageDialog(this, "Usuário salvo com sucesso!");
    }

    // Método para excluir um usuário pelo ID
    private void excluirUsuario() {
        int id = Integer.parseInt(txtId.getText());
        userDao.deletarUser(id);
        JOptionPane.showMessageDialog(this, "Usuário excluído com sucesso!");

        txtId.setText("");
        txtName.setText("");
    }

    // Atualizar o usuário
    private void updateUser() {
        int id = Integer.parseInt(txtId.getText());
        String name = txtName.getText();

        userDao.updateUser(id, name);

        User user = userDao.findUserByUserId(id);
        txtName.setText(user.getName());

        JOptionPane.showMessageDialog(this, "Usuário alterado com sucesso!");
    }
}
