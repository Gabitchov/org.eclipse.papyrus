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
package org.eclipse.papyrus.uml.compare.subelement.editor.input;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareViewerPane;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSetSnapshot;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.ui.ModelCompareInput;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.papyrus.uml.compare.subelement.Activator;
import org.eclipse.papyrus.uml.compare.subelement.utils.CompareConfigurationUtils;
import org.eclipse.papyrus.uml.compare.subelement.viewer.UMLTransactionalModelContentMergeViewerWithTwoEditingDomain;
import org.eclipse.papyrus.uml.compare.utils.RootObject;
import org.eclipse.papyrus.uml.compare.utils.UMLModelCompareEditorInput;
import org.eclipse.ui.IEditorPart;

/**
 * 
 * The Input for the nested UMLCompareEditor
 * 
 */
public class UMLModelCompareEditorInputWithTwoEditingDomain extends UMLModelCompareEditorInput {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param snapshot
	 *        the comparison snapshot
	 * @param editor
	 *        the editor
	 */
	public UMLModelCompareEditorInputWithTwoEditingDomain(final ComparisonSnapshot snapshot, final IEditorPart editor) {
		super(snapshot, editor);
	}


	/**
	 * 
	 * @see org.eclipse.emf.compare.ui.editor.ModelCompareEditorInput#createModelCompareInput(org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot)
	 * 
	 * @param snap
	 * @return
	 */
	@Override
	protected ModelCompareInput createModelCompareInput(final ComparisonSnapshot snap) {
		if(snap instanceof ComparisonResourceSetSnapshot) {
			return new ModelCompareInputWithTwoEditingDomain(getLeftEditingDomain(), getRightEditingDomain(), ((ComparisonResourceSetSnapshot)snap).getMatchResourceSet(), ((ComparisonResourceSetSnapshot)snap).getDiffResourceSet());
		}
		return new ModelCompareInputWithTwoEditingDomain(getLeftEditingDomain(), getRightEditingDomain(), ((ComparisonResourceSnapshot)snap).getMatch(), ((ComparisonResourceSnapshot)snap).getDiff());
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.compare.common.utils.PapyrusModelCompareEditorInput#getEditingDomain()
	 * 
	 * @return
	 */
	@Override
	protected TransactionalEditingDomain getEditingDomain() {
		throw new UnsupportedOperationException("The method getEditingDomain can't be used in this context");
	}

	/**
	 * 
	 * @return
	 *         the left editing domain
	 */
	protected TransactionalEditingDomain getLeftEditingDomain() {
		final CompareConfiguration cc = getCompareConfiguration();
		final Object leftObject = cc.getProperty(RootObject.LEFT_OBJECT_KEY);
		assert leftObject instanceof EObject;
		return TransactionUtil.getEditingDomain(leftObject);
	}

	/**
	 * 
	 * @return
	 *         the right editing domain
	 */
	protected TransactionalEditingDomain getRightEditingDomain() {
		final CompareConfiguration cc = getCompareConfiguration();
		final Object leftObject = cc.getProperty(RootObject.RIGHT_OBJECT_KEY);
		assert leftObject instanceof EObject;
		return TransactionUtil.getEditingDomain(leftObject);

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.compare.utils.UMLModelCompareEditorInput#createMergeViewer(org.eclipse.compare.CompareViewerPane,
	 *      org.eclipse.compare.CompareConfiguration)
	 * 
	 * @param pane
	 * @param config
	 * @return
	 */
	@Override
	protected ModelContentMergeViewer createMergeViewer(CompareViewerPane pane, CompareConfiguration config) {
		return new UMLTransactionalModelContentMergeViewerWithTwoEditingDomain(pane, config, editor);
	}

	@Override
	public void saveChanges(IProgressMonitor monitor) {
		CompareConfiguration cc = getCompareConfiguration();
		IEditorPart leftEditor = (IEditorPart)cc.getProperty(CompareConfigurationUtils.LEFT_EDITOR);
		IEditorPart rightEPart = (IEditorPart)cc.getProperty(CompareConfigurationUtils.RIGHT_EDITOR);
		leftEditor.doSave(new NullProgressMonitor());
		rightEPart.doSave(new NullProgressMonitor());
	}

	@Override
	public boolean isDirty() {
		CompareConfiguration cc = getCompareConfiguration();
		IEditorPart leftEditor = (IEditorPart)cc.getProperty(CompareConfigurationUtils.LEFT_EDITOR);
		IEditorPart rightEPart = (IEditorPart)cc.getProperty(CompareConfigurationUtils.RIGHT_EDITOR);
		//FIXME : bug when the editors are closed
		try {
			return leftEditor.isDirty() || rightEPart.isDirty();
		} catch (Exception e) {
			Activator.log.error("the editor should be closed", e);
		}
		return false;
	}

}
