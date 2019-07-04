import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class BookedOrders
{
    private static List<Order> bookedList=new LinkedList<>();

    static void confirmOrder(Order obj)
    {
        bookedList.add(obj);
    }

    static void printBookedOrders()
    {
        System.out.println("Booked Orders:");
        System.out.println("*******");
        System.out.println("Id\tQty");
        for(Order obj: bookedList)
        {
            System.out.println(obj.booking_ID+"\t "+obj.booking_Qty);
        }
        System.out.println("*******");
    }

    static void cancelOrder(int id)
    {
        if(!bookedList.isEmpty())
        {
            bookedList.removeIf(objTemp -> (objTemp.booking_ID==id));
        }
    }

    static Order findOrder(int id)
    {
        Order temp;
        if(!bookedList.isEmpty())
        {
            Iterator<Order> iterator = bookedList.iterator();
            do
            {
                temp = iterator.next();
                if (temp.booking_ID == id)
                {
                    return temp;
                }
            }while (iterator.hasNext());
        }
        return null;
    }
}
