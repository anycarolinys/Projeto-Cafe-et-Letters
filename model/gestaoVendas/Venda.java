package model.gestaoVendas;
import java.util.Calendar;

public class Venda {
    private double valorTotal;
    private double valorPago;
    private double troco;
    private Calendar data;
    private int hora;

    public Venda(){

    }

    public Venda(double valorTotal, double valorPago, double troco, Calendar data, int hora) {
        this.valorTotal = valorTotal;
        this.valorPago = valorPago;
        this.troco = troco;
        this.data = data;
        this.hora = hora;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public double getTroco() {
        return troco;
    }

    public void setTroco(double troco) {
        this.troco = troco;
    }

    public double gerarTroco(double recebido){
        return recebido;
    }   
}
