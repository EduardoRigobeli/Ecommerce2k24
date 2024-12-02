/*Crie uma interface chamada Produto que tenha as propriedades id (número), nome (string) e preco (número).
Em seguida, crie uma classe ItemLoja que implemente (implements) essa interface.
No construtor da classe, atribua valores às propriedades id, nome e preco.*/
interface Produto {
    id:number;
    nome: string;
    preco: number;
    nomeLoja?:string;//com o "?" o atributo é opcional
}

class ItemLoja  implements Produto{
    id:number;
    nome:string;
    preco:number;

    constructor(idProd:number, nomeProd:string, precoProd:number) {
        this.id = idProd;
        this.nome = nomeProd;
        this.preco = precoProd;
    }

    exibirInfo() {
        console.log(`O id ${this.id} é do alimento: ${this.nome}, Preço: R$${this.preco},00`)
    }
}

const item1 = new ItemLoja(1, "Maçã", 4)
item1.exibirInfo();