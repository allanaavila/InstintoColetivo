
package instintocoletivo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioDao {
    private final String USUARIO="root";
    private final String SENHA="";
    private final String URL="jdbc:mysql://localhost:3306/instintocoletivo";
    private Connection con = null;
    private PreparedStatement st;
    private ResultSet rs;
    
    public Connection iniciar()throws SQLException{
        return con = DriverManager.getConnection(URL, USUARIO, SENHA);     
    }
    
    public void inserir(Usuario usuario, Connection con ) throws SQLException{
        
        try{
       String sql = "INSERT INTO usuario(nome, email, endereco, cpf, telefone, senha) VALUES(?,?,?,?,?,?)";
        st = con.prepareStatement(sql);
        
        st.setString(1, usuario.getNome());
        st.setString(2, usuario.getEmail());
        st.setString(3, usuario.getEndereco());
        st.setString(4, usuario.getCpf());
        st.setString(5, usuario.getTelefone());
        st.setString(6, usuario.getSenha());
        
        st.executeUpdate();
        
            System.out.println("Inserido com sucesso no Banco de Dados!");
            
        }
            finally{
            con.close();
            st.close();
        }
    }
    
    public boolean existeUsuario(String email, String senha, Connection con ) throws SQLException{
        
        boolean existeUsuario = false;
        try {
            String sql = "SELECT id_usuario, nome FROM usuario WHERE email = ? AND senha = ? ";
            st = con.prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, senha);
            
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                String nome = rs.getString("nome");
                
                System.out.println("Usuario "+ nome +" já existe na base de dados!");
                existeUsuario = true;
            }                                
        }
        finally{
            con.close();
            st.close();
        }
        
        return existeUsuario;
    }
    
        public Usuario selecionaUsuario(String emailCadastrado, Connection con ) throws SQLException{
        
        Usuario usuarioSelecionado = null;
        try {
            String sql = "SELECT id_usuario, nome, email, endereco, cpf, telefone, senha FROM usuario WHERE email = ?";
            st = con.prepareStatement(sql);
            st.setString(1, emailCadastrado);
            
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                String id_usuario = rs.getString("id_usuario");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String endereco = rs.getString("endereco");
                String cpf = rs.getString("cpf");
                String telefone = rs.getString("telefone");
                
                usuarioSelecionado = new Usuario();
                
                usuarioSelecionado.setId_usuario(id_usuario);
                usuarioSelecionado.setNome(nome);
                usuarioSelecionado.setEmail(email);
                usuarioSelecionado.setEndereco(endereco);
                usuarioSelecionado.setCpf(cpf);
                usuarioSelecionado.setTelefone(telefone);
                 
                System.out.println("Usuario "+ nome +" selecionado na base de dados!");
            }                                
        }
        finally{
            con.close();
            st.close();
        }
        
        return usuarioSelecionado;
    }
}
