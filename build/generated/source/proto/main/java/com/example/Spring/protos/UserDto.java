// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dto/UserDto.proto

// Protobuf Java Version: 3.25.2
package com.example.Spring.protos;

public final class UserDto {
  private UserDto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_Spring_Project_UserAddRequestDto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_Spring_Project_UserAddRequestDto_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_Spring_Project_UserAddReponseDto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_Spring_Project_UserAddReponseDto_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_Spring_Project_UserUpdateRequestDto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_Spring_Project_UserUpdateRequestDto_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_Spring_Project_UserUpdateResponseDto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_Spring_Project_UserUpdateResponseDto_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_Spring_Project_UserDeleteResponseDto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_Spring_Project_UserDeleteResponseDto_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_Spring_Project_PersonalDetailsRequestDto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_Spring_Project_PersonalDetailsRequestDto_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021dto/UserDto.proto\022\032com.example.Spring." +
      "Project\"B\n\021UserAddRequestDto\022\014\n\004name\030\001 \001" +
      "(\t\022\020\n\010password\030\002 \001(\t\022\r\n\005email\030\003 \001(\t\" \n\021U" +
      "serAddReponseDto\022\013\n\003msg\030\001 \001(\t\"F\n\024UserUpd" +
      "ateRequestDto\022\024\n\014updated_name\030\001 \001(\t\022\030\n\020u" +
      "pdated_password\030\002 \001(\t\"$\n\025UserUpdateRespo" +
      "nseDto\022\013\n\003msg\030\001 \001(\t\"$\n\025UserDeleteRespons" +
      "eDto\022\013\n\003msg\030\001 \001(\t\",\n\031PersonalDetailsRequ" +
      "estDto\022\017\n\007user_id\030\001 \001(\005B\035\n\031com.example.S" +
      "pring.protosP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_example_Spring_Project_UserAddRequestDto_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_example_Spring_Project_UserAddRequestDto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_Spring_Project_UserAddRequestDto_descriptor,
        new java.lang.String[] { "Name", "Password", "Email", });
    internal_static_com_example_Spring_Project_UserAddReponseDto_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_example_Spring_Project_UserAddReponseDto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_Spring_Project_UserAddReponseDto_descriptor,
        new java.lang.String[] { "Msg", });
    internal_static_com_example_Spring_Project_UserUpdateRequestDto_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_example_Spring_Project_UserUpdateRequestDto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_Spring_Project_UserUpdateRequestDto_descriptor,
        new java.lang.String[] { "UpdatedName", "UpdatedPassword", });
    internal_static_com_example_Spring_Project_UserUpdateResponseDto_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_example_Spring_Project_UserUpdateResponseDto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_Spring_Project_UserUpdateResponseDto_descriptor,
        new java.lang.String[] { "Msg", });
    internal_static_com_example_Spring_Project_UserDeleteResponseDto_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_com_example_Spring_Project_UserDeleteResponseDto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_Spring_Project_UserDeleteResponseDto_descriptor,
        new java.lang.String[] { "Msg", });
    internal_static_com_example_Spring_Project_PersonalDetailsRequestDto_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_com_example_Spring_Project_PersonalDetailsRequestDto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_Spring_Project_PersonalDetailsRequestDto_descriptor,
        new java.lang.String[] { "UserId", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
