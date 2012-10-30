package org.eclipse.papyrus.uml.profileefacet.metamodel.resolver;

import java.util.List;

import org.eclipse.emf.facet.efacet.core.internal.exported.IResolver;
import org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.ProfileFacetSet;
import org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypeFacet;
import org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypePropertyFacetAttribute;
import org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypePropertyFacetReference;



public class ProfileEFacetResolver implements IResolver {

	public boolean canHandle(Object object) {
		return object instanceof ProfileFacetSet || object instanceof StereotypeFacet || object instanceof StereotypePropertyFacetAttribute || object instanceof StereotypePropertyFacetReference;
	}

	public <T> T resolve(Object object, Class<T> aClass) {
		Object result = object;
		if(object instanceof ProfileFacetSet){
			
		}else if(object instanceof StereotypeFacet){
			
		}else if(object instanceof StereotypePropertyFacetAttribute){
			
		}else if(object instanceof StereotypePropertyFacetReference){
			
		}
//		if (object instanceof AggregatedFacetSetImpl) {
//			final AggregatedFacetSetImpl proxy = (AggregatedFacetSetImpl) object;
//			result = proxy.getFacetSet();
//		} else if (object instanceof AggregatedFacetImpl) {
//			final AggregatedFacetImpl proxy = (AggregatedFacetImpl) object;
//			result = proxy.getFacet();
//		} else if (object instanceof AggregatedEStructuralFeatureImpl) {
//			final AggregatedEStructuralFeatureImpl proxy = (AggregatedEStructuralFeatureImpl) object;
//			result = proxy.getEStructuralFeature();
//		} else if (object instanceof AggregatedOperationImpl) {
//			final AggregatedOperationImpl proxy = (AggregatedOperationImpl) object;
//			result = proxy.getFacetOperation();
//		} else if (object instanceof Aggregate) {
//			result = object;
//		}
//		return cast(result, aClass);
//	}

		return cast(result, aClass);
	}

	public <T> List<T> selectionPropagation(Object selectedObject, Class<T> aClass) {
		int i=0;
		i++;
		return null;
	}

	public <T> T selectionRoot(Object selectedObject, Class<T> aClass) {
		int i=0;
		i++;
		return null;
	}

	
//	/**
//	 * Copyright (c) 2012 CEA LIST.
//	 * All rights reserved. This program and the accompanying materials
//	 * are made available under the terms of the Eclipse Public License v1.0
//	 * which accompanies this distribution, and is available at
//	 * http://www.eclipse.org/legal/epl-v10.html
//	 * 
//	 * Contributors:
//	 *    Gregoire Dupe (Mia-Software) - Bug 375087 - [Table] ITableWidget.addColumn(List<ETypedElement>, List<FacetSet>)
//	 *    Gregoire Dupe (Mia-Software) - Bug 372626 - Aggregates
//	 */
//	package org.eclipse.emf.facet.aggregate.metamodel.notgenerated.internal;
//
//	import java.util.Iterator;
//	import java.util.LinkedList;
//	import java.util.List;
//
//	import org.eclipse.emf.ecore.EObject;
//	import org.eclipse.emf.facet.aggregate.metamodel.notgenerated.internal.aggregateproxy.AggregatedEStructuralFeatureImpl;
//	import org.eclipse.emf.facet.aggregate.metamodel.notgenerated.internal.aggregateproxy.AggregatedFacetImpl;
//	import org.eclipse.emf.facet.aggregate.metamodel.notgenerated.internal.aggregateproxy.AggregatedFacetSetImpl;
//	import org.eclipse.emf.facet.aggregate.metamodel.notgenerated.internal.aggregateproxy.AggregatedOperationImpl;
//	import org.eclipse.emf.facet.aggregate.metamodel.v0_2_0.aggregate.Aggregate;
//	import org.eclipse.emf.facet.efacet.core.FacetUtils;
//	import org.eclipse.emf.facet.efacet.core.internal.exported.IResolver;
//	import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
//
//	public class Resolver implements IResolver {
//
//		public boolean canHandle(final Object object) {
//			return object instanceof AggregatedFacetSetImpl
//					|| object instanceof AggregatedFacetImpl
//					|| object instanceof AggregatedEStructuralFeatureImpl
//					|| object instanceof AggregatedOperationImpl
//					|| object instanceof Aggregate;
//		}
//
//
//		public <T> T resolve(final Object object, final Class<T> aClass) {
//			Object result = null;
//			if (object instanceof AggregatedFacetSetImpl) {
//				final AggregatedFacetSetImpl proxy = (AggregatedFacetSetImpl) object;
//				result = proxy.getFacetSet();
//			} else if (object instanceof AggregatedFacetImpl) {
//				final AggregatedFacetImpl proxy = (AggregatedFacetImpl) object;
//				result = proxy.getFacet();
//			} else if (object instanceof AggregatedEStructuralFeatureImpl) {
//				final AggregatedEStructuralFeatureImpl proxy = (AggregatedEStructuralFeatureImpl) object;
//				result = proxy.getEStructuralFeature();
//			} else if (object instanceof AggregatedOperationImpl) {
//				final AggregatedOperationImpl proxy = (AggregatedOperationImpl) object;
//				result = proxy.getFacetOperation();
//			} else if (object instanceof Aggregate) {
//				result = object;
//			}
//			return cast(result, aClass);
//		}
//
		@SuppressWarnings("unchecked")
		// @SuppressWarnings("unchecked") is cast is checked by the if statement.
		private static <T> T cast(final Object object, final Class<T> aClass) {
			if (!aClass.isInstance(object)) {
				throw new ClassCastException("Unexpected instance type"); //$NON-NLS-1$
			}
			return (T) object;
		}
//
//
//		public <T> List<T> selectionPropagation(final Object selectedObject,
//				final Class<T> aClass) {
//			FacetSet rootFacetSet = null; 
//			if (selectedObject instanceof AggregatedFacetSetImpl) {
//				final AggregatedFacetSetImpl proxy = (AggregatedFacetSetImpl) selectedObject;
//				rootFacetSet = FacetUtils.getRootFacetSet(proxy);
//			} else if (selectedObject instanceof AggregatedFacetImpl) {
//				final AggregatedFacetImpl proxy = (AggregatedFacetImpl) selectedObject;
//				rootFacetSet = FacetUtils.getRootFacetSet(proxy);
//			} else if (selectedObject instanceof AggregatedEStructuralFeatureImpl) {
//				final AggregatedEStructuralFeatureImpl proxy = (AggregatedEStructuralFeatureImpl) selectedObject;
//				rootFacetSet = FacetUtils.getRootFacetSet(proxy.getContainer());
//			} else if (selectedObject instanceof AggregatedOperationImpl) {
//				final AggregatedOperationImpl proxy = (AggregatedOperationImpl) selectedObject;
//				rootFacetSet = FacetUtils.getRootFacetSet(proxy.getContainer());
//			} else if (selectedObject instanceof Aggregate) {
//				rootFacetSet = (Aggregate) selectedObject;
//			} else {
//				throw new IllegalStateException();
//			}
//			final List<T> result = new LinkedList<T>();
//			final Iterator<EObject> iterator = rootFacetSet.eAllContents();
//			while (iterator.hasNext()) {
//				final Object object = iterator.next();
//				castAndAdd(aClass, result, object);
//			}
//			return result;
//		}
//
//		private static <T> void castAndAdd(final Class<T> aClass,
//				final List<T> result,
//				final Object object) {
//			if (aClass.isInstance(object)) {
//				@SuppressWarnings("unchecked")
//				// @SuppressWarnings("unchecked") checked by the call to
//				// isInstance
//				final T castedObject = (T) object;
//				result.add(castedObject);
//			}
//		}
//
//		@SuppressWarnings("unchecked")
//		// @SuppressWarnings("unchecked") checked by the call to
//		// isInstance
//		private static <T> T cast(final Class<T> aClass,
//				final Object object) {
//			if (!aClass.isInstance(object)) {
//				throw new ClassCastException();
//			}
//			return (T) object;
//		}
//
//		public <T> T selectionRoot(final Object selectedObject,
//				final Class<T> aClass) {
//			T result = null;
//			if (selectedObject instanceof FacetSet) {
//				final FacetSet facetSet = (FacetSet) selectedObject;
//				final FacetSet root = FacetUtils.getRootFacetSet(facetSet);
//				result = cast(aClass, root);
//			}
//			return result;
//
//		}
//
//	}

}
