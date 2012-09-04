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
package org.eclipse.papyrus.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

/**
 * This destroy command uses the first generic cross referencer founded instead
 * of using only the GMF one. This is useful because elements that don't have a
 * corresponding GMF type (like MOS in the sequence diagram) don't have the GMF
 * cross referencer registered after a reload.
 * 
 * @author mvelten
 * 
 */
public class DestroyElementPapyrusCommand extends DestroyElementCommand {

	public DestroyElementPapyrusCommand(DestroyElementRequest request) {
		super(request);
		getAffectedFiles().addAll(fileOfIncomingReferences(request.getElementToDestroy()));
	}
	
	/**
	 * Compute list of affected files affected by the tear donw methods
	 * @param destructee
	 * @return
	 */
	protected List fileOfIncomingReferences(EObject destructee) {
        if (destructee != null){
            Collection<Setting> usages = getUsages(destructee);
            List<Object> result =new ArrayList<Object>();
            for(Setting setting : usages) {
                EReference eRef = (EReference)setting.getEStructuralFeature();
                if(eRef.isChangeable() && (eRef.isDerived() == false) && (eRef.isContainment() == false) && (eRef.isContainer() == false)) {
                    List files = getWorkspaceFiles(setting.getEObject());
                    if (files != null){
                        result.addAll(files);
                    }
                }
            }
            return result;
        }
        return Collections.emptyList();
    }

	@Override
	protected void tearDownIncomingReferences(EObject destructee) {
		Collection<Setting> usages = getUsages(destructee);

		for(Setting setting : usages) {
			EReference eRef = (EReference)setting.getEStructuralFeature();
			if(eRef.isChangeable() && (eRef.isDerived() == false) && (eRef.isContainment() == false) && (eRef.isContainer() == false)) {
				EcoreUtil.remove(setting.getEObject(), eRef, destructee);
			}
		}
	}

	/**
	 * Gets the usages.
	 * 
	 * @param source
	 *        the source
	 * 
	 * @return the usages or null if there is no usages
	 */
	public static Collection<Setting> getUsages(EObject source) {
		if(source == null) {
			return Collections.emptyList();
		}

		ECrossReferenceAdapter crossReferencer = ECrossReferenceAdapter.getCrossReferenceAdapter(source);
		if (crossReferencer == null) {
			// try to register a cross referencer at the highest level
			crossReferencer = new ECrossReferenceAdapter();
			if (source.eResource() != null) {
				if (source.eResource().getResourceSet() != null) {
					crossReferencer.setTarget(source.eResource().getResourceSet());
				} else {
					crossReferencer.setTarget(source.eResource());
				}
			} else {
				crossReferencer.setTarget(source);
			}
		}

		return crossReferencer.getInverseReferences(source, true);
	}

}
