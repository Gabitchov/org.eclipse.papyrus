/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.tabbedproperties.uml.parts;

// Start of user code for imports

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
 

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public interface DeploymentSpecificationPropertiesEditionPart {

	/**
	 * @return the ownedComment to add
	 */
	public List getOwnedCommentToAdd();
	
	/**
	 * @return the ownedComment to remove
	 */
	public List getOwnedCommentToRemove();
	
	/**
	 * @return the ownedComment to move
	 */
	public List getOwnedCommentToMove();
	
	/**
	 * @return the ownedComment to edit
	 */
	public Map getOwnedCommentToEdit();
	
	/**
	 * @return the current ownedComment
	 */
	public List getOwnedCommentTable();
	
	/**
	 * Init the ownedComment
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initOwnedComment(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the ownedComment
	 * @param newValue the ownedComment to update
	 */
	public void updateOwnedComment(EObject newValue);
	
	
	
	
	
	/**
	 * @return the name
	 */
	public String getName();
	
	/**
	 * Defines a new name
	 * @param newValue the new name to set
	 */
	public void setName(String newValue);
	
	public void setMessageForName (String msg, int msgLevel);	
	
	public void unsetMessageForName ();
	
	/**
	 * @return the visibility
	 */
	public Enumerator getVisibility();
	
	/**
	 * Init the visibility
	 * @param eenum the enum to manage
	 * @param current the current value
	 */
	public void initVisibility(EEnum eenum, Enumerator current);

/**
	 * Defines a new visibility
	 * @param newValue the new visibility to set
	 */
	public void setVisibility(Enumerator newValue);
	
	
	
	
	
	/**
	 * @return the clientDependency to add
	 */
	public List getClientDependencyToAdd();
	
	/**
	 * @return the clientDependency to remove
	 */
	public List getClientDependencyToRemove();
	
	/**
	 * Init the clientDependency
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initClientDependency(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the clientDependency
	 * @param newValue the clientDependency to update
	 */
	public void updateClientDependency(EObject newValue);
	
	
	
	
	
	/**
	 * @return the elementImport to add
	 */
	public List getElementImportToAdd();
	
	/**
	 * @return the elementImport to remove
	 */
	public List getElementImportToRemove();
	
	/**
	 * @return the elementImport to move
	 */
	public List getElementImportToMove();
	
	/**
	 * @return the elementImport to edit
	 */
	public Map getElementImportToEdit();
	
	/**
	 * @return the current elementImport
	 */
	public List getElementImportTable();
	
	/**
	 * Init the elementImport
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initElementImport(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the elementImport
	 * @param newValue the elementImport to update
	 */
	public void updateElementImport(EObject newValue);
	
	
	
	
	
	/**
	 * @return the packageImport to add
	 */
	public List getPackageImportToAdd();
	
	/**
	 * @return the packageImport to remove
	 */
	public List getPackageImportToRemove();
	
	/**
	 * @return the packageImport to move
	 */
	public List getPackageImportToMove();
	
	/**
	 * @return the packageImport to edit
	 */
	public Map getPackageImportToEdit();
	
	/**
	 * @return the current packageImport
	 */
	public List getPackageImportTable();
	
	/**
	 * Init the packageImport
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initPackageImport(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the packageImport
	 * @param newValue the packageImport to update
	 */
	public void updatePackageImport(EObject newValue);
	
	
	
	
	
	/**
	 * @return the ownedRule to add
	 */
	public List getOwnedRuleToAdd();
	
	/**
	 * @return the ownedRule to remove
	 */
	public List getOwnedRuleToRemove();
	
	/**
	 * @return the ownedRule to move
	 */
	public List getOwnedRuleToMove();
	
	/**
	 * @return the ownedRule to edit
	 */
	public Map getOwnedRuleToEdit();
	
	/**
	 * @return the current ownedRule
	 */
	public List getOwnedRuleTable();
	
	/**
	 * Init the ownedRule
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initOwnedRule(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the ownedRule
	 * @param newValue the ownedRule to update
	 */
	public void updateOwnedRule(EObject newValue);
	
	
	
	
	
	/**
	 * @return the isLeaf
	 */
	public Boolean getIsLeaf();
	
	/**
	 * Defines a new isLeaf
	 * @param newValue the new isLeaf to set
	 */
	public void setIsLeaf(Boolean newValue);
	
	
	
	
	
	/**
	 * @return the templateBinding to add
	 */
	public List getTemplateBindingToAdd();
	
	/**
	 * @return the templateBinding to remove
	 */
	public List getTemplateBindingToRemove();
	
	/**
	 * @return the templateBinding to move
	 */
	public List getTemplateBindingToMove();
	
	/**
	 * @return the templateBinding to edit
	 */
	public Map getTemplateBindingToEdit();
	
	/**
	 * @return the current templateBinding
	 */
	public List getTemplateBindingTable();
	
	/**
	 * Init the templateBinding
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initTemplateBinding(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the templateBinding
	 * @param newValue the templateBinding to update
	 */
	public void updateTemplateBinding(EObject newValue);
	
	
	
	
	
	/**
	 * @return the isAbstract
	 */
	public Boolean getIsAbstract();
	
	/**
	 * Defines a new isAbstract
	 * @param newValue the new isAbstract to set
	 */
	public void setIsAbstract(Boolean newValue);
	
	
	
	
	
	/**
	 * @return the generalization to add
	 */
	public List getGeneralizationToAdd();
	
	/**
	 * @return the generalization to remove
	 */
	public List getGeneralizationToRemove();
	
	/**
	 * @return the generalization to move
	 */
	public List getGeneralizationToMove();
	
	/**
	 * @return the generalization to edit
	 */
	public Map getGeneralizationToEdit();
	
	/**
	 * @return the current generalization
	 */
	public List getGeneralizationTable();
	
	/**
	 * Init the generalization
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initGeneralization(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the generalization
	 * @param newValue the generalization to update
	 */
	public void updateGeneralization(EObject newValue);
	
	
	
	
	
	/**
	 * @return the powertypeExtent to add
	 */
	public List getPowertypeExtentToAdd();
	
	/**
	 * @return the powertypeExtent to remove
	 */
	public List getPowertypeExtentToRemove();
	
	/**
	 * Init the powertypeExtent
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initPowertypeExtent(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the powertypeExtent
	 * @param newValue the powertypeExtent to update
	 */
	public void updatePowertypeExtent(EObject newValue);
	
	
	
	
	
	/**
	 * @return the redefinedClassifier to add
	 */
	public List getRedefinedClassifierToAdd();
	
	/**
	 * @return the redefinedClassifier to remove
	 */
	public List getRedefinedClassifierToRemove();
	
	/**
	 * Init the redefinedClassifier
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initRedefinedClassifier(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the redefinedClassifier
	 * @param newValue the redefinedClassifier to update
	 */
	public void updateRedefinedClassifier(EObject newValue);
	
	
	
	
	
	/**
	 * @return the substitution to add
	 */
	public List getSubstitutionToAdd();
	
	/**
	 * @return the substitution to remove
	 */
	public List getSubstitutionToRemove();
	
	/**
	 * @return the substitution to move
	 */
	public List getSubstitutionToMove();
	
	/**
	 * @return the substitution to edit
	 */
	public Map getSubstitutionToEdit();
	
	/**
	 * @return the current substitution
	 */
	public List getSubstitutionTable();
	
	/**
	 * Init the substitution
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initSubstitution(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the substitution
	 * @param newValue the substitution to update
	 */
	public void updateSubstitution(EObject newValue);
	
	
	
	
	
	/**
	 * @return the collaborationUse to add
	 */
	public List getCollaborationUseToAdd();
	
	/**
	 * @return the collaborationUse to remove
	 */
	public List getCollaborationUseToRemove();
	
	/**
	 * @return the collaborationUse to move
	 */
	public List getCollaborationUseToMove();
	
	/**
	 * @return the collaborationUse to edit
	 */
	public Map getCollaborationUseToEdit();
	
	/**
	 * @return the current collaborationUse
	 */
	public List getCollaborationUseTable();
	
	/**
	 * Init the collaborationUse
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initCollaborationUse(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the collaborationUse
	 * @param newValue the collaborationUse to update
	 */
	public void updateCollaborationUse(EObject newValue);
	
	
	
	
	
	/**
	 * @return the ownedUseCase to add
	 */
	public List getOwnedUseCaseToAdd();
	
	/**
	 * @return the ownedUseCase to remove
	 */
	public List getOwnedUseCaseToRemove();
	
	/**
	 * @return the ownedUseCase to move
	 */
	public List getOwnedUseCaseToMove();
	
	/**
	 * @return the ownedUseCase to edit
	 */
	public Map getOwnedUseCaseToEdit();
	
	/**
	 * @return the current ownedUseCase
	 */
	public List getOwnedUseCaseTable();
	
	/**
	 * Init the ownedUseCase
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initOwnedUseCase(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the ownedUseCase
	 * @param newValue the ownedUseCase to update
	 */
	public void updateOwnedUseCase(EObject newValue);
	
	
	
	
	
	/**
	 * @return the useCase to add
	 */
	public List getUseCaseToAdd();
	
	/**
	 * @return the useCase to remove
	 */
	public List getUseCaseToRemove();
	
	/**
	 * Init the useCase
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initUseCase(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the useCase
	 * @param newValue the useCase to update
	 */
	public void updateUseCase(EObject newValue);
	
	
	
	
	
	/**
	 * @return the fileName
	 */
	public String getFileName();
	
	/**
	 * Defines a new fileName
	 * @param newValue the new fileName to set
	 */
	public void setFileName(String newValue);
	
	public void setMessageForFileName (String msg, int msgLevel);	
	
	public void unsetMessageForFileName ();
	
	/**
	 * @return the nestedArtifact to add
	 */
	public List getNestedArtifactToAdd();
	
	/**
	 * @return the nestedArtifact to remove
	 */
	public List getNestedArtifactToRemove();
	
	/**
	 * @return the nestedArtifact to move
	 */
	public List getNestedArtifactToMove();
	
	/**
	 * @return the nestedArtifact to edit
	 */
	public Map getNestedArtifactToEdit();
	
	/**
	 * @return the current nestedArtifact
	 */
	public List getNestedArtifactTable();
	
	/**
	 * Init the nestedArtifact
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initNestedArtifact(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the nestedArtifact
	 * @param newValue the nestedArtifact to update
	 */
	public void updateNestedArtifact(EObject newValue);
	
	
	
	
	
	/**
	 * @return the manifestation to add
	 */
	public List getManifestationToAdd();
	
	/**
	 * @return the manifestation to remove
	 */
	public List getManifestationToRemove();
	
	/**
	 * @return the manifestation to move
	 */
	public List getManifestationToMove();
	
	/**
	 * @return the manifestation to edit
	 */
	public Map getManifestationToEdit();
	
	/**
	 * @return the current manifestation
	 */
	public List getManifestationTable();
	
	/**
	 * Init the manifestation
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initManifestation(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the manifestation
	 * @param newValue the manifestation to update
	 */
	public void updateManifestation(EObject newValue);
	
	
	
	
	
	/**
	 * @return the ownedOperation to add
	 */
	public List getOwnedOperationToAdd();
	
	/**
	 * @return the ownedOperation to remove
	 */
	public List getOwnedOperationToRemove();
	
	/**
	 * @return the ownedOperation to move
	 */
	public List getOwnedOperationToMove();
	
	/**
	 * @return the ownedOperation to edit
	 */
	public Map getOwnedOperationToEdit();
	
	/**
	 * @return the current ownedOperation
	 */
	public List getOwnedOperationTable();
	
	/**
	 * Init the ownedOperation
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initOwnedOperation(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the ownedOperation
	 * @param newValue the ownedOperation to update
	 */
	public void updateOwnedOperation(EObject newValue);
	
	
	
	
	
	/**
	 * @return the ownedAttribute to add
	 */
	public List getOwnedAttributeToAdd();
	
	/**
	 * @return the ownedAttribute to remove
	 */
	public List getOwnedAttributeToRemove();
	
	/**
	 * @return the ownedAttribute to move
	 */
	public List getOwnedAttributeToMove();
	
	/**
	 * @return the ownedAttribute to edit
	 */
	public Map getOwnedAttributeToEdit();
	
	/**
	 * @return the current ownedAttribute
	 */
	public List getOwnedAttributeTable();
	
	/**
	 * Init the ownedAttribute
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initOwnedAttribute(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the ownedAttribute
	 * @param newValue the ownedAttribute to update
	 */
	public void updateOwnedAttribute(EObject newValue);
	
	
	
	
	
	/**
	 * @return the deploymentLocation
	 */
	public String getDeploymentLocation();
	
	/**
	 * Defines a new deploymentLocation
	 * @param newValue the new deploymentLocation to set
	 */
	public void setDeploymentLocation(String newValue);
	
	public void setMessageForDeploymentLocation (String msg, int msgLevel);	
	
	public void unsetMessageForDeploymentLocation ();
	
	/**
	 * @return the executionLocation
	 */
	public String getExecutionLocation();
	
	/**
	 * Defines a new executionLocation
	 * @param newValue the new executionLocation to set
	 */
	public void setExecutionLocation(String newValue);
	
	public void setMessageForExecutionLocation (String msg, int msgLevel);	
	
	public void unsetMessageForExecutionLocation ();
	





	// Start of user code for additional methods
 	
	// End of user code
}

