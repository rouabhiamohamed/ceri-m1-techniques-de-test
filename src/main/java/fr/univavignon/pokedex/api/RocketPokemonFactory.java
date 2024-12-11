package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.collections4.map.UnmodifiableMap;

public class RocketPokemonFactory implements IPokemonFactory {
    /**
    * Une association entre les indices des Pokémon et leurs noms correspondants.
    * <p>
    * Cette map permet de récupérer le nom d'un Pokémon à partir de son indice.
    * Elle inclut des entrées prédéfinies pour des cas spéciaux, comme Pikachu de Sacha (-1)
    * et MISSINGNO (0). La map est immuable afin de garantir la cohérence dans son utilisation.
    * </p>
    *
    * <ul>
    * <li>Clé : Un entier représentant l'indice du Pokémon.</li>
    * <li>Valeur : Une chaîne de caractères représentant le nom du Pokémon.</li>
   * </ul>
    */

    private static Map<Integer, String> index2name;
    static {
   Map<Integer, String> aMap = new HashMap<Integer, String>();
        aMap.put(-1, "Ash's Pikachu");
        aMap.put(0, "MISSINGNO");
        aMap.put(1, "Bulbasaur");
        //TODO : Gotta map them all !
        index2name = UnmodifiableMap.unmodifiableMap(aMap);
   }

   private static int generateRandomStat() {
    int total = 0;
       for(int i=0; i < 1000000; i++)
   {
    Random rn = new Random();
      int r = rn.nextInt(2);
     total = total + r;
    }
     return total / 10000;
    }

    @Override
   public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
    String name;
      if(!index2name.containsKey(index)) {
    name = index2name.get(0);
    } else {
     name = index2name.get(index);
    }
    int attack;
    int defense;
    int stamina;
    double iv;
    if(index < 0) {
     attack = 1000;
     defense = 1000;
     stamina = 1000;
     iv = 0;
     } else {
     attack = RocketPokemonFactory.generateRandomStat();
     defense = RocketPokemonFactory.generateRandomStat();
     stamina = RocketPokemonFactory.generateRandomStat();
     iv = 1;
     }
    return new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);
   }
   }
