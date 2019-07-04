import java.util.Scanner;

public class BookingDriver
{
    public static void main(String[] args)
    {
        Order order;
        int order_Id=0;
        int option;
        int cancel_Id;
        short quantity=0;

        Scanner sc=new Scanner(System.in);

        while(true)
        {
            System.out.println("1.Order\t2.Confirm Order\t3.Cancel Order\t4.Print Orders\t5.Print Confirmed Orders\t6.Print Canceled Orders\t7.Exit");
            System.out.print("Enter option:");
            option=sc.nextInt();

            switch (option)
            {
                case 1:
                    System.out.print("Enter Order Id:");
                    order_Id=sc.nextInt();
                    System.out.print("Enter Order Quantity:");
                    quantity=sc.nextShort();
                    order=new Order(order_Id, quantity);
                    Order.bookOrder(order);
                    break;

                case 2:
                    Order.confirmOrder();
                    break;

                case 3:
                    System.out.print("Enter the id of order to cancel:");
                    cancel_Id=sc.nextInt();
                    Order.cancelOrder(cancel_Id);
                    break;

                case 4:
                    Order.printOrders();
                    break;

                case 5:
                    Order.printBookedOrders();
                    break;

                case 6:
                    Order.printCanceledOrder();
                    break;

                case 7:
                    System.exit(0);
            }
        }
    }
}
