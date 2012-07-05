/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.ui.internal.utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.ui.ModelCompareInput;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;


/**
 * 
 * This class provides useful methods for the papyrus Viewer for EMF-Compare
 * 
 */
public class EMFCompareUIUtils {

	private EMFCompareUIUtils() {
		//nothing to do
	}

	/**
	 * 
	 * @param input
	 *        an input
	 * @param metamodels
	 *        the list of the referenced metamodels
	 * @return
	 *         if the parameter metamodels is <code>null</code>, this method initializes it
	 *         it returns the parameter metamodels filled with the metamodels referenced by the compared model
	 */
	public static final Collection<EPackage> getMetamodelForCustomization(final Object input, Collection<EPackage> metamodels) {
		if(metamodels == null) {
			metamodels = new HashSet<EPackage>();
		}
		if(input != null && input instanceof ModelCompareInput) {
			Resource res = ((ModelCompareInput)input).getLeftResource();
			metamodels.addAll(EMFHelper.getMetamodels(res));
			res = ((ModelCompareInput)input).getRightResource();
			metamodels.addAll(EMFHelper.getMetamodels(res));

			//we returns the applicable customizations on DiffElement too
			final List<DiffElement> diffs = ((ModelCompareInput)input).getDiffAsList();
			for(DiffElement current : diffs) {
				metamodels.add(current.eClass().getEPackage());
			}
		}
		return metamodels;
	}

	/**
	 * 
	 * @param input
	 *        an input
	 * @param metamodels
	 *        the list of the referenced metamodels
	 * @return
	 *         if the parameter metamodels is <code>null</code>, this method initializes it
	 *         it returns the parameter metamodels filled with the metamodels referenced by the diff element
	 */
	//TODO not used, we display the all applicable customization for the 2 viewers see bug 384358: [UML Compare] problems with customizations applied on the viewers
	@Deprecated //deprecated since July 2012
	public static final Collection<EPackage> getMetamodelForDiffCustomization(final Object input, Collection<EPackage> metamodels) {
		if(metamodels == null) {
			metamodels = new HashSet<EPackage>();
		}
		if(input != null && input instanceof ModelCompareInput) {
			List<DiffElement> diffs = ((ModelCompareInput)input).getDiffAsList();
			for(DiffElement current : diffs) {
				metamodels.add(current.eClass().getEPackage());
			}
		}
		return metamodels;
	}


}
