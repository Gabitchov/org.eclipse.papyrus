package org.eclipse.papyrus.uml.textedit.parameter.xtext.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.textedit.common.xtext.serializer.AbstractUmlCommonSemanticSequencer;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.BoundSpecification;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.MultiplicityRule;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.QualifiedName;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.TypeRule;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.UmlCommonPackage;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.services.UmlParameterGrammarAccess;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierSpecification;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifiersRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

import com.google.inject.Inject;
import com.google.inject.Provider;

@SuppressWarnings("restriction")
public class AbstractUmlParameterSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected UmlParameterGrammarAccess grammarAccess;
	
	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	@GenericSequencer
	protected Provider<ISemanticSequencer> genericSequencerProvider;
	
	protected ISemanticSequencer genericSequencer;
	
	@Inject
	protected Provider<AbstractUmlCommonSemanticSequencer> superSequencerProvider;
	 
	protected AbstractUmlCommonSemanticSequencer superSequencer; 
	
	@Override
	public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		super.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.genericSequencer = genericSequencerProvider.get();
		this.genericSequencer.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.superSequencer = superSequencerProvider.get();
		this.superSequencer.init(sequencer, sequenceAcceptor, errorAcceptor); 
	}
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == UmlCommonPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case UmlCommonPackage.BOUND_SPECIFICATION:
				if(context == grammarAccess.getBoundSpecificationRule()) {
					sequence_BoundSpecification(context, (BoundSpecification) semanticObject); 
					return; 
				}
				else break;
			case UmlCommonPackage.MULTIPLICITY_RULE:
				if(context == grammarAccess.getMultiplicityRuleRule()) {
					sequence_MultiplicityRule(context, (MultiplicityRule) semanticObject); 
					return; 
				}
				else break;
			case UmlCommonPackage.QUALIFIED_NAME:
				if(context == grammarAccess.getQualifiedNameRule()) {
					sequence_QualifiedName(context, (QualifiedName) semanticObject); 
					return; 
				}
				else break;
			case UmlCommonPackage.TYPE_RULE:
				if(context == grammarAccess.getTypeRuleRule()) {
					sequence_TypeRule(context, (TypeRule) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == UmlParameterPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case UmlParameterPackage.EFFECT_RULE:
				if(context == grammarAccess.getEffectRuleRule()) {
					sequence_EffectRule(context, (EffectRule) semanticObject); 
					return; 
				}
				else break;
			case UmlParameterPackage.MODIFIER_SPECIFICATION:
				if(context == grammarAccess.getModifierSpecificationRule()) {
					sequence_ModifierSpecification(context, (ModifierSpecification) semanticObject); 
					return; 
				}
				else break;
			case UmlParameterPackage.MODIFIERS_RULE:
				if(context == grammarAccess.getModifiersRuleRule()) {
					sequence_ModifiersRule(context, (ModifiersRule) semanticObject); 
					return; 
				}
				else break;
			case UmlParameterPackage.PARAMETER_RULE:
				if(context == grammarAccess.getParameterRuleRule()) {
					sequence_ParameterRule(context, (ParameterRule) semanticObject); 
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
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     effectKind=EffectKind
	 */
	protected void sequence_EffectRule(EObject context, EffectRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmlParameterPackage.Literals.EFFECT_RULE__EFFECT_KIND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlParameterPackage.Literals.EFFECT_RULE__EFFECT_KIND));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEffectRuleAccess().getEffectKindEffectKindEnumRuleCall_2_0(), semanticObject.getEffectKind());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=ModifierKind
	 */
	protected void sequence_ModifierSpecification(EObject context, ModifierSpecification semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmlParameterPackage.Literals.MODIFIER_SPECIFICATION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlParameterPackage.Literals.MODIFIER_SPECIFICATION__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getModifierSpecificationAccess().getValueModifierKindEnumRuleCall_0(), semanticObject.getValue());
		feeder.finish();
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
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         visibility=VisibilityKind 
	 *         direction=Direction 
	 *         name=ID 
	 *         type=TypeRule? 
	 *         multiplicity=MultiplicityRule? 
	 *         modifiers=ModifiersRule? 
	 *         effect=EffectRule
	 *     )
	 */
	protected void sequence_ParameterRule(EObject context, ParameterRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (path=[Namespace|ID] remaining=QualifiedName?)
	 */
	protected void sequence_QualifiedName(EObject context, QualifiedName semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (path=QualifiedName? type=[Type|ID])
	 */
	protected void sequence_TypeRule(EObject context, TypeRule semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
}
