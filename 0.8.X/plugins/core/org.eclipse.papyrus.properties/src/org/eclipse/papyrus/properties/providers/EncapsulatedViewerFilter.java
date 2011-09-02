package org.eclipse.papyrus.properties.providers;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.widgets.providers.UnchangedObject;
import org.eclipse.papyrus.widgets.providers.UnsetObject;


public class EncapsulatedViewerFilter extends ViewerFilter {

	private ViewerFilter viewerFilter;

	public EncapsulatedViewerFilter(ViewerFilter encapsulated) {
		this.viewerFilter = encapsulated;
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if(element == UnsetObject.instance || element == UnchangedObject.instance) {
			return true;
		}
		return viewerFilter.select(viewer, parentElement, element);
	}

}
