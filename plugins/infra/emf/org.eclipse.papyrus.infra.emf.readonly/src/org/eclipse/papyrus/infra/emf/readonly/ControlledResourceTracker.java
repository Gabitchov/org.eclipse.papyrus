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
package org.eclipse.papyrus.infra.emf.readonly;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomainEvent;
import org.eclipse.emf.transaction.TransactionalEditingDomainListener;
import org.eclipse.emf.transaction.util.TransactionUtil;

/**
 * A resource-set listener that tracks controlled resource connectivity structure. It adds controlled-resource links immediately that they occur
 * and removes them after a transaction has committed that removes them. This makes it reasonably efficient to determine that a referenced model
 * is logically a component of the referencing model and thus not to be treated as read-only. The transactional nature of updates to this mapping
 * is necessary to ensure that the ephemeral states during controlling and uncontrolling a sub-model don't fool the editing domain into thinking
 * we're making changes to a read-only resource, triggering roll-back.
 */
class ControlledResourceTracker extends AdapterImpl implements TransactionalEditingDomainListener {

	private Map<URI, URI> unitMap = new HashMap<URI, URI>();

	private Map<URI, URI> pending;

	/**
	 * Obtains the single tracker instance associated with the specified editing {@code domain}.
	 * 
	 * @param domain
	 *        an editing domain
	 * 
	 * @return its tracker
	 */
	static ControlledResourceTracker getInstance(EditingDomain domain) {
		ControlledResourceTracker result = null;

		for(Object next : domain.getResourceSet().eAdapters()) {
			if(next instanceof ControlledResourceTracker) {
				result = (ControlledResourceTracker)next;
				break;
			}
		}

		if(result == null) {
			result = new ControlledResourceTracker(domain);
		}

		return result;
	}

	private ControlledResourceTracker(EditingDomain domain) {
		domain.getResourceSet().eAdapters().add(this);

		if(domain instanceof TransactionalEditingDomain) {
			TransactionUtil.getAdapter((TransactionalEditingDomain)domain, TransactionalEditingDomain.Lifecycle.class).addTransactionalEditingDomainListener(this);
		}

		// commit the initial discovery
		commit();
	}

	/**
	 * Queries the URI of the resource in the root unit of the model of the same kind as the given potential sub-model unit.
	 * 
	 * @param uri
	 *        the URI of a resource that potentially is in a sub-model unit
	 * 
	 * @return the URI of the corresponding resource in the model's root unit, which could be the same {@code uri} if this is the root unit
	 */
	URI getRootResourceURI(URI uri) {
		URI result = uri.trimFileExtension();

		for(URI parent = get(result); parent != null; parent = get(parent)) {
			if(parent != null) {
				result = parent;
			}
		}

		return (uri.fileExtension() == null) ? result : result.appendFileExtension(uri.fileExtension());
	}

	private URI get(URI potentialUnit) {
		URI result = unitMap.get(potentialUnit);

		if((result == null) && (pending != null)) {
			// Look here, too, in case the current transaction is adding the relationship
			result = pending.get(potentialUnit);
		}

		return result;
	}

	private void ensurePending() {
		if(pending == null) {
			pending = new HashMap<URI, URI>(unitMap);
		}
	}

	private void map(URI controlledUnit, URI parentUnit) {
		ensurePending();
		pending.put(controlledUnit.trimFileExtension(), parentUnit.trimFileExtension());
	}

	private void unmap(URI controlledUnit) {
		ensurePending();
		pending.remove(controlledUnit.trimFileExtension());
	}

	private void commit() {
		if(pending != null) {
			unitMap = pending;
			pending = null;
		}
	}

	private void rollback() {
		pending = null;
	}

	//
	// Adapter protocol
	//

	@Override
	public void setTarget(Notifier newTarget) {
		if(newTarget instanceof ResourceSet) {
			// Discover existing resources
			for(Resource next : ((ResourceSet)newTarget).getResources()) {
				addAdapter(next);
			}
		} else if(newTarget instanceof Resource) {
			handleResource((Resource)newTarget);
		}
	}

	protected void addAdapter(Notifier notifier) {
		notifier.eAdapters().add(this);
	}

	protected void removeAdapter(Notifier notifier) {
		notifier.eAdapters().remove(this);
	}

	@Override
	public void unsetTarget(Notifier oldTarget) {
		if(oldTarget instanceof ResourceSet) {
			for(Resource next : ((ResourceSet)oldTarget).getResources()) {
				removeAdapter(next);
			}
		}
	}

	/**
	 * Discover existing parent-unit relationship in a resource.
	 */
	protected void handleResource(Resource resource) {
		if(!resource.getContents().isEmpty()) {
			EObject root = resource.getContents().get(0);
			EObject container = ((InternalEObject)root).eInternalContainer();
			if(container != null) {
				// Found cross-resource containment
				URI parentURI = container.eIsProxy() ? ((InternalEObject)container).eProxyURI().trimFragment() : container.eResource().getURI();
				if(parentURI != null) {
					map(resource.getURI(), parentURI);
				}
			}
		}
	}

	@Override
	public void notifyChanged(Notification msg) {
		Object notifier = msg.getNotifier();

		if(notifier instanceof ResourceSet) {
			switch(msg.getFeatureID(ResourceSet.class)) {
			case ResourceSet.RESOURCE_SET__RESOURCES:
				switch(msg.getEventType()) {
				case Notification.ADD:
					addAdapter((Resource)msg.getNewValue());
					break;
				case Notification.ADD_MANY:
					for(Object next : (Collection<?>)msg.getNewValue()) {
						addAdapter((Resource)next);
					}
					break;
				case Notification.SET:
					removeAdapter((Resource)msg.getOldValue());
					addAdapter((Resource)msg.getNewValue());
					break;
				case Notification.REMOVE:
					removeAdapter((Resource)msg.getOldValue());
					break;
				case Notification.REMOVE_MANY:
					for(Object next : (Collection<?>)msg.getOldValue()) {
						removeAdapter((Resource)next);
					}
					break;
				}
				break;
			}
		} else if(notifier instanceof Resource) {
			switch(msg.getFeatureID(Resource.class)) {
			case Resource.RESOURCE__CONTENTS:
				switch(msg.getEventType()) {
				case Notification.ADD:
				case Notification.ADD_MANY:
					// Only process the resource when the first root is added
					if(msg.getPosition() == 0) {
						handleResource((Resource)notifier);
					}
					break;
				case Notification.SET:
					// Only process the resource when the first root is replaced
					if(msg.getPosition() == 0) {
						Resource resource = (Resource)notifier;
						unmap(resource.getURI());
						handleResource(resource);
					}
					break;
				case Notification.REMOVE:
				case Notification.REMOVE_MANY:
					// Only process the resource when the first root is removed
					if(msg.getPosition() == 0) {
						unmap(((Resource)msg.getNotifier()).getURI());
					}
					break;
				}
			}
		}
	}

	//
	// TransactionalEditingDomainListener protocol
	//

	public void transactionClosed(TransactionalEditingDomainEvent event) {
		if(event.getTransaction().getStatus().getSeverity() >= IStatus.ERROR) {
			// Transaction rolled back
			rollback();
		} else {
			// Transaction committed
			commit();
		}
	}

	public void editingDomainDisposing(TransactionalEditingDomainEvent event) {
		removeAdapter(event.getSource().getResourceSet());
	}

	public void transactionStarting(TransactionalEditingDomainEvent event) {
		// pass
	}

	public void transactionInterrupted(TransactionalEditingDomainEvent event) {
		// pass
	}

	public void transactionStarted(TransactionalEditingDomainEvent event) {
		// pass
	}

	public void transactionClosing(TransactionalEditingDomainEvent event) {
		// pass
	}

}
