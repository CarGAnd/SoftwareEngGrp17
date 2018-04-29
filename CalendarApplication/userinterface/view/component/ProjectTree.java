package userinterface.view.component;

import java.awt.Dimension;

import javax.swing.JTree;

import userinterface.controller.FrameController;

public class ProjectTree extends JTree {
	private static final long serialVersionUID = 1L;

	public ProjectTree() {
		FrameController.skinComponent(this);
		this.setSize(new Dimension(300, 200));
//		//create the root node
//        DefaultMutableTreeNode root = new DefaultMutableTreeNode("All workers");
//        //create the child nodes
//        DefaultMutableTreeNode vegetableNode = new DefaultMutableTreeNode("Worker 1");
//        DefaultMutableTreeNode fruitNode = new DefaultMutableTreeNode("Worker 2");
//        //add the child nodes to the root node
//        root.add(vegetableNode);
//        root.add(fruitNode);
//         
//        //create the tree by passing in the root node
//        this.add(root);
         
	}
}
