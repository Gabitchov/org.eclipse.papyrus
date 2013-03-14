package org.eclipse.papyrus.uml.textedit.state.xtext.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.textedit.state.xtext.services.UmlStateGrammarAccess;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.DoRule;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.EntryRule;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.ExitRule;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.QualifiedName;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.StateRule;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.SubmachineRule;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.UmlStatePackage;
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
public class UmlStateSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private UmlStateGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == UmlStatePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case UmlStatePackage.DO_RULE:
				if(context == grammarAccess.getDoRuleRule()) {
					sequence_DoRule(context, (DoRule) semanticObject); 
					return; 
				}
				else break;
			case UmlStatePackage.ENTRY_RULE:
				if(context == grammarAccess.getEntryRuleRule()) {
					sequence_EntryRule(context, (EntryRule) semanticObject); 
					return; 
				}
				else break;
			case UmlStatePackage.EXIT_RULE:
				if(context == grammarAccess.getExitRuleRule()) {
					sequence_ExitRule(context, (ExitRule) semanticObject); 
					return; 
				}
				else break;
			case UmlStatePackage.QUALIFIED_NAME:
				if(context == grammarAccess.getQualifiedNameRule()) {
					sequence_QualifiedName(context, (QualifiedName) semanticObject); 
					return; 
				}
				else break;
			case UmlStatePackage.STATE_RULE:
				if(context == grammarAccess.getStateRuleRule()) {
					sequence_StateRule(context, (StateRule) semanticObject); 
					return; 
				}
				else break;
			case UmlStatePackage.SUBMACHINE_RULE:
				if(context == grammarAccess.getSubmachineRuleRule()) {
					sequence_SubmachineRule(context, (SubmachineRule) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (kind=BehaviorKind behaviorName=ID)
	 */
	protected void sequence_DoRule(EObject context, DoRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmlStatePackage.Literals.DO_RULE__KIND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlStatePackage.Literals.DO_RULE__KIND));
			if(transientValues.isValueTransient(semanticObject, UmlStatePackage.Literals.DO_RULE__BEHAVIOR_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlStatePackage.Literals.DO_RULE__BEHAVIOR_NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDoRuleAccess().getKindBehaviorKindEnumRuleCall_1_0(), semanticObject.getKind());
		feeder.accept(grammarAccess.getDoRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0(), semanticObject.getBehaviorName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (kind=BehaviorKind behaviorName=ID)
	 */
	protected void sequence_EntryRule(EObject context, EntryRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmlStatePackage.Literals.ENTRY_RULE__KIND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlStatePackage.Literals.ENTRY_RULE__KIND));
			if(transientValues.isValueTransient(semanticObject, UmlStatePackage.Literals.ENTRY_RULE__BEHAVIOR_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlStatePackage.Literals.ENTRY_RULE__BEHAVIOR_NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEntryRuleAccess().getKindBehaviorKindEnumRuleCall_1_0(), semanticObject.getKind());
		feeder.accept(grammarAccess.getEntryRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0(), semanticObject.getBehaviorName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (kind=BehaviorKind behaviorName=ID)
	 */
	protected void sequence_ExitRule(EObject context, ExitRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmlStatePackage.Literals.EXIT_RULE__KIND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlStatePackage.Literals.EXIT_RULE__KIND));
			if(transientValues.isValueTransient(semanticObject, UmlStatePackage.Literals.EXIT_RULE__BEHAVIOR_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlStatePackage.Literals.EXIT_RULE__BEHAVIOR_NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getExitRuleAccess().getKindBehaviorKindEnumRuleCall_1_0(), semanticObject.getKind());
		feeder.accept(grammarAccess.getExitRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0(), semanticObject.getBehaviorName());
		feeder.finish();
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
	 *     (name=ID submachine=SubmachineRule? entry=EntryRule? do=DoRule? exit=ExitRule?)
	 */
	protected void sequence_StateRule(EObject context, StateRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (path=QualifiedName? submachine=[StateMachine|ID])
	 */
	protected void sequence_SubmachineRule(EObject context, SubmachineRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
