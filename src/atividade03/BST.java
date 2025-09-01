package atividade03;

import java.util.ArrayList;

public class BST implements BST_IF {
	
	Pessoa pessoa;
	BST left, right;
	
	BST() {
		this.pessoa = null;
		this.left = null;
		this.right = null;
	}
	
	@Override
	public void insert(Pessoa element) {
		if(this.pessoa == null) {
			this.pessoa = element;
		} else if(pessoa.getCpf() > element.getCpf()) {
			if(left == null) {
				left = new BST();
			}
			left.insert(element);
		} else if(pessoa.getCpf() < element.getCpf()) {
			if(right == null) {
				right = new BST();
			}
			right.insert(element);
		}
	}
	
	@Override
	public void remove(Pessoa element) throws Exception {
		this.removeaux(null, this, element);
	}
	
	private void removeaux(BST parent, BST current, Pessoa element) throws Exception {
		if(current == null) {
			throw new Exception("Pessoa não encontrada para remoção!!");
		}
		
		if(current.pessoa.getCpf() > element.getCpf()) {
			removeaux(current, current.left, element);
		} else if(current.pessoa.getCpf() < element.getCpf()) {
			removeaux(current, current.right, element);
		} else {
			if(current.left != null && current.right != null) {
				BST minRight = findMin(current.right);
				current.pessoa = minRight.pessoa;
				removeaux(current, current.right, minRight.pessoa);
			} else if(parent == null) {
				if(current.left != null) {
					this.pessoa = current.left.pessoa;
					this.left = current.left.left;
					this.right = current.left.right;
				} else if(current.right != null) {
					this.pessoa = current.right.pessoa;
					this.left = current.right.left;
					this.right = current.right.right;
				} else {
					this.pessoa = null;
				}
			} else if(parent.left == current) {
				parent.left = (current.left != null) ? current.left : current.right;
			} else if(parent.right == current) {
				parent.right = (current.left != null) ? current.left : current.right;
			}
		}
	}
	
	private BST findMin(BST node) {
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}

	@Override
	public Pessoa search(Pessoa element) throws Exception {
		return searchaux(element);
	}
	
	private Pessoa searchaux(Pessoa element) throws Exception {
		if(this.pessoa == null) {
			throw new Exception("Elemento Não Encontrado !!");
		}
		
		if(this.pessoa.getCpf() == element.getCpf()) {
			return this.pessoa;
		} else if(this.pessoa.getCpf() > element.getCpf()) {
			if(left != null) {
				return left.searchaux(element);
			}
		} else if(this.pessoa.getCpf() < element.getCpf()) {
			if(right != null) {
				return right.searchaux(element);
			}
		}
		
		throw new Exception("Elemento Não Encontrado !!");
	}

	@Override
	public Pessoa[] preOrder() {
		ArrayList<Pessoa> array = new ArrayList<>();
		preOrderaux(array);
		return array.toArray(new Pessoa[0]);
	}
	
	private void preOrderaux(ArrayList<Pessoa> array) {
		if(this.pessoa != null) {
			array.add(this.pessoa);
			if(left != null) left.preOrderaux(array);
			if(right != null) right.preOrderaux(array);
		}
	}

	@Override
	public Pessoa[] order() {
		ArrayList<Pessoa> array = new ArrayList<>();
		orderaux(array);
		return array.toArray(new Pessoa[0]);
	}
	
	private void orderaux(ArrayList<Pessoa> array) {
		if(this.pessoa != null) {
			if(left != null) left.orderaux(array);
			array.add(this.pessoa);
			if(right != null) right.orderaux(array);
		}
	}

	@Override
	public Pessoa[] postOrder() {
		ArrayList<Pessoa> array = new ArrayList<>();
		postOrderaux(array);
		return array.toArray(new Pessoa[0]);
	}
	
	private void postOrderaux(ArrayList<Pessoa> array) {
		if(this.pessoa != null) {
			if(left != null) left.postOrderaux(array);
			if(right != null) right.postOrderaux(array);
			array.add(this.pessoa);
		}
	}

	@Override
	public boolean isComplete() {
		return isCompleteaux();
	}
	
	private boolean isCompleteaux() {
		if(this.pessoa == null) {
			return true;
		}
		
		if(this.left == null && this.right == null) {
			return true;
		}
		
		if(this.left != null && this.right != null) {
			return this.left.isCompleteaux() && this.right.isCompleteaux();
		}
		
		return false;
	}
}
