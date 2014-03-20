/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.query.ocl.sdk.ui.internal.widget.query;

import org.eclipse.papyrus.emf.facet.query.ocl.sdk.ui.widget.IOclQueryWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.AbstractExceptionFreeRunnable;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.AbstractVoidExceptionFreeRunnable;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.SynchronizedObject;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.AbstractWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.widget.IAbstractWidget;
import org.eclipse.swt.widgets.Display;

public class SynchonizedOclQueryWidget extends
		SynchronizedObject<OclQueryWidget> implements IOclQueryWidget,
		IAbstractWidget {

	public SynchonizedOclQueryWidget(final OclQueryWidget widget,
			final Display display) {
		super(widget, display);
	}

	public void setExpression(final String expression) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchonizedOclQueryWidget.this.getSynchronizedObject()
						.setExpression(expression);
			}
		});
	}

	public void addListener(final AbstractWidget abstractWidget) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchonizedOclQueryWidget.this.getSynchronizedObject()
						.addListener(abstractWidget);
			}
		});
	}

	public void notifyChanged() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchonizedOclQueryWidget.this.getSynchronizedObject()
						.notifyChanged();
			}
		});
	}

	public void createWidgetContent() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchonizedOclQueryWidget.this.getSynchronizedObject()
						.createWidgetContent();
			}
		});
	}

	public String getError() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<String>() {
			@Override
			public String safeRun() {
				// TODO Auto-generated method stub
				return SynchonizedOclQueryWidget.this.getSynchronizedObject()
						.getError();
			}
		});
	}

}
