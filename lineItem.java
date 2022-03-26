public class lineItem {
    private int lineItemNum;
    private Cd CD;
    private int lineItemQty;
    private double lineItemDiscRate;
    private double lineItemSubtotal;

    final static double DISCOUNT_FOR_5=0.1,DISCOUNT_FOR_10=0.15,DISCOUNT_FOR_15=0.2;

    public lineItem(String aCDId,String aCDTitle,double aCDPrice,int aLineItemQty) {
        lineItemNum++;
        CD= new Cd(aCDId,aCDTitle,aCDPrice);
        lineItemQty=aLineItemQty;
        setLineItemDiscRate();
        setLineIemSubtotal();
    }
    public void setLineItemDiscRate() {
        if (lineItemQty>=15) {
            lineItemDiscRate=DISCOUNT_FOR_15;
        }
        else if(lineItemQty>=10){
            lineItemDiscRate=DISCOUNT_FOR_10;
        }
        else if(lineItemQty>=5){
            lineItemDiscRate=DISCOUNT_FOR_5;
        }
        else{
            lineItemDiscRate=0.0;
        }
    }
    public void setLineIemSubtotal() {
        lineItemSubtotal=CD.getcdPrice()*lineItemQty*(1+lineItemDiscRate);
    }
    public int getlineItemNum() {
        return lineItemNum;
    }
    public Cd getCD() {
        return CD;
    }
    public int getlineItemQty() {
        return lineItemQty;
    }
    public double getlineItemDiscRate() {
        return lineItemDiscRate;
    }
    public double getlineItemSubtotal() {
        return lineItemSubtotal;
    }
    public String Print() {
        String formatStr="LN:%d\nCD:%s\t%s\t%.2f\nQTY:%d\n"+
        "Discount:%.2f\ntotal%.2f\n";
        String lineItemStr=String.format(formatStr, lineItemNum, this.CD.getcdID(),
        this.CD.getcdTitle(),this.CD.getcdPrice(),lineItemQty,lineItemDiscRate,lineItemSubtotal);
        return lineItemStr;
    }

}
