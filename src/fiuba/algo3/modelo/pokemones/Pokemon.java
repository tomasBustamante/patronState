package fiuba.algo3.modelo.pokemones;

import fiuba.algo3.modelo.excepciones.PokemonEstaMuertoException;

public abstract class Pokemon {

    protected int puntos;

    public int getPuntos() {
        return puntos;
    }

    public void recibirDanio(int danio) {
        if (puntos <= 0) {
            throw new PokemonEstaMuertoException();
        }
        puntos -= danio;
    }

    public abstract void dormirse();

    public abstract void despertarse();

}
