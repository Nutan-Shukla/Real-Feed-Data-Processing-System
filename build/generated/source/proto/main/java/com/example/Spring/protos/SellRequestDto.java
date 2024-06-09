// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dto/UserTransactionDto.proto

// Protobuf Java Version: 3.25.2
package com.example.Spring.protos;

/**
 * Protobuf type {@code com.example.Spring.Project.SellRequestDto}
 */
public final class SellRequestDto extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.example.Spring.Project.SellRequestDto)
    SellRequestDtoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SellRequestDto.newBuilder() to construct.
  private SellRequestDto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SellRequestDto() {
    element_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new SellRequestDto();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.example.Spring.protos.UserTransactionDto.internal_static_com_example_Spring_Project_SellRequestDto_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.example.Spring.protos.UserTransactionDto.internal_static_com_example_Spring_Project_SellRequestDto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.example.Spring.protos.SellRequestDto.class, com.example.Spring.protos.SellRequestDto.Builder.class);
  }

  public static final int QUANTITY_FIELD_NUMBER = 1;
  private double quantity_ = 0D;
  /**
   * <code>double quantity = 1;</code>
   * @return The quantity.
   */
  @java.lang.Override
  public double getQuantity() {
    return quantity_;
  }

  public static final int ELEMENT_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object element_ = "";
  /**
   * <code>string element = 2;</code>
   * @return The element.
   */
  @java.lang.Override
  public java.lang.String getElement() {
    java.lang.Object ref = element_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      element_ = s;
      return s;
    }
  }
  /**
   * <code>string element = 2;</code>
   * @return The bytes for element.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getElementBytes() {
    java.lang.Object ref = element_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      element_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (java.lang.Double.doubleToRawLongBits(quantity_) != 0) {
      output.writeDouble(1, quantity_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(element_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, element_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (java.lang.Double.doubleToRawLongBits(quantity_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(1, quantity_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(element_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, element_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.example.Spring.protos.SellRequestDto)) {
      return super.equals(obj);
    }
    com.example.Spring.protos.SellRequestDto other = (com.example.Spring.protos.SellRequestDto) obj;

    if (java.lang.Double.doubleToLongBits(getQuantity())
        != java.lang.Double.doubleToLongBits(
            other.getQuantity())) return false;
    if (!getElement()
        .equals(other.getElement())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + QUANTITY_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getQuantity()));
    hash = (37 * hash) + ELEMENT_FIELD_NUMBER;
    hash = (53 * hash) + getElement().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.example.Spring.protos.SellRequestDto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.Spring.protos.SellRequestDto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.Spring.protos.SellRequestDto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.Spring.protos.SellRequestDto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.Spring.protos.SellRequestDto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.Spring.protos.SellRequestDto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.Spring.protos.SellRequestDto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.Spring.protos.SellRequestDto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.example.Spring.protos.SellRequestDto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.example.Spring.protos.SellRequestDto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.Spring.protos.SellRequestDto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.Spring.protos.SellRequestDto parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.example.Spring.protos.SellRequestDto prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.example.Spring.Project.SellRequestDto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.example.Spring.Project.SellRequestDto)
      com.example.Spring.protos.SellRequestDtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.example.Spring.protos.UserTransactionDto.internal_static_com_example_Spring_Project_SellRequestDto_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.example.Spring.protos.UserTransactionDto.internal_static_com_example_Spring_Project_SellRequestDto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.example.Spring.protos.SellRequestDto.class, com.example.Spring.protos.SellRequestDto.Builder.class);
    }

    // Construct using com.example.Spring.protos.SellRequestDto.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      quantity_ = 0D;
      element_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.example.Spring.protos.UserTransactionDto.internal_static_com_example_Spring_Project_SellRequestDto_descriptor;
    }

    @java.lang.Override
    public com.example.Spring.protos.SellRequestDto getDefaultInstanceForType() {
      return com.example.Spring.protos.SellRequestDto.getDefaultInstance();
    }

    @java.lang.Override
    public com.example.Spring.protos.SellRequestDto build() {
      com.example.Spring.protos.SellRequestDto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.example.Spring.protos.SellRequestDto buildPartial() {
      com.example.Spring.protos.SellRequestDto result = new com.example.Spring.protos.SellRequestDto(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.example.Spring.protos.SellRequestDto result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.quantity_ = quantity_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.element_ = element_;
      }
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.example.Spring.protos.SellRequestDto) {
        return mergeFrom((com.example.Spring.protos.SellRequestDto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.example.Spring.protos.SellRequestDto other) {
      if (other == com.example.Spring.protos.SellRequestDto.getDefaultInstance()) return this;
      if (other.getQuantity() != 0D) {
        setQuantity(other.getQuantity());
      }
      if (!other.getElement().isEmpty()) {
        element_ = other.element_;
        bitField0_ |= 0x00000002;
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 9: {
              quantity_ = input.readDouble();
              bitField0_ |= 0x00000001;
              break;
            } // case 9
            case 18: {
              element_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private double quantity_ ;
    /**
     * <code>double quantity = 1;</code>
     * @return The quantity.
     */
    @java.lang.Override
    public double getQuantity() {
      return quantity_;
    }
    /**
     * <code>double quantity = 1;</code>
     * @param value The quantity to set.
     * @return This builder for chaining.
     */
    public Builder setQuantity(double value) {

      quantity_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>double quantity = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearQuantity() {
      bitField0_ = (bitField0_ & ~0x00000001);
      quantity_ = 0D;
      onChanged();
      return this;
    }

    private java.lang.Object element_ = "";
    /**
     * <code>string element = 2;</code>
     * @return The element.
     */
    public java.lang.String getElement() {
      java.lang.Object ref = element_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        element_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string element = 2;</code>
     * @return The bytes for element.
     */
    public com.google.protobuf.ByteString
        getElementBytes() {
      java.lang.Object ref = element_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        element_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string element = 2;</code>
     * @param value The element to set.
     * @return This builder for chaining.
     */
    public Builder setElement(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      element_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>string element = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearElement() {
      element_ = getDefaultInstance().getElement();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>string element = 2;</code>
     * @param value The bytes for element to set.
     * @return This builder for chaining.
     */
    public Builder setElementBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      element_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.example.Spring.Project.SellRequestDto)
  }

  // @@protoc_insertion_point(class_scope:com.example.Spring.Project.SellRequestDto)
  private static final com.example.Spring.protos.SellRequestDto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.example.Spring.protos.SellRequestDto();
  }

  public static com.example.Spring.protos.SellRequestDto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SellRequestDto>
      PARSER = new com.google.protobuf.AbstractParser<SellRequestDto>() {
    @java.lang.Override
    public SellRequestDto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<SellRequestDto> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SellRequestDto> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.example.Spring.protos.SellRequestDto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

