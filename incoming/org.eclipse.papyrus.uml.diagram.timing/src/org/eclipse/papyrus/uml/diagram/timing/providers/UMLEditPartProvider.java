/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.providers;

import java.lang.ref.WeakReference;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimingDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.UMLEditPartFactory;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLVisualIDRegistry;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class UMLEditPartProvider extends AbstractEditPartProvider {

	/**
	 * @generated
	 */
	private EditPartFactory factory;

	/**
	 * @generated
	 */
	private boolean allowCaching;

	/**
	 * @generated
	 */
	private WeakReference cachedPart;

	/**
	 * @generated
	 */
	private WeakReference cachedView;

	/**
	 * @generated
	 */
	public UMLEditPartProvider() {
		setFactory(new UMLEditPartFactory());
		setAllowCaching(true);
	}

	/**
	 * @generated
	 */
	public final EditPartFactory getFactory() {
		return this.factory;
	}

	/**
	 * @generated
	 */
	protected void setFactory(final EditPartFactory factory) {
		this.factory = factory;
	}

	/**
	 * @generated
	 */
	public final boolean isAllowCaching() {
		return this.allowCaching;
	}

	/**
	 * @generated
	 */
	protected synchronized void setAllowCaching(final boolean allowCaching) {
		this.allowCaching = allowCaching;
		if (!allowCaching) {
			this.cachedPart = null;
			this.cachedView = null;
		}
	}

	/**
	 * @generated
	 */
	protected IGraphicalEditPart createEditPart(final View view) {
		final EditPart part = this.factory.createEditPart(null, view);
		if (part instanceof IGraphicalEditPart) {
			return (IGraphicalEditPart) part;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected IGraphicalEditPart getCachedPart(final View view) {
		if (this.cachedView != null && this.cachedView.get() == view) {
			return (IGraphicalEditPart) this.cachedPart.get();
		}
		return null;
	}

	/**
	 * @generated
	 */
	@Override
	public synchronized IGraphicalEditPart createGraphicEditPart(final View view) {
		if (isAllowCaching()) {
			final IGraphicalEditPart part = getCachedPart(view);
			this.cachedPart = null;
			this.cachedView = null;
			if (part != null) {
				return part;
			}
		}
		return createEditPart(view);
	}

	/**
	 * @generated
	 */
	@Override
	public synchronized boolean provides(final IOperation operation) {
		if (operation instanceof CreateGraphicEditPartOperation) {
			final View view = ((IEditPartOperation) operation).getView();
			if (!TimingDiagramEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(view))) {
				return false;
			}
			if (isAllowCaching() && getCachedPart(view) != null) {
				return true;
			}
			final IGraphicalEditPart part = createEditPart(view);
			if (part != null) {
				if (isAllowCaching()) {
					this.cachedPart = new WeakReference(part);
					this.cachedView = new WeakReference(view);
				}
				return true;
			}
		}
		return false;
	}
}
