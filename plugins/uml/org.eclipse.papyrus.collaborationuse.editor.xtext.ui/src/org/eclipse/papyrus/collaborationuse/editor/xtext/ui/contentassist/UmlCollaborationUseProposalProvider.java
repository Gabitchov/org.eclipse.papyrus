/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.collaborationuse.editor.xtext.ui.contentassist;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.collaborationuse.editor.xtext.ui.contributions.UMLCollaborationUseEditorUtil;
import org.eclipse.papyrus.collaborationuse.editor.xtext.umlCollaborationUse.CollaborationUseRule;
import org.eclipse.papyrus.collaborationuse.editor.xtext.validation.UmlCollaborationUseJavaValidator;
import org.eclipse.papyrus.common.editor.xtext.umlCommon.QualifiedName;
import org.eclipse.papyrus.core.utils.DisplayUtils;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Type;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

/**
 * Customization of the default ProposalProvider of the textual property editor
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
public class UmlCollaborationUseProposalProvider extends AbstractUmlCollaborationUseProposalProvider {

	/** the label provider */
	private ILabelProvider labelProvider = DisplayUtils.getLabelProvider();

	/**
	 * Provides custom completion for the specifying the type of a {@link CollaborationUse}
	 * 
	 * @see org.eclipse.papyrus.collaborationuse.editor.xtext.ui.contentassist.AbstractUmlCollaborationUseProposalProvider#completeCollaborationUseRule_Type(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.xtext.Assignment, org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext,
	 *      org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 * 
	 * @param model
	 * @param assignment
	 * @param context
	 * @param acceptor
	 */
	@Override
	public void completeCollaborationUseRule_Type(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// the customization consists in proposing nothing. Proposals are handled by other methods.
		List<Collaboration> allCollaboration = new ArrayList<Collaboration>();
		allCollaboration.addAll(getRecursivelyOwnedCollaboration(UmlCollaborationUseJavaValidator.getInstance().getModel()));
		allCollaboration.addAll(getRecursivelyImportedCollaboration(UmlCollaborationUseJavaValidator.getInstance().getModel()));
		for(Collaboration c : allCollaboration) {
			if(c.getName().contains(context.getPrefix())) {
				String displayString = c.getQualifiedName();
				String completionString = UMLCollaborationUseEditorUtil.getTypeLabel(c);
				ICompletionProposal completionProposal = createCompletionProposalWithReplacementOfPrefix(c, completionString, displayString, context);
				acceptor.accept(completionProposal);
			}
		}
		completeRuleCall(((RuleCall)assignment.getTerminal()), context, acceptor);

	}

	/**
	 * Provides custom completion for the root element in a qualified name
	 * 
	 * @see org.eclipse.papyrus.property.editor.xtext.ui.contentassist.AbstractUmlPropertyProposalProvider#completeTypeRule_Path(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.xtext.Assignment, org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext,
	 *      org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 */
	@Override
	public void completeTypeRule_Path(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {

		Namespace root = UmlCollaborationUseJavaValidator.getInstance().getModel();

		if(root == null)
			return;

		// first accept the root Model
		String completionString = root.getName() + "::"; //$NON-NLS-1$
		String displayString = root.getName() + "::"; //$NON-NLS-1$
		//String displayString = c.getName() ;
		ICompletionProposal completionProposal = createCompletionProposalWithReplacementOfPrefix(root, completionString, displayString, context);
		acceptor.accept(completionProposal);

		// then accepts all packages imported by Model
		List<Package> importedPackages = root.getImportedPackages();
		for(Package p : importedPackages) {
			if(p.getName().startsWith(context.getPrefix())) {
				completionString = p.getName().substring(context.getPrefix().length()) + "::"; //$NON-NLS-1$
				displayString = p.getName() + "::"; //$NON-NLS-1$
				//String displayString = c.getName() ;
				completionProposal = createCompletionProposal(root, completionString, displayString, context);
				List<Collaboration> accessibleCollaboration = getRecursivelyOwnedCollaboration(p);
				accessibleCollaboration.addAll(getRecursivelyImportedCollaboration(p));
				if(accessibleCollaboration.size() != 0) {
					acceptor.accept(completionProposal);
				}
			}
		}

	}

	/**
	 * Provides custom completion for specifying the type of a {@link CollaborationUse}, taking into account the path if the name is qualified
	 * 
	 * @see org.eclipse.papyrus.property.editor.xtext.ui.contentassist.AbstractUmlPropertyProposalProvider#completeTypeRule_Type(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.xtext.Assignment, org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext,
	 *      org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 */
	@Override
	public void completeTypeRule_Type(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {

		Namespace namespace = UmlCollaborationUseJavaValidator.getInstance().getContextElement().getNearestPackage();
		if(model instanceof org.eclipse.papyrus.collaborationuse.editor.xtext.umlCollaborationUse.TypeRule) {
			org.eclipse.papyrus.collaborationuse.editor.xtext.umlCollaborationUse.TypeRule typeRule = (org.eclipse.papyrus.collaborationuse.editor.xtext.umlCollaborationUse.TypeRule)model;
			QualifiedName path = typeRule.getPath();
			while(path.getRemaining() != null) {
				path = path.getRemaining();
			}
			namespace = path.getPath();
		} else if(!(model instanceof CollaborationUseRule))
			return;
		for(NamedElement n : namespace.getOwnedMembers()) {
			if(n instanceof Collaboration) {
				if(n.getName().startsWith(context.getPrefix())) {
					String completionString = n.getName().substring(context.getPrefix().length());
					String displayString = n.getName();
					//String displayString = c.getName() ;
					ICompletionProposal completionProposal = createCompletionProposal(n, completionString, displayString, context);
					acceptor.accept(completionProposal);
				}
			}
			if(n instanceof Namespace) {
				for(Type t : getRecursivelyOwnedCollaboration((Namespace)n)) {
					if(t.getName().startsWith(context.getPrefix())) {
						String completionString = t.getName().substring(context.getPrefix().length());
						String displayString = t.getName();
						//String displayString = c.getName() ;
						ICompletionProposal completionProposal = createCompletionProposal(t, completionString, displayString, context);
						acceptor.accept(completionProposal);
					}
				}
			}
		}

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.collaborationuse.editor.xtext.ui.contentassist.AbstractUmlCollaborationUseProposalProvider#completeQualifiedName_Path(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.xtext.Assignment, org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext,
	 *      org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 * 
	 * @param model
	 * @param assignment
	 * @param context
	 * @param acceptor
	 */
	@Override
	public void completeQualifiedName_Path(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		//The customization consists in proposing nothing. Proposals are already handled by other methods
	}

	/**
	 * Provides custom completion for a path, taking into account the path which has already been specified
	 * 
	 * @see org.eclipse.papyrus.collaborationuse.editor.xtext.ui.contentassist.AbstractUmlCollaborationUseProposalProvider#completeQualifiedName_Remaining(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.xtext.Assignment, org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext,
	 *      org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 * 
	 * @param model
	 * @param assignment
	 * @param context
	 * @param acceptor
	 */
	@Override
	public void completeQualifiedName_Remaining(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {


		QualifiedName path = (QualifiedName)model;
		for(NamedElement n : path.getPath().getOwnedMembers()) {
			if(n instanceof Package) {
				if(n.getName().startsWith(context.getPrefix())) {
					String completionString = n.getName().substring(context.getPrefix().length()) + "::"; //$NON-NLS-1$
					String displayString = n.getName() + "::"; //$NON-NLS-1$
					//String displayString = c.getName() ;
					ICompletionProposal completionProposal = createCompletionProposal(n, completionString, displayString, context);
					List<Collaboration> accessibleCollaboration = getRecursivelyOwnedCollaboration((Namespace)n);
					accessibleCollaboration.addAll(getRecursivelyImportedCollaboration((Namespace)n));
					if(accessibleCollaboration.size() != 0) {
						acceptor.accept(completionProposal);
					}
				}
			}
		}
		for(Package p : path.getPath().getImportedPackages()) {
			if(p.getName().startsWith(context.getPrefix())) {
				String completionString = p.getName().substring(context.getPrefix().length()) + "::"; //$NON-NLS-1$
				String displayString = p.getName() + "::"; //$NON-NLS-1$
				//String displayString = c.getName() ;
				ICompletionProposal completionProposal = createCompletionProposal(p, completionString, displayString, context);
				List<Collaboration> accessibleCollaboration = getRecursivelyOwnedCollaboration(p);
				accessibleCollaboration.addAll(getRecursivelyImportedCollaboration(p));
				if(accessibleCollaboration.size() != 0) {
					acceptor.accept(completionProposal);
				}
			}
		}

	}

	/**
	 * 
	 * @see org.eclipse.xtext.ui.editor.contentassist.AbstractJavaBasedContentProposalProvider#completeKeyword(org.eclipse.xtext.Keyword,
	 *      org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext, org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 * 
	 * @param keyword
	 * @param contentAssistContext
	 * @param acceptor
	 */
	@Override
	public void completeKeyword(Keyword keyword, ContentAssistContext contentAssistContext, ICompletionProposalAcceptor acceptor) {
		/*
		 * we avoid to have "::" after a correct Type (model::Collaboration1:: )
		 * and we want are able to complete something like "model:"
		 */
		if(keyword.getValue().equals("::") && !contentAssistContext.getPrefix().equals(":")) { //$NON-NLS-1$ //$NON-NLS-2$
			//do nothing
		} else {
			ICompletionProposal proposal = createCompletionProposal(keyword.getValue(), getKeywordDisplayString(keyword), getImage(keyword), contentAssistContext);
			getPriorityHelper().adjustKeywordPriority(proposal, contentAssistContext.getPrefix());
			acceptor.accept(proposal);
		}
	}

	/**
	 * Private Utility method for creating a completion proposal
	 * 
	 * @param namedElement
	 *        The named element for which completion proposal must be created
	 * @param completionString
	 *        The actual completion string
	 * @param displayString
	 *        The way the completion is displayed in the completion list
	 * @param context
	 *        Some information related to the context of the completion
	 * @return
	 */
	@Override
	protected ICompletionProposal createCompletionProposal(NamedElement namedElement, String completionString, String displayString, ContentAssistContext context) {
		String additionalProposalInfo = "" + namedElement.getQualifiedName() + "\n" + '(' + namedElement.eClass().getName() + ')'; //$NON-NLS-1$ //$NON-NLS-2$

		ICompletionProposal completionProposal = new CompletionProposal(completionString, // String to be inserted 
		context.getOffset(), // Offset
		context.getSelectedText().length(), // Replacement length
		completionString.length(), // cursorPosition
		labelProvider.getImage(namedElement), // image
		" " + displayString, // displayString //$NON-NLS-1$
		null, // contextInformation
		additionalProposalInfo // additionalProposalInfo
		);
		return completionProposal;
	}

	/**
	 * 
	 * Private Utility method for creating a completion proposal with replacement of prefix
	 * 
	 * @param namedElement
	 *        The named element for which completion proposal must be created
	 * @param completionString
	 *        The actual completion string
	 * @param displayString
	 *        The way the completion is displayed in the completion list
	 * @param context
	 *        Some information related to the context of the completion
	 * @return
	 */
	@Override
	protected ICompletionProposal createCompletionProposalWithReplacementOfPrefix(NamedElement namedElement, String completionString, String displayString, ContentAssistContext context) {
		String additionalProposalInfo = "" + namedElement.getQualifiedName() + "\n" + '(' + namedElement.eClass().getName() + ')'; //$NON-NLS-1$ //$NON-NLS-2$

		ICompletionProposal completionProposal = new CompletionProposal(completionString, // String to be inserted 
		context.getOffset() - context.getPrefix().length(), // Offset
		context.getPrefix().length(), // Replacement length
		completionString.length(), // cursorPosition
		labelProvider.getImage(namedElement), // image
		" " + displayString, // displayString //$NON-NLS-1$
		null, // contextInformation
		additionalProposalInfo // additionalProposalInfo
		);
		return completionProposal;
	}

	/**
	 * Private Utility method for creating a completion proposal
	 * 
	 * @param completionString
	 *        The actual completion string
	 * @param displayString
	 *        The way the completion is displayed in the completion list
	 * @param context
	 *        Some information related to the context of the completion
	 * @return
	 */
	@Override
	protected ICompletionProposal createCompletionProposal(String completionString, String displayString, ContentAssistContext context) {

		ICompletionProposal completionProposal = new CompletionProposal(completionString, // String to be inserted 
		context.getOffset(), // Offset
		context.getSelectedText().length(), // Replacement length
		completionString.length(), // cursorPosition
		null, // image
		" " + displayString, // displayString //$NON-NLS-1$
		null, // contextInformation
		null // additionalProposalInfo
		);
		return completionProposal;
	}

	/**
	 * Utility methods wich returns the list of classifiers that are directly or indirectly owned by a context namespace
	 * 
	 * @param context
	 *        The context namespace
	 * @return the list of classifiers that are directly or indirectly owned by the context namespace
	 */
	private List<Collaboration> getRecursivelyOwnedCollaboration(Namespace context) {
		List<Collaboration> recursivelyOwnedClassifiers = new ArrayList<Collaboration>();

		List<Element> allOwnedElements = context.getOwnedElements();
		for(Element e : allOwnedElements) {
			if(e instanceof Collaboration)
				recursivelyOwnedClassifiers.add((Collaboration)e);
			else if(e instanceof Namespace)
				recursivelyOwnedClassifiers.addAll(getRecursivelyOwnedCollaboration((Package)e));
		}

		return recursivelyOwnedClassifiers;
	}

	/**
	 * Utility methods which returns the list of classifiers that are directly or indirectly owned by the namespaces imported by a context namespace
	 * 
	 * @param context
	 *        The context namespace
	 * @return the list of classifiers that are directly or indirectly owned by the namespaces imported by the context namespace
	 */
	private List<Collaboration> getRecursivelyImportedCollaboration(Namespace context) {
		List<Collaboration> recursivelyImportedClassifiers = new ArrayList<Collaboration>();

		List<Package> importedPackages = context.getImportedPackages();
		for(Package p : importedPackages) {
			recursivelyImportedClassifiers.addAll(getRecursivelyOwnedCollaboration(p));
		}

		return recursivelyImportedClassifiers;
	}
}
