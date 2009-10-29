/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/

package org.eclipse.papyrus.diagram.common.commands;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

// TODO: Auto-generated Javadoc
/**
 * Unapplies all stereotypes from an EObject.
 * 
 * @generated NOT
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * @deprecated
 */
public class UnapplyAllStereotypesCommand extends Command {

	/** Element to unapply stereotypes from. */
	private Element elementToEdit = null;

	/**
	 * Instantiates a new unapply all stereotypes command.
	 * 
	 * @param element
	 *            the element
	 */
	// @unused
	public UnapplyAllStereotypesCommand(Element element) {
		elementToEdit = element;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return elementToEdit != null;
	}

	/**
	 * Gets the element to edit.
	 * 
	 * @return the element to edit
	 */
	// @unused
	public EObject getElementToEdit() {
		return elementToEdit;
	}

	/**
	 * Sets the element to edit.
	 * 
	 * @param elementToEdit
	 *            the new element to edit
	 */
	// @unused
	public void setElementToEdit(Element elementToEdit) {
		this.elementToEdit = elementToEdit;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#dispose()
	 */
	@Override
	public void dispose() {
		elementToEdit = null;
		super.dispose();
	}

	/**
	 * Unapply stereotypes from elementToEdit.
	 */
	@Override
	public void execute() {

		List<Stereotype> stereotypeApplications = elementToEdit.getAppliedStereotypes();

		for (Stereotype stereotype : stereotypeApplications) {
			elementToEdit.unapplyStereotype(stereotype);
		}

	}

}
