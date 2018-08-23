
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class SortedListsIterator implements Iterator {
    private PriorityQueue<Element> elemQueue = new PriorityQueue<>();

    private static class Element {
        List<Integer> source;
        int sourceIndex;

        public Element(List<Integer> source, int sourceIndex) {
            this.source = source;
            this.sourceIndex = sourceIndex;
        }
    }

    public SortedListsIterator(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            if (list.size() > 0) {
                elemQueue.add(new Element(list, 0));
            }
        }
    }

    public boolean hasNext() {
        return elemQueue.size() > 0;
    }

    public Integer next() {
        Element e = elemQueue.poll();
        if (elemQueue.size() == 0) {
            throw new NoSuchElementException();
        }
        if (e.sourceIndex < e.source.size()) {
            elemQueue.add(new Element(e.source, e.sourceIndex + 1));
        }
        return e.source.get(e.sourceIndex);
    }
}