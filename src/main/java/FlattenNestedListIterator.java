import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2016/7/29.
 */
public class FlattenNestedListIterator implements Iterator<Integer> {
    private Stack<NestedInteger> stack = new Stack<>();
    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        for (int i = 0; i < nestedList.size(); i++) {
            stack.push(nestedList.get(i));
        }
    }
    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }
    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            NestedInteger n = stack.pop();
            List<NestedInteger> t = n.getList();
            for (int i = t.size() - 1; i >= 0; i--) {
                stack.push(t.get(i));
            }
        }
        return !stack.isEmpty();
    }
    @Override
    public void remove() {

    }
}

interface NestedInteger {
    public boolean isInteger();
    public Integer getInteger();
    public List<NestedInteger> getList();
}