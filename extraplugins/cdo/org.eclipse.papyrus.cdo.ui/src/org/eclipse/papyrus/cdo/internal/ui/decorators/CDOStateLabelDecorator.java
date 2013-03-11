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

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.cdo.dawn.appearance.DawnElementStylizer;
import org.eclipse.emf.cdo.dawn.spi.DawnState;
import org.eclipse.emf.cdo.dawn.ui.stylizer.DawnElementStylizerRegistry;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.papyrus.cdo.internal.ui.l10n.Messages;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.progress.UIJob;

/**
 * This is the CDOStateLabelDecorator type. Enjoy.
 */
public class CDOStateLabelDecorator
		implements ILabelDecorator {

	private static Set<CDOStateLabelDecorator> instances = new CopyOnWriteArraySet<CDOStateLabelDecorator>();

	private final ResourceManager manager = new LocalResourceManager(
		JFaceResources.getResources());

	private final ListenerList listeners = new ListenerList();

	private static LabelUpdateJob labelUpdateJob = new LabelUpdateJob();

	public CDOStateLabelDecorator() {
		super();

		instances.add(this);
	}

	public void dispose() {
		manager.dispose();

		instances.remove(this);
	}

	public Image decorateImage(Image image, Object element) {
		EObject eObject = EMFHelper.getEObject(element);

		if (eObject != null) {
			DawnState state = CDOStateAdapter.getState(eObject);
			if (state != DawnState.CLEAN) {
				DawnElementStylizer stylizer = DawnElementStylizerRegistry.instance
					.getStylizer(eObject);

				if (stylizer != null) {
					ImageDescriptor decoration = ImageDescriptor
						.createFromImage(stylizer.getImage(eObject, state));

					if (decoration != null) {
						ImageDescriptor desc = new DecorationOverlayIcon(image,
							decoration, IDecoration.BOTTOM_RIGHT);

						return (Image) manager.get(desc);
					}
				}
			}
		}

		return image;
	}

	public String decorateText(String text, Object element) {
		return text;
	}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public void addListener(ILabelProviderListener listener) {
		listeners.add(listener);
	}

	public void removeListener(ILabelProviderListener listener) {
		listeners.remove(listener);
	}

	public static void fireLabelUpdates() {
		labelUpdateJob.poke();
	}

	private void fireUpdates() {
		Object[] listeners = this.listeners.getListeners();

		if (listeners.length > 0) {
			LabelProviderChangedEvent event = new LabelProviderChangedEvent(
				this);

			for (int i = 0; i < listeners.length; i++) {
				try {
					((ILabelProviderListener) listeners[i])
						.labelProviderChanged(event);
				} catch (Exception e) {
					Activator.log.error(
						"Uncaught exception in label provider listener.", e); //$NON-NLS-1$
				}
			}
		}
	}

	/**
	 * A label-updating job that aggregates multiple requests to update labels,
	 * in order to avoid redundant updates.
	 */
	private static class LabelUpdateJob
			extends UIJob {

		private final Object lock = new Object();

		private boolean pending;

		LabelUpdateJob() {
			super(Messages.CDOStateLabelDecorator_1);

			setSystem(true);
		}

		@Override
		public IStatus runInUIThread(IProgressMonitor monitor) {

			for (;;) {
				synchronized (lock) {
					pending = false;
				}

				for (CDOStateLabelDecorator next : instances) {
					next.fireUpdates();
				}

				synchronized (lock) {
					if (!pending) {
						break;
					}
				}
			};

			return Status.OK_STATUS;
		}

		void poke() {
			synchronized (lock) {
				if (!pending) {
					pending = true;

					if (getState() != Job.RUNNING) {
						schedule();
					}
				}
			}
		}
	}
}
