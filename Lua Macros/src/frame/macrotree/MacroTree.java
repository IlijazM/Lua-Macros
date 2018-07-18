package frame.macrotree;

import java.io.File;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import macro.Macro;

@SuppressWarnings("serial")
public class MacroTree extends JTree {
	
	public MacroTree() {
		setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Macros") {
				{
					for (int i = 0; i < Macro.luaMacros.size(); i++) {
						String path = Macro.luaMacros.get(i).path;
						
						File file = new File(path);
						String name = file.getName();
						
						add(new DefaultMutableTreeNode(name));
					}
				}
			}
		));
		
		addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent event) {
			}
		});
	}
	
}
