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
package org.eclipse.papyrus.uml.compare.subelement.editor;

import java.util.List;
import java.util.Map;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareEditorInput;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.ui.ModelCompareInput;
import org.eclipse.emf.compare.ui.editor.ModelCompareEditorInput;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.commands.CheckedOperationHistory;
import org.eclipse.papyrus.infra.emf.compare.common.editor.AbstractPapyrusCompareEditor;
import org.eclipse.papyrus.infra.emf.compare.common.utils.PapyrusModelCompareEditorInput;
import org.eclipse.papyrus.infra.emf.compare.diff.utils.PapyrusCompareOptions;
import org.eclipse.papyrus.uml.compare.diff.services.UMLDiffService;
import org.eclipse.papyrus.uml.compare.diff.services.nested.NestedMatchService;
import org.eclipse.papyrus.uml.compare.diff.services.nested.NestedMergeUtils;
import org.eclipse.papyrus.uml.compare.subelement.editor.input.UMLModelCompareEditorInputWithTwoEditingDomain;
import org.eclipse.papyrus.uml.compare.subelement.input.CompareUMLFileInput;
import org.eclipse.papyrus.uml.compare.utils.RootObject;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.uml2.uml.NamedElement;

public class CompareUMLModelElementEditor extends AbstractPapyrusCompareEditor {

	/** the type of the editor */
	public static final String EDITOR_TYPE = "org.eclipse.papyrus.uml.compare.models.editor"; //$NON-NLS-1$

	private CompareUMLFileInput tmpInput;

	/**
	 * the compared elements
	 */
	private EObject roots[];

	public CompareUMLModelElementEditor() {
		addUndoRedoListeners();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.compare.common.editor.AbstractPapyrusCompareEditor#getCompareOptions(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject)
	 * 
	 * @param monitor
	 * @param leftObject
	 * @param rightObject
	 * @return
	 */
	@Override
	protected Map<String, Object> getCompareOptions(final IProgressMonitor monitor, final EObject leftObject, final EObject rightObject) {
		return NestedMergeUtils.getMergeOptions(monitor, leftObject, rightObject);
	}

	@Override
	protected MatchModel doMatch(IProgressMonitor monitor, final EObject left, final EObject right, final Map<String, Object> options) throws InterruptedException {
		return NestedMatchService.doContentMatch(left, right, options);
	}

	/**
	 * A part of this method is duplicated from DiffService#doDiff
	 * 
	 * @param match
	 * @return
	 */
	@Override
	protected DiffModel doDiff(final MatchModel match, final Map<String, Object> options) {
		return UMLDiffService.doDiff(match, false, options);
	}


	@Override
	protected ModelCompareEditorInput createModelCompareEditorInput(final ComparisonSnapshot snapshot) {
		return new UMLModelCompareEditorInputWithTwoEditingDomain(snapshot, this);
	}



	@Override
	protected void configureInput(final PapyrusModelCompareEditorInput input) {

		//TODO : warning if we use a label provider, warning to the stereotype use 
		CompareConfiguration cc = input.getCompareConfiguration();
		ILabelProvider prov = getLabelProvider();
		String leftQName = null;
		String rightQName = null;
		final EObject left = tmpInput.getComparedElements().get(0);

		if(left instanceof NamedElement) {
			leftQName = ((NamedElement)left).getQualifiedName();
		}
		final EObject right = tmpInput.getComparedElements().get(1);


		if(right instanceof NamedElement) {
			rightQName = ((NamedElement)right).getQualifiedName();
		}

		String leftFile = left.eResource().getURI().toString() + ":/"; //$NON-NLS-1$
		String rightFile = right.eResource().getURI().toString() + ":/"; //$NON-NLS-1$
		cc.setLeftLabel(leftFile + leftQName);
		cc.setRightLabel(rightFile + rightQName);
		cc.setLeftImage(prov.getImage(left));
		cc.setRightImage(prov.getImage(right));
		cc.setProperty(RootObject.LEFT_OBJECT_KEY, left);
		cc.setProperty(RootObject.RIGHT_OBJECT_KEY, right);

		//configure the merge options
		final Map<String, Object> options = getCompareOptions(null, left, right);//we are looking for the merge options
		final Boolean leftToRight = (Boolean)options.get(PapyrusCompareOptions.KEY_ALLOW_MERGE_LEFT_TO_RIGHT);
		final Boolean rightToLeft = (Boolean)options.get(PapyrusCompareOptions.KEY_ALLOW_MERGE_RIGHT_TO_LEFT);
		if(rightToLeft != null) {
			cc.setLeftEditable(rightToLeft);
		}
		if(leftToRight != null) {
			cc.setRightEditable(leftToRight);
		}
		if(roots == null) {
			roots = new EObject[2];
			roots[0] = left;
			roots[1] = right;
		}
	};

	@Override
	public void init(final IEditorSite site, final IEditorInput input) throws PartInitException {

		if(input instanceof CompareUMLFileInput) {
			this.tmpInput = (CompareUMLFileInput)input;
			final List<EObject> files = ((CompareUMLFileInput)input).getComparedElements();

			ModelCompareEditorInput newInput = getCompareInput(files.get(0), files.get(1));
			super.init(site, newInput);
		} else {
			super.init(site, input);
		}
	}

	@Override
	public void dispose() {
		super.dispose();
		tmpInput.getComparedElements().clear();
		CompareEditorInput input = (CompareEditorInput)getEditorInput();
		CompareConfiguration conf = input.getCompareConfiguration();
		conf.setProperty(RootObject.LEFT_OBJECT_KEY, null);
		conf.setProperty(RootObject.LEFT_OBJECT_KEY, null);
		roots = null;
		tmpInput = null;
		removeUndoRedoListener();
	}

	@Override
	protected IOperationHistory getIOperationHistory() {
		return CheckedOperationHistory.getInstance();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.compare.common.editor.AbstractPapyrusCompareEditor#resetInput()
	 * 
	 */
	@Override
	protected void resetInput() {
		IEditorInput input = getEditorInput();
		assert (input instanceof PapyrusModelCompareEditorInput);
		final TreeViewer viewer = ((PapyrusModelCompareEditorInput)input).getStructureMergeViewer();
		final PapyrusModelCompareEditorInput newInput = (PapyrusModelCompareEditorInput)getCompareInput(roots[0], roots[1]);
		final ModelCompareInput input2 = newInput.getpreparedModelCompareInput();
		viewer.setInput(input2);
	}
}
