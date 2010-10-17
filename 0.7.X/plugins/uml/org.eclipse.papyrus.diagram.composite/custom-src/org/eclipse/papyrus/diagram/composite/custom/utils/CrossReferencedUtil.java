/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.diagram.composite.custom.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.emf.core.util.CrossReferenceAdapter;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

public class CrossReferencedUtil {

	/**
	 * Returns the {@link CrossReferenceAdapter} corresponding to an {@link EObject}
	 * 
	 * @param element
	 *        the {@link EObject} element
	 * @return
	 *         the {@link CrossReferenceAdapter} corresponding to element
	 */
	public static CrossReferenceAdapter getCrossReferenceAdapter(EObject element) {

		CrossReferenceAdapter crossReferenceAdapter = CrossReferenceAdapter.getExistingCrossReferenceAdapter(element);
		if(crossReferenceAdapter == null) {
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(element);
			if(domain != null) {
				crossReferenceAdapter = CrossReferenceAdapter.getCrossReferenceAdapter(domain.getResourceSet());
			}
		}

		return crossReferenceAdapter;
	}

	/**
	 * <pre>
	 * This method looks for any views in Composite Structure Diagram that are currently
	 * referencing the referencedObject.
	 * </pre>
	 * 
	 * @param referencedObject
	 * @param diagramType
	 *        type of diagram containing the list of {@link View}
	 * @return the list of {@link View} referencing the referencedObject
	 */
	public static List<View> getCrossReferencingViews(EObject referencedObject, String diagramType) {

		List<View> referencingObjects = new ArrayList<View>();

		CrossReferenceAdapter crossReferenceAdapter = CrossReferencedUtil.getCrossReferenceAdapter(referencedObject);
		if(crossReferenceAdapter != null) {

			// Retrieve all views referencing the referencedObject
			Iterator<?> views = crossReferenceAdapter.getInverseReferencers(referencedObject, NotationPackage.eINSTANCE.getView_Element(), NotationPackage.eINSTANCE.getView()).iterator();
			while(views.hasNext()) {

				View view = (View)views.next();
				// Check if current view is owned by a diagram which type conforms to diagramType
				if(diagramType.equals(view.getDiagram().getType())) {
					referencingObjects.add(view);
				}
			}
		}
		return referencingObjects;
	}
}
