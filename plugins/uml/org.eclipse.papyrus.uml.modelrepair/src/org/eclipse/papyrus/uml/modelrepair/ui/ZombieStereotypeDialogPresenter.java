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
package org.eclipse.papyrus.uml.modelrepair.ui;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResourceSet;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.labelprovider.service.impl.LabelProviderServiceImpl;
import org.eclipse.papyrus.uml.modelrepair.Activator;
import org.eclipse.papyrus.uml.modelrepair.internal.stereotypes.ZombieStereotypesDescriptor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;

import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;


/**
 * This is the ZombieStereotypeDialogPresenter type. Enjoy.
 */
public class ZombieStereotypeDialogPresenter {

	private final Shell parentShell;

	private final ModelSet modelSet;

	private final List<ZombieStereotypesDescriptor> zombieDescriptors = Lists.newArrayListWithExpectedSize(1);

	private final BrowseProfileSupplier dynamicProfileSupplier = new BrowseProfileSupplier();

	private Runnable presentation;

	private final Lock lock = new ReentrantLock();

	private final Condition pendingCond = lock.newCondition();

	private volatile boolean pending = false;

	public ZombieStereotypeDialogPresenter(Shell parentShell, ModelSet modelSet) {
		super();

		this.parentShell = parentShell;
		this.modelSet = modelSet;
	}

	public void dispose() {
		lock.lock();
		try {
			zombieDescriptors.clear();
			presentation = null;
		} finally {
			lock.unlock();
		}
	}

	public BrowseProfileSupplier getDynamicProfileSupplier() {
		return dynamicProfileSupplier;
	}

	public void addZombies(ZombieStereotypesDescriptor zombies) {
		lock.lock();
		try {
			zombieDescriptors.add(zombies);

			if(presentation == null) {
				internalSetPending(true);

				presentation = new Runnable() {

					public void run() {
						List<ZombieStereotypesDescriptor> zombies;

						lock.lock();
						try {
							if(presentation != this) {
								internalSetPending(false);
								return;
							}
							zombies = ImmutableList.copyOf(zombieDescriptors);
							dispose();
						} finally {
							lock.unlock();
						}

						try {
							if(!zombies.isEmpty()) {
								try {
									ZombieStereotypesDialog zombieDialog = new ZombieStereotypesDialog(parentShell, modelSet, zombies);
									dynamicProfileSupplier.setParentWindow(zombieDialog);
									zombieDialog.setBlockOnOpen(true);
									zombieDialog.open();
								} catch (ServiceException e) {
									StatusManager.getManager().handle(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Failed to open model repair dialog.", e), StatusManager.SHOW);
								} finally {
									dynamicProfileSupplier.setParentWindow(null);
								}
							}
						} finally {
							internalSetPending(false);
						}
					}
				};

				parentShell.getDisplay().asyncExec(presentation);
			}
		} finally {
			lock.unlock();
		}
	}

	public boolean isPending() {
		return pending;
	}

	public void awaitPending(boolean expected) throws InterruptedException {
		lock.lock();
		try {
			while(pending != expected) {
				pendingCond.await();
			}
		} finally {
			lock.unlock();
		}
	}

	private void internalSetPending(boolean pending) {
		lock.lock();
		try {
			this.pending = pending;
			pendingCond.signalAll();
		} finally {
			lock.unlock();
		}
	}

	//
	// Nested types
	//

	private class BrowseProfileSupplier implements Supplier<Profile> {

		private Window parentWindow;

		void setParentWindow(Window parentWindow) {
			this.parentWindow = parentWindow;
		}

		public Profile get() {
			Profile result = null;

			LabelProviderService labelProvider = null;
			boolean localProvider = false;
			try {
				labelProvider = ServiceUtilsForResourceSet.getInstance().getService(LabelProviderService.class, modelSet);
			} catch (ServiceException e) {
				labelProvider = new LabelProviderServiceImpl();
				localProvider = true;
			}

			final BrowseProfilesDialog dlg = new BrowseProfilesDialog(parentWindow.getShell(), labelProvider);

			parentShell.getDisplay().syncExec(new Runnable() {

				public void run() {
					dlg.setBlockOnOpen(true);
					dlg.open();
				}
			});

			if(localProvider) {
				try {
					labelProvider.disposeService();
				} catch (ServiceException e) {
					Activator.log.error(e);
				}
			}

			if(dlg.getSelectedProfileURI() != null) {
				result = UML2Util.load(modelSet, dlg.getSelectedProfileURI(), UMLPackage.Literals.PROFILE);
			}

			return result;
		}
	}
}
