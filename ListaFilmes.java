package LDEC;
public class ListaFilmes {
    private NodeSecundario primeiro;
    private int qtd;
    private NodeSecundario ultimo;

    public boolean isEmpty() {
        return this.primeiro == null && this.qtd == 0 && this.ultimo == null;
    }
    
    public void inserir (Filme filme) {
        NodeSecundario novo = new NodeSecundario(filme);
        NodeSecundario retorno = busca(filme);
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
        else if (this.primeiro.getInfo().compareTo(filme) > 0) {
            this.primeiro.setAnte(novo);
            novo.setProx(this.primeiro);
            novo.setAnte(this.ultimo);
            this.ultimo.setProx(novo);
            this.primeiro = novo;
            this.qtd++;
            System.out.println("Inserção efetuada!");
        }
        else if (this.ultimo.getInfo().compareTo(filme) < 0) {
            this.ultimo.setProx(novo);
            novo.setAnte(this.ultimo);
            novo.setProx(this.primeiro);
            this.primeiro.setAnte(novo);
            this.ultimo = novo;
            this.qtd++;
            System.out.println("Inserção efetuada!");
        }
        else {
            NodeSecundario aux = this.primeiro;
            NodeSecundario anterior;
            do {
                if (aux.getInfo().compareTo(filme) > 0) {
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

    public NodeSecundario busca (Filme filme) {
        NodeSecundario aux = this.primeiro;
        boolean achou = false;
        while (aux != null) {
            if (aux.getInfo().equals(filme)) {
                achou = true;
                break;
            } 
            else if (aux.getInfo().compareTo(filme) > 0) {
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

    public void remover (Filme filme) {
        if (isEmpty()) {
            System.out.println("Lista vazia");
        }
        else if (this.primeiro.getInfo().equals(filme)) {
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
        else if (this.ultimo.getInfo().equals(filme)) {
            this.ultimo = this.ultimo.getAnte();
            this.ultimo.setProx(primeiro);
            this.primeiro.setAnte(this.ultimo);
            this.qtd--;
            System.out.println("Remoção efetuada!");
        }
        else {
            NodeSecundario retorno = busca(filme);
            NodeSecundario prox, ant;

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
        NodeSecundario aux = this.primeiro;
        do {
            System.out.println(aux.getInfo().toString());
            aux = aux.getProx();
        } while (aux != this.primeiro);
    }
}
