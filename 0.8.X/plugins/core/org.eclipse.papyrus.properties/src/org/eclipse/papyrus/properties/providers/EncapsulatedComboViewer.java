package org.eclipse.papyrus.properties.providers;

import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ViewerFilter;


public class EncapsulatedComboViewer extends ComboViewer {

	public EncapsulatedComboViewer(ComboViewer viewer) {
		super(viewer.getCCombo());
		if(viewer.getContentProvider() != null) {
			super.setContentProvider(viewer.getContentProvider());
		}
		if(viewer.getInput() != null) {
			super.setInput(viewer.getInput());
		}
		if(viewer.getLabelProvider() != null) {
			super.setLabelProvider(viewer.getLabelProvider());
		}
		if(viewer.getFilters() != null) {
			super.setFilters(viewer.getFilters());
		}
	}

	@Override
	public void setFilters(ViewerFilter[] filters) {
		for(ViewerFilter filter : filters) {
			addFilter(filter);
		}
	}

	@Override
	public void addFilter(ViewerFilter filter) {
		super.addFilter(new EncapsulatedViewerFilter(filter));
	}
}
