package controller;

import Modelos.Usuario;
import View.LoginCadastro;
import View.MENUFRAME;
import dao.UsuarioDAO;
import dao.conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginController {

    private LoginCadastro View;


    public LoginController(LoginCadastro View) {
        this.View = View;
    }

    public void autentica() throws SQLException {

        //Buscar um usuario da view
        String usuario = View.getjTextFieldusuario().getText();
        String senha = View.getjPasswordFieldsenha().getText();

        Usuario usuarioAutenticar = new Usuario(usuario, senha);
        //Verificar se ele existe no Banco de Dados
        Connection conexao = new conexao().getConnection();
        UsuarioDAO usuariodao = new UsuarioDAO(conexao);
        
        boolean existe = usuariodao.existePorUsuarioESenha(usuarioAutenticar);
        
        
        //Se existe, executar para o menu
        if(existe) {
            MENUFRAME telaDeMenu = new MENUFRAME();
            telaDeMenu.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(View, "Usuário ou senha inválidos");
        }
    }

}
