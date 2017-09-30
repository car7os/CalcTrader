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
    private double custoCompraVenda;
    
    
    public double getCustos (int quantidadeContratos, double custoCorretagem, double taxaISSCorretagem, double custoEmolumentos, double custoRegistroVariavel, double custoRegistroFixo, double custoLiquidacao, double dolarReferencial){
        
        this.quantidade = quantidadeContratos;
        this.corretagem = custoCorretagem;
        this.taxaIss = taxaISSCorretagem;
        this.emolumentos = custoEmolumentos;
        this.registroVariavel = custoRegistroVariavel;
        this.registroFixo = custoRegistroFixo;
        this.liquidacao = custoLiquidacao;
        this.dolarReferencial = dolarReferencial;
        
        if (this.dolarReferencial == 0){
            this.dolarReferencial = 1;
        }

        if (this.taxaIss == 0){
            this.dolarReferencial = 0;
        }
        
        this.corretagem = this.corretagem + (this.corretagem * (this.taxaIss/100));
        
        this.emolumentos = this.emolumentos * this.dolarReferencial;
        
        this.registroVariavel = this.registroVariavel * this.dolarReferencial;
        
        this.liquidacao = this.liquidacao * this.dolarReferencial;
        
        
        this.custoCompraVenda = (2*(this.corretagem + this.emolumentos + this.registroVariavel + this.registroFixo + this.liquidacao)) * this.quantidade;
        
        return this.custoCompraVenda;
    }
    
}
