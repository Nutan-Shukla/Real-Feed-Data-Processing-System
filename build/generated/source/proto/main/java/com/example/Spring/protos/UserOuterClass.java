// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: User.proto

// Protobuf Java Version: 3.25.2
package com.example.Spring.protos;

public final class UserOuterClass {
  private UserOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_Spring_Project_User_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_Spring_Project_User_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_Spring_Project_UserList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_Spring_Project_UserList_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nUser.proto\022\032com.example.Spring.Project" +
      "\"\307\001\n\004User\022\n\n\002id\030\001 \001(\003\022\014\n\004name\030\002 \001(\t\022\017\n\007b" +
      "alance\030\003 \001(\001\022\025\n\rgold_quantity\030\004 \001(\001\022\020\n\010p" +
      "assword\030\005 \001(\t\022\014\n\004role\030\006 \001(\t\022\027\n\017silver_qu" +
      "antity\030\007 \001(\001\022\032\n\022palladium_quantity\030\010 \001(\001" +
      "\022\031\n\021platinum_quantity\030\t \001(\001\022\r\n\005email\030\n \001" +
      "(\t\":\n\010UserList\022.\n\004user\030\001 \003(\0132 .com.examp" +
      "le.Spring.Project.UserB\035\n\031com.example.Sp" +
      "ring.protosP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_example_Spring_Project_User_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_example_Spring_Project_User_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_Spring_Project_User_descriptor,
        new java.lang.String[] { "Id", "Name", "Balance", "GoldQuantity", "Password", "Role", "SilverQuantity", "PalladiumQuantity", "PlatinumQuantity", "Email", });
    internal_static_com_example_Spring_Project_UserList_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_example_Spring_Project_UserList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_Spring_Project_UserList_descriptor,
        new java.lang.String[] { "User", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
