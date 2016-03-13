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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Person.PhoneNumber number = new Person.PhoneNumber.Builder()
                .number("0637195509")
                .type(Person.PhoneType.MOBILE)
                .build();
        List<Person.PhoneNumber> phoneNumbers = new List<Person.PhoneNumber>() {
            @Override
            public void add(int location, Person.PhoneNumber object) {
                this.add(number);
            }

            @Override
            public boolean add(Person.PhoneNumber object) {
                return true;
            }

            @Override
            public boolean addAll(int location, Collection<? extends Person.PhoneNumber> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Person.PhoneNumber> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean contains(Object object) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public Person.PhoneNumber get(int location) {
                return null;
            }

            @Override
            public int indexOf(Object object) {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @NonNull
            @Override
            public Iterator<Person.PhoneNumber> iterator() {
                return null;
            }

            @Override
            public int lastIndexOf(Object object) {
                return 0;
            }

            @Override
            public ListIterator<Person.PhoneNumber> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<Person.PhoneNumber> listIterator(int location) {
                return null;
            }

            @Override
            public Person.PhoneNumber remove(int location) {
                return null;
            }

            @Override
            public boolean remove(Object object) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public Person.PhoneNumber set(int location, Person.PhoneNumber object) {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @NonNull
            @Override
            public List<Person.PhoneNumber> subList(int start, int end) {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(T[] array) {
                return null;
            }
        };
        Person person = new Person.Builder()
                .name("Vova")
                .id(1)
                .email("dr@i.ua")
                .phone(phoneNumbers)
                .build();
        byte[] personByte = Person.ADAPTER.encode(person);
        Log.d("myLog","encode "+ Base64.encodeToString(personByte,Base64.DEFAULT));
try {
    Person oneMan = Person.ADAPTER.decode(personByte);
    Log.d("myLog","name "+oneMan.name);
    Log.d("myLog","id "+String.valueOf(oneMan.id));
}catch (IOException e){
    Log.e("myLog", e.getLocalizedMessage());
}

    }
}
