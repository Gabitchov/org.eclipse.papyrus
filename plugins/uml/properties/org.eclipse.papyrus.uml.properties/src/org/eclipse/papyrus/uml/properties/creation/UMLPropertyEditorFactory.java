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
package org.eclipse.papyrus.uml.properties.creation;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.properties.Activator;
import org.eclipse.papyrus.views.properties.creation.EcorePropertyEditorFactory;


public class UMLPropertyEditorFactory extends EcorePropertyEditorFactory {

	public UMLPropertyEditorFactory(EReference referenceIn) {
		super(referenceIn);
	}

	/**
	 * {@inheritDoc} Overridden to use Papyrus commands
	 */
	@Override
	public Collection<Object> validateObjects(Collection<Object> objectsToValidate) {
		if(!referenceIn.isContainment()) {
			for(Object objectToValidate : objectsToValidate) {
				//We add the object to the containment reference
				//They will be automatically added to the edited reference
				//(referenceIn) after this method returns
				CreateIn creationInformation = this.createIn.get(objectToValidate);
				if(creationInformation != null) {
					set(creationInformation.createInObject, creationInformation.createInReference, objectToValidate);
				} else {
					Activator.log.warn("Unknown object : " + objectToValidate);
				}
			}
		}

		return objectsToValidate;
	}

	protected void set(EObject container, EReference reference, Object value) {
		try {
			EditingDomain domain = EMFHelper.resolveEditingDomain(container);
			if(domain == null) {
				container.eSet(reference, value);
				return;
			}

			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(container);

			if(provider != null) {
				SetRequest request = new SetRequest((TransactionalEditingDomain)domain, container, reference, value);
				ICommand createGMFCommand = provider.getEditCommand(request);

				Command emfCommand = new GMFtoEMFCommandWrapper(createGMFCommand);

				domain.getCommandStack().execute(emfCommand);
			}
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

}
