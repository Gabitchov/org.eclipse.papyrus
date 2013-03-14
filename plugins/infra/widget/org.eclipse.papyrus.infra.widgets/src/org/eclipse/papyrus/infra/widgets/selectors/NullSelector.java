package org.eclipse.papyrus.infra.widgets.selectors;

import org.eclipse.papyrus.infra.widgets.editors.IElementSelectionListener;
import org.eclipse.papyrus.infra.widgets.editors.IElementSelector;
import org.eclipse.swt.widgets.Composite;

/**
 * A Null implementation of the IElementSelector interface
 * 
 * @author Camille Letavernier
 * 
 */
public class NullSelector implements IElementSelector {

	private NullSelector() {

	}

	public Object[] getSelectedElements() {
		return new Object[0];
	}

	public void setSelectedElements(Object[] elements) {
		//Nothing
	}

	public Object[] getAllElements() {
		return new Object[0];
	}

	public void createControls(Composite parent) {
		//Nothing
	}

	public void newObjectCreated(Object newObject) {
		//Nothing
	}

	public void clearTemporaryElements() {
		//Nothing
	}

	public void addElementSelectionListener(IElementSelectionListener listener) {
		//Nothing
	}

	public void removeElementSelectionListener(IElementSelectionListener listener) {
		//Nothing
	}

	public final static NullSelector instance = new NullSelector();

}
