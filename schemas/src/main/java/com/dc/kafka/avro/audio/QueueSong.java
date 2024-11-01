/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.dc.kafka.avro.audio;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class QueueSong extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 6296799654033454513L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"QueueSong\",\"namespace\":\"com.dc.kafka.avro.audio\",\"fields\":[{\"name\":\"song\",\"type\":\"string\"},{\"name\":\"artist\",\"type\":\"string\"},{\"name\":\"order\",\"type\":{\"type\":\"enum\",\"name\":\"Order\",\"symbols\":[\"FIRST\",\"LAST\"]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<QueueSong> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<QueueSong> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<QueueSong> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<QueueSong> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<QueueSong> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this QueueSong to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a QueueSong from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a QueueSong instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static QueueSong fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence song;
  private java.lang.CharSequence artist;
  private com.dc.kafka.avro.audio.Order order;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public QueueSong() {}

  /**
   * All-args constructor.
   * @param song The new value for song
   * @param artist The new value for artist
   * @param order The new value for order
   */
  public QueueSong(java.lang.CharSequence song, java.lang.CharSequence artist, com.dc.kafka.avro.audio.Order order) {
    this.song = song;
    this.artist = artist;
    this.order = order;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return song;
    case 1: return artist;
    case 2: return order;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: song = (java.lang.CharSequence)value$; break;
    case 1: artist = (java.lang.CharSequence)value$; break;
    case 2: order = (com.dc.kafka.avro.audio.Order)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'song' field.
   * @return The value of the 'song' field.
   */
  public java.lang.CharSequence getSong() {
    return song;
  }


  /**
   * Sets the value of the 'song' field.
   * @param value the value to set.
   */
  public void setSong(java.lang.CharSequence value) {
    this.song = value;
  }

  /**
   * Gets the value of the 'artist' field.
   * @return The value of the 'artist' field.
   */
  public java.lang.CharSequence getArtist() {
    return artist;
  }


  /**
   * Sets the value of the 'artist' field.
   * @param value the value to set.
   */
  public void setArtist(java.lang.CharSequence value) {
    this.artist = value;
  }

  /**
   * Gets the value of the 'order' field.
   * @return The value of the 'order' field.
   */
  public com.dc.kafka.avro.audio.Order getOrder() {
    return order;
  }


  /**
   * Sets the value of the 'order' field.
   * @param value the value to set.
   */
  public void setOrder(com.dc.kafka.avro.audio.Order value) {
    this.order = value;
  }

  /**
   * Creates a new QueueSong RecordBuilder.
   * @return A new QueueSong RecordBuilder
   */
  public static com.dc.kafka.avro.audio.QueueSong.Builder newBuilder() {
    return new com.dc.kafka.avro.audio.QueueSong.Builder();
  }

  /**
   * Creates a new QueueSong RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new QueueSong RecordBuilder
   */
  public static com.dc.kafka.avro.audio.QueueSong.Builder newBuilder(com.dc.kafka.avro.audio.QueueSong.Builder other) {
    if (other == null) {
      return new com.dc.kafka.avro.audio.QueueSong.Builder();
    } else {
      return new com.dc.kafka.avro.audio.QueueSong.Builder(other);
    }
  }

  /**
   * Creates a new QueueSong RecordBuilder by copying an existing QueueSong instance.
   * @param other The existing instance to copy.
   * @return A new QueueSong RecordBuilder
   */
  public static com.dc.kafka.avro.audio.QueueSong.Builder newBuilder(com.dc.kafka.avro.audio.QueueSong other) {
    if (other == null) {
      return new com.dc.kafka.avro.audio.QueueSong.Builder();
    } else {
      return new com.dc.kafka.avro.audio.QueueSong.Builder(other);
    }
  }

  /**
   * RecordBuilder for QueueSong instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<QueueSong>
    implements org.apache.avro.data.RecordBuilder<QueueSong> {

    private java.lang.CharSequence song;
    private java.lang.CharSequence artist;
    private com.dc.kafka.avro.audio.Order order;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.dc.kafka.avro.audio.QueueSong.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.song)) {
        this.song = data().deepCopy(fields()[0].schema(), other.song);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.artist)) {
        this.artist = data().deepCopy(fields()[1].schema(), other.artist);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.order)) {
        this.order = data().deepCopy(fields()[2].schema(), other.order);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing QueueSong instance
     * @param other The existing instance to copy.
     */
    private Builder(com.dc.kafka.avro.audio.QueueSong other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.song)) {
        this.song = data().deepCopy(fields()[0].schema(), other.song);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.artist)) {
        this.artist = data().deepCopy(fields()[1].schema(), other.artist);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.order)) {
        this.order = data().deepCopy(fields()[2].schema(), other.order);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'song' field.
      * @return The value.
      */
    public java.lang.CharSequence getSong() {
      return song;
    }


    /**
      * Sets the value of the 'song' field.
      * @param value The value of 'song'.
      * @return This builder.
      */
    public com.dc.kafka.avro.audio.QueueSong.Builder setSong(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.song = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'song' field has been set.
      * @return True if the 'song' field has been set, false otherwise.
      */
    public boolean hasSong() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'song' field.
      * @return This builder.
      */
    public com.dc.kafka.avro.audio.QueueSong.Builder clearSong() {
      song = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'artist' field.
      * @return The value.
      */
    public java.lang.CharSequence getArtist() {
      return artist;
    }


    /**
      * Sets the value of the 'artist' field.
      * @param value The value of 'artist'.
      * @return This builder.
      */
    public com.dc.kafka.avro.audio.QueueSong.Builder setArtist(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.artist = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'artist' field has been set.
      * @return True if the 'artist' field has been set, false otherwise.
      */
    public boolean hasArtist() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'artist' field.
      * @return This builder.
      */
    public com.dc.kafka.avro.audio.QueueSong.Builder clearArtist() {
      artist = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'order' field.
      * @return The value.
      */
    public com.dc.kafka.avro.audio.Order getOrder() {
      return order;
    }


    /**
      * Sets the value of the 'order' field.
      * @param value The value of 'order'.
      * @return This builder.
      */
    public com.dc.kafka.avro.audio.QueueSong.Builder setOrder(com.dc.kafka.avro.audio.Order value) {
      validate(fields()[2], value);
      this.order = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'order' field has been set.
      * @return True if the 'order' field has been set, false otherwise.
      */
    public boolean hasOrder() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'order' field.
      * @return This builder.
      */
    public com.dc.kafka.avro.audio.QueueSong.Builder clearOrder() {
      order = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public QueueSong build() {
      try {
        QueueSong record = new QueueSong();
        record.song = fieldSetFlags()[0] ? this.song : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.artist = fieldSetFlags()[1] ? this.artist : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.order = fieldSetFlags()[2] ? this.order : (com.dc.kafka.avro.audio.Order) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<QueueSong>
    WRITER$ = (org.apache.avro.io.DatumWriter<QueueSong>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<QueueSong>
    READER$ = (org.apache.avro.io.DatumReader<QueueSong>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.song);

    out.writeString(this.artist);

    out.writeEnum(this.order.ordinal());

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.song = in.readString(this.song instanceof Utf8 ? (Utf8)this.song : null);

      this.artist = in.readString(this.artist instanceof Utf8 ? (Utf8)this.artist : null);

      this.order = com.dc.kafka.avro.audio.Order.values()[in.readEnum()];

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.song = in.readString(this.song instanceof Utf8 ? (Utf8)this.song : null);
          break;

        case 1:
          this.artist = in.readString(this.artist instanceof Utf8 ? (Utf8)this.artist : null);
          break;

        case 2:
          this.order = com.dc.kafka.avro.audio.Order.values()[in.readEnum()];
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










