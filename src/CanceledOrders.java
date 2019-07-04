import java.util.Iterator;
import java.util.Stack;

class CanceledOrders
{
    private static Stack<Order> stack=new Stack<>();

    static void addCanceledOrder(Order order)
    {
        stack.push(order);
    }

    static void printCanceledOrders()
    {
        if(!stack.isEmpty())
        {
            System.out.println("Canceled Orders:");
            System.out.println("*******");
            System.out.println("Id\tQty");
            for (Order obj : stack) {
                System.out.println(obj.booking_ID + "\t " + obj.booking_Qty);
            }
            System.out.println("*******");
        }
    }
}
