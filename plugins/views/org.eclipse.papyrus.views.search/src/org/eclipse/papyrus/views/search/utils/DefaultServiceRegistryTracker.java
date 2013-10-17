/*****************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.search.utils;

import java.lang.ref.ReferenceQueue;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.views.search.Activator;


/**
 * This is the DefaultServiceRegistryTracker type. Enjoy.
 */
public class DefaultServiceRegistryTracker implements IServiceRegistryTracker {

	private static final ExecutorService EXEC = Executors.newCachedThreadPool(new ThreadFactory() {

		private final AtomicInteger threadNum = new AtomicInteger();

		private final ThreadGroup group = new ThreadGroup(Thread.currentThread().getThreadGroup(), "Service Registry Tracker Threads"); //$NON-NLS-1$

		public Thread newThread(Runnable r) {
			Thread result = new Thread(group, r, "SvcRegTracker-" + threadNum.incrementAndGet()); //$NON-NLS-1$
			result.setDaemon(true);
			return result;
		}
	});

	private Set<TrackerReference> references = new java.util.HashSet<TrackerReference>();

	private ReferenceQueue<Object> queue = new ReferenceQueue<Object>();

	private int count = 0;

	private boolean active = true;

	private Runnable reaper;

	public DefaultServiceRegistryTracker() {
		super();
	}

	public synchronized boolean isActive() {
		return active;
	}

	// requires monitor
	private void checkActive() {
		if(!active) {
			throw new IllegalStateException("not active"); //$NON-NLS-1$
		}
	}

	public synchronized void track(Object owner, ServicesRegistry serviceRegistry) {
		checkActive();

		TrackerReference existing = getReference(serviceRegistry);
		if(existing == null) {
			// only in this case would we ever track
			references.add(new TrackerReference(owner, serviceRegistry));
			count++;
			reapLater();
		} else {
			Object actualOwner = existing.get();

			// the reference may have been cleared, in which case we assume the registry
			// was disposed and the reference did track this owner
			if((actualOwner != null) && (actualOwner != owner)) {
				throw new IllegalArgumentException("registry already tracked against a different owner"); //$NON-NLS-1$
			}
		}
	}

	public synchronized void untrack(Object owner, ServicesRegistry serviceRegistry) {
		checkActive();

		TrackerReference existing = getReference(serviceRegistry);
		if((existing != null) && (existing.get() == owner)) {
			references.remove(existing);
			// it will still be enqueued later, but we will ignore it
		}
	}

	// requires monitor
	private TrackerReference getReference(ServicesRegistry serviceRegistry) {
		TrackerReference result = null;

		for(TrackerReference next : references) {
			if(next.matches(serviceRegistry)) {
				result = next;
			}
		}

		return result;
	}

	// requires monitor
	private void reapLater() {
		if(reaper == null) {
			reaper = new Runnable() {

				public void run() {
					for(;;) {
						try {
							if(!dequeue()) {
								// done!
								break;
							}
						} catch (InterruptedException e) {
							Activator.log.error("Service registry reaper thread interrupted. How?", e); //$NON-NLS-1$
						}
					}
				}
			};

			EXEC.execute(reaper);
		}
	}

	private boolean dequeue() throws InterruptedException {
		boolean result = true;

		TrackerReference ref = (TrackerReference)queue.remove();

		synchronized(this) {
			if(references.remove(ref)) {
				// only dispose the service registry if we didn't untrack it!
				ref.dispose();
			}

			if(--count <= 0) {
				// nothing more to reap
				reaper = null;
				active = false;
				result = false;
			}
		}

		return result;
	}

	//
	// Nested types
	//

	private class TrackerReference extends java.lang.ref.WeakReference<Object> {

		private final ServicesRegistry serviceRegistry;

		TrackerReference(Object owner, ServicesRegistry serviceRegistry) {
			super(owner, queue);

			this.serviceRegistry = serviceRegistry;
		}

		void dispose() {
			try {
				serviceRegistry.disposeRegistry();
			} catch (Exception e) {
				Activator.log.error("Exception in disposal of service registry that is no longer in use.", e); //$NON-NLS-1$
			}
		}

		boolean matches(ServicesRegistry serviceRegistry) {
			return this.serviceRegistry == serviceRegistry;
		}
	}
}
