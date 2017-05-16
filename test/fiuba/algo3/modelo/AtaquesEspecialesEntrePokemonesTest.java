package fiuba.algo3.modelo;

import fiuba.algo3.modelo.excepciones.PokemonEstaDormidoException;
import fiuba.algo3.modelo.excepciones.JigglypuffNoPuedeDormirseException;
import fiuba.algo3.modelo.pokemones.Jigglypuff;
import fiuba.algo3.modelo.pokemones.Pikachu;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class AtaquesEspecialesEntrePokemonesTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void JigglypuffCantaYPikachuNoPuedeAtacarPorqueEstaDormido() {

        Pikachu pikachu = new Pikachu(); // Crea a Pikachu con 100 puntos de vida
        Jigglypuff jigglypuff = new Jigglypuff(); // Crea a Jigglypuff con 80 puntos de vida

        jigglypuff.cantar(pikachu); // pikachu pasa a estar dormido

        thrown.expect(PokemonEstaDormidoException.class);
        pikachu.impacTrueno(jigglypuff);
    }

    @Test
    public void LosPuntosDePikachuNoSonAlteradosCuandoJigglypuffCanta() {

        Pikachu pikachu = new Pikachu(); // Crea a Pikachu con 100 puntos de vida
        Jigglypuff jigglypuff = new Jigglypuff(); // Crea a Jigglypuff con 80 puntos de vida

        jigglypuff.cantar(pikachu); // pikachu pasa a estar dormido

        assertEquals(100, pikachu.getPuntos()); // los puntos de pikachu no son alterados
    }

    @Test
    public void JigglypuffNoRecibeDanioCuandoPikachuIntentaAtacarEstandoDormido() {

        Pikachu pikachu = new Pikachu(); // Crea a Pikachu con 100 puntos de vida
        Jigglypuff jigglypuff = new Jigglypuff(); // Crea a Jigglypuff con 80 puntos de vida

        jigglypuff.cantar(pikachu); // pikachu pasa a estar dormido

        try {
            pikachu.impacTrueno(jigglypuff);
        } catch (PokemonEstaDormidoException ignored) { }

        assertEquals(80, jigglypuff.getPuntos()); // los puntos de Jigglypuff no son alterados
    }

    @Test
    public void PikachuSigueSinPoderAtacarPorSegundaVezDespuesDeHaberseDormido() {

        Pikachu pikachu = new Pikachu(); // Crea a Pikachu con 100 puntos de vida
        Jigglypuff jigglypuff = new Jigglypuff(); // Crea a Jigglypuff con 80 puntos de vida

        jigglypuff.cantar(pikachu); // pikachu pasa a estar dormido

        thrown.expect(PokemonEstaDormidoException.class);
        try {
            pikachu.impacTrueno(jigglypuff);
        } catch (PokemonEstaDormidoException e) {
            pikachu.impacTrueno(jigglypuff);
        }
    }

    @Test
    public void PikachuSigueSinPoderAtacarPorTerceraVezDespuesDeHaberseDormido() {

        Pikachu pikachu = new Pikachu(); // Crea a Pikachu con 100 puntos de vida
        Jigglypuff jigglypuff = new Jigglypuff(); // Crea a Jigglypuff con 80 puntos de vida

        jigglypuff.cantar(pikachu); // pikachu pasa a estar dormido

        thrown.expect(PokemonEstaDormidoException.class);
        try {
            pikachu.impacTrueno(jigglypuff);
        } catch (PokemonEstaDormidoException e1) {
            try {
                pikachu.impacTrueno(jigglypuff);
            } catch (PokemonEstaDormidoException e2) {
                pikachu.impacTrueno(jigglypuff);
            }
        }
    }

    @Test
    public void JigglypuffCantaYPikachuNoPuedeAtacarPorTresTurnosPeroSiAlCuarto() {

        Pikachu pikachu = new Pikachu(); // Crea a Pikachu con 100 puntos de vida
        Jigglypuff jigglypuff = new Jigglypuff(); // Crea a Jigglypuff con 80 puntos de vida

        jigglypuff.cantar(pikachu); // pikachu pasa a estar dormido

        try {
            pikachu.impacTrueno(jigglypuff);
        } catch (PokemonEstaDormidoException e1) {
            try {
                pikachu.impacTrueno(jigglypuff);
            } catch (PokemonEstaDormidoException e2) {
                try {
                    pikachu.impacTrueno(jigglypuff);
                } catch (PokemonEstaDormidoException e3){ }
            }
        }

        pikachu.impacTrueno(jigglypuff); // quita 20 puntos

        assertEquals(60, jigglypuff.getPuntos());
    }

    @Test
    public void JigglypuffNoPuedeQuedarseDormido() {

        Jigglypuff jigglypuff1 = new Jigglypuff(); // Crea a un Jigglypuff con 80 puntos de vida
        Jigglypuff jigglypuff2 = new Jigglypuff(); // Crea a otro Jigglypuff con 80 puntos de vida

        thrown.expect(JigglypuffNoPuedeDormirseException.class);
        jigglypuff1.cantar(jigglypuff2);
    }

}
