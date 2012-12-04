/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
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
package org.eclipse.papyrus.infra.table.common.util;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.notation.NotationModel;
import org.eclipse.papyrus.infra.table.common.messages.Messages;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;



/**
 * 
 * This class provides utilities for the AdditionalContentsFacetSet.
 * This facetset is used to provide additional contents for table EFacet (Currently,
 * this main job is to provide FacetSet to edit easily the properties of the stereotypes into a table
 * 
 */
public class AdditionalContentsUtils {

	private AdditionalContentsUtils() {
		//to prevent instanciation
	}

	public static final String ADDITIONAL_CONTENTS_EPCKAGE_NAME = "AdditionalContentsForTable"; //$NON-NLS-1$

	public static final String ADDITIONAL_CONTENTS_EPACKAGE_NS_URI = "http://www.eclipse.org/papyrustable/additionalcontentsepackage"; //$NON-NLS-1$

	public static final String ADDITIONAL_CONTENTS_EPACKAGE_PREFIX = "additionalcontentsepackage"; //$NON-NLS-1$

	public static final String ADDITIONAL_CONTENTS_FACET_SET_DOCUMENTATION = Messages.AdditionalContentsUtils_AdditionContentsEPackageDocumentation;

	public static final String ADDITIONAL_CONTENTS_QUERY_SET_NAME = "AdditionalContentsModelQuerySetForTable"; //$NON-NLS-1$

	public static EPackage createAdditionalContentsEPackage() {
		final EPackage additionFeatureRootFacetSet = EcoreFactory.eINSTANCE.createEPackage();
		additionFeatureRootFacetSet.setName(AdditionalContentsUtils.ADDITIONAL_CONTENTS_EPCKAGE_NAME);
		additionFeatureRootFacetSet.setNsPrefix(AdditionalContentsUtils.ADDITIONAL_CONTENTS_EPACKAGE_PREFIX);
		additionFeatureRootFacetSet.setNsURI(AdditionalContentsUtils.ADDITIONAL_CONTENTS_EPACKAGE_NS_URI);
		return additionFeatureRootFacetSet;
	}

	public static EPackage getAdditionalContentsEPackage(final PapyrusTableInstance table) {
		EPackage ePackage = null;
		final ModelSet modelSet = (ModelSet)table.eResource().getResourceSet();
		final Resource resource = modelSet.getAssociatedResource(table.eResource(), NotationModel.NOTATION_FILE_EXTENSION);
		final Iterator<EObject> iter = resource.getContents().iterator();
		while(iter.hasNext() && ePackage == null) {
			final EObject current = iter.next();
			if(current instanceof EPackage) {
				final EPackage tmp = (EPackage)current;
				if(AdditionalContentsUtils.ADDITIONAL_CONTENTS_EPACKAGE_NS_URI.equals(tmp.getNsURI())) {
					ePackage = tmp;
				}
			}
		}

		return ePackage;
	}

	/**
	 * 
	 * @param source
	 *        a resource
	 * @return
	 *         return the EPackage with the uri {@link #ADDITIONAL_CONTENTS_FACET_SET_NS_URI} in the resource or <code>null</code> if not found
	 */
	public static EPackage getAdditionalContentsEPackage(final Resource source) {
		if(source != null) {
			EPackage additionalSet = null;
			Iterator<EObject> iter = source.getContents().iterator();
			while(iter.hasNext() && additionalSet == null) {
				final EObject contents = iter.next();
				if(contents instanceof EPackage && AdditionalContentsUtils.ADDITIONAL_CONTENTS_EPACKAGE_NS_URI.equals(((EPackage)contents).getNsURI())) {
					additionalSet = (EPackage)contents;
				}
			}
			return additionalSet;
		}
		return null;
	}
}
