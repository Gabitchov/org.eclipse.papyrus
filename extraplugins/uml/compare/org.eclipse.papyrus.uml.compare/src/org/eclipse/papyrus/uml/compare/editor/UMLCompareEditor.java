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
package org.eclipse.papyrus.uml.compare.editor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.MoveModelElement;
import org.eclipse.emf.compare.match.MatchOptions;
import org.eclipse.emf.compare.match.engine.GenericMatchScopeProvider;
import org.eclipse.emf.compare.match.engine.IMatchEngine;
import org.eclipse.emf.compare.match.engine.IMatchScopeProvider;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.ui.editor.ModelCompareEditorInput;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.compare.common.editor.EMFCompareEditor;
import org.eclipse.papyrus.infra.emf.compare.common.utils.PapyrusModelCompareEditorInput;
import org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.PapyrusEMFCompareInstance;
import org.eclipse.papyrus.uml.compare.utils.RootObject;
import org.eclipse.papyrus.uml.compare.utils.UMLDiffService;
import org.eclipse.papyrus.uml.compare.utils.UMLMatchEngine;
import org.eclipse.papyrus.uml.compare.utils.UMLModelCompareEditorInput;
import org.eclipse.uml2.uml.NamedElement;



public class UMLCompareEditor extends EMFCompareEditor {

	/** the type of the editor */
	public static final String EDITOR_TYPE = "PapyrusUMLCompare"; //$NON-NLS-1$

	/**
	 * @param servicesRegistry
	 * @param rawModel
	 * 
	 */
	public UMLCompareEditor(final ServicesRegistry servicesRegistry, final PapyrusEMFCompareInstance rawModel) {
		super(servicesRegistry, rawModel);
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
		final Map<String, Object> options = super.getCompareOptions(monitor, leftObject, rightObject);
		//we override the options for the comparison
		options.put(MatchOptions.OPTION_PROGRESS_MONITOR, monitor);
		options.put(MatchOptions.OPTION_IGNORE_ID, Boolean.TRUE);
		options.put(MatchOptions.OPTION_IGNORE_XMI_ID, Boolean.TRUE);
		options.put(MatchOptions.OPTION_MATCH_SCOPE_PROVIDER, getMatchScopeProvider(leftObject, rightObject));
		return options;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.compare.common.editor.AbstractPapyrusCompareEditor#getMatchScopeProvider(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.EObject)
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	@Override
	protected IMatchScopeProvider getMatchScopeProvider(final EObject left, final EObject right) {
		return new GenericMatchScopeProvider(left, right);
	}


	@Override
	protected MatchModel doContentMatch(final EObject left, final EObject right, final Map<String, Object> options) throws InterruptedException {
		final IMatchEngine engine = new UMLMatchEngine();
		final MatchModel result = engine.contentMatch(left, right, options);
		engine.reset();
		return result;
	}

	@Override
	protected ComparisonSnapshot doContentCompare(final EObject left, final EObject right) {
		final ComparisonSnapshot snapshot = super.doContentCompare(left, right);
		cleanSnapshot(snapshot);
		return snapshot;
	}

	/**
	 * A part of this method is duplicated from DiffService#doDiff
	 * 
	 * @param match
	 * @return
	 */
	@Override
	protected DiffModel doDiff(final MatchModel match) {
		return UMLDiffService.doDiff(match, false);
	}

	/**
	 * This method allows to remove unnecessary differences :
	 * we don't show element move from the root element (see bug 377143)
	 * 
	 * @param snapshot
	 *        the snapshot
	 */
	private void cleanSnapshot(final ComparisonSnapshot snapshot) {
		final EList<EObject> contents = snapshot.eContents();
		final DiffModel root = (DiffModel)contents.get(0);
		final EList<DiffElement> differences = root.getDifferences();
		final List<DiffElement> toRemove = new ArrayList<DiffElement>();
		for(DiffElement current : differences) {
			if(current instanceof MoveModelElement) {
				EObject leftTarget = ((MoveModelElement)current).getLeftTarget();
				EObject rightTarget = ((MoveModelElement)current).getRightTarget();
				if(leftTarget == null && rightTarget == null) {
					toRemove.add(current);
				}
			}
		}
		for(DiffElement current : toRemove) {
			EcoreUtil.remove(current);
		}
	}


	@Override
	protected ModelCompareEditorInput createModelCompareEditorInput(final ComparisonSnapshot snapshot) {
		return new UMLModelCompareEditorInput(snapshot, this);
	}

	@Override
	protected void configureInput(final PapyrusModelCompareEditorInput input) {

		//TODO : warning if we use a label provider, warnign to the stereotype use 
		CompareConfiguration cc = input.getCompareConfiguration();
		ILabelProvider prov = getLabelProvider();
		String leftQName = null;
		String rightQName = null;
		EObject left = this.rawModel.getLeft();
		if(left instanceof NamedElement) {
			leftQName = ((NamedElement)left).getQualifiedName();
		}
		EObject right = this.rawModel.getRight();
		if(right instanceof NamedElement) {
			rightQName = ((NamedElement)right).getQualifiedName();
		}

		cc.setLeftLabel(leftQName);
		cc.setRightLabel(rightQName);
		cc.setLeftImage(prov.getImage(left));
		cc.setRightImage(prov.getImage(right));
		cc.setProperty(RootObject.LEFT_OBJECT_KEY, rawModel.getLeft());
		cc.setProperty(RootObject.RIGHT_OBJECT_KEY, rawModel.getRight());
	};
}
