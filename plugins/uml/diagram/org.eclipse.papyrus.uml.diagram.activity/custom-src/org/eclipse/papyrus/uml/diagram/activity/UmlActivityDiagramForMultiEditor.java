/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramEditor;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.uml.diagram.common.listeners.DropTargetListener;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;

/**
 * Editor used in multitabs editor.
 * 
 * @author Emilien Perico
 * 
 */
public class UmlActivityDiagramForMultiEditor extends UMLDiagramEditor {

	/**
	 * The location of diagram icon in the plug-in
	 */
	private static final String DIAG_IMG_PATH = "icons/obj16/Diagram_Activity.gif";

	/**
	 * The image descriptor of the diagram icon
	 */
	private static final ImageDescriptor DIAG_IMG_DESC = UMLDiagramEditorPlugin.getBundledImageDescriptor(UmlActivityDiagramForMultiEditor.DIAG_IMG_PATH);

	/** The editor splitter. */
	private Composite splitter;

	/**
	 * Constructor for SashSystem v2. Context and required objects are retrieved from the
	 * ServiceRegistry.
	 * 
	 * @throws BackboneException
	 * @throws ServiceException
	 * 
	 *
	 */
	public UmlActivityDiagramForMultiEditor(ServicesRegistry servicesRegistry, Diagram diagram) throws BackboneException, ServiceException {
		super(servicesRegistry, diagram);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		setPartName(getDiagram().getName());
		setTitleImage(DIAG_IMG_DESC.createImage());
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

	/*
	 * FIXME create viewer which allow to select element trought group
	 */
	//    /**
	//     * Creates a ScrollingGraphicalViewer without the drop adapter which
	//     * excludes drag and drop functionality from other defined views (XML)
	//     * Subclasses must override this method to include the DnD functionality
	//     *
	//     * @return ScrollingGraphicalViewer
	//     */
	//	@Override
	//    protected ScrollingGraphicalViewer createScrollingGraphicalViewer() {
	//       // return new DiagramGraphicalViewer();
	//        return new GroupGraphicalViewer();
	//    }
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
		return "org.eclipse.papyrus.uml.diagram.activity.EditingDomain";
	}

	@Override
	protected void initializeGraphicalViewer() {
		/*
		 * During content initialization, view with unknown semantic hint can be loaded (hint must be deduced).
		 * In such cases, if the provider has not been set yet, view providing fails instead of loading the provider.
		 * Ensure the activity diagram provider is correctly loaded before trying to initialize content.
		 * To do so, we ask to provide the main activity node with all required details.
		 */
		IAdaptable adapter = new SemanticAdapter(getDiagram().getElement(), null);
		String semanticHint = ((IHintedType)UMLElementTypes.Activity_2001).getSemanticHint();
		// We already know that result is true. Provider is correctly initialized during the process.
		ViewService.getInstance().provides(Node.class, adapter, getDiagram(), semanticHint, ViewUtil.APPEND, false, getPreferencesHint());
		// initialize content
		super.initializeGraphicalViewer();
		// Enable Drop
		getDiagramGraphicalViewer().addDropTargetListener(new DropTargetListener(getDiagramGraphicalViewer(), LocalSelectionTransfer.getTransfer()) {

			@Override
			protected Object getJavaObject(TransferData data) {
				return LocalSelectionTransfer.getTransfer().nativeToJava(data);
			}

			@Override
			protected TransactionalEditingDomain getTransactionalEditingDomain() {
				return getEditingDomain();
			}
		});
	}
}
