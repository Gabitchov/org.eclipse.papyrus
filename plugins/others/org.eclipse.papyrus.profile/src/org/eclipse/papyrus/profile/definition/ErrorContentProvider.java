package org.eclipse.papyrus.profile.definition;

import java.util.ArrayList;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * this class is used to navigate in list of properties error in the profile  {@link ProfileRedefinition#verifyBaseProperty(org.eclipse.uml2.uml.Package)}
 */
public class ErrorContentProvider implements ITreeContentProvider{
	
	/** the list of errors */
	ArrayList<String> errorList=null;
	
	/**
	 * Creates a new ErrorContentProvider.
	 */
	public ErrorContentProvider() {
		super();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Object[] getChildren(Object parentElement) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getParent(Object element) {
		return errorList;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasChildren(Object element) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getElements(Object inputElement) {
		//this is a list of errors?
		if (inputElement instanceof ArrayList){
			errorList=((ArrayList)inputElement);
			return ((ArrayList)inputElement).toArray();
		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
	}

	/**
	 * {@inheritDoc}
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}
}
