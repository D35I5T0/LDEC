package LDEC;
public class ListaCategorias {
    private NodePrincipal primeiro; 
    private int qtd;
    private NodePrincipal ultimo;

    public boolean isEmpty() {
        return this.primeiro == null && this.qtd == 0 && this.ultimo == null;
    }
    
    public void inserir (Categoria categoria) {
        NodePrincipal novo = new NodePrincipal(categoria);
        NodePrincipal retorno = busca(categoria);
        if (isEmpty()) {
            this.primeiro = novo;
            this.ultimo = novo;
            this.primeiro.setProx(this.ultimo);
            this.primeiro.setAnte(this.ultimo);
            this.ultimo.setProx(this.primeiro);
            this.ultimo.setAnte(this.primeiro);
            this.qtd++;
            System.out.println("Inserção efetuada!");
        }
        else if (retorno != null) {
            System.out.println("Categoria já inserida");
        }
        else if (this.primeiro.getInfo().compareTo(categoria) > 0) {
            this.primeiro.setAnte(novo);
            novo.setProx(this.primeiro);
            novo.setAnte(this.ultimo);
            this.ultimo.setProx(novo);
            this.primeiro = novo;
            this.qtd++;
            System.out.println("Inserção efetuada!");
        }
        else if (this.ultimo.getInfo().compareTo(categoria) < 0) {
            this.ultimo.setProx(novo);
            novo.setAnte(this.ultimo);
            novo.setProx(this.primeiro);
            this.primeiro.setAnte(novo);
            this.ultimo = novo;
            this.qtd++;
            System.out.println("Inserção efetuada!");
        }
        else {
            NodePrincipal aux = this.primeiro;
            NodePrincipal anterior;
            do {
                if (aux.getInfo().compareTo(categoria) > 0) {
                    anterior = aux.getAnte();
                    anterior.setProx(novo);
                    novo.setAnte(anterior);
                    novo.setProx(aux);
                    aux.setAnte(novo);
                    this.qtd++;
                    System.out.println("Inserção efetuada!");
                }
                else {
                    aux = aux.getProx();
                }
            } while (aux != this.primeiro);

            System.out.println("Inserção efetuada!");
        }
    }

    public NodePrincipal busca (Categoria categoria) {
        NodePrincipal aux = this.primeiro;
        boolean achou = false;
        while (aux != null) {
            if (aux.getInfo().equals(categoria)) {
                achou = true;
                break;
            } 
            else if (aux.getInfo().compareTo(categoria) > 0) {
                break;
            }
            else {
                aux = aux.getProx();
            }
        }
        if (achou == false) {
            return null;
        } else {
            return aux;
        }
    }

    public void remover (Categoria categoria) {
        if (isEmpty()) {
            System.out.println("Lista vazia");
        }
        else if (this.primeiro.getInfo().equals(categoria)) {
            this.primeiro = this.primeiro.getProx();
            this.qtd--;
            if (this.qtd == 0) {
                this.ultimo = null;
            } else {
                this.primeiro.setAnte(this.ultimo);
                this.ultimo.setProx(this.primeiro);
            }
            System.out.println("Remoção efetuada!");
        }
        else if (this.ultimo.getInfo().equals(categoria)) {
            this.ultimo = this.ultimo.getAnte();
            this.ultimo.setProx(primeiro);
            this.primeiro.setAnte(this.ultimo);
            this.qtd--;
            System.out.println("Remoção efetuada!");
        }
        else {
            NodePrincipal retorno = busca(categoria);
            NodePrincipal prox, ant;

            if (retorno == null) {
                System.out.println("Valor não encontrado");
            }
            else {
                ant = retorno.getAnte();
                prox = retorno.getProx();
                ant.setProx(prox);
                prox.setAnte(ant);
                this.qtd--;
                System.out.println("Remoção efetuada!");
            }
        }
    }

    public void exibirLista() {
        NodePrincipal aux = this.primeiro;
        do {
            System.out.println(aux.getInfo().toString());
            aux = aux.getProx();
        } while (aux != this.primeiro);
    }
}
