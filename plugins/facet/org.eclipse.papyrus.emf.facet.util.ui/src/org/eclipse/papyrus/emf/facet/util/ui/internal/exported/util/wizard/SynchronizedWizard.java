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
package org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.wizard;

import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.AbstractExceptionFreeRunnable;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.AbstractVoidExceptionFreeRunnable;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.SynchronizedObject;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.wizard.IExtendedWizard;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

/**
 * Synchronized class for safe run.
 * 
 * @see WizardFactoryImpl
 * @since 0.3
 */
public class SynchronizedWizard<T extends IExtendedWizard> extends
		SynchronizedObject<T> implements IExtendedWizard {

	/**
	 * Constructor.
	 * 
	 * @param object
	 *            the to synchronized.
	 * @param display
	 *            the display.
	 */
	public SynchronizedWizard(final T object, final Display display) {
		super(object, display);
	}

	public int open() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<Integer>() {
			@Override
			public Integer safeRun() {
				return Integer.valueOf(SynchronizedWizard.this
						.getSynchronizedObject().open());
			}
		}).intValue();
	}

	public IWizardPage getCurrentPage() {
		return this
				.safeSyncExec(new AbstractExceptionFreeRunnable<IWizardPage>() {
					@Override
					public IWizardPage safeRun() {
						return SynchronizedWizard.this.getSynchronizedObject()
								.getCurrentPage();
					}
				});
	}

	public IWizardPage next() {
		return this
				.safeSyncExec(new AbstractExceptionFreeRunnable<IWizardPage>() {
					@Override
					public IWizardPage safeRun() {
						return SynchronizedWizard.this.getSynchronizedObject()
								.next();
					}
				});
	}

	public IWizardPage previous() {
		return this
				.safeSyncExec(new AbstractExceptionFreeRunnable<IWizardPage>() {
					@Override
					public IWizardPage safeRun() {
						return SynchronizedWizard.this.getSynchronizedObject()
								.previous();
					}
				});
	}

	public boolean finish() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<Boolean>() {
			@Override
			public Boolean safeRun() {
				return Boolean.valueOf(SynchronizedWizard.this
						.getSynchronizedObject().finish());
			}
		}).booleanValue();
	}

	public void addPages() {
		this.voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedWizard.this.getSynchronizedObject().addPages();
			}
		});
	}

	public boolean canFinish() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<Boolean>() {
			@Override
			public Boolean safeRun() {
				return Boolean.valueOf(SynchronizedWizard.this
						.getSynchronizedObject().canFinish());
			}
		}).booleanValue();
	}

	public void createPageControls(final Composite pageContainer) {
		this.voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedWizard.this.getSynchronizedObject()
						.createPageControls(pageContainer);
			}
		});
	}

	public void dispose() {
		this.voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedWizard.this.getSynchronizedObject().dispose();
			}
		});
	}

	public IWizardContainer getContainer() {
		return this
				.safeSyncExec(new AbstractExceptionFreeRunnable<IWizardContainer>() {
					@Override
					public IWizardContainer safeRun() {
						return SynchronizedWizard.this.getSynchronizedObject()
								.getContainer();
					}
				});
	}

	public Image getDefaultPageImage() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<Image>() {
			@Override
			public Image safeRun() {
				return SynchronizedWizard.this.getSynchronizedObject()
						.getDefaultPageImage();
			}
		});
	}

	public IDialogSettings getDialogSettings() {
		return this
				.safeSyncExec(new AbstractExceptionFreeRunnable<IDialogSettings>() {
					@Override
					public IDialogSettings safeRun() {
						return SynchronizedWizard.this.getSynchronizedObject()
								.getDialogSettings();
					}
				});
	}

	public IWizardPage getNextPage(final IWizardPage page) {
		return this
				.safeSyncExec(new AbstractExceptionFreeRunnable<IWizardPage>() {
					@Override
					public IWizardPage safeRun() {
						return SynchronizedWizard.this.getSynchronizedObject()
								.getNextPage(page);
					}
				});
	}

	public IWizardPage getPage(final String pageName) {
		return this
				.safeSyncExec(new AbstractExceptionFreeRunnable<IWizardPage>() {
					@Override
					public IWizardPage safeRun() {
						return SynchronizedWizard.this.getSynchronizedObject()
								.getPage(pageName);
					}
				});
	}

	public int getPageCount() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<Integer>() {
			@Override
			public Integer safeRun() {
				return Integer.valueOf(SynchronizedWizard.this
						.getSynchronizedObject().getPageCount());
			}
		}).intValue();
	}

	public IWizardPage[] getPages() {
		return this
				.safeSyncExec(new AbstractExceptionFreeRunnable<IWizardPage[]>() {
					@Override
					public IWizardPage[] safeRun() {
						return SynchronizedWizard.this.getSynchronizedObject()
								.getPages();
					}
				});
	}

	public IWizardPage getPreviousPage(final IWizardPage page) {
		return this
				.safeSyncExec(new AbstractExceptionFreeRunnable<IWizardPage>() {
					@Override
					public IWizardPage safeRun() {
						return SynchronizedWizard.this.getSynchronizedObject()
								.getPreviousPage(page);
					}
				});
	}

	public IWizardPage getStartingPage() {
		return this
				.safeSyncExec(new AbstractExceptionFreeRunnable<IWizardPage>() {
					@Override
					public IWizardPage safeRun() {
						return SynchronizedWizard.this.getSynchronizedObject()
								.getStartingPage();
					}
				});
	}

	public RGB getTitleBarColor() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<RGB>() {
			@Override
			public RGB safeRun() {
				return SynchronizedWizard.this.getSynchronizedObject()
						.getTitleBarColor();
			}
		});
	}

	public String getWindowTitle() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<String>() {
			@Override
			public String safeRun() {
				return SynchronizedWizard.this.getSynchronizedObject()
						.getWindowTitle();
			}
		});
	}

	public boolean isHelpAvailable() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<Boolean>() {
			@Override
			public Boolean safeRun() {
				return Boolean.valueOf(SynchronizedWizard.this
						.getSynchronizedObject().isHelpAvailable());
			}
		}).booleanValue();
	}

	public boolean needsPreviousAndNextButtons() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<Boolean>() {
			@Override
			public Boolean safeRun() {
				return Boolean.valueOf(SynchronizedWizard.this
						.getSynchronizedObject().needsPreviousAndNextButtons());
			}
		}).booleanValue();
	}

	public boolean needsProgressMonitor() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<Boolean>() {
			@Override
			public Boolean safeRun() {
				return Boolean.valueOf(SynchronizedWizard.this
						.getSynchronizedObject().needsProgressMonitor());
			}
		}).booleanValue();
	}

	public boolean performCancel() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<Boolean>() {
			@Override
			public Boolean safeRun() {
				return Boolean.valueOf(SynchronizedWizard.this
						.getSynchronizedObject().performCancel());
			}
		}).booleanValue();
	}

	public boolean performFinish() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<Boolean>() {
			@Override
			public Boolean safeRun() {
				return Boolean.valueOf(SynchronizedWizard.this
						.getSynchronizedObject().performFinish());
			}
		}).booleanValue();
	}

	public void setContainer(final IWizardContainer wizardContainer) {
		this.voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedWizard.this.getSynchronizedObject().setContainer(
						wizardContainer);
			}
		});
	}
}
