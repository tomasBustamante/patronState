package fiuba.algo3.modelo.estados;

import fiuba.algo3.modelo.pokemones.Pikachu;
import fiuba.algo3.modelo.pokemones.Pokemon;
import fiuba.algo3.modelo.excepciones.PokemonEstaDormidoException;

public class EstadoPikachuDormido implements EstadoPikachu {

    private int turnos;

    public EstadoPikachuDormido() {
        turnos = 3;
    }

    @Override
    public void impacTrueno(Pikachu pikachu, Pokemon otroAlgomon) {
        turnos -= 1;
        if (turnos > -1)
            throw new PokemonEstaDormidoException();
        pikachu.despertarse();
        pikachu.impacTrueno(otroAlgomon);
    }

}
