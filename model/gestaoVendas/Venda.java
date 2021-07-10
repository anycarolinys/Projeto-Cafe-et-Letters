package model.gestaoVendas;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Venda {
    private double valorTotal;
    private double valorPago;
    private String dataHora;

    public Venda(){}

    public Venda(double valorTotal, double valorPago) {
        this.valorTotal = valorTotal;
        this.valorPago = valorPago;
        setDataHora();
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

    public double gerarTroco() {
        return getValorTotal() - getValorPago();
    }


    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        this.dataHora = dtf.format(LocalDateTime.now());
    }

}