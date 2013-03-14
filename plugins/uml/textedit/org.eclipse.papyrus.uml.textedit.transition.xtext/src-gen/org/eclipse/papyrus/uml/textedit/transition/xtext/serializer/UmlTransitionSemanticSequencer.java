package org.eclipse.papyrus.uml.textedit.transition.xtext.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.textedit.transition.xtext.services.UmlTransitionGrammarAccess;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.AbsoluteTimeEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.AnyReceiveEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.CallOrSignalEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.ChangeEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EffectRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.GuardRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.RelativeTimeEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TransitionRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.UmlTransitionPackage;
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
public class UmlTransitionSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private UmlTransitionGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == UmlTransitionPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case UmlTransitionPackage.ABSOLUTE_TIME_EVENT_RULE:
				if(context == grammarAccess.getAbsoluteTimeEventRuleRule() ||
				   context == grammarAccess.getEventRuleRule() ||
				   context == grammarAccess.getTimeEventRuleRule()) {
					sequence_AbsoluteTimeEventRule(context, (AbsoluteTimeEventRule) semanticObject); 
					return; 
				}
				else break;
			case UmlTransitionPackage.ANY_RECEIVE_EVENT_RULE:
				if(context == grammarAccess.getAnyReceiveEventRuleRule() ||
				   context == grammarAccess.getEventRuleRule()) {
					sequence_AnyReceiveEventRule(context, (AnyReceiveEventRule) semanticObject); 
					return; 
				}
				else break;
			case UmlTransitionPackage.CALL_OR_SIGNAL_EVENT_RULE:
				if(context == grammarAccess.getCallOrSignalEventRuleRule() ||
				   context == grammarAccess.getEventRuleRule()) {
					sequence_CallOrSignalEventRule(context, (CallOrSignalEventRule) semanticObject); 
					return; 
				}
				else break;
			case UmlTransitionPackage.CHANGE_EVENT_RULE:
				if(context == grammarAccess.getChangeEventRuleRule() ||
				   context == grammarAccess.getEventRuleRule()) {
					sequence_ChangeEventRule(context, (ChangeEventRule) semanticObject); 
					return; 
				}
				else break;
			case UmlTransitionPackage.EFFECT_RULE:
				if(context == grammarAccess.getEffectRuleRule()) {
					sequence_EffectRule(context, (EffectRule) semanticObject); 
					return; 
				}
				else break;
			case UmlTransitionPackage.GUARD_RULE:
				if(context == grammarAccess.getGuardRuleRule()) {
					sequence_GuardRule(context, (GuardRule) semanticObject); 
					return; 
				}
				else break;
			case UmlTransitionPackage.RELATIVE_TIME_EVENT_RULE:
				if(context == grammarAccess.getEventRuleRule() ||
				   context == grammarAccess.getRelativeTimeEventRuleRule() ||
				   context == grammarAccess.getTimeEventRuleRule()) {
					sequence_RelativeTimeEventRule(context, (RelativeTimeEventRule) semanticObject); 
					return; 
				}
				else break;
			case UmlTransitionPackage.TRANSITION_RULE:
				if(context == grammarAccess.getTransitionRuleRule()) {
					sequence_TransitionRule(context, (TransitionRule) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     expr=STRING
	 */
	protected void sequence_AbsoluteTimeEventRule(EObject context, AbsoluteTimeEventRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmlTransitionPackage.Literals.TIME_EVENT_RULE__EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlTransitionPackage.Literals.TIME_EVENT_RULE__EXPR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAbsoluteTimeEventRuleAccess().getExprSTRINGTerminalRuleCall_1_0(), semanticObject.getExpr());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     isAReceiveEvent='all'
	 */
	protected void sequence_AnyReceiveEventRule(EObject context, AnyReceiveEventRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmlTransitionPackage.Literals.ANY_RECEIVE_EVENT_RULE__IS_ARECEIVE_EVENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlTransitionPackage.Literals.ANY_RECEIVE_EVENT_RULE__IS_ARECEIVE_EVENT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAnyReceiveEventRuleAccess().getIsAReceiveEventAllKeyword_0(), semanticObject.getIsAReceiveEvent());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     operationOrSignal=[NamedElement|ID]
	 */
	protected void sequence_CallOrSignalEventRule(EObject context, CallOrSignalEventRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmlTransitionPackage.Literals.CALL_OR_SIGNAL_EVENT_RULE__OPERATION_OR_SIGNAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlTransitionPackage.Literals.CALL_OR_SIGNAL_EVENT_RULE__OPERATION_OR_SIGNAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getCallOrSignalEventRuleAccess().getOperationOrSignalNamedElementIDTerminalRuleCall_0_1(), semanticObject.getOperationOrSignal());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     exp=STRING
	 */
	protected void sequence_ChangeEventRule(EObject context, ChangeEventRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmlTransitionPackage.Literals.CHANGE_EVENT_RULE__EXP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlTransitionPackage.Literals.CHANGE_EVENT_RULE__EXP));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getChangeEventRuleAccess().getExpSTRINGTerminalRuleCall_1_0(), semanticObject.getExp());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (kind=BehaviorKind behaviorName=ID)
	 */
	protected void sequence_EffectRule(EObject context, EffectRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmlTransitionPackage.Literals.EFFECT_RULE__KIND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlTransitionPackage.Literals.EFFECT_RULE__KIND));
			if(transientValues.isValueTransient(semanticObject, UmlTransitionPackage.Literals.EFFECT_RULE__BEHAVIOR_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlTransitionPackage.Literals.EFFECT_RULE__BEHAVIOR_NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEffectRuleAccess().getKindBehaviorKindEnumRuleCall_1_0(), semanticObject.getKind());
		feeder.accept(grammarAccess.getEffectRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0(), semanticObject.getBehaviorName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     constraint=STRING
	 */
	protected void sequence_GuardRule(EObject context, GuardRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmlTransitionPackage.Literals.GUARD_RULE__CONSTRAINT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlTransitionPackage.Literals.GUARD_RULE__CONSTRAINT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getGuardRuleAccess().getConstraintSTRINGTerminalRuleCall_1_0(), semanticObject.getConstraint());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     expr=STRING
	 */
	protected void sequence_RelativeTimeEventRule(EObject context, RelativeTimeEventRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmlTransitionPackage.Literals.TIME_EVENT_RULE__EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlTransitionPackage.Literals.TIME_EVENT_RULE__EXPR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRelativeTimeEventRuleAccess().getExprSTRINGTerminalRuleCall_1_0(), semanticObject.getExpr());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ((triggers+=EventRule triggers+=EventRule*)? guard=GuardRule? effect=EffectRule?)
	 */
	protected void sequence_TransitionRule(EObject context, TransitionRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
