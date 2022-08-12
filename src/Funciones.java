import java.util.ArrayList;
import java.util.Scanner;

public class Funciones {

    Scanner lectu = new Scanner(System.in);
    public void MenuPrincipal(){
        System.out.println("\nEscoge una opción");
        System.out.println("1. Crear Cuenta");
        System.out.println("2. Ingresar a mi cuenta");
        System.out.println("0. Salir");
    }



    public void MenuFunciones(){
        System.out.println("\nEscoge una opción");
        System.out.println("1. Visualizaciones");
        System.out.println("2. Procesos");
        System.out.println("3. Modificaciones");
        System.out.println("0. Salir");
    }

    public void SubMenu(int option){
        switch (option){
            case 1:
                System.out.println("Mostrar: ");
                System.out.println("1. Datos");
                System.out.println("2. Cedula");
                System.out.println("3. Nombre");
                System.out.println("4. Tipo de cuenta");
                System.out.println("5. Saldo");
                System.out.println("6. Monto");
                System.out.println("0. Salir");
                break;
            case 2:
                System.out.println("Quiero:");
                System.out.println("1. Retirar dinero");
                System.out.println("2. Depositar dinero");
                System.out.println("3. Transferir dinero");
                System.out.println("4. Ver Ultimos retiros");
                System.out.println("5. Ver ultimos depositos");
                System.out.println("0. Salir");
                break;
            case 3:
                System.out.println("Modificar:");
                System.out.println("1. Nombre");
                System.out.println("2. Cedula");
                System.out.println("3. Monto máximo");
                System.out.println("0. Salir");
                break;
        }
    }

}
