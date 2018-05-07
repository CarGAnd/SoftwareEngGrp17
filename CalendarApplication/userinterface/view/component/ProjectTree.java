package userinterface.view.component;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.Box;
import javax.swing.JPanel;
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
 * @version 0.4
 *
 */
public class ProjectTree extends JPanel {
	private static final long	   serialVersionUID	= 1L;
	private DefaultMutableTreeNode usersProjectList;

	public ProjectTree() {
		super();
		this.setLayout(new BorderLayout());
		try {
			this.add(Box.createHorizontalStrut(200), BorderLayout.SOUTH);
			updateProjectTree(FrameController.getController().getManagement().getLoggedInUser());
			System.out.println("Created project tree.");
		} catch (Exception e) {
			updateProjectTree(new User(null, null, null));
			System.out.println("Caught an exception...");
		}

	}

	public void updateProjectTree(User user) {
		if (user != null) {
			if (user.getTypeOfUser() == Management.userType.Admin) {
				System.out.println("Admin logged in");
				usersProjectList = new DefaultMutableTreeNode(user.getUserID());
				DefaultMutableTreeNode users = new DefaultMutableTreeNode("All users");
				DefaultMutableTreeNode projects = new DefaultMutableTreeNode("All projects");
				usersProjectList.add(users);
				usersProjectList.add(projects);

			}
			else if (user.getTypeOfUser() == userType.Employee) {
				System.out.println("Employee logged in");
				usersProjectList = new DefaultMutableTreeNode(user.getTypeOfUser().toString() + ": " + user.getUserID());
				DefaultMutableTreeNode ownProjects = new DefaultMutableTreeNode("");
				DefaultMutableTreeNode allProjects = new DefaultMutableTreeNode("Worker two");
				usersProjectList.add(ownProjects);
				usersProjectList.add(allProjects);

			}
			else {
				usersProjectList = new DefaultMutableTreeNode("No user is logged in.");

			}

			// create the tree by passing in the root node
			JTree tree = new JTree(usersProjectList);
			FrameController.skinComponent(this);
			this.add(tree, BorderLayout.CENTER);
		}

	}

}
