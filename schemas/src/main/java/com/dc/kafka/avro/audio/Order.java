/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.dc.kafka.avro.audio;
@org.apache.avro.specific.AvroGenerated
public enum Order implements org.apache.avro.generic.GenericEnumSymbol<Order> {
  FIRST, LAST  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"Order\",\"namespace\":\"com.dc.kafka.avro.audio\",\"symbols\":[\"FIRST\",\"LAST\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
}