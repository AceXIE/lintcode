/**
 * Created by Administrator on 2016/8/10.
 */
public class NutsBoltsProblem {

    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        if (nuts == null || nuts.length == 0) return;
        sortSub(nuts, bolts, 0, nuts.length - 1, compare);
    }
    public void sortSub(String[] nuts, String[] bolts, int start, int end, NBComparator compare) {
        if (start >= end) return;
        int pivot = sortBolts(bolts, nuts[start], start, end, compare);
        sortNuts(nuts, bolts[pivot], start, end, compare);

        sortSub(nuts, bolts, start, pivot - 1, compare);
        sortSub(nuts, bolts, pivot + 1, end, compare);
    }
    public void sortNuts(String[] nuts, String pivot, int start, int end, NBComparator compare) {
        int left = start, right = end;
        while (left < right) {
            while (left < right && compare.cmp(nuts[left], pivot) > 0) {
                left++;
            }
            while (left < right && compare.cmp(nuts[right], pivot) < 0) {
                right--;
            }
            if (left < right) swap(nuts, left, right);
        }
    }
    public int sortBolts(String[] bolts, String pivot, int start, int end, NBComparator compare) {
        int left = start, right = end;
        while (left < right) {
            while (left < right && compare.cmp(pivot, bolts[left]) < 0) {
                left++;
            }
            while (left < right && compare.cmp(pivot, bolts[right]) > 0) {
                right--;
            }
            if (left < right) swap(bolts, left, right);
        }
        return left;
    }
    public void swap(String[] A, int l, int r) {
        String tmp = A[l];
        A[l] = A[r];
        A[r] = tmp;
    }
}
class NBComparator {
    public static int cmp(String a, String b) {
        return 0;
    }
}