/**
 *  Copyright (c) 2012 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *      Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *      Nicolas Bros (Mia-Software) - Bug 372626 - Aggregates
 */
package org.eclipse.papyrus.emf.facet.custom.ui.internal.dialog;

import java.util.List;

import org.eclipse.papyrus.emf.facet.custom.ui.internal.exported.dialog.ILoadCustomizationsDialog;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.exported.exception.IllegalParameterException;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialogCallbackWithPreCommit;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.AbstractExceptionFreeRunnable;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.AbstractVoidExceptionFreeRunnable;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.AbstractVoidRunnable;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.SynchronizedObject;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SynchronizedLoadCustomizationsDialog<D> extends
		SynchronizedObject<LoadCustomizationsDialog<D>> implements
		ILoadCustomizationsDialog<D> { // NOPMD by gdupe on 03/02/12 12:13 - We cannot do more. This class is a facade/wrapper of an other class.

	public SynchronizedLoadCustomizationsDialog(final Shell parent,
			final List<Customization> availableCustoms,
			final List<Customization> selectedCustoms,
			final List<Customization> lockedCustoms,
			final IDialogCallbackWithPreCommit<List<Customization>, Boolean, D> callback,
			final String lockMsg) {
		super(new LoadCustomizationsDialog(parent, availableCustoms,
				selectedCustoms, lockedCustoms, callback, lockMsg),
				initDisplay(parent));
	}

	private static Display initDisplay(final Shell parent) {
		Display display;
		if (parent == null) {
			display = Display.getDefault();
		} else {
			display = parent.getDisplay();
		}
		return display;
	}

	public int open() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<Integer>() {
			@Override
			public Integer safeRun() {
				return Integer.valueOf(SynchronizedLoadCustomizationsDialog.this
						.getSynchronizedObject().open());
			}
		}).intValue();
	}

	public void asyncOpen() {
		this.voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedLoadCustomizationsDialog.this
						.getSynchronizedObject().asyncOpen();
			}
		});
	}

	public D pressOk() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<D>() {
			@Override
			public D safeRun() {
				return SynchronizedLoadCustomizationsDialog.this
						.getSynchronizedObject().pressOk();
			}
		});
	}

	public void selectAvailableCustom(final Customization customization) {
		this.voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedLoadCustomizationsDialog.this
						.getSynchronizedObject().selectAvailableCustom(
								customization);
			}
		});
	}

	public void loadSelectedCustoms() {
		this.voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedLoadCustomizationsDialog.this
						.getSynchronizedObject().loadSelectedCustoms();
			}
		});
	}

	public void selectSelectedCustom(final Customization customization) {
		this.voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedLoadCustomizationsDialog.this
						.getSynchronizedObject().selectSelectedCustom(
								customization);
			}
		});
	}

	public void unloadSelectedCustoms() {
		this.voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedLoadCustomizationsDialog.this
						.getSynchronizedObject().unloadSelectedCustoms();
			}
		});
	}

	public void addCustomization(final Customization customization)
			throws IllegalParameterException {
		voidSyncExec(new AbstractVoidRunnable<IllegalParameterException>() {
			@Override
			public void voidRun() throws IllegalParameterException {
				getSynchronizedObject().addCustomization(customization);
			}
		});
	}

	public void addCustomizations(final List<Customization> customizations)
			throws IllegalParameterException {
		voidSyncExec(new AbstractVoidRunnable<IllegalParameterException>() {
			@Override
			public void voidRun() throws IllegalParameterException {
				getSynchronizedObject().addCustomizations(customizations);
			}
		});
	}

	public void removeCustomization(final Customization customization)
			throws IllegalParameterException {
		voidSyncExec(new AbstractVoidRunnable<IllegalParameterException>() {
			@Override
			public void voidRun() throws IllegalParameterException {
				getSynchronizedObject().removeCustomization(customization);
			}
		});
	}

	public void removeCustomizations(final List<Customization> customizations)
			throws IllegalParameterException {
		voidSyncExec(new AbstractVoidRunnable<IllegalParameterException>() {
			@Override
			public void voidRun() throws IllegalParameterException {
				getSynchronizedObject().removeCustomizations(customizations);
			}
		});
	}

	public void cancel() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				getSynchronizedObject().cancel();
			}
		});
	}

	public void validate() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				getSynchronizedObject().validate();
			}
		});
	}

	public List<Customization> getSelectedCustomizations() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<List<Customization>>() {
			@Override
			public List<Customization> safeRun() {
				return getSynchronizedObject().getSelectedCustomizations();
			}
		});
	}

	public List<Customization> getAvailableCustomizations() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<List<Customization>>() {
			@Override
			public List<Customization> safeRun() {
				return getSynchronizedObject().getAvailableCustomizations();
			}
		});
	}

	public void pushUp(final Customization customization)
			throws IllegalParameterException {
		voidSyncExec(new AbstractVoidRunnable<IllegalParameterException>() {
			@Override
			public void voidRun() throws IllegalParameterException {
				getSynchronizedObject().pushUp(customization);
			}
		});
	}

	public void pushDown(final Customization customization)
			throws IllegalParameterException {
		voidSyncExec(new AbstractVoidRunnable<IllegalParameterException>() {
			@Override
			public void voidRun() throws IllegalParameterException {
				getSynchronizedObject().pushDown(customization);
			}
		});
	}

}
