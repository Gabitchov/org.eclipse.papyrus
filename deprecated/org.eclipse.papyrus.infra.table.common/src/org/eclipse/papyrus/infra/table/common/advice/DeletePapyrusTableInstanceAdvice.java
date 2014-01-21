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
package org.eclipse.papyrus.infra.table.common.advice;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableinstancePackage;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance2.TableInstance2;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.core.util.CrossReferenceAdapter;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrustableinstancePackage;

/**
 * Destroy the referenced TableInstance2
 * 
 * 
 * @author Vincent Lorenzo
 * 
 */
public class DeletePapyrusTableInstanceAdvice extends AbstractEditHelperAdvice {

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
		//the destroyed element is a PapyrusTableInstace
		if(objectToDestroy instanceof PapyrusTableInstance) {
			final TableInstance2 instance = ((PapyrusTableInstance)objectToDestroy).getTable();
			final DestroyElementRequest request2 = new DestroyElementRequest(instance, false);
			final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(instance);
			return provider.getEditCommand(request2);
		} else if(objectToDestroy instanceof EObject) {//the destroyed element could be a table container
			final ECrossReferenceAdapter crossReferencerAdapter = CrossReferenceAdapter.getCrossReferenceAdapter(objectToDestroy);
			final Collection<Setting> settings = crossReferencerAdapter.getNonNavigableInverseReferences(objectToDestroy);
			//the destroyed context can references several table!
			final CompositeCommand cmd = new CompositeCommand("Destroy Table Instance2 Command"); //$NON-NLS-1$
			for(Setting currentSetting : settings) {
				final EObject currentEObject = currentSetting.getEObject();
				final EStructuralFeature currentfeature = currentSetting.getEStructuralFeature();
				if(currentEObject instanceof TableInstance2 && currentfeature == TableinstancePackage.eINSTANCE.getTableInstance_Context()) {
					final Collection<Setting> tableInstanceSettings = crossReferencerAdapter.getNonNavigableInverseReferences(currentEObject);
					for(Setting setting : tableInstanceSettings) {
						final EObject eobject = setting.getEObject();
						final EStructuralFeature currentFeature = setting.getEStructuralFeature();
						if(eobject instanceof PapyrusTableInstance && currentFeature == PapyrustableinstancePackage.eINSTANCE.getPapyrusTableInstance_Table()) {//the destroyed element is a table container
							final DestroyElementRequest request2 = new DestroyElementRequest(eobject, false);
							final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(eobject);
							final ICommand tmp = provider.getEditCommand(request2);
							cmd.add(tmp);
						}
					}
				}
			}
			if(!cmd.isEmpty()) {
				return cmd;
			}
		}
		return null;
	}

}
