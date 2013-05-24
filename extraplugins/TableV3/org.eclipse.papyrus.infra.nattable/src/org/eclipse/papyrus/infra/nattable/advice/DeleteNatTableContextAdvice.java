/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.advice;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.core.util.CrossReferenceAdapter;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.infra.nattable.messages.Messages;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;

/**
 * Destroy the NatTable
 * 
 * 
 * @author Vincent Lorenzo
 * 
 */
public class DeleteNatTableContextAdvice extends AbstractEditHelperAdvice {

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getBeforeDestroyDependentsCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest request) {
		final EObject objectToDestroy = request.getElementToDestroy();
		if(objectToDestroy == null) {
			return null;
		}

		final ECrossReferenceAdapter crossReferencerAdapter = CrossReferenceAdapter.getCrossReferenceAdapter(objectToDestroy);
		final Collection<Setting> settings = crossReferencerAdapter.getNonNavigableInverseReferences(objectToDestroy);
		CompositeCommand cmd = new CompositeCommand(Messages.DeleteNatTableContextAdvice_DestroyNattableCommand);
		for(Setting currentSetting : settings) {
			final EObject currentEObject = currentSetting.getEObject();
			final EStructuralFeature currentfeature = currentSetting.getEStructuralFeature();
			if(currentEObject instanceof Table && currentfeature == NattablePackage.eINSTANCE.getTable_Context()) {
				final DestroyElementRequest request2 = new DestroyElementRequest(currentEObject, false);
				final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(currentEObject);
				cmd.add(provider.getEditCommand(request2));
			}
		}
		if(!cmd.isEmpty()) {
			return cmd;
		}
		return null;
	}

}
