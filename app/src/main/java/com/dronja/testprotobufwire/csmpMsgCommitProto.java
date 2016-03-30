// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: message.proto at 27:1
package com.dronja.testprotobufwire;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import okio.ByteString;

public final class csmpMsgCommitProto extends Message<csmpMsgCommitProto, csmpMsgCommitProto.Builder> {
  public static final ProtoAdapter<csmpMsgCommitProto> ADAPTER = new ProtoAdapter_csmpMsgCommitProto();

  private static final long serialVersionUID = 0L;

  public static final Corpus DEFAULT_CORPUS = Corpus.nullValue;

  public static final ByteString DEFAULT_HPKIPROTO = ByteString.EMPTY;

  public static final ByteString DEFAULT_HCSPROTO = ByteString.EMPTY;

  @WireField(
      tag = 1,
      adapter = "com.dronja.testprotobufwire.csmpMsgCommitProto$Corpus#ADAPTER"
  )
  public final Corpus corpus;

  @WireField(
      tag = 2,
      adapter = "com.squareup.wire.ProtoAdapter#BYTES"
  )
  public final ByteString HpkiProto;

  @WireField(
      tag = 3,
      adapter = "com.squareup.wire.ProtoAdapter#BYTES"
  )
  public final ByteString HcsProto;

  public csmpMsgCommitProto(Corpus corpus, ByteString HpkiProto, ByteString HcsProto) {
    this(corpus, HpkiProto, HcsProto, ByteString.EMPTY);
  }

  public csmpMsgCommitProto(Corpus corpus, ByteString HpkiProto, ByteString HcsProto, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.corpus = corpus;
    this.HpkiProto = HpkiProto;
    this.HcsProto = HcsProto;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.corpus = corpus;
    builder.HpkiProto = HpkiProto;
    builder.HcsProto = HcsProto;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof csmpMsgCommitProto)) return false;
    csmpMsgCommitProto o = (csmpMsgCommitProto) other;
    return Internal.equals(unknownFields(), o.unknownFields())
        && Internal.equals(corpus, o.corpus)
        && Internal.equals(HpkiProto, o.HpkiProto)
        && Internal.equals(HcsProto, o.HcsProto);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (corpus != null ? corpus.hashCode() : 0);
      result = result * 37 + (HpkiProto != null ? HpkiProto.hashCode() : 0);
      result = result * 37 + (HcsProto != null ? HcsProto.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (corpus != null) builder.append(", corpus=").append(corpus);
    if (HpkiProto != null) builder.append(", HpkiProto=").append(HpkiProto);
    if (HcsProto != null) builder.append(", HcsProto=").append(HcsProto);
    return builder.replace(0, 2, "csmpMsgCommitProto{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<csmpMsgCommitProto, Builder> {
    public Corpus corpus;

    public ByteString HpkiProto;

    public ByteString HcsProto;

    public Builder() {
    }

    public Builder corpus(Corpus corpus) {
      this.corpus = corpus;
      return this;
    }

    public Builder HpkiProto(ByteString HpkiProto) {
      this.HpkiProto = HpkiProto;
      return this;
    }

    public Builder HcsProto(ByteString HcsProto) {
      this.HcsProto = HcsProto;
      return this;
    }

    @Override
    public csmpMsgCommitProto build() {
      return new csmpMsgCommitProto(corpus, HpkiProto, HcsProto, buildUnknownFields());
    }
  }

  public enum Corpus implements WireEnum {
    nullValue(0),

    csmpVersionProtcol(1);

    public static final ProtoAdapter<Corpus> ADAPTER = ProtoAdapter.newEnumAdapter(Corpus.class);

    private final int value;

    Corpus(int value) {
      this.value = value;
    }

    /**
     * Return the constant for {@code value} or null.
     */
    public static Corpus fromValue(int value) {
      switch (value) {
        case 0: return nullValue;
        case 1: return csmpVersionProtcol;
        default: return null;
      }
    }

    @Override
    public int getValue() {
      return value;
    }
  }

  private static final class ProtoAdapter_csmpMsgCommitProto extends ProtoAdapter<csmpMsgCommitProto> {
    ProtoAdapter_csmpMsgCommitProto() {
      super(FieldEncoding.LENGTH_DELIMITED, csmpMsgCommitProto.class);
    }

    @Override
    public int encodedSize(csmpMsgCommitProto value) {
      return (value.corpus != null ? Corpus.ADAPTER.encodedSizeWithTag(1, value.corpus) : 0)
          + (value.HpkiProto != null ? ProtoAdapter.BYTES.encodedSizeWithTag(2, value.HpkiProto) : 0)
          + (value.HcsProto != null ? ProtoAdapter.BYTES.encodedSizeWithTag(3, value.HcsProto) : 0)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, csmpMsgCommitProto value) throws IOException {
      if (value.corpus != null) Corpus.ADAPTER.encodeWithTag(writer, 1, value.corpus);
      if (value.HpkiProto != null) ProtoAdapter.BYTES.encodeWithTag(writer, 2, value.HpkiProto);
      if (value.HcsProto != null) ProtoAdapter.BYTES.encodeWithTag(writer, 3, value.HcsProto);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public csmpMsgCommitProto decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: {
            try {
              builder.corpus(Corpus.ADAPTER.decode(reader));
            } catch (ProtoAdapter.EnumConstantNotFoundException e) {
              builder.addUnknownField(tag, FieldEncoding.VARINT, (long) e.value);
            }
            break;
          }
          case 2: builder.HpkiProto(ProtoAdapter.BYTES.decode(reader)); break;
          case 3: builder.HcsProto(ProtoAdapter.BYTES.decode(reader)); break;
          default: {
            FieldEncoding fieldEncoding = reader.peekFieldEncoding();
            Object value = fieldEncoding.rawProtoAdapter().decode(reader);
            builder.addUnknownField(tag, fieldEncoding, value);
          }
        }
      }
      reader.endMessage(token);
      return builder.build();
    }

    @Override
    public csmpMsgCommitProto redact(csmpMsgCommitProto value) {
      Builder builder = value.newBuilder();
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}