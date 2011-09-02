package org.eclipse.papyrus.widgets.providers;

import java.util.Collection;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;


public class TreeCollectionContentProvider implements ITreeContentProvider {

	private TreeCollectionContentProvider() {

	}

	public Object[] getChildren(Object parentElement) {
		return new Object[0];
	}

	public Object getParent(Object element) {
		return null;
	}

	public boolean hasChildren(Object element) {
		return false;
	}

	public static TreeCollectionContentProvider instance = new TreeCollectionContentProvider();

	public void dispose() {
		//Nothing
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		//Nothing
	}

	/**
	 * Converts the input List to an Array containing the same elements
	 * 
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 * 
	 * @param inputElement
	 * @return
	 *         The Array containing the input elements
	 */
	public Object[] getElements(Object inputElement) {
		if(inputElement instanceof Collection) {
			return ((Collection<?>)inputElement).toArray();
		} else if(inputElement instanceof Object[]) {
			return (Object[])inputElement;
		}

		return new Object[]{};
	}

}
