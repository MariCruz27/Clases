

public class CuentaBancaria {

    //Atributos
    private String noCuenta;
    private String tipo;
    private double saldo;
    private String cliente;
    private String cedula;
    private double montoMax;

    //Constructor
    public CuentaBancaria(String num, String tipo, double saldo, String nom, String cedula, double max) {
        this.noCuenta = num;
        this.tipo = tipo;
        this.saldo = saldo;
        this.cliente = nom;
        this.cedula = cedula;
        this.montoMax = max;
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
    public void retirarDinero(double retiro) {
        if (retiro > this.saldo || retiro <= 0) {
            System.out.println("Cantidad de dinero a retirar erronea o no disponible");
        }else {
            this.saldo = this.saldo-retiro;
            System.out.println("Su nuevo saldo es: " + this.saldo);
        }
    }

    //Depositar
    public void depositarDinero(double deposito) {
        this.saldo = this.saldo+deposito;
        System.out.println("Su nuevo saldo es: " + this.saldo);
    }

    //Transferir

    //Ultimos Retiros
    public void ultimosRetiros() {
        System.out.println("Estamos trabajando por ti, se necesita mas de un día de plazo para esta función. ");
    }
    public void ultimosDepositos() {
        System.out.println("Estamos trabajando por ti, se necesita mas de un día de plazo para esta función. ");
    }
}
