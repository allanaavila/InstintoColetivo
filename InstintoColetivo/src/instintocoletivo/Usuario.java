package instintocoletivo;

public class Usuario {

    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private String telefone;
    private String senha;
    private String id_usuario;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return this.endereco;
    }

    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return this.senha;
    }
    
    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getId_usuario() {
        return this.id_usuario;
    }

  
    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", cpf=" + cpf + ", email=" + email 
                + ", endereco=" + endereco + ", telefone=" + telefone 
                + ", senha=" + senha + ", id_usuario=" + id_usuario + '}';
    }


}
