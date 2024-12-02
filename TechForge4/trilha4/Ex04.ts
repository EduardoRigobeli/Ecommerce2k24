/*Crie uma interface Livro com as propriedades titulo (string), autor (string) e disponivel (boolean).
Crie uma classe Biblioteca que contenha um array de livros que implementem Livro.
Implemente um método buscarLivrosDisponiveis() que retorne um array com todos os livros cuja propriedade disponivel seja true.*/
interface Livro {
    titulo: string;
    autor: string;
    disponivel: boolean;
}

class Biblioteca implements Livro {
    titulo: string;
    autor: string;
    disponivel: boolean;
    private livros: Livro[] = [];

    constructor(livrosBiblioteca:Livro[]) {
        this.livros = livrosBiblioteca;
    }

    buscarLivrosDisponiveis() {
        return this.livros.filter((livros) => livros.disponivel === true);
    }
}

const livros: Livro[] = [
    {titulo: 'Código Limpo', autor: 'Roberto Cecil Martin', disponivel: true},
    {titulo: 'O Progamador Pragmático: De Aprendiz a Mestre', autor: 'Dave Thomas', disponivel: false},
    {titulo: 'Refatoração: Aperfeiçoando o Design de Códigos Existentes', autor: 'Kent Beck', disponivel: true}
];

//instaciar 
const respLivros = new Biblioteca(livros);

console.log(respLivros.buscarLivrosDisponiveis());