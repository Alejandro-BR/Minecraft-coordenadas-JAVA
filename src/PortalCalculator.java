/**
 * PortalCalculator
 * 
 * Calculadora de coordenadas entre el Overworld y el Nether en Minecraft.
 * 
 *   _  __   _____   _   _   ______    _____   _____               ______   _______ 
 * |  \/  | |_   _| | \ | | |  ____|  / ____| |  __ \      /\     |  ____| |__   __|
 * | \  / |   | |   |  \| | | |__    | |      | |__) |    /  \    | |__       | |   
 * | |\/| |   | |   | . ` | |  __|   | |      |  _  /    / /\ \   |  __|      | |   
 * | |  | |  _| |_  | |\  | | |____  | |____  | | \ \   / ____ \  | |         | |   
 * |_|  |_| |_____| |_| \_| |______|  \_____| |_|  \_\ /_/    \_\ |_|         |_|  
 * 
 * @autor Alejandro Barrionuevo Rosado
 */

package src;

import java.util.HashMap;
import java.util.Map;

import src.color.Color;

public class PortalCalculator {

  private static final int CALCULAR = 1;
  private static final int LISTADO = 2;
  private static final int CREDITOS = 3;
  private static final int SALIR = 4;
  private static final int X = 0;
  private static final int Z = 1;
  private static final int Y = 2;

  private static HashMap<Coordenada, Coordenada> coordenadas = new HashMap<>();

  /**
   * Imprime el título de la aplicación en la consola.
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
   * Imprime el menú de opciones en la consola.
   */
  private static void imprimirMenu() {
    System.out.println("Menu: ");
    System.out.println("1 - Calcular coordenadas del portal.");
    System.out.println("2 - Listado.");
    System.out.println("3 - Creditos.");
    System.out.println("4 - Salir.\n");
  }

  /**
   * Limpia la pantalla del terminal.
   */
  private static void limpiar() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  /**
   * Solicita y devuelve la opción seleccionada por el usuario del menú.
   * Controla que sea dentro de los valores correctos.
   * 
   * @return int opción seleccionada
   */
  private static int perdirOpcion() {
    int opcion = 0;

    do {
      System.out.print("Opcion: ");
      opcion = Integer.parseInt(System.console().readLine());
    } while (opcion != CALCULAR && opcion != CREDITOS && opcion != LISTADO && opcion != SALIR);

    return opcion;
  }

  /**
   * Solicita al usuario las coordenadas X, Z, Y y las devuelve como un arreglo.
   * 
   * @return int[] arreglo de coordenadas
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
   * Calcula las coordenadas del portal del Overworld al Nether.
   * Llama al metodo pedirCoordenadas().
   * Llama al metodo nuevasCoordenadas().
   * Y muestra por pantalla.
   * 
   */
  private static void calcularCoordenadas() {
    int[] valores = pedirCoordenadas();
    Coordenada overworld = new Coordenada(valores[X], valores[Z], valores[Y]);
    Coordenada nether = Calculadora.calculCoordenadasNether(overworld);

    nuevasCoordenadas(overworld, nether);

    System.out.println(Color.GREEN);
    System.out.println(overworld.toString() + Color.RESET + " -> " + Color.RED + nether.toString());
    System.out.println(Color.RESET);
  }

  /**
   * Registra las nuevas coordenadas en el mapa de coordenadas.
   * 
   * @param overworld coordenadas en el Overworld
   * @param nether    coordenadas en el Nether
   */
  private static void nuevasCoordenadas(Coordenada overworld, Coordenada nether) {
    coordenadas.put(overworld, nether);
  }

  /**
   * Muestra un listado de todas las coordenadas registradas en el mapa.
   */
  private static void listado() {
    System.out.println("\nListado:");

    for (Map.Entry<Coordenada, Coordenada> entry : coordenadas.entrySet()) {
      Coordenada key = entry.getKey();
      Coordenada value = entry.getValue();
      System.out.println("Overworld: " + key + ", Nether: " + value);
    }
  }

  /**
   * Introduce un retardo de 2 segundos en la ejecución.
   */
  private static void retardo() {
    final int TIEMPO = 2000;

    try {
      Thread.sleep(TIEMPO);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   * Muestra los créditos del programa en la consola.
   */
  private static void mostrarCreditos() {
    System.out.println("\n  ╔══════════════════════════════════════════════════╗");
    System.out.println("  ║                                                  ║");
    System.out.println("  ║" + Color.CYAN + "                      CREDITOS                    " + Color.RESET + "║");
    System.out.println("  ║                                                  ║");
    System.out.println("  ║" + Color.CYAN + "           Alejandro Barrionuevo Rosado           " + Color.RESET + "║");
    System.out.println("  ║                                                  ║");
    System.out.println("  ╚══════════════════════════════════════════════════╝");
    System.out.println("\n");
  }

  /**
   * Muestra un mensaje de despedida al usuario antes de salir.
   */
  private static void mostrarSalida() {
    System.out.println(Color.CYAN);
    System.out.println("\nGracias por usar la app! 😁\n");
    System.out.println(Color.RESET);
  }

  /**
   * Método principal que ejecuta la aplicación y gestiona el menú de opciones.
   */
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
          retardo();
          break;
        case LISTADO:
          listado();
          retardo();
          retardo();
          break;
        case CREDITOS:
          limpiar();
          mostrarCreditos();
          retardo();
          break;
        default:
          salir = true;
          mostrarSalida();
          break;
      }
    } while (!salir);
  }
}
