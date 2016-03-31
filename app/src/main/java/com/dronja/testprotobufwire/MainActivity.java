package com.dronja.testprotobufwire;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import com.squareup.wire.Wire;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import okio.ByteString;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      /*  final Person.PhoneNumber number = new Person.PhoneNumber.Builder()
                .number("0637195509")
                .type(Person.PhoneType.MOBILE)
                .build();

        Person person = new Person.Builder()
                .name("Vova")
                .id(1)
                .email("dr@i.ua")
                .build();
        byte[] personByte = Person.ADAPTER.encode(person);
        Log.d("myLog", "encode " + Base64.encodeToString(personByte, Base64.DEFAULT));
try {
    Person oneMan = Person.ADAPTER.decode(personByte);
    Log.d("myLog","name "+oneMan.name);
    Log.d("myLog","id "+String.valueOf(oneMan.id));
}catch (IOException e){
    Log.e("myLog", e.getLocalizedMessage());
}
*/

       csmpMsgCommitProto.Corpus corpus = csmpMsgCommitProto.Corpus.fromValue(2);
        byte[] b = {'1','2','3','4','5','6','7','8'};
       csmpMsgCommitProto csmpMsgCommitProto = new csmpMsgCommitProto.Builder()
               .corpus(corpus)
               .HpkiProto(ByteString.of(b, 0, 8))
               .HcsProto(ByteString.of(new byte[8], 0, 8))
               .build();

            GenericMessage genericMessage = new GenericMessage.Builder()
                    .message_id("123")
                    .commitProto(csmpMsgCommitProto)
                    .build();
        byte[] message = GenericMessage.ADAPTER.encode(genericMessage);
        Log.d("myLog", Base64.encodeToString(message,Base64.DEFAULT));

        try {
            GenericMessage message1 = GenericMessage.ADAPTER.decode(message);
            byte[] gf = message1.commitProto.HpkiProto.toByteArray();
            Log.d("myLog", new String(gf));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
