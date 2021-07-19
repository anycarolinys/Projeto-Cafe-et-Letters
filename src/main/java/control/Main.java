package control;

// import java.io.BufferedWriter;
// import java.io.File;
// import java.io.FileWriter;
// import java.io.IOException;

import model.gestaoVendas.Compra;


public class Main {
    public static void main(String[] args) {
        Compra c1 = new Compra();
        Compra c2 = new Compra();
        System.out.println();
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
    }
}
