package org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.services.UmlCollaborationUseGrammarAccess;
import org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.CollaborationUseRule;
import org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.TypeRule;
import org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.UmlCollaborationUsePackage;
import org.eclipse.papyrus.uml.textedit.common.xtext.serializer.UmlCommonSemanticSequencer;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.BoundSpecification;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.MultiplicityRule;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.QualifiedName;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.UmlCommonPackage;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("all")
public class UmlCollaborationUseSemanticSequencer extends UmlCommonSemanticSequencer {

	@Inject
	private UmlCollaborationUseGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == UmlCollaborationUsePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case UmlCollaborationUsePackage.COLLABORATION_USE_RULE:
				if(context == grammarAccess.getCollaborationUseRuleRule()) {
					sequence_CollaborationUseRule(context, (CollaborationUseRule) semanticObject); 
					return; 
				}
				else break;
			case UmlCollaborationUsePackage.TYPE_RULE:
				if(context == grammarAccess.getTypeRuleRule()) {
					sequence_TypeRule(context, (TypeRule) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == UmlCommonPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
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
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (visibility=VisibilityKind name=ID type=TypeRule?)
	 */
	protected void sequence_CollaborationUseRule(EObject context, CollaborationUseRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (path=QualifiedName? type=[Collaboration|ID])
	 */
	protected void sequence_TypeRule(EObject context, TypeRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
