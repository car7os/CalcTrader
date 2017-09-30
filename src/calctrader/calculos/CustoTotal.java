package calctrader.calculos;

public class CustoTotal {
 
    private int quantidade;
    private double corretagem;
    private double taxaIss;
    private double custoISS;
    private double emolumentos;
    private double registroVariavel;
    private double registroFixo;
    private double liquidacao;
    private double dolarReferencial;
    private double custoUnitario;
    private double custoCompraVenda;
    private double incentivoDayTrade;
    private double incentivoMiniContratos;
    private double taxaPermanenciaDiaria;
    private int permanenciaDias;
    private double fatorReducao;
    
    
    
    public void setCustosTotais (int quantidadeContratos, double custoCorretagem, double taxaISSCorretagem, double custoEmolumentos, double custoRegistroVariavel, double custoRegistroFixo, double custoLiquidacao, double dolarReferencial, double taxaIncentivoDayTrade, double taxaIncentivoMiniContratos, double taxaPermanenciaDiaria, int permanenciaDias, double fatorReducao, double CAt, double Ct, double Vt){
        
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
        this.taxaPermanenciaDiaria = taxaPermanenciaDiaria;
        this.permanenciaDias = permanenciaDias;
        this.fatorReducao = fatorReducao;
        
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
        
        
        
        /*
        CAt-1 = Somatório de todas as posições mantidas em aberto no dia anterior;
        Ct + Vt = Somatório de compras e vendas realizadas para o contrato em questão na data t;
        */
        
        double CA_CV = (CAt-(this.fatorReducao*(Ct+Vt)));
        
        if (CA_CV > 0){
        this.taxaPermanenciaDiaria = (this.taxaPermanenciaDiaria * this.permanenciaDias);
        this.taxaPermanenciaDiaria = this.taxaPermanenciaDiaria*CA_CV;    
        }else{
        this.taxaPermanenciaDiaria = 0;
        }
        
        
        this.custoUnitario = this.corretagem + this.custoISS + this.registroVariavel + (this.emolumentos+this.registroFixo) + this.taxaPermanenciaDiaria;
        
        this.custoCompraVenda = this.custoUnitario*2;
        
       
    }
    
    public double getCustosTotais (){
        
        return (this.custoCompraVenda);
    }
    
    public double getCustosCorretora(){
        return (this.corretagem);
    }
   
    public double getCustosISS(){
        return (this.custoISS);
    }

    public double getCustosTaxaRegistroBMF_RegVariavel(){
        return (this.registroVariavel);
    }

    public double getCustosTaxaRegistroBMF_EmolimentosRegFixo(){
        return (this.emolumentos+this.registroFixo);
    }
    
    public double getCustosTaxaPermanencia(){
        return (this.taxaPermanenciaDiaria);
    }
    
    public void setSpread(){
        
    }

}
