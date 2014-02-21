/** 
 * Copyright (c) 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 */

package org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.sync.generated;

import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.SynchronizedObject;
import org.eclipse.swt.widgets.Display;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.AbstractVoidExceptionFreeRunnable;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.AbstractExceptionFreeRunnable;

@SuppressWarnings("PMD.ExcessivePublicCount")
public class SynchronizedEStructuralFeatureWidget extends SynchronizedObject<org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.IEStructuralFeatureWidget> implements org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.IEStructuralFeatureWidget {

	public SynchronizedEStructuralFeatureWidget(final org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.IEStructuralFeatureWidget object, final Display display) {
		super(object, display);
	}
	public final void addListener(final org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.AbstractWidget parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().addListener(parm0);
			}
		});
	}
	
	public final void createWidgetContent() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().createWidgetContent();
			}
		});
	}
	
	public final java.lang.String getError() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<java.lang.String>() {
			@Override
			public java.lang.String safeRun() {
				return SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().getError();
			}
		});
	}
	
	public final void notifyChanged() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().notifyChanged();
			}
		});
	}
	
	public final <A> A adapt(final java.lang.Class<A> parm0) {
		return safeSyncExec(new AbstractExceptionFreeRunnable<A>() {
			@Override
			public A safeRun() {
				return SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().adapt(parm0);
			}
		});
	}
	
	public final java.lang.Object getCommand() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<java.lang.Object>() {
			@Override
			public java.lang.Object safeRun() {
				return SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().getCommand();
			}
		});
	}
	
	public final void onDialogValidation() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().onDialogValidation();
			}
		});
	}
	
	public final org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet getContainer() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet>() {
			@Override
			public org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet safeRun() {
				return SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().getContainer();
			}
		});
	}
	
	public final java.lang.String getElementName() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<java.lang.String>() {
			@Override
			public java.lang.String safeRun() {
				return SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().getElementName();
			}
		});
	}
	
	public final org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog<org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget<org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet, org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.IFacetWidget>> pressParentButton() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog<org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget<org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet, org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.IFacetWidget>>>() {
			@Override
			public org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog<org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget<org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet, org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.IFacetWidget>> safeRun() {
				return SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().pressParentButton();
			}
		});
	}
	
	public final void setName(final java.lang.String parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().setName(parm0);
			}
		});
	}
	
	public final org.eclipse.emf.ecore.EClassifier getEType() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<org.eclipse.emf.ecore.EClassifier>() {
			@Override
			public org.eclipse.emf.ecore.EClassifier safeRun() {
				return SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().getEType();
			}
		});
	}
	
	public final java.lang.String getElementTypeName() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<java.lang.String>() {
			@Override
			public java.lang.String safeRun() {
				return SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().getElementTypeName();
			}
		});
	}
	
	public final int getLowerBound() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<Integer>() {
			@Override
			public Integer safeRun() {
				return Integer.valueOf(SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().getLowerBound());
			}
		}).intValue();
	}
	
	public final int getUpperBound() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<Integer>() {
			@Override
			public Integer safeRun() {
				return Integer.valueOf(SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().getUpperBound());
			}
		}).intValue();
	}
	
	public final boolean isOrdered() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<Boolean>() {
			@Override
			public Boolean safeRun() {
				return Boolean.valueOf(SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().isOrdered());
			}
		}).booleanValue();
	}
	
	public final boolean isUnique() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<Boolean>() {
			@Override
			public Boolean safeRun() {
				return Boolean.valueOf(SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().isUnique());
			}
		}).booleanValue();
	}
	
	public final org.eclipse.papyrus.emf.facet.util.emf.ui.internal.exported.wizard.ISelectETypeWizard<org.eclipse.emf.ecore.EClassifier> pressTypeButton() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<org.eclipse.papyrus.emf.facet.util.emf.ui.internal.exported.wizard.ISelectETypeWizard<org.eclipse.emf.ecore.EClassifier>>() {
			@Override
			public org.eclipse.papyrus.emf.facet.util.emf.ui.internal.exported.wizard.ISelectETypeWizard<org.eclipse.emf.ecore.EClassifier> safeRun() {
				return SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().pressTypeButton();
			}
		});
	}
	
	public final void setEType(final org.eclipse.emf.ecore.EClassifier parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().setEType(parm0);
			}
		});
	}
	
	public final void setLowerBound(final int parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().setLowerBound(parm0);
			}
		});
	}
	
	public final void setOrdered(final boolean parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().setOrdered(parm0);
			}
		});
	}
	
	public final void setUnique(final boolean parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().setUnique(parm0);
			}
		});
	}
	
	public final void setUpperBound(final int parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().setUpperBound(parm0);
			}
		});
	}
	
	public final org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query getQuery() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query>() {
			@Override
			public org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query safeRun() {
				return SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().getQuery();
			}
		});
	}
	
	public final java.lang.String getQueryText() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<java.lang.String>() {
			@Override
			public java.lang.String safeRun() {
				return SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().getQueryText();
			}
		});
	}
	
	public final boolean isQueryEnable() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<Boolean>() {
			@Override
			public Boolean safeRun() {
				return Boolean.valueOf(SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().isQueryEnable());
			}
		}).booleanValue();
	}
	
	public final org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog<org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.component.query.ICreateQueryWidget> selectQueryType(final java.lang.String parm0) {
		return safeSyncExec(new AbstractExceptionFreeRunnable<org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog<org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.component.query.ICreateQueryWidget>>() {
			@Override
			public org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog<org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.component.query.ICreateQueryWidget> safeRun() {
				return SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().selectQueryType(parm0);
			}
		});
	}
	
	public final void setQuery(final org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().setQuery(parm0);
			}
		});
	}
	
	public final boolean isChangeable() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<Boolean>() {
			@Override
			public Boolean safeRun() {
				return Boolean.valueOf(SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().isChangeable());
			}
		}).booleanValue();
	}
	
	public final boolean isDerived() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<Boolean>() {
			@Override
			public Boolean safeRun() {
				return Boolean.valueOf(SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().isDerived());
			}
		}).booleanValue();
	}
	
	public final boolean isTransient() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<Boolean>() {
			@Override
			public Boolean safeRun() {
				return Boolean.valueOf(SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().isTransient());
			}
		}).booleanValue();
	}
	
	public final boolean isVolatile() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<Boolean>() {
			@Override
			public Boolean safeRun() {
				return Boolean.valueOf(SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().isVolatile());
			}
		}).booleanValue();
	}
	
	public final void setChangeable(final boolean parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().setChangeable(parm0);
			}
		});
	}
	
	public final void setDerived(final boolean parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().setDerived(parm0);
			}
		});
	}
	
	public final void setTransient(final boolean parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().setTransient(parm0);
			}
		});
	}
	
	public final void setVolatile(final boolean parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedEStructuralFeatureWidget.this.getSynchronizedObject().setVolatile(parm0);
			}
		});
	}
	
}
