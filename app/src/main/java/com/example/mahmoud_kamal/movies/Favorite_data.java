package com.example.mahmoud_kamal.movies;

import android.content.Context;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Mahmoud_Kamal on 4/19/2016.
 */
public class Favorite_data {
    Realm realm;
    RealmResults<MovieInfo> realmResults;
    Context context;

    public Favorite_data(Context context) {
        realm = Realm.getInstance(context);
        this.context = context;
    }

    public void insert(long id, String poster, String title) {
        realm.beginTransaction();
        MovieInfo object = new MovieInfo(id, poster, title);
        realm.copyToRealm(object);
        realm.commitTransaction();
    }

    public ArrayList<MovieInfo> retrive() {
        if (realm == null) {
            realm = Realm.getInstance(context);
        }
        ArrayList<MovieInfo> mydata = new ArrayList<>();

        realmResults = realm.where(MovieInfo.class).findAll();
        for (int i = 0; i < realmResults.size(); i++) {
            mydata.add(realmResults.get(i));
        }
        return mydata;
    }

    public boolean retrivebyID(long id) {
        if (realm == null) {
            realm = Realm.getInstance(context);
        }

        realmResults = realm.where(MovieInfo.class).equalTo("id", id).findAll();
        if (realmResults != null & !realmResults.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
