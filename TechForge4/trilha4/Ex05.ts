/*Crie uma interface LivroBiblioteca com as propriedades titulo (string), autor (string), genero (string) e disponivel (boolean).
 - Crie uma classe BibliotecaGestao que contenha um array de livros implementando a interface LivroBiblioteca.
Implemente os seguintes métodos:
 - filtrarPorGenero(genero: string): LivroBiblioteca[] - retorna um array de livros que pertencem ao gênero especificado.
 - buscarPorAutor(autor: string): LivroBiblioteca[] - retorna todos os livros escritos por um autor específico.
 - obterLivrosDisponiveisOrdenados(): LivroBiblioteca[] - retorna uma lista de todos os livros disponíveis, ordenada alfabeticamente pelo título.*/
interface LivroBiblioteca {
    titulo:string;
    autor:string;
    genero:string;
    disponivel:boolean;
}

class BibliotecaGestao implements LivroBiblioteca {
    private Livros: LivroBiblioteca[] = [];
    titulo: string;
    autor: string;
    genero: string;
    disponivel: boolean;

    constructor(livrosBiblioteca:LivroBiblioteca[]) {
        this.Livros = livrosBiblioteca;
    }

    filtrarPorGenero(genero:string): LivroBiblioteca[] {
        return this.Livros.filter((adcLivros) => adcLivros.genero === genero);
    }

    buscarPorAutor(autor:string): LivroBiblioteca[] {
        return this.Livros.filter((adcLivros) => adcLivros.autor === autor);
    }

    obterLivrosDisponiveisOrdenados(): LivroBiblioteca[] {
        return this.Livros
            .sort((a,b) => a.titulo.localeCompare(b.titulo));
    }

}

const adcLivros: LivroBiblioteca[] = [
    {titulo: 'O Progamador Pragmático: De Aprendiz a Mestre', autor: 'Dave Thomas', genero: 'Informática Linguagens', disponivel: true},
    {titulo: 'Código Limpo', autor: 'Roberto Cecil Martin', genero: 'Informática Linguagens', disponivel: false},
    {titulo: 'Refatoração: Aperfeiçoando o Design de Códigos Existentes', autor: 'Kent Beck', genero: 'Informática Linguagens', disponivel: false},
    {titulo: 'JavaScript: O Guia Definitivo', autor: 'David Flanagan', genero: 'Informática Linguagens', disponivel: true},
    {titulo: 'Engenharia de Software para Cientistas de Dados', autor: 'Catherine Nelson', genero: 'Informática Linguagens', disponivel: true}
];

//instanciar
const respostaLivros = new BibliotecaGestao(adcLivros);

console.log(respostaLivros.filtrarPorGenero("Informática Linguagens"));
console.log(respostaLivros.buscarPorAutor("Dave Thomas"));
console.log(respostaLivros.obterLivrosDisponiveisOrdenados());