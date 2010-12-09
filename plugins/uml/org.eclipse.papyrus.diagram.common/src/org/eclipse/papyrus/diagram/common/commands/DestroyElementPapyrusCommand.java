/*****************************************************************************
 * Copyright (c) 2010 Atos Origin
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.commands;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

/**
 * This destroy command uses the first generic cross referencer founded instead of using only the GMF one.
 * This is useful because elements that don't have a corresponding GMF type (like MOS in the sequence diagram)
 * don't have the GMF cross referencer registered after a reload.
 * 
 * @author mvelten
 * 
 */
public class DestroyElementPapyrusCommand extends DestroyElementCommand {

	public DestroyElementPapyrusCommand(DestroyElementRequest request) {
		super(request);
	}

	@Override
	protected void tearDownIncomingReferences(EObject destructee) {
		ECrossReferenceAdapter crossReferencer = ECrossReferenceAdapter.getCrossReferenceAdapter(destructee);

		if(crossReferencer != null) {
			Collection<Setting> inverseReferences = crossReferencer.getInverseReferences(destructee);
			if(inverseReferences != null) {
				for(Setting setting : inverseReferences) {
					EReference eRef = (EReference)setting.getEStructuralFeature();
					if(eRef.isChangeable() && (eRef.isDerived() == false) && (eRef.isContainment() == false) && (eRef.isContainer() == false)) {
						EcoreUtil.remove(setting.getEObject(), eRef, destructee);
					}
				}
			}
		}
	}

}
