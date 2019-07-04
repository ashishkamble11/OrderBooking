import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Order
{
    int booking_ID;
    short booking_Qty;

    private static Queue<Order> bookingQueue= new LinkedList<>();

    Order(int id, short qty)
    {
        this.booking_ID=id;
        this.booking_Qty=qty;
    }

    static public void bookOrder(Order obj)
    {
        bookingQueue.add(obj);
    }

    public static void printOrders()
    {
        System.out.println("Orders In Process:");
        System.out.println("*******");
        System.out.println("Id\tQty");
        for(Order obj: bookingQueue)
        {
            System.out.println(obj.booking_ID+"\t "+obj.booking_Qty);
        }
        System.out.println("*******");
    }

    public static void confirmOrder()
    {
        BookedOrders.confirmOrder(bookingQueue.remove());
    }

    public static void printBookedOrders()
    {
        BookedOrders.printBookedOrders();
    }

    public static void cancelOrder(int id)
    {
        Order temp;

        if(!bookingQueue.isEmpty())
        {
            Iterator<Order> iterator=bookingQueue.iterator();
            do
            {
                temp=iterator.next();
                if(temp.booking_ID==id)
                {
                    CanceledOrders.addCanceledOrder(temp);
                    bookingQueue.removeIf(objTemp -> (objTemp.booking_ID==id));
                }

            }while (iterator.hasNext());
        }

        temp=BookedOrders.findOrder(id);
        if(temp!=null)
        {
            CanceledOrders.addCanceledOrder(temp);
            BookedOrders.cancelOrder(id);
        }
    }
    public static void printCanceledOrder()
    {
        CanceledOrders.printCanceledOrders();
    }
}