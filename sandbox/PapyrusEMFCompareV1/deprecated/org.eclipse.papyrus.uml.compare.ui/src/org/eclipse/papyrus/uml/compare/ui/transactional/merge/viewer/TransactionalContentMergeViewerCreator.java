package org.eclipse.papyrus.uml.compare.ui.transactional.merge.viewer;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.IViewerCreator;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;


public class TransactionalContentMergeViewerCreator implements IViewerCreator {

	public TransactionalContentMergeViewerCreator() {
		// TODO Auto-generated constructor stub
	}

	public Viewer createViewer(Composite parent, CompareConfiguration config) {
		//return new  ModelContentMergeViewer(parent,config);
		return new TransactionalModelContentMergeViewer(parent, config);
	}
	
	
}
