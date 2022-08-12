import java.util.ArrayList;
import java.util.Scanner;

public class CuentaBancaria {
    Scanner scan = new Scanner(System.in);

    //Atributos
    private String noCuenta;
    private String tipo;
    private double saldo;
    private String cliente;
    private String cedula;
    private double montoMax;

    //Constructor
    public void CuentaBancaria(String num, String tipo, double saldo, String nom, String cedula, double max) {
        this.noCuenta = num;
        this.tipo = tipo;
        this.saldo = saldo;
        this.cliente = nom;
        this.cedula = cedula;
        this.montoMax = max;
    }

    //Crear Cuenta
    public void crearPerfil() {
        System.out.println("Digite el nombre: ");
        String nom = scan.nextLine();
        System.out.println("Que tipo de cuenta desea abrir (Credito o Debito) ");
        String tipo = scan.nextLine();
        System.out.println("Digite su numero de cédula: ");
        String id = scan.nextLine();
        System.out.println("Digite su numero de cuenta: ");
        String nCuenta = scan.nextLine();
        System.out.println("Digite su saldo actual: ");
        double saldo = scan.nextDouble();
        double mmax;

        tipo = tipo.toLowerCase();

        if (tipo.equals("credito")) {
            System.out.println("Cual es su monto máximo vigente?: ");
            mmax = scan.nextDouble();
        }
        else {
            mmax = saldo;
        }
        CuentaBancaria(nCuenta,tipo,saldo,nom,id,mmax);
    }

    //Accesores
    public String getMostrarCedula() {
        return this.cedula;
    }
    public String getMostrarNombre() {
        return this.cliente;
    }
    public double getMostrarSaldo() {
        return this.saldo;
    }
    public double getMostrarMontoMax() {
        return this.montoMax;
    }
    public String getMostrarTipo() {
        return this.tipo;
    }
    public String getMostrarNumCuenta() {
        return this.noCuenta;
    }



    //Mutadores
    public void setModificarCedula(String cedu) {
        this.cedula = cedu;
    }
    public void setModificarNombre(String nom) {
        this.cliente = nom;
    }
    public void setModificarMontoMax(double mmax) {
        this.montoMax = mmax;
    }

    //Accesor de toda la información
    public String to_String() {
        return "---Cuenta Bancaria---\n" + "Número de cuenta: " + this.noCuenta + "\nTipo de cuenta: " + this.tipo + "\nSaldo: "+this.saldo + "\nNombre: " + this.cliente + "\nCédula: " + this.cedula + "\nMonto Máximo: " + this.montoMax ;
    }

    //Retirar dinero
    public void retirarDinero() {
        System.out.println("Digite la cantidad a retirar: ");
        double retiro = scan.nextDouble();

        if (retiro > this.saldo || retiro <= 0) {
            System.out.println("Cantidad de dinero a retirar erronea o no disponible");
        }else {
            this.saldo = this.saldo-retiro;
            System.out.println("Su nuevo saldo es: " + this.saldo);
        }
    }

    //Depositar
    public void depositarDinero() {
        System.out.println("Digite la cantidad a depositar: ");
        double deposito = scan.nextDouble();
        this.saldo = this.saldo+deposito;
        System.out.println("Su nuevo saldo es: " + this.saldo);
    }

    //Transferir
    public void transferirDinero(String cuentaT) {
        System.out.println("Digite el monto a transferir: ");
        double transfer = scan.nextDouble();
        if (transfer > this.saldo || transfer <= 0) {
            System.out.println("Cantidad de dinero a transferir erronea o no disponible");
        }else {
            this.saldo = this.saldo-transfer;
            System.out.println("Su nuevo saldo es: " + this.saldo);
        }
    }

    //Ultimos Retiros
    public void ultimosRetiros() {
        System.out.println("Estamos trabajando por ti, se necesita mas de un día de plazo para esta función. ");
    }
    public void ultimosDepositos() {
        System.out.println("Estamos trabajando por ti, se necesita mas de un día de plazo para esta función. ");
    }
}
