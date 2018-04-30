package userinterface.view.component;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import userinterface.controller.FrameController;

public class ProjectTree extends JTree {
	private static final long serialVersionUID = 1L;

	public ProjectTree() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("all projects");
		createNodes(root);
		JTree tree = new JTree(root);
		FrameController.skinComponent(tree);
	}

	private void createNodes(DefaultMutableTreeNode top) {
		DefaultMutableTreeNode category = null;
		DefaultMutableTreeNode book = null;

		category = new DefaultMutableTreeNode("Books for Java Programmers");
		top.add(category);

		book = new DefaultMutableTreeNode("d");
		category.add(book);

	}
}
