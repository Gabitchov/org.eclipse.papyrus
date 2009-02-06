/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *
 * $Id$
 **********************************************************************/

package org.eclipse.papyrus.outline;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.contentoutline.IPapyrusContentOutlinePage;
import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.editor.MultiDiagramEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.navigator.CommonNavigatorOutline;

/**
 * An outline based on the Common Navigator Framework
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques Lescot</a>
 */
public class UMLNavigatorOutline extends CommonNavigatorOutline implements IEditingDomainProvider, IPapyrusContentOutlinePage {

	private IMultiDiagramEditor multiDiagramEditor;

	/**
	 * Constructor
	 */
	public UMLNavigatorOutline() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.CommonNavigatorOutline#getCommonViewerId()
	 */
	@Override
	protected String getCommonViewerId() {
		return MultiDiagramEditor.ID;
	}

	@Override
	protected Object getInitialInput() {
		return getDiagram();
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		hookListeners();
	}

	@Override
	public void dispose() {
		unhookListeners();
		super.dispose();
	}

	protected Diagram getDiagram() {
		return (Diagram) multiDiagramEditor.getDefaultContext().getResourceSet().getNotationResource().getContents().get(0);
	}

	/**
	 * Add listeners : <br>
	 * - on the model<br>
	 */
	protected void hookListeners() {
	}

	/**
	 * Remove listeners
	 */
	protected void unhookListeners() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.edit.domain.IEditingDomainProvider#getEditingDomain()
	 */
	public EditingDomain getEditingDomain() {
		return (EditingDomain) multiDiagramEditor.getAdapter(EditingDomain.class);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void init(IMultiDiagramEditor multiEditor) throws BackboneException {
		multiDiagramEditor = (IMultiDiagramEditor) multiEditor;

	}

}
