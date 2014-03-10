/*****************************************************************************
 * Copyright (c) 2013, 2014 Atos Origin, CEA, and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 323802
 *  Christian W. Damus (CEA) - bug 429826
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.resource;

import static org.eclipse.papyrus.infra.core.resource.ReadOnlyAxis.permissionAxes;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler2;
import org.eclipse.papyrus.infra.core.resource.ReadOnlyAxis;

import com.google.common.base.Optional;

public abstract class AbstractReadOnlyHandler implements IReadOnlyHandler2 {

	private EditingDomain editingDomain;

	private CopyOnWriteArrayList<IReadOnlyListener> listeners = new CopyOnWriteArrayList<IReadOnlyListener>();
	
	public AbstractReadOnlyHandler(EditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}
	
	public static IReadOnlyHandler2 adapt(IReadOnlyHandler handler, EditingDomain domain) {
		return new Adapter(handler, domain);
	}

	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	@Deprecated
	public Optional<Boolean> anyReadOnly(URI[] uris) {
		return anyReadOnly(permissionAxes(), uris);
	}
	
	@Deprecated
	public Optional<Boolean> isReadOnly(EObject eObject) {
		return isReadOnly(permissionAxes(), eObject);
	}

	public Optional<Boolean> isReadOnly(Set<ReadOnlyAxis> axes, EObject eObject) {
		Resource res = eObject.eResource();
		if (res != null && res.getURI() != null) {
			return anyReadOnly(axes, new URI[] {res.getURI()});
		}
		return Optional.absent();
	}

	@Deprecated
	public Optional<Boolean> makeWritable(URI[] uris) {
		return makeWritable(permissionAxes(), uris);
	}
	
	@Deprecated
	public Optional<Boolean> makeWritable(EObject eObject) {
		return makeWritable(permissionAxes(), eObject);
	}

	public Optional<Boolean> makeWritable(Set<ReadOnlyAxis> axes, EObject eObject) {
		Resource res = eObject.eResource();
		if (res != null && res.getURI() != null) {
			return makeWritable(axes, new URI[] {res.getURI()});
		}
		return Optional.absent();
	}

	/**
	 * By default, we do not handle writability of these resources.
	 */
	public Optional<Boolean> canMakeWritable(Set<ReadOnlyAxis> axes, URI[] uris) {
		return Optional.absent();
	}
	
	public Optional<Boolean> canMakeWritable(Set<ReadOnlyAxis> axes, EObject object) {
		Resource res = object.eResource();
		if((res != null) && (res.getURI() != null)) {
			return canMakeWritable(axes, new URI[]{ res.getURI() });
		}
		return Optional.absent();
	}
	
	@Override
	public void addReadOnlyListener(IReadOnlyListener listener) {
		listeners.addIfAbsent(listener);
	}
	
	@Override
	public void removeReadOnlyListener(IReadOnlyListener listener) {
		listeners.remove(listener);
	}
	
	protected void fireReadOnlyStateChanged(ReadOnlyAxis axis, URI resourceURI, boolean readOnly) {
		if(!listeners.isEmpty()) {
			ReadOnlyEvent event = new ReadOnlyEvent(this, axis, resourceURI, readOnly);
			for(IReadOnlyListener next : listeners) {
				try {
					next.readOnlyStateChanged(event);
				} catch (Exception e) {
					Activator.log.error("Uncaught exception in read-only state change listener.", e); //$NON-NLS-1$
				}
			}
		}
	}
	
	protected void fireReadOnlyStateChanged(ReadOnlyAxis axis, EObject object, boolean readOnly) {
		if(!listeners.isEmpty()) {
			ReadOnlyEvent event = new ReadOnlyEvent(this, axis, object, readOnly);
			for(IReadOnlyListener next : listeners) {
				try {
					next.readOnlyStateChanged(event);
				} catch (Exception e) {
					Activator.log.error("Uncaught exception in read-only state change listener.", e); //$NON-NLS-1$
				}
			}
		}
	}
	
	//
	// Nested types
	//
	
	private static class Adapter extends AbstractReadOnlyHandler {
		private final IReadOnlyHandler delegate;

		Adapter(IReadOnlyHandler handler, EditingDomain editingDomain) {
			super(editingDomain);

			this.delegate = handler;
		}

		public Optional<Boolean> anyReadOnly(Set<ReadOnlyAxis> axes, URI[] uris) {
			// these handlers implicitly only deal with permission-based read-only-ness
			return !axes.contains(ReadOnlyAxis.PERMISSION) ? Optional.<Boolean> absent() : delegate.anyReadOnly(uris);
		}
		
		@Override
		public Optional<Boolean> isReadOnly(Set<ReadOnlyAxis> axes, EObject eObject) {
			return !axes.contains(ReadOnlyAxis.PERMISSION) ? Optional.<Boolean> absent() : delegate.isReadOnly(eObject);
		}

		public Optional<Boolean> makeWritable(Set<ReadOnlyAxis> axes, URI[] uris) {
			// these handlers implicitly only deal with permission-based read-only-ness
			Optional<Boolean> result = !axes.contains(ReadOnlyAxis.PERMISSION) ? Optional.<Boolean> absent() : delegate.makeWritable(uris);
			
			if (result.or(false)) {
				for (URI next : uris) {
					fireReadOnlyStateChanged(ReadOnlyAxis.PERMISSION, next, true);
				}
			}
			
			return result;
		}
		
		@Override
		public Optional<Boolean> makeWritable(Set<ReadOnlyAxis> axes, EObject eObject) {
			Optional<Boolean> result = !axes.contains(ReadOnlyAxis.PERMISSION) ? Optional.<Boolean> absent() : delegate.makeWritable(eObject);
			
			if (result.or(false)) {
				fireReadOnlyStateChanged(ReadOnlyAxis.PERMISSION, eObject, true);
			}
			
			return result;
		}
	}
}
