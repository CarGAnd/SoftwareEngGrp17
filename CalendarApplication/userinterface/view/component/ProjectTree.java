package userinterface.view.component;

import java.awt.Container;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import business_logic.Management;
import business_logic.Management.userType;
import business_logic.User;
import userinterface.controller.FrameController;

/**
 * ProjectTree shows projects for the user/worker.
 * 
 * @author Tobias
 * @version 0.3
 *
 */
public class ProjectTree extends JPanel {
	private static final long	   serialVersionUID	= 1L;
	private DefaultMutableTreeNode usersProjectList;



	public ProjectTree() {
		try {
			updateProjectTree(FrameController.getController().getManagement().getLoggedInUser());			
		} catch (Exception e) {

		}finally {
			updateProjectTree(new User("Dummy", "dummy", userType.Employee));
		}

	}

	public void updateProjectTree(User user) {
		if (user!=null) {
			if (user.getTypeOfUser()== Management.userType.Admin) {
				usersProjectList = new DefaultMutableTreeNode(user.getUserID());
				DefaultMutableTreeNode project = new DefaultMutableTreeNode("Project one");
				DefaultMutableTreeNode fruitNode = new DefaultMutableTreeNode("Project two");
				usersProjectList.add(project);
				usersProjectList.add(fruitNode);

			}
			else if (user.getTypeOfUser() == userType.Employee) {
				usersProjectList = new DefaultMutableTreeNode("Admin");
				// create the child nodes
				DefaultMutableTreeNode project = new DefaultMutableTreeNode("Worker one");
				DefaultMutableTreeNode fruitNode = new DefaultMutableTreeNode("Worker two");

				// add the child nodes to the root node
				usersProjectList.add(project);
				usersProjectList.add(fruitNode);

			}
			else {
				usersProjectList = new DefaultMutableTreeNode("No user is logged in.");

			}

			// create the tree by passing in the root node
			JTree tree = new JTree(usersProjectList);
			add(tree);

			FrameController.skinComponent(this);
		}

	}

}
