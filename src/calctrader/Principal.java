package calctrader;

import calctrader.calculos.MediaMovel;
import calctrader.calculos.CustoTotal;


public class Principal {

    public static void main(String[] args) {
        
        MediaMovel transportarMedia = new MediaMovel();
        System.out.printf("Media Transportada -> %d\n", transportarMedia.getConvertPeriodo(1, 15, 20));
        
        CustoTotal custoCompraVenda = new CustoTotal();
        System.out.printf("Custos Totais -> %.2f\n", custoCompraVenda.getCustos(5,1, 5, 0.53, 0.59, 0.1166181, 0.60, 3.15));
        
        
        
        
    }

     
}
