/**
 * 
 * Clase entity Coordenadas:
 * 
 * Esta clase representa las coordenadas
 * del videojuego MINECRAFT.
 * 
 * @author Alejandro Barrionuevo Rosado
 */

package src;

public class Coordenadas {

  //////// Atributos
  private int x;
  private int z;
  private int y;

  //////// Constructores

  /**
   * Constructor completo.
   * 
   * @param x int
   * @param z int 
   * @param y int
   */
  public Coordenadas(int x, int z, int y) {
    this.x = x;
    this.z = z;
    this.y = y;
  }

  /**
   * Constructor con la altura.
   * 
   * @param z int 
   */
  public Coordenadas(int z) {
    this.z = z;
    this.x = 0;
    this.y = 0;
  }

  /**
   * Constructor basico.
   */
  public Coordenadas() {
    this.z = 0;
    this.x = 0;
    this.y = 0;
  }

  //////// Metodos

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getZ() {
    return z;
  }

  public void setZ(int z) {
    this.z = z;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  @Override
  public String toString() {
    return "Coordenadas [ x = " + x + "| z = " + z + "| y = " + y + " ]";
  }

}