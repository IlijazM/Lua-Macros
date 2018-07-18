package frame;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import frame.macrotree.MacroTree;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {
	
	public MacroTree tree;
	public JPanel panel;
	
	public MainPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		add(splitPane, BorderLayout.CENTER);
		
		JScrollPane scrollPaneWest = new JScrollPane();
		splitPane.setLeftComponent(scrollPaneWest);
		
		tree = new MacroTree();
		scrollPaneWest.setViewportView(tree);
		tree.setEditable(false);
		
		JScrollPane scrollPaneCenter = new JScrollPane();
		splitPane.setRightComponent(scrollPaneCenter);
		
		panel = new JPanel();
		scrollPaneCenter.setViewportView(panel);
	}

}
