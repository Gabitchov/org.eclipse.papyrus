/*****************************************************************************
 * Copyright (c) 2009, 2014 Atos Origin, CEA, and others.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *   Christian W. Damus (CEA) - bug 392301
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditor;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.util.FixGateViewOnOpening;
import org.eclipse.papyrus.uml.diagram.sequence.util.FixInteractionOperandsOnOpening;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;

/**
 * Editor used in multitabs editor.
 */
public class UmlSequenceDiagramForMultiEditor extends UMLDiagramEditor {

	/**
	 * The location of diagram icon in the plug-in
	 */
	private static final String DIAG_IMG_PATH = "icons/obj16/Diagram_Sequence.gif";

	/**
	 * The image descriptor of the diagram icon
	 */
	private static final ImageDescriptor DIAG_IMG_DESC = UMLDiagramEditorPlugin.getBundledImageDescriptor(UmlSequenceDiagramForMultiEditor.DIAG_IMG_PATH);

	/** The editor splitter. */
	private Composite splitter;

	private Image titleImage;
	
	/**
	 * Constructor for SashSystem v2. Context and required objects are retrieved from the
	 * ServiceRegistry.
	 * 
	 * @throws BackboneException
	 * @throws ServiceException
	 */
	public UmlSequenceDiagramForMultiEditor(ServicesRegistry servicesRegistry, Diagram diagram) throws BackboneException, ServiceException {
		super(servicesRegistry, diagram);
		// Fix interaction operand bounds (see bug 400460)
		new FixInteractionOperandsOnOpening().fix(diagram);
		// Fix to add graphical view of gate. (see https://bugs.eclipse.org/bugs/show_bug.cgi?id=389531)
		new FixGateViewOnOpening().fix(diagram);
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
		return "org.eclipse.papyrus.uml.diagram.sequence.EditingDomain";
	}

	@Override
	protected void applyCustomizationsToPalette(PaletteRoot paletteRoot) {
		super.applyCustomizationsToPalette(paletteRoot);
		//Sort Nodes of Palette
		List children = paletteRoot.getChildren();
		if(children.size() > 2) {
			Object nodes = children.get(1);
			if(nodes instanceof PaletteContainer) {
				doSort((PaletteContainer)nodes);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void doSort(PaletteContainer nodes) {
		if(nodes == null) {
			return;
		}
		List children = nodes.getChildren();
		Collections.sort(children, new Comparator<PaletteEntry>() {

			public int compare(PaletteEntry o1, PaletteEntry o2) {
				String l1 = o1.getLabel();
				String l2 = o2.getLabel();
				if(l1 != null && l2 != null) {
					return Collator.getInstance().compare(l1, l2);
				}
				return 0;
			}
		});
	}
}
