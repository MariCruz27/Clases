import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Creación de tres cuentas
        ArrayList<CuentaBancaria> cuentas = new ArrayList<CuentaBancaria>();
        //Prototipo
        CuentaBancaria cuenta = new CuentaBancaria();
        Funciones funcion = new Funciones();

        Scanner nums = new Scanner(System.in);
        Scanner texts = new Scanner(System.in);

        int option, process, processTwo;
        String cuentaTransfer; //Cuenta a transferir
        int posiTransfer;
        do {
            funcion.MenuPrincipal();//Register or login
            option = nums.nextInt();

            //Variables para verificación
            String numCuenta;
            int posi = 0;

            if (option==1){
                cuenta.crearPerfil();
                cuentas.add(cuenta);
            }if(option==2){
                //Hallar cuenta
                System.out.println("Ingresa el número de tu cuenta");
                numCuenta = texts.next();
                for (int i = 0; i<cuentas.size();i++){
                    if (cuentas.get(i).getMostrarNumCuenta().equals(numCuenta)){
                        posi = i;
                    }else{
                        posi=-1;
                    }
                }
                if (posi>=0){
                    do{
                        //Menú de funciones
                        funcion.MenuFunciones();
                        process = nums.nextInt();
                        if (process>=0 && process<4){
                            do{
                                funcion.SubMenu(process);
                                processTwo = nums.nextInt();
                                if (process==1){
                                    switch (processTwo) {
                                        case 1:
                                            System.out.println(cuentas.get(posi).to_String());
                                            break;
                                        case 2:
                                            System.out.println(cuentas.get(posi).getMostrarCedula());
                                            break;
                                        case 3:
                                            System.out.println(cuentas.get(posi).getMostrarNombre());
                                            break;
                                        case 4:
                                            System.out.println(cuentas.get(posi).getMostrarTipo());
                                            break;
                                        case 5:
                                            System.out.println(cuentas.get(posi).getMostrarSaldo());
                                            break;
                                        case 6:
                                            System.out.println(cuentas.get(posi).getMostrarMontoMax());
                                            break;
                                    }
                                } else if (process==2) {
                                    switch (processTwo) {
                                        case 1:
                                            cuentas.get(posi).retirarDinero();
                                            break;
                                        case 2:
                                            cuentas.get(posi).depositarDinero();
                                            break;
                                        case 3:
                                            //Pedir otra cuenta

                                            System.out.println("Ingresa el número de la cuenta a transferir: ");
                                            cuentaTransfer = texts.next();
                                            for (int i = 0; i<cuentas.size();i++) {
                                                if (cuentas.get(i).getMostrarNumCuenta().equals(cuentaTransfer)) {
                                                    posiTransfer = i;
                                                } else {
                                                    posiTransfer = -1;
                                                }
                                            }
                                            cuentas.get(posi).transferirDinero("123");
                                            break;
                                        case 4:
                                            cuentas.get(posi).ultimosRetiros();
                                            break;
                                        case 5:
                                            cuentas.get(posi).ultimosDepositos();
                                            break;
                                    }
                                } else if (process==3) {
                                    switch (processTwo) {
                                        case 1:
                                            System.out.println("Ingresa el nuevo nombre");
                                            String nom = texts.nextLine();
                                            cuentas.get(posi).setModificarNombre(nom);
                                            break;
                                        case 2:
                                            System.out.println("Ingresa la nueva cedula");
                                            String cedu = texts.nextLine();
                                            cuentas.get(posi).setModificarCedula(cedu);
                                            break;
                                        case 3:
                                            System.out.println("Ingresa el nuevo monto");
                                            double monto = nums.nextDouble();
                                            cuentas.get(posi).setModificarMontoMax(monto);
                                            break;
                                    }
                                }
                            }while(processTwo!=0);
                        }else{
                            System.out.println("Error");
                        }

                    }while(process!=0);
                }

            }else if(option<0 || option>2){
                System.out.println("Error");
            }
        }while(option!=0);
    }
}
