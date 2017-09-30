package calctrader.calculos;

public final class MediaMovel{
    
    private int periodoCorrente;
    private int periodoAplicado;
    private int mediaAplicada;
    
    public int getConvertPeriodo(int periodoGraficoCorrente, int periodoGraficoAplicado, int periodoMediaAplicada){
    
        this.periodoCorrente = periodoGraficoCorrente;
        this.periodoAplicado = periodoGraficoAplicado;
        this.mediaAplicada = periodoMediaAplicada;
        
        return ((this.mediaAplicada*this.periodoAplicado)/this.periodoCorrente);
    }
    
        
}
    
   