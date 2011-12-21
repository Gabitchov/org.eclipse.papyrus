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
package org.eclipse.papyrus.infra.emf.newchild.policies;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.papyrus.infra.emf.newchild.ncpolicy.CustomPolicy;
import org.eclipse.papyrus.infra.emf.newchild.ncpolicy.FilterPolicy;
import org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NewChildPolicy;
import org.eclipse.papyrus.infra.emf.newchild.ncpolicy.ReplacePolicy;
import org.eclipse.papyrus.infra.tools.util.ClassLoaderHelper;


public interface NewChildFillPolicy {

	public void setPolicy(NewChildPolicy policy);

	public Collection<EClass> getEClasses();

	public Collection<String> getRoles();

	public void fill(IMenuManager manager, EObject parentEObject, EClass eClass, EStructuralFeature role, EObject selectedEObject);

	public class Factory {

		public static Factory instance = new Factory();

		private Factory() {
		}

		public NewChildFillPolicy getPolicy(NewChildPolicy policy) {
			NewChildFillPolicy result = null;
			if(policy instanceof ReplacePolicy) {
				result = new ReplaceFillPolicy();
			} else if(policy instanceof FilterPolicy) {
				result = new FilterFillPolicy();
			} else if(policy instanceof CustomPolicy) {
				String className = ((CustomPolicy)policy).getClassName();
				return ClassLoaderHelper.newInstance(className, NewChildFillPolicy.class);
			}

			if(result != null) {
				result.setPolicy(policy);
			}

			return result;
		}
	}
}
