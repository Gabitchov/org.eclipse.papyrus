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

import java.util.Map;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.ui.editor.ModelCompareEditorInput;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.compare.common.editor.EMFCompareEditor;
import org.eclipse.papyrus.infra.emf.compare.common.utils.PapyrusModelCompareEditorInput;
import org.eclipse.papyrus.infra.emf.compare.diff.utils.PapyrusCompareOptions;
import org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.PapyrusEMFCompareInstance;
import org.eclipse.papyrus.uml.compare.diff.services.UMLDiffService;
import org.eclipse.papyrus.uml.compare.diff.services.nested.NestedMatchService;
import org.eclipse.papyrus.uml.compare.diff.services.nested.NestedMergeUtils;
import org.eclipse.papyrus.uml.compare.utils.RootObject;
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
		return new UMLModelCompareEditorInput(snapshot, this);
	}

	@Override
	protected void configureInput(final PapyrusModelCompareEditorInput input) {

		//TODO : warning if we use a label provider, warning to the stereotype use 
		CompareConfiguration cc = input.getCompareConfiguration();
		ILabelProvider prov = getLabelProvider();
		String leftQName = null;
		String rightQName = null;
		final EObject left = this.rawModel.getLeft();
		if(left instanceof NamedElement) {
			leftQName = ((NamedElement)left).getQualifiedName();
		}
		final EObject right = this.rawModel.getRight();
		if(right instanceof NamedElement) {
			rightQName = ((NamedElement)right).getQualifiedName();
		}

		cc.setLeftLabel(leftQName);
		cc.setRightLabel(rightQName);
		cc.setLeftImage(prov.getImage(left));
		cc.setRightImage(prov.getImage(right));
		cc.setProperty(RootObject.LEFT_OBJECT_KEY, rawModel.getLeft());
		cc.setProperty(RootObject.RIGHT_OBJECT_KEY, rawModel.getRight());

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
	};
}
