/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;

/**
 * Utility class for Connector edit helpers.
 */
public class ConnectorUtils {

	/**
	 * Tries to find a common structure container view for source and target.
	 * 
	 * @param source
	 *        the source view
	 * @param target
	 *        the target view
	 * @return the least common structure container view
	 */
	public View deduceViewContainer(View source, View target) {

		List<View> sourceProposedContainers = getStructureContainers(source);
		List<View> targetProposedContainers = getStructureContainers(target);

		// The deduced container is the StructuredClassifier related to the least
		// common containing View.
		View deducedContainer = null;
		for(View container : sourceProposedContainers) {
			if(targetProposedContainers.contains(container)) {
				deducedContainer = container;
				break;
			}
		}

		return deducedContainer;
	}
	
	public Property getPartWithPort(View checkedView, View oppositeView) {
		Property result = null;
		EObject targetPort = checkedView.getElement();
		if(targetPort instanceof Port) {
			// Only look for PartWithPort if the role is a Port.

			View parentView = ViewUtil.getContainerView(checkedView);
			EObject semanticParent = parentView.getElement();
			if((semanticParent instanceof Property) && !(semanticParent instanceof Port)) {
				// Only add PartWithPort for assembly (not for delegation)
				if(!EcoreUtil.isAncestor(parentView, oppositeView)) {
					result = (Property)semanticParent;
				}
			}

		}

		return result;
	}
	

	/**
	 * Tries to find a common StructuredClassifier container to add the new Connector.
	 * 
	 * @param source
	 *        the source graphical view
	 * @param target
	 *        the target graphical view
	 * @return a common StructuredClassifier container (graphical search through views)
	 */
	public StructuredClassifier deduceContainer(View source, View target) {
		return (deduceViewContainer(source, target) != null) ? getStructuredClassifier(deduceViewContainer(source, target)) : null;
	}

	/**
	 * Collect container hierarchy for a view (including itself and keeping containment order).
	 * 
	 * @param view
	 *        the graphical view
	 * @return the list of containing Views.
	 */
	public List<View> getStructureContainers(View view) {

		List<View> containerViews = new ArrayList<View>();
		
		for(View currentView = view; currentView != null; currentView = ViewUtil.getContainerView(currentView)) {
			if((currentView instanceof Shape) && (getStructuredClassifier(currentView) != null)) {
				containerViews.add(currentView);
			}
		}

		return containerViews;
	}

	/**
	 * Get the {@link StructuredClassifier} related to a View.
	 * If the view relates to a Property, returns its type in case it is a StructuredClassifier.
	 * 
	 * @param view
	 *        the graphical view
	 * @return the related {@link StructuredClassifier}
	 */
	public StructuredClassifier getStructuredClassifier(View view) {

		StructuredClassifier structuredClassifier = null;

		EObject semanticElement = view.getElement();
		if(semanticElement instanceof StructuredClassifier) {
			structuredClassifier = (StructuredClassifier)semanticElement;

		} else if(semanticElement instanceof Property) {
			Property property = (Property)semanticElement;
			if((property.getType() != null) && (property.getType() instanceof StructuredClassifier)) {
				structuredClassifier = (StructuredClassifier)property.getType();
			}

		} // else return null


		return structuredClassifier;
	}
	
	public ConnectorEnd getSourceConnectorEnd(Connector connector) {
		return connector.getEnds().get(0);
	}
	
	public ConnectorEnd getTargetConnectorEnd(Connector connector) {
		return connector.getEnds().get(1);
	}
}
