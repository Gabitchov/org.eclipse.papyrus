/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.newchild.policies;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.newchild.ncpolicy.NewChildPolicy;
import org.eclipse.papyrus.newchild.ncpolicy.NewChildPolicySet;
import org.eclipse.papyrus.newchild.util.EMFHelper;


public class PolicyMatcher {

	private List<NewChildFillPolicy> fillPolicies;

	public void setPolicies(Collection<NewChildPolicySet> policySets) {
		this.fillPolicies = new LinkedList<NewChildFillPolicy>();
		for(NewChildPolicySet policySet : policySets) {
			for(NewChildPolicy policy : policySet.getPolicies()) {
				NewChildFillPolicy fillPolicy = NewChildFillPolicy.Factory.instance.getPolicy(policy);
				fillPolicies.add(fillPolicy);
			}
		}
	}

	public List<NewChildFillPolicy> getMatchingPolicies(EClass eClass, EStructuralFeature role){
		List<NewChildFillPolicy> matchedPolicies = new LinkedList<NewChildFillPolicy>();

		for (NewChildFillPolicy policy : fillPolicies){
			if(matches(policy, eClass, role)) {
				matchedPolicies.add(policy);
			}
		}

		return matchedPolicies;
	}

	private boolean matches(NewChildFillPolicy policy, EClass eClass, EStructuralFeature role) {
		Collection<EClass> eClasses = policy.getEClasses();
		Collection<String> roles = policy.getRoles();

		if(eClasses.isEmpty() && roles.isEmpty()) {
			return true;
		}

		if(roles.contains(role.getName()) && (eClasses.isEmpty() || isContained(eClass, eClasses))) {
			return true;
		}

		if((roles.isEmpty() || roles.contains(role)) && isContained(eClass, eClasses)) {
			return true;
		}

		return false;
	}

	private boolean isContained(EClass eClass, Collection<EClass> eClasses) {
		for(EClass classToCheck : eClasses) {
			if(EMFHelper.isSubclass(eClass, classToCheck)) {
				return true;
			}
		}
		return false;
	}
}
