package calctrader.calculos;

public class CustoTotal {
 
    private int quantidade;
    private double corretagem;
    private double taxaIss;
    private double custoISS;
    private double emolumentos;
    private double registroVariavel;
    private double registroFixo;
    private double emolimentosRegFixo;
    private double liquidacao;
    private double dolarReferencial;
    private double custoUnitario;
    private double custosTotais;
    private double incentivoDayTrade;
    private double incentivoMiniContratos;
    private double taxaPermanenciaDiaria;
    private int permanenciaDias;
    private double fatorReducao;
    
    private double spreadMinimo;
    private double valorPonto;
    private double valorMinimo;
    
    
    
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
        this.custosTotais = this.custoUnitario*2;
        this.corretagem = (this.corretagem)*2;
        this.custoISS = (this.custoISS)*2;
        this.registroVariavel = (this.registroVariavel)*2;
        this.emolimentosRegFixo = (this.emolumentos+this.registroFixo)*2;
        
                
    }
    
    public double getCustosTotais (){
        return (this.custosTotais);
    }
    
    public double getCustosTotaisUnitario(){
        return (this.custoUnitario);
        
    }
    
    public double getCustosCorretagem(){
        return (this.corretagem);
    }
   
    public double getCustosISS(){
        return (this.custoISS);
    }
    
    public double getCustosCorretora(){
        return (this.corretagem+this.custoISS);
    }

    public double getCustosTaxaRegistroBMF_RegVariavel(){
        return (this.registroVariavel);
    }

    public double getCustosTaxaRegistroBMF_EmolimentosRegFixo(){
        return (this.emolimentosRegFixo);
    }
    
    public double getCustosBMF(){
        return (this.registroVariavel+this.emolimentosRegFixo);
    }
    
    public double getCustosTaxaPermanencia(){
        return (this.taxaPermanenciaDiaria);
    }
    
    public void setSpread(double spreadMinimo, double valorPorPonto){
        this.spreadMinimo = spreadMinimo;
        this.valorPonto = valorPorPonto; // no caso do dolar são 50 reais, pois os 5 contratos é 250 e o ponto minimo é 125
        
        this.valorMinimo = (this.spreadMinimo = this.spreadMinimo*(this.valorPonto*this.quantidade));
    }
    
    public double getValorMinimo (){
        
        return (this.valorMinimo);
    }
    
    public double getSpredMinimoLucro(){
        return (this.custosTotais/(this.valorPonto*this.quantidade));
    }
    
    public double getValorSpreadMinimo(){
        return (this.spreadMinimo*this.valorPonto);
    }

}
