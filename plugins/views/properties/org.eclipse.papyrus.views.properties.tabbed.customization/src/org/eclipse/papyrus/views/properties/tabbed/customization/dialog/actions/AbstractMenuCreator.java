/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.tabbed.customization.dialog.actions;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.papyrus.views.properties.tabbed.core.view.SectionSetDescriptorState;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.uml2.uml.Stereotype;


/**
 * Abstract class for all menu creators for customization dialog
 */
public abstract class AbstractMenuCreator implements IMenuCreator {

	/** identifier for the add group in the menu */
	public static final String ADD_GROUP = "addGroup";

	/** current selected section set descriptor state */
	private final SectionSetDescriptorState sectionSetDescriptorState;


	/**
	 * Returns the sectionSetDescriptorState
	 * 
	 * @return the sectionSetDescriptorState
	 */
	public SectionSetDescriptorState getSectionSetDescriptorState() {
		return sectionSetDescriptorState;
	}

	/**
	 * Returns the currentMetaclass
	 * 
	 * @return the currentMetaclass
	 */
	public EClassifier getCurrentMetaclass() {
		return currentMetaclass;
	}

	/**
	 * Returns the currentStereotype
	 * 
	 * @return the currentStereotype
	 */
	public Stereotype getCurrentStereotype() {
		return currentStereotype;
	}

	/** current selected metaclass */
	private final EClassifier currentMetaclass;

	/** current selected stereotype */
	private final Stereotype currentStereotype;


	/**
	 * Creates a new AbstractMenuCreator.
	 * Note: Either {@link #currentMetaclass} either {@link #currentStereotype} should not be null
	 * 
	 * @param sectionSetDescriptorState
	 *        the current selected section set descriptor state
	 * @param currentMetaclass
	 *        the current selected metaclass. Can be <code>null</code>
	 * @param currentStereotype
	 *        the current selected Stereotype. Can be <code>null</code>
	 * 
	 */
	public AbstractMenuCreator(SectionSetDescriptorState sectionSetDescriptorState, EClassifier currentMetaclass, Stereotype currentStereotype) {
		this.sectionSetDescriptorState = sectionSetDescriptorState;
		this.currentMetaclass = currentMetaclass;
		this.currentStereotype = currentStereotype;
	}

	/**
	 * {@inheritDoc}
	 */
	public Menu getMenu(Menu parent) {
		return null;
	}

}
