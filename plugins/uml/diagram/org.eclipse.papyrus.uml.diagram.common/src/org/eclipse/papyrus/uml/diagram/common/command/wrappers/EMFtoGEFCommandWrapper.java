/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.command.wrappers;

// TODO: Auto-generated Javadoc
/**
 * A GEF Command that wraps an EMF command. Each method is redirected to the EMF
 * one. <br>
 * Adapts an {@link org.eclipse.emf.common.command.Command EMF Command} to be a {@link org.eclipse.gef.commands.Command GEF Command}.
 * 
 * Creation : 21 fev. 2006
 * 
 * @deprecated use {@link org.eclipse.papyrus.commands.wrappers.EMFtoGEFCommandWrapper} instead
 * @author aarong, <a href="mailto:jacques.lescot@anyware-tech.com">Jacques
 *         LESCOT</a>
 */
public class EMFtoGEFCommandWrapper extends org.eclipse.papyrus.commands.wrappers.EMFtoGEFCommandWrapper {

	/**
	 * Constructor.
	 * 
	 * @param command
	 *        the wrapped EMF command
	 */
	public EMFtoGEFCommandWrapper(final org.eclipse.emf.common.command.Command command) {
		super(command);
	}
}
