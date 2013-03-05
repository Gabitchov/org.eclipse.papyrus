/*****************************************************************************
 * Copyright (c) 2012, 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - Don't assume that profiles are in XMI resources (CDO)
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profilefacet.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.uml.profilefacet.messages.Messages;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetSet;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypeFacet;
import org.eclipse.uml2.uml.Profile;



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

	public static final String ADDITIONAL_CONTENTS_FACET_SET_DOCUMENTATION = Messages.AdditionalContentsUtils_ProfileEFacetDescription;

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

	/**
	 * 
	 * @param resourceSet
	 *        a resource set
	 * @return all ProfileFacetSet owned by the resource setassuming that :
	 *         <ul>
	 *         <li>the ProfileFacetSet are stored as root of the resource</li>
	 *         <li>the ProfileFacetSet are stored in the notation file</li>
	 *         </ul>
	 */
	public static final Collection<ProfileFacetSet> getAllProfileFacetSets(final ResourceSet resourceSet) {
		final Collection<ProfileFacetSet> facetSets = new HashSet<ProfileFacetSet>();
		final TransactionalEditingDomain domain = (TransactionalEditingDomain)EMFHelper.resolveEditingDomain(resourceSet);

		for(final Resource current : resourceSet.getResources()) {
			//we assume that all ProfileFacetSet are stored into notation files
			if(NotationModel.NOTATION_FILE_EXTENSION.equals(current.getURI().fileExtension()) && !domain.isReadOnly(current)) {
				final EPackage additionalContentsEPackage = getAdditionalContentsEPackage(current);
				if(additionalContentsEPackage != null) {
					for(final EPackage currentEPackage : additionalContentsEPackage.getESubpackages()) {
						if(currentEPackage instanceof ProfileFacetSet) {
							facetSets.add((ProfileFacetSet)currentEPackage);
						}
					}
				}
			}
		}
		return facetSets;
	}

	/**
	 * 
	 * @param profile
	 *        a profile
	 * @return
	 *         the list of the existing {@link ProfileFacetSet} for this profile.
	 *         This is a collection, because in case of a model splitted in several file, we could have several representation for the same profile
	 */
	public static final Collection<ProfileFacetSet> getAllFacetSet(final Profile profile) {
		final String profileID = profile.eResource().getURIFragment(profile);

		final Collection<ProfileFacetSet> facetSets = new HashSet<ProfileFacetSet>();
		final ResourceSet resourceSet = profile.eResource().getResourceSet();

		final Collection<ProfileFacetSet> allExistingFacetSets = getAllProfileFacetSets(resourceSet);
		for(final ProfileFacetSet current : allExistingFacetSets) {
			if(profileID.equals(((ProfileFacetSet)current).getRepresentedElement_XMI_ID())) {
				facetSets.add(current);
			}
		}
		return facetSets;
	}

	/**
	 * 
	 * @param profileFacetSet
	 *        a profile facet set
	 * @return
	 *         the list all {@link StereotypeFacet} owned by this {@link ProfileFacetSet} and its sub - {@link ProfileFacetSet}
	 */
	public static final Collection<StereotypeFacet> getAllStereotypeFacets(final ProfileFacetSet profileFacetSet) {
		final Collection<StereotypeFacet> facets = new HashSet<StereotypeFacet>();
		for(final ProfileFacetSet current : profileFacetSet.getSubProfileFacetSet()) {
			facets.addAll(getAllStereotypeFacets(current));
		}
		facets.addAll(profileFacetSet.getStereotypeFacets());
		return facets;
	}

	/**
	 * 
	 * @param resourceSet
	 *        a resourceset
	 * @return
	 *         <code>true</code> if there is not several ProfileFacetSet representing Profile with the same ID in the same resource.
	 *         That is to say that we can have seral ProfileFacetSet representing Profile with the same id owned by differents resources!
	 */
	public static final boolean areAllFacetSetUniqueByResource(final ResourceSet resourceSet) {
		final Map<String, Collection<Resource>> XMI_ID_Resource = new HashMap<String, Collection<Resource>>();
		final Collection<ProfileFacetSet> allExistingProfileFacetSet = getAllProfileFacetSets(resourceSet);
		for(ProfileFacetSet profileFacetSet : allExistingProfileFacetSet) {
			final String id = profileFacetSet.getRepresentedElement_XMI_ID();
			if(XMI_ID_Resource.containsKey(id)) {
				if(XMI_ID_Resource.get(id).contains(profileFacetSet.eResource())) {
					return false;
				}
			} else {
				Collection<Resource> res = new ArrayList<Resource>();
				XMI_ID_Resource.put(id, res);
			}
			XMI_ID_Resource.get(id).add(profileFacetSet.eResource());
		}
		return true;
	}

	/**
	 * 
	 * @param profile
	 *        a profile
	 * @param additionalResourceEPackage
	 *        an epackage
	 * @return
	 *         the {@link ProfileFacetSet} for this profile if it is owned by the epackage or <code>null</code> if not found
	 */
	public static final ProfileFacetSet findProfileFacetSet(final Profile profile, final EPackage additionalResourceEPackage) {
		final XMIResource resource = (XMIResource)profile.eResource();
		final String profileID = resource.getID(profile);
		for(final EPackage current : additionalResourceEPackage.getESubpackages()) {
			if(current instanceof ProfileFacetSet) {
				if(profileID.equals(((ProfileFacetSet)current).getRepresentedElement_XMI_ID())) {
					return (ProfileFacetSet)current;
				}
			}
		}
		return null;
	}
}
