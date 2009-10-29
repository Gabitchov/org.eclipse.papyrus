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
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.extensionpoints.editors.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.core.runtime.content.IContentTypeManager;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ISynchronizable;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelExtension;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IModelGenerator;
import org.eclipse.ui.texteditor.spelling.SpellingContext;

/**
 * 
 */
public class AntlrReconcileStrategy implements IReconcilingStrategy {

	/**
	 * Spelling problem collector.
	 */
	private class ProblemCollector {

		/** Annotation model. */
		private IAnnotationModel fAnnotationModel;

		/** Annotations to add. */
		private Map fAddAnnotations;

		/** Lock object for modifying the annotations. */
		private Object fLockObject;

		/**
		 * Initializes this collector with the given annotation model.
		 * 
		 * @param annotationModel
		 *            the annotation model
		 */
		public ProblemCollector(IAnnotationModel annotationModel) {
			Assert.isLegal(annotationModel != null);
			fAnnotationModel = annotationModel;
			if (fAnnotationModel instanceof ISynchronizable)
				fLockObject = ((ISynchronizable) fAnnotationModel).getLockObject();
			else
				fLockObject = fAnnotationModel;
		}

		public void accept(Throwable exception) {
			if (exception instanceof RecognitionException) {
				fAddAnnotations.put(new ErrorAnnotation(false, exception.getLocalizedMessage()), new Position(
						((RecognitionException) exception).token.getCharPositionInLine(),
						((RecognitionException) exception).token.getText().length()));
			}
		}

		public void accept(IStatus status) {
			// parse the message of the status to get the line number and position
			Throwable exception = status.getException();

			if (exception instanceof MismatchedTokenException) {
				addErrorAnnotation((MismatchedTokenException) exception);
			} else if (exception instanceof NoViableAltException) {
				addErrorAnnotation((NoViableAltException) exception);
			} else if (exception instanceof RecognitionException) {
				addErrorAnnotation((RecognitionException) exception);
			}

		}

		protected Object addErrorAnnotation(RecognitionException exception) {
			int offset = exception.token.getCharPositionInLine();
			String value = exception.token.getText();
			int length = (value != null) ? value.length() : 0;
			StringBuffer buffer = new StringBuffer();
			buffer.append('[');
			buffer.append(offset);
			buffer.append(',');
			buffer.append(offset + length);
			buffer.append("] ");
			return fAddAnnotations.put(new ErrorAnnotation(true, buffer.toString() + exception), new Position(offset,
					length));
		}

		protected Object addErrorAnnotation(MismatchedTokenException exception) {
			int offset = exception.token.getCharPositionInLine();
			String value = exception.token.getText();
			int length = (value != null) ? value.length() : 0;
			StringBuffer buffer = new StringBuffer();
			buffer.append('[');
			buffer.append(offset);
			buffer.append(',');
			buffer.append(offset + length);
			buffer.append("] ");
			buffer.append("Found \'");
			buffer.append(value);
			buffer.append("\' ");
			buffer.append("excepting ");
			buffer.append(exception.expecting);

			return fAddAnnotations.put(new ErrorAnnotation(true, buffer.toString()), new Position(offset, length));
		}

		protected Object addErrorAnnotation(NoViableAltException exception) {
			int offset = exception.token.getCharPositionInLine();
			String value = exception.token.getText();
			int length = (value != null) ? value.length() : 0;
			StringBuffer buffer = new StringBuffer();
			buffer.append('[');
			buffer.append(offset);
			buffer.append(',');
			buffer.append(offset + length);
			buffer.append("] ");
			buffer.append("Found \'");
			buffer.append(value);
			buffer.append("\' ");
			buffer.append("Excepting ");
			buffer.append(exception.grammarDecisionDescription);

			return fAddAnnotations.put(new ErrorAnnotation(true, buffer.toString()), new Position(offset, length));
		}

		/*
		 * @see org.eclipse.ui.texteditor.spelling.ISpellingProblemCollector#beginCollecting()
		 */
		public void beginCollecting() {
			fAddAnnotations = new HashMap();
		}

		/*
		 * @see org.eclipse.ui.texteditor.spelling.ISpellingProblemCollector#endCollecting()
		 */
		public void endCollecting() {

			List toRemove = new ArrayList();

			synchronized (fLockObject) {
				Iterator iter = fAnnotationModel.getAnnotationIterator();
				while (iter.hasNext()) {
					Annotation annotation = (Annotation) iter.next();
					if (ErrorAnnotation.TYPE.equals(annotation.getType()))
						toRemove.add(annotation);
				}
				Annotation[] annotationsToRemove = (Annotation[]) toRemove.toArray(new Annotation[toRemove.size()]);

				if (fAnnotationModel instanceof IAnnotationModelExtension)
					((IAnnotationModelExtension) fAnnotationModel).replaceAnnotations(annotationsToRemove,
							fAddAnnotations);
				else {
					for (int i = 0; i < annotationsToRemove.length; i++)
						fAnnotationModel.removeAnnotation(annotationsToRemove[i]);
					for (iter = fAddAnnotations.keySet().iterator(); iter.hasNext();) {
						Annotation annotation = (Annotation) iter.next();
						fAnnotationModel.addAnnotation(annotation, (Position) fAddAnnotations.get(annotation));
					}
				}
			}

			fAddAnnotations = null;
		}
	}

	/** Text content type */
	private static final IContentType TEXT_CONTENT_TYPE = Platform.getContentTypeManager().getContentType(
			IContentTypeManager.CT_TEXT);

	/** The text editor to operate on. */
	private ISourceViewer viewer;

	/** The document to operate on. */
	private IDocument document;

	/** The progress monitor. */
	private IProgressMonitor progressMonitor;

	/** The spelling context containing the Java source content type. */
	private SpellingContext fSpellingContext;

	private ProblemCollector problemCollector;

	private IModelGenerator modelGenerator;

	/**
	 * Creates a new comment reconcile strategy.
	 * 
	 * @param viewer
	 *            the source viewer
	 * @param spellingService
	 *            the spelling service to use
	 */
	public AntlrReconcileStrategy(ISourceViewer viewer, IModelGenerator modelGenerator) {
		Assert.isNotNull(viewer);
		this.viewer = viewer;
		this.modelGenerator = modelGenerator;
		fSpellingContext = new SpellingContext();
		fSpellingContext.setContentType(getContentType());

	}

	/*
	 * @see org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension#initialReconcile()
	 */
	public void initialReconcile() {
		reconcile(new Region(0, document.getLength()));
	}

	/*
	 * @seeorg.eclipse.jface.text.reconciler.IReconcilingStrategy#reconcile(org.eclipse.jface.text.
	 * reconciler.DirtyRegion,org.eclipse.jface.text.IRegion)
	 */
	public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
		reconcile(new Region(0, document.getLength()));
	}

	/*
	 * @see
	 * org.eclipse.jface.text.reconciler.IReconcilingStrategy#reconcile(org.eclipse.jface.text.IRegion
	 * )
	 */
	public void reconcile(final IRegion region) {
		if (getAnnotationModel() == null)
			return;

		// launch the validation using ANTLR
		try {
			problemCollector.beginCollecting();
			ISafeRunnable runnable = new ISafeRunnable() {

				public void run() throws Exception {

					// here, launch check on document
					String text = document.get(region.getOffset(), region.getLength());
					IStatus status = modelGenerator.validate(text);
					if (!status.isOK()) {
						if (!status.isMultiStatus()) {
							problemCollector.accept(status);
						} else {
							IStatus[] children = ((MultiStatus) status).getChildren();
							for (IStatus child : children) {
								problemCollector.accept(child);
							}
						}

					}

				}

				public void handleException(Throwable x) {
				}
			};
			SafeRunner.run(runnable);
		} finally {
			problemCollector.endCollecting();
		}
	}

	/**
	 * Returns the content type of the underlying editor input.
	 * 
	 * @return the content type of the underlying editor input or <code>null</code> if none could be
	 *         determined
	 */
	protected IContentType getContentType() {
		return TEXT_CONTENT_TYPE;
	}

	/**
	 * Returns the document which is checked.
	 * 
	 * @return the document on which the check is run
	 */
	protected final IDocument getDocument() {
		return document;
	}

	/**
	 * Tells this reconciling strategy on which document it will work. This method will be called
	 * before any other method and can be called multiple times. The regions passed to the other
	 * methods always refer to the most recent document passed into this method.
	 * 
	 * @param document
	 *            the document on which this strategy will work
	 */
	public void setDocument(IDocument document) {
		this.document = document;
		problemCollector = createProblemCollector();
	}

	/**
	 * Creates a new problem collector.
	 * 
	 * @return the collector or <code>null</code> if none is available
	 */
	protected ProblemCollector createProblemCollector() {
		IAnnotationModel model = getAnnotationModel();
		if (model == null) {
			return null;
		}
		return new ProblemCollector(model);
	}

	/**
	 * Tells this reconciling strategy with which progress monitor it will work. This method will be
	 * called before any other method and can be called multiple times.
	 * 
	 * @param monitor
	 *            the progress monitor with which this strategy will work
	 */
	public final void setProgressMonitor(IProgressMonitor monitor) {
		progressMonitor = monitor;
	}

	/**
	 * Returns the annotation model to be used by this reconcile strategy.
	 * 
	 * @return the annotation model of the underlying editor input or <code>null</code> if none
	 *         could be determined
	 */
	protected IAnnotationModel getAnnotationModel() {
		return viewer.getAnnotationModel();
	}

}
