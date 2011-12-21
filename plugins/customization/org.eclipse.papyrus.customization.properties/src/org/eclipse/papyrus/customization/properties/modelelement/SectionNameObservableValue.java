/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.modelelement;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.emf.databinding.EMFObservableValue;
import org.eclipse.papyrus.views.properties.contexts.ContextsPackage;
import org.eclipse.papyrus.views.properties.contexts.Section;

/**
 * An ObservableValue for handling changes in a section's name.
 * The section is linked to an external XWT Resource with the same
 * name. When the section's name changes, the XWT resource should
 * be moved as well, and the section's sectionFile property should
 * be updated.
 * 
 * @author Camille Letavernier
 */
public class SectionNameObservableValue extends EMFObservableValue {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param eObject
	 *        The EObject (Section) being edited
	 * @param eStructuralFeature
	 *        The feature ("name") being editing
	 * @param domain
	 *        The editing domain on which the commands will be called
	 */
	public SectionNameObservableValue(EObject eObject, EStructuralFeature eStructuralFeature, EditingDomain domain) {
		super(eObject, eStructuralFeature, domain);
	}

	@Override
	public void doSetValue(Object value) {
		CompoundCommand command = new CompoundCommand();
		String name = (String)value;
		command.append(getSetCommand(name));
		command.append(getMoveCommand(name));
		command.append(getSetSectionFileCommand(name));
		domain.getCommandStack().execute(command);
	}

	/**
	 * Returns a command to change the section's sectionFile when the name changes
	 * 
	 * @param name
	 *        The name of the section we are editing
	 * @return
	 *         The command to change the section's sectionFile
	 */
	protected Command getSetSectionFileCommand(String name) {
		return new SetCommand(domain, eObject, ContextsPackage.eINSTANCE.getSection_SectionFile(), "ui/" + name + ".xwt"); //$NON-NLS-1$ //$NON-NLS-2$ 
	}

	/**
	 * Returns the EMF command to move the section's XWT Resource
	 * 
	 * @param name
	 *        The new name of the section
	 * @return
	 *         The EMF command to move the section's XWT Resource
	 */
	protected Command getMoveCommand(String name) {
		Section section = (Section)eObject;

		//TODO : Create a command for that
		if(section.getWidget() != null) {
			URI newURI = URI.createURI("ui/" + name + ".xwt"); //$NON-NLS-1$ //$NON-NLS-2$
			newURI = newURI.resolve(section.eResource().getURI());
			ResourceSet resourceSet = section.eResource().getResourceSet();
			Resource newResource = resourceSet.createResource(newURI);
			newResource.getContents().add(section.getWidget());
		}

		return null;
	}
}
