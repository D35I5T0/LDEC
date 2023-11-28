package LDEC;
public class Categoria implements Comparable <Categoria> {
    private String descricao;
    private ListaFilmes lista;

    public Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ListaFilmes getLista() {
        return lista;
    }

    public void setLista(ListaFilmes lista) {
        this.lista = lista;
    }

    public String toString() {
        return this.descricao;
    }

    public int compareTo(Categoria categoria) {
        return this.descricao.compareTo(categoria.getDescricao());
    }
}
