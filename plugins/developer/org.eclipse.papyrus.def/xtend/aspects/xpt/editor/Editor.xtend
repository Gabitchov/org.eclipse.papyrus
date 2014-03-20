/**
 * Copyright (c) 2006, 2014 Borland Software Corporation, CEA, and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 *    Emilien Perico (Atos Origin) - add code to refactor some classes
 *    Christian W. Damus (CEA) - bug 430648
 */
package aspects.xpt.editor

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenEditorView
import org.eclipse.gmf.codegen.gmfgen.Palette
import xpt.Common

@Singleton class Editor extends xpt.editor.Editor {
	@Inject extension Common;


	override extendsList(GenEditorView it) '''extends org.eclipse.papyrus.uml.diagram.common.part.UmlGmfDiagramEditor'''

	override attributes(GenEditorView it) '''
	«generatedMemberComment»
	public static final String ID = "«ID»"; «nonNLS»
	
	«generatedMemberComment»
public static final String CONTEXT_ID = "«contextID»"; «nonNLS»

	
	«««	Documentation. adds listener for papyrus editors
	«generatedMemberComment»
	private org.eclipse.gef.KeyHandler paletteKeyHandler = null;

	«generatedMemberComment»
	private org.eclipse.swt.events.MouseListener paletteMouseListener = null;

	«««	Helps to handle correctly the dirty state
	«generatedMemberComment»
	private org.eclipse.core.commands.operations.IUndoableOperation savedOperation = null;
	
	«generatedMemberComment»
	private org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain;

	«generatedMemberComment»
    private org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider documentProvider;
	'''
	
	override constructor(GenEditorView it) '''
		«generatedMemberComment»
		public «className»(org.eclipse.papyrus.infra.core.services.ServicesRegistry servicesRegistry, org.eclipse.gmf.runtime.notation.Diagram diagram) throws org.eclipse.papyrus.infra.core.services.ServiceException{
		super(servicesRegistry, diagram);

		«««	Documentation. adds listener for papyrus palette service
		// adds a listener to the palette service, which reacts to palette customizations
		org.eclipse.papyrus.uml.diagram.common.service.PapyrusPaletteService.getInstance().addProviderChangeListener(this);
		
		«««Share the same editing domain
		// Share the same editing provider
		editingDomain = servicesRegistry.getService(org.eclipse.emf.transaction.TransactionalEditingDomain.class);
		documentProvider = new org.eclipse.papyrus.infra.gmfdiag.common.GmfMultiDiagramDocumentProvider(editingDomain);
		
		// overrides editing domain created by super constructor
		setDocumentProvider(documentProvider);
		
		«««end of listeners addition
		}
	'''

override createPaletteRoot (Palette it)'''
	«generatedMemberComment»
	protected org.eclipse.gef.palette.PaletteRoot createPaletteRoot(org.eclipse.gef.palette.PaletteRoot existingPaletteRoot) {
		org.eclipse.gef.palette.PaletteRoot paletteRoot;
		if (existingPaletteRoot == null) {
			paletteRoot = org.eclipse.papyrus.uml.diagram.common.service.PapyrusPaletteService.getInstance().createPalette(this, getDefaultPaletteContent());
		} else {
			org.eclipse.papyrus.uml.diagram.common.service.PapyrusPaletteService.getInstance().updatePalette(existingPaletteRoot, this, getDefaultPaletteContent());
			paletteRoot = existingPaletteRoot;
		}
		applyCustomizationsToPalette(paletteRoot);
		return paletteRoot;
	}
'''

def createPaletteCustomizer (GenEditorView it)'''
	«generatedMemberComment»
	protected org.eclipse.gef.ui.palette.PaletteCustomizer createPaletteCustomizer() {
		return new org.eclipse.papyrus.uml.diagram.common.part.PapyrusPaletteCustomizer(getPreferenceStore());
	}
'''

override additions (GenEditorView it)'''
	
	«createEditingDomain(it)»
	
	« configureDiagramEditDomain(it)»
	
	« doSave(it)»
	
	« isDirty(it)»
	
	«««Documentation. adds method to handle palette changes
	« handlePaletteChange(it)»
	
	« dispose(it)»
	
	« getPaletteViewer(it)»
	
	«««	Documentation: (RS) advanced customization abilities
	«««	« createPaletteCustomizer»
	
	
	« constructPaletteViewer(it)»
	
	« createPaletteviewerProvider(it)»
	
	«getGraphicalViewer(it)»
	
	«initializeGraphicalViewer(it)»
	
	«selectionChanged(it)»
'''

def handlePaletteChange (GenEditorView it) '''
	«generatedMemberComment»
	public void providerChanged(org.eclipse.gmf.runtime.common.core.service.ProviderChangeEvent event) {
		// update the palette if the palette service has changed
		if (org.eclipse.papyrus.uml.diagram.common.service.PapyrusPaletteService.getInstance().equals(event.getSource())) {
			org.eclipse.papyrus.uml.diagram.common.service.PapyrusPaletteService.getInstance().updatePalette(getPaletteViewer().getPaletteRoot(), this,
					getDefaultPaletteContent());
		}
	}
'''

def constructPaletteViewer (GenEditorView it) '''
	«generatedMemberComment»
	protected org.eclipse.gef.ui.palette.PaletteViewer constructPaletteViewer() {
		return new org.eclipse.papyrus.uml.diagram.common.part.PapyrusPaletteViewer();
	}
'''

def dispose(GenEditorView it)'''
	«generatedMemberComment»
	public void dispose() {
		// remove palette service listener
		// remove preference listener
		org.eclipse.papyrus.uml.diagram.common.service.PapyrusPaletteService.getInstance().removeProviderChangeListener(this);
		
		super.dispose();
	}
'''

def getPaletteViewer (GenEditorView it)'''
	«generatedMemberComment»
	protected org.eclipse.gef.ui.palette.PaletteViewer getPaletteViewer() {
		return getEditDomain().getPaletteViewer();
	}
'''	
	
override implementsList(Iterable<String> it)'''
 implements org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener
	«IF  ! it.isEmpty», 
		«FOR string : it  SEPARATOR ', '»
			«implementsListEntry(string)»
		«ENDFOR»
	«ENDIF»
'''

def implementsListEntry (String it)'''«it»'''

def createPaletteviewerProvider (GenEditorView it)'''
«generatedMemberComment»
protected org.eclipse.gef.ui.palette.PaletteViewerProvider createPaletteViewerProvider() {
		getEditDomain().setPaletteRoot(createPaletteRoot(null));
		return new org.eclipse.gef.ui.palette.PaletteViewerProvider(getEditDomain()) {

			/**
			 * Override to provide the additional behavior for the tools. Will intialize with a
			 * PaletteEditPartFactory that has a TrackDragger that understand how to handle the
			 * mouseDoubleClick event for shape creation tools. Also will initialize the palette
			 * with a defaultTool that is the SelectToolEx that undestands how to handle the enter
			 * key which will result in the creation of the shape also.
			 */
			protected void configurePaletteViewer(org.eclipse.gef.ui.palette.PaletteViewer viewer) {
				super.configurePaletteViewer(viewer);

				// customize menu...
				viewer.setContextMenu(new org.eclipse.papyrus.uml.diagram.common.part.PapyrusPaletteContextMenuProvider(viewer));

				viewer.getKeyHandler().setParent(getPaletteKeyHandler());
				viewer.getControl().addMouseListener(getPaletteMouseListener());

				// Add a transfer drag target listener that is supported on
				// palette template entries whose template is a creation tool.
				// This will enable drag and drop of the palette shape creation
				// tools.
				viewer.addDragSourceListener(new org.eclipse.gmf.runtime.diagram.ui.internal.parts.PaletteToolTransferDragSourceListener(viewer));
				viewer.setCustomizer(createPaletteCustomizer());
			}

			public org.eclipse.gef.ui.palette.PaletteViewer createPaletteViewer(org.eclipse.swt.widgets.Composite parent) {
				org.eclipse.gef.ui.palette.PaletteViewer pViewer = constructPaletteViewer();
				pViewer.createControl(parent);
				configurePaletteViewer(pViewer);
				hookPaletteViewer(pViewer);
				return pViewer;
			}

			/**
			 * @return Palette Key Handler for the palette
			 */
			private org.eclipse.gef.KeyHandler getPaletteKeyHandler() {

				if (paletteKeyHandler == null) {

					paletteKeyHandler = new org.eclipse.gef.KeyHandler() {

						/**
						 * Processes a <i>key released </i> event. This method is called by the Tool
						 * whenever a key is released, and the Tool is in the proper state. Override
						 * to support pressing the enter key to create a shape or connection
						 * (between two selected shapes)
						 * 
						 * @param event
						 *            the KeyEvent
						 * @return <code>true</code> if KeyEvent was handled in some way
						 */
						public boolean keyReleased(org.eclipse.swt.events.KeyEvent event) {

							if (event.keyCode == org.eclipse.swt.SWT.Selection) {

								org.eclipse.gef.Tool tool = getPaletteViewer().getActiveTool().createTool();

								if (toolSupportsAccessibility(tool)) {

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
			private org.eclipse.swt.events.MouseListener getPaletteMouseListener() {

				if (paletteMouseListener == null) {

					paletteMouseListener = new org.eclipse.swt.events.MouseListener() {

						/**
						 * Flag to indicate that the current active tool should be cleared after a
						 * mouse double-click event.
						 */
						private boolean clearActiveTool = false;

						/**
						 * Override to support double-clicking a palette tool entry to create a
						 * shape or connection (between two selected shapes).
						 * 
						 * @see org.eclipse.swt.events.MouseListener#mouseDoubleClick(org.eclipse.swt.events.MouseEvent)
						 */
						public void mouseDoubleClick(org.eclipse.swt.events.MouseEvent e) {
							org.eclipse.gef.Tool tool = getPaletteViewer().getActiveTool().createTool();

							if (toolSupportsAccessibility(tool)) {

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

						public void mouseDown(org.eclipse.swt.events.MouseEvent e) {
							// do nothing
						}

						public void mouseUp(org.eclipse.swt.events.MouseEvent e) {
							// Deactivate current active tool here if a
							// double-click was handled.
							if (clearActiveTool) {
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
'''

//Not used
override performSaveAs (GenEditorView it)'''
	«generatedMemberComment»
protected void performSaveAs(org.eclipse.core.runtime.IProgressMonitor progressMonitor) {
  // Nothing
}
'''

//Share the same editing domain
override getEditingDomain (GenEditorView it)'''
	«generatedMemberComment»
	public org.eclipse.emf.transaction.TransactionalEditingDomain getEditingDomain() {
		return editingDomain;
	}	
'''

def createEditingDomain (GenEditorView it)'''
«generatedMemberComment»
	protected org.eclipse.emf.transaction.TransactionalEditingDomain createEditingDomain() {
		// Already configured
		return editingDomain;
	}
'''


def configureDiagramEditDomain (GenEditorView it)'''
«generatedMemberComment»
	protected void configureDiagramEditDomain() {
		super.configureDiagramEditDomain();
		getDiagramEditDomain().getDiagramCommandStack().addCommandStackListener(new org.eclipse.gef.commands.CommandStackListener() {

			public void commandStackChanged(java.util.EventObject event) {
				firePropertyChange( org.eclipse.ui.IEditorPart.PROP_DIRTY);
			}
		});
	}
'''

def doSave (GenEditorView it)'''
«generatedMemberComment»
	public void doSave(org.eclipse.core.runtime.IProgressMonitor progressMonitor) {
		// The saving of the resource is done by the CoreMultiDiagramEditor
		savedOperation =  getOperationHistory().getUndoOperation(getUndoContext());
	}
'''

//Fix the dirty state
def isDirty (GenEditorView it)'''
«generatedMemberComment»
	public boolean isDirty() {
		org.eclipse.core.commands.operations.IUndoableOperation op = getOperationHistory().getUndoOperation(getUndoContext());
		return savedOperation != op && org.eclipse.papyrus.commands.util.OperationUtils.anyDirtyingAfter(getOperationHistory().getUndoHistory(getUndoContext()), savedOperation);
	}
'''

//Code refactoring moved in UMLDiagramEditor
override getDocumentProvider (GenEditorView it)'''
	«generatedMemberComment»
	protected final org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider getDocumentProvider(org.eclipse.ui.IEditorInput input) {
		return documentProvider;
	}
'''

override setDocumentProvider (GenEditorView it)'''
	«generatedMemberComment»
	protected final void setDocumentProvider(org.eclipse.ui.IEditorInput input) {
		// Already set in the constructor
	}
'''

def getGraphicalViewer (GenEditorView it)'''
«generatedMemberComment»
	@Override
	public org.eclipse.gef.GraphicalViewer getGraphicalViewer() {
		return super.getGraphicalViewer();
	}
'''


override initializeGraphicalViewer (GenEditorView it)'''
«generatedMemberComment»
	@Override
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();

		// Enable Drop
		getDiagramGraphicalViewer().addDropTargetListener(
				new org.eclipse.papyrus.uml.diagram.common.listeners.DropTargetListener(getDiagramGraphicalViewer(), org.eclipse.jface.util.LocalSelectionTransfer.getTransfer()) {

					@Override
					protected Object getJavaObject(org.eclipse.swt.dnd.TransferData data) {
						// It is usual for the transfer data not to be set because it is available locally
						return LocalSelectionTransfer.getTransfer().getSelection();
					}

					@Override
					protected org.eclipse.emf.transaction.TransactionalEditingDomain getTransactionalEditingDomain() {
						return getEditingDomain();
					}
				});

	}
'''

def selectionChanged (GenEditorView it)'''
«generatedMemberComment»
	@Override
	public void selectionChanged(org.eclipse.ui.IWorkbenchPart part, org.eclipse.jface.viewers.ISelection selection) {
		if (getSite().getPage().getActiveEditor() instanceof org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor) {
			org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor editor = (org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor) getSite().getPage().getActiveEditor();
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
'''

override getContextID (GenEditorView it)'''
	«generatedMemberComment»
protected String getContextID() {
	return CONTEXT_ID;
}
'''

}
