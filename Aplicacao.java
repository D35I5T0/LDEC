package LDEC;
import java.util.Scanner;
public class Aplicacao {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int op;
        String nomeCategoria, titulo, genero, classificacao;
        int ano;
        Filme filme;
        Categoria categoria;
        ListaCategorias listaCategorias = new ListaCategorias();

        do {
            menu();
            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1: 
                    System.out.println("Informe o nome da categoria: ");
                    nomeCategoria = sc.nextLine();
                    categoria = new Categoria(nomeCategoria);

                    System.out.println("Informe o título: ");
                    titulo = sc.nextLine();
                    System.out.println("Informe o gênero: ");
                    genero = sc.nextLine();
                    System.out.println("Informe a classificação: ");
                    classificacao = sc.nextLine();
                    System.out.println("Informe o ano: ");
                    ano = Integer.parseInt(sc.nextLine());
                    filme = new Filme(titulo, genero, classificacao, ano);

                    cadastrarFilme(filme, categoria, listaCategorias);
                    break;
                case 2: 
                    System.out.println("Informe o nome da categoria: ");
                    nomeCategoria = sc.nextLine();
                    categoria = new Categoria(nomeCategoria);

                    System.out.println("Informe o título: ");
                    titulo = sc.nextLine();
                    System.out.println("Informe o gênero: ");
                    genero = sc.nextLine();
                    System.out.println("Informe a classificação: ");
                    classificacao = sc.nextLine();
                    System.out.println("Informe o ano: ");
                    ano = Integer.parseInt(sc.nextLine());
                    filme = new Filme(titulo, genero, classificacao, ano);
                    removerFilme(categoria, filme, listaCategorias);
                    break;
                case 3:
                    System.out.println("Informe o nome da categoria: ");
                    nomeCategoria = sc.nextLine();
                    categoria = new Categoria(nomeCategoria);

                    System.out.println("Informe o título: ");
                    titulo = sc.nextLine();
                    System.out.println("Informe o gênero: ");
                    genero = sc.nextLine();
                    System.out.println("Informe a classificação: ");
                    classificacao = sc.nextLine();
                    System.out.println("Informe o ano: ");
                    ano = Integer.parseInt(sc.nextLine());
                    filme = new Filme(titulo, genero, classificacao, ano);
                    exibirFilme(categoria, filme, listaCategorias);
                    break;
                case 4:
                    System.out.println("Informe o nome da categoria: ");
                    nomeCategoria = sc.nextLine();
                    categoria = new Categoria(nomeCategoria);

                    System.out.println("Informe o título: ");
                    titulo = sc.nextLine();
                    System.out.println("Informe o gênero: ");
                    genero = sc.nextLine();
                    System.out.println("Informe a classificação: ");
                    classificacao = sc.nextLine();
                    System.out.println("Informe o ano: ");
                    ano = Integer.parseInt(sc.nextLine());
                    filme = new Filme(titulo, genero, classificacao, ano);
                    editarFilme(categoria, filme, listaCategorias);
                    break;
                case 5:
                    exibirTudo(listaCategorias);
                    break;
                case 6:
                    System.out.println("Informe o nome da categoria: ");
                    nomeCategoria = sc.nextLine();
                    categoria = new Categoria(nomeCategoria);
                    exibirCategoria(categoria, listaCategorias);
                    break;
                case 0:
                    System.out.println("Fim de programa");
                    break;
                default: 
                    System.out.println("Digite novamente");
            }
        }while (op != 0);
        sc.close();
    }

    public static void menu() {
        System.out.println("1 - Cadastrar um filme");
        System.out.println("2 - Remover um filme");
        System.out.println("3 - Exibir dados de um filme");
        System.out.println("4 - Editar dados de um filme");
        System.out.println("5 - Exibir tudo");
        System.out.println("6 - Exibir todos os filmes de uma categoria");
        System.out.println("0 - Finalizar programa");
    }

    public static void cadastrarFilme(Filme filme, Categoria categoria, ListaCategorias listaCategorias) {
        NodePrincipal categoriaExistente = listaCategorias.busca(categoria);
        if (categoriaExistente != null) {
            categoriaExistente.getInfo().getLista().inserir(filme);
        }
        else {
            categoria.getLista().inserir(filme);
            listaCategorias.inserir(categoria);
        }
    }

    public static void removerFilme(Categoria categoria, Filme filme, ListaCategorias listaCategorias) {
        NodePrincipal categoriaExistente = listaCategorias.busca(categoria);
        if(categoriaExistente != null) {
            NodeSecundario filmeExistente = categoriaExistente.getInfo().getLista().busca(filme);
            if (filmeExistente != null) {
                categoriaExistente.getInfo().getLista().remover(filme);
            }
            else {
                System.out.println("Filme não cadastrado");
            }
        }
        else {
            System.out.println("Categoria não encontrada");
        }
    }

    public static void exibirFilme (Categoria categoria, Filme filme, ListaCategorias listaCategorias) {
        NodePrincipal categoriaExistente = listaCategorias.busca(categoria);
        if(categoriaExistente != null) {
            ListaFilmes listaFilmes = categoriaExistente.getInfo().getLista();
            NodeSecundario filmeExistente = listaFilmes.busca(filme);
            if (filmeExistente != null) {
                System.out.println(filmeExistente.getInfo().toString());
            }
            else {
                System.out.println("Filme não cadastrado");
            }
        }
        else {
            System.out.println("Categoria não encontrada");
        }
    }

    public static void editarFilme(Categoria categoria, Filme filme, ListaCategorias listaCategorias) {
        Scanner sc = new Scanner(System.in); 
        NodePrincipal categoriaExistente = listaCategorias.busca(categoria);
        if(categoriaExistente != null) {
            ListaFilmes listaFilmes = categoriaExistente.getInfo().getLista();
            NodeSecundario filmeExistente = listaFilmes.busca(filme);
            if (filmeExistente != null) {
                System.out.println("Informe o título: ");
                String titulo = sc.nextLine();
                System.out.println("Informe o gênero: ");
                String genero = sc.nextLine();
                System.out.println("Informe a classificação: ");
                String classificacao = sc.nextLine();
                System.out.println("Informe o ano: ");
                int ano = Integer.parseInt(sc.nextLine());
                Filme novoFilme = new Filme(titulo, genero, classificacao, ano);
                filmeExistente.setInfo(novoFilme);
            }
            else {
                System.out.println("Filme não cadastrado");
            }
        }
        else {
            System.out.println("Categoria não encontrada");
        }
        sc.close();
    }

    public static void exibirTudo(ListaCategorias listaCategorias) {
        listaCategorias.exibirLista();
    }

    public static void exibirCategoria (Categoria categoria,  ListaCategorias listaCategorias) {
        NodePrincipal categoriaExistente = listaCategorias.busca(categoria);
        if(categoriaExistente != null) {
            ListaFilmes listaFilmes = categoriaExistente.getInfo().getLista();
            listaFilmes.exibirLista();
        }
        else {
            System.out.println("Categoria não encontrada");
        }
    }
}
