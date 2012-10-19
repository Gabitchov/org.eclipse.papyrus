package org.eclipse.papyrus.infra.table.efacet.menu.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.ProfileFacetSet;
import org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.StereotypeFacet;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;

public class StereotypeManagement {

	public StereotypeManagement() {

	}


	public List<FacetSet> getAdditionalFeatures(final PapyrusTable papyrusTable, final Collection<EObject> tableContents, final Collection<FacetSet> existingFacetSets) {
		final Set<Stereotype> appliedStereotypes = new HashSet<Stereotype>();
		for(final EObject current : tableContents) {
			if(current instanceof Element) {
				appliedStereotypes.addAll(((Element)current).getAppliedStereotypes());
			}
		}

		final Set<Profile> usedProfile = new HashSet<Profile>();
		for(final Stereotype current : appliedStereotypes) {
			usedProfile.add((Profile)PackageUtil.getRootPackage(current));
		}

		//TODO provides a way to register facetset representing static profile

		//TODO verify that an existing FacetSet doesn't exist for it
		final String wantedURI = "http://www.eclipse.org/papyrustableefacet/additionalcontentsfacetset";
		FacetSet additionalContentsFacetSet = null;
		lookForFacetSet : for(EObject current : papyrusTable.eResource().getContents()) {
			if(current instanceof FacetSet) {
				if(wantedURI.equals(((EPackage)current).getNsURI())) {
					additionalContentsFacetSet = (FacetSet)current;
					break lookForFacetSet;
				}
			}
		}

		Map<String, ProfileFacetSet> mapProfileQNameFacetSet = new HashMap<String, ProfileFacetSet>();
		if(additionalContentsFacetSet != null) {
			final TreeIterator<EObject> iter = additionalContentsFacetSet.eAllContents();

			while(iter.hasNext()) {
				final EObject current = iter.next();
				if(current instanceof ProfileFacetSet) {
					mapProfileQNameFacetSet.put(((ProfileFacetSet)current).getProfileQualifiedName(), (ProfileFacetSet)current);
				} else if(current instanceof StereotypeFacet) {

				}
			}
		}
		final List<FacetSet> addtionalFacetSet = new ArrayList<FacetSet>();
		for(final Profile current : usedProfile) {
			if(!mapProfileQNameFacetSet.containsKey(current.getQualifiedName())) {
				ProfileFacetSet set = FacetFactory.createProfileFacetSet(current);
				if(set != null) {
					addtionalFacetSet.add(set);
				}
			}
		}

		return addtionalFacetSet;
	}
}
