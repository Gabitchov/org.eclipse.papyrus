/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST- Initial API and implementation
 *   Nizar GUEDIDI (CEA LIST)- modification
 *   Christian W. Damus (CEA) - bug 392301
 *
 ****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.requirement;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.sysml.diagram.requirement.part.RequirementDiagramEditor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;

/**
 * An editor to be used in multitabs editor. This editor extends the original UML Diagram.
 * 
 */
public class RequirementDiagramForMultiEditor extends RequirementDiagramEditor {

	/**
	 * The location of diagram icon in the plug-in
	 */
	private static final String DIAG_IMG_PATH = "icons/obj16/Diagram_Requirement.gif";

	/**
	 * The image descriptor of the diagram icon
	 */
	private static final ImageDescriptor DIAG_IMG_DESC = Activator.getBundledImageDescriptor(RequirementDiagramForMultiEditor.DIAG_IMG_PATH);

	/** The editor splitter. */
	private Composite splitter;
	
	private Image titleImage;

	/**
	 * Constructor for SashSystem v2. Context and required objects are retrieved from the
	 * ServiceRegistry.
	 * 
	 * @throws BackboneException
	 * @throws ServiceException
	 * 
	 */
	public RequirementDiagramForMultiEditor(ServicesRegistry servicesRegistry, Diagram diagram) throws BackboneException, ServiceException {
		super(servicesRegistry, diagram);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		setPartName(getDiagram().getName());
		titleImage = DIAG_IMG_DESC.createImage();
		setTitleImage(titleImage);
	}

	@Override
	public void dispose() {
		if(titleImage != null) {
			titleImage.dispose();
			titleImage = null;
		}
		
		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setInput(IEditorInput input) {
		try {
			// Provide an URI with fragment in order to reuse the same Resource
			// and set the diagram to the fragment.
			URIEditorInput uriInput = new URIEditorInput(EcoreUtil.getURI(getDiagram()));
			doSetInput(uriInput, true);
		} catch (CoreException x) {
			String title = "Problem opening";
			String msg = "Cannot open input element:";
			Shell shell = getSite().getShell();
			ErrorDialog.openError(shell, title, msg, x.getStatus());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createGraphicalViewer(Composite parent) {
		splitter = parent;
		super.createGraphicalViewer(parent);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {
		splitter.setFocus();
		super.setFocus();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getEditingDomainID() {
		return "org.eclipse.papyrus.sysml.diagram.requirement.EditingDomain";
	}
}
