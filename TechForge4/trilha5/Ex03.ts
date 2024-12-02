/*Implemente uma classe abstrata FavoriteManager que gerencia listas de itens favoritos. Ela deve ter métodos abstratos addFavorite(item: string): void e getFavorites(): string[].

Crie duas subclasses: MoviesFavoriteManager e BooksFavoriteManager.
MoviesFavoriteManager deve gerenciar uma lista de filmes favoritos sem itens duplicados e retornar a lista em ordem alfabética. Dica: pesquisar pelo método sort para arrays em JavaScript
BooksFavoriteManager deve gerenciar uma lista de livros favoritos, mas sempre que um novo item é adicionado, ele deve ser inserido no início da lista. */
abstract class FavoriteManager {
    protected favorites: Set<string>;
  
    constructor() {
      this.favorites = new Set<string>();
    }
  
    abstract addFavorite(item: string): void;
    abstract getFavorites(): string[];
}
  
class MoviesFavoriteManager extends FavoriteManager {
    addFavorite(item: string): void {
      this.favorites.add(item);
    }
  
    getFavorites(): string[] {
      return Array.from(this.favorites).sort();
    }
}
  
class BooksFavoriteManager extends FavoriteManager {
    addFavorite(item: string): void {
      const newFavorites = new Set([item, ...this.favorites]);
      this.favorites = newFavorites;
    }
  
    getFavorites(): string[] {
      return Array.from(this.favorites);
    }
}

const moviesManager = new MoviesFavoriteManager();
moviesManager.addFavorite("Como Treinar o seu Dragão");
moviesManager.addFavorite("Matrix");
moviesManager.addFavorite("Vingadores");
moviesManager.addFavorite("Motoqueiro Fantasma");
console.log(moviesManager.getFavorites());
  
const booksManager = new BooksFavoriteManager();
booksManager.addFavorite("O Progamador Pragmático: De Aprendiz a Mestre");
booksManager.addFavorite("Código Limpo");
booksManager.addFavorite("JavaScript: O Guia Definitivo");
console.log(booksManager.getFavorites());