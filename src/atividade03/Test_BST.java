package atividade03;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class Test_BST {
	private BST_IF bst;
	private final long basecpf = 99955511100L;
	
	@Before
	public void setUp() {
		bst = new BST();
	}
	
	@Test
	public void testInsertAndSearch() throws Exception {
		bst.insert( new Pessoa(0, basecpf, "Ana") );
		Pessoa ana = new Pessoa(0, basecpf, "Ana");
		assertEquals(ana, bst.search(new Pessoa(0, basecpf, "Ana")));
	}
	
	@Test
	public void testInsert() throws Exception {
		int[] v = {8,4,12,2,6,10,14,1,3,5,7,9,11,13,15};
		for(int i: v) bst.insert( new Pessoa(i, basecpf+i, "Xxx"+i) );
		Pessoa pessoa8 = new Pessoa(8, basecpf+8, "Xxx"+8);
		assertEquals(pessoa8, bst.search(new Pessoa(8, basecpf+8, "Xxx"+8)));
	}
	
	@Test
	public void testInsert_comPostOrder(){
		int[] v = {10,6,8,9,3,7,2,5,1,4,16,14,18,13,19,15,20,11,12,17,21};
		for(int i: v) bst.insert( new Pessoa(i, basecpf+i, "Xxx"+i) );
		int postorder[] = {1,2,4,5,3,7,9,8,6,12,11,13,15,14,17,21,20,19,18,16,10};
		Pessoa[] pessoas_postorder = new Pessoa[postorder.length];
		for (int p = 0; p < pessoas_postorder.length; p++) pessoas_postorder[p] = new Pessoa(postorder[p], basecpf+postorder[p], "Xxx"+postorder[p]);
		assertArrayEquals(pessoas_postorder, bst.postOrder());
	}
	
	@Test(expected = Exception.class)
	public void testRemove1() throws Exception {
		bst.remove( new Pessoa(0, basecpf, "Ana") );
	}
	
	@Test(expected = Exception.class)
	public void testRemove2() throws Exception {
		Pessoa ana = new Pessoa(0, basecpf, "Ana");
		bst.insert(ana);
		bst.remove(ana);
		bst.search(ana);
	}
	
	@Test
	public void testRemove_order_pares() throws Exception {
		int[] v = {8,4,12,2,6,10,14,1,3,5,7,9,11,13,15};
		for(int i: v) bst.insert( new Pessoa(i, basecpf+i, "Xxx"+i) );
		for(int i: v) if (i%2 == 0) bst.remove( new Pessoa(i, basecpf+i, "Xxx"+i) );
		int order[] = {1,3,5,7,9,11,13,15};
		Pessoa[] pessoas_order = new Pessoa[order.length];
		for (int p = 0; p < pessoas_order.length; p++) pessoas_order[p] = new Pessoa(order[p], basecpf+order[p], "Xxx"+order[p]);
		assertArrayEquals(pessoas_order, bst.order());
	}
	
	@Test
	public void testRemove_order_impares() throws Exception {
		int[] v = {8,4,12,2,6,10,14,1,3,5,7,9,11,13,15};
		for(int i: v) bst.insert( new Pessoa(i, basecpf+i, "Xxx"+i) );
		for(int i: v) if (i%2 != 0) bst.remove( new Pessoa(i, basecpf+i, "Xxx"+i) );
		int order[] = {2,4,6,8,10,12,14};
		Pessoa[] pessoas_order = new Pessoa[order.length];
		for (int p = 0; p < pessoas_order.length; p++) pessoas_order[p] = new Pessoa(order[p], basecpf+order[p], "Xxx"+order[p]);
		assertArrayEquals(pessoas_order, bst.order());
	}
	
	@Test(expected = Exception.class)
	public void testSearch1() throws Exception {
		bst.search( new Pessoa(0, basecpf, "Ana") );
	}
	
	@Test
	public void testSearch2() throws Exception {
		bst.insert( new Pessoa(0, basecpf, "Ana") );
		assertEquals(new Pessoa(0, basecpf, "Ana"), bst.search(new Pessoa(0, basecpf, "Ana")));
	}
	
	@Test
	public void testSearch3() throws Exception {
		int[] v = {10,6,8,9,3,7,2,5,1,4,16,14,18,13,19,15,20,11,12,17,21};
		for(int i: v) bst.insert( new Pessoa(i, basecpf+i, "Xxx"+i) );
		int postorder[] = {1,2,4,5,3,7,9,8,6,12,11,13,15,14,17,21,20,19,18,16,10};
		for (int p = 0; p < postorder.length; p++) {
			Pessoa pessoa = new Pessoa(postorder[p], basecpf+postorder[p], "Xxx"+postorder[p]);
			assertEquals( bst.search(pessoa), new Pessoa(postorder[p], basecpf+postorder[p], "Xxx"+postorder[p]) );
		}
	}
	
	@Test
	public void testPreOrder1(){
		int[] v = {8,4,12,2,6,10,14,1,3,5,7,9,11,13,15};
		for(int i: v) bst.insert( new Pessoa(i, basecpf+i, "Xxx"+i) );
		int[] preOrder = {8,4,2,1,3,6,5,7,12,10,9,11,14,13,15};
		Pessoa[] pessoas_preOrder = new Pessoa[preOrder.length];
		for (int p = 0; p < pessoas_preOrder.length; p++) pessoas_preOrder[p] = new Pessoa(preOrder[p], basecpf+preOrder[p], "Xxx"+preOrder[p]);
		assertArrayEquals(pessoas_preOrder, bst.preOrder());
	}
	
	@Test
	public void testpreOrder2(){
		int[] v = {10,6,8,9,3,7,2,5,1,4,16,14,18,13,19,15,20,11,12,17};
		for(int i: v) bst.insert( new Pessoa(i, basecpf+i, "Xxx"+i) );
		int preOrder[] = {10, 6, 3, 2, 1, 5, 4, 8, 7, 9, 16, 14, 13, 11, 12, 15, 18, 17, 19, 20};
		Pessoa[] pessoas_preOrder = new Pessoa[preOrder.length];
		for (int p = 0; p < pessoas_preOrder.length; p++) pessoas_preOrder[p] = new Pessoa(preOrder[p], basecpf+preOrder[p], "Xxx"+preOrder[p]);
		assertArrayEquals(pessoas_preOrder, bst.preOrder());
	}
	
	@Test
	public void testOrder1(){
		int[] v = {8,4,12,2,6,10,14,1,3,5,7,9,11,13,15};
		for(int i: v) bst.insert( new Pessoa(i, basecpf+i, "Xxx"+i) );
		int[] order = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		Pessoa[] pessoas_order = new Pessoa[order.length];
		for (int p = 0; p < pessoas_order.length; p++) pessoas_order[p] = new Pessoa(order[p], basecpf+order[p], "Xxx"+order[p]);
		assertArrayEquals(pessoas_order, bst.order());
	}
	
	@Test
	public void testOrder2(){
		int[] v = {10,6,8,9,3,7,2,5,1,4,16,14,18,13,19,15,20,11,12,17};
		for(int i: v) bst.insert( new Pessoa(i, basecpf+i, "Xxx"+i) );
		int order[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		Pessoa[] pessoas_order = new Pessoa[order.length];
		for (int p = 0; p < pessoas_order.length; p++) pessoas_order[p] = new Pessoa(order[p], basecpf+order[p], "Xxx"+order[p]);
		assertArrayEquals(pessoas_order, bst.order());
	}
	
	@Test
	public void testPostOrder1(){
		int[] v = {8,4,12,2,6,10,14,1,3,5,7,9,11,13,15};
		for(int i: v) bst.insert( new Pessoa(i, basecpf+i, "Xxx"+i) );
		int[] postOrder = {1,3,2,5,7,6,4,9,11,10,13,15,14,12,8};
		Pessoa[] pessoas_postOrder = new Pessoa[postOrder.length];
		for (int p = 0; p < pessoas_postOrder.length; p++) pessoas_postOrder[p] = new Pessoa(postOrder[p], basecpf+postOrder[p], "Xxx"+postOrder[p]);
		assertArrayEquals(pessoas_postOrder, bst.postOrder());
	}
	
	@Test
	public void testpostOrder2(){
		int[] v = {10,6,8,9,3,7,2,5,1,4,16,14,18,13,19,15,20,11,12,17};
		for(int i: v) bst.insert( new Pessoa(i, basecpf+i, "Xxx"+i) );
		int postOrder[] = {1,2,4,5,3,7,9,8,6,12,11,13,15,14,17,20,19,18,16,10};
		Pessoa[] pessoas_postOrder = new Pessoa[postOrder.length];
		for (int p = 0; p < pessoas_postOrder.length; p++) pessoas_postOrder[p] = new Pessoa(postOrder[p], basecpf+postOrder[p], "Xxx"+postOrder[p]);
		assertArrayEquals(pessoas_postOrder, bst.postOrder());

	}
	
	@Test
	public void testIsComplete1(){
		int[] v = {8,4,12,2,6,10,14,1,3,5,7,9,11,13,15};
		for(int i: v) bst.insert( new Pessoa(i, basecpf+i, "Xxx"+i) );
		assertTrue(bst.isComplete());
	}
	
	@Test
	public void testIsComplete1_false(){
		int[] v = {8,4,12,2,6,10,14,1,3,5,7,9,11,13};
		for(int i: v) bst.insert( new Pessoa(i, basecpf+i, "Xxx"+i) );
		assertFalse(bst.isComplete());
	}
	
	@Test
	public void testIsComplete2(){
		int[] v = {10,6,8,9,3,7,2,5,16,14,18,13,19,15,17};
		for(int i: v) bst.insert( new Pessoa(i, basecpf+i, "Xxx"+i) );
		assertTrue(bst.isComplete());
	}
	
	@Test
	public void testIsComplete2_false(){
		int[] v = {10,6,8,9,3,7,2,5,1,4,16,14,18,13,19,15,20,11,12,17};
		for(int i: v) bst.insert( new Pessoa(i, basecpf+i, "Xxx"+i) );
		assertFalse(bst.isComplete());
	}

}