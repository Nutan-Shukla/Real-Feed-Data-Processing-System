// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ApiResponse.proto

// Protobuf Java Version: 3.25.2
package com.example.Spring.protos;

public final class ApiResponseOuterClass {
  private ApiResponseOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_Spring_Project_ApiResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_Spring_Project_ApiResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021ApiResponse.proto\022\032com.example.Spring." +
      "Project\"*\n\013ApiResponse\022\013\n\003msg\030\001 \001(\t\022\016\n\006s" +
      "tatus\030\002 \001(\tB\035\n\031com.example.Spring.protos" +
      "P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_example_Spring_Project_ApiResponse_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_example_Spring_Project_ApiResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_Spring_Project_ApiResponse_descriptor,
        new java.lang.String[] { "Msg", "Status", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
