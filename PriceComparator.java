import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PriceComparator implements Comparator<Mobile> {

    @Override
    public int compare(Mobile o1, Mobile o2) {
        return o1.price.compareTo(o2.price);
    }

    public static void main (String args[]) {
        List<Mobile> mobileList = new ArrayList<>();
        mobileList.add(new Mobile("MotoG",12333.00,2000));
        mobileList.add(new Mobile("Iphone",123333.90,1990));
        mobileList.add(new Mobile("Nokia",99879.10,2001));
        PriceComparator priceComparator = new PriceComparator();
        Collections.sort(mobileList, priceComparator);

        for (Mobile mobile:mobileList) {
            System.out.println(mobile.name+" "+mobile.price);
        }
    }
}
