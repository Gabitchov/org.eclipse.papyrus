package org.eclipse.papyrus.exteditor.cdt.editor;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.jface.text.IAutoIndentStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IEventConsumer;
import org.eclipse.jface.text.IFindReplaceTarget;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextInputListener;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.IUndoManager;
import org.eclipse.jface.text.IViewportListener;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.uml2.uml.Classifier;

/**
 * Unsuccessful attempt to create a delegating source viewer that changes the implementation of
 * the operation getSelectionProvider of a source viewer. Problem in case of CDT is that
 * source viewer is case to CSourceViewer later.
 *  
 * @author ansgar
 *
 */
public class DelegatingSourceViewer implements ISourceViewer {

	public DelegatingSourceViewer(ISourceViewer delegationTarget, Classifier classifier) {
		// super(null,  null,  null,  false, 0,  null);
		this.dt = delegationTarget;
		this.cl = classifier;
		
		sp = new ISelectionProvider() {
			
			public void setSelection(ISelection selection) {
			}
			
			public void removeSelectionChangedListener(
					ISelectionChangedListener listener) {
				System.err.println("removeSelectionChangedListener");				
			}
			
			public ISelection getSelection() {
				return new IStructuredSelection() {
					
					public boolean isEmpty() {
						return false;
					}
					
					public List toList() {
						List l = new BasicEList<Object>();
						l.add(cl);
						return l;
					}
					
					public Object[] toArray() {
						return new Object [] { cl };
					}
					
					public int size() {
						// TODO Auto-generated method stub
						return 1;
					}
					
					public Iterator iterator() {
						return null;
					}
					
					public Object getFirstElement() {
						return cl;
					}
				};
			}
			
			public void addSelectionChangedListener(ISelectionChangedListener listener) {
				// TODO Auto-generated method stub
				System.err.println("add SelectionChangedListener");
				
			}
		};
	}
	
	ISourceViewer dt;
	
	Classifier cl;

	ISelectionProvider sp;

	public StyledText getTextWidget() {
		return dt.getTextWidget();
	}

	public void setUndoManager(IUndoManager undoManager) {
		dt.setUndoManager(undoManager);
	}

	public void setTextDoubleClickStrategy(
			ITextDoubleClickStrategy strategy, String contentType) {
		dt.setTextDoubleClickStrategy(strategy, contentType);
	}

	public void setAutoIndentStrategy(IAutoIndentStrategy strategy,
			String contentType) {
		dt.setAutoIndentStrategy(strategy, contentType);	
	}

	public void setTextHover(ITextHover textViewerHover,
			String contentType) {
		dt.setTextHover(textViewerHover, contentType);
	}

	public void activatePlugins() {
		dt.activatePlugins();
	}

	public void resetPlugins() {
		dt.resetPlugins();			
	}

	public void addViewportListener(IViewportListener listener) {
		dt.addViewportListener(listener);			
	}

	public void removeViewportListener(IViewportListener listener) {
		dt.removeViewportListener(listener);
	}

	public void addTextListener(ITextListener listener) {
		dt.addTextListener(listener);			
	}

	public void removeTextListener(ITextListener listener) {
		dt.removeTextListener(listener);		
	}

	public void addTextInputListener(ITextInputListener listener) {
		dt.addTextInputListener(listener);			
	}

	public void removeTextInputListener(ITextInputListener listener) {
		dt.removeTextInputListener(listener);
	}

	public void setDocument(IDocument document) {
		dt.setDocument(document);			
	}

	public IDocument getDocument() {
		return dt.getDocument();
	}

	public void setEventConsumer(IEventConsumer consumer) {
		dt.setEventConsumer(consumer);
		
	}

	public void setEditable(boolean editable) {
		dt.setEditable(editable);
	}

	public boolean isEditable() {
		return dt.isEditable();
	}

	public void setDocument(IDocument document, int modelRangeOffset,
			int modelRangeLength) {
		dt.setDocument(document, modelRangeOffset, modelRangeLength);
	}

	public void setVisibleRegion(int offset, int length) {
		dt.setVisibleRegion(offset, length);
	}

	public void resetVisibleRegion() {
		dt.resetVisibleRegion();
	}

	public IRegion getVisibleRegion() {
		return dt.getVisibleRegion();
	}

	public boolean overlapsWithVisibleRegion(int offset, int length) {
		return dt.overlapsWithVisibleRegion(offset, length);
	}

	public void changeTextPresentation(TextPresentation presentation,
			boolean controlRedraw) {
		dt.changeTextPresentation(presentation, controlRedraw);
	}

	public void invalidateTextPresentation() {
		dt.invalidateTextPresentation();
		
	}

	public void setTextColor(Color color) {
		dt.setTextColor(color);			
	}

	public void setTextColor(Color color, int offset, int length,
			boolean controlRedraw) {
		dt.setTextColor(color, offset, length, controlRedraw);
	}

	public ITextOperationTarget getTextOperationTarget() {
		return dt.getTextOperationTarget();
	}

	public IFindReplaceTarget getFindReplaceTarget() {
		return dt.getFindReplaceTarget();
	}

	public void setDefaultPrefixes(String[] defaultPrefixes,
			String contentType) {
		dt.setDefaultPrefixes(defaultPrefixes, contentType);
		
	}

	public void setIndentPrefixes(String[] indentPrefixes,
			String contentType) {
		dt.setIndentPrefixes(indentPrefixes, contentType);			
	}

	public void setSelectedRange(int offset, int length) {
		dt.setSelectedRange(offset, length);
	}

	public Point getSelectedRange() {
		return dt.getSelectedRange();
	}

	public ISelectionProvider getSelectionProvider() {
		return dt.getSelectionProvider();
	}

	public void revealRange(int offset, int length) {
		dt.revealRange(offset, length);
	}

	public void setTopIndex(int index) {
		dt.setTopIndex(index);
	}

	public int getTopIndex() {
		return dt.getTopIndex();
	}

	public int getTopIndexStartOffset() {
		return dt.getTopIndexStartOffset();
	}

	public int getBottomIndex() {
		return dt.getBottomIndex();
	}

	public int getBottomIndexEndOffset() {
		return dt.getBottomIndexEndOffset();
	}

	public int getTopInset() {
		return dt.getTopInset();
	}

	public void configure(SourceViewerConfiguration configuration) {
		dt.configure(configuration);
	}

	public void setAnnotationHover(IAnnotationHover annotationHover) {
		dt.setAnnotationHover(annotationHover);			
	}

	public void setDocument(IDocument document,
			IAnnotationModel annotationModel) {
		dt.setDocument(document, annotationModel);
	}

	public void setDocument(IDocument document,
			IAnnotationModel annotationModel, int modelRangeOffset,
			int modelRangeLength) {
		dt.setDocument(document, annotationModel, modelRangeOffset, modelRangeLength);
		
	}

	public IAnnotationModel getAnnotationModel() {
		return dt.getAnnotationModel();
	}

	public void setRangeIndicator(Annotation rangeIndicator) {
		dt.setRangeIndicator(rangeIndicator);
		
	}

	public void setRangeIndication(int offset, int length,
			boolean moveCursor) {
		dt.setRangeIndication(offset, length, moveCursor);
	}

	public IRegion getRangeIndication() {
		return dt.getRangeIndication();
	}

	public void removeRangeIndication() {
		dt.removeRangeIndication();
	}

	public void showAnnotations(boolean show) {
		dt.showAnnotations(show);
	}
}
