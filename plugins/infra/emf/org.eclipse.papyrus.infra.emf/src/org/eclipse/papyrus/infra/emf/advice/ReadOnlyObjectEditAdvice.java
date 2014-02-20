/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.emf.advice;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;


/**
 * Advice that disapproves edits that would modify objects that are read-only and could not reasonably be made writable.
 */
public class ReadOnlyObjectEditAdvice extends AbstractEditHelperAdvice {

	public ReadOnlyObjectEditAdvice() {
		super();
	}

	protected boolean isUneditable(IEditCommandRequest request, EObject object) {
		boolean result = false;

		if(EMFHelper.isReadOnly(object, request.getEditingDomain())) {
			// If it is in a resource and it is a local file, we may be able to make it writable using team provider hooks or some other means.  Otherwise, no
			Resource resource = object.eResource();
			if(resource == null) {
				result = true;
			} else {
				URI uri = resource.getURI();
				result = !(uri.isPlatformResource() || uri.isFile());
			}
		}

		return result;
	}

	@Override
	public boolean approveRequest(IEditCommandRequest request) {
		if(request instanceof CreateRelationshipRequest) {
			return approveCreateRelationshipRequest((CreateRelationshipRequest)request);
		} else if(request instanceof CreateElementRequest) {
			return approveCreateElementRequest((CreateElementRequest)request);
		} else if(request instanceof DestroyElementRequest) {
			return approveDestroyElementRequest((DestroyElementRequest)request);
		} else if(request instanceof DestroyReferenceRequest) {
			return approveDestroyReferenceRequest((DestroyReferenceRequest)request);
		} else if(request instanceof DuplicateElementsRequest) {
			return approveDuplicateElementsRequest((DuplicateElementsRequest)request);
		} else if(request instanceof MoveRequest) {
			return approveMoveRequest((MoveRequest)request);
		} else if(request instanceof ReorientReferenceRelationshipRequest) {
			return approveReorientReferenceRelationshipRequest((ReorientReferenceRelationshipRequest)request);
		} else if(request instanceof ReorientRelationshipRequest) {
			return approveReorientRelationshipRequest((ReorientRelationshipRequest)request);
		} else if(request instanceof SetRequest) {
			return approveSetRequest((SetRequest)request);
		}

		return super.approveRequest(request);
	}

	protected boolean approveCreateElementRequest(CreateElementRequest request) {
		EObject container = request.getContainer();

		if((container != null) && isUneditable(request, container)) {
			return false;
		}

		return true;
	}

	protected boolean approveCreateRelationshipRequest(CreateRelationshipRequest request) {
		EObject container = request.getContainer();

		if((container != null) && isUneditable(request, container)) {
			return false;
		}

		if(isUneditable(request, request.getSource())) {
			return false;
		}
		// Assume that the target (as in most cases) will not have an inverse reference to the new relationship

		return true;
	}

	protected boolean approveDestroyElementRequest(DestroyElementRequest request) {
		EObject container = request.getContainer();

		if((container != null) && isUneditable(request, container)) {
			return false;
		}
		// Cross-resource containment to a read-only resource? Unlikely. Don't need to look at the object-to-be-destroyed

		return true;
	}

	protected boolean approveDestroyReferenceRequest(DestroyReferenceRequest request) {
		EObject container = request.getContainer();

		// Simple case is when the owner object is read-only
		if((container != null) && isUneditable(request, container)) {
			return false;
		}

		// Handle the case where the reference has an opposite
		EReference ref = request.getContainingFeature();
		if(ref.getEOpposite() != null) {
			// The object being removed will have its inverse reference removed, also
			EObject referenced = request.getReferencedObject();
			if((referenced != null) && isUneditable(request, referenced)) {
				return false;
			}
		}

		return true;
	}

	protected boolean approveDuplicateElementsRequest(DuplicateElementsRequest request) {
		List<?> elements = request.getElementsToBeDuplicated();

		// Elements are duplicated in their containers, so the container must not be read-only
		for(EObject next : Iterables.filter(elements, EObject.class)) {
			EObject container = next.eContainer();
			if((container != null) && isUneditable(request, container)) {
				return false;
			}
		}

		return true;
	}

	protected boolean approveMoveRequest(MoveRequest request) {
		// Is any of the former containers read-only?
		for(EObject next : Iterables.filter(request.getElementsToMove().keySet(), EObject.class)) {
			EObject container = next.eContainer();

			if((container != null) && isUneditable(request, container)) {
				System.out.printf("Container not writable: %s%n", container);
				return false;
			}
		}

		if(isUneditable(request, request.getTargetContainer())) {
			return false;
		}

		return true;
	}

	protected boolean approveReorientRelationshipRequest(ReorientRelationshipRequest request) {
		EObject relationship = request.getRelationship();

		// Simple case is when the owner object is read-only
		if((relationship != null) && isUneditable(request, relationship)) {
			return false;
		}

		// Assume that changing the target would not affect the target object because it would not have an inverse reference
		if(request.getDirection() == ReorientRequest.REORIENT_SOURCE) {
			if(isUneditable(request, request.getOldRelationshipEnd())) {
				return false;
			}
			if(isUneditable(request, request.getNewRelationshipEnd())) {
				return false;
			}
		}

		return true;
	}

	protected boolean approveReorientReferenceRelationshipRequest(ReorientReferenceRelationshipRequest request) {
		EObject owner = request.getReferenceOwner();

		// Simple case is when the owner object is read-only
		if((owner != null) && isUneditable(request, owner)) {
			return false;
		}

		// Assume that changing the target would not affect the target object because it would not have an inverse reference
		if(request.getDirection() == ReorientRequest.REORIENT_SOURCE) {
			if(isUneditable(request, request.getOldRelationshipEnd())) {
				return false;
			}
			if(isUneditable(request, request.getNewRelationshipEnd())) {
				return false;
			}
		}

		return true;
	}

	protected boolean approveSetRequest(SetRequest request) {
		// Simple case of read-only element
		if(isUneditable(request, request.getElementToEdit())) {
			return false;
		}

		if(request.getFeature() instanceof EReference) {
			EReference ref = (EReference)request.getFeature();
			if(ref.getEOpposite() != null) {
				// Objects on the opposite end must not be read-only
				Collection<EObject> affectedOpposites = getAffectedOpposites(request.getElementToEdit(), ref, request.getValue());
				if(!affectedOpposites.isEmpty()) {
					for(EObject next : affectedOpposites) {
						if(isUneditable(request, next)) {
							return false;
						}
					}
				}
			}
		}

		return true;
	}

	/**
	 * Obtains the objects that will be changed by means of the opposite "handshaking" of the given reference of a {@code source} object getting a new
	 * value.
	 */
	protected Collection<EObject> getAffectedOpposites(EObject source, EReference refWithOpposite, Object newValue) {
		Collection<EObject> result;

		if(refWithOpposite.isMany()) {
			if((newValue == null) || ((newValue instanceof Collection<?>) && ((Collection<?>)newValue).isEmpty())) {
				// Removing all current references (and, hence, their inverses)
				result = getReferencedObjects(source, refWithOpposite);
			} else {
				// The symmetric difference of currently- and to-be-referenced objects will change
				Set<EObject> current = Sets.newHashSet(getReferencedObjects(source, refWithOpposite));
				Set<EObject> future = (newValue instanceof Collection<?>) ? ImmutableSet.copyOf(Iterables.filter((Collection<?>)newValue, EObject.class)) : Collections.singleton((EObject)newValue);
				result = ImmutableList.copyOf(Sets.symmetricDifference(current, future));
			}
		} else {
			Object current = source.eGet(refWithOpposite);
			if(current != newValue) {
				// The current value will lose its inverse reference and the new value will gain one
				if(current == null) {
					result = Collections.singletonList((EObject)newValue);
				} else if(newValue == null) {
					result = Collections.singleton((EObject)current);
				} else {
					result = ImmutableList.of((EObject)current, (EObject)newValue);
				}
			} else {
				// No objects will change
				result = Collections.emptyList();
			}
		}

		return result;
	}

	/**
	 * Obtains the objects referenced by a {@code source} object via a particular {@code reference}.
	 */
	private Collection<EObject> getReferencedObjects(EObject source, EReference reference) {
		Collection<EObject> result;

		Object current = source.eGet(reference);
		if(current instanceof Collection<?>) {
			result = ImmutableList.copyOf(Iterables.filter((Collection<?>)current, EObject.class));
		} else if(current != null) {
			result = Collections.singletonList((EObject)current);
		} else {
			result = Collections.emptyList();
		}

		return result;
	}
}
