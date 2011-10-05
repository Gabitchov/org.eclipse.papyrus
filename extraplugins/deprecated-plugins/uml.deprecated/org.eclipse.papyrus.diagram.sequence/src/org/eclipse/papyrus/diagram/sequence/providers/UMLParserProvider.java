/***************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Gabriel Merin Cubero (Prodevelop) – Sequence Diagram implementation
 * 				 Javier Muñoz (Prodevelop) - Messages are updated when properties changes
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;


import org.eclipse.papyrus.diagram.common.parser.TagsAdderParser;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CombinedFragmentInteractionOperatorEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionName2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionNameEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineNameEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageName2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageName3EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageName4EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageName5EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageName6EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageNameEditPart;
import org.eclipse.papyrus.diagram.sequence.parsers.MessageFormatParser;
import org.eclipse.papyrus.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.sequence.util.MessageCommonUtil;

/**
 * @generated
 */
public class UMLParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser interactionName_4004Parser;

	/**
	 * @generated
	 */
	private IParser getInteractionName_4004Parser() {
		if (interactionName_4004Parser == null) {
			interactionName_4004Parser = createInteractionName_4004Parser();
		}
		return interactionName_4004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInteractionName_4004Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("sd: {0} ");
		parser.setEditorPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser commentBody_5003Parser;

	/**
	 * @generated
	 */
	private IParser getCommentBody_5003Parser() {
		if (commentBody_5003Parser == null) {
			commentBody_5003Parser = createCommentBody_5003Parser();
		}
		return commentBody_5003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCommentBody_5003Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getComment_Body(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser interactionName_4003Parser;

	/**
	 * @generated
	 */
	private IParser getInteractionName_4003Parser() {
		if (interactionName_4003Parser == null) {
			interactionName_4003Parser = createInteractionName_4003Parser();
		}
		return interactionName_4003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInteractionName_4003Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("sd: {0} ");
		parser.setEditorPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser lifelineName_4001Parser;

	/**
	 * @generated
	 */
	private IParser getLifelineName_4001Parser() {
		if (lifelineName_4001Parser == null) {
			lifelineName_4001Parser = createLifelineName_4001Parser();
		}
		return lifelineName_4001Parser;
	}

	/**
	 * @generated NOT
	 * 
	 * modified to show lifeline name and represents
	 */
	protected IParser createLifelineName_4001Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getNamedElement_Name(), };

		// Own MessageFormatParser
		MessageFormatParser parser = new LifelineLabelFormatParser(features);
		parser.setViewPattern("{0}: ");
		parser.setEditorPattern("{0}");
		parser.setEditPattern("{0}");
		// Own TagsAdderParser
		return new LifelineTagsAdderParser(parser);
	}

	/**
	 * @generated
	 */
	private IParser combinedFragmentInteractionOperator_4002Parser;

	/**
	 * @generated
	 */
	private IParser getCombinedFragmentInteractionOperator_4002Parser() {
		if (combinedFragmentInteractionOperator_4002Parser == null) {
			combinedFragmentInteractionOperator_4002Parser = createCombinedFragmentInteractionOperator_4002Parser();
		}
		return combinedFragmentInteractionOperator_4002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCombinedFragmentInteractionOperator_4002Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getCombinedFragment_InteractionOperator(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser messageName_4005Parser;

	/**
	 * @generated
	 */
	private IParser getMessageName_4005Parser() {
		if (messageName_4005Parser == null) {
			messageName_4005Parser = createMessageName_4005Parser();
		}
		return messageName_4005Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createMessageName_4005Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getNamedElement_Name(), };
		// Own parser for Message Label
		MessageFormatParser parser = new MessageLabelFormatParser(features);
		parser.setViewPattern(" {0}");
		parser.setEditorPattern(" {0}");
		parser.setEditPattern("{0}");
		// Own parser to add convenient listeners
		return new MessageTagsAdderParser(parser);
	}

	/**
	 * @generated
	 */
	private IParser messageName_4006Parser;

	/**
	 * @generated
	 */
	private IParser getMessageName_4006Parser() {
		if (messageName_4006Parser == null) {
			messageName_4006Parser = createMessageName_4006Parser();
		}
		return messageName_4006Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createMessageName_4006Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getNamedElement_Name(), };
		// Own parser for Message Label
		MessageFormatParser parser = new MessageLabelFormatParser(features);
		parser.setViewPattern(" {0}");
		parser.setEditorPattern(" {0}");
		parser.setEditPattern("{0}");
		// Own parser to add convenient listeners
		return new MessageTagsAdderParser(parser);
	}

	/**
	 * @generated
	 */
	private IParser messageName_4007Parser;

	/**
	 * @generated
	 */
	private IParser getMessageName_4007Parser() {
		if (messageName_4007Parser == null) {
			messageName_4007Parser = createMessageName_4007Parser();
		}
		return messageName_4007Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createMessageName_4007Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getNamedElement_Name(), };
		// Own parser for Message Label
		MessageFormatParser parser = new MessageLabelFormatParser(features);
		parser.setViewPattern(" {0}");
		parser.setEditorPattern(" {0}");
		parser.setEditPattern("{0}");
		// Own parser to add convenient listeners
		return new MessageTagsAdderParser(parser);
	}

	/**
	 * @generated
	 */
	private IParser messageName_4008Parser;

	/**
	 * @generated
	 */
	private IParser getMessageName_4008Parser() {
		if (messageName_4008Parser == null) {
			messageName_4008Parser = createMessageName_4008Parser();
		}
		return messageName_4008Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createMessageName_4008Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getNamedElement_Name(), };
		// Own parser for Message Label
		MessageFormatParser parser = new MessageLabelFormatParser(features);
		parser.setViewPattern(" {0}");
		parser.setEditorPattern(" {0}");
		parser.setEditPattern("{0}");
		// Own parser to add convenient listeners
		return new MessageTagsAdderParser(parser);
	}

	/**
	 * @generated
	 */
	private IParser messageName_4009Parser;

	/**
	 * @generated
	 */
	private IParser getMessageName_4009Parser() {
		if (messageName_4009Parser == null) {
			messageName_4009Parser = createMessageName_4009Parser();
		}
		return messageName_4009Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createMessageName_4009Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getNamedElement_Name(), };
		// Own parser for Message Label
		MessageFormatParser parser = new MessageLabelFormatParser(features);
		parser.setViewPattern(" {0}");
		parser.setEditorPattern(" {0}");
		parser.setEditPattern("{0}");
		// Own parser to add convenient listeners
		return new MessageTagsAdderParser(parser);
	}

	/**
	 * @generated
	 */
	private IParser messageName_4010Parser;

	/**
	 * @generated
	 */
	private IParser getMessageName_4010Parser() {
		if (messageName_4010Parser == null) {
			messageName_4010Parser = createMessageName_4010Parser();
		}
		return messageName_4010Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createMessageName_4010Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getNamedElement_Name(), };
		// Own parser for Message Label
		MessageFormatParser parser = new MessageLabelFormatParser(features);
		parser.setViewPattern(" {0}");
		parser.setEditorPattern(" {0}");
		parser.setEditPattern("{0}");
		// Own parser to add convenient listeners
		return new MessageTagsAdderParser(parser);
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case InteractionNameEditPart.VISUAL_ID:
			return getInteractionName_4004Parser();
		case CommentBodyEditPart.VISUAL_ID:
			return getCommentBody_5003Parser();
		case InteractionName2EditPart.VISUAL_ID:
			return getInteractionName_4003Parser();
		case LifelineNameEditPart.VISUAL_ID:
			return getLifelineName_4001Parser();
		case CombinedFragmentInteractionOperatorEditPart.VISUAL_ID:
			return getCombinedFragmentInteractionOperator_4002Parser();
		case MessageNameEditPart.VISUAL_ID:
			return getMessageName_4005Parser();
		case MessageName2EditPart.VISUAL_ID:
			return getMessageName_4006Parser();
		case MessageName3EditPart.VISUAL_ID:
			return getMessageName_4007Parser();
		case MessageName4EditPart.VISUAL_ID:
			return getMessageName_4008Parser();
		case MessageName5EditPart.VISUAL_ID:
			return getMessageName_4009Parser();
		case MessageName6EditPart.VISUAL_ID:
			return getMessageName_4010Parser();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(UMLVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(UMLVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (UMLElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		@Override
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

	/**
	 * 
	 * @NOT-generated
	 * @author Gabriel Merin Cubero
	 * 
	 */
	public class MessageLabelFormatParser extends MessageFormatParser {

		public MessageLabelFormatParser(EAttribute[] features) {
			super(features);
		}

		@Override
		public String getPrintString(IAdaptable adapter, int flags) {
			String superString = super.getPrintString(adapter, flags);
			EObject eObject = (EObject) adapter.getAdapter(EObject.class);
			if (eObject instanceof Message) {
				Operation op = MessageCommonUtil
						.getMessageSendOperation((Message) eObject);
				if (op != null) {
					superString = MessageCommonUtil.getMessageOperationString(
							(Message) eObject, op);
				}
			}
			return superString;
		}

	}

	/**
	 * 
	 * @NOT-generated
	 * @author Gabriel Merin Cubero
	 * 
	 */
	public class MessageTagsAdderParser extends TagsAdderParser {

		public MessageTagsAdderParser(IParser parser) {
			super(parser);
		}

		@Override
		public List getSemanticElementsBeingParsed(EObject arg0) {
			List eList = new ArrayList(super
					.getSemanticElementsBeingParsed(arg0));

			if (arg0 instanceof Message) {
				Message msg = (Message) arg0;
				// add the Operation
				Operation op = MessageCommonUtil.getMessageSendOperation(msg);
				if (op != null) {
					eList.add(op);

					// add the Operation Parameters : by jmunoz
					eList.addAll(op.getOwnedParameters());

					// add the event
					Event e = MessageCommonUtil.getMessageSendEvent(msg);
					eList.add(e);

					// add the MessageArguments
					eList.addAll(msg.getArguments());
				}
			}
			return eList;
		}

		@Override
		public boolean areSemanticElementsAffected(EObject arg0, Object arg1) {
			if (arg1 instanceof Notification) {
				Notification event = (Notification) arg1;

				if (event.getNotifier() instanceof ValueSpecification) {
					return true;
				}

				if (event.getNotifier() instanceof Operation
						&& UMLPackage.eINSTANCE.getNamedElement_Name().equals(
								event.getFeature())) {
					return true;
				}

				if (event.getNotifier() instanceof Operation
						&& event.getFeature() == UMLPackage.eINSTANCE
								.getBehavioralFeature_OwnedParameter()) {
					return true;
				}

				if (event.getNotifier() instanceof Event) {
					return true;
				}

				if (event.getNotifier() instanceof Message) {
					return true;
				}

			}
			return false;
		}

	}

	/**
	 * 
	 * @NOT-generated
	 * @author Francisco Javier Cano Muñoz, Gabriel Merin Cubero
	 * 
	 */
	public class LifelineLabelFormatParser extends MessageFormatParser {

		public LifelineLabelFormatParser(EAttribute[] features) {
			super(features);
		}

		@Override
		public String getPrintString(IAdaptable adapter, int flags) {
			String superString = super.getPrintString(adapter, flags);
			EObject eObject = (EObject) adapter.getAdapter(EObject.class);
			if (eObject instanceof Lifeline) {
				String representsString = getLifelineRepresents((Lifeline) eObject);
				if (representsString != null && representsString.length() > 0) {
					superString += ("<" + representsString + ">");
				}
			}
			return superString;
		}

		private String getLifelineRepresents(Lifeline lifeline) {
			String represents = "";
			if (lifeline != null) {
				ConnectableElement connectableElement = lifeline
						.getRepresents();
				if (connectableElement instanceof Property) {
					Property property = (Property) connectableElement;
					Type type = property.getType();
					if (type != null) {
						represents = type.getName();
					}
				}
			}
			return represents;
		}

	}

	/**
	 * 
	 * @NOT-generated
	 * @author Francisco Javier Cano Muñoz, Gabriel Merin Cubero
	 * 
	 */
	public class LifelineTagsAdderParser extends TagsAdderParser {

		public LifelineTagsAdderParser(IParser parser) {
			super(parser);
		}

		@Override
		public List getSemanticElementsBeingParsed(EObject arg0) {
			List eList = new ArrayList(super
					.getSemanticElementsBeingParsed(arg0));

			if (arg0 instanceof Lifeline) {
				Lifeline lifeline = (Lifeline) arg0;
				// add the represented element
				ConnectableElement connectableElement = lifeline
						.getRepresents();

				if (connectableElement != null
						&& connectableElement instanceof Property) {
					Property property = (Property) connectableElement;
					// Listen to changes on the property
					eList.add(property);
					// Listen to changes on the Type referenced by the property
					Type type = property.getType();
					if (type != null) {
						eList.add(type);
					}
				}
			}
			return eList;
		}

		@Override
		public boolean areSemanticElementsAffected(EObject arg0, Object arg1) {
			if (arg1 instanceof Notification) {
				Notification event = (Notification) arg1;

				// Change on a ConnectableElement (Parameter, Property or
				// Variable)
				if (event.getNotifier() instanceof ConnectableElement
						&& (UMLPackage.eINSTANCE.getNamedElement_Name().equals(
								event.getFeature()) || UMLPackage.eINSTANCE
								.getTypedElement_Type().equals(
										event.getFeature()))) {
					return true;
				}
				// Change on the represent feature
				if (event.getNotifier() instanceof Lifeline
						&& UMLPackage.eINSTANCE.getLifeline_Represents()
								.equals(event.getFeature())) {
					return true;
				}
			}
			return super.areSemanticElementsAffected(arg0, arg1);
		}

	}

}
