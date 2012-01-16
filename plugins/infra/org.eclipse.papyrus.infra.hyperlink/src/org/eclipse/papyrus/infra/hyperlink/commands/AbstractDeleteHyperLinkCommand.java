/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.hyperlink.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * 
 * An abstract class to remove eannotation
 * 
 */
public abstract class AbstractDeleteHyperLinkCommand extends RecordingCommand {

	/**
	 * the edited object
	 */
	private final EModelElement object;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param domain
	 *        the editing domain for this command
	 * @param object
	 *        the edited EModelElement
	 */
	public AbstractDeleteHyperLinkCommand(final TransactionalEditingDomain domain, final EModelElement object) {
		super(domain);
		this.object = object;
	}

	/**
	 * 
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 * 
	 */
	@Override
	protected void doExecute() {
		// remove annotations
		for(EAnnotation current : getEAnnotationsToRemove()) {
			this.object.getEAnnotations().remove(current);
		}

	}

	/**
	 * 
	 * @return
	 *         the list of the EAnnotation to remove
	 */
	protected List<EAnnotation> getEAnnotationsToRemove() {
		List<EAnnotation> toRemove = new ArrayList<EAnnotation>();
		return toRemove;
	}

	/**
	 * Getter for {@link this#object}
	 * 
	 * @return
	 */
	protected EModelElement getObject() {
		return this.object;
	}

}
