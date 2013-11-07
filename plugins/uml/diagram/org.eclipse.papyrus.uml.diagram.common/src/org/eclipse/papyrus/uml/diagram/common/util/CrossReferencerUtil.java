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
package org.eclipse.papyrus.uml.diagram.common.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.emf.core.util.CrossReferenceAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

public class CrossReferencerUtil {

	/**
	 * Returns the {@link CrossReferenceAdapter} corresponding to an {@link EObject}
	 * 
	 * @param element
	 *        the {@link EObject} element
	 * @return the {@link CrossReferenceAdapter} corresponding to element
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
	 * This method looks for any views (possibly filtered by a kind of diagram) that are currently
	 * referencing the referencedObject.
	 * </pre>
	 * 
	 * @param referencedObject
	 * @param diagramType
	 *        type of diagram containing the list of {@link View} (may be
	 *        null)
	 * @return the list of {@link View} referencing the referencedObject
	 */
	public static Set<View> getCrossReferencingViews(EObject referencedObject, String diagramType) {

		Set<View> referencingObjects = new HashSet<View>();

		CrossReferenceAdapter crossReferenceAdapter = CrossReferencerUtil.getCrossReferenceAdapter(referencedObject);
		if(crossReferenceAdapter != null) {

			// Retrieve all views referencing the referencedObject
			Iterator<?> views = crossReferenceAdapter.getInverseReferencers(referencedObject, NotationPackage.eINSTANCE.getView_Element(), NotationPackage.eINSTANCE.getView()).iterator();
			while(views.hasNext()) {

				View view = (View)views.next();
				if(diagramType != null) { // Filter to get only view from this
											// kind of diagram

					// Check if current view is owned by a diagram which type
					// conforms to diagramType
					if(diagramType.equals(view.getDiagram().getType())) {
						referencingObjects.add(view);
					}

				} else { // Return all views
					referencingObjects.add(view);
				}
			}
		}
		return referencingObjects;
	}

	/**
	 * <pre>
	 * This method looks for any views (possibly filtered by a kind of diagram) that are currently
	 * referencing the referencedObject.
	 * </pre>
	 * 
	 * @param referencedObject
	 * @param diagram
	 *        diagram instance containing the list of {@link View} (may be
	 *        null)
	 * @return the list of {@link View} referencing the referencedObject
	 */
	public static Set<View> getCrossReferencingViews(final EObject referencedObject, final Diagram diagram) {

		Set<View> referencingObjects = new HashSet<View>();

		CrossReferenceAdapter crossReferenceAdapter = CrossReferencerUtil.getCrossReferenceAdapter(referencedObject);
		if(crossReferenceAdapter != null) {

			// Retrieve all views referencing the referencedObject
			Iterator<?> views = crossReferenceAdapter.getInverseReferencers(referencedObject, NotationPackage.eINSTANCE.getView_Element(), NotationPackage.eINSTANCE.getView()).iterator();
			while(views.hasNext()) {

				View view = (View)views.next();
				if(diagram != null) { // Filter to get only view from this
										// kind of diagram

					// Check if current view is owned by a diagram which type
					// conforms to diagramType
					if(diagram == view.getDiagram()) {
						referencingObjects.add(view);
					}

				} else { // Return all views
					referencingObjects.add(view);
				}
			}
		}
		return referencingObjects;
	}
}
