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
package org.eclipse.papyrus.diagram.sequence;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.papyrus.core.adaptor.gmf.GmfEditorContext;
import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.extension.editorcontext.IEditorContextRegistry;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.diagram.common.listeners.DropTargetListener;
import org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditor;
import org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;

/**
 * Editor used in multitabs editor.
 */
public class UmlSequenceDiagramForMultiEditor extends UMLDiagramEditor {

	/**
	 * The location of diagram icon in the plug-in
	 */
	private static final String DIAG_IMG_PATH = "icons/SequenceDiagram.gif";

	/**
	 * The image descriptor of the diagram icon
	 */
	private static final ImageDescriptor DIAG_IMG_DESC = UMLDiagramEditorPlugin
			.getBundledImageDescriptor(UmlSequenceDiagramForMultiEditor.DIAG_IMG_PATH);

	/**
	 * The diagram shown by the editor.
	 */
	private Diagram diagram;

	/**
	 * The editor's owner
	 */
	private GmfEditorContext context;

	/** The editor splitter. */
	private Composite splitter;

	/**
	 * Constructor for SashSystem v2. Context and required objects are retrieved from the
	 * ServiceRegistry.
	 * 
	 * @throws BackboneException
	 * @throws ServiceException
	 * 
	 * @generated NOT
	 */
	public UmlSequenceDiagramForMultiEditor(ServicesRegistry servicesRegistry, Diagram diagram)
			throws BackboneException, ServiceException {
		super(servicesRegistry);
		this.diagram = diagram;
		// ServicesRegistry servicesRegistry = EditorUtils.getServiceRegistry();
		IEditorContextRegistry contextRegistry;
		contextRegistry = (IEditorContextRegistry) servicesRegistry.getService(IEditorContextRegistry.class);

		// Get the context by its ID
		this.context = (GmfEditorContext) contextRegistry.getContext(GmfEditorContext.GMF_CONTEXT_ID);

		// overrides editing domain created by super constructor

		setDocumentProvider(context.getDocumentProvider());
		System.err.println(this.getClass().getName());
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
	protected final IDocumentProvider getDocumentProvider(IEditorInput input) {
		if (input instanceof IFileEditorInput || input instanceof URIEditorInput) {
			return context.getDocumentProvider();
		}
		return super.getDocumentProvider(input);
	}

	/**
	 * {@inheritDoc}
	 */
	protected void setDocumentProvider(IEditorInput input) {
		if (input instanceof IFileEditorInput || input instanceof URIEditorInput) {
			setDocumentProvider(context.getDocumentProvider());
		} else {
			super.setDocumentProvider(input);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setInput(IEditorInput input) {
		try {
			// Provide an URI with fragment in order to reuse the same Resource
			// and set the diagram to the fragment.
			URIEditorInput uriInput = new URIEditorInput(EcoreUtil.getURI(diagram));
			doSetInput(uriInput, true);
		} catch (CoreException x) {
			String title = "Problem opening";
			String msg = "Cannot open input element:";
			Shell shell = getSite().getShell();
			ErrorDialog.openError(shell, title, msg, x.getStatus());
		}
	}

	@Override
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();

		// Enable Drop
		getDiagramGraphicalViewer().addDropTargetListener(
				new DropTargetListener(getDiagramGraphicalViewer(), LocalSelectionTransfer.getTransfer()) {

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
	public String getEditingDomainID() {
		return "org.eclipse.papyrus.diagram.sequence.EditingDomain";
	}

	// ================ Getters & Setters ==================

	/**
	 * Change visibility to public.
	 */
	@Override
	public GraphicalViewer getGraphicalViewer() {
		return super.getGraphicalViewer();
	}

	/**
	 * @return the diagram
	 */
	public Diagram getDiagram() {
		return diagram;
	}

	/**
	 * @param diagram
	 *            the diagram to set
	 */
	public void setDiagram(Diagram diagram) {
		this.diagram = diagram;
	}

	/**
	 * @return the parentEditor
	 */
	public GmfEditorContext getSharedObjects() {
		return context;
	}

	/**
	 * @param parentEditor
	 *            the parentEditor to set
	 */
	public void setSharedObject(GmfEditorContext parentEditor) {
		this.context = parentEditor;
	}
}
