package LDEC;
public class NodePrincipal {
    private NodePrincipal ante;
    private Categoria info;
    private NodePrincipal prox;

    public NodePrincipal (Categoria info) {
        this.info = info;
    }
    
    public NodePrincipal getAnte() {
        return ante;
    }

    public void setAnte(NodePrincipal ante) {
        this.ante = ante;
    }

    public Categoria getInfo() {
        return info;
    }

    public void setInfo(Categoria info) {
        this.info = info;
    }

    public NodePrincipal getProx() {
        return prox;
    }

    public void setProx(NodePrincipal prox) {
        this.prox = prox;
    }
}
