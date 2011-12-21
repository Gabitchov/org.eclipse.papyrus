/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.commands;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * A Command to apply a Stereotype on a UML Element
 * 
 * @author Camille Letavernier
 */
public class ApplyStereotypeCommand extends AbstractCommand {

	private Element element;

	private Collection<Stereotype> stereotypes;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param element
	 *        The UML Element on which the stereotypes will be applied
	 * @param stereotypes
	 *        The stereotypes to apply
	 */
	public ApplyStereotypeCommand(Element element, Collection<Stereotype> stereotypes) {
		this.element = element;
		this.stereotypes = stereotypes;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param element
	 *        The UML Element on which the stereotype will be applied
	 * @param stereotype
	 *        The stereotypes to apply
	 */
	public ApplyStereotypeCommand(Element element, Stereotype stereotype) {
		this.element = element;
		this.stereotypes = Collections.singletonList(stereotype);
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	public void execute() {
		for(Stereotype stereotype : stereotypes) {
			element.applyStereotype(stereotype);
		}
	}

	@Override
	public boolean canUndo() {
		return true;
	}

	@Override
	public void undo() {
		for(Stereotype stereotype : stereotypes) {
			element.unapplyStereotype(stereotype);
		}
	}

	public void redo() {
		execute();
	}

}
