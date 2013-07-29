/*****************************************************************************
 * Copyright (c) 2011 AtoS.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (Atos) tristan.faure@atos.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.service.palette;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool;

/**
 * Annotation to apply to Aspect Actions which modify references
 * 
 * @author tristan.faure@atos.net
 * 
 */
public interface IFeatureSetterAspectAction {

	public EStructuralFeature[] getAllImpactedFeatures();

	public static class IFeatureSetterAspectActionUtil {
		/**
		 * Return all the impacted features for a given request the array of int
		 * represents the ids
		 * 
		 * @param request
		 * @return never null
		 */
		public static Set<EStructuralFeature> getAllImpactedFeatures(
				Request request) {
			return getAllImpactedFeatures(request.getExtendedData());
		}
		
		/**
		 * Return all the impacted Features from a map given by a request
		 * @param map
		 * @return the features impacted by an action
		 */
		public static Set<EStructuralFeature> getAllImpactedFeatures(
				Map map) {
			Set<EStructuralFeature> result = new HashSet<EStructuralFeature>();
			List<IAspectAction> aspectActions = AspectUnspecifiedTypeCreationTool
					.getAspectActions(map);
			if (aspectActions != null)
			{
				for (IAspectAction a : aspectActions)
				{
					if (a instanceof IFeatureSetterAspectAction) {
						IFeatureSetterAspectAction featureSetter = (IFeatureSetterAspectAction) a;
						result.addAll(Arrays.asList(featureSetter.getAllImpactedFeatures()));
					}
				}
			}
			return result;
		}
		
		/**
		 * Return all the impacted features in a {@link IEditCommandRequest} containing Pre and Post actions
		 * @param request
		 * @return
		 */
		public static Set<EStructuralFeature> getAllImpactedFeatures(
				IEditCommandRequest request) {
			return getAllImpactedFeatures(request.getParameters());
		}

		/**
		 * Determine if the features in parameters are managed by Pre/Post
		 * Action in the request
		 * @param request
		 * @param features
		 * @return true if they are ALL managed
		 */
		public static boolean areFeaturesManaged(Request request, EStructuralFeature... features)
		{
			return request != null && areFeaturesManaged(request.getExtendedData(), features);
		}
		
		/**
		 * Determine if the features in parameters are managed by Pre/Post
		 * Action in the request
		 * @param request
		 * @param features
		 * @return true if they are ALL managed
		 */
		public static boolean areFeaturesManaged(IEditCommandRequest request, EStructuralFeature features)
		{
			return request != null && areFeaturesManaged(request.getParameters(), features);
		}
		
		private static boolean areFeaturesManaged(Map map, EStructuralFeature... feature)
		{
			Set<EStructuralFeature> impacted = getAllImpactedFeatures(map);
			for (EStructuralFeature f : feature)
			{
				if (!impacted.contains(f))
				{
					return false ;
				}
			}
			return true ;
		}
		
	}

}
