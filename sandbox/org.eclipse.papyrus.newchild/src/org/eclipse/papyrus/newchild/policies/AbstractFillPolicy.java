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
import java.util.HashSet;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.newchild.ncpolicy.NewChildPolicy;


public abstract class AbstractFillPolicy implements NewChildFillPolicy {

	protected NewChildPolicy policy;

	protected Collection<EClass> eClasses;

	public Collection<EClass> getEClasses() {
		if(eClasses == null) {
			eClasses = new HashSet<EClass>();
			for(EClass eClass : policy.getEClasses()) {
				EPackage staticPackage = EPackage.Registry.INSTANCE.getEPackage(eClass.getEPackage().getNsURI());
				eClass = (EClass)staticPackage.getEClassifier(eClass.getName());
				eClasses.add(eClass);
			}
		}
		return eClasses;
	}

	public Collection<String> getRoles() {
		return policy.getRoles();
	}

	public void setPolicy(NewChildPolicy policy) {
		this.policy = policy;
	}

}
