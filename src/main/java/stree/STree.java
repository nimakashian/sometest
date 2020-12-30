package stree;

import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class STree {
    //TODO automatic STreeNode merging

    private Vector<STreeNode> nodes = new Vector<>();
    private int size = 0;

    public synchronized void append(Object obj, Object key) {
        if (size == 0) {
            // this is first object to be added
            STreeNode node = new STreeNode(key);
            node.append(obj);

            nodes.add(node);
        } else {

            STreeNode node = null;
            boolean found = false;
            for (int i = 0; i < nodes.size(); i++) {
                node = nodes.get(i);
                if (node.getKey().equals(key)) {
                    node.append(obj);
                    found = true;
                }
            }
            if (!found) {
                node = new STreeNode(key);
                node.append(obj);

                nodes.add(node);
            }

        }


        size++;

    }

    // do a.java simple 0 indexed get on the whole tree
    public synchronized Object get(int index) {
        return null;
    }

    public int nextIndex(int node) {
        STreeNode stn = nodes.get(node);
        return stn.nextIndex();
    }

    public synchronized Object get(int node, int index) {
        STreeNode stn = nodes.get(node);
        return stn.get(index);
    }

    public synchronized STreeNode getNode(int node) {
        return nodes.get(node);
    }

    public synchronized int getCursor(STreeNode node) {
        return nodes.indexOf(node);
    }

    public synchronized boolean remove(int node, int index) {
        STreeNode stn = nodes.get(node);
        boolean last = stn.remove(index);
        if (last) {
            // remove the node
            nodes.remove(node);

            // see if the node before and node after have same keys
            // one before && one after && one before.key equals one after.key
            if (node > 0 && node < nodes.size() && (nodes.get(node)).getKey().equals((nodes.get(node - 1)).getKey())) {
                (nodes.get(node - 1)).merge(nodes.remove(node));
            }
        }
        size--;
        return last;
    }

    public synchronized int getSize() {
        return size;
    }

    public synchronized boolean isEmpty() {
        return size == 0;
    }

    public synchronized int getNodesSize() {
        return nodes.size();
    }

    public synchronized int getNodeSize(int node) {
        if (node < nodes.size()) {

            STreeNode stn = (STreeNode) nodes.get(node);
            return stn.getSize();
        } else {
            return 0;
        }

    }

    // get the key from a.java particular node
    public synchronized Object getNodeKey(int node) {
        STreeNode stn = (STreeNode) nodes.get(node);
        return stn.getKey();
    }

    public void showStructure() {
        System.out.println("Size is " + size);
        Iterator i = nodes.iterator();
        while (i.hasNext()) {
            STreeNode stn = (STreeNode) i.next();
            System.out.println("  key=" + stn.getKey() + ", size=" + stn.getSize());
        }
    }


    public String getStructure() {
        StringBuffer sb = new StringBuffer();
        sb.append("Size is " + size);
        Iterator<STreeNode> it = Collections.unmodifiableList(nodes).iterator();
        int i = 0;
        try {
            while (it.hasNext()) {
                if (i++ % 6 == 0) {
                    sb.append("\n");
                }
                STreeNode stn = it.next();
                sb.append("[key=" + stn.getKey() + ", size=" + stn.getSize() + "] ");
            }
        } catch (Exception e) {
            e.printStackTrace();
            sb.append("an exception in iterating.");
        }
        return sb.toString();
    }


    public synchronized boolean resetIndex(Object key) {
        for (int i = 0; i < nodes.size(); i++) {
            STreeNode node = nodes.get(i);
            if ((node.getKey()).equals(key)) {
                node.resetIndex();
                return true;
            }
        }
        return false;
    }
}