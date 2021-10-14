
package instintocoletivo;

public class Denuncia {

    private String tipoDenuncia;
    private String descricao;
    private String endereco;

    public void setTipoDenuncia(String tipoDenuncia) {
        this.tipoDenuncia = tipoDenuncia;
    }

    public String getTipoDenuncia() {
        return this.tipoDenuncia;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return this.endereco;
    }
}
