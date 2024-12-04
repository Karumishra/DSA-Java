import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NameComparator implements Comparator<Mobile> {

    @Override
    public int compare(Mobile o1, Mobile o2) {
        return o1.name.compareTo(o2.name);
    }

    public static void main (String args[]) {
        List<Mobile> mobileList = new ArrayList<>();
        mobileList.add(new Mobile("MotoG",12333.00,2000));
        mobileList.add(new Mobile("Iphone",123333.90,1990));
        mobileList.add(new Mobile("Nokia",99879.10,2001));
        NameComparator nameComparator = new NameComparator();
        Collections.sort(mobileList, nameComparator);

        for (Mobile mobile:mobileList) {
            System.out.println(mobile.name);
        }
    }
}
