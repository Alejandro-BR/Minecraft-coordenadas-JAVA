/**
 * Calculadora:
 * 
 * Esta clase calcula las coordenadas del portal 
 * del nether en MINECRAFT.
 * 
 * @author Alejandro Barrionuevo Rosado
 */

package src;

public class Calculadora {

  //////// Atributo
  private final static int DIVISOR = 8;

  //////// Metodos

  /**
   * calculCoordenadasNether:
   * 
   * Calcula las coordenadas del nether
   * a traves de las del overworld.
   * 
   * @param overworld Coordenadas
   * @return Coordenadas nether
   */
  public static Coordenadas calculCoordenadasNether(Coordenadas overworld) {
    Coordenadas nether = new Coordenadas(overworld.getZ());
    nether.setX(overworld.getX() / DIVISOR);
    nether.setY(overworld.getY() / DIVISOR);
    return nether;
  }
}
