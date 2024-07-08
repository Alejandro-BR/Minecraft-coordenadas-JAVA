/**
 * PortalCalculator
 * 
 *   _  __   _____   _   _   ______    _____   _____               ______   _______ 
 * |  \/  | |_   _| | \ | | |  ____|  / ____| |  __ \      /\     |  ____| |__   __|
 * | \  / |   | |   |  \| | | |__    | |      | |__) |    /  \    | |__       | |   
 * | |\/| |   | |   | . ` | |  __|   | |      |  _  /    / /\ \   |  __|      | |   
 * | |  | |  _| |_  | |\  | | |____  | |____  | | \ \   / ____ \  | |         | |   
 * |_|  |_| |_____| |_| \_| |______|  \_____| |_|  \_\ /_/    \_\ |_|         |_|  
 * 
 * @author Alejandro Barrionuevo Rosado
 */

package src;

import src.color.Color;

public class PortalCalculator {

  private static final int CALCULAR = 1;
  private static final int CREDITOS = 2;
  private static final int SALIR = 3;
  private static final int X = 0;
  private static final int Z = 1;
  private static final int Y = 2;

  /**
   * Titulo de la app.
   */
  private static void imprimirTitulo() {
    System.out.println(Color.GREEN);
    System.out.println(" __  __   _____   _   _   ______    _____   _____               ______   _______ ");
    System.out.println("|  \\/  | |_   _| | \\ | | |  ____|  / ____| |  __ \\      /\\     |  ____| |__   __|");
    System.out.println("| \\  / |   | |   |  \\| | | |__    | |      | |__) |    /  \\    | |__       | |   ");
    System.out.println("| |\\/| |   | |   | . ` | |  __|   | |      |  _  /    / /\\ \\   |  __|      | | ");
    System.out.println("| |  | |  _| |_  | |\\  | | |____  | |____  | | \\ \\   / ____ \\  | |         | | ");
    System.out.println("|_|  |_| |_____| |_| \\_| |______|  \\_____| |_|  \\_\\ /_/    \\_\\ |_|         |_|");
    System.out.println(Color.CYAN);
    System.out.println("╔══════════════════════════════════════════╗");
    System.out.println("║" + Color.RESET + "     MINECRAFT COORDENADAS DEL PORTAL     " + Color.CYAN + "║");
    System.out.println("╚══════════════════════════════════════════╝");
    System.out.println(Color.RESET);
  }

  /**
   * Menu
   */
  private static void imprimirMenu() {
    System.out.println("Menu: ");
    System.out.println("1 - Calcular coordenadas del portal.");
    System.out.println("2 - Creditos.");
    System.out.println("3 - Salir.\n");
  }

  /**
   * Borrar la pantalla del terminal.
   */
  private static void limpiar() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  /**
   * Pedir la opcion del menu.
   * 
   * @return int opcion
   */
  private static int perdirOpcion() {
    int opcion = 0;

    do {
      System.out.print("Opcion: ");
      opcion = Integer.parseInt(System.console().readLine());
    } while (opcion != CALCULAR && opcion != CREDITOS && opcion != SALIR);

    return opcion;
  }

  /**
   * Pedir las coordenadas.
   * 
   * @return int[] valores
   */
  private static int[] pedirCoordenadas() {

    final int CANTIDAD = 3;

    int[] valores = new int[CANTIDAD];

    System.out.print("\nIntroduce la coordenada X: ");
    valores[X] = Integer.parseInt(System.console().readLine());

    System.out.print("Introduce la coordenada Z: ");
    valores[Z] = Integer.parseInt(System.console().readLine());

    System.out.print("Introduce la coordenada Y: ");
    valores[Y] = Integer.parseInt(System.console().readLine());

    return valores;
  }

  /**
   * Calcular las coordenadas.
   */
  private static void calcularCoordenadas() {
    int[] valores = pedirCoordenadas();
    Coordenadas overworld = new Coordenadas(valores[X], valores[Z], valores[Y]);
    Coordenadas nether = Calculadora.calculCoordenadasNether(overworld);

    System.out.println(Color.GREEN);
    System.out.println(overworld.toString() + Color.RESET + " -> " + Color.RED + nether.toString());
    System.out.println(Color.RESET);
  }

  /**
   * Retardo.
   */
  private static void retardo() {
    final int TIEMPO = 2000;

    try {
      Thread.sleep(TIEMPO);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {

    boolean salir = false;
    int menu = 0;

    do {
      limpiar();
      imprimirTitulo();
      imprimirMenu();
      menu = perdirOpcion();

      switch (menu) {
        case CALCULAR:
          calcularCoordenadas();
          break;
        case CREDITOS:
          System.out.println(Color.CYAN);
          System.out.println("\nAutor: Alejandro Barrionuevo Rosado\n");
          System.out.println(Color.RESET);
          break;

        default:
          salir = true;
          System.out.println(Color.CYAN);
          System.out.println("\nGracias por usar la app!\n");
          System.out.println(Color.RESET);
          break;
      }

      retardo();
    } while (!salir);
  }
}
