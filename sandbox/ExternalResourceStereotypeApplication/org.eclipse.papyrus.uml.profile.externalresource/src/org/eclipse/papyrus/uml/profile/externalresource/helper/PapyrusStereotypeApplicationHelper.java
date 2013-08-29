/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.externalresource.helper;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.util.UMLUtil.StereotypeApplicationHelper;


/**
 * Specific Stereotype Application Helper for Papyrus tool. If it detects the model is not a model handled by Papyrus, it will delegate to the standard Stereotype application helper.
 */
public class PapyrusStereotypeApplicationHelper extends StereotypeApplicationHelper {
	
	/** Key for the location strategy value  */
	public static final String LOCATION_STRATEGY_KEY = "locationStrategy";
	
	/** source for the eannotation that is used to store specific URI for stereotype application resource */
	public static final String PAPYRUS_EXTERNAL_RESOURCE_EANNOTATION_SOURCE = "http://www.eclipse.org/papyrus/uml/profile/externalresource"; //$NON-NLS-1$
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public EObject applyStereotype(Element element, EClass definition) {
		return super.applyStereotype(element, definition);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addToContainmentList(Element element, EObject stereotypeApplication) {
		return super.addToContainmentList(element, stereotypeApplication);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected EList<EObject> getContainmentList(Element element, EClass definition) {
		// 1. find the current strategy used for the model element
		// 2. use the strategy to find the resource and the containment list
		// 3. if no strategy found, return usual strategy ==> stereotype application are directly contained by the resource containing the stereotyped element.
		IStereotypeApplicationLocationStrategy locationStrategy = getCurrentLocationStrategy(element);
		if(locationStrategy ==null) {
			return StandardApplicationLocationStrategy.getInstance().getContainmentList(element, definition);
		} 
		return locationStrategy.getContainmentList(element, definition);
	}

	/**
	 * Returns the specific location strategy to use for the given model element
	 * @param element the stereotyped element
	 * @return the location strategy or the standard one if none was found
	 */
	public static IStereotypeApplicationLocationStrategy getCurrentLocationStrategy(EObject element) {
		EObject container = EcoreUtil.getRootContainer(element, true);
		if(container instanceof Element) {
			EAnnotation annotation = ((Element)container).getEAnnotation(PAPYRUS_EXTERNAL_RESOURCE_EANNOTATION_SOURCE);
			if(annotation == null) {
				return StrategyRegistry.getInstance().getStrategy(StandardApplicationLocationStrategy.ID);
			}
			
			String location = annotation.getDetails().get(LOCATION_STRATEGY_KEY);
			if(location == null) {
				return StrategyRegistry.getInstance().getStrategy(StandardApplicationLocationStrategy.ID);
			}
			
			IStereotypeApplicationLocationStrategy strategy = StrategyRegistry.getInstance().getStrategy(location);
			if(strategy != null) {
				return strategy;
			}
		}
		return StrategyRegistry.getInstance().getStrategy(StandardApplicationLocationStrategy.ID);
	}
	
	/**
	 * Sets the specific location strategy to use for the given model element
	 * Warning: this method modifies the model, it should be executed in a command. 
	 * @param element the stereotyped element
	 * @return the location strategy or <code>null</code> if none was found
	 */
	public static void setCurrentLocationStrategy(EObject element, IStereotypeApplicationLocationStrategy newStrategy) {
		EObject container = EcoreUtil.getRootContainer(element, true);
		if(container instanceof Element) {
			EAnnotation annotation = ((Element)container).getEAnnotation(PAPYRUS_EXTERNAL_RESOURCE_EANNOTATION_SOURCE);
			if(annotation == null) {
				// create a new one
				annotation = ((Element)container).createEAnnotation(PAPYRUS_EXTERNAL_RESOURCE_EANNOTATION_SOURCE);
			}
			// update or create
			annotation.getDetails().put(LOCATION_STRATEGY_KEY, newStrategy.getIdentifier());
		}
	}
	
}
