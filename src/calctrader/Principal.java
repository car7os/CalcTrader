package calctrader;

import calctrader.calculos.MediaMovel;
import calctrader.calculos.CustoTotal;


public class Principal {

    public static void main(String[] args) {
        
        MediaMovel transportarMedia = new MediaMovel();
        
        System.out.printf("Media Transportada -> %d\n", transportarMedia.getConvertPeriodo(1, 15, 20));
        
        CustoTotal Custos = new CustoTotal();

        Custos.setCustosTotais(5,2, 9, 0.53, 0.59, 0.1166181, 0.60, 3.15, 50, 0, 0,0,0,0,0,0);
        Custos.setSpread(0.5, 50);
        System.out.printf("Custos por Contrato (Dólar Cheio) -> %.2f\n", Custos.getCustosTotais());
        System.out.printf("Valor Minimo (Dólar Cheio) -> %.2f\n", Custos.getValorMinimo());
        System.out.printf("Spread Minimo para ter Lucro (Dólar Cheio) -> %.2f\n", Custos.getSpredMinimoLucro());


        Custos.setCustosTotais(1,1, 9, 0.53, 0.59, 0.1166181, 0.60, 3.15, 50, 22,  0,0,0,0,0,0);
        Custos.setSpread(0.5, 10);
        System.out.printf("Custos por Contrato (Mini Dólar) -> %.2f\n", Custos.getCustosTotais());
        System.out.printf("Valor Minimo (MiniDolar) -> %.2f\n", Custos.getValorMinimo());
        System.out.printf("Spread Minimo para ter Lucro (Mini Dólar) -> %.2f\n", Custos.getSpredMinimoLucro());

        
        
        
        
    }

     
}
