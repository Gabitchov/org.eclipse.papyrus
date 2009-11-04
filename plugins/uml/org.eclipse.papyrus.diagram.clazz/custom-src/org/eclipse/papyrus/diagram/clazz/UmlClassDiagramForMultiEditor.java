/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin Cedric.Dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.internal.l10n.EditorMessages;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.diagram.clazz.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.common.listeners.DropTargetListener;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;

/**
 * An editor to be used in multitabs editor. This editor extends the original UML Diagram.
 * 
 * @author dumoulin
 * 
 */
public class UmlClassDiagramForMultiEditor extends org.eclipse.papyrus.diagram.clazz.part.UMLDiagramEditor {

	/**
	 * The image descriptor of the diagram icon
	 */
	private static final ImageDescriptor DIAG_IMG_DESC = UMLDiagramEditorPlugin
			.getBundledImageDescriptor(UmlClassDiagramForMultiEditor.DIAG_IMG_PATH);

	/**
	 * The location of diagram icon in the plug-in
	 */
	private static final String DIAG_IMG_PATH = "icons/ClassDiagram.gif";

	/**
	 * Parent
	 */
	// private GmfEditorContext context;

	/**
	 * The diagram shown by this editor.
	 */
	private Diagram diagram;

	/**
	 * Constructor. Context and required objects are retrieved from the ServiceRegistry.
	 * 
	 * @throws BackboneException
	 * @throws ServiceException
	 * 
	 */
	public UmlClassDiagramForMultiEditor(ServicesRegistry servicesRegistry, Diagram diagram) throws BackboneException,
			ServiceException {
		super(servicesRegistry);
		this.diagram = diagram;
		// ServicesRegistry servicesRegistry = EditorUtils.getServiceRegistry();
		// IEditorContextRegistry contextRegistry = (IEditorContextRegistry) servicesRegistry
		// .getService(IEditorContextRegistry.class);

		// Get the context by its ID
		// this.context = (GmfEditorContext)
		// contextRegistry.getContext(GmfEditorContext.GMF_CONTEXT_ID);
	}

	/**
	 * @return the diagram
	 */
	@Override
	public Diagram getDiagram() {
		return diagram;
	}

	/**
	 * 
	 */
	@Override
	protected final IDocumentProvider getDocumentProvider(IEditorInput input) {
		// System.out.println("getDocumentProvider(IEditorInput input)");
		if (input instanceof IFileEditorInput || input instanceof URIEditorInput) {
			return getDocumentProvider();
		}
		return super.getDocumentProvider(input);
	}

	/**
	 * Returns an editing domain id used to retrive an editing domain from the editing domain
	 * registry. Clients should override this if they wish to use a shared editing domain for this
	 * editor. If null is returned then a new editing domain will be created per editor instance.
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor#getEditingDomainID()
	 * @return
	 * 
	 */
	@Override
	public String getEditingDomainID() {
		return "org.eclipse.uml2.diagram.clazz.EditingDomain";
	}

	/**
	 * Change visibility to public.
	 */
	@Override
	public GraphicalViewer getGraphicalViewer() {
		return super.getGraphicalViewer();
	}

	/**
	 * @return the parentEditor
	 */
	// @unused
	// public GmfEditorContext getSharedObjects() {
	// return null;
	// }

	/**
	 * 
	 */
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		// Set name after calling super.init()
		setPartName(getDiagram().getName());
		setTitleImage(DIAG_IMG_DESC.createImage());
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
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor#selectionChanged(org.eclipse.ui.IWorkbenchPart,
	 *      org.eclipse.jface.viewers.ISelection)
	 * @param part
	 * @param selection
	 * 
	 */
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (getSite().getPage().getActiveEditor() instanceof IMultiDiagramEditor) {
			IMultiDiagramEditor editor = (IMultiDiagramEditor) getSite().getPage().getActiveEditor();
			// If not the active editor, ignore selection changed.
			if (this.equals(editor.getActiveEditor())) {
				updateActions(getSelectionActions());
				super.selectionChanged(part, selection);
			} else {
				super.selectionChanged(part, selection);
			}
		} else {
			super.selectionChanged(part, selection);
		}
		// from
		// org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor.selectionChanged(IWorkbenchPart,
		// ISelection)
		if (part == this) {
			rebuildStatusLine();
		}
	}

	/**
	 * @param diagram
	 *            the diagram to set
	 */
	public void setDiagram(Diagram diagram) {
		this.diagram = diagram;
	}

	/**
	 * @generated
	 */
	@Override
	protected void setDocumentProvider(IEditorInput input) {
		if (input instanceof IFileEditorInput || input instanceof URIEditorInput) {
			setDocumentProvider(getDocumentProvider());
		} else {
			super.setDocumentProvider(input);
		}
	}

	/**
	 * 
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
	 * @param parentEditor
	 *            the parentEditor to set
	 */
	// @unused
	// public void setSharedObject(GmfEditorContext parentEditor) {
	// this.context = parentEditor;
	// }

}
