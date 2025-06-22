import java.util.Arrays;
import java.util.Comparator;

public class BinarySearch {

    public static Product binarySearch(Product[] products, String targetName) {
        // Sort the array by product name before binary search
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String midName = products[mid].productName.toLowerCase();

            int compare = targetName.toLowerCase().compareTo(midName);

            if (compare == 0) {
                return products[mid];
            } else if (compare > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }
}
