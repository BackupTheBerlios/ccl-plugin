// Copyright (c) 1996-2002 The Regents of the University of California. All
// Rights Reserved. Permission to use, copy, modify, and distribute this
// software and its documentation without fee, and without a written
// agreement is hereby granted, provided that the above copyright notice
// and this paragraph appear in all copies.  This software program and
// documentation are copyrighted by The Regents of the University of
// California. The software program and documentation are supplied "AS
// IS", without any accompanying services from The Regents. The Regents
// does not warrant that the operation of the program will be
// uninterrupted or error-free. The end-user understands that the program
// was developed for research purposes and is advised not to rely
// exclusively on the program for any reason.  IN NO EVENT SHALL THE
// UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY FOR DIRECT, INDIRECT,
// SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES, INCLUDING LOST PROFITS,
// ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
// THE UNIVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF
// SUCH DAMAGE. THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY
// WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
// MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
// PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
// CALIFORNIA HAS NO OBLIGATIONS TO PROVIDE MAINTENANCE, SUPPORT,
// UPDATES, ENHANCEMENTS, OR MODIFICATIONS.

package org.argouml.model.uml;

import org.apache.log4j.Category;
import org.argouml.model.uml.behavioralelements.activitygraphs.ActivityGraphsFactory;
import org.argouml.model.uml.behavioralelements.collaborations.CollaborationsFactory;
import org.argouml.model.uml.behavioralelements.commonbehavior.CommonBehaviorFactory;
import org.argouml.model.uml.behavioralelements.statemachines.StateMachinesFactory;
import org.argouml.model.uml.behavioralelements.usecases.UseCasesFactory;
import org.argouml.model.uml.foundation.core.CoreFactory;
import org.argouml.model.uml.foundation.datatypes.DataTypesFactory;
import org.argouml.model.uml.foundation.extensionmechanisms.ExtensionMechanismsFactory;
import org.argouml.model.uml.modelmanagement.ModelManagementFactory;
import ru.novosoft.uml.MBase;
import ru.novosoft.uml.behavior.activity_graphs.MActionState;
import ru.novosoft.uml.behavior.activity_graphs.MActivityGraph;
import ru.novosoft.uml.behavior.activity_graphs.MCallState;
import ru.novosoft.uml.behavior.activity_graphs.MClassifierInState;
import ru.novosoft.uml.behavior.activity_graphs.MObjectFlowState;
import ru.novosoft.uml.behavior.activity_graphs.MPartition;
import ru.novosoft.uml.behavior.activity_graphs.MSubactivityState;
import ru.novosoft.uml.behavior.collaborations.MAssociationEndRole;
import ru.novosoft.uml.behavior.collaborations.MAssociationRole;
import ru.novosoft.uml.behavior.collaborations.MClassifierRole;
import ru.novosoft.uml.behavior.collaborations.MCollaboration;
import ru.novosoft.uml.behavior.collaborations.MInteraction;
import ru.novosoft.uml.behavior.collaborations.MMessage;
import ru.novosoft.uml.behavior.common_behavior.MAction;
import ru.novosoft.uml.behavior.common_behavior.MActionSequence;
import ru.novosoft.uml.behavior.common_behavior.MAttributeLink;
import ru.novosoft.uml.behavior.common_behavior.MCallAction;
import ru.novosoft.uml.behavior.common_behavior.MComponentInstance;
import ru.novosoft.uml.behavior.common_behavior.MCreateAction;
import ru.novosoft.uml.behavior.common_behavior.MDataValue;
import ru.novosoft.uml.behavior.common_behavior.MDestroyAction;
import ru.novosoft.uml.behavior.common_behavior.MException;
import ru.novosoft.uml.behavior.common_behavior.MInstance;
import ru.novosoft.uml.behavior.common_behavior.MLink;
import ru.novosoft.uml.behavior.common_behavior.MLinkEnd;
import ru.novosoft.uml.behavior.common_behavior.MLinkObject;
import ru.novosoft.uml.behavior.common_behavior.MNodeInstance;
import ru.novosoft.uml.behavior.common_behavior.MObject;
import ru.novosoft.uml.behavior.common_behavior.MReception;
import ru.novosoft.uml.behavior.common_behavior.MReturnAction;
import ru.novosoft.uml.behavior.common_behavior.MSendAction;
import ru.novosoft.uml.behavior.common_behavior.MSignal;
import ru.novosoft.uml.behavior.common_behavior.MTerminateAction;
import ru.novosoft.uml.behavior.common_behavior.MUninterpretedAction;
import ru.novosoft.uml.behavior.state_machines.MCallEvent;
import ru.novosoft.uml.behavior.state_machines.MChangeEvent;
import ru.novosoft.uml.behavior.state_machines.MCompositeState;
import ru.novosoft.uml.behavior.state_machines.MEvent;
import ru.novosoft.uml.behavior.state_machines.MFinalState;
import ru.novosoft.uml.behavior.state_machines.MGuard;
import ru.novosoft.uml.behavior.state_machines.MPseudostate;
import ru.novosoft.uml.behavior.state_machines.MSignalEvent;
import ru.novosoft.uml.behavior.state_machines.MSimpleState;
import ru.novosoft.uml.behavior.state_machines.MState;
import ru.novosoft.uml.behavior.state_machines.MStateMachine;
import ru.novosoft.uml.behavior.state_machines.MStateVertex;
import ru.novosoft.uml.behavior.state_machines.MStubState;
import ru.novosoft.uml.behavior.state_machines.MSubmachineState;
import ru.novosoft.uml.behavior.state_machines.MSynchState;
import ru.novosoft.uml.behavior.state_machines.MTimeEvent;
import ru.novosoft.uml.behavior.state_machines.MTransition;
import ru.novosoft.uml.behavior.use_cases.MActor;
import ru.novosoft.uml.behavior.use_cases.MExtend;
import ru.novosoft.uml.behavior.use_cases.MExtensionPoint;
import ru.novosoft.uml.behavior.use_cases.MInclude;
import ru.novosoft.uml.behavior.use_cases.MUseCase;
import ru.novosoft.uml.behavior.use_cases.MUseCaseInstance;
import ru.novosoft.uml.foundation.core.MAbstraction;
import ru.novosoft.uml.foundation.core.MAssociation;
import ru.novosoft.uml.foundation.core.MAssociationClass;
import ru.novosoft.uml.foundation.core.MAssociationEnd;
import ru.novosoft.uml.foundation.core.MAttribute;
import ru.novosoft.uml.foundation.core.MBehavioralFeature;
import ru.novosoft.uml.foundation.core.MBinding;
import ru.novosoft.uml.foundation.core.MClass;
import ru.novosoft.uml.foundation.core.MClassifier;
import ru.novosoft.uml.foundation.core.MComment;
import ru.novosoft.uml.foundation.core.MComponent;
import ru.novosoft.uml.foundation.core.MConstraint;
import ru.novosoft.uml.foundation.core.MDataType;
import ru.novosoft.uml.foundation.core.MDependency;
import ru.novosoft.uml.foundation.core.MElement;
import ru.novosoft.uml.foundation.core.MFeature;
import ru.novosoft.uml.foundation.core.MFlow;
import ru.novosoft.uml.foundation.core.MGeneralizableElement;
import ru.novosoft.uml.foundation.core.MGeneralization;
import ru.novosoft.uml.foundation.core.MInterface;
import ru.novosoft.uml.foundation.core.MMethod;
import ru.novosoft.uml.foundation.core.MModelElement;
import ru.novosoft.uml.foundation.core.MNamespace;
import ru.novosoft.uml.foundation.core.MNode;
import ru.novosoft.uml.foundation.core.MOperation;
import ru.novosoft.uml.foundation.core.MParameter;
import ru.novosoft.uml.foundation.core.MPermission;
import ru.novosoft.uml.foundation.core.MPresentationElement;
import ru.novosoft.uml.foundation.core.MRelationship;
import ru.novosoft.uml.foundation.core.MStructuralFeature;
import ru.novosoft.uml.foundation.core.MTemplateParameter;
import ru.novosoft.uml.foundation.core.MUsage;
import ru.novosoft.uml.foundation.extension_mechanisms.MStereotype;
import ru.novosoft.uml.foundation.extension_mechanisms.MTaggedValue;
import ru.novosoft.uml.model_management.MElementImport;
import ru.novosoft.uml.model_management.MModel;
import ru.novosoft.uml.model_management.MPackage;
import ru.novosoft.uml.model_management.MSubsystem;

/**
 * Root factory for UML model element instance creation.
 *
 * @since ARGO0.11.2
 * @author Thierry Lach
 * @stereotype singleton
 */
public class UmlFactory extends AbstractUmlModelFactory {

    /** Log4j logging category.
     */
    protected Category logger = null;

    /** Singleton instance.
     */
    private static UmlFactory SINGLETON =
                   new UmlFactory();

    /** Singleton instance access method.
     */
    public static UmlFactory getFactory() {
        return SINGLETON;
    }

    /** Don't allow instantiation.
     *  Create a logger.
     */
    private UmlFactory() {
        logger =Category.getInstance("org.argouml.model.uml.factory");
    }

    /** Returns the package factory for the UML
     *  package Foundation::ExtensionMechanisms.
     *  
     *  @return the ExtensionMechanisms factory instance.
     */
    public ExtensionMechanismsFactory getExtensionMechanisms() {
        return ExtensionMechanismsFactory.getFactory();
    }

    /** Returns the package factory for the UML
     *  package Foundation::DataTypes.
     *  
     *  @return the DataTypes factory instance.
     */
    public DataTypesFactory getDataTypes() {
        return DataTypesFactory.getFactory();
    }

    /** Returns the package factory for the UML
     *  package Foundation::Core.
     *  
     *  @return the Core factory instance.
     */
    public CoreFactory getCore() {
        return CoreFactory.getFactory();
    }

    /** Returns the package factory for the UML
     *  package BehavioralElements::CommonBehavior.
     *  
     *  @return the CommonBehavior factory instance.
     */
    public CommonBehaviorFactory getCommonBehavior() {
        return CommonBehaviorFactory.getFactory();
    }

    /** Returns the package factory for the UML
     *  package BehavioralElements::UseCases.
     *  
     *  @return the UseCases factory instance.
     */
    public UseCasesFactory getUseCases() {
        return UseCasesFactory.getFactory();
    }

    /** Returns the package factory for the UML
     *  package BehavioralElements::StateMachines.
     *  
     *  @return the StateMachines factory instance.
     */
    public StateMachinesFactory getStateMachines() {
        return StateMachinesFactory.getFactory();
    }

    /** Returns the package factory for the UML
     *  package BehavioralElements::Collaborations.
     *  
     *  @return the Collaborations factory instance.
     */
    public CollaborationsFactory getCollaborations() {
        return CollaborationsFactory.getFactory();
    }

    /** Returns the package factory for the UML
     *  package BehavioralElements::ActivityGraphs.
     *  
     *  @return the ActivityGraphs factory instance.
     */
    public ActivityGraphsFactory getActivityGraphs() {
        return ActivityGraphsFactory.getFactory();
    }

    /** Returns the package factory for the UML
     *  package ModelManagement.
     *  
     *  @return the ModelManagement factory instance.
     */
    public ModelManagementFactory getModelManagement() {
        return ModelManagementFactory.getFactory();
    }
    
    /**
     * <p>
     * Deletes a modelelement. It calls the remove method of the modelelement
     * but also does 'cascading deletes' that are not provided for in the 
     * remove method of the modelelement itself. For example: this delete method
     * also removes the binary associations that a class has if the class is 
     * deleted. In this way, it is not longer possible that illegal states exist
     * in the model.
     * </p>
     * <p>
     * The actual deletion is delegated to delete methods in the rest of the 
     * factories. For example: a method deleteClass exists on CoreHelper.
     * Delete methods as deleteClass should only do those extra actions that are
     * necessary for the deletion of the modelelement itself. I.e. deleteClass
     * should only take care of things specific to MClass.
     * <p>
     * The delete methods in the UML Factories should not be called directly
     * throughout the code! Calls should allways refer to this method and never
     * call the deleteXXX method on XXXFactory directly. The reason that it is 
     * possible to call the deleteXXX methods directly is a pure implementation 
     * detail. 
     * </p>
     * <p>
     * The implementation of this method uses a quite complicate if then else 
     * tree. This is done to provide optimal performance and full compliance to
     * the UML 1.3 model. The last remark refers to the fact that the UML 1.3 
     * model knows multiple inheritance in several places. This has to be taken
     * into account.
     * </p>
     * <p>
     * Extensions and its children are not taken into account here. They do not
     * require extra cleanup actions. Not in the form of a call to the remove 
     * method as is normal for all children of MBase and not in the form of other
     * behaviour we want to implement via this operation.
     * </p>
     * @param elem The element to be deleted
     */
    public void delete(MBase elem) {
        if (elem == null) throw new IllegalArgumentException("Element may not be null in delete");
        if (elem instanceof MElement) {
            getCore().deleteElement((MElement)elem);
            if (elem instanceof MModelElement) {
                getCore().deleteModelElement((MModelElement)elem);
                if (elem instanceof MFeature) {
                    deleteFeature((MFeature)elem);
                } else
                if (elem instanceof MNamespace) {
                    deleteNamespace((MNamespace)elem);
                } // no else here to make sure MClassifier with its double inheritance goes ok
                // no else here too to make sure MAssociationClass goes ok
                if (elem instanceof MGeneralizableElement) {
                    getCore().deleteGeneralizableElement((MGeneralizableElement)elem);
                    if (elem instanceof MStereotype) {
                        getExtensionMechanisms().deleteStereotype((MStereotype)elem);
                    }
                } // no else here to make sure MAssociationClass goes ok
                if (elem instanceof MParameter) {
                    getCore().deleteParameter((MParameter)elem);
                } else
                if (elem instanceof MConstraint) {
                    getCore().deleteConstraint((MConstraint)elem);
                } else
                if (elem instanceof MRelationship) {
                    deleteRelationship((MRelationship)elem);
                } else
                if (elem instanceof MAssociationEnd) {
                    getCore().deleteAssociationEnd((MAssociationEnd)elem);
                    if (elem instanceof MAssociationEndRole) {
                        getCollaborations().deleteAssociationEndRole((MAssociationEndRole)elem);
                    }
                } else
                if (elem instanceof MComment) {
                    getCore().deleteComment((MComment)elem);
                } else
                if (elem instanceof MAction) {
                    deleteAction((MAction)elem);
                } else
                if (elem instanceof MAttributeLink) {
                    getCommonBehavior().deleteAttributeLink((MAttributeLink)elem);
                } else
                if (elem instanceof MInstance) {
                    deleteInstance((MInstance)elem);
                } // no else to handle multiple inheritance of linkobject
                if (elem instanceof MLink) {
                    getCommonBehavior().deleteLink((MLink)elem);
                } else 
                if (elem instanceof MLinkEnd) {
                    getCommonBehavior().deleteLinkEnd((MLinkEnd)elem);
                } else
                if (elem instanceof MInteraction) {
                    getCollaborations().deleteInteraction((MInteraction)elem);
                } else
                if (elem instanceof MMessage) {
                    getCollaborations().deleteMessage((MMessage)elem);
                } else
                if (elem instanceof MExtensionPoint) {
                    getUseCases().deleteExtensionPoint((MExtensionPoint)elem);
                } else
                if (elem instanceof MStateVertex) {
                    deleteStateVertex((MStateVertex)elem);
                }        
                if (elem instanceof MStateMachine) {
                    getStateMachines().deleteStateMachine((MStateMachine)elem);
                    if (elem instanceof MActivityGraph) {
                        getActivityGraphs().deleteActivityGraph((MActivityGraph)elem);
                    }
                } else
                if (elem instanceof MTransition) {
                    getStateMachines().deleteTransition((MTransition)elem);
                } else
                if (elem instanceof MGuard) {
                    getStateMachines().deleteGuard((MGuard)elem);
                } else
                if (elem instanceof MEvent) {
                    
                }
            } else
            if (elem instanceof MPresentationElement) {
                getCore().deletePresentationElement((MPresentationElement)elem);
            }
        } else
        if (elem instanceof MTemplateParameter) {
            getCore().deleteTemplateParameter((MTemplateParameter)elem);
        } else
        if (elem instanceof MTaggedValue) {
            getExtensionMechanisms().deleteTaggedValue((MTaggedValue)elem);
        } 
        if (elem instanceof MPartition) {
            getActivityGraphs().deletePartition((MPartition)elem);
        } else
        if (elem instanceof MElementImport) {
            getModelManagement().deleteElementImport((MElementImport)elem);
        }       
       elem.remove();
       UmlModelEventPump.getPump().cleanUp(elem);
    }
     
    /**
     * Factored this method out of delete to simplify the design of the delete
     * operation
     * @param elem
     */
    private void deleteFeature(MFeature elem) {
        getCore().deleteFeature(elem);
        if (elem instanceof MBehavioralFeature) {
            getCore().deleteBehavioralFeature((MBehavioralFeature)elem);
            if (elem instanceof MOperation) {
                getCore().deleteOperation((MOperation)elem);
            } else
            if (elem instanceof MMethod) {
                getCore().deleteMethod((MMethod)elem);
            } else
            if (elem instanceof MReception) {
                getCommonBehavior().deleteReception((MReception)elem);
            }
        } else
        if (elem instanceof MStructuralFeature) {
            getCore().deleteStructuralFeature((MStructuralFeature)elem);
            if (elem instanceof MAttribute) {
                getCore().deleteAttribute((MAttribute)elem);
            }
        } 
    }  
    
    /**
     * Factored this method out of delete to simplify the design of the delete
     * operation
     * @param elem
     */
    private void deleteNamespace(MNamespace elem) {
        getCore().deleteNamespace(elem);
        if (elem instanceof MClassifier) {
            getCore().deleteClassifier((MClassifier)elem);
            if (elem instanceof MClass) {
                getCore().deleteClass((MClass)elem);
                if (elem instanceof MAssociationClass) {
                    getCore().deleteAssociationClass((MAssociationClass)elem);
                }
            } else
            if (elem instanceof MInterface) {
                getCore().deleteInterface((MInterface)elem);
            } else
            if (elem instanceof MDataType) {
                getCore().deleteDataType((MDataType)elem);
            } else
            if (elem instanceof MNode) {
                getCore().deleteNode((MNode)elem);
            } else
            if (elem instanceof MComponent) {
                getCore().deleteComponent((MComponent)elem);
            } else
            if (elem instanceof MSignal) {
                getCommonBehavior().deleteSignal((MSignal)elem);
                if (elem instanceof MException) {
                    getCommonBehavior().deleteException((MException)elem);
                }
            } else
            if (elem instanceof MClassifierRole) {
                getCollaborations().deleteClassifierRole((MClassifierRole)elem);
            } else  
            if (elem instanceof MUseCase) {
                getUseCases().deleteUseCase((MUseCase)elem);
            } else
            if (elem instanceof MActor) {
                getUseCases().deleteActor((MActor)elem);
            } else
            if (elem instanceof MClassifierInState) {
                getActivityGraphs().deleteClassifierInState((MClassifierInState)elem);
            }
        } else
        if (elem instanceof MCollaboration) {
            getCollaborations().deleteCollaboration((MCollaboration)elem);
        } else
        if (elem instanceof MPackage) {
            getModelManagement().deletePackage((MPackage)elem);
            if (elem instanceof MModel) {
                getModelManagement().deleteModel((MModel)elem);
            } else
            if (elem instanceof MSubsystem) {
                getModelManagement().deleteSubsystem((MSubsystem)elem);
            }  
        }   
    }       
    
    /**
     * Factored this method out of delete to simplify the design of the delete
     * operation
     * @param elem
     */
    private void deleteRelationship(MRelationship elem) {
        getCore().deleteRelationship(elem);
        if (elem instanceof MFlow) {
            getCore().deleteFlow((MFlow)elem);
        } else
        if (elem instanceof MGeneralization) {
            getCore().deleteGeneralization((MGeneralization)elem);
        } else
        if (elem instanceof MAssociation) {
            getCore().deleteAssociation((MAssociation)elem);
            if (elem instanceof MAssociationRole) {
                getCollaborations().deleteAssociationRole((MAssociationRole)elem);
            }
        } else
        if (elem instanceof MDependency) {
            getCore().deleteDependency((MDependency)elem);
            if (elem instanceof MAbstraction) {
                getCore().deleteAbstraction((MAbstraction)elem);
            } else
            if (elem instanceof MBinding) {
                getCore().deleteBinding((MBinding)elem);
            } else
            if (elem instanceof MUsage) {
                getCore().deleteUsage((MUsage)elem);
            } else
            if (elem instanceof MPermission) {
                getCore().deletePermission((MPermission)elem);
            }
        } else
        if (elem instanceof MInclude) {
            getUseCases().deleteInclude((MInclude)elem);
        } else
        if (elem instanceof MExtend) {
            getUseCases().deleteExtend((MExtend)elem);
        }  
    }
    
    /**
     * Factored this method out of delete to simplify the design of the delete
     * operation
     * @param elem
     */
    private void deleteAction(MAction elem) {
        getCommonBehavior().deleteAction(elem);
        if (elem instanceof MActionSequence) {
            getCommonBehavior().deleteActionSequence((MActionSequence)elem);
        } else 
        if (elem instanceof MCreateAction) {
            getCommonBehavior().deleteCreateAction((MCreateAction)elem);
        } else
        if (elem instanceof MCallAction) {
            getCommonBehavior().deleteCallAction((MCallAction)elem);
        } else
        if (elem instanceof MReturnAction) {
            getCommonBehavior().deleteReturnAction((MReturnAction)elem);
        } else
        if (elem instanceof MSendAction) {
            getCommonBehavior().deleteSendAction((MSendAction)elem);
        } else
        if (elem instanceof MTerminateAction) {
            getCommonBehavior().deleteTerminateAction((MTerminateAction)elem);
        } else
        if (elem instanceof MUninterpretedAction) {
            getCommonBehavior().deleteUninterpretedAction((MUninterpretedAction)elem);
        } else
        if (elem instanceof MDestroyAction) {
            getCommonBehavior().deleteDestroyAction((MDestroyAction)elem);
        }
    }
    
    /**
     * Factored this method out of delete to simplify the design of the delete
     * operation
     * @param elem
     */
    private void deleteInstance(MInstance elem) {
        getCommonBehavior().deleteInstance(elem);
        if (elem instanceof MDataValue) {
            getCommonBehavior().deleteDataValue((MDataValue)elem);
        } else
        if (elem instanceof MComponentInstance) {
            getCommonBehavior().deleteComponentInstance((MComponentInstance)elem);
        } else
        if (elem instanceof MNodeInstance) {
            getCommonBehavior().deleteNodeInstance((MNodeInstance)elem);
        } else
        if (elem instanceof MObject) {
            getCommonBehavior().deleteObject((MObject)elem);
            if (elem instanceof MLinkObject) {
                getCommonBehavior().deleteLinkObject((MLinkObject)elem);
            }
        } 
        if (elem instanceof MUseCaseInstance) {
            getUseCases().deleteUseCaseInstance((MUseCaseInstance)elem);
        }
    }
    
    /**
     * Factored this method out of delete to simplify the design of the delete
     * operation
     * @param elem
     */
    private void deleteStateVertex(MStateVertex elem) {
        getStateMachines().deleteStateVertex(elem);
        if (elem instanceof MPseudostate) {
            getStateMachines().deletePseudostate((MPseudostate)elem);
        } else
        if (elem instanceof MSynchState) {
            getStateMachines().deleteSynchState((MSynchState)elem);
        } else
        if (elem instanceof MStubState) {
            getStateMachines().deleteStubState((MStubState)elem);
        } else
        if (elem instanceof MState) {
            getStateMachines().deleteState((MState)elem);
            if (elem instanceof MCompositeState) {
                getStateMachines().deleteCompositeState((MCompositeState)elem);
                if (elem instanceof MSubmachineState) {
                    getStateMachines().deleteSubmachineState((MSubmachineState)elem);
                    if (elem instanceof MSubactivityState) {
                        getActivityGraphs().deleteSubactivityState((MSubactivityState)elem);
                    }
                }                            
            } else
            if (elem instanceof MSimpleState) {
                getStateMachines().deleteSimpleState((MSimpleState)elem);
                if (elem instanceof MActionState) {
                    getActivityGraphs().deleteActionState((MActionState)elem);
                    if (elem instanceof MCallState) {
                        getActivityGraphs().deleteCallState((MCallState)elem);
                    }
                } else
                if (elem instanceof MObjectFlowState) {
                    getActivityGraphs().deleteObjectFlowState((MObjectFlowState)elem);
                }
            } else
            if (elem instanceof MFinalState) {
                getStateMachines().deleteFinalState((MFinalState)elem);
            }
        }
    }
    
    /**
     * Factored this method out of delete to simplify the design of the delete
     * operation
     * @param elem
     */
    private void deleteEvent(MEvent elem) {
        getStateMachines().deleteEvent(elem);
        if (elem instanceof MSignalEvent) {
            getStateMachines().deleteSignalEvent((MSignalEvent)elem);
        } else
        if (elem instanceof MCallEvent) {
            getStateMachines().deleteCallEvent((MCallEvent)elem);
        } else 
        if (elem instanceof MTimeEvent) {
            getStateMachines().deleteTimeEvent((MTimeEvent)elem);
        } else
        if (elem instanceof MChangeEvent) {
            getStateMachines().deleteChangeEvent((MChangeEvent)elem);
        }
    }   
    
}
