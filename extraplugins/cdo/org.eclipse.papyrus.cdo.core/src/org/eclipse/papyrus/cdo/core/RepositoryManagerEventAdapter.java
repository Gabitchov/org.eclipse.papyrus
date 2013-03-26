/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.core;

import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.cdo.view.CDOViewInvalidationEvent;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.net4j.util.container.ContainerEventAdapter;
import org.eclipse.net4j.util.container.IContainer;
import org.eclipse.net4j.util.container.IContainerDelta;
import org.eclipse.net4j.util.container.IContainerDelta.Kind;
import org.eclipse.net4j.util.container.IContainerEvent;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.net4j.util.lifecycle.ILifecycle;
import org.eclipse.net4j.util.lifecycle.LifecycleEventAdapter;
import org.eclipse.papyrus.cdo.internal.core.Activator;
import org.eclipse.papyrus.cdo.internal.core.IInternalPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.core.IInternalPapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.core.PapyrusRepositoryManager;


/**
 * A handy listener adapter to add to {@link PapyrusRepositoryManager}s to be notified when
 * <ul>
 * <li>a repository is {@linkplain #onAdded(IPapyrusRepositoryManager, IPapyrusRepository) added}</li>
 * <li>a repository is {@linkplain #onRemoved(IPapyrusRepositoryManager, IPapyrusRepository) removed}</li>
 * <li>a repository is {@linkplain #onConnected(IPapyrusRepository) connected}</li>
 * <li>a repository is {@linkplain #onDisconnected(IPapyrusRepository) disconnected}</li>
 * <li>(optionally) the view attached to some {link ResourceSet} receives an
 * {@linkplain #onInvalidation(IPapyrusRepository, CDOView, CDOViewInvalidationEvent) invalidation event}</li>
 * </ul>
 * <p>
 * To add the listener to a repository manager, use the {@link #install(IPapyrusRepositoryManager)} method. To remove it, use
 * {@link #uninstall(IPapyrusRepositoryManager)}.
 * </p>
 * 
 * @see #install(IPapyrusRepositoryManager)
 * @see #uninstall(IPapyrusRepositoryManager)
 */
public class RepositoryManagerEventAdapter {

	private IPapyrusRepositoryManager target;

	private final ManagerListener managerListener;

	private final RepositoryListener repositoryListener;

	private final IListener viewInvalidationListener;

	public RepositoryManagerEventAdapter() {
		this(null);
	}

	public RepositoryManagerEventAdapter(ResourceSet resourceSet) {
		super();

		managerListener = new ManagerListener();
		repositoryListener = new RepositoryListener();

		this.viewInvalidationListener = (resourceSet != null) ? new InvalidationListener(resourceSet) : null;
	}

	/**
	 * Install me on a repository manager. This iterates all repositories that already exist, to call the
	 * {@link #onAdded(IPapyrusRepositoryManager, IPapyrusRepository)} call-back
	 * on each, for convenience. For any existing repositories that are already connected, the {@link #onConnected(IPapyrusRepository)} call-back is
	 * also invoked.
	 * 
	 * @param repositoryManager
	 *        a repository manager to install me on
	 * 
	 * @return myself, for convenience of call chaining
	 */
	public RepositoryManagerEventAdapter install(IPapyrusRepositoryManager repositoryManager) {
		@SuppressWarnings("unchecked")
		IContainer<IPapyrusRepository> container = (IContainer<IPapyrusRepository>)repositoryManager;

		target = repositoryManager;

		container.addListener(managerListener);

		for(IPapyrusRepository next : repositoryManager.getRepositories()) {
			try {
				managerListener.onAdded(container, next);
			} catch (Exception e) {
				Activator.log.error(e);
			}
		}

		return this;
	}

	/**
	 * Remove me from a repository manager. This iterates all repositories that currently exist, to call the
	 * {@link #onRemoved(IPapyrusRepositoryManager, IPapyrusRepository)} call-back on each, for convenience.
	 * 
	 * @param repositoryManager
	 *        a repository manager to remove me from
	 * 
	 * @return myself, for convenience of call chaining
	 */
	public RepositoryManagerEventAdapter uninstall(IPapyrusRepositoryManager repositoryManager) {
		if((target != null) && (target == repositoryManager)) {
			@SuppressWarnings("unchecked")
			IContainer<IPapyrusRepository> container = (IContainer<IPapyrusRepository>)repositoryManager;

			for(IPapyrusRepository next : repositoryManager.getRepositories()) {
				try {
					onRemoved(repositoryManager, next);
				} catch (Exception e) {
					Activator.log.error(e);
				}
			}

			container.removeListener(managerListener);

			target = null;
		}

		return this;
	}

	void handleConnection(IInternalPapyrusRepository repository) {
		if(viewInvalidationListener != null) {
			repository.getCDOSession().addListener(viewInvalidationListener);

			// look for existing view
			for(CDOView next : repository.getCDOSession().getViews()) {
				if(next.getResourceSet() == target) {
					next.addListener(viewInvalidationListener);
				}
			}
		}

		onConnected(repository);
	}

	void handleDisconnection(IInternalPapyrusRepository repository) {
		onDisconnected(repository);
	}

	protected void onAdded(IPapyrusRepositoryManager manager, IPapyrusRepository repository) {
		// pass
	}

	protected void onRemoved(IPapyrusRepositoryManager manager, IPapyrusRepository repository) {
		// pass
	}

	protected void onConnected(IPapyrusRepository repository) {
		// pass
	}

	protected void onDisconnected(IPapyrusRepository repository) {
		// pass
	}

	protected void onInvalidation(IPapyrusRepository repository, CDOView view, CDOViewInvalidationEvent event) {

	}


	//
	// Nested types
	//

	private class ManagerListener extends ContainerEventAdapter<IPapyrusRepository> {

		@Override
		protected void onAdded(IContainer<IPapyrusRepository> container, IPapyrusRepository element) {
			element.addPapyrusRepositoryListener(repositoryListener);

			RepositoryManagerEventAdapter.this.onAdded((IPapyrusRepositoryManager)container, element);

			if(element.isConnected()) {
				handleConnection((IInternalPapyrusRepository)element);
			}
		}

		@Override
		protected void onRemoved(IContainer<IPapyrusRepository> container, IPapyrusRepository element) {
			element.removePapyrusRepositoryListener(repositoryListener);

			RepositoryManagerEventAdapter.this.onRemoved((IPapyrusRepositoryManager)container, element);
		}

	}

	private class RepositoryListener implements IPapyrusRepositoryListener {

		public void papyrusRepositoryChanged(PapyrusRepositoryEvent event) {
			switch(event.getEventType()) {
			case PapyrusRepositoryEvent.CONNECTED:
				handleConnection((IInternalPapyrusRepository)event.getSource());
				break;
			case PapyrusRepositoryEvent.DISCONNECTED:
				handleDisconnection((IInternalPapyrusRepository)event.getSource());
				break;
			default:
				throw new IllegalArgumentException("Invalid repository event type: " + event.getEventType()); //$NON-NLS-1$
			}
		}
	}

	private class InvalidationListener extends LifecycleEventAdapter {

		private final ResourceSet resourceSet;

		InvalidationListener(ResourceSet resourceSet) {
			this.resourceSet = resourceSet;
		}

		@Override
		protected void notifyOtherEvent(IEvent event) {
			if(event instanceof CDOViewInvalidationEvent) {
				CDOViewInvalidationEvent invalidation = (CDOViewInvalidationEvent)event;
				IPapyrusRepository repo = ((IInternalPapyrusRepositoryManager)target).getRepository(invalidation.getSource());
				onInvalidation(repo, invalidation.getSource(), invalidation);
			} else if(event instanceof IContainerEvent<?>) {
				@SuppressWarnings("unchecked")
				IContainerEvent<CDOView> containerEvent = (IContainerEvent<CDOView>)event;
				onContainerEvent(containerEvent);
			}
		}

		@Override
		protected void onDeactivated(ILifecycle lifecycle) {
			lifecycle.removeListener(this);
		}

		protected void onContainerEvent(IContainerEvent<CDOView> event) {
			for(IContainerDelta<CDOView> next : event.getDeltas()) {
				if(next.getKind() == Kind.ADDED) {
					if(next.getElement().getResourceSet() == resourceSet) {
						next.getElement().addListener(this);
					}
				}
			}
		}
	}
}
