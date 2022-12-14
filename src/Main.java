import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Creación de tres cuentas
        ArrayList<CuentaBancaria> cuentas = new ArrayList<CuentaBancaria>();
        Funciones funcion = new Funciones();
        Scanner nums = new Scanner(System.in);
        Scanner texts = new Scanner(System.in);

        int indicesCuentas = -1;

        int option, process, processTwo;
        String cuentaTransfer; //Cuenta a transferir
        do {
            funcion.MenuPrincipal();//Register or login
            option = nums.nextInt();

            //Variables para verificación
            String numCuenta;
            int posi = 0;
            int posiTransfer = 0;

            if (option==1){
                indicesCuentas++;
                System.out.println("Digite el nombre: ");
                String nom = texts.nextLine();
                System.out.println("Que tipo de cuenta desea abrir (Credito o Debito) ");
                String tipo = texts.nextLine();
                System.out.println("Digite su numero de cédula: ");
                String id = texts.nextLine();
                System.out.println("Digite su numero de cuenta: ");
                String nCuenta = texts.nextLine();
                System.out.println("Digite su saldo actual: ");
                double saldo = nums.nextDouble();
                double mmax;

                tipo = tipo.toLowerCase();

                if (tipo.equals("credito")) {
                    System.out.println("Cual es su monto máximo vigente?: ");
                    mmax = nums.nextDouble();
                }
                else {
                    mmax = saldo;
                }
                cuentas.add(indicesCuentas, new CuentaBancaria(nCuenta,tipo,saldo,nom,id,mmax));
            }if(option==2){
                //Hallar cuenta
                System.out.println("Ingresa el número de tu cuenta");
                numCuenta = texts.next();
                for (int i = 0; i<cuentas.size();i++){
                    System.out.println(cuentas.get(i).getMostrarNumCuenta());
                    if (cuentas.get(i).getMostrarNumCuenta().equals(numCuenta)){
                        posi = i;
                        break;
                    }else{
                        posi=-1;
                    }
                }
                if (posi>=0){
                    System.out.println("Bienvenido/a");
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
                                            System.out.println("Digite una cantidad a retirar");
                                            double retiro = nums.nextDouble();
                                            cuentas.get(posi).retirarDinero(retiro);
                                            break;
                                        case 2:
                                            System.out.println("Digite una cantidad a depositar");
                                            double deposito = nums.nextDouble();
                                            cuentas.get(posi).depositarDinero(deposito);
                                            break;
                                        case 3:
                                            //Pedir otra cuenta

                                            System.out.println("Ingresa el número de la cuenta a transferir: ");
                                            cuentaTransfer = texts.next();
                                            for (int i = 0; i<cuentas.size();i++) {
                                                if (cuentas.get(i).getMostrarNumCuenta().equals(cuentaTransfer)) {
                                                    posiTransfer = i;
                                                    break;
                                                } else {
                                                    posiTransfer = -1;
                                                }
                                            }
                                            System.out.println("Digite el monto a transferir: ");
                                            double transfer = nums.nextDouble();
                                            cuentas.get(posi).retirarDinero(transfer);
                                            cuentas.get(posiTransfer).depositarDinero(transfer);
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
                }else{
                    System.out.println("El número de cuenta digitado no existe");
                }

            }else if(option<0 || option>2){
                System.out.println("Error");
            }
        }while(option!=0);
    }
}
