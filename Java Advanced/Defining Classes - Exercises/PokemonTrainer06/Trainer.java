package PokemonTrainer06;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer {
    private String name;
    private int badgesCount = 0;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.badgesCount = 0;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getBadgesCount() {
        return badgesCount;
    }

    public int getPokemonsCount() {
        return this.pokemons.size();
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void processElement(String element) {
        if(isPokemon(element)) {
            this.badgesCount++;
        } else {
            pokemons.forEach(Pokemon::reducePokemonHealth);
            this.pokemons = this.pokemons.stream()
                    .filter(Pokemon::isAlive)
                    .collect(Collectors.toList());
        }
    }

    private boolean isPokemon(String element) {
        return this.pokemons.stream().anyMatch(pokemon -> pokemon.getElement().equals(element));
    }

    public int compareTo(Trainer other) {
        return Integer.compare(other.badgesCount, this.badgesCount);
    }
    @Override
    public String toString() {
        return String.format("%s %d %d",this.getName(),this.getBadgesCount(),this.getPokemonsCount());
    }
}
