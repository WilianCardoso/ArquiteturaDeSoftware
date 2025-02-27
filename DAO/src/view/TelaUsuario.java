package view;

import dao.UserDaoImpl;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaUsuario extends JFrame {

    private JTextField txtId;
    private JTextField txtNome;
    private JButton btnBuscar;
    private JButton btnSalvar;
    private JButton btnExcluir;
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
        txtNome = new JTextField();

        btnBuscar = new JButton("Buscar");
        btnSalvar = new JButton("Salvar");
        btnExcluir = new JButton("Excluir");

        // Adicionando os componentes ao JFrame
        add(lblId);
        add(txtId);
        add(lblNome);
        add(txtNome);

        add(btnBuscar);
        add(btnSalvar);
        add(btnExcluir);

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

        setLocationRelativeTo(null); // Centraliza a janela
    }

    // Método para buscar usuário pelo ID
    private void buscarUsuario() {
        int id = Integer.parseInt(txtId.getText());
        User user = userDao.findUserByUserId(id);

        if (user != null) {
            txtNome.setText(user.getName());
        } else {
            JOptionPane.showMessageDialog(this, "Usuário não encontrado!");
        }
    }

    // Método para salvar um novo usuário
    private void salvarUsuario() {
        String nome = txtNome.getText();

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
        txtNome.setText("");
    }
}