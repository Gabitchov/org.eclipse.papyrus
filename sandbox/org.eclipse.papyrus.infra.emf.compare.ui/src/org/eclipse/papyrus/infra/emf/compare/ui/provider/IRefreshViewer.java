package org.eclipse.papyrus.infra.emf.compare.ui.provider;

import org.eclipse.jface.viewers.TreeViewer;


public interface IRefreshViewer {

	public void registerViewer(TreeViewer viewer);
	
 public void refreshViewer();
}
