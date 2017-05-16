package fiuba.algo3.modelo.pokemones;

import fiuba.algo3.modelo.estados.EstadoPikachu;
import fiuba.algo3.modelo.estados.EstadoPikachuDormido;
import fiuba.algo3.modelo.estados.EstadoPikachuNormal;

public class Pikachu extends Pokemon {

    private EstadoPikachu estado;

    public Pikachu() {
        puntos = 100;
        estado = new EstadoPikachuNormal();
    }

    public void impacTrueno(Pokemon otroAlgomon) {
        estado.impacTrueno(this, otroAlgomon);
    }

    @Override
    public void dormirse() {
        estado = new EstadoPikachuDormido();
    }

    @Override
    public void despertarse() {
        estado = new EstadoPikachuNormal();
    }

}
