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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.property.xtext.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.textedit.property.xtext.services.UmlPropertyGrammarAccess;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.BoundSpecification;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.DefaultValueRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.ModifierSpecification;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.ModifiersRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.MultiplicityRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.PropertyRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.QualifiedName;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.RedefinesRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.SubsetsRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.TypeRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.UmlPropertyPackage;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class UmlPropertySemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private UmlPropertyGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == UmlPropertyPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case UmlPropertyPackage.BOUND_SPECIFICATION:
				if(context == grammarAccess.getBoundSpecificationRule()) {
					sequence_BoundSpecification(context, (BoundSpecification) semanticObject); 
					return; 
				}
				else break;
			case UmlPropertyPackage.DEFAULT_VALUE_RULE:
				if(context == grammarAccess.getDefaultValueRuleRule()) {
					sequence_DefaultValueRule(context, (DefaultValueRule) semanticObject); 
					return; 
				}
				else break;
			case UmlPropertyPackage.MODIFIER_SPECIFICATION:
				if(context == grammarAccess.getModifierSpecificationRule()) {
					sequence_ModifierSpecification(context, (ModifierSpecification) semanticObject); 
					return; 
				}
				else break;
			case UmlPropertyPackage.MODIFIERS_RULE:
				if(context == grammarAccess.getModifiersRuleRule()) {
					sequence_ModifiersRule(context, (ModifiersRule) semanticObject); 
					return; 
				}
				else break;
			case UmlPropertyPackage.MULTIPLICITY_RULE:
				if(context == grammarAccess.getMultiplicityRuleRule()) {
					sequence_MultiplicityRule(context, (MultiplicityRule) semanticObject); 
					return; 
				}
				else break;
			case UmlPropertyPackage.PROPERTY_RULE:
				if(context == grammarAccess.getPropertyRuleRule()) {
					sequence_PropertyRule(context, (PropertyRule) semanticObject); 
					return; 
				}
				else break;
			case UmlPropertyPackage.QUALIFIED_NAME:
				if(context == grammarAccess.getQualifiedNameRule()) {
					sequence_QualifiedName(context, (QualifiedName) semanticObject); 
					return; 
				}
				else break;
			case UmlPropertyPackage.REDEFINES_RULE:
				if(context == grammarAccess.getRedefinesRuleRule()) {
					sequence_RedefinesRule(context, (RedefinesRule) semanticObject); 
					return; 
				}
				else break;
			case UmlPropertyPackage.SUBSETS_RULE:
				if(context == grammarAccess.getSubsetsRuleRule()) {
					sequence_SubsetsRule(context, (SubsetsRule) semanticObject); 
					return; 
				}
				else break;
			case UmlPropertyPackage.TYPE_RULE:
				if(context == grammarAccess.getTypeRuleRule()) {
					sequence_TypeRule(context, (TypeRule) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     value=UnlimitedLiteral
	 */
	protected void sequence_BoundSpecification(EObject context, BoundSpecification semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmlPropertyPackage.Literals.BOUND_SPECIFICATION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlPropertyPackage.Literals.BOUND_SPECIFICATION__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralParserRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     default=STRING
	 */
	protected void sequence_DefaultValueRule(EObject context, DefaultValueRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmlPropertyPackage.Literals.DEFAULT_VALUE_RULE__DEFAULT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlPropertyPackage.Literals.DEFAULT_VALUE_RULE__DEFAULT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDefaultValueRuleAccess().getDefaultSTRINGTerminalRuleCall_1_0(), semanticObject.getDefault());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (value=ModifierKind | redefines=RedefinesRule | subsets=SubsetsRule)
	 */
	protected void sequence_ModifierSpecification(EObject context, ModifierSpecification semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (values+=ModifierSpecification values+=ModifierSpecification*)
	 */
	protected void sequence_ModifiersRule(EObject context, ModifiersRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (bounds+=BoundSpecification bounds+=BoundSpecification?)
	 */
	protected void sequence_MultiplicityRule(EObject context, MultiplicityRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         visibility=VisibilityKind 
	 *         isDerived='/'? 
	 *         name=ID 
	 *         type=TypeRule? 
	 *         multiplicity=MultiplicityRule? 
	 *         modifiers=ModifiersRule? 
	 *         default=DefaultValueRule?
	 *     )
	 */
	protected void sequence_PropertyRule(EObject context, PropertyRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (path=[Namespace|ID] remaining=QualifiedName?)
	 */
	protected void sequence_QualifiedName(EObject context, QualifiedName semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     property=[Property|ID]
	 */
	protected void sequence_RedefinesRule(EObject context, RedefinesRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmlPropertyPackage.Literals.REDEFINES_RULE__PROPERTY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlPropertyPackage.Literals.REDEFINES_RULE__PROPERTY));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRedefinesRuleAccess().getPropertyPropertyIDTerminalRuleCall_1_0_1(), semanticObject.getProperty());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     property=[Property|ID]
	 */
	protected void sequence_SubsetsRule(EObject context, SubsetsRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmlPropertyPackage.Literals.SUBSETS_RULE__PROPERTY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlPropertyPackage.Literals.SUBSETS_RULE__PROPERTY));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSubsetsRuleAccess().getPropertyPropertyIDTerminalRuleCall_1_0_1(), semanticObject.getProperty());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (path=QualifiedName? type=[Classifier|ID])
	 */
	protected void sequence_TypeRule(EObject context, TypeRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
