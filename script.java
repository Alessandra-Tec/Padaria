/**/
import java.util.*;

interface Produto {
    String getNome();
    double getPreco();
}

abstract class ProdutoPadaria implements Produto {
    private String nome;
    private double preco;
   
    public ProdutoPadaria(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }
   
    public double getPreco() {
        return preco;
    }
}

class Item extends ProdutoPadaria {
    public Item(String nome, double preco) {
        super(nome, preco);
    }
}

public class Main
{
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
   
    Item paoDeSal = new Item("Pão de sal - R$", 0.50);
    Item paoDeQueijo = new Item("Pão de queijo - R$", 1.00);
    Item biscoitoDoce = new Item("Biscoito doce - R$", 1.50);
    Item biscoitoSalgado = new Item("Biscoito salgado - R$", 1.30);
    Item tortalete = new Item("Tortalete - R$", 2.00);
    Item boloAniversario = new Item("Bolo de aniversário - R$", 60.00);
    Item pizza = new Item("Pizza - R$", 30.00);
    Item salgadoParaFesta = new Item("Salgados para festa - R$", 25.00);
    Item cafeExpresso = new Item("Café expresso - R$", 2.00);
    Item cafeComLeite = new Item("Café com leite - R$", 3.50);
    Item leiteQuente = new Item("Leite quente - R$", 1.50);
    Item suco = new Item("Suco - R$", 4.00);
    Item refrigerante = new Item("Refrigerante - R$", 5.00);
   
    Produto[] produtos = {
       paoDeSal, paoDeQueijo, biscoitoDoce, biscoitoSalgado, tortalete, boloAniversario,
       pizza, salgadoParaFesta, cafeExpresso, cafeComLeite, leiteQuente, suco, refrigerante
    };
   
    ArrayList<Produto> produtosEscolhidos = new ArrayList<>();
    ArrayList<Integer> quantidades = new ArrayList<>();
   
    System.out.println("\n          Bem-vindo à Padaria A&A Gourmet Bites!");
    System.out.println("                           ...");
    System.out.println("+----------------------------------------------------------+");
    System.out.println("|  Aprecie o nosso menu e adicione os itens ao seu pedido: |");
    for(int i = 0; i < produtos.length; i++) {
       System.out.println("   " + (i+1) + ". " + produtos[i].getNome() + produtos[i].getPreco());
    }
    System.out.println("|                           ...                            |");
    System.out.println("+----------------------------------------------------------+");

    System.out.println("Obs.: digite qualquer número que não esteja na lista para sair.");
    System.out.println("\n[Pedido]");
    int continuar = 0;
    do {
       System.out.print("\nInforme o número do item: ");
       int escolha = sc.nextInt() - 1;
       if(escolha < 0) {
           break;
       }
       if(escolha > 12) {
           break;
       }
       System.out.print("Informe a quantidade que deseja: ");
       int quantidade = sc.nextInt();
       
       produtosEscolhidos.add(produtos[escolha]);
       quantidades.add(quantidade);
       
       System.out.print("Digite '1' para continuar ou '2' para finalizar: ");
       continuar = sc.nextInt();
    } while(continuar == 1);
   
    double total = 0.0;
    System.out.println("\n             Nota Fiscal");
    System.out.println(" ---------------------------------------");
    for(int i = 0; i < produtosEscolhidos.size(); i++) {
       Produto produto = produtosEscolhidos.get(i);
       int quantidade = quantidades.get(i);
       double totalPorProduto = produto.getPreco() * quantidade;
       
       System.out.println("  " + quantidade + " x " + produto.getNome() + totalPorProduto);
       total += totalPorProduto;
    }
   
    System.out.println(" _______________________________________");
    System.out.println("\n  Total: R$" + total);
    System.out.println("\n  Agradecemos a preferência, volte sempre!");
    }
}
