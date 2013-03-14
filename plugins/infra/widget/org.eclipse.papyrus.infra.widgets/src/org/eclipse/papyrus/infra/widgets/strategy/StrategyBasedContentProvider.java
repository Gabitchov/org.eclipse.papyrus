/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.strategy;

import java.util.List;

import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.widgets.providers.EncapsulatedContentProvider;

public class StrategyBasedContentProvider extends EncapsulatedContentProvider {

	protected TreeBrowseStrategy browseStrategy;

	protected TreeBrowseStrategy revealStrategy;

	protected StructuredViewer viewer;

	public StrategyBasedContentProvider(TreeBrowseStrategy browseStrategy, TreeBrowseStrategy revealStrategy) {
		setRevealStrategy(revealStrategy);
		setBrowseStrategy(browseStrategy);
	}

	public void setBrowseStrategy(TreeBrowseStrategy strategy) {
		if(strategy != null) {
			browseStrategy = strategy;
			encapsulated = browseStrategy;
		}
	}

	public void setRevealStrategy(TreeBrowseStrategy strategy) {
		if(strategy != null) {
			revealStrategy = strategy;
		}
	}

	@Override
	public void dispose() {
		super.dispose();
		if(browseStrategy != null) {
			browseStrategy.dispose();
		}
		if(revealStrategy != null) {
			revealStrategy.dispose();
		}
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		super.inputChanged(viewer, oldInput, newInput);
		if(viewer instanceof StructuredViewer) {
			this.viewer = (StructuredViewer)viewer;
		} else {
			this.viewer = null;
		}

		revealStrategy.inputChanged(viewer, oldInput, newInput);
		browseStrategy.inputChanged(viewer, oldInput, newInput);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Reveals and selects the given semantic elements
	 */
	@Override
	public void revealSemanticElement(List<?> semanticElementsList) {
		revealStrategy.revealSemanticElement(semanticElementsList);
		//		List<Object> containerElements = new LinkedList<Object>();
		//
		//		for(Object semanticElement : semanticElementsList) {
		//			TreePath path = revealStrategy.findPath(semanticElement, getElements(viewer.getInput()));
		//			if(path.getSegmentCount() > 0) {
		//				viewer.reveal(path);
		//				containerElements.add(path.getLastSegment());
		//			}
		//		}
		//
		//		viewer.setSelection(new StructuredSelection(containerElements));
	}

	@Override
	public TreeBrowseStrategy getBrowseStrategy() {
		return browseStrategy;
	}

	@Override
	public TreeBrowseStrategy getRevealStrategy() {
		return revealStrategy;
	}
}
