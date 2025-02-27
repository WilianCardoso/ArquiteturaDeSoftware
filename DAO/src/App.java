import javax.swing.SwingUtilities;

import view.TelaUsuario;

public class App {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(() -> {
            TelaUsuario tela = new TelaUsuario();
            tela.setVisible(true);
        });
    }
}
