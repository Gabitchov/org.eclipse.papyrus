/*******************************************************************************
 * Copyright (c) 2008 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.tabbedproperties.core.listeners;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;

/**
 * this is listenr to create an element
 * 
 * @author Patrick Tessier
 * 
 */
public abstract class CreateElementListener implements MouseListener {

	/**
	 * {@inheritDoc}
	 */
	public void mouseDoubleClick(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	public void mouseDown(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * code to write in order to create a element when the Form send the kind of element to create example for value Specification
	 * 
	 * @param eclass
	 *            hte kind of element
	 */
	public void fireCreate(EClass eclass) {
		System.err.println("Create " + eclass);

	}

	/**
	 * Code to write in order to create the element
	 * 
	 */
	public abstract void mouseUp(MouseEvent e);

}
