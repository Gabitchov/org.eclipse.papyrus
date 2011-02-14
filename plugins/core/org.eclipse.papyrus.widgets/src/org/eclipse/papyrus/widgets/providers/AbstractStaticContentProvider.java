package org.eclipse.papyrus.widgets.providers;

import org.eclipse.jface.viewers.Viewer;

/**
 * An empty implementation of IStaticContentProvider
 * 
 * @author Camille Letavernier
 * 
 */
public abstract class AbstractStaticContentProvider implements IStaticContentProvider {

	public void dispose() {
		// Nothing
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// Nothing
	}

}
