/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.providers;

import java.util.Collection;

import org.eclipse.papyrus.diagram.common.helper.NamedElementHelper;
import org.eclipse.papyrus.diagram.usecase.expressions.UMLOCLFactory;
import org.eclipse.papyrus.diagram.usecase.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ExtensionPoint;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Usage;
import org.eclipse.uml2.uml.UseCase;

/**
 * @generated
 */
public class ElementInitializers {

	/**
	 * @generated
	 */
	public static void init_Actor_2011(Actor instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							"let base : String = \'Actor\' in\r\nlet suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in \r\nlet space : Namespace = self.namespace in\r\nlet allMissed : Sequence(String) = suffixes->\r\n    select(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s))\r\n    ) in\r\nlet firstMissed : String = allMissed->first() in \r\nlet noMisses : Boolean = firstMissed.oclIsUndefined() in\r\nlet allNames : Set(String) = \r\n    if noMisses \r\n    then \r\n    space.member->collect(e : NamedElement | \r\n         if e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base\r\n         then \'\' \r\n         else e.name \r\n         endif)->asSet()->excluding(\'\') else Set{\'not in use\'} \r\n    endif in \r\nlet longestName : String = \r\n    if noMisses\r\n    then allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first() \r\n    else \'not in use\' \r\n    endif in \r\nif noMisses then \r\n    if longestName.oclIsUndefined() \r\n    then base \r\n    else longestName.concat(\'1\') \r\n    endif \r\nelse \r\n    base.concat(firstMissed) \r\nendif ",
							UMLPackage.eINSTANCE.getActor()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Actor_2012(Actor instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							"let base : String = \'Actor\' in\r\nlet suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in \r\nlet space : Namespace = self.namespace in\r\nlet allMissed : Sequence(String) = suffixes->\r\n    select(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s))\r\n    ) in\r\nlet firstMissed : String = allMissed->first() in \r\nlet noMisses : Boolean = firstMissed.oclIsUndefined() in\r\nlet allNames : Set(String) = \r\n    if noMisses \r\n    then \r\n    space.member->collect(e : NamedElement | \r\n         if e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base\r\n         then \'\' \r\n         else e.name \r\n         endif)->asSet()->excluding(\'\') else Set{\'not in use\'} \r\n    endif in \r\nlet longestName : String = \r\n    if noMisses\r\n    then allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first() \r\n    else \'not in use\' \r\n    endif in \r\nif noMisses then \r\n    if longestName.oclIsUndefined() \r\n    then base \r\n    else longestName.concat(\'1\') \r\n    endif \r\nelse \r\n    base.concat(firstMissed) \r\nendif ",
							UMLPackage.eINSTANCE.getActor()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_UseCase_2013(UseCase instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'UseCase\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getUseCase()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_UseCase_2014(UseCase instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'UseCase\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getUseCase()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Component_2015(Component instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							"let base : String = \'Subsystem\' in\r\nlet suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in \r\nlet space : Namespace = self.namespace in\r\nlet allMissed : Sequence(String) = suffixes->\r\n    select(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s))\r\n    ) in\r\nlet firstMissed : String = allMissed->first() in \r\nlet noMisses : Boolean = firstMissed.oclIsUndefined() in\r\nlet allNames : Set(String) = \r\n    if noMisses \r\n    then \r\n    space.member->collect(e : NamedElement | \r\n         if e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base\r\n         then \'\' \r\n         else e.name \r\n         endif)->asSet()->excluding(\'\') else Set{\'not in use\'} \r\n    endif in \r\nlet longestName : String = \r\n    if noMisses\r\n    then allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first() \r\n    else \'not in use\' \r\n    endif in \r\nif noMisses then \r\n    if longestName.oclIsUndefined() \r\n    then base \r\n    else longestName.concat(\'1\') \r\n    endif \r\nelse \r\n    base.concat(firstMissed) \r\nendif ",
							UMLPackage.eINSTANCE.getComponent()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Package_2016(Package instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'package\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getPackage()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Constraint_2017(Constraint instance) {
		try {
			OpaqueExpression newInstance_0_0 = UMLFactory.eINSTANCE.createOpaqueExpression();

			instance.setSpecification(newInstance_0_0);
			;
			Object value_0_0_0 = UMLOCLFactory.getExpression("\'OpaqueExpression\'",
					UMLPackage.eINSTANCE.getOpaqueExpression()).evaluate(newInstance_0_0);
			if (value_0_0_0 instanceof Collection) {
				newInstance_0_0.getBodies().clear();
				newInstance_0_0.getBodies().addAll(((Collection) value_0_0_0));
			} else {
				newInstance_0_0.getBodies().add((String) value_0_0_0);
			}

		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Comment_2018(Comment instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression("\' \'", UMLPackage.eINSTANCE.getComment()).evaluate(instance);
			instance.setBody((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_ExtensionPoint_3007(ExtensionPoint instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'point\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getExtensionPoint()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_ExtensionPoint_3008(ExtensionPoint instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'point\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getExtensionPoint()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_UseCase_3009(UseCase instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'UseCase\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getUseCase()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Component_3016(Component instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							"let base : String = \'Subsystem\' in\r\nlet suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in \r\nlet space : Namespace = self.namespace in\r\nlet allMissed : Sequence(String) = suffixes->\r\n    select(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s))\r\n    ) in\r\nlet firstMissed : String = allMissed->first() in \r\nlet noMisses : Boolean = firstMissed.oclIsUndefined() in\r\nlet allNames : Set(String) = \r\n    if noMisses \r\n    then \r\n    space.member->collect(e : NamedElement | \r\n         if e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base\r\n         then \'\' \r\n         else e.name \r\n         endif)->asSet()->excluding(\'\') else Set{\'not in use\'} \r\n    endif in \r\nlet longestName : String = \r\n    if noMisses\r\n    then allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first() \r\n    else \'not in use\' \r\n    endif in \r\nif noMisses then \r\n    if longestName.oclIsUndefined() \r\n    then base \r\n    else longestName.concat(\'1\') \r\n    endif \r\nelse \r\n    base.concat(firstMissed) \r\nendif ",
							UMLPackage.eINSTANCE.getComponent()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Comment_3015(Comment instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression("\' \'", UMLPackage.eINSTANCE.getComment()).evaluate(instance);
			instance.setBody((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Constraint_3017(Constraint instance) {
		try {
			OpaqueExpression newInstance_0_0 = UMLFactory.eINSTANCE.createOpaqueExpression();

			instance.setSpecification(newInstance_0_0);
			;
			Object value_0_0_0 = UMLOCLFactory.getExpression("\'OpaqueExpression\'",
					UMLPackage.eINSTANCE.getOpaqueExpression()).evaluate(newInstance_0_0);
			if (value_0_0_0 instanceof Collection) {
				newInstance_0_0.getBodies().clear();
				newInstance_0_0.getBodies().addAll(((Collection) value_0_0_0));
			} else {
				newInstance_0_0.getBodies().add((String) value_0_0_0);
			}

		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Actor_3018(Actor instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							"let base : String = \'Actor\' in\r\nlet suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in \r\nlet space : Namespace = self.namespace in\r\nlet allMissed : Sequence(String) = suffixes->\r\n    select(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s))\r\n    ) in\r\nlet firstMissed : String = allMissed->first() in \r\nlet noMisses : Boolean = firstMissed.oclIsUndefined() in\r\nlet allNames : Set(String) = \r\n    if noMisses \r\n    then \r\n    space.member->collect(e : NamedElement | \r\n         if e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base\r\n         then \'\' \r\n         else e.name \r\n         endif)->asSet()->excluding(\'\') else Set{\'not in use\'} \r\n    endif in \r\nlet longestName : String = \r\n    if noMisses\r\n    then allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first() \r\n    else \'not in use\' \r\n    endif in \r\nif noMisses then \r\n    if longestName.oclIsUndefined() \r\n    then base \r\n    else longestName.concat(\'1\') \r\n    endif \r\nelse \r\n    base.concat(firstMissed) \r\nendif ",
							UMLPackage.eINSTANCE.getActor()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Package_3019(Package instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'package\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getPackage()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Constraint_3010(Constraint instance) {
		try {
			OpaqueExpression newInstance_0_0 = UMLFactory.eINSTANCE.createOpaqueExpression();

			instance.setSpecification(newInstance_0_0);
			;
			Object value_0_0_0 = UMLOCLFactory.getExpression("\'OpaqueExpression\'",
					UMLPackage.eINSTANCE.getOpaqueExpression()).evaluate(newInstance_0_0);
			if (value_0_0_0 instanceof Collection) {
				newInstance_0_0.getBodies().clear();
				newInstance_0_0.getBodies().addAll(((Collection) value_0_0_0));
			} else {
				newInstance_0_0.getBodies().add((String) value_0_0_0);
			}

		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Actor_3011(Actor instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							"let base : String = \'Actor\' in\r\nlet suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in \r\nlet space : Namespace = self.namespace in\r\nlet allMissed : Sequence(String) = suffixes->\r\n    select(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s))\r\n    ) in\r\nlet firstMissed : String = allMissed->first() in \r\nlet noMisses : Boolean = firstMissed.oclIsUndefined() in\r\nlet allNames : Set(String) = \r\n    if noMisses \r\n    then \r\n    space.member->collect(e : NamedElement | \r\n         if e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base\r\n         then \'\' \r\n         else e.name \r\n         endif)->asSet()->excluding(\'\') else Set{\'not in use\'} \r\n    endif in \r\nlet longestName : String = \r\n    if noMisses\r\n    then allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first() \r\n    else \'not in use\' \r\n    endif in \r\nif noMisses then \r\n    if longestName.oclIsUndefined() \r\n    then base \r\n    else longestName.concat(\'1\') \r\n    endif \r\nelse \r\n    base.concat(firstMissed) \r\nendif ",
							UMLPackage.eINSTANCE.getActor()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_UseCase_3012(UseCase instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'UseCase\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getUseCase()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Component_3013(Component instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							"let base : String = \'Subsystem\' in\r\nlet suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in \r\nlet space : Namespace = self.namespace in\r\nlet allMissed : Sequence(String) = suffixes->\r\n    select(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s))\r\n    ) in\r\nlet firstMissed : String = allMissed->first() in \r\nlet noMisses : Boolean = firstMissed.oclIsUndefined() in\r\nlet allNames : Set(String) = \r\n    if noMisses \r\n    then \r\n    space.member->collect(e : NamedElement | \r\n         if e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base\r\n         then \'\' \r\n         else e.name \r\n         endif)->asSet()->excluding(\'\') else Set{\'not in use\'} \r\n    endif in \r\nlet longestName : String = \r\n    if noMisses\r\n    then allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first() \r\n    else \'not in use\' \r\n    endif in \r\nif noMisses then \r\n    if longestName.oclIsUndefined() \r\n    then base \r\n    else longestName.concat(\'1\') \r\n    endif \r\nelse \r\n    base.concat(firstMissed) \r\nendif ",
							UMLPackage.eINSTANCE.getComponent()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Package_3014(Package instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							" let base : String = \'package\' in  let suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in  let space : Namespace = self.namespace in  let allMissed : Sequence(String) = suffixes-> \tselect(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s)) ) in  let firstMissed : String = allMissed->first() in  let noMisses : Boolean = firstMissed.oclIsUndefined() in  let allNames : Set(String) =  \tif noMisses \t\tthen \t\tspace.member->collect(e : NamedElement | \t\t\tif e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base \t\t\tthen \'\' else e.name \t\t\tendif \t\t)->asSet()->excluding(\'\') \t\telse Set{\'not in use\'} \t\tendif in  let longestName : String = \t\tif noMisses \t\tthen allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first()\t\telse \'not in use\' \t\tendif \tin  if noMisses then \t\tif longestName.oclIsUndefined() \t\tthen base \t\telse longestName.concat(\'1\') \t\tendif  else base.concat(firstMissed)  endif ",
							UMLPackage.eINSTANCE.getPackage()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Association_4011(Association instance) {
		try {
			Object value_0 = UMLOCLFactory
					.getExpression(
							"let sourceName : String = self.memberEnd->first().name in\r\nlet targetName : String = self.memberEnd->at(2).name in\r\n\'A_\'.concat(sourceName).concat(\'_\').concat(targetName)",
							UMLPackage.eINSTANCE.getAssociation()).evaluate(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Dependency_4013(Dependency instance) {
		try {
			Object value_0 = name_Dependency_4013(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Abstraction_4015(Abstraction instance) {
		try {
			Object value_0 = name_Abstraction_4015(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Usage_4016(Usage instance) {
		try {
			Object value_0 = name_Usage_4016(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Realization_4017(Realization instance) {
		try {
			Object value_0 = name_Realization_4017(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated NOT
	 */
	private static String name_Dependency_4013(Dependency self) {
		return getName(self);
	}

	/**
	 * @generated NOT
	 */
	private static String name_Abstraction_4015(Abstraction self) {
		return getName(self);
	}

	/**
	 * @generated NOT
	 */
	private static String name_Usage_4016(Usage self) {
		return getName(self);
	}

	/**
	 * @generated NOT
	 */
	private static String name_Realization_4017(Realization self) {
		return getName(self);
	}

	/**
	 * Custom code.
	 * 
	 * @param self
	 *            the current object
	 * 
	 * @return the element name
	 */
	private static String getName(org.eclipse.uml2.uml.Element self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());

	}

}
