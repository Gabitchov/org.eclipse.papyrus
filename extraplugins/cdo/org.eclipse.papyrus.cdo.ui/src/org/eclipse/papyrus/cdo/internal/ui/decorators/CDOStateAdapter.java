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
package org.eclipse.papyrus.cdo.internal.ui.decorators;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.cdo.dawn.spi.DawnState;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.collect.Sets;

/**
 * An adapter that caches the current Dawn
 */
public class CDOStateAdapter
		extends AdapterImpl {

	private DawnState state = DawnState.CLEAN;

	CDOStateAdapter() {
		super();
	}

	public static CDOStateAdapter require(Notifier notifier) {
		CDOStateAdapter result = get(notifier);

		if (result == null) {
			result = new CDOStateAdapter();
			notifier.eAdapters().add(result);
		}

		return result;
	}

	public static CDOStateAdapter get(Notifier notifier) {
		return (CDOStateAdapter) EcoreUtil.getExistingAdapter(notifier,
			DawnState.class);
	}

	public static DawnState getState(Notifier notifier) {
		CDOStateAdapter adapter = get(notifier);

		return (adapter == null)
			? DawnState.CLEAN
			: adapter.getState();
	}

	public static void setState(Notifier notifier, DawnState state) {
		if (state == DawnState.CLEAN) {
			CDOStateAdapter adapter = get(notifier);
			if (adapter != null) {
				notifier.eAdapters().remove(adapter);
			}
		} else {
			require(notifier).setState(state);
		}
	}

	public static Iterable<CDOStateAdapter> getAll(ResourceSet resourceSet) {
		Iterable<CDOStateAdapter> result;

		Tracker tracker = Tracker.get(resourceSet);
		if (tracker == null) {
			result = Collections.emptySet();
		} else {
			result = tracker.getStateAdapters();
		}

		return result;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == DawnState.class;
	}

	public DawnState getState() {
		return state;
	}

	public void setState(DawnState state) {
		this.state = (state == null)
			? DawnState.CLEAN
			: state;
	}

	@Override
	public void setTarget(Notifier newTarget) {
		super.setTarget(newTarget);

		if (newTarget instanceof EObject) {
			Resource res = ((EObject) newTarget).eResource();
			if (res != null) {
				ResourceSet rset = res.getResourceSet();
				if (rset != null) {
					Tracker.require(rset).add(this);
				}
			}
		}
	}

	@Override
	public void unsetTarget(Notifier oldTarget) {
		if (oldTarget instanceof EObject) {
			Resource res = ((EObject) oldTarget).eResource();
			if (res != null) {
				ResourceSet rset = res.getResourceSet();
				if (rset != null) {
					Tracker tracker = Tracker.get(rset);
					if (tracker != null) {
						tracker.remove(this);
					}
				}
			}
		}

		super.unsetTarget(oldTarget);
	}

	//
	// Nested types
	//

	private static final class Tracker
			extends AdapterImpl {

		private final Set<CDOStateAdapter> stateAdapters = Sets.newHashSet();

		static Tracker get(ResourceSet resourceSet) {
			Tracker result = null;

			for (Object next : resourceSet.eAdapters()) {
				if (next instanceof Tracker) {
					result = (Tracker) next;
					break;
				}
			}

			return result;
		}

		static Tracker require(ResourceSet resourceSet) {
			Tracker result = get(resourceSet);

			if (result == null) {
				result = new Tracker();
				resourceSet.eAdapters().add(result);
			}

			return result;
		}

		void add(CDOStateAdapter stateAdapter) {
			stateAdapters.add(stateAdapter);
		}

		void remove(CDOStateAdapter stateAdapter) {
			stateAdapters.remove(stateAdapter);
		}

		Iterable<CDOStateAdapter> getStateAdapters() {
			return stateAdapters;
		}
	}
}
