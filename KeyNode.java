public class KeyNode {
    
    private int data;
    
    KeyNode(){data = 0;}
    KeyNode (int d) {data = d;}

    public int getData() {return data;}

    public void setData(int data) {this.data = data;}

    @Override
    public String toString() {return "KeyNode{" + "data=" + data + '}';}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.data;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KeyNode other = (KeyNode) obj;
        if (this.data != other.data) {
            return false;
        }
        return true;
    }
    
    
}
