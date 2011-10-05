/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.part;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.internal.l10n.EditorMessages;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.core.adaptor.gmf.GmfEditorContext;
import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.extension.editorcontext.IEditorContext;
import org.eclipse.papyrus.core.extension.editorcontext.IEditorContextRegistry;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;

/**
 * The Class UMLSequenceDiagramForMultiEditor.
 */
public class UMLSequenceDiagramForMultiEditor extends UMLDiagramEditor {

	/** The diagram. */
	private Diagram diagram = null;

	/** The context. */
	private GmfEditorContext context = null;

	/**
	 * The location of diagram icon in the plug-in
	 */
	private static final String DIAG_IMG_PATH = "icons/SequenceDiagram.gif";

	/**
	 * The image descriptor of the diagram icon
	 */
	private static final ImageDescriptor DIAG_IMG_DESC = UMLDiagramEditorPlugin.getBundledImageDescriptor(UMLSequenceDiagramForMultiEditor.DIAG_IMG_PATH);

	/**
	 * Constructor for SashSystem v2. Context and required objects are retrieved from the ServiceRegistry.
	 * 
	 * @throws BackboneException
	 * @throws ServiceException
	 * 
	 * @generated NOT
	 */
	public UMLSequenceDiagramForMultiEditor(ServicesRegistry servicesRegistry, Diagram diagram) throws BackboneException, ServiceException {
		super();
		this.diagram = diagram;
//		ServicesRegistry servicesRegistry = EditorUtils.getServiceRegistry();
		IEditorContextRegistry contextRegistry;
		contextRegistry = (IEditorContextRegistry) servicesRegistry.getService(IEditorContextRegistry.class);

		// Get the context by its ID
		this.context = (GmfEditorContext) contextRegistry.getContext(GmfEditorContext.GMF_CONTEXT_ID);

		// overrides editing domain created by super constructor

		setDocumentProvider(context.getDocumentProvider());
		System.err.println(this.getClass().getName());
	}

	/**
	 * Instantiates a new uML sequence diagram for multi editor.
	 * 
	 * @param diagram
	 *            the diagram
	 * @param context
	 *            the context
	 */
	public UMLSequenceDiagramForMultiEditor(Object diagram, IEditorContext context) {
		this((Diagram) diagram, (GmfEditorContext) context);
	}

	/**
	 * Instantiates a new uML sequence diagram for multi editor.
	 * 
	 * @param diagram
	 *            the diagram
	 * @param context
	 *            the context
	 */
	public UMLSequenceDiagramForMultiEditor(Diagram diagram, GmfEditorContext context) {
		super();
		this.diagram = diagram;
		this.context = context;
		setDocumentProvider(context.getDocumentProvider());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Diagram getDiagram() {
		return diagram;
	}

	/**
	 * Sets the diagram.
	 * 
	 * @param diagram
	 *            the new diagram
	 */
	public void setDiagram(Diagram diagram) {
		this.diagram = diagram;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GraphicalViewer getGraphicalViewer() {
		return super.getGraphicalViewer();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	final protected IDocumentProvider getDocumentProvider(IEditorInput input) {
		if (input instanceof IFileEditorInput || input instanceof URIEditorInput) {
			return context.getDocumentProvider();
		}
		return super.getDocumentProvider(input);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setDocumentProvider(IEditorInput input) {
		if (input instanceof IFileEditorInput || input instanceof URIEditorInput) {
			setDocumentProvider(context.getDocumentProvider());
		} else {
			super.setDocumentProvider(input);
		}
	}

	/**
	 * Configures the diagram with the parent Multi editor shared command stack
	 */
	@Override
	protected void configureDiagramEditDomain() {
		super.configureDiagramEditDomain();
		DiagramEditDomain editDomain = (DiagramEditDomain) getDiagramEditDomain();

		if (editDomain != null) {
			editDomain.setCommandStack(context.getDiagramEditDomain().getDiagramCommandStack());
			editDomain.setActionManager(editDomain.getActionManager());
		}
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
			// We are in a nested editor.
			// Provide an URI with fragment in order to reuse the same Resource
			// and to
			// set the diagram to the fragment.
			// First, compute the URI
			URIEditorInput uriInput = new URIEditorInput(EcoreUtil.getURI(diagram));
			System.err.println(this.getClass().getSimpleName() + ".setInput(" + uriInput.toString() + ")");
			doSetInput(uriInput, true);
		} catch (CoreException x) {
			String title = EditorMessages.Editor_error_setinput_title;
			String msg = EditorMessages.Editor_error_setinput_message;
			Shell shell = getSite().getShell();
			ErrorDialog.openError(shell, title, msg, x.getStatus());
		}

	}

	/**
	 * Gets the shared objects.
	 * 
	 * @return the shared objects
	 */
	public GmfEditorContext getSharedObjects() {
		return context;
	}

	/**
	 * Sets the shared object.
	 * 
	 * @param parentEditor
	 *            the new shared object
	 */
	public void setSharedObject(GmfEditorContext parentEditor) {
		this.context = parentEditor;
	}

	/** The splitter. */
	Composite splitter;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createGraphicalViewer(Composite parent) {
		System.out.println("store Composite " + parent);
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

}
