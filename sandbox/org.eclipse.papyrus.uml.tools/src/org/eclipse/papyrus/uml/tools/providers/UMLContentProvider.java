package org.eclipse.papyrus.uml.tools.providers;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.widgets.providers.AbstractStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;

public class UMLContentProvider extends AbstractStaticContentProvider implements IHierarchicContentProvider{

	public void dispose() {
		// TODO Auto-generated method stub
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub
		
	}

	public Object[] getElements(Object inputElement) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object[] getChildren(Object parentElement) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasChildren(Object element) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isValidValue(Object element) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object[] getElements() {
		// TODO Auto-generated method stub
		return null;
	}

}
