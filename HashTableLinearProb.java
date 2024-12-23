public class HashTableLinearProb { // HashTable with Linear Probing

    private KeyNode [] table;
    private int capacity, size = 0;
    private static final double expandThreshold = 0.7, shrinkThreshold = 0.3;

    public HashTableLinearProb(int capacity) {

        this.capacity = capacity;
        table = new KeyNode[capacity];
    }

    public void insert(int element) {

        if(size > table.length * expandThreshold) resize();

        int index = element % capacity;
        
        while(table[index] != null) {

            index = (index + 1) % capacity;
        }

        if(table[index] == null) {

            table[index] = new KeyNode(element);
            size++;
        }
    }

    public boolean remove(int element) {

        int index = element % capacity;

        while(table[index] != null) {

            if(table[index].getData() == element) {

                table[index] = null;
                size--;

                if(table.length > 10 && size < table.length * shrinkThreshold) shrink();

                return true;
            }

            index = (index + 1) % capacity;
        }

        return false;
    }

    public boolean search(int element) {

        if(size < 1) return false;

        int index = element % capacity;

        while(table[index] != null) {

            if(table[index].getData() == element) return true;

            index = (index + 1) % capacity;
        }

        return false;
    }

    private void resize() {

        capacity *= 2;

        KeyNode [] oldTable = table;
        table = new KeyNode[capacity];
        size = 0;

        for(KeyNode node : oldTable) {

            if(node != null)
                insert(node.getData());
        }
    }

    private void shrink() {

        if(capacity/2 < 10) capacity = 10;
        else capacity /= 2;

        KeyNode [] oldTable = table;
        table = new KeyNode[capacity];
        size = 0;

        for(KeyNode node : oldTable) {

            if(node != null)
                insert(node.getData());
        }
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < table.length ; i++) {

            if(table[i] != null) sb.append("Index " + i + ": " + table[i].getData() + "\n");

            else sb.append("Index " + i + ": \n");
        }

        return sb.toString();
    }

    public void clear() {

        capacity = 10;
        table = new KeyNode[capacity];
        size = 0;
    }
}