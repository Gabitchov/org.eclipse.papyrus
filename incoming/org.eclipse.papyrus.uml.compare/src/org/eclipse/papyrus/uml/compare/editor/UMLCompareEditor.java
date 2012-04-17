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

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.ui.editor.ModelCompareEditorInput;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.compare.common.editor.EMFCompareEditor;
import org.eclipse.papyrus.infra.emf.compare.common.utils.PapyrusModelCompareEditorInput;
import org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.PapyrusEMFCompareInstance;
import org.eclipse.papyrus.infra.emf.compare.ui.utils.LabelProviderUtil;
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

	protected UMLCompareEditor() {
		super();
		// TODO used by the compare file editor
	}

	@Override
	protected ModelCompareEditorInput createModelCompareEditorInput(ComparisonSnapshot snapshot) {
		PapyrusModelCompareEditorInput input = new PapyrusModelCompareEditorInput(snapshot, this);
		CompareConfiguration cc = input.getCompareConfiguration();
		//TODO : manage the Element which are not NamedElement
		//TODO : warning if we use a label provider, warnign to the stereotype use 
		LabelProvider prov = (LabelProvider)LabelProviderUtil.INSTANCE.getLabelProviderFor(this);
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
		return input;
	}
}
