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

import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.reconciler.AbstractReconciler;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension;


/**
 * Reconciler that uses several independent strategies.
 */
public class MultiReconciler extends AbstractReconciler {

	/** The reconciling strategy. */
	private List<IReconcilingStrategy> fStrategies;


	/**
	 * Creates a new reconciler that uses several reconciling strategies to
	 * reconcile its document independent of the type of the document's contents.
	 *
	 * @param strategies the reconciling strategies to be used
	 * @param isIncremental the indication whether strategy is incremental or not
	 */
	public MultiReconciler(List<IReconcilingStrategy> strategies, boolean isIncremental) {
		Assert.isNotNull(strategies);
		fStrategies= strategies;
		for(IReconcilingStrategy strategy : fStrategies) {
			if (strategy instanceof IReconcilingStrategyExtension) {
				IReconcilingStrategyExtension extension= (IReconcilingStrategyExtension)strategy;
				extension.setProgressMonitor(getProgressMonitor());
			}
		}

		setIsIncrementalReconciler(isIncremental);
	}

	/*
	 * @see IReconciler#getReconcilingStrategy(String)
	 */
	public IReconcilingStrategy getReconcilingStrategy(String contentType) {
		Assert.isNotNull(contentType);
		return fStrategies.get(0);
	}

	/*
	 * @see AbstractReconciler#process(DirtyRegion)
	 */
	protected void process(DirtyRegion dirtyRegion) {

		for(IReconcilingStrategy strategy : fStrategies) {
			if(dirtyRegion != null)
				strategy.reconcile(dirtyRegion, dirtyRegion);
			else {
				IDocument document= getDocument();
				if (document != null)
					strategy.reconcile(new Region(0, document.getLength()));
			}
		}
	}

	/*
	 * @see AbstractReconciler#reconcilerDocumentChanged(IDocument)
	 */
	protected void reconcilerDocumentChanged(IDocument document) {
		for(IReconcilingStrategy strategy : fStrategies) {
			strategy.setDocument(document);
		}
	}

	/*
	 * @see AbstractReconciler#setProgressMonitor(IProgressMonitor)
	 */
	public void setProgressMonitor(IProgressMonitor monitor) {
		super.setProgressMonitor(monitor);
		
		for(IReconcilingStrategy strategy : fStrategies) {
			if (strategy instanceof IReconcilingStrategyExtension) {
				IReconcilingStrategyExtension extension= (IReconcilingStrategyExtension) strategy;
				extension.setProgressMonitor(monitor);
			}
		}
		
	}

	/*
	 * @see AbstractReconciler#initialProcess()
	 */
	protected void initialProcess() {
		
		for(IReconcilingStrategy strategy : fStrategies) {
			if (strategy instanceof IReconcilingStrategyExtension) {
				IReconcilingStrategyExtension extension= (IReconcilingStrategyExtension) strategy;
				extension.initialReconcile();
			}
		}
	}

}
