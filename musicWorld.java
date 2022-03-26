import javax.swing.JOptionPane;

public class musicWorld {
    public static void main(String[] args) {
        String choice = "", numStr = "", cdIDStr = "",
                cdTitleStr = "", cdPriceStr = "", orderQtyStr = "", outputMessage = "";

        int lineNum = 0;
        int orderQuantity = 0;
        double orderPrice = 0.0;

        cdOrder anOrder = null;
        lineItem[] CDline = new lineItem[10];

        while (!choice.equalsIgnoreCase("x")) {
            numStr = JOptionPane.showInputDialog("Enter Order Number: ");
            for (int i = 0; i < 10; i++) {
                cdIDStr = "";
                cdIDStr = JOptionPane.showInputDialog("Enter CD Id: ");
                if (cdIDStr.equals("")) {
                    break;
                }
                cdTitleStr = JOptionPane.showInputDialog("Enter CD Title: ");
                cdPriceStr = JOptionPane.showInputDialog("Enter CD Price: ");
                orderPrice = Double.parseDouble(cdPriceStr);
                orderQtyStr = JOptionPane.showInputDialog("Enter Order Quantity: ");
                orderQuantity = Integer.parseInt(orderQtyStr);
                lineNum++;

                CDline[i] = new lineItem(cdIDStr, cdTitleStr, orderPrice, orderQuantity);
            }

            anOrder = new cdOrder(numStr, CDline, lineNum);
            System.out.println("Order Number:" + anOrder.getorderNum());
            System.out.println("Order Date:" + anOrder.getorderDate());
            for (int i = 0; i < lineNum; i++) {
                System.out.println("CD Id:" + anOrder.getarrayoflineItem()[i].getCD().getcdID());
                System.out.println("CD Title:" + anOrder.getarrayoflineItem()[i].getCD().getcdTitle());
                System.out.println("CD Price:" + anOrder.getarrayoflineItem()[i].getCD().getcdPrice());
                System.out.println("Order Quantity:" + anOrder.getarrayoflineItem()[i].getlineItemQty());
                System.out.println("Subtotal:" + anOrder.getarrayoflineItem()[i].getlineItemSubtotal());
            }
            outputMessage = String.format("Press enter or continue or 'x' to exit: ");
            System.out.println("Order Subtotal: " + anOrder.getorderSubtotal());
            System.out.println("Order Tax:" + anOrder.getorderTax());
            System.out.println("Order Total:" + anOrder.getorderTotal());
            lineNum = 0;
            choice = JOptionPane.showInputDialog(null, outputMessage, "MusicWorld", JOptionPane.PLAIN_MESSAGE);
        }
        System.exit(0);

    }
}
