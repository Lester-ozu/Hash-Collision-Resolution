import java.util.LinkedList;

public class HashTableChaining { // HashTable with Chaining

    private LinkedList<KeyNode> [] table;
    private int capacity;

    @SuppressWarnings("unchecked")
    public HashTableChaining(int capacity) {

        this.capacity = capacity;
        table = new LinkedList[capacity];

        for(int i = 0 ; i < capacity ; i++) 
            table[i] = new LinkedList<>();
    }

    public void insert(int element) {

        int index = element % capacity;

        if(table[index] == null) {

            LinkedList<KeyNode> listNode = new LinkedList<>();
            listNode.add(new KeyNode(element));
            table[index] = listNode;
        }

        else {

            table[index].add(new KeyNode(element));
        }
    }

    public boolean remove(int element) {

        int index = element % capacity;

        if(table[index] == null) return false;

        for(KeyNode node : table[index]) {

            if(node.getData() == element) table[index].remove(node);

            return true;
        }

        return false;
    }

    public boolean search(int element) {

        int index = element % capacity;

        if(table[index] == null) return false;

        for(KeyNode node : table[index]) {

            if(node.getData() == element) return true;
        }

        return false;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < table.length ; i++) {

            sb.append("Index " + i + ": ");

            if(table[i] != null) {

                for(int j = 0 ; j < table[i].size() ; j++) {

                    sb.append(table[i].get(j).getData());

                    if(j < table[i].size()-1) sb.append(" -> ");
                }
            }

            sb.append("\n");
        }

        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public void clear() {

        table = new LinkedList[capacity];
    }
}