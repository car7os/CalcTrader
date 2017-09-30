package calctrader.calculos;

public class CustoTotal {
 
    private int quantidade;
    private double corretagem;
    private double taxaIss;
    private double emolumentos;
    private double registroVariavel;
    private double registroFixo;
    private double liquidacao;
    private double dolarReferencial;
    private double custoUnitario;
    private double custoCompraVenda;
    private double incentivoDayTrade;
    private double incentivoMiniContratos;
    
    private double custoISS;
    
    
    public void setCustos (int quantidadeContratos, double custoCorretagem, double taxaISSCorretagem, double custoEmolumentos, double custoRegistroVariavel, double custoRegistroFixo, double custoLiquidacao, double dolarReferencial, double taxaIncentivoDayTrade, double taxaIncentivoMiniContratos){
        
        this.quantidade = quantidadeContratos;
        this.corretagem = custoCorretagem;
        this.taxaIss = taxaISSCorretagem;
        this.emolumentos = custoEmolumentos;
        this.registroVariavel = custoRegistroVariavel;
        this.registroFixo = custoRegistroFixo;
        this.liquidacao = custoLiquidacao;
        this.dolarReferencial = dolarReferencial;
        this.incentivoDayTrade = taxaIncentivoDayTrade;
        this.incentivoMiniContratos = taxaIncentivoMiniContratos;
        
        if (this.dolarReferencial == 0){
            this.dolarReferencial = 1;
        }

        if (this.taxaIss == 0){
            this.taxaIss = 100;
        }
        
        if (this.incentivoDayTrade == 0){
            this.incentivoDayTrade = 100;
        }
        
        if (this.incentivoMiniContratos == 0){
            this.incentivoMiniContratos = 100;
        }
        
        this.corretagem = (this.corretagem * this.quantidade);
        this.custoISS = (this.corretagem * (this.taxaIss/100));
        
        this.emolumentos = this.emolumentos * this.dolarReferencial;
        
        this.registroVariavel = (this.registroVariavel * this.dolarReferencial)*this.quantidade;
        
        this.liquidacao = this.liquidacao * this.dolarReferencial;
        
        this.incentivoDayTrade = (this.incentivoDayTrade/100);
        this.incentivoMiniContratos = (this.incentivoMiniContratos/100);

        this.emolumentos = ((this.emolumentos*this.incentivoDayTrade) * this.incentivoMiniContratos )*this.quantidade;
        this.registroVariavel = ((this.registroVariavel*this.incentivoDayTrade) * this.incentivoMiniContratos);
        
        this.custoUnitario = this.corretagem + this.custoISS + this.registroVariavel + (this.emolumentos+this.registroFixo);
        
        this.custoCompraVenda = this.custoUnitario*2;
        
       
    }
    
    public double getCustos (){
        
        return (this.custoCompraVenda);
    }
    
    public double getCorretora(){
        return (this.corretagem);
    }
   
    public double getISS(){
        return (this.custoISS);
    }

    public double getTaxaRegistroBMF_RegVariavel(){
        return (this.registroVariavel);
    }

    public double getTaxaRegistroBMF_EmolimentosRegFixo(){
        return (this.emolumentos+this.registroFixo);
    }

}
