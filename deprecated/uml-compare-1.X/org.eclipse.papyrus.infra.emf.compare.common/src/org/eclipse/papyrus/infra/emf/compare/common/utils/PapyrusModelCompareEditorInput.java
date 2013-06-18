/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.common.utils;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareViewerPane;
import org.eclipse.compare.Splitter;
import org.eclipse.compare.contentmergeviewer.ContentMergeViewer;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.ui.ModelCompareInput;
import org.eclipse.emf.compare.ui.editor.ModelCompareEditorInput;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer;
import org.eclipse.emf.compare.ui.viewer.structure.ModelStructureMergeViewer;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.emf.compare.common.messages.Messages;
import org.eclipse.papyrus.infra.emf.compare.ui.content.transactional.viewer.PapyrusTransactionalModelContentMergeViewer;
import org.eclipse.papyrus.infra.emf.compare.ui.structural.viewer.PapyrusCustomizableParameterizedStructureMergeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;

/**
 * 
 * the ModelInput for Papyrus Compare
 * 
 */
public class PapyrusModelCompareEditorInput extends ModelCompareEditorInput implements ICompareViewerProvider {

	/** the editor */
	protected IEditorPart editor;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param snapshot
	 *        the snapshot
	 * @param editor
	 *        the editor for the comparison
	 * @param ancestor
	 *        the ancestor
	 * @param left
	 *        the left Object to compare (used to display the name of elementthe element
	 * @param right
	 */
	public PapyrusModelCompareEditorInput(final ComparisonSnapshot snapshot, final IEditorPart editor) {
		super(snapshot);
		this.editor = editor;
	}

	/**
	 * This methods allows to set the labels displayed at the top of the content merger viewers
	 * These labels are used too for the title of the editor
	 * 
	 * @param leftLabel
	 *        the left label
	 * @param leftImage
	 *        the left image
	 * @param rightLabel
	 *        the right label
	 * @param rightImage
	 *        the right image
	 */
	public void initLabels(final String leftLabel, final Image leftImage, final String rightLabel, final Image rightImage) {
		CompareConfiguration cc = getCompareConfiguration();
		cc.setLeftLabel(leftLabel);
		cc.setRightLabel(rightLabel);
		cc.setLeftImage(leftImage);
		cc.setRightImage(rightImage);
		setTitle(NLS.bind(Messages.PapyrusModelCompareEditorInput_CompareTitle, leftLabel, rightLabel));
	}

	/**
	 * 
	 * @see org.eclipse.emf.compare.ui.editor.ModelCompareEditorInput#createMergeViewer(org.eclipse.compare.CompareViewerPane,
	 *      org.eclipse.compare.CompareConfiguration)
	 * 
	 * @param pane
	 * @param config
	 * @return
	 */
	@Override
	protected ModelContentMergeViewer createMergeViewer(final CompareViewerPane pane, final CompareConfiguration config) {
		return new PapyrusTransactionalModelContentMergeViewer(pane, config, editor);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see CompareEditorInput#createOutlineContents(Composite, int)
	 */
	@Override
	public Control createOutlineContents(final Composite parent, final int direction) {
		final Splitter splitter = new Splitter(parent, direction);

		final CompareViewerPane pane = new CompareViewerPane(splitter, SWT.NONE);

		//structureMergeViewer = new ModelStructureMergeViewer(pane, getCompareConfiguration());
		CompareConfiguration conf = getCompareConfiguration();
		//		conf.s
		structureMergeViewer = new PapyrusCustomizableParameterizedStructureMergeViewer(pane, getCompareConfiguration(), editor);
		pane.setContent(structureMergeViewer.getTree());

		structureMergeViewer.setInput(preparedInput);

		return splitter;
	}

	/**
	 * 
	 * @see org.eclipse.emf.compare.ui.editor.ModelCompareEditorInput#saveChanges(org.eclipse.core.runtime.IProgressMonitor)
	 * 
	 * @param monitor
	 */
	@Override
	public void saveChanges(final IProgressMonitor monitor) {
		//normally it ok, there is nothing to do to save notation and di files
		super.saveChanges(monitor);
	}

	/**
	 * 
	 * @return
	 *         the content merge viewer for this input. The returned value can be <code>null</code> if the viewer has not been yet created
	 */
	public ContentMergeViewer getContentMergeViewer() {
		return this.contentMergeViewer;
	}

	/**
	 * 
	 * @return
	 *         the structure merge viewer for this input. The retruned value can be <code>null</code> if the viewer has not been yet created
	 */
	public ModelStructureMergeViewer getStructureMergeViewer() {
		return this.structureMergeViewer;
	}

	/**
	 * 
	 * @return
	 *         the prepared input
	 */
	public ModelCompareInput getpreparedModelCompareInput() {
		prepareInput(new NullProgressMonitor());
		return this.preparedInput;
	}

	/**
	 * 
	 * @return
	 *         the EditingDomain for the current Editor, or <code>null</code> if not found
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		TransactionalEditingDomain domain = null;
		if(this.editor instanceof IAdaptable) {
			domain = (TransactionalEditingDomain)this.editor.getAdapter(TransactionalEditingDomain.class);
		}
		return domain;
	}
}
