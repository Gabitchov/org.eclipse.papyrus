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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.papyrus.newchild.Activator;
import org.eclipse.papyrus.newchild.ncpolicy.CustomPolicy;
import org.eclipse.papyrus.newchild.ncpolicy.FilterPolicy;
import org.eclipse.papyrus.newchild.ncpolicy.NewChildPolicy;
import org.eclipse.papyrus.newchild.ncpolicy.ReplacePolicy;


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
				try {
					return Class.forName(className).asSubclass(NewChildFillPolicy.class).newInstance();
				} catch (InstantiationException ex) {
					Activator.log.error(ex);
				} catch (IllegalAccessException ex) {
					Activator.log.error(ex);
				} catch (ClassNotFoundException ex) {
					Activator.log.error(ex);
				} catch (ClassCastException ex) {
					String message = "The CustomPolicy must implement " + NewChildFillPolicy.class.getName() + ". ";
					message += "Class : " + className;
					Activator.log.error(message, ex);
					Activator.log.error(ex);
				}
			}

			if(result != null) {
				result.setPolicy(policy);
			}

			return result;
		}
	}
}
