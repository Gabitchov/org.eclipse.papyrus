package org.eclipse.papyrus.profile.definition;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Property;
/**
 * this class is used to display mistake of properties doublon  {@link ProfileRedefinition#verifyBaseProperty(org.eclipse.uml2.uml.Package)}
 */
public class ErrorLabelProvider implements ILabelProvider{

	/**
	 * Constructor
	 */
	public ErrorLabelProvider() {
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Image getImage(Object element) {
		return null;
	}
	/**
	 * {@inheritDoc}
	 */
	public String getText(Object element) {
		if(element instanceof Property){
			return "The property "+((org.eclipse.uml2.uml.Property)element).getName()+
			" exists twice " +
			"time in the class "+((Classifier)((org.eclipse.uml2.uml.Property)element).getOwner()).getQualifiedName();
		}
		return element.toString();
	}
	/**
	 * {@inheritDoc}
	 */
	public void addListener(ILabelProviderListener listener) {
	}
	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
	}
	/**
	 * {@inheritDoc}
	 */
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}
	/**
	 * {@inheritDoc}
	 */
	public void removeListener(ILabelProviderListener listener) {
	}

}
