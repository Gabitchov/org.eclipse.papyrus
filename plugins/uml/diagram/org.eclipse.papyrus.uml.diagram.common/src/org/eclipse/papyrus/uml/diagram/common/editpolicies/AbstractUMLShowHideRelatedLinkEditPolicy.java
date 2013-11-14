/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.UpdaterLinkDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.AbstractShowHideRelatedLinkEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.EdgeWithNoSemanticElementRepresentationImpl;
import org.eclipse.papyrus.uml.diagram.common.helper.LinkMappingHelper;
import org.eclipse.papyrus.uml.diagram.common.ui.dialogs.ShowHideRelatedLinkSelectionDialog;
import org.eclipse.papyrus.uml.diagram.common.util.LinkEndsMapper;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Relationship;


/**
 * 
 * Abstract class used to show hide related links on UML Diagram
 * 
 */
public abstract class AbstractUMLShowHideRelatedLinkEditPolicy extends AbstractShowHideRelatedLinkEditPolicy {


	/**
	 * 
	 * Constructor.
	 * 
	 * @param host
	 *        the host for this edit policy
	 */
	public AbstractUMLShowHideRelatedLinkEditPolicy(final DiagramEditPart host) {
		super(host);
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.AbstractShowHideRelatedLinkEditPolicy#getShowHideRelatedLinkCommandWithDialog(java.util.Collection,
	 *      java.util.Map, java.util.Set, java.util.Map, java.util.Collection)
	 * 
	 * @param selectedEditParts
	 * @param availableLinks
	 * @param visibleLinks
	 * @param domain2NotationMap
	 * @param linksDescriptors
	 * @return
	 *         the command which open a dialog to ask for the user to select visible links, chained with the command to show/hide the links according
	 *         to the user selection
	 */
	@Override
	protected Command getShowHideRelatedLinkCommandWithDialog(final Collection<EditPart> selectedEditParts, final Map<EditPart, Set<EObject>> availableLinks, final Set<EObject> visibleLinks, final Map<EObject, View> domain2NotationMap, final Collection<UpdaterLinkDescriptor> linksDescriptors) {
		//0. build the mapping between semantic link and their representations used in the dialog
		final Map<EObject, LinkEndsMapper> linkMapping = new HashMap<EObject, LinkEndsMapper>();
		final Iterator<UpdaterLinkDescriptor> iter = linksDescriptors.iterator();
		while(iter.hasNext()) {
			final UpdaterLinkDescriptor current = iter.next();
			final EObject link = current.getModelElement();
			if(link instanceof Element) {
				linkMapping.put(link, createLinkEndMapper((Element)link, current));
			} else if(link instanceof EdgeWithNoSemanticElementRepresentationImpl) {
				final EObject source = ((EdgeWithNoSemanticElementRepresentationImpl)link).getSource();
				if(source instanceof Comment || source instanceof Constraint) {
					linkMapping.put(link, createLinkEndMapper((Element)source, current));
				}
			}
		}

		final TransactionalEditingDomain domain = getEditingDomain();
		final CompositeCommand compositeCommand = new CompositeCommand("Show/Hide Related Link Command"); //$NON-NLS-1$
		final ICommand cmd = getOpenDialogCommand(domain, selectedEditParts, availableLinks, visibleLinks, linkMapping);
		compositeCommand.add(cmd);
		compositeCommand.add(getComputeCommandResultCommand(domain, cmd, visibleLinks, domain2NotationMap, linksDescriptors));
		return new ICommandProxy(compositeCommand);
	}





	/**
	 * 
	 * @param descriptor
	 *        the link descriptor
	 * @return
	 *         the collection of link descriptors without some invalid descriptor (we get this case when the link doesn't have source AND target, but
	 *         only ends)
	 */
	protected Collection<UpdaterLinkDescriptor> removeInvalidLinkDescriptor(final Collection<UpdaterLinkDescriptor> descriptor) {
		final Collection<UpdaterLinkDescriptor> firstResult = super.removeInvalidLinkDescriptor(descriptor);
		final Collection<UpdaterLinkDescriptor> result = new ArrayList<UpdaterLinkDescriptor>();
		final Iterator<UpdaterLinkDescriptor> iter = firstResult.iterator();
		while(iter.hasNext()) {
			final UpdaterLinkDescriptor current = iter.next();
			final EObject modelElement = current.getModelElement();

			/*
			 * for example, for association between Class1 and class2, we get a link descriptor between class1 and class2 BUT another one between
			 * class1 and class1...
			 */
			if(!isAnOrientedLink(modelElement)) {
				EObject src = current.getSource();
				EObject target = current.getDestination();
				if(src == target) {
					final Collection<?> sources = LinkMappingHelper.getSource((Element)modelElement);
					final Collection<?> targets = LinkMappingHelper.getTarget((Element)modelElement);
					if(sources.size() > 1 && sources.equals(targets)) {
						int nbOccurencesInSource = 0;
						final Iterator<?> iterSrc = sources.iterator();
						while(nbOccurencesInSource < 2 && iterSrc.hasNext()) {
							if(iterSrc.next() == src) {
								nbOccurencesInSource++;
							}
						}

						int nbOccurencesInTarget = 0;
						final Iterator<?> iterTarget = targets.iterator();
						while(nbOccurencesInTarget < 2 && iterTarget.hasNext()) {
							if(iterTarget.next() == src) {
								nbOccurencesInTarget++;
							}
						}

						if(nbOccurencesInSource > 1 || nbOccurencesInTarget > 1) {
							//do nothing;
						} else {
							continue;//we must exclude it!
						}
					} else if(!(sources.contains(src) && targets.contains(src))) {
						continue;
					}
				}
			}
			result.add(current);
		}
		return result;
	}

	/**
	 * 
	 * @return
	 *         <code>true</code> if the link is oriented and <code>false</code> if not.
	 *         If not, that is to say than {@link LinkMappingHelper} should returns the same values for sources and targets
	 */
	public static final boolean isAnOrientedLink(final EObject link) {
		if(link instanceof DirectedRelationship) {
			return true;
		} else if(link instanceof Relationship) {
			return false;
		} else if(link instanceof Connector) {
			return false;
		} else if(link instanceof Comment || link instanceof Constraint) {
			return true;
		}
		return false;
	}




	/**
	 * 
	 * @param element
	 *        an element
	 * @return
	 *         a linkEndsMapper according to this element
	 */
	public static final LinkEndsMapper createLinkEndMapper(final Element element, final UpdaterLinkDescriptor descriptor) {
		Collection<?> ends;
		Collection<?> sources;
		Collection<?> targets;
		if(element instanceof Comment || element instanceof Constraint) {
			ends = Collections.emptyList();
			sources = Collections.singletonList(descriptor.getSource());
			targets = Collections.singletonList(descriptor.getDestination());
		} else if(isAnOrientedLink(element)) {
			ends = Collections.emptyList();
			sources = LinkMappingHelper.getSource(element);
			targets = LinkMappingHelper.getTarget(element);
		} else {
			ends = LinkMappingHelper.getSource(element);
			sources = Collections.emptyList();
			targets = Collections.emptyList();
		}
		return new LinkEndsMapper(element, ends, sources, targets);
	}

	/**
	 * 
	 * @param domain
	 *        the editing domain
	 * @return
	 *         the command to open the dialog to choose the link to show
	 */
	protected ICommand getOpenDialogCommand(final TransactionalEditingDomain domain, final Collection<EditPart> selectedEditPart, final Map<EditPart, Set<EObject>> availableLinks, final Collection<EObject> initialSelection, final Map<EObject, LinkEndsMapper> linkMapping) {
		final ICommand cmd = new AbstractTransactionalCommand(domain, "Open Show/HideDialogCommand", null) {//$NON-NLS-1$

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				final ShowHideRelatedLinkSelectionDialog dialog = new ShowHideRelatedLinkSelectionDialog(Display.getDefault().getActiveShell(), getLabelProvider(), new AbstractShowHideRelatedLinkEditPolicy.LinkContentProvider(availableLinks), availableLinks, linkMapping);
				dialog.setTitle("Show/Hide Links");//$NON-NLS-1$
				dialog.setMessage("Choose the links to show.");//$NON-NLS-1$
				dialog.setInput(selectedEditPart);
				dialog.setInitialSelection(initialSelection);
				dialog.setExpandedElements(selectedEditPart.toArray());
				dialog.setContainerMode(true);
				int status = dialog.open();
				if(status == Window.CANCEL) {
					return CommandResult.newCancelledCommandResult();
				}
				return CommandResult.newOKCommandResult(Arrays.asList(dialog.getResult()));
			}
		};

		return cmd;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.AbstractShowHideRelatedLinkEditPolicy#getLabelProvider()
	 * 
	 * @return
	 */
	@Override
	protected ILabelProvider getLabelProvider() {
		return new UMLLabelProvider();
	}
}
