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
package org.eclipse.papyrus.uml.table.efacet.common.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.plaf.TableUI;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.facet.efacet.core.IFacetSetCatalogManagerFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.papyrus.infra.table.efacet.common.utils.AdditionalContentsFacetSetUtils;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTableUtils;
import org.eclipse.papyrus.uml.profileefacet.generation.factory.ProfileEFacetGenericFactory;
import org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.ProfileFacetSet;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;

public class ProfileFacetSetProvider extends AbstractAdditionalContentsProvider {

	@Override
	public void setPapyrusTable(final PapyrusTable table) {
		super.setPapyrusTable(table);
	}

	@Override
	public Collection<FacetSet> getAdditionalFeatures() {
		final Set<Stereotype> appliedStereotypes = new HashSet<Stereotype>();
		for(final EObject current : this.tableContents) {
			if(current instanceof Element) {
				appliedStereotypes.addAll(((Element)current).getAppliedStereotypes());
			}
		}

		final Set<Profile> usedProfile = new HashSet<Profile>();
		for(final Stereotype current : appliedStereotypes) {
			usedProfile.add((Profile)PackageUtil.getRootPackage(current));
		}

		FacetSet additionalContentsFacetSet = null;
		lookForFacetSet: for(final EObject current : this.pTable.eResource().getContents()) {
			if(current instanceof FacetSet) {
				if(AdditionalContentsFacetSetUtils.ADDITIONAL_CONTENTS_FACET_SET_NS_URI.equals(((EPackage)current).getNsURI())) {
					additionalContentsFacetSet = (FacetSet)current;
					break lookForFacetSet;
				}
			}
		}

		final Map<String, ProfileFacetSet> mapProfileQNameFacetSet = new HashMap<String, ProfileFacetSet>();
		if(additionalContentsFacetSet != null) {
			final TreeIterator<EObject> iter = additionalContentsFacetSet.eAllContents();

			while(iter.hasNext()) {
				final EObject current = iter.next();
				if(current instanceof ProfileFacetSet) {
					mapProfileQNameFacetSet.put(((ProfileFacetSet)current).getProfileQualifiedName(), (ProfileFacetSet)current);
				}
			}
		}

		final List<FacetSet> additionalFacetSet = new ArrayList<FacetSet>();
		for(final Profile current : usedProfile) {
			final String profileQN = current.getQualifiedName();
			final XMIResource res = (XMIResource)current.eResource();
			final String profile_XMI_ID = res.getID(current);
			if(!mapProfileQNameFacetSet.containsKey(profileQN)) {//the profile is not known by the AdditionContentsFacetSet
				//we look for a registered profile FacetSet representation of this profile
				FacetSet registeredFacetSet = findRegisteredProfileFacetSet(profileQN, profile_XMI_ID);
				if(registeredFacetSet != null) {
					additionalFacetSet.add(registeredFacetSet);
				} else { //we generate a ProfileFacetSet for this profile
					final ProfileEFacetGenericFactory factory = new ProfileEFacetGenericFactory(current.eResource().getResourceSet());
					final ProfileFacetSet set = factory.createProfileFacetSet(current);
					if(set != null) {
						additionalFacetSet.add(set);
					}
				}
			}
		}

		return additionalFacetSet;
	}

	/**
	 * 
	 * @param rootProfileQualifiedName
	 *        the qualified name of the profile that we are looking for
	 * @param rootProfileXMI_ID
	 *        the XMI_ID of the profile that we are looking for
	 * @return
	 */
	protected ProfileFacetSet findRegisteredProfileFacetSet(final String rootProfileQualifiedName, final String rootProfileXMI_ID) {
		if(rootProfileQualifiedName != null && rootProfileXMI_ID != null) {
			final HashSet<FacetSet> availableFacetSets = new HashSet<FacetSet>();
			availableFacetSets.addAll(IFacetSetCatalogManagerFactory.DEFAULT.getOrCreateFacetSetCatalogManager(this.pTable.eResource().getResourceSet()).getRegisteredFacetSets());
			final Iterator<FacetSet> iter = availableFacetSets.iterator();
			while(iter.hasNext()) {
				final FacetSet current = iter.next();
				if(current instanceof ProfileFacetSet) {
					final ProfileFacetSet set = (ProfileFacetSet)current;
					if(rootProfileQualifiedName.equals(set.getProfileQualifiedName()) && rootProfileXMI_ID.equals(set.getRepresentedElement_XMI_ID())) {
						return set;
					}
				}
			}
		}
		return null;

	}


}
