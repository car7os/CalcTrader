package calctrader;

import calctrader.calculos.MediaMovel;


public class Principal {

    public static void main(String[] args) {
        
        MediaMovel Media = new MediaMovel();
        
        System.out.printf("Media -> %d", Media.getConvertPeriodo(1, 15, 20));
        
        
    }

     
}
