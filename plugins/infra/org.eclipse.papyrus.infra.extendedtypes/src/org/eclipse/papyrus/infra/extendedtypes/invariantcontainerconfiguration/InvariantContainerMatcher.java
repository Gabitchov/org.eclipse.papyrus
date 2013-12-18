/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.IConfigurableElementMatcher;

/**
 * Matcher of the hierarchy matcher
 */
public class InvariantContainerMatcher implements IConfigurableElementMatcher<InvariantContainerConfiguration> {

	protected EList<HierarchyPermission> permissions;

	/**
	 * 
	 */
	public InvariantContainerMatcher() {
		// nothing here. Trying not to create list to avoid unnecessary created objects
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EObject eObject) {
		return true;
//		boolean matches = false;
//		
//		EObject container = eObject.eContainer(); 
//		
//		if(container ==null) {
//			return false;
//		}
//		
//		matches = checkAllowed(container, allowedDirectParents, false);
//		
//		// if not ok in direct parents, test in the hierarchy
//		if(!matches && allowedParentsInHierarchy!=null && !allowedParentsInHierarchy.isEmpty()) {
//			while(!matches && container.eContainer() !=null) {
//				container = container.eContainer();
//				matches = checkAllowed(container, allowedParentsInHierarchy, false);
//			}
//		}
//
//		// check now that some forbidden type does not override the current matches
//		if(!matches) {
//			return false;
//		}
//		
//		container = eObject.eContainer();
//		// container (direct or indirect) could match. now try the forbidden lists
//		matches = checkForbidden(container, forbiddenDirectParents, false);
//		
//		// if not ok in direct parents, test in the hierarchy
//		if(matches && forbiddenParentsInHierarchy!=null && !forbiddenParentsInHierarchy.isEmpty()) {
//			while(matches && container.eContainer() !=null) {
//				container = container.eContainer();
//				matches = checkForbidden(container, forbiddenParentsInHierarchy, false);
//			}
//		}
//
//		return matches;
	}

	/**
	 * @param container
	 * @param forbiddenParentsInHierarchy2
	 * @param b
	 * @return
	 */
	protected boolean checkForbidden(EObject container, List<String> forbiddenParents, boolean isStrict) {
		// check direct permissions
		if(forbiddenParents != null && !forbiddenParents.isEmpty()) {
			IElementType parentType = ElementTypeRegistry.getInstance().getElementType(container);
			if(parentType != null) {
				// check if necessary all super types of the direct parent
				List<String> parentIds = new ArrayList<String>();
				parentIds.add(parentType.getId());
				if(forbiddenParents.contains(parentIds)) {
					return false;
				} else {
					// check also super types ids, if not strict permission
					if(!isStrict) {
						for(IElementType superType : parentType.getAllSuperTypes()) {
							if(forbiddenParents.contains(superType.getId())) {
								return false;
							}
						}	
					}
				}
			}
		}
		return true;
	}

	/**
	 * 
	 */
	protected boolean checkAllowed(EObject container, List<String> allowedParents, boolean isStrict) {
		boolean matches = false;
		// check direct permissions
		if(allowedParents != null && !allowedParents.isEmpty()) {
			IElementType parentType = ElementTypeRegistry.getInstance().getElementType(container);
			if(parentType != null) {
				// check if necessary all super types of the direct parent
				List<String> parentIds = new ArrayList<String>();
				parentIds.add(parentType.getId());
				if(allowedParents.contains(parentIds)) {
					matches = true;
				} else {
					// check also super types ids, if not strict permission
					if(!isStrict) {
						for(IElementType superType : parentType.getAllSuperTypes()) {
							if(allowedParents.contains(superType.getId())) {
								matches = true;
								break;
							}
						}	
					}
				}
			}
		}
		return matches;
	}

	/**
	 * {@inheritDoc}
	 */
	public void init(InvariantContainerConfiguration configuration) {
		this.permissions = configuration.getPermissions();
	}
}
