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
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.sync.generated;

import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.SynchronizedObject;
import org.eclipse.swt.widgets.Display;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.AbstractVoidExceptionFreeRunnable;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.AbstractExceptionFreeRunnable;

@SuppressWarnings("PMD.ExcessivePublicCount")
public class SynchronizedFacetWidget extends SynchronizedObject<org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.IFacetWidget> implements org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.IFacetWidget {

	public SynchronizedFacetWidget(final org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.IFacetWidget object, final Display display) {
		super(object, display);
	}
	public final void addListener(final org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.AbstractWidget parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedFacetWidget.this.getSynchronizedObject().addListener(parm0);
			}
		});
	}
	
	public final void createWidgetContent() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedFacetWidget.this.getSynchronizedObject().createWidgetContent();
			}
		});
	}
	
	public final java.lang.String getError() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<java.lang.String>() {
			@Override
			public java.lang.String safeRun() {
				return SynchronizedFacetWidget.this.getSynchronizedObject().getError();
			}
		});
	}
	
	public final void notifyChanged() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedFacetWidget.this.getSynchronizedObject().notifyChanged();
			}
		});
	}
	
	public final <A> A adapt(final java.lang.Class<A> parm0) {
		return safeSyncExec(new AbstractExceptionFreeRunnable<A>() {
			@Override
			public A safeRun() {
				return SynchronizedFacetWidget.this.getSynchronizedObject().adapt(parm0);
			}
		});
	}
	
	public final java.lang.Object getCommand() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<java.lang.Object>() {
			@Override
			public java.lang.Object safeRun() {
				return SynchronizedFacetWidget.this.getSynchronizedObject().getCommand();
			}
		});
	}
	
	public final void onDialogValidation() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedFacetWidget.this.getSynchronizedObject().onDialogValidation();
			}
		});
	}
	
	public final org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet getContainer() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet>() {
			@Override
			public org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet safeRun() {
				return SynchronizedFacetWidget.this.getSynchronizedObject().getContainer();
			}
		});
	}
	
	public final java.lang.String getElementName() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<java.lang.String>() {
			@Override
			public java.lang.String safeRun() {
				return SynchronizedFacetWidget.this.getSynchronizedObject().getElementName();
			}
		});
	}
	
	public final org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog<org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.creation.IGetOrCreateFilteredFacetSetWidget> pressParentButton() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog<org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.creation.IGetOrCreateFilteredFacetSetWidget>>() {
			@Override
			public org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog<org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.creation.IGetOrCreateFilteredFacetSetWidget> safeRun() {
				return SynchronizedFacetWidget.this.getSynchronizedObject().pressParentButton();
			}
		});
	}
	
	public final void setName(final java.lang.String parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedFacetWidget.this.getSynchronizedObject().setName(parm0);
			}
		});
	}
	
	public final org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.component.metaclass.IGetExtendedMetaclassWidget getGetExtendedMetaclassWidget() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.component.metaclass.IGetExtendedMetaclassWidget>() {
			@Override
			public org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.component.metaclass.IGetExtendedMetaclassWidget safeRun() {
				return SynchronizedFacetWidget.this.getSynchronizedObject().getGetExtendedMetaclassWidget();
			}
		});
	}
	
	public final java.lang.String getSubTypingFacet() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<java.lang.String>() {
			@Override
			public java.lang.String safeRun() {
				return SynchronizedFacetWidget.this.getSynchronizedObject().getSubTypingFacet();
			}
		});
	}
	
	public final org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog<org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget<org.eclipse.emf.ecore.ETypedElement, java.lang.Object>> pressSubTypingButton() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog<org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget<org.eclipse.emf.ecore.ETypedElement, java.lang.Object>>>() {
			@Override
			public org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog<org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget<org.eclipse.emf.ecore.ETypedElement, java.lang.Object>> safeRun() {
				return SynchronizedFacetWidget.this.getSynchronizedObject().pressSubTypingButton();
			}
		});
	}
	
	public final void setSubTypingFacetSelection(final boolean parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedFacetWidget.this.getSynchronizedObject().setSubTypingFacetSelection(parm0);
			}
		});
	}
	
}
