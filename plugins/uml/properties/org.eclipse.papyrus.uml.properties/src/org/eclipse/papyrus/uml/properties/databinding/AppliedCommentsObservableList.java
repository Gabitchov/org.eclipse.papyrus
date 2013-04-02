/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sebastien Poissonnet (CEA LIST) sebastien.poissonnet@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.databinding;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.tools.databinding.PapyrusObservableList;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;

public class AppliedCommentsObservableList extends PapyrusObservableList {

	public AppliedCommentsObservableList(EditingDomain domain, Element source) {
		super(getAppliedCommentsList(source), domain, source, UMLPackage.eINSTANCE.getElement_OwnedComment());
	}

	private static List<Comment> getAppliedCommentsList(Element source) {
		List<Comment> result = new LinkedList<Comment>();

		Iterator<Setting> it = UML2Util.getNonNavigableInverseReferences(source).iterator();
		while(it.hasNext()) {
			Setting setting = it.next();
			if(setting.getEStructuralFeature() == UMLPackage.Literals.COMMENT__ANNOTATED_ELEMENT) {
				if(setting.getEObject() instanceof Comment) {
					Comment comment = (Comment)setting.getEObject();

					// small bugfix...
					// UML2Util.getNonNavigableInverseReferences returns more element than
					// needed, especially elements that are not real ones
					// so we must check if they are contained by the current resource or
					// not...
					boolean isProxy = false;
					for(Element annotatedElement : comment.getAnnotatedElements()) {
						if(annotatedElement.eResource() == null) {
							isProxy = true;
						}
					}

					// this is the real element, not a ghost one. display it in the list
					if(!isProxy) {
						if(comment.getAnnotatedElements().contains(source)) {
							result.add(comment);
						}
					}

				}
			}
		}

		return result;
	}

	@Override
	protected void refreshCacheList() {
		if(isDisposed()) {
			return;
		}
		wrappedList.clear();
		wrappedList.addAll(getAppliedCommentsList((Element)source));
		fireListChange(null);
	}

	@Override
	public Command getAddAllCommand(Collection<?> values) {
		throw new UnsupportedOperationException();
		//		return super.getAddAllCommand(values);
	}

	@Override
	public Command getAddAllCommand(int index, Collection<?> values) {
		throw new UnsupportedOperationException();
		//		return super.getAddAllCommand(index, values);
	}

	@Override
	public Command getAddCommand(int index, Object value) {
		throw new UnsupportedOperationException();
		//		return super.getAddCommand(index, value);
	}

	@Override
	public Command getAddCommand(Object value) {
		Assert.isTrue(value instanceof Comment);

		Comment comment = (Comment)value;

		//Add the comment to source#ownedComment
		CompoundCommand addAppliedCommentCommand = new CompoundCommand("Add applied comment");
		addAppliedCommentCommand.append(super.getAddCommand(value));

		//Add the source element to comment#annotatedElement
		//		List<Element> values = new LinkedList<Element>(comment.getAnnotatedElements());
		//		values.add((Element)source);
		//		
		//		SetRequest setRequest = new SetRequest(comment, UMLPackage.eINSTANCE.getComment_AnnotatedElement(), values);
		//		IElementEditService provider = getProvider();
		//
		//		addAppliedCommentCommand.append(getCommandFromRequests(provider, Collections.singletonList(setRequest)));


		AddCommand addCommand = new AddCommand(editingDomain, comment, UMLPackage.eINSTANCE.getComment_AnnotatedElement(), source);
		addAppliedCommentCommand.append(addCommand);

		return addAppliedCommentCommand;
	}

	@Override
	public Command getRemoveCommand(Object value) {
		Assert.isTrue(value instanceof Comment);

		CompoundCommand removeAppliedCommentCommand = new CompoundCommand("Remove applied comment");
		Comment comment = (Comment)value;

		if(comment.getAnnotatedElements().size() <= 1) {
			return super.getRemoveCommand(value);
		}

		//Remove the source element to comment#annotatedElement
		List<Element> values = new LinkedList<Element>(comment.getAnnotatedElements());
		values.remove(source);
		SetRequest setRequest = new SetRequest(comment, UMLPackage.eINSTANCE.getComment_AnnotatedElement(), values);
		IElementEditService provider = getProvider();

		removeAppliedCommentCommand.append(getCommandFromRequests(provider, Collections.singletonList(setRequest)));


		//		if(editingDomain != null) {
		//			RemoveCommand command = new RemoveCommand(editingDomain, comment, UMLPackage.eINSTANCE.getComment_AnnotatedElement(), source);
		//			return command;
		//		}

		return removeAppliedCommentCommand;
	}

	@Override
	public Command getRemoveAllCommand(Collection<?> values) {

		Iterator<?> itr = values.iterator();
		Comment comment;
		Element value;
		List<Element> values_;
		CompoundCommand removeAppliedCommentCommand = new CompoundCommand("Remove applied comment");

		while(itr.hasNext()) {
			value = (Element)itr.next();
			Assert.isTrue(value instanceof Comment);
			comment = (Comment)value;

			if(comment.getAnnotatedElements().size() <= 1) {
				removeAppliedCommentCommand.append(super.getRemoveCommand(value));
			} else {
				values_ = new LinkedList<Element>(comment.getAnnotatedElements());
				values_.remove(source);
				SetRequest setRequest = new SetRequest(comment, UMLPackage.eINSTANCE.getComment_AnnotatedElement(), values_);
				IElementEditService provider = getProvider();

				removeAppliedCommentCommand.append(getCommandFromRequests(provider, Collections.singletonList(setRequest)));
			}

		}

		return removeAppliedCommentCommand;
	}

	//
	// Unsupported operations
	//

	@Override
	public Command getClearCommand() {
		throw new UnsupportedOperationException();
		//		return super.getClearCommand();
	}

	@Override
	public List<Command> getMoveCommands(int oldIndex, int newIndex) {
		throw new UnsupportedOperationException();
		//		return super.getMoveCommands(oldIndex, newIndex);
	}

	@Override
	public Command getRemoveCommand(int index) {
		throw new UnsupportedOperationException();
		//		return super.getRemoveCommand(index);
	}

	@Override
	public Command getSetCommand(int index, Object value) {
		throw new UnsupportedOperationException();
		//		return super.getSetCommand(index, value);
	}



}
