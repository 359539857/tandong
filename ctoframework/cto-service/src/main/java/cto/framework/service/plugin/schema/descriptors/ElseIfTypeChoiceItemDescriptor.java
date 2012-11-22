/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.service.plugin.schema.descriptors;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import cto.framework.service.plugin.schema.ElseIfTypeChoiceItem;

/**
 * Class ElseIfTypeChoiceItemDescriptor.
 * 
 * @version $Revision$ $Date$
 */
public class ElseIfTypeChoiceItemDescriptor extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {

    /**
     * Field _elementDefinition.
     */
    private boolean _elementDefinition;

    /**
     * Field _nsPrefix.
     */
    private java.lang.String _nsPrefix;

    /**
     * Field _nsURI.
     */
    private java.lang.String _nsURI;

    /**
     * Field _xmlName.
     */
    private java.lang.String _xmlName;

    /**
     * Field _identity.
     */
    private org.exolab.castor.xml.XMLFieldDescriptor _identity;

    public ElseIfTypeChoiceItemDescriptor() {
        super();
        _nsURI = "http://www.w3school.com.cn";
        _elementDefinition = false;

        //-- set grouping compositor
        setCompositorAsChoice();
        org.exolab.castor.xml.util.XMLFieldDescriptorImpl  desc           = null;
        org.exolab.castor.mapping.FieldHandler             handler        = null;
        org.exolab.castor.xml.FieldValidator               fieldValidator = null;
        //-- initialize attribute descriptors

        //-- initialize element descriptors

        //-- _ifElseIfGroupList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.service.plugin.schema.IfElseIfGroup.class, "_ifElseIfGroupList", "-error-if-this-is-used-", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                return target.getIfElseIfGroup();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                    target.addIfElseIfGroup( (cto.framework.service.plugin.schema.IfElseIfGroup) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public void resetValue(Object object) throws IllegalStateException, IllegalArgumentException {
                try {
                    ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                    target.removeAllIfElseIfGroup();
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.service.plugin.schema.IfElseIfGroup();
            }
        };
        desc.setSchemaType("list");
        desc.setComponentType("cto.framework.service.plugin.schema.IfElseIfGroup");
        desc.setHandler(handler);
        desc.setContainer(true);
        desc.setClassDescriptor(new cto.framework.service.plugin.schema.descriptors.IfElseIfGroupDescriptor());
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _ifElseIfGroupList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(0);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _tryCatchFinallyGroupList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.service.plugin.schema.TryCatchFinallyGroup.class, "_tryCatchFinallyGroupList", "-error-if-this-is-used-", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                return target.getTryCatchFinallyGroup();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                    target.addTryCatchFinallyGroup( (cto.framework.service.plugin.schema.TryCatchFinallyGroup) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public void resetValue(Object object) throws IllegalStateException, IllegalArgumentException {
                try {
                    ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                    target.removeAllTryCatchFinallyGroup();
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.service.plugin.schema.TryCatchFinallyGroup();
            }
        };
        desc.setSchemaType("list");
        desc.setComponentType("cto.framework.service.plugin.schema.TryCatchFinallyGroup");
        desc.setHandler(handler);
        desc.setContainer(true);
        desc.setClassDescriptor(new cto.framework.service.plugin.schema.descriptors.TryCatchFinallyGroupDescriptor());
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _tryCatchFinallyGroupList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(0);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _log
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.service.plugin.schema.Log.class, "_log", "Log", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                return target.getLog();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                    target.setLog( (cto.framework.service.plugin.schema.Log) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.service.plugin.schema.Log();
            }
        };
        desc.setSchemaType("cto.framework.service.plugin.schema.Log");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _log
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _for
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.service.plugin.schema.For.class, "_for", "For", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                return target.getFor();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                    target.setFor( (cto.framework.service.plugin.schema.For) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.service.plugin.schema.For();
            }
        };
        desc.setSchemaType("cto.framework.service.plugin.schema.For");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _for
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _return
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.service.plugin.schema.Return.class, "_return", "Return", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                return target.getReturn();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                    target.setReturn( (cto.framework.service.plugin.schema.Return) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.service.plugin.schema.Return();
            }
        };
        desc.setSchemaType("cto.framework.service.plugin.schema.Return");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _return
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _setValue
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.service.plugin.schema.SetValue.class, "_setValue", "SetValue", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                return target.getSetValue();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                    target.setSetValue( (cto.framework.service.plugin.schema.SetValue) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.service.plugin.schema.SetValue();
            }
        };
        desc.setSchemaType("cto.framework.service.plugin.schema.SetValue");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _setValue
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _out
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.service.plugin.schema.Out.class, "_out", "Out", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                return target.getOut();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                    target.setOut( (cto.framework.service.plugin.schema.Out) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.service.plugin.schema.Out();
            }
        };
        desc.setSchemaType("cto.framework.service.plugin.schema.Out");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _out
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _call
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.service.plugin.schema.Call.class, "_call", "Call", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                return target.getCall();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                    target.setCall( (cto.framework.service.plugin.schema.Call) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.service.plugin.schema.Call();
            }
        };
        desc.setSchemaType("cto.framework.service.plugin.schema.Call");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _call
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _insert
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.service.plugin.schema.Insert.class, "_insert", "Insert", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                return target.getInsert();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                    target.setInsert( (cto.framework.service.plugin.schema.Insert) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.service.plugin.schema.Insert();
            }
        };
        desc.setSchemaType("cto.framework.service.plugin.schema.Insert");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _insert
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _update
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.service.plugin.schema.Update.class, "_update", "Update", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                return target.getUpdate();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                    target.setUpdate( (cto.framework.service.plugin.schema.Update) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.service.plugin.schema.Update();
            }
        };
        desc.setSchemaType("cto.framework.service.plugin.schema.Update");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _update
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _delete
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.service.plugin.schema.Delete.class, "_delete", "Delete", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                return target.getDelete();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                    target.setDelete( (cto.framework.service.plugin.schema.Delete) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.service.plugin.schema.Delete();
            }
        };
        desc.setSchemaType("cto.framework.service.plugin.schema.Delete");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _delete
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _selectRecordSet
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.service.plugin.schema.SelectRecordSet.class, "_selectRecordSet", "SelectRecordSet", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                return target.getSelectRecordSet();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                    target.setSelectRecordSet( (cto.framework.service.plugin.schema.SelectRecordSet) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.service.plugin.schema.SelectRecordSet();
            }
        };
        desc.setSchemaType("cto.framework.service.plugin.schema.SelectRecordSet");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _selectRecordSet
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _selectRecord
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.service.plugin.schema.SelectRecord.class, "_selectRecord", "SelectRecord", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                return target.getSelectRecord();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                    target.setSelectRecord( (cto.framework.service.plugin.schema.SelectRecord) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.service.plugin.schema.SelectRecord();
            }
        };
        desc.setSchemaType("cto.framework.service.plugin.schema.SelectRecord");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _selectRecord
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _selectFeild
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.service.plugin.schema.SelectFeild.class, "_selectFeild", "SelectFeild", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                return target.getSelectFeild();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                    target.setSelectFeild( (cto.framework.service.plugin.schema.SelectFeild) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.service.plugin.schema.SelectFeild();
            }
        };
        desc.setSchemaType("cto.framework.service.plugin.schema.SelectFeild");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _selectFeild
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _httpClient
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.service.plugin.schema.HttpClient.class, "_httpClient", "HttpClient", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                return target.getHttpClient();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                    target.setHttpClient( (cto.framework.service.plugin.schema.HttpClient) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.service.plugin.schema.HttpClient();
            }
        };
        desc.setSchemaType("cto.framework.service.plugin.schema.HttpClient");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _httpClient
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _bean
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.service.plugin.schema.Bean.class, "_bean", "Bean", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                return target.getBean();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                    target.setBean( (cto.framework.service.plugin.schema.Bean) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.service.plugin.schema.Bean();
            }
        };
        desc.setSchemaType("cto.framework.service.plugin.schema.Bean");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _bean
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _invoke
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.service.plugin.schema.Invoke.class, "_invoke", "Invoke", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                return target.getInvoke();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                    target.setInvoke( (cto.framework.service.plugin.schema.Invoke) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.service.plugin.schema.Invoke();
            }
        };
        desc.setSchemaType("cto.framework.service.plugin.schema.Invoke");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _invoke
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _hadoopUtil
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.service.plugin.schema.HadoopUtil.class, "_hadoopUtil", "HadoopUtil", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                return target.getHadoopUtil();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                    target.setHadoopUtil( (cto.framework.service.plugin.schema.HadoopUtil) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.service.plugin.schema.HadoopUtil();
            }
        };
        desc.setSchemaType("cto.framework.service.plugin.schema.HadoopUtil");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _hadoopUtil
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _commitTrans
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.Object.class, "_commitTrans", "CommitTrans", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                return target.getCommitTrans();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                    target.setCommitTrans( (java.lang.Object) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new java.lang.Object();
            }
        };
        desc.setSchemaType("java.lang.Object");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _commitTrans
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _rollbackTrans
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.Object.class, "_rollbackTrans", "RollbackTrans", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                return target.getRollbackTrans();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseIfTypeChoiceItem target = (ElseIfTypeChoiceItem) object;
                    target.setRollbackTrans( (java.lang.Object) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new java.lang.Object();
            }
        };
        desc.setSchemaType("java.lang.Object");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _rollbackTrans
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
    }

    /**
     * Method getAccessMode.
     * 
     * @return the access mode specified for this class.
     */
    @Override()
    public org.exolab.castor.mapping.AccessMode getAccessMode() {
        return null;
    }

    /**
     * Method getIdentity.
     * 
     * @return the identity field, null if this class has no
     * identity.
     */
    @Override()
    public org.exolab.castor.mapping.FieldDescriptor getIdentity() {
        return _identity;
    }

    /**
     * Method getJavaClass.
     * 
     * @return the Java class represented by this descriptor.
     */
    @Override()
    public java.lang.Class getJavaClass() {
        return cto.framework.service.plugin.schema.ElseIfTypeChoiceItem.class;
    }

    /**
     * Method getNameSpacePrefix.
     * 
     * @return the namespace prefix to use when marshaling as XML.
     */
    @Override()
    public java.lang.String getNameSpacePrefix() {
        return _nsPrefix;
    }

    /**
     * Method getNameSpaceURI.
     * 
     * @return the namespace URI used when marshaling and
     * unmarshaling as XML.
     */
    @Override()
    public java.lang.String getNameSpaceURI() {
        return _nsURI;
    }

    /**
     * Method getValidator.
     * 
     * @return a specific validator for the class described by this
     * ClassDescriptor.
     */
    @Override()
    public org.exolab.castor.xml.TypeValidator getValidator() {
        return this;
    }

    /**
     * Method getXMLName.
     * 
     * @return the XML Name for the Class being described.
     */
    @Override()
    public java.lang.String getXMLName() {
        return _xmlName;
    }

    /**
     * Method isElementDefinition.
     * 
     * @return true if XML schema definition of this Class is that
     * of a global
     * element or element with anonymous type definition.
     */
    public boolean isElementDefinition() {
        return _elementDefinition;
    }

}
