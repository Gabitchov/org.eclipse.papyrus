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

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.extendedtypes.Activator;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.IInvariantEditHelperAdvice;
import org.eclipse.papyrus.infra.services.edit.internal.context.TypeContext;

/**
 * Edit Helper advice configured by the {@link InvariantHierarchyConfiguration}
 */
public class InvariantContainerEditHelperAdvice extends AbstractEditHelperAdvice implements IInvariantEditHelperAdvice<InvariantContainerConfiguration> {

	protected List<HierarchyPermission> permissions;

	protected IClientContext sharedContext;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean approveRequest(IEditCommandRequest request) {
		if(request instanceof SetRequest) {
			SetRequest setRequest = ((SetRequest)request);
			EStructuralFeature structuralFeature = setRequest.getFeature();
			if(structuralFeature instanceof EReference) {
				EReference reference = ((EReference)structuralFeature);
				if(reference.isContainment() && setRequest.getValue() != null) {
					// check new value
					return canContain(setRequest);
				}
			}
		} else if(request instanceof CreateElementRequest) {
			CreateElementRequest createElementRequest = ((CreateElementRequest)request);
			IElementType typeToCreate = createElementRequest.getElementType();
			boolean approvedRequest = isValid(typeToCreate, false);
			return approvedRequest;
		}
		return super.approveRequest(request);
	}

	protected boolean isValid(IElementType typeToAdd, boolean baseIsValid) {
		boolean isValid = baseIsValid;
		for(HierarchyPermission permission : permissions) {
			boolean isPermitted = permission.isIsPermitted();
			String childType = permission.getChildType();
			boolean isStrict = permission.isIsStrict();
			IElementType type = ElementTypeRegistry.getInstance().getType(childType);
			if(type != null) {
				if(isStrict) {
					if(typeToAdd.equals(type)) {
						if(isPermitted) {
							isValid = true;
						}
					} else if(!isPermitted) {
						isValid = false;
					}
				} else {
					// not strict. The super types of typeToCreate should contain the permission type if permitted, or not contain  the permission type if not permitted
					List<IElementType> allTypes = Arrays.asList(typeToAdd.getAllSuperTypes());
					allTypes.add(typeToAdd);
					if(allTypes.contains(type)) {
						if(isPermitted) {
							isValid = true;
						}
					} else if(!isPermitted) {
						isValid = false;
					}
				}
			}
		}
		return isValid;
	}
	
	
	protected boolean canContain(SetRequest request) {
		// multivalue or simple value ?
		if(request.getValue() instanceof List<?>) {
			List<Object> values = (List<Object>)request.getValue();
			for(Object value : values) {
				if(value instanceof EObject) {
					IElementType type = ElementTypeRegistry.getInstance().getElementType((EObject)value, request.getClientContext());	
					if(type !=null) {
						if(!isValid(type, false)) {
							return false;
						}
					} else {
						return false;
					}
				}
			}
		} else {
			if(request.getValue() instanceof EObject) {
				IElementType type = ElementTypeRegistry.getInstance().getElementType((EObject)request.getValue(), request.getClientContext());
				if(type !=null) {
					return isValid(type, false);	
				} else {
					return false;
				}
			}
		}
		return true;
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	public void init(InvariantContainerConfiguration configuration) {
		try {
			sharedContext = TypeContext.getContext();
		} catch (ServiceException e) {
			Activator.log.error(e);
		}
		permissions = configuration.getPermissions();
	}
}
