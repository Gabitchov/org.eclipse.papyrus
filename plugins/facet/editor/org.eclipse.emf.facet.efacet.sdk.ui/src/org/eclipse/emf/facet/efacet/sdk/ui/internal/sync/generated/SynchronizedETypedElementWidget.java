/** 
 * Copyright (c) 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 */

package org.eclipse.emf.facet.efacet.sdk.ui.internal.sync.generated;

import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.SynchronizedObject;
import org.eclipse.swt.widgets.Display;
import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.AbstractVoidExceptionFreeRunnable;
import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.AbstractExceptionFreeRunnable;

@SuppressWarnings("PMD.ExcessivePublicCount")
public class SynchronizedETypedElementWidget <C extends org.eclipse.emf.ecore.EObject, CW extends java.lang.Object> extends SynchronizedObject<org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IETypedElementWidget <C, CW>> implements org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IETypedElementWidget <C, CW> {

	public SynchronizedETypedElementWidget(final org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IETypedElementWidget <C, CW> object, final Display display) {
		super(object, display);
	}
	public final void addListener(final org.eclipse.emf.facet.util.ui.internal.exported.util.widget.AbstractWidget parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedETypedElementWidget.this.getSynchronizedObject().addListener(parm0);
			}
		});
	}
	
	public final void createWidgetContent() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedETypedElementWidget.this.getSynchronizedObject().createWidgetContent();
			}
		});
	}
	
	public final java.lang.String getError() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<java.lang.String>() {
			@Override
			public java.lang.String safeRun() {
				return SynchronizedETypedElementWidget.this.getSynchronizedObject().getError();
			}
		});
	}
	
	public final void notifyChanged() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedETypedElementWidget.this.getSynchronizedObject().notifyChanged();
			}
		});
	}
	
	public final <A> A adapt(final java.lang.Class<A> parm0) {
		return safeSyncExec(new AbstractExceptionFreeRunnable<A>() {
			@Override
			public A safeRun() {
				return SynchronizedETypedElementWidget.this.getSynchronizedObject().adapt(parm0);
			}
		});
	}
	
	public final java.lang.Object getCommand() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<java.lang.Object>() {
			@Override
			public java.lang.Object safeRun() {
				return SynchronizedETypedElementWidget.this.getSynchronizedObject().getCommand();
			}
		});
	}
	
	public final void onDialogValidation() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedETypedElementWidget.this.getSynchronizedObject().onDialogValidation();
			}
		});
	}
	
	public final C getContainer() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<C>() {
			@Override
			public C safeRun() {
				return SynchronizedETypedElementWidget.this.getSynchronizedObject().getContainer();
			}
		});
	}
	
	public final java.lang.String getElementName() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<java.lang.String>() {
			@Override
			public java.lang.String safeRun() {
				return SynchronizedETypedElementWidget.this.getSynchronizedObject().getElementName();
			}
		});
	}
	
	public final org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog<CW> pressParentButton() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog<CW>>() {
			@Override
			public org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog<CW> safeRun() {
				return SynchronizedETypedElementWidget.this.getSynchronizedObject().pressParentButton();
			}
		});
	}
	
	public final void setName(final java.lang.String parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedETypedElementWidget.this.getSynchronizedObject().setName(parm0);
			}
		});
	}
	
	public final org.eclipse.emf.ecore.EClassifier getEType() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<org.eclipse.emf.ecore.EClassifier>() {
			@Override
			public org.eclipse.emf.ecore.EClassifier safeRun() {
				return SynchronizedETypedElementWidget.this.getSynchronizedObject().getEType();
			}
		});
	}
	
	public final java.lang.String getElementTypeName() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<java.lang.String>() {
			@Override
			public java.lang.String safeRun() {
				return SynchronizedETypedElementWidget.this.getSynchronizedObject().getElementTypeName();
			}
		});
	}
	
	public final int getLowerBound() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<Integer>() {
			@Override
			public Integer safeRun() {
				return Integer.valueOf(SynchronizedETypedElementWidget.this.getSynchronizedObject().getLowerBound());
			}
		}).intValue();
	}
	
	public final int getUpperBound() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<Integer>() {
			@Override
			public Integer safeRun() {
				return Integer.valueOf(SynchronizedETypedElementWidget.this.getSynchronizedObject().getUpperBound());
			}
		}).intValue();
	}
	
	public final boolean isOrdered() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<Boolean>() {
			@Override
			public Boolean safeRun() {
				return Boolean.valueOf(SynchronizedETypedElementWidget.this.getSynchronizedObject().isOrdered());
			}
		}).booleanValue();
	}
	
	public final boolean isUnique() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<Boolean>() {
			@Override
			public Boolean safeRun() {
				return Boolean.valueOf(SynchronizedETypedElementWidget.this.getSynchronizedObject().isUnique());
			}
		}).booleanValue();
	}
	
	public final org.eclipse.emf.facet.util.emf.ui.internal.exported.wizard.ISelectETypeWizard<org.eclipse.emf.ecore.EClassifier> pressTypeButton() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<org.eclipse.emf.facet.util.emf.ui.internal.exported.wizard.ISelectETypeWizard<org.eclipse.emf.ecore.EClassifier>>() {
			@Override
			public org.eclipse.emf.facet.util.emf.ui.internal.exported.wizard.ISelectETypeWizard<org.eclipse.emf.ecore.EClassifier> safeRun() {
				return SynchronizedETypedElementWidget.this.getSynchronizedObject().pressTypeButton();
			}
		});
	}
	
	public final void setEType(final org.eclipse.emf.ecore.EClassifier parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedETypedElementWidget.this.getSynchronizedObject().setEType(parm0);
			}
		});
	}
	
	public final void setLowerBound(final int parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedETypedElementWidget.this.getSynchronizedObject().setLowerBound(parm0);
			}
		});
	}
	
	public final void setOrdered(final boolean parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedETypedElementWidget.this.getSynchronizedObject().setOrdered(parm0);
			}
		});
	}
	
	public final void setUnique(final boolean parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedETypedElementWidget.this.getSynchronizedObject().setUnique(parm0);
			}
		});
	}
	
	public final void setUpperBound(final int parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedETypedElementWidget.this.getSynchronizedObject().setUpperBound(parm0);
			}
		});
	}
	
}
