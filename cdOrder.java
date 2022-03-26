import java.util.Date;

public class cdOrder {
    private String orderNum;
    private Date orderDate;
    private lineItem[] arrayoflineItems;
    private double orderSubtotal;
    private double orderTax;
    private double orderTotal;
    private int lineNum;
    final static double TAX_RATE = 0.0625;
    final static int MAX_NUM_LINE_ITEMS = 10;

    public cdOrder(String theorderNum, lineItem[] thearrayoflineItems, int ln) {
        orderNum = theorderNum;
        orderDate = new Date();
        arrayoflineItems = thearrayoflineItems;
        lineNum = ln;
        setorderSubtital();
        setorderTax();
        setorderTotal();
    }

    public void setorderSubtital() {
        for (int i = 0; i < lineNum; i++) {
            orderSubtotal += arrayoflineItems[i].getlineItemSubtotal();
        }
    }

    public void setorderTax() {
        orderTax = orderSubtotal * TAX_RATE;
    }

    private void setorderTotal() {
        orderTotal = orderSubtotal + orderTax;
    }

    public int getlineNum() {
        return lineNum;
    }

    public String getorderNum() {
        return orderNum;
    }

    public Date getorderDate() {
        return orderDate;
    }

    public lineItem[] getarrayoflineItem() {
        return arrayoflineItems;
    }

    public double getorderSubtotal() {
        return orderSubtotal;
    }

    public double getorderTax() {
        return orderTax;
    }

    public double getorderTotal() {
        return orderTotal;
    }
}
