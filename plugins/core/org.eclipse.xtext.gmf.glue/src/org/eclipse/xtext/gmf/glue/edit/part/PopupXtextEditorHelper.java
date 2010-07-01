/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.gmf.glue.edit.part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;

import javax.swing.text.JTextComponent.KeyBinding;


import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;
import org.eclipse.jface.bindings.Binding;
import org.eclipse.jface.commands.ActionHandler;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.extensionpoints.editors.ui.IPopupEditorHelper;
//import org.eclipse.papyrus.sasheditor.internal.eclipsecopy.MultiPageEditorSite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IKeyBindingService;
import org.eclipse.ui.INestableKeyBindingService;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.internal.KeyBindingService;
import org.eclipse.ui.internal.PartSite;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.internal.WorkbenchPlugin;
import org.eclipse.ui.internal.services.INestable;
import org.eclipse.ui.keys.IBindingService;
import org.eclipse.ui.part.FileEditorInputFactory;
import org.eclipse.ui.services.IServiceLocator;
import org.eclipse.xtext.gmf.glue.Activator;
import org.eclipse.xtext.gmf.glue.editingdomain.ChangeAggregatorAdapter;
import org.eclipse.xtext.gmf.glue.editingdomain.UpdateXtextResourceTextCommand;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.CompoundXtextEditorCallback;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.info.ResourceWorkingCopyFileEditorInput;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * Base class to handle a small in-diagram XtextEditor.
 * 
 * Override the generated <code>performDirectEdit</code> methods in the EditPart of the label to be directly edited, and
 * call {@link #showEditor()} instead of opening the default {@link TextCellEditor}.
 * 
 * @author koehnlein
 * @author CEA LIST - Some modifications for the integration in Papyrus 
 * Changes:
 * - Added "implements" relationship towards IPopupEditorHelper, 
 * 		related to the DirectEditor extension point of Papyrus
 * - Signature of the constructor modified
 * - Method showEditor modified, with the creation of a temporary file, underlying the popup xtext editor
 * - Method closeEditor modified, with new statements for managing the reconciliation between the original
 * 		UML model and the textual specification resulting from the edition in the popup xtext editor. The 
 * 		temporary text file created by showEditor is also deleted.
 * - Method createXTextEditor modified. Now uses the Papyrus IEditorSite, and also adds a focus listener for
 * 		managing the context eobject and current xtext editor.
 * - Method setEditorRegin modified (needs some work...)
 * - Method setEditorBounds modified (needs some work...)
 * - Method activateServices and deactivateServices, for managing the key binding of the context diagram
 * 		editor.
 */

public class PopupXtextEditorHelper implements IPopupEditorHelper {

	private static int MIN_EDITOR_WIDTH = 100;

	private static int MIN_EDITOR_HEIGHT = 20;

	private IGraphicalEditPart hostEditPart;

	private IEditorPart diagramEditor;

	private XtextEditor xtextEditor;

	private int editorOffset;

	private int initialEditorSize;

	private int initialDocumentSize;

	private Composite xtextEditorComposite;
	private final Injector xtextInjector;

	private XtextResource xtextResource;

	private String semanticElementFragment;

	private IEObjectContextUpdater eobjectContextUpdater ;
	
	private IXTextEditorContextUpdater xtextEditorContextUpdater ;
	
	private EObject semanticElement ;
	
	private String textToEdit ;
	
	private String fileExtension ;
	
	private static int uniqueID = 0 ;
	
	private String temporaryFilePath = "" ;

	private IXtextEMFReconciler modelReconciler;
	
	
	private IPartListener addedPartListener ;

	
	/**
	 * This element was originally undocumented in the XText/GMF integration example
	 * 
	 * Modifications performed by CEA LIST
	 * 		- Signature changed: was public PopupXtextEditorHelper(IGraphicalEditPart editPart, Injector xtextInjector)
	 * @param editPart The editPart on which a direct edit has been performed.
	 * @param xtextInjector The xtextInjector.
	 * @param eobjectContextUpdater The IEObjectContextUpdater, to update the currently edited UML model element
	 * @param xtextEditorContextUpdater The IXtextEditorContextUpdater, to update the currently select xtext editor
	 * @param modelReconciler The IXtextEMFReconciler, to update the context UML model with changes textually specified in the popup xtext editor
	 * @param textToEdit the initialization text, used as the initial textual content for the popup xtext editor 
	 * @param fileExtension the extension for the temporary textual file (underlying the editor)
	 * 
	 */
	public PopupXtextEditorHelper(IGraphicalEditPart editPart, 
							Injector xtextInjector, 
							IEObjectContextUpdater eobjectContextUpdater, 
							IXTextEditorContextUpdater xtextEditorContextUpdater,
							IXtextEMFReconciler modelReconciler,
							String textToEdit, 
							String fileExtension) {
		this.hostEditPart = editPart;
		this.xtextInjector = xtextInjector ;
		this.textToEdit = "" + textToEdit ;
		this.fileExtension = "" + fileExtension ;
		this.eobjectContextUpdater = eobjectContextUpdater ;
		this.xtextEditorContextUpdater = xtextEditorContextUpdater ;
		this.modelReconciler = modelReconciler ;
	}

	/**
	 * This element was originally not documented in the XText / GMF integration example.
	 * 
	 * Changes from CEA LIST:
	 * 		- Statements added for the creation of a temporary text file, used as an input for the popup xtext editor
	 */
	public void showEditor() {
		try {
			semanticElement = hostEditPart.resolveSemanticElement();
			if (semanticElement == null) {
				return;
			}
			this.eobjectContextUpdater.updateContext(semanticElement) ;
			Resource semanticResource = semanticElement.eResource();

			semanticElementFragment = semanticResource.getURIFragment(semanticElement);
			if (semanticElementFragment == null || "".equals(semanticElementFragment)) {
				return;
			}
			IDiagramEditDomain diagramEditDomain = hostEditPart.getDiagramEditDomain();
			
			diagramEditor = ((DiagramEditDomain) diagramEditDomain).getEditorPart();
			
			
			try {
				IFile file2 = (IFile) Workbench.getInstance().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorInput().
			    getAdapter(IFile.class);
				
				String portablePath = file2.getRawLocation().toPortableString() ;
				portablePath = new String(portablePath.substring(0, portablePath.lastIndexOf("/")+1)) + "tmpXtextFile" + uniqueID++ + fileExtension ;
					
				temporaryFilePath = "" + portablePath ;
				File file = new File(temporaryFilePath);
				FileOutputStream outputStream = null ;
				PrintStream data = null ;
				file.createNewFile();
				outputStream = new FileOutputStream(file) ;
				data = new PrintStream(outputStream) ; 
				data.print(textToEdit) ;
				xtextResource = (XtextResource)semanticResource.getResourceSet().createResource(URI.createFileURI(file.getAbsolutePath())) ;
				xtextResource.load(null) ;
				
				createXtextEditor(new ResourceWorkingCopyFileEditorInput(xtextResource));
				
			} 
			catch (IOException e) {
				Activator.logError(e);
			}
		} catch (Exception e) {
			Activator.logError(e);
		}
	}

	/**
	 * This element was originally not documented in the XText/GMF integration example.
	 * 
	 * Changes performed by CEA LIST:
	 * 	- new statements for managing the reconciliation between the original UML model and 
	 * 		the textual specification resulting from the edition in the popup xtext editor. The 
	 * 		temporary text file created by showEditor is also deleted.
	 * @param isReconcile Determines whether a reconciliation must be performed or not
	 */
	public void closeEditor(boolean isReconcile) {
		if (xtextEditor != null) {
			if (isReconcile) {
				try {
					final IXtextDocument xtextDocument = xtextEditor.getDocument();
					if (!isDocumentHasErrors(xtextDocument)) {
						int documentGrowth = xtextDocument.getLength() - initialDocumentSize ;
						String newText = xtextDocument.get(editorOffset , initialEditorSize + documentGrowth) ;
						UpdateXtextResourceTextCommand.createUpdateCommand(xtextResource, editorOffset,
								initialEditorSize, newText).execute(null, null);

						if (xtextResource.getAllContents().hasNext())
							modelReconciler.reconcile(semanticElement, xtextResource.getAllContents().next()) ;
					}
				} catch (Exception exc) {
					Activator.logError(exc);
				}
			}
			xtextEditorComposite.setVisible(false);
			deactivateServices(false) ;
			xtextEditor.dispose() ;
			
			MultiPageEditorSite site = (MultiPageEditorSite)xtextEditor.getSite() ;
			site.dispose() ;
			
			diagramEditor.getSite().getPage().removePartListener(this.addedPartListener) ;
			
			////////////////////////////////////////////
			// TODO: Deletion of the temp file does not always work...
			// TODO: When it works, how to update the content of the outline?
			try {
				xtextResource.unload() ;
				xtextResource.delete(null) ;
			}
			catch (Exception e) {
				e.printStackTrace() ;
			}
		}
	}

	/**
	 * This element was originally not documented in the XText/GMF integration example
	 * 
	 * Changes performed by CEA LIST:
	 * 		- Now uses the Papyrus IEditorSite 
	 * 		- adds a focus listener for managing the context eobject and current xtext editor.
	 * 
	 * @param editorInput
	 */
	private void createXtextEditor(IEditorInput editorInput) throws Exception {
		Shell diagramShell = diagramEditor.getSite().getShell();
		xtextEditorComposite = new Decorations(diagramShell, SWT.RESIZE | SWT.ON_TOP | SWT.BORDER);
		xtextEditorComposite.setLayout(new FillLayout());
		
		IEditorSite editorSite = (IEditorSite)EditorUtils.getMultiDiagramEditor().getSite() ;
		xtextEditor = xtextInjector.getInstance(XtextEditor.class);
		// remove dirty state editor callback
		xtextEditor.setXtextEditorCallback(new CompoundXtextEditorCallback(Guice.createInjector(new Module() {
			public void configure(Binder binder) {
			}
		})));
		
		editorSite = new MultiPageEditorSite((IEditorSite)EditorUtils.getMultiDiagramEditor().getSite(), xtextEditor, null) ;
		
		xtextEditor.init(editorSite, editorInput);
		xtextEditor.createPartControl(xtextEditorComposite);
		
		this.activateServices() ;
		
		registerKeyListener();
		setEditorRegion();
		setEditorBounds();
		
		xtextEditorComposite.addFocusListener(new FocusListener() {
			
			public void focusLost(FocusEvent e) {
				eobjectContextUpdater.updateContext(semanticElement) ;
				xtextEditorContextUpdater.updateCurrentEditor(xtextEditor) ;
			}
			
			public void focusGained(FocusEvent e) {
				eobjectContextUpdater.updateContext(semanticElement) ;
				xtextEditorContextUpdater.updateCurrentEditor(xtextEditor) ;
			}
		}) ;
		
		xtextEditorComposite.setVisible(true);
		xtextEditorComposite.forceFocus();
		xtextEditor.setFocus();
				
		IWorkbenchPage page = diagramEditor.getSite().getPage();
		addedPartListener = new IPartListener() {
			public void partActivated(IWorkbenchPart part) {
				closeEditor(false);
			}
			public void partBroughtToTop(IWorkbenchPart part) {
				System.out.println("part brought to top") ;
			}
			public void partClosed(IWorkbenchPart part) {
				closeEditor(false);
			}
			public void partDeactivated(IWorkbenchPart part) {
				closeEditor(false);
			}
			public void partOpened(IWorkbenchPart part) {
				closeEditor(false);
			}
		} ; 
		page.addPartListener(this.addedPartListener);
	}

	private void registerKeyListener() {
		XtextSourceViewer sourceViewer = (XtextSourceViewer) xtextEditor.getInternalSourceViewer();
		final StyledText xtextTextWidget = sourceViewer.getTextWidget();
		PopupXtextEditorKeyListener keyListener = new PopupXtextEditorKeyListener(this, sourceViewer
				.getContentAssistant());
		xtextTextWidget.addVerifyKeyListener(keyListener);
		xtextTextWidget.addKeyListener(keyListener);
	}

	/**
	 * This element was originally not documented in the XText/GMF integration example
	 */
	private void setEditorRegion() throws BadLocationException {
		final IXtextDocument xtextDocument = xtextEditor.getDocument();
		boolean success = xtextEditor.getDocument().modify(new IUnitOfWork<Boolean, XtextResource>() {

			public Boolean exec(XtextResource state) throws Exception {
				EObject semanticElementInDocument = state.getEObject(semanticElementFragment);
				
				if (semanticElementInDocument == null) {
					return false;
				}
				
				CompositeNode xtextNode = getCompositeNode(semanticElementInDocument);
				if (xtextNode == null) {
					return false;
				}
				
				editorOffset = xtextNode.getOffset();
				initialEditorSize = xtextNode.getLength() ;
				initialDocumentSize = xtextDocument.getLength();
				
				xtextDocument.replace(editorOffset + 1 + initialEditorSize, 0, "\n");
				
				return true;
			}

		});

		if (success) {
			xtextEditor.showHighlightRangeOnly(true);
			xtextEditor.setHighlightRange(editorOffset + 1, initialEditorSize, true);
			xtextEditor.setFocus();
		}
	}

	/**
	 * This element was originally not documented in the XText/GMF integration example
	 * 
	 * Modifications from CEA LIST:
	 * 		- modifications to rules for computing the initial location and size of the popup editor.
	 * 			This still needs some work...
	 */
	private void setEditorBounds() {
		final IXtextDocument xtextDocument = xtextEditor.getDocument();
		// mind the added newlines
		String editString = "";
		try {
			editString = xtextDocument.get(editorOffset + 1, initialEditorSize);
		} catch (BadLocationException exc) {
			Activator.logError(exc);
		}
		int numLines = StringUtil.getNumLines(editString);
		int numColumns = 0;
		for (int i = 0 ; i<xtextDocument.getNumberOfLines();i++) {
			try {
				numColumns = Math.max(xtextDocument.getLineLength(i), numColumns) ;
			} catch (Exception e) {}
		}

		IFigure figure = hostEditPart.getFigure();
		Rectangle bounds = figure.getBounds().getCopy();
		DiagramRootEditPart diagramEditPart = (DiagramRootEditPart) hostEditPart.getRoot();
		IFigure contentPane = diagramEditPart.getContentPane();
		contentPane.translateToAbsolute(bounds);
		EditPartViewer viewer = hostEditPart.getViewer();
		Control control = viewer.getControl();
		while (control != null && false == control instanceof Shell) {
			bounds.translate(control.getBounds().x, control.getBounds().y);
			control = control.getParent();
		}

		Font font = figure.getFont();
		FontData fontData = font.getFontData()[0];
		int fontHeightInPixel = fontData.getHeight();

		// TODO: this needs some work...
		int width = Math.max(fontHeightInPixel * (numColumns + 3), hostEditPart.getContentPane().getBounds().width);
		int height = Math.max(fontHeightInPixel * (numLines + 4), MIN_EDITOR_HEIGHT);
		
		xtextEditorComposite.setBounds(bounds.x, bounds.y, width, height);
	}

	private CompositeNode getCompositeNode(EObject semanticElement) {
		NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(semanticElement);
		if (nodeAdapter != null) {
			final CompositeNode parserNode = nodeAdapter.getParserNode();
			return parserNode;
		}
		return null;
	}

	private boolean isDocumentHasErrors(final IXtextDocument xtextDocument) {
		return (xtextDocument.readOnly(new IUnitOfWork<Boolean, XtextResource>() {
			public Boolean exec(XtextResource state) throws Exception {
				IParseResult parseResult = state.getParseResult();
				return !state.getErrors().isEmpty() || parseResult == null || !parseResult.getParseErrors().isEmpty();
			}
		}));
	}

	
	

	/**
	 * @author CEA LIST
	 * This method is used for explicitly re-activating the key binding of the context diagram editor
	 */
	@SuppressWarnings({ "restriction", "deprecation" })
	private void activateServices() {
		
		// Get the service
		final IKeyBindingService service = EditorUtils.getMultiDiagramEditor().getEditorSite().getKeyBindingService();


		final IEditorPart editor = xtextEditor ;

		if(editor != null) {
			// active the service for this inner editor
			if(service instanceof INestableKeyBindingService) {
				final INestableKeyBindingService nestableService = (INestableKeyBindingService)service;
				nestableService.activateKeyBindingService(editor.getEditorSite());

			} else {
				WorkbenchPlugin.log("MultiPageEditorPart.activateSite()   Parent key binding service was not an instance of INestableKeyBindingService.  It was an instance of " + service.getClass().getName() + " instead."); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
	}

	/**
	 * @author CEA LIST
	 * 
	 * Deactivate services: old nested site if any and keybinding service if there is no active editor.
	 * Deactivate the key binding service.
	 * Deactivate it only if there is no editor selected.
	 * 
	 * This method is used for explicitly re-activating the key binding of the context diagram editor
	 */
	@SuppressWarnings({ "restriction", "deprecation" })
	private void deactivateServices(boolean immediate) {

		final IEditorPart editor = xtextEditor;
		final IKeyBindingService service = EditorUtils.getMultiDiagramEditor().getEditorSite().getKeyBindingService();
		if(editor != null || immediate) {
			// There is no selected page, so deactivate the active service.
			if(service instanceof INestableKeyBindingService) {
				final INestableKeyBindingService nestableService = (INestableKeyBindingService)service;
				nestableService.activateKeyBindingService(null);
			} else {
				WorkbenchPlugin.log("MultiPageEditorPart.deactivateSite()   Parent key binding service was not an instance of INestableKeyBindingService.  It was an instance of " + service.getClass().getName() + " instead."); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
	}
	
}
