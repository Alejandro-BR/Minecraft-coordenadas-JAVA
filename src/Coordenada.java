/**
 * Clase entity Coordenadas:
 * 
 * Esta clase representa las coordenadas
 * del videojuego MINECRAFT.
 * 
 * @author Alejandro Barrionuevo Rosado
 */

package src;

public class Coordenada {

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
  public Coordenada(int x, int z, int y) {
    this.x = x;
    this.z = z;
    this.y = y;
  }

  /**
   * Constructor con la altura.
   * 
   * @param z int 
   */
  public Coordenada(int z) {
    this.z = z;
    this.x = 0;
    this.y = 0;
  }

  /**
   * Constructor basico.
   */
  public Coordenada() {
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
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + x;
    result = prime * result + z;
    result = prime * result + y;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Coordenada other = (Coordenada) obj;
    if (x != other.x)
      return false;
    if (z != other.z)
      return false;
    if (y != other.y)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Coordenadas [ x = " + x + "| z = " + z + "| y = " + y + " ]";
  }

}