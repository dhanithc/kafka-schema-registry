/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.dc.kafka.avro.btlnse;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class Payment extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -6614705942512740605L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Payment\",\"namespace\":\"com.dc.kafka.avro.btlnse\",\"fields\":[{\"name\":\"id\",\"type\":\"string\"},{\"name\":\"currNo\",\"type\":\"long\"},{\"name\":\"companyCode\",\"type\":\"string\"},{\"name\":\"BU\",\"type\":\"string\"},{\"name\":\"audit\",\"type\":{\"type\":\"record\",\"name\":\"Audit\",\"fields\":[{\"name\":\"companyId\",\"type\":\"string\"},{\"name\":\"eventCreationTime\",\"type\":\"string\"},{\"name\":\"inputterList\",\"type\":{\"type\":\"array\",\"items\":\"string\"}},{\"name\":\"eventId\",\"type\":\"string\"},{\"name\":\"dateTimeList\",\"type\":{\"type\":\"array\",\"items\":\"string\"}}]}},{\"name\":\"countryCode\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"testOptionalField\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"testRequiredField\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Payment> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Payment> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Payment> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Payment> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Payment> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Payment to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Payment from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Payment instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Payment fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence id;
  private long currNo;
  private java.lang.CharSequence companyCode;
  private java.lang.CharSequence BU;
  private com.dc.kafka.avro.btlnse.Audit audit;
  private java.lang.CharSequence countryCode;
  private java.lang.CharSequence testOptionalField;
  private java.lang.CharSequence testRequiredField;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Payment() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param currNo The new value for currNo
   * @param companyCode The new value for companyCode
   * @param BU The new value for BU
   * @param audit The new value for audit
   * @param countryCode The new value for countryCode
   * @param testOptionalField The new value for testOptionalField
   * @param testRequiredField The new value for testRequiredField
   */
  public Payment(java.lang.CharSequence id, java.lang.Long currNo, java.lang.CharSequence companyCode, java.lang.CharSequence BU, com.dc.kafka.avro.btlnse.Audit audit, java.lang.CharSequence countryCode, java.lang.CharSequence testOptionalField, java.lang.CharSequence testRequiredField) {
    this.id = id;
    this.currNo = currNo;
    this.companyCode = companyCode;
    this.BU = BU;
    this.audit = audit;
    this.countryCode = countryCode;
    this.testOptionalField = testOptionalField;
    this.testRequiredField = testRequiredField;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return currNo;
    case 2: return companyCode;
    case 3: return BU;
    case 4: return audit;
    case 5: return countryCode;
    case 6: return testOptionalField;
    case 7: return testRequiredField;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.CharSequence)value$; break;
    case 1: currNo = (java.lang.Long)value$; break;
    case 2: companyCode = (java.lang.CharSequence)value$; break;
    case 3: BU = (java.lang.CharSequence)value$; break;
    case 4: audit = (com.dc.kafka.avro.btlnse.Audit)value$; break;
    case 5: countryCode = (java.lang.CharSequence)value$; break;
    case 6: testOptionalField = (java.lang.CharSequence)value$; break;
    case 7: testRequiredField = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.CharSequence getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.CharSequence value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'currNo' field.
   * @return The value of the 'currNo' field.
   */
  public long getCurrNo() {
    return currNo;
  }


  /**
   * Sets the value of the 'currNo' field.
   * @param value the value to set.
   */
  public void setCurrNo(long value) {
    this.currNo = value;
  }

  /**
   * Gets the value of the 'companyCode' field.
   * @return The value of the 'companyCode' field.
   */
  public java.lang.CharSequence getCompanyCode() {
    return companyCode;
  }


  /**
   * Sets the value of the 'companyCode' field.
   * @param value the value to set.
   */
  public void setCompanyCode(java.lang.CharSequence value) {
    this.companyCode = value;
  }

  /**
   * Gets the value of the 'BU' field.
   * @return The value of the 'BU' field.
   */
  public java.lang.CharSequence getBU() {
    return BU;
  }


  /**
   * Sets the value of the 'BU' field.
   * @param value the value to set.
   */
  public void setBU(java.lang.CharSequence value) {
    this.BU = value;
  }

  /**
   * Gets the value of the 'audit' field.
   * @return The value of the 'audit' field.
   */
  public com.dc.kafka.avro.btlnse.Audit getAudit() {
    return audit;
  }


  /**
   * Sets the value of the 'audit' field.
   * @param value the value to set.
   */
  public void setAudit(com.dc.kafka.avro.btlnse.Audit value) {
    this.audit = value;
  }

  /**
   * Gets the value of the 'countryCode' field.
   * @return The value of the 'countryCode' field.
   */
  public java.lang.CharSequence getCountryCode() {
    return countryCode;
  }


  /**
   * Sets the value of the 'countryCode' field.
   * @param value the value to set.
   */
  public void setCountryCode(java.lang.CharSequence value) {
    this.countryCode = value;
  }

  /**
   * Gets the value of the 'testOptionalField' field.
   * @return The value of the 'testOptionalField' field.
   */
  public java.lang.CharSequence getTestOptionalField() {
    return testOptionalField;
  }


  /**
   * Sets the value of the 'testOptionalField' field.
   * @param value the value to set.
   */
  public void setTestOptionalField(java.lang.CharSequence value) {
    this.testOptionalField = value;
  }

  /**
   * Gets the value of the 'testRequiredField' field.
   * @return The value of the 'testRequiredField' field.
   */
  public java.lang.CharSequence getTestRequiredField() {
    return testRequiredField;
  }


  /**
   * Sets the value of the 'testRequiredField' field.
   * @param value the value to set.
   */
  public void setTestRequiredField(java.lang.CharSequence value) {
    this.testRequiredField = value;
  }

  /**
   * Creates a new Payment RecordBuilder.
   * @return A new Payment RecordBuilder
   */
  public static com.dc.kafka.avro.btlnse.Payment.Builder newBuilder() {
    return new com.dc.kafka.avro.btlnse.Payment.Builder();
  }

  /**
   * Creates a new Payment RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Payment RecordBuilder
   */
  public static com.dc.kafka.avro.btlnse.Payment.Builder newBuilder(com.dc.kafka.avro.btlnse.Payment.Builder other) {
    if (other == null) {
      return new com.dc.kafka.avro.btlnse.Payment.Builder();
    } else {
      return new com.dc.kafka.avro.btlnse.Payment.Builder(other);
    }
  }

  /**
   * Creates a new Payment RecordBuilder by copying an existing Payment instance.
   * @param other The existing instance to copy.
   * @return A new Payment RecordBuilder
   */
  public static com.dc.kafka.avro.btlnse.Payment.Builder newBuilder(com.dc.kafka.avro.btlnse.Payment other) {
    if (other == null) {
      return new com.dc.kafka.avro.btlnse.Payment.Builder();
    } else {
      return new com.dc.kafka.avro.btlnse.Payment.Builder(other);
    }
  }

  /**
   * RecordBuilder for Payment instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Payment>
    implements org.apache.avro.data.RecordBuilder<Payment> {

    private java.lang.CharSequence id;
    private long currNo;
    private java.lang.CharSequence companyCode;
    private java.lang.CharSequence BU;
    private com.dc.kafka.avro.btlnse.Audit audit;
    private com.dc.kafka.avro.btlnse.Audit.Builder auditBuilder;
    private java.lang.CharSequence countryCode;
    private java.lang.CharSequence testOptionalField;
    private java.lang.CharSequence testRequiredField;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.dc.kafka.avro.btlnse.Payment.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.currNo)) {
        this.currNo = data().deepCopy(fields()[1].schema(), other.currNo);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.companyCode)) {
        this.companyCode = data().deepCopy(fields()[2].schema(), other.companyCode);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.BU)) {
        this.BU = data().deepCopy(fields()[3].schema(), other.BU);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.audit)) {
        this.audit = data().deepCopy(fields()[4].schema(), other.audit);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (other.hasAuditBuilder()) {
        this.auditBuilder = com.dc.kafka.avro.btlnse.Audit.newBuilder(other.getAuditBuilder());
      }
      if (isValidValue(fields()[5], other.countryCode)) {
        this.countryCode = data().deepCopy(fields()[5].schema(), other.countryCode);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.testOptionalField)) {
        this.testOptionalField = data().deepCopy(fields()[6].schema(), other.testOptionalField);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
      if (isValidValue(fields()[7], other.testRequiredField)) {
        this.testRequiredField = data().deepCopy(fields()[7].schema(), other.testRequiredField);
        fieldSetFlags()[7] = other.fieldSetFlags()[7];
      }
    }

    /**
     * Creates a Builder by copying an existing Payment instance
     * @param other The existing instance to copy.
     */
    private Builder(com.dc.kafka.avro.btlnse.Payment other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.currNo)) {
        this.currNo = data().deepCopy(fields()[1].schema(), other.currNo);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.companyCode)) {
        this.companyCode = data().deepCopy(fields()[2].schema(), other.companyCode);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.BU)) {
        this.BU = data().deepCopy(fields()[3].schema(), other.BU);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.audit)) {
        this.audit = data().deepCopy(fields()[4].schema(), other.audit);
        fieldSetFlags()[4] = true;
      }
      this.auditBuilder = null;
      if (isValidValue(fields()[5], other.countryCode)) {
        this.countryCode = data().deepCopy(fields()[5].schema(), other.countryCode);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.testOptionalField)) {
        this.testOptionalField = data().deepCopy(fields()[6].schema(), other.testOptionalField);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.testRequiredField)) {
        this.testRequiredField = data().deepCopy(fields()[7].schema(), other.testRequiredField);
        fieldSetFlags()[7] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.CharSequence getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.dc.kafka.avro.btlnse.Payment.Builder setId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.dc.kafka.avro.btlnse.Payment.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'currNo' field.
      * @return The value.
      */
    public long getCurrNo() {
      return currNo;
    }


    /**
      * Sets the value of the 'currNo' field.
      * @param value The value of 'currNo'.
      * @return This builder.
      */
    public com.dc.kafka.avro.btlnse.Payment.Builder setCurrNo(long value) {
      validate(fields()[1], value);
      this.currNo = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'currNo' field has been set.
      * @return True if the 'currNo' field has been set, false otherwise.
      */
    public boolean hasCurrNo() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'currNo' field.
      * @return This builder.
      */
    public com.dc.kafka.avro.btlnse.Payment.Builder clearCurrNo() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'companyCode' field.
      * @return The value.
      */
    public java.lang.CharSequence getCompanyCode() {
      return companyCode;
    }


    /**
      * Sets the value of the 'companyCode' field.
      * @param value The value of 'companyCode'.
      * @return This builder.
      */
    public com.dc.kafka.avro.btlnse.Payment.Builder setCompanyCode(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.companyCode = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'companyCode' field has been set.
      * @return True if the 'companyCode' field has been set, false otherwise.
      */
    public boolean hasCompanyCode() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'companyCode' field.
      * @return This builder.
      */
    public com.dc.kafka.avro.btlnse.Payment.Builder clearCompanyCode() {
      companyCode = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'BU' field.
      * @return The value.
      */
    public java.lang.CharSequence getBU() {
      return BU;
    }


    /**
      * Sets the value of the 'BU' field.
      * @param value The value of 'BU'.
      * @return This builder.
      */
    public com.dc.kafka.avro.btlnse.Payment.Builder setBU(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.BU = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'BU' field has been set.
      * @return True if the 'BU' field has been set, false otherwise.
      */
    public boolean hasBU() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'BU' field.
      * @return This builder.
      */
    public com.dc.kafka.avro.btlnse.Payment.Builder clearBU() {
      BU = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'audit' field.
      * @return The value.
      */
    public com.dc.kafka.avro.btlnse.Audit getAudit() {
      return audit;
    }


    /**
      * Sets the value of the 'audit' field.
      * @param value The value of 'audit'.
      * @return This builder.
      */
    public com.dc.kafka.avro.btlnse.Payment.Builder setAudit(com.dc.kafka.avro.btlnse.Audit value) {
      validate(fields()[4], value);
      this.auditBuilder = null;
      this.audit = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'audit' field has been set.
      * @return True if the 'audit' field has been set, false otherwise.
      */
    public boolean hasAudit() {
      return fieldSetFlags()[4];
    }

    /**
     * Gets the Builder instance for the 'audit' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public com.dc.kafka.avro.btlnse.Audit.Builder getAuditBuilder() {
      if (auditBuilder == null) {
        if (hasAudit()) {
          setAuditBuilder(com.dc.kafka.avro.btlnse.Audit.newBuilder(audit));
        } else {
          setAuditBuilder(com.dc.kafka.avro.btlnse.Audit.newBuilder());
        }
      }
      return auditBuilder;
    }

    /**
     * Sets the Builder instance for the 'audit' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */

    public com.dc.kafka.avro.btlnse.Payment.Builder setAuditBuilder(com.dc.kafka.avro.btlnse.Audit.Builder value) {
      clearAudit();
      auditBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'audit' field has an active Builder instance
     * @return True if the 'audit' field has an active Builder instance
     */
    public boolean hasAuditBuilder() {
      return auditBuilder != null;
    }

    /**
      * Clears the value of the 'audit' field.
      * @return This builder.
      */
    public com.dc.kafka.avro.btlnse.Payment.Builder clearAudit() {
      audit = null;
      auditBuilder = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'countryCode' field.
      * @return The value.
      */
    public java.lang.CharSequence getCountryCode() {
      return countryCode;
    }


    /**
      * Sets the value of the 'countryCode' field.
      * @param value The value of 'countryCode'.
      * @return This builder.
      */
    public com.dc.kafka.avro.btlnse.Payment.Builder setCountryCode(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.countryCode = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'countryCode' field has been set.
      * @return True if the 'countryCode' field has been set, false otherwise.
      */
    public boolean hasCountryCode() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'countryCode' field.
      * @return This builder.
      */
    public com.dc.kafka.avro.btlnse.Payment.Builder clearCountryCode() {
      countryCode = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'testOptionalField' field.
      * @return The value.
      */
    public java.lang.CharSequence getTestOptionalField() {
      return testOptionalField;
    }


    /**
      * Sets the value of the 'testOptionalField' field.
      * @param value The value of 'testOptionalField'.
      * @return This builder.
      */
    public com.dc.kafka.avro.btlnse.Payment.Builder setTestOptionalField(java.lang.CharSequence value) {
      validate(fields()[6], value);
      this.testOptionalField = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'testOptionalField' field has been set.
      * @return True if the 'testOptionalField' field has been set, false otherwise.
      */
    public boolean hasTestOptionalField() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'testOptionalField' field.
      * @return This builder.
      */
    public com.dc.kafka.avro.btlnse.Payment.Builder clearTestOptionalField() {
      testOptionalField = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'testRequiredField' field.
      * @return The value.
      */
    public java.lang.CharSequence getTestRequiredField() {
      return testRequiredField;
    }


    /**
      * Sets the value of the 'testRequiredField' field.
      * @param value The value of 'testRequiredField'.
      * @return This builder.
      */
    public com.dc.kafka.avro.btlnse.Payment.Builder setTestRequiredField(java.lang.CharSequence value) {
      validate(fields()[7], value);
      this.testRequiredField = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'testRequiredField' field has been set.
      * @return True if the 'testRequiredField' field has been set, false otherwise.
      */
    public boolean hasTestRequiredField() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'testRequiredField' field.
      * @return This builder.
      */
    public com.dc.kafka.avro.btlnse.Payment.Builder clearTestRequiredField() {
      testRequiredField = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Payment build() {
      try {
        Payment record = new Payment();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.currNo = fieldSetFlags()[1] ? this.currNo : (java.lang.Long) defaultValue(fields()[1]);
        record.companyCode = fieldSetFlags()[2] ? this.companyCode : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.BU = fieldSetFlags()[3] ? this.BU : (java.lang.CharSequence) defaultValue(fields()[3]);
        if (auditBuilder != null) {
          try {
            record.audit = this.auditBuilder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("audit"));
            throw e;
          }
        } else {
          record.audit = fieldSetFlags()[4] ? this.audit : (com.dc.kafka.avro.btlnse.Audit) defaultValue(fields()[4]);
        }
        record.countryCode = fieldSetFlags()[5] ? this.countryCode : (java.lang.CharSequence) defaultValue(fields()[5]);
        record.testOptionalField = fieldSetFlags()[6] ? this.testOptionalField : (java.lang.CharSequence) defaultValue(fields()[6]);
        record.testRequiredField = fieldSetFlags()[7] ? this.testRequiredField : (java.lang.CharSequence) defaultValue(fields()[7]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Payment>
    WRITER$ = (org.apache.avro.io.DatumWriter<Payment>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Payment>
    READER$ = (org.apache.avro.io.DatumReader<Payment>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.id);

    out.writeLong(this.currNo);

    out.writeString(this.companyCode);

    out.writeString(this.BU);

    this.audit.customEncode(out);

    if (this.countryCode == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.countryCode);
    }

    if (this.testOptionalField == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.testOptionalField);
    }

    out.writeString(this.testRequiredField);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.id = in.readString(this.id instanceof Utf8 ? (Utf8)this.id : null);

      this.currNo = in.readLong();

      this.companyCode = in.readString(this.companyCode instanceof Utf8 ? (Utf8)this.companyCode : null);

      this.BU = in.readString(this.BU instanceof Utf8 ? (Utf8)this.BU : null);

      if (this.audit == null) {
        this.audit = new com.dc.kafka.avro.btlnse.Audit();
      }
      this.audit.customDecode(in);

      if (in.readIndex() != 1) {
        in.readNull();
        this.countryCode = null;
      } else {
        this.countryCode = in.readString(this.countryCode instanceof Utf8 ? (Utf8)this.countryCode : null);
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.testOptionalField = null;
      } else {
        this.testOptionalField = in.readString(this.testOptionalField instanceof Utf8 ? (Utf8)this.testOptionalField : null);
      }

      this.testRequiredField = in.readString(this.testRequiredField instanceof Utf8 ? (Utf8)this.testRequiredField : null);

    } else {
      for (int i = 0; i < 8; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.id = in.readString(this.id instanceof Utf8 ? (Utf8)this.id : null);
          break;

        case 1:
          this.currNo = in.readLong();
          break;

        case 2:
          this.companyCode = in.readString(this.companyCode instanceof Utf8 ? (Utf8)this.companyCode : null);
          break;

        case 3:
          this.BU = in.readString(this.BU instanceof Utf8 ? (Utf8)this.BU : null);
          break;

        case 4:
          if (this.audit == null) {
            this.audit = new com.dc.kafka.avro.btlnse.Audit();
          }
          this.audit.customDecode(in);
          break;

        case 5:
          if (in.readIndex() != 1) {
            in.readNull();
            this.countryCode = null;
          } else {
            this.countryCode = in.readString(this.countryCode instanceof Utf8 ? (Utf8)this.countryCode : null);
          }
          break;

        case 6:
          if (in.readIndex() != 1) {
            in.readNull();
            this.testOptionalField = null;
          } else {
            this.testOptionalField = in.readString(this.testOptionalField instanceof Utf8 ? (Utf8)this.testOptionalField : null);
          }
          break;

        case 7:
          this.testRequiredField = in.readString(this.testRequiredField instanceof Utf8 ? (Utf8)this.testRequiredField : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










