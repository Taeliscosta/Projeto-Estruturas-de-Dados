package atividade03;

public class ListaEncadeada implements ListaEncadeada_IF {
    protected Pessoa data;
    protected ListaEncadeada next;
    
    ListaEncadeada() {
        this.data = null;
        this.next = null;
    }
    
    @Override
    public boolean isEmpty() {
        return this.data == null;
    }

    @Override
    public int size() {
        return sizeaux(this);
    }
    
    private int sizeaux(ListaEncadeada currentnode) {
        if(currentnode == null || currentnode.data == null) {
            return 0;
        }
        
        return 1 + sizeaux(currentnode.next);
    }

    @Override
    public void insert(Pessoa element) {
        ListaEncadeada newnode = new ListaEncadeada();
        newnode.data = this.data;
        newnode.next = this.next;
        
        this.data = element;
        this.next = newnode;
    }

    @Override
    public void remove(Pessoa element) throws Exception {
        if (this.data == null) {
            throw new Exception("A lista está vazia!!");
        }
        if (this.data.equals(element)) {
            this.data = this.next != null ? this.next.data : null;
            this.next = this.next != null ? this.next.next : null;
        } else {
            removeaux(this, element);
        }
    }

    private void removeaux(ListaEncadeada currentnode, Pessoa element) throws Exception {
        if(currentnode.next == null) {
            throw new Exception("Elemento não encontrado!!");
        } 
        
        if(currentnode.next.data.equals(element)){
            currentnode.next = currentnode.next.next;
        } else {
            removeaux(currentnode.next, element);
        }
    }
    
    
    @Override
    public Pessoa search(Pessoa element) throws Exception {
        return searchaux(this, element);
    }
    
    private Pessoa searchaux(ListaEncadeada currentnode, Pessoa element) throws Exception {
        if(currentnode == null || currentnode.data == null) {
            throw new Exception("Elemento não encontrado!!");
        }
        
        if(currentnode.data.equals(element)) {
            return currentnode.data;
        } 
        return searchaux(currentnode.next, element);        
    }

    @Override
    public Pessoa[] toArray() {
        Pessoa array[] = new Pessoa[size()];
        toArrayaux(this, array, 0);
        return array;
    }
    
    private void toArrayaux(ListaEncadeada currentnode, Pessoa array[], int i) {
        if(currentnode != null && currentnode.data != null) {
            array[i] = currentnode.data;
            if(currentnode.next != null) {
                toArrayaux(currentnode.next, array, i + 1);
            }
        }
    }
}