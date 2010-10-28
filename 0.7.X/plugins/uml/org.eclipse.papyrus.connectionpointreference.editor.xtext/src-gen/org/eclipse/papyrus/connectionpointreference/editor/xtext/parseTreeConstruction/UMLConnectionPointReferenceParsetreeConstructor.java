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
package org.eclipse.papyrus.connectionpointreference.editor.xtext.parseTreeConstruction;

import org.eclipse.emf.ecore.*;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.IEObjectConsumer;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor;

import org.eclipse.papyrus.connectionpointreference.editor.xtext.services.UMLConnectionPointReferenceGrammarAccess;

import com.google.inject.Inject;

@SuppressWarnings("all")
public class UMLConnectionPointReferenceParsetreeConstructor extends AbstractParseTreeConstructor {
		
	@Inject
	private UMLConnectionPointReferenceGrammarAccess grammarAccess;
	
	@Override
	protected AbstractToken getRootToken(IEObjectConsumer inst) {
		return new ThisRootNode(inst);	
	}
	
protected class ThisRootNode extends RootToken {
	public ThisRootNode(IEObjectConsumer inst) {
		super(inst);
	}
	
	@Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConnectionPointReferenceRule_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
}
	

/************ begin Rule ConnectionPointReferenceRule ****************
 *
 * ConnectionPointReferenceRule:
 * 	("entry" entry+=[uml::Pseudostate] ("," entry+=[uml::Pseudostate])* | "exit" exit+=[uml::Pseudostate] (","
 * 	exit+=[uml::Pseudostate])*)?;
 *
 **/

// ("entry" entry+=[uml::Pseudostate] ("," entry+=[uml::Pseudostate])* | "exit" exit+=[uml::Pseudostate] (","
// exit+=[uml::Pseudostate])*)?
protected class ConnectionPointReferenceRule_Alternatives extends AlternativesToken {

	public ConnectionPointReferenceRule_Alternatives(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getConnectionPointReferenceRuleAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConnectionPointReferenceRule_Group_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new ConnectionPointReferenceRule_Group_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getConnectionPointReferenceRuleRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "entry" entry+=[uml::Pseudostate] ("," entry+=[uml::Pseudostate])*
protected class ConnectionPointReferenceRule_Group_0 extends GroupToken {
	
	public ConnectionPointReferenceRule_Group_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getConnectionPointReferenceRuleAccess().getGroup_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConnectionPointReferenceRule_Group_0_2(lastRuleCallOrigin, this, 0, inst);
			case 1: return new ConnectionPointReferenceRule_EntryAssignment_0_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// "entry"
protected class ConnectionPointReferenceRule_EntryKeyword_0_0 extends KeywordToken  {
	
	public ConnectionPointReferenceRule_EntryKeyword_0_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getConnectionPointReferenceRuleAccess().getEntryKeyword_0_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// entry+=[uml::Pseudostate]
protected class ConnectionPointReferenceRule_EntryAssignment_0_1 extends AssignmentToken  {
	
	public ConnectionPointReferenceRule_EntryAssignment_0_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getConnectionPointReferenceRuleAccess().getEntryAssignment_0_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConnectionPointReferenceRule_EntryKeyword_0_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("entry",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("entry");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::CrossReferenceImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryPseudostateCrossReference_0_1_0().getType().getClassifier())) {
				type = AssignmentType.CROSS_REFERENCE;
				element = grammarAccess.getConnectionPointReferenceRuleAccess().getEntryPseudostateCrossReference_0_1_0(); 
				return obj;
			}
		}
		return null;
	}

}

// ("," entry+=[uml::Pseudostate])*
protected class ConnectionPointReferenceRule_Group_0_2 extends GroupToken {
	
	public ConnectionPointReferenceRule_Group_0_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getConnectionPointReferenceRuleAccess().getGroup_0_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConnectionPointReferenceRule_EntryAssignment_0_2_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// ","
protected class ConnectionPointReferenceRule_CommaKeyword_0_2_0 extends KeywordToken  {
	
	public ConnectionPointReferenceRule_CommaKeyword_0_2_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getConnectionPointReferenceRuleAccess().getCommaKeyword_0_2_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConnectionPointReferenceRule_Group_0_2(lastRuleCallOrigin, this, 0, inst);
			case 1: return new ConnectionPointReferenceRule_EntryAssignment_0_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// entry+=[uml::Pseudostate]
protected class ConnectionPointReferenceRule_EntryAssignment_0_2_1 extends AssignmentToken  {
	
	public ConnectionPointReferenceRule_EntryAssignment_0_2_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getConnectionPointReferenceRuleAccess().getEntryAssignment_0_2_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConnectionPointReferenceRule_CommaKeyword_0_2_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("entry",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("entry");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::CrossReferenceImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryPseudostateCrossReference_0_2_1_0().getType().getClassifier())) {
				type = AssignmentType.CROSS_REFERENCE;
				element = grammarAccess.getConnectionPointReferenceRuleAccess().getEntryPseudostateCrossReference_0_2_1_0(); 
				return obj;
			}
		}
		return null;
	}

}



// "exit" exit+=[uml::Pseudostate] ("," exit+=[uml::Pseudostate])*
protected class ConnectionPointReferenceRule_Group_1 extends GroupToken {
	
	public ConnectionPointReferenceRule_Group_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getConnectionPointReferenceRuleAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConnectionPointReferenceRule_Group_1_2(lastRuleCallOrigin, this, 0, inst);
			case 1: return new ConnectionPointReferenceRule_ExitAssignment_1_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// "exit"
protected class ConnectionPointReferenceRule_ExitKeyword_1_0 extends KeywordToken  {
	
	public ConnectionPointReferenceRule_ExitKeyword_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getConnectionPointReferenceRuleAccess().getExitKeyword_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// exit+=[uml::Pseudostate]
protected class ConnectionPointReferenceRule_ExitAssignment_1_1 extends AssignmentToken  {
	
	public ConnectionPointReferenceRule_ExitAssignment_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getConnectionPointReferenceRuleAccess().getExitAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConnectionPointReferenceRule_ExitKeyword_1_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("exit",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("exit");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::CrossReferenceImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getConnectionPointReferenceRuleAccess().getExitPseudostateCrossReference_1_1_0().getType().getClassifier())) {
				type = AssignmentType.CROSS_REFERENCE;
				element = grammarAccess.getConnectionPointReferenceRuleAccess().getExitPseudostateCrossReference_1_1_0(); 
				return obj;
			}
		}
		return null;
	}

}

// ("," exit+=[uml::Pseudostate])*
protected class ConnectionPointReferenceRule_Group_1_2 extends GroupToken {
	
	public ConnectionPointReferenceRule_Group_1_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getConnectionPointReferenceRuleAccess().getGroup_1_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConnectionPointReferenceRule_ExitAssignment_1_2_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// ","
protected class ConnectionPointReferenceRule_CommaKeyword_1_2_0 extends KeywordToken  {
	
	public ConnectionPointReferenceRule_CommaKeyword_1_2_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getConnectionPointReferenceRuleAccess().getCommaKeyword_1_2_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConnectionPointReferenceRule_Group_1_2(lastRuleCallOrigin, this, 0, inst);
			case 1: return new ConnectionPointReferenceRule_ExitAssignment_1_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// exit+=[uml::Pseudostate]
protected class ConnectionPointReferenceRule_ExitAssignment_1_2_1 extends AssignmentToken  {
	
	public ConnectionPointReferenceRule_ExitAssignment_1_2_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getConnectionPointReferenceRuleAccess().getExitAssignment_1_2_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConnectionPointReferenceRule_CommaKeyword_1_2_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("exit",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("exit");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::CrossReferenceImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getConnectionPointReferenceRuleAccess().getExitPseudostateCrossReference_1_2_1_0().getType().getClassifier())) {
				type = AssignmentType.CROSS_REFERENCE;
				element = grammarAccess.getConnectionPointReferenceRuleAccess().getExitPseudostateCrossReference_1_2_1_0(); 
				return obj;
			}
		}
		return null;
	}

}




/************ end Rule ConnectionPointReferenceRule ****************/

}
