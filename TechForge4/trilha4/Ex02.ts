/*Crie uma interface chamada Documento com as propriedades titulo (string) e conteudo (string).
Implemente essa interface em uma classe chamada Texto e crie um método exibir() que retorna uma string com o título e o conteúdo formatados da seguinte forma: "Título: [titulo], Conteúdo: [conteudo]".*/
interface Documento {
    titulo:string;
    conteudo:string;
}

class Texto implements Documento {
    titulo: string;
    conteudo: string;

    constructor(titulo:string, conteudo:string) {
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public getTitulo() {
        return this.titulo;
    }

    public setTitulo() {
        return this.titulo;
    }

    public getConteudo() {
        return this.conteudo;
    }

    public setConteudo() {
        return this.conteudo;
    }

    public exibir(): string {
        return `Título: [${this.titulo}], Conteúdo: [${this.conteudo}]`
    }
}

let texto1 = new Texto("Diário de um Banana", "Vida de um adolescente revoltado");
console.log(texto1.exibir());