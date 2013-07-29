/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.helper;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.appearance.commands.SetLayoutKindCommand;
import org.eclipse.papyrus.uml.diagram.common.figure.layout.AutomaticCompartmentToolBox;
import org.eclipse.papyrus.uml.diagram.common.figure.layout.ILayoutToolBox;
import org.eclipse.papyrus.uml.diagram.common.figure.layout.ManualCompartmentToolBox;

/**
 * The Class BasicClassifierCompartmentLayoutHelper offer automatic layout or
 * manual layout
 */
public class BasicClassifierCompartmentLayoutHelper extends ClassifierCompartmentLayoutHelper {

	/** The e instance. */
	protected static BasicClassifierCompartmentLayoutHelper eInstance = new BasicClassifierCompartmentLayoutHelper();

	/** The manualtool box. */
	protected ILayoutToolBox manualtoolBox;

	/** The automatic tool box. */
	protected ILayoutToolBox automaticToolBox;

	/**
	 * Gets the instances.
	 * 
	 * @return the instances
	 */
	public static BasicClassifierCompartmentLayoutHelper getInstances() {
		return eInstance;
	}

	/**
	 * Instantiates a new basic classifier compartment layout helper.
	 */
	protected BasicClassifierCompartmentLayoutHelper() {
		super();
		manualtoolBox = new ManualCompartmentToolBox();
		layoutToolBoxList.put(manualtoolBox.getLayout(), manualtoolBox);
		automaticToolBox = new AutomaticCompartmentToolBox();
		layoutToolBoxList.put(automaticToolBox.getLayout(), automaticToolBox);
	}

	/**
	 * Checks if is automatic.
	 * 
	 * @param eModelElement
	 *        the e model element
	 * 
	 * @return true, if is automatic
	 */
	public boolean isAutomatic(EModelElement eModelElement) {
		if((super.getLayoutKindFromView(eModelElement)).equals(automaticToolBox.getLayout())) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if is manual.
	 * 
	 * @param eModelElement
	 *        the e model element
	 * 
	 * @return true, if is manual
	 */
	public boolean isManual(EModelElement eModelElement) {
		if((super.getLayoutKindFromView(eModelElement)).equals(manualtoolBox.getLayout())) {
			return true;
		}
		return false;
	}

	/**
	 * Sets the manual layout kind on view.
	 * 
	 * @param domain
	 *        the domain
	 * @param view
	 *        the view
	 * 
	 * @return the sets the layout kind command
	 */
	public SetLayoutKindCommand setManualLayoutKindOnView(TransactionalEditingDomain domain, EModelElement view) {
		// TODO Auto-generated method stub
		return super.setLayoutKindOnView(domain, view, manualtoolBox.getLayout());
	}

	/**
	 * Sets the automatic layout kind on view.
	 * 
	 * @param domain
	 *        the domain
	 * @param view
	 *        the view
	 * 
	 * @return the sets the layout kind command
	 */
	public SetLayoutKindCommand setAutomaticLayoutKindOnView(TransactionalEditingDomain domain, EModelElement view) {
		// TODO Auto-generated method stub
		return super.setLayoutKindOnView(domain, view, automaticToolBox.getLayout());
	}
}
