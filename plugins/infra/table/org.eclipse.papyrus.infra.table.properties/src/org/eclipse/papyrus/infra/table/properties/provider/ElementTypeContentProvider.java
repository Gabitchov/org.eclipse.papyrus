package org.eclipse.papyrus.infra.table.properties.provider;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.AbstractStaticContentProvider;


public class ElementTypeContentProvider extends AbstractStaticContentProvider implements ITreeContentProvider {

	public String[] getElements() {
		return new String[]{ /* TODO */};
	}

	public Object[] getChildren(Object parentElement) {
		return new Object[0];
	}

	public Object getParent(Object element) {
		return null; //Flat provider
	}

	public boolean hasChildren(Object element) {
		return false;
	}


}
