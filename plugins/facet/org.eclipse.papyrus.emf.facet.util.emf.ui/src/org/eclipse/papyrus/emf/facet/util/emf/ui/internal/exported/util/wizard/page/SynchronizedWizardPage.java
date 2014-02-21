/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.util.emf.ui.internal.exported.util.wizard.page;

import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.AbstractExceptionFreeRunnable;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.AbstractVoidExceptionFreeRunnable;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.SynchronizedObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

/**
 * Synchronized class for safe run.
 * 
 * @author amenager_stage
 * @since 0.3
 * 
 */
public class SynchronizedWizardPage<WP extends IWizardPage> extends
		SynchronizedObject<WP>
		implements IWizardPage {

	/**
	 * Constructor.
	 * 
	 * @param object
	 *            the to synchronized.
	 * @param display
	 *            the display.
	 */
	public SynchronizedWizardPage(final WP object,
			final Display display) {
		super(object, display);
	}

	public void createControl(final Composite parent) {
		this.voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedWizardPage.this.getSynchronizedObject()
						.createControl(parent);
			}
		});
	}

	public void dispose() {
		this.voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedWizardPage.this.getSynchronizedObject().dispose();
			}
		});
	}

	public Control getControl() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<Control>() {
			@Override
			public Control safeRun() {
				return SynchronizedWizardPage.this.getSynchronizedObject()
						.getControl();
			}
		});
	}

	public String getDescription() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<String>() {
			@Override
			public String safeRun() {
				return SynchronizedWizardPage.this.getSynchronizedObject()
						.getDescription();
			}
		});
	}

	public String getErrorMessage() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<String>() {
			@Override
			public String safeRun() {
				return SynchronizedWizardPage.this.getSynchronizedObject()
						.getErrorMessage();
			}
		});
	}

	public Image getImage() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<Image>() {
			@Override
			public Image safeRun() {
				return SynchronizedWizardPage.this.getSynchronizedObject()
						.getImage();
			}
		});
	}

	public String getMessage() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<String>() {
			@Override
			public String safeRun() {
				return SynchronizedWizardPage.this.getSynchronizedObject()
						.getMessage();
			}
		});
	}

	public String getTitle() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<String>() {
			@Override
			public String safeRun() {
				return SynchronizedWizardPage.this.getSynchronizedObject()
						.getTitle();
			}
		});
	}

	public void performHelp() {
		this.voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedWizardPage.this.getSynchronizedObject()
						.performHelp();
			}
		});
	}

	public void setDescription(final String description) {
		this.voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedWizardPage.this.getSynchronizedObject()
						.setDescription(description);
			}
		});
	}

	public void setImageDescriptor(final ImageDescriptor image) {
		this.voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedWizardPage.this.getSynchronizedObject()
						.setImageDescriptor(image);
			}
		});
	}

	public void setTitle(final String title) {
		this.voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedWizardPage.this.getSynchronizedObject().setTitle(
						title);
			}
		});
	}

	public void setVisible(final boolean visible) {
		this.voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedWizardPage.this.getSynchronizedObject().setVisible(
						visible);
			}
		});
	}

	public boolean canFlipToNextPage() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<Boolean>() {
			@Override
			public Boolean safeRun() {
				return Boolean.valueOf(SynchronizedWizardPage.this
						.getSynchronizedObject()
						.canFlipToNextPage());
			}
		}).booleanValue();
	}

	public IWizardPage getNextPage() {
		return this
				.safeSyncExec(new AbstractExceptionFreeRunnable<IWizardPage>() {
					@Override
					public IWizardPage safeRun() {
						return SynchronizedWizardPage.this
								.getSynchronizedObject().getNextPage();
					}
				});
	}

	public IWizardPage getPreviousPage() {
		return this
				.safeSyncExec(new AbstractExceptionFreeRunnable<IWizardPage>() {
					@Override
					public IWizardPage safeRun() {
						return SynchronizedWizardPage.this
								.getSynchronizedObject().getPreviousPage();
					}
				});
	}

	public IWizard getWizard() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<IWizard>() {
			@Override
			public IWizard safeRun() {
				return SynchronizedWizardPage.this.getSynchronizedObject()
						.getWizard();
			}
		});
	}

	public boolean isPageComplete() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<Boolean>() {
			@Override
			public Boolean safeRun() {
				return Boolean.valueOf(SynchronizedWizardPage.this
						.getSynchronizedObject().isPageComplete());
			}
		}).booleanValue();
	}

	public void setPreviousPage(final IWizardPage page) {
		this.voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedWizardPage.this.getSynchronizedObject()
						.setPreviousPage(page);
			}
		});
	}

	public void setWizard(final IWizard newWizard) {
		this.voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedWizardPage.this.getSynchronizedObject().setWizard(
						newWizard);
			}
		});
	}

	public String getName() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<String>() {
			@Override
			public String safeRun() {
				return SynchronizedWizardPage.this.getSynchronizedObject()
						.getName();
			}
		});
	}
}
