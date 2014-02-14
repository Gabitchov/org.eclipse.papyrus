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
public class SynchronizedDerivedTypedElementWidget extends SynchronizedObject<org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IDerivedTypedElementWidget> implements org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IDerivedTypedElementWidget {

	public SynchronizedDerivedTypedElementWidget(final org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IDerivedTypedElementWidget object, final Display display) {
		super(object, display);
	}
	public final void addListener(final org.eclipse.emf.facet.util.ui.internal.exported.util.widget.AbstractWidget parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedDerivedTypedElementWidget.this.getSynchronizedObject().addListener(parm0);
			}
		});
	}
	
	public final void createWidgetContent() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedDerivedTypedElementWidget.this.getSynchronizedObject().createWidgetContent();
			}
		});
	}
	
	public final java.lang.String getError() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<java.lang.String>() {
			@Override
			public java.lang.String safeRun() {
				return SynchronizedDerivedTypedElementWidget.this.getSynchronizedObject().getError();
			}
		});
	}
	
	public final void notifyChanged() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedDerivedTypedElementWidget.this.getSynchronizedObject().notifyChanged();
			}
		});
	}
	
	public final <A> A adapt(final java.lang.Class<A> parm0) {
		return safeSyncExec(new AbstractExceptionFreeRunnable<A>() {
			@Override
			public A safeRun() {
				return SynchronizedDerivedTypedElementWidget.this.getSynchronizedObject().adapt(parm0);
			}
		});
	}
	
	public final java.lang.Object getCommand() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<java.lang.Object>() {
			@Override
			public java.lang.Object safeRun() {
				return SynchronizedDerivedTypedElementWidget.this.getSynchronizedObject().getCommand();
			}
		});
	}
	
	public final void onDialogValidation() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedDerivedTypedElementWidget.this.getSynchronizedObject().onDialogValidation();
			}
		});
	}
	
	public final org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet getContainer() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet>() {
			@Override
			public org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet safeRun() {
				return SynchronizedDerivedTypedElementWidget.this.getSynchronizedObject().getContainer();
			}
		});
	}
	
	public final java.lang.String getElementName() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<java.lang.String>() {
			@Override
			public java.lang.String safeRun() {
				return SynchronizedDerivedTypedElementWidget.this.getSynchronizedObject().getElementName();
			}
		});
	}
	
	public final org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog<org.eclipse.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget<org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet, org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IFacetWidget>> pressParentButton() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog<org.eclipse.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget<org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet, org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IFacetWidget>>>() {
			@Override
			public org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog<org.eclipse.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget<org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet, org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IFacetWidget>> safeRun() {
				return SynchronizedDerivedTypedElementWidget.this.getSynchronizedObject().pressParentButton();
			}
		});
	}
	
	public final void setName(final java.lang.String parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedDerivedTypedElementWidget.this.getSynchronizedObject().setName(parm0);
			}
		});
	}
	
	public final org.eclipse.emf.ecore.EClassifier getEType() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<org.eclipse.emf.ecore.EClassifier>() {
			@Override
			public org.eclipse.emf.ecore.EClassifier safeRun() {
				return SynchronizedDerivedTypedElementWidget.this.getSynchronizedObject().getEType();
			}
		});
	}
	
	public final java.lang.String getElementTypeName() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<java.lang.String>() {
			@Override
			public java.lang.String safeRun() {
				return SynchronizedDerivedTypedElementWidget.this.getSynchronizedObject().getElementTypeName();
			}
		});
	}
	
	public final int getLowerBound() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<Integer>() {
			@Override
			public Integer safeRun() {
				return Integer.valueOf(SynchronizedDerivedTypedElementWidget.this.getSynchronizedObject().getLowerBound());
			}
		}).intValue();
	}
	
	public final int getUpperBound() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<Integer>() {
			@Override
			public Integer safeRun() {
				return Integer.valueOf(SynchronizedDerivedTypedElementWidget.this.getSynchronizedObject().getUpperBound());
			}
		}).intValue();
	}
	
	public final boolean isOrdered() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<Boolean>() {
			@Override
			public Boolean safeRun() {
				return Boolean.valueOf(SynchronizedDerivedTypedElementWidget.this.getSynchronizedObject().isOrdered());
			}
		}).booleanValue();
	}
	
	public final boolean isUnique() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<Boolean>() {
			@Override
			public Boolean safeRun() {
				return Boolean.valueOf(SynchronizedDerivedTypedElementWidget.this.getSynchronizedObject().isUnique());
			}
		}).booleanValue();
	}
	
	public final org.eclipse.emf.facet.util.emf.ui.internal.exported.wizard.ISelectETypeWizard<org.eclipse.emf.ecore.EClassifier> pressTypeButton() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<org.eclipse.emf.facet.util.emf.ui.internal.exported.wizard.ISelectETypeWizard<org.eclipse.emf.ecore.EClassifier>>() {
			@Override
			public org.eclipse.emf.facet.util.emf.ui.internal.exported.wizard.ISelectETypeWizard<org.eclipse.emf.ecore.EClassifier> safeRun() {
				return SynchronizedDerivedTypedElementWidget.this.getSynchronizedObject().pressTypeButton();
			}
		});
	}
	
	public final void setEType(final org.eclipse.emf.ecore.EClassifier parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedDerivedTypedElementWidget.this.getSynchronizedObject().setEType(parm0);
			}
		});
	}
	
	public final void setLowerBound(final int parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedDerivedTypedElementWidget.this.getSynchronizedObject().setLowerBound(parm0);
			}
		});
	}
	
	public final void setOrdered(final boolean parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedDerivedTypedElementWidget.this.getSynchronizedObject().setOrdered(parm0);
			}
		});
	}
	
	public final void setUnique(final boolean parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedDerivedTypedElementWidget.this.getSynchronizedObject().setUnique(parm0);
			}
		});
	}
	
	public final void setUpperBound(final int parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedDerivedTypedElementWidget.this.getSynchronizedObject().setUpperBound(parm0);
			}
		});
	}
	
	public final org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query getQuery() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query>() {
			@Override
			public org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query safeRun() {
				return SynchronizedDerivedTypedElementWidget.this.getSynchronizedObject().getQuery();
			}
		});
	}
	
	public final java.lang.String getQueryText() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<java.lang.String>() {
			@Override
			public java.lang.String safeRun() {
				return SynchronizedDerivedTypedElementWidget.this.getSynchronizedObject().getQueryText();
			}
		});
	}
	
	public final boolean isQueryEnable() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<Boolean>() {
			@Override
			public Boolean safeRun() {
				return Boolean.valueOf(SynchronizedDerivedTypedElementWidget.this.getSynchronizedObject().isQueryEnable());
			}
		}).booleanValue();
	}
	
	public final org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog<org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.component.query.ICreateQueryWidget> selectQueryType(final java.lang.String parm0) {
		return safeSyncExec(new AbstractExceptionFreeRunnable<org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog<org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.component.query.ICreateQueryWidget>>() {
			@Override
			public org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog<org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.component.query.ICreateQueryWidget> safeRun() {
				return SynchronizedDerivedTypedElementWidget.this.getSynchronizedObject().selectQueryType(parm0);
			}
		});
	}
	
	public final void setQuery(final org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedDerivedTypedElementWidget.this.getSynchronizedObject().setQuery(parm0);
			}
		});
	}
	
}
