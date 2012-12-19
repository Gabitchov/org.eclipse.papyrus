package org.eclipse.papyrus.uml.textedit.operation.xtext.ui.contributions;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.papyrus.uml.alf.ui.contributions.AbstractAlfReconciler;
import org.eclipse.xtext.gmf.glue.edit.part.IXTextSemanticValidator;
import org.eclipse.xtext.gmf.glue.edit.part.IXtextEMFReconciler;
import org.eclipse.xtext.gmf.glue.edit.part.PopupXtextEditorHelper;
import org.eclipse.xtext.gmf.glue.partialEditing.SourceViewerHandle;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;

import com.google.inject.Injector;

/**
 * Overrides the default closeEditor implementation to allow for serialization of textual representations in case of errors
 * 
 * @author CEA LIST - Initial implementation and API
 *
 */
public class AlfPopupXtextEditorHelper extends PopupXtextEditorHelper {

	public AlfPopupXtextEditorHelper(IGraphicalEditPart editPart, Injector xtextInjector, IXtextEMFReconciler modelReconciler, String textToEdit, String fileExtension, IXTextSemanticValidator semanticValidator) {
		super(editPart, xtextInjector, modelReconciler, textToEdit, fileExtension, semanticValidator);
	}

	/** 
	 * Overrides the default closeEditor implementation to allow for serialization in case of errors
	 * 
	 * @see org.eclipse.xtext.gmf.glue.edit.part.PopupXtextEditorHelper#closeEditor(boolean)
	 */
	public void closeEditor(boolean isReconcile) {
		if (sourceViewerHandle != null) {
			boolean documentHasErrors = false ;
			if (isReconcile) {
				final IXtextDocument xtextDocument = sourceViewerHandle.getDocument();
				int documentGrowth = xtextDocument.getLength() - initialDocumentSize ;
				String newText;
				try {
					newText = xtextDocument.get(editorOffset , initialEditorSize + documentGrowth);
					if (this.semanticValidator.validate()) {
						if (!isDocumentHasErrors(xtextDocument)) {
							xtextResource = partialEditor.createResource(newText) ;						
							if (xtextResource.getAllContents().hasNext())
								modelReconciler.reconcile(semanticElement, xtextResource.getAllContents().next()) ;
						}
						else {
							documentHasErrors = true ;
						}
					}
					else {
						documentHasErrors = true ;
					}
					if (documentHasErrors) {
						// Tries the default reconciliation strategy
						if (modelReconciler instanceof AbstractAlfReconciler) {
							AbstractAlfReconciler alfReconciler = (AbstractAlfReconciler)modelReconciler ;
							alfReconciler.reconcileWithError(hostEditPart, semanticElement, newText) ;
						}
						else {
							documentHasErrors = true ;	
						}
					}
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
			}
			xtextEditorComposite.setVisible(false);
			xtextEditorComposite.dispose() ;
			// TODO If documentHasErrors: Put an error marker on the edited element
		}
		SourceViewerHandle.bindPartialModelEditorClass(null) ;
	}

}
