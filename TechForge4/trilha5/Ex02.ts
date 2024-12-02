/*Crie uma classe abstrata Inventory que gerencie um inventário de itens. Ela deve ter métodos abstratos addItem(item: string, quantity: number): void, removeItem(item: string): void e getInventory(): Record<string, number>. Dica: ver tipagem com Record para objetos com TypeScript

Crie duas subclasses WarehouseInventory e StoreInventory.
WarehouseInventory deve ter a capacidade de armazenar quantidades grandes e controlar os itens de forma genérica.
StoreInventory deve ter um limite de quantidade por item (máximo 10 unidades) e impedir que itens ultrapassem esse limite.
Ambos os inventários devem retornar uma lista de itens com suas quantidades disponíveis.*/
abstract class Inventory {
    protected items: Record<string, number>;
  
    constructor() {
      this.items = {};
    }
  
    abstract addItem(item: string, quantity: number): void;
    abstract removeItem(item: string): void;
  
    getInventory(): Record<string, number> {
      return this.items;
    }
}
  
  class WarehouseInventory extends Inventory {
    addItem(item: string, quantity: number): void {
      if (this.items[item]) {
        this.items[item] += quantity;
      } else {
        this.items[item] = quantity;
      }
    }
  
    removeItem(item: string): void {
      delete this.items[item];
    }
}
  
class StoreInventory extends Inventory {
    addItem(item: string, quantity: number): void {
      if (this.items[item]) {
        this.items[item] = Math.min(10, this.items[item] + quantity);
      } else {
        this.items[item] = Math.min(10, quantity);
      }
    }
  
    removeItem(item: string): void {
      delete this.items[item];
    }
}

const warehouse = new WarehouseInventory();
warehouse.addItem("Garfo", 50);
warehouse.addItem("Livro", 20);
warehouse.addItem("Cadeira", 30);
console.log(warehouse.getInventory());
  
const store = new StoreInventory();
store.addItem("Bola", 5);
store.addItem("Espada", 8);
store.addItem("Jarra", 10); 
console.log(store.getInventory());
  