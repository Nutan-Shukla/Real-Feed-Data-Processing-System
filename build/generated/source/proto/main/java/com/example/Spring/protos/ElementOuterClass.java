// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Element.proto

// Protobuf Java Version: 3.25.2
package com.example.Spring.protos;

public final class ElementOuterClass {
  private ElementOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_Spring_Project_Element_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_Spring_Project_Element_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rElement.proto\022\032com.example.Spring.Proj" +
      "ect\"{\n\007Element\022\n\n\002id\030\001 \001(\t\022\014\n\004mode\030\002 \001(\t" +
      "\022\017\n\007user_id\030\003 \001(\005\022\026\n\016metal_quantity\030\004 \001(" +
      "\001\022\017\n\007balance\030\005 \001(\001\022\r\n\005price\030\006 \001(\001\022\r\n\005met" +
      "al\030\007 \001(\tB\035\n\031com.example.Spring.protosP\001b" +
      "\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_example_Spring_Project_Element_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_example_Spring_Project_Element_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_Spring_Project_Element_descriptor,
        new java.lang.String[] { "Id", "Mode", "UserId", "MetalQuantity", "Balance", "Price", "Metal", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
