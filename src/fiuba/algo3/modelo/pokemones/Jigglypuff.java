package fiuba.algo3.modelo.pokemones;

import fiuba.algo3.modelo.excepciones.JigglypuffNoPuedeDormirseException;

public class Jigglypuff extends Pokemon {

    public Jigglypuff() {
        puntos = 80;
    }

    public void cachetazo(Pokemon otroAlgomon) {
        otroAlgomon.recibirDanio(10);
    }

    public void cantar(Pokemon otroAlgomon) {
        otroAlgomon.dormirse();
    }

    @Override
    public void dormirse() {
        throw new JigglypuffNoPuedeDormirseException();
    }

    @Override
    public void despertarse() {

    }

}
