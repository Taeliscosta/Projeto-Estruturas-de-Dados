package atividade03;

/*
 * Interface para implementacao da classe "BST".
 */
public interface BST_IF {
	public void insert(Pessoa element);
	public void remove(Pessoa element) throws Exception; //lancar excecao caso nao encontre
	public Pessoa search(Pessoa element) throws Exception; //lancar excecao caso nao encontre
	public Pessoa[] preOrder();
	public Pessoa[] order();
	public Pessoa[] postOrder();
	public boolean isComplete();
}
