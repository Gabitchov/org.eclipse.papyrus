/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib saadia.dhouib@cea.fr
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.communication.part;

import java.util.EventObject;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.Tool;
import org.eclipse.gef.commands.CommandStackListener;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gef.ui.palette.PaletteViewerProvider;
import org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener;
import org.eclipse.gmf.runtime.common.core.service.ProviderChangeEvent;
import org.eclipse.gmf.runtime.common.ui.services.marker.MarkerNavigationService;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.internal.parts.PaletteToolTransferDragSourceListener;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.commands.util.OperationUtils;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.gmfdiag.common.GmfMultiDiagramDocumentProvider;
import org.eclipse.papyrus.uml.diagram.common.listeners.DropTargetListener;
import org.eclipse.papyrus.uml.diagram.common.part.PapyrusPaletteContextMenuProvider;
import org.eclipse.papyrus.uml.diagram.common.part.PapyrusPaletteViewer;
import org.eclipse.papyrus.uml.diagram.common.part.UmlGmfDiagramEditor;
import org.eclipse.papyrus.uml.diagram.common.service.PapyrusPaletteService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.navigator.resources.ProjectExplorer;
import org.eclipse.ui.part.IShowInTargetList;
import org.eclipse.ui.part.ShowInContext;
import org.eclipse.ui.views.properties.IPropertySheetPage;

/**
 * @generated
 */
public class UMLDiagramEditor extends UmlGmfDiagramEditor implements IProviderChangeListener, IGotoMarker {

	/**
	 * @generated
	 */
	public static final String ID = "org.eclipse.papyrus.uml.diagram.communication.part.UMLDiagramEditorID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final String CONTEXT_ID = "org.eclipse.papyrus.uml.diagram.communication.ui.diagramContext"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private KeyHandler paletteKeyHandler = null;

	/**
	 * @generated
	 */
	private MouseListener paletteMouseListener = null;

	/**
	 * @generated
	 */
	private IUndoableOperation savedOperation = null;

	/**
	 * @generated
	 */
	private TransactionalEditingDomain editingDomain;

	/**
	 * @generated
	 */
	private IDocumentProvider documentProvider;

	/**
	 * @generated
	 */
	public UMLDiagramEditor(ServicesRegistry servicesRegistry, Diagram diagram) throws ServiceException {
		super(servicesRegistry, diagram);
		// adds a listener to the palette service, which reacts to palette customizations
		PapyrusPaletteService.getInstance().addProviderChangeListener(this);
		// Share the same editing provider
		editingDomain = servicesRegistry.getService(TransactionalEditingDomain.class);
		documentProvider = new GmfMultiDiagramDocumentProvider(editingDomain);
		// overrides editing domain created by super constructor
		setDocumentProvider(documentProvider);
	}

	/**
	 * @generated
	 */
	@Override
	protected String getContextID() {
		return CONTEXT_ID;
	}

	/**
	 * @generated
	 */
	@Override
	protected PaletteRoot createPaletteRoot(PaletteRoot existingPaletteRoot) {
		PaletteRoot paletteRoot;
		if(existingPaletteRoot == null) {
			paletteRoot = PapyrusPaletteService.getInstance().createPalette(this, getDefaultPaletteContent());
		} else {
			PapyrusPaletteService.getInstance().updatePalette(existingPaletteRoot, this, getDefaultPaletteContent());
			paletteRoot = existingPaletteRoot;
		}
		applyCustomizationsToPalette(paletteRoot);
		return paletteRoot;
	}

	/**
	 * @generated
	 */
	@Override
	protected PreferencesHint getPreferencesHint() {
		return UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}

	/**
	 * @generated
	 */
	@Override
	public String getContributorId() {
		return UMLDiagramEditorPlugin.ID;
	}

	/**
	 * @generated
	 */
	@Override
	public Object getAdapter(Class type) {
		if(type == IPropertySheetPage.class) {
			return null;
		}
		if(type == IShowInTargetList.class) {
			return new IShowInTargetList() {

				public String[] getShowInTargetIds() {
					return new String[]{ ProjectExplorer.VIEW_ID };
				}
			};
		}
		return super.getAdapter(type);
	}

	/**
	 * @generated
	 */
	@Override
	protected final IDocumentProvider getDocumentProvider(IEditorInput input) {
		return documentProvider;
	}

	/**
	 * @generated
	 */
	@Override
	public TransactionalEditingDomain getEditingDomain() {
		return editingDomain;
	}

	/**
	 * @generated
	 */
	@Override
	protected final void setDocumentProvider(IEditorInput input) {
		// Already set in the constructor
	}

	/**
	 * @generated
	 */
	public void gotoMarker(IMarker marker) {
		MarkerNavigationService.getInstance().gotoMarker(this, marker);
	}

	/**
	 * @generated
	 */
	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

	/**
	 * @generated
	 */
	@Override
	public void doSaveAs() {
		performSaveAs(new NullProgressMonitor());
	}

	/**
	 * @generated
	 */
	@Override
	protected void performSaveAs(IProgressMonitor progressMonitor) {
		// Nothing
	}

	/**
	 * @generated
	 */
	@Override
	public ShowInContext getShowInContext() {
		return new ShowInContext(getEditorInput(), getNavigatorSelection());
	}

	/**
	 * @generated
	 */
	private ISelection getNavigatorSelection() {
		IDiagramDocument document = getDiagramDocument();
		return StructuredSelection.EMPTY;
	}

	/**
	 * @generated
	 */
	@Override
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		DiagramEditorContextMenuProvider provider = new DiagramEditorContextMenuProvider(this, getDiagramGraphicalViewer());
		getDiagramGraphicalViewer().setContextMenu(provider);
		getSite().registerContextMenu(ActionIds.DIAGRAM_EDITOR_CONTEXT_MENU, provider, getDiagramGraphicalViewer());
	}

	/**
	 * @generated
	 */
	@Override
	protected TransactionalEditingDomain createEditingDomain() {
		// Already configured
		return editingDomain;
	}

	/**
	 * @generated
	 */
	@Override
	protected void configureDiagramEditDomain() {
		super.configureDiagramEditDomain();
		getDiagramEditDomain().getDiagramCommandStack().addCommandStackListener(new CommandStackListener() {

			public void commandStackChanged(EventObject event) {
				firePropertyChange(IEditorPart.PROP_DIRTY);
			}
		});
	}

	/**
	 * @generated
	 */
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		// The saving of the resource is done by the CoreMultiDiagramEditor
		savedOperation = getOperationHistory().getUndoOperation(getUndoContext());
	}

	/**
	 * @generated
	 */
	@Override
	public boolean isDirty() {
		IUndoableOperation op = getOperationHistory().getUndoOperation(getUndoContext());
		return savedOperation != op && OperationUtils.anyDirtyingAfter(getOperationHistory().getUndoHistory(getUndoContext()), savedOperation);
	}

	/**
	 * @generated
	 */
	public void providerChanged(ProviderChangeEvent event) {
		// update the palette if the palette service has changed
		if(PapyrusPaletteService.getInstance().equals(event.getSource())) {
			PapyrusPaletteService.getInstance().updatePalette(getPaletteViewer().getPaletteRoot(), this, getDefaultPaletteContent());
		}
	}

	/**
	 * @generated
	 */
	@Override
	public void dispose() {
		// remove palette service listener
		// remove preference listener
		PapyrusPaletteService.getInstance().removeProviderChangeListener(this);
		super.dispose();
	}

	/**
	 * @generated
	 */
	protected PaletteViewer getPaletteViewer() {
		return getEditDomain().getPaletteViewer();
	}

	/**
	 * @generated
	 */
	@Override
	protected PaletteViewer constructPaletteViewer() {
		return new PapyrusPaletteViewer();
	}

	/**
	 * @generated
	 */
	@Override
	protected PaletteViewerProvider createPaletteViewerProvider() {
		getEditDomain().setPaletteRoot(createPaletteRoot(null));
		return new PaletteViewerProvider(getEditDomain()) {

			/**
			 * Override to provide the additional behavior for the tools. Will intialize with a
			 * PaletteEditPartFactory that has a TrackDragger that understand how to handle the
			 * mouseDoubleClick event for shape creation tools. Also will initialize the palette
			 * with a defaultTool that is the SelectToolEx that undestands how to handle the enter
			 * key which will result in the creation of the shape also.
			 */
			protected void configurePaletteViewer(PaletteViewer viewer) {
				super.configurePaletteViewer(viewer);
				// customize menu...
				viewer.setContextMenu(new PapyrusPaletteContextMenuProvider(viewer));
				viewer.getKeyHandler().setParent(getPaletteKeyHandler());
				viewer.getControl().addMouseListener(getPaletteMouseListener());
				// Add a transfer drag target listener that is supported on
				// palette template entries whose template is a creation tool.
				// This will enable drag and drop of the palette shape creation
				// tools.
				viewer.addDragSourceListener(new PaletteToolTransferDragSourceListener(viewer));
				viewer.setCustomizer(createPaletteCustomizer());
			}

			public PaletteViewer createPaletteViewer(Composite parent) {
				PaletteViewer pViewer = constructPaletteViewer();
				pViewer.createControl(parent);
				configurePaletteViewer(pViewer);
				hookPaletteViewer(pViewer);
				return pViewer;
			}

			/**
			 * @return Palette Key Handler for the palette
			 */
			private KeyHandler getPaletteKeyHandler() {
				if(paletteKeyHandler == null) {
					paletteKeyHandler = new KeyHandler() {

						/**
						 * Processes a <i>key released </i> event. This method is called by the Tool
						 * whenever a key is released, and the Tool is in the proper state. Override
						 * to support pressing the enter key to create a shape or connection
						 * (between two selected shapes)
						 * 
						 * @param event
						 *        the KeyEvent
						 * @return <code>true</code> if KeyEvent was handled in some way
						 */
						public boolean keyReleased(KeyEvent event) {
							if(event.keyCode == SWT.Selection) {
								Tool tool = getPaletteViewer().getActiveTool().createTool();
								if(toolSupportsAccessibility(tool)) {
									tool.keyUp(event, getDiagramGraphicalViewer());
									// deactivate current selection
									getPaletteViewer().setActiveTool(null);
									return true;
								}
							}
							return super.keyReleased(event);
						}
					};
				}
				return paletteKeyHandler;
			}

			/**
			 * @return Palette Mouse listener for the palette
			 */
			private MouseListener getPaletteMouseListener() {
				if(paletteMouseListener == null) {
					paletteMouseListener = new MouseListener() {

						/**
						 * Flag to indicate that the current active tool should be cleared after a
						 * mouse double-click event.
						 */
						private boolean clearActiveTool = false;

						/**
						 * Override to support double-clicking a palette tool entry to create a
						 * shape or connection (between two selected shapes).
						 * 
						 * @see MouseListener#mouseDoubleClick(MouseEvent)
						 */
						public void mouseDoubleClick(MouseEvent e) {
							Tool tool = getPaletteViewer().getActiveTool().createTool();
							if(toolSupportsAccessibility(tool)) {
								tool.setViewer(getDiagramGraphicalViewer());
								tool.setEditDomain(getDiagramGraphicalViewer().getEditDomain());
								tool.mouseDoubleClick(e, getDiagramGraphicalViewer());
								// Current active tool should be deactivated,
								// but if it is down here it will get
								// reactivated deep in GEF palette code after
								// receiving mouse up events.
								clearActiveTool = true;
							}
						}

						public void mouseDown(MouseEvent e) {
							// do nothing
						}

						public void mouseUp(MouseEvent e) {
							// Deactivate current active tool here if a
							// double-click was handled.
							if(clearActiveTool) {
								getPaletteViewer().setActiveTool(null);
								clearActiveTool = false;
							}
						}
					};
				}
				return paletteMouseListener;
			}
		};
	}

	/**
	 * @generated
	 */
	@Override
	public GraphicalViewer getGraphicalViewer() {
		return super.getGraphicalViewer();
	}

	/**
	 * @generated
	 */
	@Override
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		// Enable Drop
		getDiagramGraphicalViewer().addDropTargetListener(new DropTargetListener(getDiagramGraphicalViewer(), LocalSelectionTransfer.getTransfer()) {

			@Override
			protected Object getJavaObject(TransferData data) {
				return LocalSelectionTransfer.getTransfer().getSelection();
			}

			@Override
			protected TransactionalEditingDomain getTransactionalEditingDomain() {
				return getEditingDomain();
			}
		});
	}

	/**
	 * @generated
	 */
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if(getSite().getPage().getActiveEditor() instanceof IMultiDiagramEditor) {
			IMultiDiagramEditor editor = (IMultiDiagramEditor)getSite().getPage().getActiveEditor();
			// If not the active editor, ignore selection changed.
			if(this.equals(editor.getActiveEditor())) {
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
		if(part == this) {
			rebuildStatusLine();
		}
	}
}
