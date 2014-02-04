/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.extendedtypes.advices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IContainerDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;

/**
 * Advice for potential owners of Extended Element Types. This advice will help to the pre/post validation for the creation of child element which is
 * describe by the extended type
 */
public class ExtendedTypesOwnerAdvice extends AbstractEditHelperAdvice {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean approveRequest(IEditCommandRequest request) {
		if(request instanceof CreateElementRequest) {
			// approve the request for this element and all super types 
			IElementType typeToCreate = ((CreateElementRequest)request).getElementType();
			if(typeToCreate instanceof IExtendedHintedElementType) {
				if(!approveCreationRequest(((IExtendedHintedElementType)typeToCreate), (CreateElementRequest)request)) {
					return false;
				}
				// ask for extended super types
				List<IExtendedHintedElementType> superExtendedTypes = getAllSuperExtendedTypes((IExtendedHintedElementType)typeToCreate);
				if(superExtendedTypes == null || superExtendedTypes.size() == 0) {
					return super.approveRequest(request);
				} else {
					for(IExtendedHintedElementType superType : superExtendedTypes) {
						// only refuse if one element refuses the request
						if(!approveCreationRequest(superType, (CreateElementRequest)request)) {
							return false;
						}
					}
				}
			}
		} else if(request instanceof SetRequest) {
			// check the feature to set is a containment feature and element to move is an extended element type
			EStructuralFeature feature = ((SetRequest)request).getFeature();
			if(feature instanceof EReference) {
				if(!((EReference)feature).isContainment()) {
					return super.approveRequest(request);
				} else {
					// containment. Check the kind of element to edit
					Object value = ((SetRequest)request).getValue();
					// value = single object or list ?
					if(value instanceof EObject) {
						IElementType type = ElementTypeRegistry.getInstance().getElementType((EObject)value, request.getClientContext());
						if(type instanceof IExtendedHintedElementType) {
							return approveMoveRequest((IExtendedHintedElementType)type, (SetRequest)request);
						}
					} else if(value instanceof List<?>) {
						for(Object object : (List<Object>)value) {
							if(object instanceof EObject) {
								IElementType[] types = ElementTypeRegistry.getInstance().getAllTypesMatching((EObject)object, request.getClientContext());
								for(IElementType type : types) {
									if(type instanceof IExtendedHintedElementType) {
										if(!approveMoveRequest((IExtendedHintedElementType)type, (SetRequest)request)) {
											return false;
										}
										List<IExtendedHintedElementType> superExtendedTypes = getAllSuperExtendedTypes((IExtendedHintedElementType)type);
										if(superExtendedTypes == null || superExtendedTypes.size() == 0) {
											// nothing here
										} else {
											for(IExtendedHintedElementType superType : superExtendedTypes) {
												// only refuse if one element refuses the request
												if(!approveMoveRequest(superType, (SetRequest)request)) {
													return false;
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		} else if(request instanceof MoveRequest) {
			// check the feature to set is a containment feature and element to move is an extended element type
			Map<EObject, EReference> objectsToMove = ((MoveRequest)request).getElementsToMove();
			if(objectsToMove == null || objectsToMove.isEmpty()) {
				return super.approveRequest(request);
			}
			for(Entry<EObject, EReference> movedElement : objectsToMove.entrySet()) {
				// do not compute with reference, this can be null. This could be interesting to check...
				IElementType[] types = ElementTypeRegistry.getInstance().getAllTypesMatching(movedElement.getKey(), request.getClientContext());
				for(IElementType type : types) {
					if(type instanceof IExtendedHintedElementType) {
						if(!approveMoveRequest((IExtendedHintedElementType)type, movedElement.getKey(), (MoveRequest)request)) {
							return false;
						}
						List<IExtendedHintedElementType> superExtendedTypes = getAllSuperExtendedTypes((IExtendedHintedElementType)type);
						if(superExtendedTypes == null || superExtendedTypes.size() == 0) {
							// nothing here
						} else {
							for(IExtendedHintedElementType superType : superExtendedTypes) {
								// only refuse if one element refuses the request
								if(!approveMoveRequest(superType, movedElement.getKey(), (MoveRequest)request)) {
									return false;
								}
							}
						}
					}
				}
			}
			return super.approveRequest(request);
		}
		return super.approveRequest(request);
	}

	/**
	 * @param iExtendedHintedElementType
	 * @param request
	 * @return
	 */
	protected boolean approveCreationRequest(IExtendedHintedElementType typeToCreate, CreateElementRequest request) {
		IContainerDescriptor containerDescriptor = typeToCreate.getEContainerDescriptor();
		EObject newContainer = request.getContainer();
		// check it matches the container descriptor for the element type
		if(containerDescriptor == null || newContainer == null) {
			return true;
		}
		if(containerDescriptor.getContainmentFeatures() != null && containerDescriptor.getContainmentFeatures().length > 0) {
			// check containment feature
			List<EReference> references = Arrays.asList(containerDescriptor.getContainmentFeatures());
			if(!(references.contains(request.getContainmentFeature()))) {
				return false;
			}
		}
		IElementMatcher containerMatcher = containerDescriptor.getMatcher();
		if(containerMatcher != null) {
			return containerMatcher.matches(newContainer);
		}
		// check container is matching the matcher of the container descriptor for the new type
		return true;
	}

	protected boolean approveMoveRequest(IExtendedHintedElementType typeToMove, SetRequest request) {
		IContainerDescriptor containerDescriptor = typeToMove.getEContainerDescriptor();
		EObject newContainer = request.getElementToEdit();
		// check it matches the container descriptor for the element type
		if(containerDescriptor == null || newContainer == null) {
			return true;
		}
		if(containerDescriptor.getContainmentFeatures() != null && containerDescriptor.getContainmentFeatures().length > 0) {
			// check containment feature
			List<EReference> references = Arrays.asList(containerDescriptor.getContainmentFeatures());
			if(!(references.contains(request.getFeature()))) {
				return false;
			}
		}
		IElementMatcher containerMatcher = containerDescriptor.getMatcher();
		if(containerMatcher != null) {
			return containerMatcher.matches(newContainer);
		}
		// check container is matching the matcher of the container descriptor for the new type
		return true;
	}

	protected boolean approveMoveRequest(IExtendedHintedElementType typeToMove, EObject objectToMove, MoveRequest request) {
		IContainerDescriptor containerDescriptor = typeToMove.getEContainerDescriptor();
		EObject newContainer = request.getTargetContainer();
		// check it matches the container descriptor for the element type
		if(containerDescriptor == null || newContainer == null) {
			return true;
		}
		if(containerDescriptor.getContainmentFeatures() != null && containerDescriptor.getContainmentFeatures().length > 0) {
			// check containment feature
			List<EReference> references = Arrays.asList(containerDescriptor.getContainmentFeatures());
			if(!(references.contains(request.getTargetFeature(objectToMove)))) {
				return false;
			}
		}
		IElementMatcher containerMatcher = containerDescriptor.getMatcher();
		if(containerMatcher != null) {
			return containerMatcher.matches(newContainer);
		}
		// check container is matching the matcher of the container descriptor for the new type
		return true;
	}

	public List<IExtendedHintedElementType> getAllSuperExtendedTypes(IExtendedHintedElementType type) {
		IElementType[] superTypes = type.getAllSuperTypes();
		if(superTypes.length == 0) {
			return Collections.emptyList();
		}
		List<IExtendedHintedElementType> superExtendedTypes = new ArrayList<IExtendedHintedElementType>();
		// get the reverse order (the extended element types are the closest types
		for(int i = superTypes.length - 1; i >= 0; i--) {
			if(superTypes[i] instanceof IExtendedHintedElementType) {
				superExtendedTypes.add((IExtendedHintedElementType)superTypes[i]);
			} /*
			 * else { // optimization: once we are in the hierarchy of "standard" types, we should not go into this hierarchy
			 * return superExtendedTypes;
			 * }
			 */
		}
		return superExtendedTypes;
	}
}
