/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Ansgar Radermacher - ansgar.radermacher@cea.fr CEA LIST - initial API and implementation
 *
 *******************************************************************************/

package org.eclipse.papyrus.exteditor.cdt.sync;

import org.eclipse.cdt.core.CCorePlugin;
import org.eclipse.cdt.core.dom.ast.IASTNodeSelector;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.index.IIndex;
import org.eclipse.cdt.core.model.CModelException;
import org.eclipse.cdt.core.model.CoreModel;
import org.eclipse.cdt.core.model.ICElement;
import org.eclipse.cdt.core.model.ICProject;
import org.eclipse.cdt.core.model.IFunctionDeclaration;
import org.eclipse.cdt.core.model.IParent;
import org.eclipse.cdt.core.model.ISourceRange;
import org.eclipse.cdt.core.model.ISourceReference;
import org.eclipse.cdt.core.model.ITranslationUnit;
import org.eclipse.cdt.ui.CDTUITools;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Operation;


public class RevealCurrentOperation {

	public RevealCurrentOperation(IEditorInput input, Classifier classifier, String projectName) {
		m_input = input;
		m_classifier = classifier;
		m_projectName = projectName;
	}

	public Element obtainSelectedElement(ITextSelection selection) {
		ICElement ice = CDTUITools.getEditorInputCElement(m_input);

		if(ice instanceof ITranslationUnit) {
			ICProject project = CoreModel.getDefault().getCModel().getCProject(m_projectName);

			IIndex index = null;
			try {
				index = CCorePlugin.getIndexManager().getIndex(project);
				index.acquireReadLock();

				// index = CCorePlugin.getIndexManager().getIndex(project);
				ITranslationUnit itu = (ITranslationUnit)ice;
				// hack: force re-evaluation of AST node, requires modified CDT!
				// Seems to be no longer required.
				// ASTProvider.getASTProvider().fCache.setActiveElement(itu);

				IASTTranslationUnit ast = itu.getAST(index, ITranslationUnit.AST_SKIP_INDEXED_HEADERS);
				IASTNodeSelector selector = ast.getNodeSelector(null);

				String opName = findOperation(itu, selector, itu, selection);
				if (opName != null) {
					int sep = opName.lastIndexOf("::");
					if (sep != -1) {
						opName = opName.substring(sep+2);
					}
					Operation operation = m_classifier.getOperation(opName,  null,  null);
					if (operation != null) return operation;
				}

			} catch (CModelException e) {
				System.err.println(e);
			} catch (Exception e) {
				System.err.println(e);
			} finally {
				if(index != null) {
					index.releaseReadLock();
				}
			}
		}
		return m_classifier;
	}

	/**
	 * Examine the children of a translation unit in order to extract the methods that are defined within
	 * the unit
	 * 
	 * @param itu
	 * @param selector
	 * @param parent
	 * @throws CModelException
	 */
	public String findOperation(ITranslationUnit itu, IASTNodeSelector selector, IParent parent, ITextSelection selection) throws CModelException {

		for(ICElement child : parent.getChildren()) {
			if(child instanceof IParent) {
				return findOperation(itu, selector, (IParent)child, selection);
			}
			ISourceRange range = null;
			if(child instanceof ISourceReference) {
				range = ((ISourceReference)child).getSourceRange();
			}
			if(child instanceof IFunctionDeclaration) {
				// function declaration is a superclass for method declaration (but need to trace functions differently?)
				String name = ((IFunctionDeclaration)child).getElementName();
				int pos = selection.getOffset();
				if ((pos >= range.getStartPos()) && (pos < range.getStartPos() + range.getLength())) {
					return name;
				}
			}
		}
		return null;
	}



	protected IEditorInput m_input;

	protected Classifier m_classifier;

	protected String m_projectName;
}
