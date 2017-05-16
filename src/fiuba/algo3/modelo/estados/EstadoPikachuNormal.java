package fiuba.algo3.modelo.estados;

import fiuba.algo3.modelo.pokemones.Pikachu;
import fiuba.algo3.modelo.pokemones.Pokemon;

public class EstadoPikachuNormal implements EstadoPikachu {

    @Override
    public void impacTrueno(Pikachu pikachu, Pokemon otroAlgomon) {
        otroAlgomon.recibirDanio(20);
    }

}
