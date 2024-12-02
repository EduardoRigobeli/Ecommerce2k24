/*Crie uma interface chamada ProdutoLoja com as propriedades codigo (número) e nome (string).
Crie uma classe Loja que tenha um array de produtos que implemente a interface ProdutoLoja.
Implemente um método buscarProdutoPorCodigo(codigo: number): ProdutoLoja | undefined que recebe um código de produto e retorna o produto correspondente, caso exista; caso contrário, retorne undefined*/
// Definindo a interface ItemProduto
interface ItemProduto {
    codigo: number;
    nome: string;
}

class Loja implements ItemProduto{
    private produtos: ItemProduto[] = [];
    codigo: number;
    nome: string;

    constructor(produtos: ItemProduto[]) {
        this.produtos = produtos;
    }

    buscarProdutoPorCodigo(pesquisarCodigo: number): ItemProduto | undefined {
        return this.produtos.find(produto => produto.codigo === pesquisarCodigo);
    }
}

//adicionar os codigos e produtos
const produtos: ItemProduto[] = [
    {codigo: 1, nome: 'Notebook'},
    {codigo: 2, nome: 'Café'},
    {codigo: 3, nome: 'Cafeteira'},
    {codigo: 4, nome: 'Celular'},
    {codigo: 5, nome: 'Farinha'},
    {codigo: 6, nome: 'Televisão'}
];

//instanciar Loja
const loja = new Loja(produtos);

console.log(loja.buscarProdutoPorCodigo(3));
console.log(loja.buscarProdutoPorCodigo(7));//undefined
