/*Crie uma classe abstrata VoteSystem que gerencie votos em uma competição. Ela deve ter métodos abstratos voteFor(candidate: string): void e getResults(): object.

Crie duas subclasses: Election e Poll.
Election deve permitir adicionar votos para um candidato específico e retornar o total de votos por candidato em um objeto.
Poll deve retornar uma lista dos candidatos em ordem de votos (do mais votado para o menos votado).*/
abstract class VoteSystem {
    protected votes: Map<string, number>;

    constructor() {
        this.votes = new Map<string, number>();
    }

    abstract voteFor(candidate: string): void;

    abstract getResults(): object;
}

class Election extends VoteSystem {
    voteFor(candidate: string): void {
        if (this.votes.has(candidate)) {
            this.votes.set(candidate, this.votes.get(candidate)! + 1);
        } else {
            this.votes.set(candidate, 1);
        }
    }

    getResults(): object {
        const results: Record<string, number> = {};
        this.votes.forEach((count, candidate) => {
            results[candidate] = count;
        });
        return results;
    }
}

class Poll extends VoteSystem {
    voteFor(candidate: string): void {
        if (this.votes.has(candidate)) {
            this.votes.set(candidate, this.votes.get(candidate)! + 1);
        } else {
            this.votes.set(candidate, 1);
        }
    }

    getResults(): object {
        return Array.from(this.votes.entries())
            .sort((a, b) => b[1] - a[1])
            .map(([candidate]) => candidate);
    }
}

const election = new Election();
election.voteFor("Alice");
election.voteFor("Bob");
election.voteFor("Alice");
console.log(election.getResults());

const poll = new Poll();
poll.voteFor("Charlie");
poll.voteFor("Alice");
poll.voteFor("Charlie");
poll.voteFor("Bob");
console.log(poll.getResults());