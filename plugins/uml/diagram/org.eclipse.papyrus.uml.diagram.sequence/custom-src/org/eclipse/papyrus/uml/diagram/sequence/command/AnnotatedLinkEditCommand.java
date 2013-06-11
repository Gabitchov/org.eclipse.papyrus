/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AnnotatedLinkEditPart;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Observation;
import org.eclipse.uml2.uml.TimeObservation;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class AnnotatedLinkEditCommand extends AbstractTransactionalCommand {

	private AnnotatedLinkEditPart annotatedLink;

	private Element oldSourceElement;

	private Element oldTargetElement;

	private Element newSourceElement;

	private Element newTargetElement;

	/**
	 * Constructor.
	 * 
	 * @param domain
	 * @param label
	 * @param affectedFiles
	 */
	public AnnotatedLinkEditCommand(TransactionalEditingDomain domain) {
		super(domain, "edit annotated link", null);
	}

	@Override
	public boolean canExecute() {
		if(newSourceElement != null) {
			if(!(newSourceElement instanceof Comment || newSourceElement instanceof Observation || newSourceElement instanceof Constraint)) {
				return false;
			}
			if(newSourceElement == newTargetElement || newSourceElement == oldTargetElement) {
				return false;
			}
		} else if(oldSourceElement != null) {
			if(!(oldSourceElement instanceof Comment || oldSourceElement instanceof Observation || oldSourceElement instanceof Constraint)) {
				return false;
			}
			if(oldSourceElement == newTargetElement || oldSourceElement == newTargetElement) {
				return false;
			}
		}
		Element targetElement = newTargetElement == null ? oldTargetElement : newTargetElement;
		Element sourceElement = newSourceElement == null ? oldSourceElement : newSourceElement;
		return checkTargetType(sourceElement, targetElement);
	}

	/**
	 * Enables to:
	 * 1. Create comment to each Element, such as Observations and Constraint.
	 * 2. Create constraint for each Element.
	 */
	private boolean checkTargetType(Element sourceElement, Element targetElement) {
		if(sourceElement == null || targetElement == null) {
			return false;
		}
		if(sourceElement instanceof DurationObservation || sourceElement instanceof TimeObservation) {
			return targetElement instanceof NamedElement;
		}
		return true;
	}

	/**
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 * 
	 * @param monitor
	 * @param info
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if(!canExecute()) {
			return CommandResult.newErrorCommandResult("Unable to create annotated link");
		}
		Element targetElement = newTargetElement == null ? oldTargetElement : newTargetElement;
		Element sourceElement = newSourceElement == null ? oldSourceElement : newSourceElement;
		if(targetElement == null || sourceElement == null) {
			return CommandResult.newErrorCommandResult("Unable to create annotated link");
		}
		if(oldSourceElement != null) {
			if(oldSourceElement instanceof Comment) {
				((Comment)oldSourceElement).getAnnotatedElements().remove(targetElement);
			} else if(oldSourceElement instanceof DurationObservation) {
				((DurationObservation)oldSourceElement).getEvents().remove(targetElement);
			} else if(oldSourceElement instanceof TimeObservation) {
				((TimeObservation)oldSourceElement).setEvent(null);
			} else if(oldSourceElement instanceof Constraint) {
				((Constraint)oldSourceElement).getConstrainedElements().remove(targetElement);
			}
		}
		if(sourceElement instanceof Comment) {
			((Comment)sourceElement).getAnnotatedElements().add(targetElement);
		} else if(sourceElement instanceof DurationObservation && targetElement instanceof NamedElement) {
			((DurationObservation)sourceElement).getEvents().add((NamedElement)targetElement);
		} else if(sourceElement instanceof TimeObservation && targetElement instanceof NamedElement) {
			((TimeObservation)sourceElement).setEvent((NamedElement)targetElement);
		} else if(sourceElement instanceof Constraint) {
			((Constraint)sourceElement).getConstrainedElements().add(targetElement);
		}
		return CommandResult.newOKCommandResult(sourceElement);
	}

	private Element resolveElement(EditPart editPart) {
		if(editPart == null) {
			return null;
		}
		Object model = editPart.getModel();
		if(model instanceof View) {
			EObject element = ViewUtil.resolveSemanticElement((View)model);
			if(element instanceof Element) {
				return (Element)element;
			}
		}
		return null;
	}

	/**
	 * @param source
	 *        the source to set
	 */
	public void setSource(EditPart source) {
		newSourceElement = resolveElement(source);
	}

	/**
	 * @param target
	 *        the target to set
	 */
	public void setTarget(EditPart target) {
		newTargetElement = resolveElement(target);
	}

	/**
	 * @return the annotatedLink
	 */
	public AnnotatedLinkEditPart getAnnotatedLink() {
		return annotatedLink;
	}

	/**
	 * @param annotatedLink
	 *        the annotatedLink to set
	 */
	public void setAnnotatedLink(AnnotatedLinkEditPart annotatedLink) {
		this.annotatedLink = annotatedLink;
		if(annotatedLink != null) {
			oldSourceElement = resolveElement(annotatedLink.getSource());
			oldTargetElement = resolveElement(annotatedLink.getTarget());
		}
	}
}
