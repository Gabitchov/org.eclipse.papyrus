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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.extendedtypes.Activator;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.IInvariantContainerDescriptor;
import org.eclipse.papyrus.infra.services.edit.internal.context.TypeContext;

/**
 * @author RS211865
 */
public class InvariantContainerConfigurationContainerDescriptor implements IInvariantContainerDescriptor<InvariantContainerConfiguration> {

	protected EList<HierarchyPermission> permissions;

	private IClientContext sharedContext;

	private IElementMatcher matcher;

	/**
	 * {@inheritDoc}
	 */
	public IElementMatcher getMatcher() {
		if(matcher == null) {
			matcher = createMatcher();
		}
		return matcher;
	}

	/**
	 * @return
	 */
	protected IElementMatcher createMatcher() {
		return new IElementMatcher() {

			public boolean matches(EObject eObject) {
				
				IElementType[] types = ElementTypeRegistry.getInstance().getAllTypesMatching(eObject, sharedContext);
				if(types == null || types.length == 0) {
					return false;
				}
				boolean isValid = false;
				for(HierarchyPermission permission : permissions) {
					boolean isPermitted = permission.isIsPermitted();
					String childType = permission.getChildType();
					boolean isStrict = permission.isIsStrict();
					IElementType type = ElementTypeRegistry.getInstance().getType(childType);
					if(type != null) {
						if(isStrict) {
							if(types[0].equals(type)) {
								if(isPermitted) {
									isValid = true;
								}
							} else if(!isPermitted) {
								isValid = false;
							}
						} else {
							// not strict. The super types of typeToCreate should contain the permission type if permitted, or not contain  the permission type if not permitted
							List<IElementType> allTypes = Arrays.asList(types);
							if(allTypes.contains(type)) {
								if(isPermitted) {
									isValid = true;
								} else if(!isPermitted) {
									isValid = false;
								}
							} 
						}
					}
				}
				return isValid;
			}
		};
	}

	/**
	 * {@inheritDoc}
	 */
	public EReference[] getContainmentFeatures() {
		// TODO should implement in permissions...
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void init(InvariantContainerConfiguration ruleConfiguration) {
		this.permissions = ruleConfiguration.getPermissions();
		try {
			sharedContext = TypeContext.getContext();
		} catch (ServiceException e) {
			Activator.log.error(e);
		}
	}
}
