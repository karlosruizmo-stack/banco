import java.util.Scanner;

// CLASE USUARIO ---
class Usuario {
    private String nombre;
    private String dni;
    private int edad;

    public Usuario(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public String toString() {
        return "Titular: " + nombre + " | DNI: " + dni + " | Edad: " + edad;
    }
}

// CLASE CUENTA ---
class Cuenta {
    private Usuario titular;
    private double saldo;

    public Cuenta(Usuario titular, double saldoInicial) {
        this.titular = titular;
        // Si el saldo inicial es negativo, lo ponemos a 0
        this.saldo = Math.max(saldoInicial, 0);
    }

    public void ingresar(double cantidad) {
        if (cantidad > 0) {
            this.saldo += cantidad;
            System.out.println(">>> ¡Ingreso exitoso! Has depositado: " + cantidad);
        } else {
            System.out.println(">>> Error: La cantidad a ingresar debe ser positiva.");
        }
    }

    public void retirar(double cantidad) {
        if (cantidad > 0) {
            this.saldo -= cantidad;
            System.out.println(">>> Retirada completada: " + cantidad);
        } else {
            System.out.println(">>> Error: Cantidad no válida.");
        }
    }

    public void mostrarInfo() {

        System.out.println("ESTADO DE LA CUENTA   ");
        System.out.println(titular.toString());
        System.out.printf("Saldo disponible: $%.2f\n", saldo);
    }
}

//  menu principal
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // 1. Registro Usuario
        System.out.println(" Registro de Nuevo Cliente ");
        System.out.print("Nombre completo: ");
        String nombre = teclado.nextLine();
        System.out.print("DNI: ");
        String dni = teclado.nextLine();
        System.out.print("Edad: ");
        int edad = teclado.nextInt();

        Usuario cliente = new Usuario(nombre, dni, edad);
        Cuenta miCuenta = new Cuenta(cliente, 0); // Iniciamos con saldo 0

        // 2. Menú para usuario
        int opcion;
        do {
            System.out.println("¿Qué operación desea realizar?");
            System.out.println("1. Ver información");
            System.out.println("2. Ingresar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    miCuenta.mostrarInfo();
                    break;
                case 2:
                    System.out.print("Cantidad a ingresar: ");
                    double ingreso = teclado.nextDouble();
                    miCuenta.ingresar(ingreso);
                    break;
                case 3:
                    System.out.print("Cantidad a retirar: ");
                    double retiro = teclado.nextDouble();
                    miCuenta.retirar(retiro);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }
}
