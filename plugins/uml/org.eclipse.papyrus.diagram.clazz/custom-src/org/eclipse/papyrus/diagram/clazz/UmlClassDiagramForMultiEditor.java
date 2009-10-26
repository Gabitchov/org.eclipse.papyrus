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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.PreferenceChangeEvent;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.palette.PaletteCustomizer;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gef.ui.palette.PaletteViewerProvider;
import org.eclipse.gmf.runtime.diagram.ui.internal.parts.PaletteToolTransferDragSourceListener;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.internal.l10n.EditorMessages;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.core.adaptor.gmf.GmfEditorContext;
import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.extension.editorcontext.IEditorContext;
import org.eclipse.papyrus.core.extension.editorcontext.IEditorContextRegistry;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.core.utils.PapyrusTrace;
import org.eclipse.papyrus.diagram.clazz.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.listeners.DropTargetListener;
import org.eclipse.papyrus.diagram.common.part.PapyrusPaletteContextMenuProvider;
import org.eclipse.papyrus.diagram.common.part.PapyrusPaletteCustomizer;
import org.eclipse.papyrus.diagram.common.part.PapyrusPalettePreferences;
import org.eclipse.papyrus.diagram.common.service.PapyrusPaletteService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;

/**
 * An editor to be used in multitabs editor. This editor extends the original UML Activity Diagram.
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
	private GmfEditorContext context;

	/**
	 * The diagram shown by this editor.
	 */
	private Diagram diagram;

	Composite splitter;

	/**
	 * 
	 * @deprecated Old init method. Now use SashSystem v2
	 */
	public UmlClassDiagramForMultiEditor(Diagram diagram, GmfEditorContext context) {
		super();
		this.diagram = diagram;
		this.context = context;

		// overrides editing domain created by super constructor

		setDocumentProvider(context.getDocumentProvider());
		PapyrusTrace.log(IStatus.INFO, this.getClass().getName());
	}

	// /**
	// * Creates and register actions with the {@link ActionRegistry} for this
	// editor.
	// */
	// @Override
	// protected void createActions() {
	// ActionRegistry registry = getActionRegistry();
	// IAction action;
	//
	// action = new UndoAction(this);
	// registry.registerAction(action);
	// getStackActions().add(action.getId());
	//
	// action = new RedoAction(this);
	// registry.registerAction(action);
	// getStackActions().add(action.getId());
	//
	// action = new SelectAllAction(this);
	// registry.registerAction(action);
	//
	// // action = new DirectEditAction(this);
	// // registry.registerAction(action);
	// // getSelectionActions().add(action.getId());
	// }

	// @Override
	// protected void createGraphicalViewer(Composite parent) {
	// System.out.println("store Composite " + parent);
	// splitter = parent;
	// super.createGraphicalViewer(parent);
	// }

	// /**
	// * Called to configure the viewer before it receives its contents.
	// */
	// protected void configurePaletteViewer() {
	// PaletteViewer viewer = getEditDomain().getPaletteViewer();
	//
	// if (viewer == null)
	// return;
	//
	// ContextMenuProvider paletteContextProvider = new PapyrusPaletteContextMenuProvider(viewer);
	// getEditDomain().getPaletteViewer().setContextMenu(paletteContextProvider);
	// }

	/**
	 * @deprecated Old init method. Now use SashSystem v2
	 */
	public UmlClassDiagramForMultiEditor(Object diagram, IEditorContext context) {
		this((Diagram) diagram, (GmfEditorContext) context);
	}

	/**
	 * Constructor. Context and required objects are retrieved from the ServiceRegistry.
	 * 
	 * @throws BackboneException
	 * @throws ServiceException
	 * 
	 */
	public UmlClassDiagramForMultiEditor(ServicesRegistry servicesRegistry, Diagram diagram) throws BackboneException,
			ServiceException {
		super();
		this.diagram = diagram;
		// ServicesRegistry servicesRegistry = EditorUtils.getServiceRegistry();
		IEditorContextRegistry contextRegistry;
		contextRegistry = (IEditorContextRegistry) servicesRegistry.getService(IEditorContextRegistry.class);

		// Get the context by its ID
		this.context = (GmfEditorContext) contextRegistry.getContext(GmfEditorContext.GMF_CONTEXT_ID);

		// overrides editing domain created by super constructor

		setDocumentProvider(context.getDocumentProvider());
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
			editDomain.setActionManager(context.getDiagramEditDomain().getActionManager());
		}
	}

	/**
	 * @return the diagram
	 */
	public Diagram getDiagram() {
		return diagram;
	}

	/**
	 * 
	 */
	final protected IDocumentProvider getDocumentProvider(IEditorInput input) {
		// System.out.println("getDocumentProvider(IEditorInput input)");
		if (input instanceof IFileEditorInput || input instanceof URIEditorInput) {
			return context.getDocumentProvider();
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

	protected PaletteViewer getPaletteViewer() {
		return getEditDomain().getPaletteViewer();
	}

	/**
	 * @return the parentEditor
	 */
	public GmfEditorContext getSharedObjects() {
		return context;
	}

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

	// @Override
	// public void setFocus() {
	//
	// // System.out.println("setFocus( " + ((Object)splitter).hashCode() +
	// // "):" + splitter.getChildren());
	// splitter.setFocus();
	//
	// super.setFocus();
	// }

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
	 * @{inheritedDoc
	 */
	public void preferenceChange(PreferenceChangeEvent event) {
		if (PapyrusPalettePreferences.PALETTE_CUSTOMIZATIONS_ID.equals(event.getKey())) {
			PapyrusPaletteService.getInstance().updatePalette(getPaletteViewer().getPaletteRoot(), this,
					getDefaultPaletteContent());
		}
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
	protected void setDocumentProvider(IEditorInput input) {
		if (input instanceof IFileEditorInput || input instanceof URIEditorInput) {
			setDocumentProvider(context.getDocumentProvider());
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
	public void setSharedObject(GmfEditorContext parentEditor) {
		this.context = parentEditor;
	}

}
