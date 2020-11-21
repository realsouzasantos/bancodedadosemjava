
package controller;


import Modelos.Usuario;
import View.FormCadastroView;
import dao.UsuarioDAO;
import dao.conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;




public class FormCadastroController {
    
  private FormCadastroView View ;

    public FormCadastroController(FormCadastroView View) {
        this.View = View;
    }
    
    public void salvaUsuario() {
        
        String usuario = View.getjTextFieldusuario().getText();
        String senha = View.getjPasswordFieldsenha().getText();    
        
        Usuario usuarioxande = new Usuario(usuario,senha);
       
        try {
            Connection conexao = new conexao().getConnection();
            UsuarioDAO usuariodao = new UsuarioDAO(conexao);
            usuariodao.insert(usuarioxande);
            
            JOptionPane.showMessageDialog(null, "Usuário salvo com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(FormCadastroView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
