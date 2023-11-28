package LDEC;
public class NodeSecundario {
    private NodeSecundario ante;
    private Filme info;
    private NodeSecundario prox;

    public NodeSecundario(Filme info) {
        this.info = info;
    }

    public NodeSecundario getAnte() {
        return ante;
    }

    public void setAnte(NodeSecundario ante) {
        this.ante = ante;
    }

    public Filme getInfo() {
        return info;
    }

    public void setInfo(Filme info) {
        this.info = info;
    }

    public NodeSecundario getProx() {
        return prox;
    }
    
    public void setProx(NodeSecundario prox) {
        this.prox = prox;
    }
}
