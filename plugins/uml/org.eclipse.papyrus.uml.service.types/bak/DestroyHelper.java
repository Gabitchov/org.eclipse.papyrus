/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.helper;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.DestroyElementPapyrusCommand;

/**
 * Helper class containing the specific behavior for drag and drop of Connector
 */
public class DestroyHelper extends ElementHelper {

	/**
	 * Constructor
	 * 
	 * @param editDomain
	 *        the editing domain
	 */
	public DestroyHelper(TransactionalEditingDomain editDomain) {
		super();
		this.editDomain = editDomain;
	}

	public CompositeCommand getDestroyElementCommand(DestroyElementRequest req) {
		CompositeCommand cc = new CompositeCommand("Destroy...");
		cc.add(getDeleteSemanticChildCommand(req));
		cc.add(getDeleteRelatedViewCommand(req));
		cc.add(getDeleteIndirectRelatedViewCommand(req));
		cc.add(new DestroyElementPapyrusCommand(req));
		return cc;
	}

	protected ICommand getDeleteSemanticChildCommand(DestroyElementRequest req) {
		CompositeCommand cc = new CompositeCommand("Destroy...");

		// Parse semantic children
		EObject elt = req.getElementToDestroy();
		Iterator<EObject> it = elt.eContents().iterator();
		while(it.hasNext()) {
			EObject child = it.next();

			DestroyElementRequest reqDelChild = new DestroyElementRequest(getEditingDomain(), child, false);
			cc.add(getDestroyElementCommand(reqDelChild));
		}

		return cc;
	}

	protected ICommand getDeleteRelatedViewCommand(DestroyElementRequest req) {
		CompositeCommand cc = new CompositeCommand("Destroy...");

		EObject element = req.getElementToDestroy();
		ECrossReferenceAdapter crossReferencer = ECrossReferenceAdapter.getCrossReferenceAdapter(element);

		if(crossReferencer != null) {
			Collection<Setting> inverseReferences = crossReferencer.getInverseReferences(element);
			if(inverseReferences != null) {
				for(Setting setting : inverseReferences) {
					EReference eRef = (EReference)setting.getEStructuralFeature();
					if(eRef.isChangeable() && (eRef.isDerived() == false) && (eRef.isContainment() == false) && (eRef.isContainer() == false)) {

						EObject eo = setting.getEObject();
						if(setting.getEObject() instanceof View) {
							cc.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), (View)setting.getEObject()));
						}
					}
				}
			}
		}

		return cc;
	}

	protected ICommand getDeleteIndirectRelatedViewCommand(DestroyElementRequest req) {
		CompositeCommand cc = new CompositeCommand("Destroy...");

		//		EObject element = req.getElementToDestroy();
		//		ECrossReferenceAdapter crossReferencer = ECrossReferenceAdapter.getCrossReferenceAdapter(element);
		//
		//		if(crossReferencer != null) {
		//			Collection<Setting> inverseReferences = crossReferencer.getInverseReferences(element);
		//			if(inverseReferences != null) {
		//				for(Setting setting : inverseReferences) {
		//					EReference eRef = (EReference)setting.getEStructuralFeature();
		//					if(eRef.isChangeable() && (eRef.isDerived() == false) && (eRef.isContainment() == false) && (eRef.isContainer() == false)) {
		//
		//						EObject eo = setting.getEObject();
		//						if(setting.getEObject() instanceof View) {
		//							cc.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), (View)setting.getEObject()));
		//						}
		//					}
		//				}
		//			}
		//		}

		return cc;
	}
}
