package LDEC;
public class Filme implements Comparable <Filme> {
    private String titulo;
    private String genero;
    private String classificação;
    private int ano;

    public Filme(String titulo, String genero, String classificação, int ano) {
        this.titulo = titulo;
        this.genero = genero;
        this.classificação = classificação;
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClassificação() {
        return classificação;
    }

    public void setClassificação(String classificação) {
        this.classificação = classificação;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int compareTo (Filme filme) {
        int comparacaoTitulo = this.titulo.compareTo(filme.getTitulo());
        if (comparacaoTitulo == 0) {
            return Integer.compare(this.ano, filme.getAno());
        }
        return comparacaoTitulo;
    }    
}
